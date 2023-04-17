package com.grim3212.assorted.core.compat.jei;

import com.google.common.collect.Lists;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.api.machines.MachineUtil;
import com.grim3212.assorted.lib.platform.Services;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JEIHelpers {

    public static List<ItemStack> grindingMillAcceptedTools = Lists.newArrayList();

    public static void hydrateLists() {
        grindingMillAcceptedTools = Services.PLATFORM.getRegistry(Registries.ITEM).getValues().filter((item) -> MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(item))).map((item) -> new ItemStack(item)).collect(Collectors.toList());
    }

    public static List<List<ItemStack>> getMachineIngredientStacks(MachineIngredient... machineIngredients) {
        List<List<ItemStack>> ingredients = Lists.newArrayList();

        for (MachineIngredient ingredient : machineIngredients) {
            ingredients.add(Arrays.asList(ingredient.getMatchingStacks()));
        }

        return ingredients;
    }

    public static ItemStack getResultItem(Recipe<?> recipe) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null) {
            throw new NullPointerException("level must not be null.");
        }
        RegistryAccess registryAccess = level.registryAccess();
        return recipe.getResultItem(registryAccess);
    }

}
