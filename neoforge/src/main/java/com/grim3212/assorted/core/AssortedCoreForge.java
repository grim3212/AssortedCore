package com.grim3212.assorted.core;

import com.grim3212.assorted.core.client.data.CoreLanguageProvider;
import com.grim3212.assorted.core.client.data.CoreBlockstateProvider;
import com.grim3212.assorted.core.client.data.CoreItemModelProvider;
import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.data.*;
import com.grim3212.assorted.lib.data.ForgeBlockTagProvider;
import com.grim3212.assorted.lib.data.ForgeItemTagProvider;
import com.grim3212.assorted.lib.data.ForgeDatapackRegistryProvider;
import com.grim3212.assorted.lib.inventory.ForgePlatformInventoryStorageHandlerSided;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod(Constants.MOD_ID)
public class AssortedCoreForge {

    /**
     * {@code FMLJavaModLoadingContext} is gone; the mod event bus and the mod container are injected
     * into the {@code @Mod} constructor instead.
     */
    public AssortedCoreForge(IEventBus modBus, ModContainer modContainer) {
        modBus.addListener(this::gatherServerData);
        modBus.addListener(this::gatherClientData);
        modBus.addListener(this::registerCapabilities);

        NeoForge.EVENT_BUS.addListener(this::onDatapackSync);

        CoreCommonMod.init();
    }

    /**
     * Vanilla stopped sending recipes to the client in 1.21.2 - only recipe property sets and
     * stonecutter recipes go over now - so a recipe type whose recipes are needed client side has to
     * opt in. {@code sendRecipes} is NeoForge's mechanism for that; the client picks them up in
     * {@code AssortedCoreForgeClient} from {@code RecipesReceivedEvent}.
     * <p>
     * The event fires for a joining player and again for everyone after {@code /reload}, and this
     * listener is deliberately on the common {@code @Mod} class so it is registered on both physical
     * sides, as NeoForge's docs require.
     */
    private void onDatapackSync(final OnDatapackSyncEvent event) {
        event.sendRecipes(CoreRecipeTypes.ALLOY_FORGE.get(), CoreRecipeTypes.GRINDING_MILL.get());
    }

    /**
     * {@code ExistingFileHelper} was removed from datagen, the event owns the provider list now
     * ({@code addProvider}), and the include flags are gone because the server and client halves are
     * separate events.
     */
    private void gatherServerData(final GatherDataEvent.Server event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Recipe providers are not data providers any more - the Runner owns the output.
        event.addProvider(new CoreRecipes.Runner(packOutput, lookupProvider));
        ForgeBlockTagProvider blockTagProvider = event.addProvider(new ForgeBlockTagProvider(packOutput, lookupProvider, Constants.MOD_ID, new CoreBlockTagProvider(packOutput, lookupProvider)));
        event.addProvider(new ForgeItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), Constants.MOD_ID, new CoreItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter())));
        event.addProvider(new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(CoreBlockLoot::new, LootContextParamSets.BLOCK)), lookupProvider));
        event.addProvider(new ForgeDatapackRegistryProvider(Constants.MOD_ID, new CoreWorldGenData()).datpackEntriesProvider(packOutput, lookupProvider));
    }

    private void gatherClientData(final GatherDataEvent.Client event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();

        event.addProvider(new CoreBlockstateProvider(packOutput));
        event.addProvider(new CoreItemModelProvider(packOutput));
        event.addProvider(new CoreLanguageProvider(packOutput));
    }

    /**
     * This used to be a mixin on {@code BaseMachineBlockEntity} overriding {@code getCapability}.
     * Block entities do not answer capability lookups themselves any more - a capability is
     * registered per {@link BlockEntityType} from {@link RegisterCapabilitiesEvent} - so the mixin
     * was deleted and the registration lives here, mirroring what the Fabric side does with
     * {@code ItemStorage.SIDED}.
     */
    private void registerCapabilities(final RegisterCapabilitiesEvent event) {
        registerMachineItemHandler(event, CoreBlockEntityTypes.BASIC_ALLOY_FORGE);
        registerMachineItemHandler(event, CoreBlockEntityTypes.INTERMEDIATE_ALLOY_FORGE);
        registerMachineItemHandler(event, CoreBlockEntityTypes.ADVANCED_ALLOY_FORGE);
        registerMachineItemHandler(event, CoreBlockEntityTypes.EXPERT_ALLOY_FORGE);

        registerMachineItemHandler(event, CoreBlockEntityTypes.BASIC_GRINDING_MILL);
        registerMachineItemHandler(event, CoreBlockEntityTypes.INTERMEDIATE_GRINDING_MILL);
        registerMachineItemHandler(event, CoreBlockEntityTypes.ADVANCED_GRINDING_MILL);
        registerMachineItemHandler(event, CoreBlockEntityTypes.EXPERT_GRINDING_MILL);
    }

    /**
     * {@code ForgeCapabilities.ITEM_HANDLER} and the deprecated {@code IItemHandler} it was typed
     * with are replaced by {@code Capabilities.Item.BLOCK}, a transactional
     * {@code ResourceHandler<ItemResource>}; the library's sided handler already exposes one.
     */
    private static <BE extends BaseMachineBlockEntity> void registerMachineItemHandler(RegisterCapabilitiesEvent event, IRegistryObject<BlockEntityType<BE>> type) {
        event.registerBlockEntity(Capabilities.Item.BLOCK, type.get(), (blockEntity, side) -> {
            if (blockEntity.isRemoved()) {
                return null;
            }
            return ((ForgePlatformInventoryStorageHandlerSided) blockEntity.getStorageHandler()).getCapability(side);
        });
    }

}
