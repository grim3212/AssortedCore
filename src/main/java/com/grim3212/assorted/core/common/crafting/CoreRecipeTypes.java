package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.item.crafting.IRecipeType;

public class CoreRecipeTypes {

	public static IRecipeType<AlloyForgeRecipe> ALLOY_FORGE = IRecipeType.register(prefix("alloy_forge"));

	private static String prefix(String s) {
		return AssortedCore.MODID + ":" + s;
	}

}
