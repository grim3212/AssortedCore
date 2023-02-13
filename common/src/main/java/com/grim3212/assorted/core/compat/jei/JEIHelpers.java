package com.grim3212.assorted.core.compat.jei;

import com.google.common.collect.Lists;
import com.grim3212.assorted.core.CoreServices;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.lib.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JEIHelpers {

    public static List<ItemStack> grindingMillAcceptedTools = Lists.newArrayList();

    public static void hydrateLists() {
        grindingMillAcceptedTools = Services.PLATFORM.getRegistry(Registries.ITEM).getValues().filter((item) -> CoreServices.MACHINES.allowedInGrindingMillToolSlot(new ItemStack(item))).map((item) -> new ItemStack(item)).collect(Collectors.toList());
    }

    public static List<List<ItemStack>> getMachineIngredientStacks(MachineIngredient... machineIngredients) {
        List<List<ItemStack>> ingredients = Lists.newArrayList();

        for (MachineIngredient ingredient : machineIngredients) {
            ingredients.add(Arrays.asList(ingredient.getMatchingStacks()));
        }

        return ingredients;
    }

}
