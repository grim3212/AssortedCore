package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import net.minecraft.item.crafting.IRecipeType;

public class CoreRecipeTypes {

	public static IRecipeType<AlloyForgeRecipe> ALLOY_FORGE = IRecipeType.register(prefix("alloy_forge"));
	public static IRecipeType<GrindingMillRecipe> GRINDING_MILL = IRecipeType.register(prefix("grinding_mill"));

	private static String prefix(String s) {
		return AssortedCore.MODID + ":" + s;
	}

}
