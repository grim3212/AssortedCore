package com.grim3212.assorted.core.api;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ToolType;

public class AssortedCoreAPI {

	public static boolean allowedInGrindingMillToolSlot(ItemStack stack) {
		return stack.getItem().getToolTypes(stack).stream().anyMatch((tooltype) -> tooltype == ToolType.PICKAXE) && stack.getHarvestLevel(ToolType.PICKAXE, null, null) >= 2;
	}

	public static boolean isValidAlloyForgeInput(ItemStack stack) {
		return AlloyForgeRecipe.recipes.stream().anyMatch((recipe) -> recipe.validItem(stack));
	}

	public static boolean isValidGrindingMillInput(ItemStack stack) {
		return GrindingMillRecipe.recipes.stream().anyMatch((recipe) -> recipe.validItem(stack));
	}
}
