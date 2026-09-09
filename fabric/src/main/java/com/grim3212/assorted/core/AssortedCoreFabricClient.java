package com.grim3212.assorted.core;

import com.grim3212.assorted.core.client.CoreClient;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.common.crafting.ClientMachineRecipes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.recipe.v1.sync.ClientRecipeSynchronizedEvent;
import net.fabricmc.fabric.api.recipe.v1.sync.SynchronizedRecipes;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

public class AssortedCoreFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CoreClient.init();

        ClientRecipeSynchronizedEvent.EVENT.register((client, recipes) -> onRecipesSynchronized(recipes));

        // The synced recipes belong to the server that sent them.
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> ClientMachineRecipes.clear());
    }

    /**
     * Fabric puts the synced recipes into the client's own {@code RecipeAccess}, so this only
     * mirrors them into the shared cache that the JEI plugin and the machine containers read -
     * keeping the common code identical to the NeoForge side, which has no such access.
     */
    private static void onRecipesSynchronized(SynchronizedRecipes recipes) {
        ClientMachineRecipes.set(recipesOf(recipes, CoreRecipeTypes.ALLOY_FORGE.get()), recipesOf(recipes, CoreRecipeTypes.GRINDING_MILL.get()));
    }

    private static <T extends BaseMachineRecipe> List<T> recipesOf(SynchronizedRecipes recipes, RecipeType<T> recipeType) {
        return recipes.getAllOfType(recipeType).stream().map(RecipeHolder::value).toList();
    }
}
