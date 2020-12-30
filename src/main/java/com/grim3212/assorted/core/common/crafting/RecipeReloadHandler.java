package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import net.minecraft.item.crafting.RecipeManager;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RecipeReloadHandler {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onRecipesUpdated(RecipesUpdatedEvent event) {
		RecipeManager manager = event.getRecipeManager();

		AlloyForgeRecipe.recipes = manager.getRecipesForType(CoreRecipeTypes.ALLOY_FORGE);
		GrindingMillRecipe.recipes = manager.getRecipesForType(CoreRecipeTypes.GRINDING_MILL);
	}
}
