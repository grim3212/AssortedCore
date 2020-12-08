package com.grim3212.assorted.core.common.crafting;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RecipeReloadListener implements IResourceManagerReloadListener {

	private final DataPackRegistries dataPackRegistries;

	public RecipeReloadListener(DataPackRegistries dataPackRegistries) {
		this.dataPackRegistries = dataPackRegistries;
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		if (dataPackRegistries != null) {
			hydrateRecipes(dataPackRegistries.getRecipeManager());
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void recipesUpdated(RecipesUpdatedEvent event) {
		hydrateRecipes(event.getRecipeManager());
	}

	private void hydrateRecipes(RecipeManager manager) {
		Collection<IRecipe<?>> recipes = manager.getRecipes();

		if (recipes.size() > 0) {
			AlloyForgeRecipe.recipes = getRecipes(recipes, AlloyForgeRecipe.class, CoreRecipeTypes.ALLOY_FORGE);
		}
	}

	private static <T extends IRecipe<?>> Map<ResourceLocation, T> getRecipes(Collection<IRecipe<?>> recipes, Class<T> recipeClass, IRecipeType<T> type) {
		return recipes.stream().filter((recipe) -> recipe.getType() == type).map(recipeClass::cast).collect(Collectors.toMap((recipe) -> recipe.getId(), (recipe) -> recipe));
	}
}
