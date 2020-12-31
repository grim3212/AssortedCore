package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.api.AssortedCoreAPI;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class GrindingMillToolSlot extends Slot {

	public GrindingMillToolSlot(IInventory forgeInventory, int id, int x, int y) {
		super(forgeInventory, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return AssortedCoreAPI.allowedInGrindingMillToolSlot(stack);
	}

}
