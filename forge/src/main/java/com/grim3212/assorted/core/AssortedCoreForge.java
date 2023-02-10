package com.grim3212.assorted.core;

import com.grim3212.assorted.core.client.data.CoreBlockstateProvider;
import com.grim3212.assorted.core.client.data.CoreItemModelProvider;
import com.grim3212.assorted.core.client.screen.CoreScreens;
import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import com.grim3212.assorted.core.common.capabilities.MachineBlockContainerWrapper;
import com.grim3212.assorted.core.common.creative.CoreCreativeTab;
import com.grim3212.assorted.core.common.data.*;
import com.grim3212.assorted.core.common.data.CoreLootProvider.BlockTables;
import com.grim3212.assorted.core.common.handler.CoreConfig;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod(Constants.MOD_ID)
public class AssortedCoreForge {
    public AssortedCoreForge() {
        final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        AssortedCoreCommonMod.init();

        modBus.addListener(this::setupClient);
        modBus.addListener(this::gatherData);
        modBus.addListener(CoreCreativeTab::registerTabs);
        forgeBus.addGenericListener(BlockEntity.class, AssortedCoreForge::attachBlockCapabilities);

        ModLoadingContext.get().registerConfig(Type.COMMON, CoreConfig.COMMON_SPEC);
    }

    public static void attachBlockCapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof BaseMachineBlockEntity machineBlock) {
            event.addCapability(new ResourceLocation(Constants.MOD_ID, "item"), new MachineBlockContainerWrapper(machineBlock));
        }
    }

    private void setupClient(final FMLClientSetupEvent event) {
        CoreScreens.init();
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
