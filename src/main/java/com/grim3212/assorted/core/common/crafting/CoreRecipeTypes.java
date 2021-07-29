package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import net.minecraft.world.item.crafting.RecipeType;

public class CoreRecipeTypes {

	public static RecipeType<AlloyForgeRecipe> ALLOY_FORGE = RecipeType.register(prefix("alloy_forge"));
	public static RecipeType<GrindingMillRecipe> GRINDING_MILL = RecipeType.register(prefix("grinding_mill"));

	private static String prefix(String s) {
		return AssortedCore.MODID + ":" + s;
	}

}
