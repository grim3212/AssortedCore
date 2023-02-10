package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.platform.Services;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MachineFuelSlot extends Slot {

    public MachineFuelSlot(Container forgeInventory, int id, int x, int y) {
        super(forgeInventory, id, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return Services.PLATFORM.getFuelTime(stack, null) > 0;
    }
}
