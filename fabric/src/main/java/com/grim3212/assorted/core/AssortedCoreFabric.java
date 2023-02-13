package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import com.grim3212.assorted.core.config.CoreConfig;
import com.grim3212.assorted.core.events.AssortedCoreCreativeTab;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.impl.transfer.item.InventoryStorageImpl;

public class AssortedCoreFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CoreConfig.setup();

        AssortedCoreCommonMod.init();
        AssortedCoreCreativeTab.init();

        ItemStorage.SIDED.registerFallback((world, pos, state, blockEntity, context) -> {
            if (blockEntity instanceof BaseMachineBlockEntity machineBlock) {
                return InventoryStorageImpl.of(machineBlock, context);
            }
            return null;
        });
    }
}
