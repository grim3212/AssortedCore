package com.grim3212.assorted.core.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class AssortedCoreAPI {

	public static boolean allowedInGrindingMill(ItemStack stack) {
		return stack.getItem().getToolTypes(stack).stream().anyMatch((tooltype) -> tooltype == ToolType.PICKAXE) && stack.getHarvestLevel(ToolType.PICKAXE, null, null) >= 2;
	}
}
