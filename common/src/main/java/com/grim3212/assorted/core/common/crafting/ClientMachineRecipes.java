package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The machine recipes the server has told this client about.
 * <p>
 * 1.21.2 stopped syncing recipes: {@code ClientboundUpdateRecipesPacket} carries only recipe
 * property sets and stonecutter recipes, and the client's {@code RecipeAccess} exposes nothing else,
 * so a recipe type whose recipes are needed client side - by JEI, and by the container's own
 * shift-click check - has to opt in to being sent. Both loaders have their own mechanism for that
 * and each fills this cache from its client entry point: NeoForge from
 * {@code OnDatapackSyncEvent#sendRecipes} plus {@code RecipesReceivedEvent}, Fabric from
 * {@code RecipeSynchronization#synchronizeRecipeSerializer} plus
 * {@code ClientRecipeSynchronizedEvent}. Both fire on login and again after {@code /reload}.
 * <p>
 * The lists are swapped wholesale rather than mutated, so readers can hold on to one and compare it
 * by identity to notice a reload.
 */
public final class ClientMachineRecipes {

    private static final List<Runnable> listeners = new CopyOnWriteArrayList<>();

    private static List<AlloyForgeRecipe> alloyForge = List.of();
    private static List<GrindingMillRecipe> grindingMill = List.of();

    private ClientMachineRecipes() {
    }

    public static void set(List<AlloyForgeRecipe> alloyForgeIn, List<GrindingMillRecipe> grindingMillIn) {
        alloyForge = List.copyOf(alloyForgeIn);
        grindingMill = List.copyOf(grindingMillIn);

        for (Runnable listener : listeners) {
            listener.run();
        }
    }

    /**
     * Dropped on disconnect - these recipes belong to the server that sent them, and the next one
     * may not have the same ones loaded.
     */
    public static void clear() {
        set(List.of(), List.of());
    }

    public static List<AlloyForgeRecipe> alloyForge() {
        return alloyForge;
    }

    public static List<GrindingMillRecipe> grindingMill() {
        return grindingMill;
    }

    /**
     * Runs on the client thread whenever a new set of recipes arrives, including the empty set on
     * disconnect.
     */
    public static void addUpdateListener(Runnable listener) {
        listeners.add(listener);
    }
}
