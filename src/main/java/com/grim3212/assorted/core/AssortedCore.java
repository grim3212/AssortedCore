package com.grim3212.assorted.core;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grim3212.assorted.core.client.data.CoreBlockstateProvider;
import com.grim3212.assorted.core.client.data.CoreItemModelProvider;
import com.grim3212.assorted.core.client.proxy.ClientProxy;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.block.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.creative.CoreCreativeTab;
import com.grim3212.assorted.core.common.data.CoreBlockTagProvider;
import com.grim3212.assorted.core.common.data.CoreFeatureProvider;
import com.grim3212.assorted.core.common.data.CoreItemTagProvider;
import com.grim3212.assorted.core.common.data.CoreLootProvider;
import com.grim3212.assorted.core.common.data.CoreLootProvider.BlockTables;
import com.grim3212.assorted.core.common.data.CoreRecipes;
import com.grim3212.assorted.core.common.handler.CoreConfig;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.proxy.IProxy;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AssortedCore.MODID)
public class AssortedCore {
	public static final String MODID = "assortedcore";
	public static final String MODNAME = "Assorted Core";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static IProxy proxy = new IProxy() {
	};

	public AssortedCore() {
		DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
		proxy.starting();

		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		modBus.addListener(this::setupClient);
		modBus.addListener(this::gatherData);
		modBus.addListener(CoreCreativeTab::registerTabs);

		CoreBlocks.BLOCKS.register(modBus);
		CoreItems.ITEMS.register(modBus);
		CoreBlockEntityTypes.BLOCK_ENTITIES.register(modBus);
		CoreContainerTypes.CONTAINER_TYPES.register(modBus);
		CoreRecipeTypes.RECIPE_TYPES.register(modBus);
		CoreRecipeSerializers.RECIPE_SERIALIZERS.register(modBus);

		ModLoadingContext.get().registerConfig(Type.COMMON, CoreConfig.COMMON_SPEC);
	}

	private void setupClient(final FMLClientSetupEvent event) {
		MenuScreens.register(CoreContainerTypes.ALLOY_FORGE.get(), AlloyForgeScreen::new);
		MenuScreens.register(CoreContainerTypes.GRINDING_MILL.get(), GrindingMillScreen::new);
	}

	private void gatherData(GatherDataEvent event) {
		DataGenerator datagenerator = event.getGenerator();
		PackOutput packOutput = datagenerator.getPackOutput();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		CoreBlockTagProvider blockTagProvider = new CoreBlockTagProvider(packOutput, lookupProvider, fileHelper);
		datagenerator.addProvider(event.includeServer(), blockTagProvider);
		datagenerator.addProvider(event.includeServer(), new CoreItemTagProvider(packOutput, lookupProvider, blockTagProvider, fileHelper));
		datagenerator.addProvider(event.includeServer(), new CoreLootProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockTables::new, LootContextParamSets.BLOCK))));
		datagenerator.addProvider(event.includeServer(), new CoreRecipes(packOutput));
		datagenerator.addProvider(event.includeServer(), CoreFeatureProvider.datpackEntriesProvider(packOutput, lookupProvider));

		CoreBlockstateProvider blockStatesProvider = new CoreBlockstateProvider(packOutput, fileHelper);
		datagenerator.addProvider(event.includeClient(), blockStatesProvider);
		datagenerator.addProvider(event.includeClient(), new CoreItemModelProvider(packOutput, blockStatesProvider.getExistingFileHelper()));
	}

}
