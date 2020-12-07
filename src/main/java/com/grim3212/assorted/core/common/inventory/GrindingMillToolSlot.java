package com.grim3212.assorted.core.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class GrindingMillToolSlot extends Slot {

	public GrindingMillToolSlot(IInventory forgeInventory, int id, int x, int y) {
		super(forgeInventory, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return validTool(stack);
	}

	public static boolean validTool(ItemStack stack) {
		return stack.getItem().getToolTypes(stack).stream().anyMatch((tooltype) -> tooltype == ToolType.PICKAXE) && stack.getHarvestLevel(ToolType.PICKAXE, null, null) >= 2;
	}
}
