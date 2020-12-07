package com.grim3212.assorted.core.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class BurnableFuelSlot extends Slot {

	public BurnableFuelSlot(IInventory forgeInventory, int id, int x, int y) {
		super(forgeInventory, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return ForgeHooks.getBurnTime(stack) > 0;
	}
}
