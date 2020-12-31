package com.grim3212.assorted.core.compat.jei;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.grim3212.assorted.core.api.AssortedCoreAPI;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;

import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class JEIHelpers {

	public static List<ItemStack> grindingMillAcceptedTools = Lists.newArrayList();

	public static void hydrateLists() {
		grindingMillAcceptedTools = Registry.ITEM.stream().filter((item) -> AssortedCoreAPI.allowedInGrindingMillToolSlot(new ItemStack(item))).map((item) -> new ItemStack(item)).collect(Collectors.toList());
	}

	public static List<List<ItemStack>> getMachineIngredientStacks(MachineIngredient... machineIngredients) {
		List<List<ItemStack>> ingredients = Lists.newArrayList();

		for (MachineIngredient ingredient : machineIngredients) {
			ingredients.add(Arrays.asList(ingredient.getMatchingStacks()));
		}

		return ingredients;
	}

}
