package com.grim3212.assorted.core.api;

import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolActions;

public class AssortedCoreAPI {

	public static boolean allowedInGrindingMillToolSlot(ItemStack stack) {
		if (stack.is(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS))
			return true;

		if (stack.getItem() instanceof TieredItem itemTier) {
			if (stack.getItem().canPerformAction(stack, ToolActions.PICKAXE_DIG)) {
				if (TierSortingRegistry.isTierSorted(itemTier.getTier())) {
					// Iron is our benchmark so the tools should be greater than iron at least
					return TierSortingRegistry.getTiersLowerThan(itemTier.getTier()).contains(Tiers.IRON);
				} else {
					// Fallback to old method of determining if a pick is the correct level
					return itemTier.getTier().getLevel() >= 2;
				}
			}
		}
		return false;
	}

	public static boolean isValidAlloyForgeInput(RecipeManager manager, ItemStack stack) {
		return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.ALLOY_FORGE.get()).stream().anyMatch((recipe) -> recipe.validItem(stack));
	}

	public static boolean isValidGrindingMillInput(RecipeManager manager, ItemStack stack) {
		return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.GRINDING_MILL.get()).stream().anyMatch((recipe) -> recipe.validItem(stack));
	}
}
