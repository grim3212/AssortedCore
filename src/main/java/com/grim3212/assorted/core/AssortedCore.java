package com.grim3212.assorted.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grim3212.assorted.core.client.data.CoreBlockstateProvider;
import com.grim3212.assorted.core.client.data.CoreItemModelProvider;
import com.grim3212.assorted.core.client.proxy.ClientProxy;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.block.tileentity.CoreTileEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.data.CoreBlockTagProvider;
import com.grim3212.assorted.core.common.data.CoreItemTagProvider;
import com.grim3212.assorted.core.common.data.CoreLootProvider;
import com.grim3212.assorted.core.common.data.CoreRecipes;
import com.grim3212.assorted.core.common.gen.CoreWorldGeneration;
import com.grim3212.assorted.core.common.gen.feature.CoreConfiguredFeatures;
import com.grim3212.assorted.core.common.handler.CoreConfig;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.proxy.IProxy;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AssortedCore.MODID)
public class AssortedCore {
	public static final String MODID = "assortedcore";
	public static final String MODNAME = "Assorted Core";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static IProxy proxy = new IProxy() {
	};

	public static final ItemGroup ASSORTED_CORE_ITEM_GROUP = (new ItemGroup(AssortedCore.MODID) {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(CoreBlocks.PLATINUM_ORE.get());
		}
	});

	public AssortedCore() {
		DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
		proxy.starting();

		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		modBus.addListener(this::setup);
		modBus.addListener(this::setupClient);
		modBus.addListener(this::gatherData);

		CoreBlocks.BLOCKS.register(modBus);
		CoreItems.ITEMS.register(modBus);
		CoreTileEntityTypes.TILE_ENTITIES.register(modBus);
		CoreContainerTypes.CONTAINER_TYPES.register(modBus);
		CoreRecipeSerializers.RECIPE_SERIALIZERS.register(modBus);

		ModLoadingContext.get().registerConfig(Type.COMMON, CoreConfig.COMMON_SPEC);

		MinecraftForge.EVENT_BUS.register(new CoreWorldGeneration());
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CoreConfiguredFeatures.registerConfiguredFeatures();
		});
	}

	private void setupClient(final FMLClientSetupEvent event) {
		ScreenManager.register(CoreContainerTypes.ALLOY_FORGE.get(), AlloyForgeScreen::new);
		ScreenManager.register(CoreContainerTypes.GRINDING_MILL.get(), GrindingMillScreen::new);
	}

	private void gatherData(GatherDataEvent event) {
		DataGenerator datagenerator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			CoreBlockTagProvider blockTagProvider = new CoreBlockTagProvider(datagenerator, fileHelper);
			datagenerator.addProvider(blockTagProvider);
			datagenerator.addProvider(new CoreItemTagProvider(datagenerator, blockTagProvider, fileHelper));
			datagenerator.addProvider(new CoreLootProvider(datagenerator));
			datagenerator.addProvider(new CoreRecipes(datagenerator));
		}

		if (event.includeClient()) {
			CoreBlockstateProvider blockStatesProvider = new CoreBlockstateProvider(datagenerator, fileHelper);
			datagenerator.addProvider(blockStatesProvider);
			datagenerator.addProvider(new CoreItemModelProvider(datagenerator, blockStatesProvider.getExistingFileHelper()));
		}
	}
}
