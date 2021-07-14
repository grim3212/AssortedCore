package com.grim3212.assorted.core.api;

import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraftforge.common.ToolType;

public class AssortedCoreAPI {

	public static boolean allowedInGrindingMillToolSlot(ItemStack stack) {
		return stack.getItem().getToolTypes(stack).stream().anyMatch((tooltype) -> tooltype == ToolType.PICKAXE) && stack.getHarvestLevel(ToolType.PICKAXE, null, null) >= 2;
	}

	public static boolean isValidAlloyForgeInput(RecipeManager manager, ItemStack stack) {
		return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.ALLOY_FORGE).stream().anyMatch((recipe) -> recipe.validItem(stack));
	}

	public static boolean isValidGrindingMillInput(RecipeManager manager, ItemStack stack) {
		return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.GRINDING_MILL).stream().anyMatch((recipe) -> recipe.validItem(stack));
	}
}
