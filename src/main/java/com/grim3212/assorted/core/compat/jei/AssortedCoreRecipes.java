package com.grim3212.assorted.core.compat.jei;

import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.crafting.RecipeManager;

public final class AssortedCoreRecipes {

	private final RecipeManager recipeManager;

	public AssortedCoreRecipes() {
		ClientWorld world = Minecraft.getInstance().world;
		if (world == null)
			throw new NullPointerException("Minecraft world was null when grabbing Assorted Core Recipes for JEI");
		this.recipeManager = world.getRecipeManager();
	}

}
