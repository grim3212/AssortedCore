package com.grim3212.assorted.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonElement;
import com.grim3212.assorted.core.client.data.CoreBlockstateProvider;
import com.grim3212.assorted.core.client.data.CoreItemModelProvider;
import com.grim3212.assorted.core.client.proxy.ClientProxy;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.block.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.data.CoreBlockTagProvider;
import com.grim3212.assorted.core.common.data.CoreItemTagProvider;
import com.grim3212.assorted.core.common.data.CoreLootProvider;
import com.grim3212.assorted.core.common.data.CoreRecipes;
import com.grim3212.assorted.core.common.gen.CoreWorldGeneration;
import com.grim3212.assorted.core.common.handler.CoreConfig;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.proxy.IProxy;
import com.mojang.serialization.JsonOps;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(AssortedCore.MODID)
public class AssortedCore {
	public static final String MODID = "assortedcore";
	public static final String MODNAME = "Assorted Core";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static IProxy proxy = new IProxy() {
	};

	public static final CreativeModeTab ASSORTED_CORE_ITEM_GROUP = (new CreativeModeTab(AssortedCore.MODID) {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(CoreBlocks.PLATINUM_ORE.get());
		}
	});

	public AssortedCore() {
		DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
		proxy.starting();

		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		modBus.addListener(this::setupClient);
		modBus.addListener(this::gatherData);

		CoreBlocks.BLOCKS.register(modBus);
		CoreItems.ITEMS.register(modBus);
		CoreBlockEntityTypes.BLOCK_ENTITIES.register(modBus);
		CoreContainerTypes.CONTAINER_TYPES.register(modBus);
		CoreRecipeTypes.RECIPE_TYPES.register(modBus);
		CoreRecipeSerializers.RECIPE_SERIALIZERS.register(modBus);
		CoreWorldGeneration.CONFIGURED_FEATURES.register(modBus);
		CoreWorldGeneration.PLACED_FEATURES.register(modBus);

		ModLoadingContext.get().registerConfig(Type.COMMON, CoreConfig.COMMON_SPEC);

		MinecraftForge.EVENT_BUS.register(new CoreWorldGeneration());
	}

	private void setupClient(final FMLClientSetupEvent event) {
		MenuScreens.register(CoreContainerTypes.ALLOY_FORGE.get(), AlloyForgeScreen::new);
		MenuScreens.register(CoreContainerTypes.GRINDING_MILL.get(), GrindingMillScreen::new);
	}

	private void gatherData(GatherDataEvent event) {
		DataGenerator datagenerator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		CoreBlockTagProvider blockTagProvider = new CoreBlockTagProvider(datagenerator, fileHelper);
		datagenerator.addProvider(event.includeServer(), blockTagProvider);
		datagenerator.addProvider(event.includeServer(), new CoreItemTagProvider(datagenerator, blockTagProvider, fileHelper));
		datagenerator.addProvider(event.includeServer(), new CoreLootProvider(datagenerator));
		datagenerator.addProvider(event.includeServer(), new CoreRecipes(datagenerator));

		final RegistryAccess registries = RegistryAccess.builtinCopy();
		final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, registries);

		final DataProvider configuredFeatureProvider = JsonCodecProvider.forDatapackRegistry(datagenerator, fileHelper, AssortedCore.MODID, ops, Registry.CONFIGURED_FEATURE_REGISTRY, getConfiguredFeatures(registries));
		datagenerator.addProvider(event.includeServer(), configuredFeatureProvider);

		final DataProvider placedFeatureProvider = JsonCodecProvider.forDatapackRegistry(datagenerator, fileHelper, AssortedCore.MODID, ops, Registry.PLACED_FEATURE_REGISTRY, getPlacedFeatures(registries));
		datagenerator.addProvider(event.includeServer(), placedFeatureProvider);

		final HolderSet.Named<Biome> overworldTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_OVERWORLD);
		final BiomeModifier addOres = new AddFeaturesBiomeModifier(overworldTag, getPlacedFeaturesForBiome(registries), Decoration.UNDERGROUND_ORES);
		final ResourceLocation NAME = new ResourceLocation(AssortedCore.MODID, "add_ores");
		final DataProvider biomeModifierProvider = JsonCodecProvider.forDatapackRegistry(datagenerator, fileHelper, AssortedCore.MODID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS, Map.of(NAME, addOres));
		datagenerator.addProvider(event.includeServer(), biomeModifierProvider);

		CoreBlockstateProvider blockStatesProvider = new CoreBlockstateProvider(datagenerator, fileHelper);
		datagenerator.addProvider(event.includeClient(), blockStatesProvider);
		datagenerator.addProvider(event.includeClient(), new CoreItemModelProvider(datagenerator, blockStatesProvider.getExistingFileHelper()));
	}

	private static Map<ResourceLocation, ConfiguredFeature<?, ?>> getConfiguredFeatures(RegistryAccess registries) {
		Map<ResourceLocation, ConfiguredFeature<?, ?>> map = new HashMap<>();

		CoreWorldGeneration.CONFIGURED_FEATURES.getEntries().forEach((feature) -> {
			Registry<ConfiguredFeature<?, ?>> configuredFeatures = registries.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
			ConfiguredFeature<?, ?> configFeature = configuredFeatures.get(feature.getId());
			map.put(feature.getId(), configFeature);
		});

		return map;
	}

	private static Map<ResourceLocation, PlacedFeature> getPlacedFeatures(RegistryAccess registries) {
		Map<ResourceLocation, PlacedFeature> map = new HashMap<>();

		CoreWorldGeneration.PLACED_FEATURES.getEntries().forEach((feature) -> {
			Registry<PlacedFeature> placedFeatures = registries.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);
			PlacedFeature placedFeature = placedFeatures.get(feature.getId());
			map.put(feature.getId(), placedFeature);
		});

		return map;
	}

	private static HolderSet.Direct<PlacedFeature> getPlacedFeaturesForBiome(RegistryAccess registries) {
		List<Holder<PlacedFeature>> features = Lists.newArrayList();

		CoreWorldGeneration.PLACED_FEATURES.getEntries().forEach((feature) -> {
			Registry<PlacedFeature> placedFeatures = registries.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);
			features.add(placedFeatures.getHolderOrThrow(feature.getKey()));
		});

		return HolderSet.direct(features);
	}
}
