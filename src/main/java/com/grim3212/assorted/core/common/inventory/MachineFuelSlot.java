package com.grim3212.assorted.core.common.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class MachineFuelSlot extends Slot {

	public MachineFuelSlot(Container forgeInventory, int id, int x, int y) {
		super(forgeInventory, id, x, y);
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return ForgeHooks.getBurnTime(stack, null) > 0;
	}
}
