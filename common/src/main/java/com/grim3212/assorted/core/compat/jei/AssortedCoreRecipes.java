package com.grim3212.assorted.core.compat.jei;

import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import java.util.List;

/**
 * The machine recipes JEI should show.
 * <p>
 * TODO(26.2): these used to be read straight off the client's recipe manager. 26.x removed that
 * entirely - {@code ClientboundUpdateRecipesPacket} now only carries recipe property sets and
 * stonecutter recipes, and {@link net.minecraft.client.multiplayer.ClientRecipeContainer} (the
 * client's {@code RecipeAccess}) exposes nothing else. Recipes reach the client only as
 * {@code RecipeDisplay} entries through the recipe book, which these recipes opt out of via
 * {@code isSpecial()}. Restoring the JEI listing needs a mod packet that syncs the alloy forge and
 * grinding mill recipes to the client on login/reload and calls {@link #setRecipes}; that is
 * networking, which lives in the loader modules. Until then JEI shows the categories with no
 * recipes in them.
 */
public final class AssortedCoreRecipes {

    private static List<AlloyForgeRecipe> alloyForgeRecipes = List.of();
    private static List<GrindingMillRecipe> grindingMillRecipes = List.of();

    /**
     * Fed by the (not yet written) recipe sync payload.
     */
    public static void setRecipes(List<AlloyForgeRecipe> alloyForge, List<GrindingMillRecipe> grindingMill) {
        alloyForgeRecipes = List.copyOf(alloyForge);
        grindingMillRecipes = List.copyOf(grindingMill);
    }

    public List<AlloyForgeRecipe> getAlloyForgeRecipes() {
        return alloyForgeRecipes;
    }

    public List<GrindingMillRecipe> getGrindingMillRecipes() {
        return grindingMillRecipes;
    }
}
