package com.grim3212.assorted.core.platform.services;

import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

public interface IMachineHelper {

    public boolean allowedInGrindingMillToolSlot(ItemStack stack);

    default boolean isValidAlloyForgeInput(RecipeManager manager, ItemStack stack) {
        return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.ALLOY_FORGE.get()).stream().anyMatch((recipe) -> recipe.validItem(stack));
    }

    default boolean isValidGrindingMillInput(RecipeManager manager, ItemStack stack) {
        return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.GRINDING_MILL.get()).stream().anyMatch((recipe) -> recipe.validItem(stack));
    }
}
