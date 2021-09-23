package com.grim3212.assorted.core.compat.jei;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

public final class AssortedCoreRecipes {

	private final RecipeManager recipeManager;

	public AssortedCoreRecipes() {
		ClientLevel world = Minecraft.getInstance().level;
		if (world == null)
			throw new NullPointerException("Minecraft world was null when grabbing Assorted Core Recipes for JEI");
		this.recipeManager = world.getRecipeManager();
	}

	public List<AlloyForgeRecipe> getAlloyForgeRecipes() {
		return getRecipes(recipeManager, CoreRecipeTypes.ALLOY_FORGE);
	}

	public List<GrindingMillRecipe> getGrindingMillRecipes() {
		return getRecipes(recipeManager, CoreRecipeTypes.GRINDING_MILL);
	}

	@SuppressWarnings("unchecked")
	private static <C extends Container, T extends Recipe<C>> List<T> getRecipes(RecipeManager recipeManager, RecipeType<T> recipeType) {
		Map<ResourceLocation, Recipe<C>> recipes = recipeManager.byType(recipeType);
		AssortedCore.LOGGER.info("Found " + recipes.size() + " for recipe type " + recipeType.toString());
		return (List<T>) recipes.values().stream().collect(Collectors.toList());
	}
}
