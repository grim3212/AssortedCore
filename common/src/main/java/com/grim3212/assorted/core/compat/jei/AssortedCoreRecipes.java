package com.grim3212.assorted.core.compat.jei;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

public final class AssortedCoreRecipes {

    private final RecipeManager recipeManager;

    public AssortedCoreRecipes() {
        ClientLevel world = Minecraft.getInstance().level;
        if (world == null)
            throw new NullPointerException("Minecraft world was null when grabbing Assorted Core Recipes for JEI");
        this.recipeManager = world.getRecipeManager();
    }

    private static <C extends Container, T extends Recipe<C>> List<T> getRecipes(RecipeManager recipeManager, RecipeType<T> recipeType) {
        return recipeManager.getAllRecipesFor(recipeType).stream().toList();
    }

    public List<AlloyForgeRecipe> getAlloyForgeRecipes() {
        return getRecipes(recipeManager, CoreRecipeTypes.ALLOY_FORGE.get());
    }

    public List<GrindingMillRecipe> getGrindingMillRecipes() {
        return getRecipes(recipeManager, CoreRecipeTypes.GRINDING_MILL.get());
    }
}
