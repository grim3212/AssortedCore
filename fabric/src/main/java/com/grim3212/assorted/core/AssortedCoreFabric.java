package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.lib.core.inventory.IInventoryBlockEntity;
import com.grim3212.assorted.lib.inventory.FabricPlatformInventoryStorageHandlerSided;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;

public class AssortedCoreFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CoreCommonMod.init();


        ItemStorage.SIDED.registerForBlockEntities((be, direction) ->
                {
                    if (be instanceof IInventoryBlockEntity inv)
                        return ((FabricPlatformInventoryStorageHandlerSided) inv.getStorageHandler()).getFabricInventory(direction);
                    return null;
                },
                CoreBlockEntityTypes.BASIC_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.BASIC_GRINDING_MILL.get(),
                CoreBlockEntityTypes.INTERMEDIATE_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.INTERMEDIATE_GRINDING_MILL.get(),
                CoreBlockEntityTypes.ADVANCED_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.ADVANCED_GRINDING_MILL.get(),
                CoreBlockEntityTypes.EXPERT_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.EXPERT_GRINDING_MILL.get()
        );
    }
}
