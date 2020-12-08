package com.grim3212.assorted.core.compat.jei;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

public final class AssortedCoreRecipes {

	private final RecipeManager recipeManager;

	public AssortedCoreRecipes() {
		ClientWorld world = Minecraft.getInstance().world;
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
	private static <C extends IInventory, T extends IRecipe<C>> List<T> getRecipes(RecipeManager recipeManager, IRecipeType<T> recipeType) {
		Map<ResourceLocation, IRecipe<C>> recipes = recipeManager.getRecipes(recipeType);
		AssortedCore.LOGGER.info("Found " + recipes.size() + " for recipe type " + recipeType.toString());
		return (List<T>) recipes.values().stream().collect(Collectors.toList());
	}
}
