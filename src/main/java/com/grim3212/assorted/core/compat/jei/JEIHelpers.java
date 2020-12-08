package com.grim3212.assorted.core.compat.jei;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;

import net.minecraft.item.ItemStack;

public class JEIHelpers {

	public static List<List<ItemStack>> getMachineIngredientStacks(MachineIngredient... machineIngredients) {
		List<List<ItemStack>> ingredients = Lists.newArrayList();

		for (MachineIngredient ingredient : machineIngredients) {
			ingredients.add(Arrays.asList(ingredient.getMatchingStacks()));
		}

		return ingredients;
	}

}
