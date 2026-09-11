package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The machine recipes the server sent this client. Recipes are not synced by default, so each
 * loader opts this type in and fills this on login and after {@code /reload}. The lists are
 * replaced wholesale, so a reader can spot a reload by identity.
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
