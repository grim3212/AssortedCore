package com.grim3212.assorted.core.client;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.common.crafting.ClientMachineRecipes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;

/**
 * The client-only entry point: a second {@code @Mod} for the same mod id, constructed only on the
 * client.
 */
@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class AssortedCoreForgeClient {

    public AssortedCoreForgeClient(IEventBus modBus, ModContainer modContainer) {
        CoreClient.init();

        // HIGHEST because JEI starts from its own listener on this same event - it waits for the
        // recipe sync before loading plugins - so the cache has to be filled before it runs.
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGHEST, (final RecipesReceivedEvent event) -> onRecipesReceived(event.getRecipeMap()));

        // The synced recipes belong to the server that sent them.
        NeoForge.EVENT_BUS.addListener((final ClientPlayerNetworkEvent.LoggingOut event) -> ClientMachineRecipes.clear());
    }

    /**
     * The recipes the server was asked for in {@code AssortedCoreForge#onDatapackSync}. NeoForge
     * hands over a {@link RecipeMap} and leaves storing it to the mod, so it goes into the shared
     * client cache the JEI plugin and the machine containers read.
     */
    private static void onRecipesReceived(RecipeMap recipeMap) {
        ClientMachineRecipes.set(recipesOf(recipeMap, CoreRecipeTypes.ALLOY_FORGE.get()), recipesOf(recipeMap, CoreRecipeTypes.GRINDING_MILL.get()));
    }

    private static <T extends BaseMachineRecipe> List<T> recipesOf(RecipeMap recipeMap, RecipeType<T> recipeType) {
        return recipeMap.byType(recipeType).stream().map(RecipeHolder::value).toList();
    }
}
