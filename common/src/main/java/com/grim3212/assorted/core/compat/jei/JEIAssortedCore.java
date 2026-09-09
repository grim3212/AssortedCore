package com.grim3212.assorted.core.compat.jei;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.crafting.ClientMachineRecipes;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;
import com.grim3212.assorted.core.compat.jei.categories.AlloyForgeRecipeCategory;
import com.grim3212.assorted.core.compat.jei.categories.GrindingMillRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@JeiPlugin
public class JEIAssortedCore implements IModPlugin {

    public static final IRecipeType<AlloyForgeRecipe> ALLOY_FORGE = IRecipeType.create(Constants.MOD_ID, "alloy_forge", AlloyForgeRecipe.class);
    public static final IRecipeType<GrindingMillRecipe> GRINDING_MILL = IRecipeType.create(Constants.MOD_ID, "grinding_mill", GrindingMillRecipe.class);

    private static final Identifier PLUGIN_ID = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "assets/assortedcore");

    static {
        ClientMachineRecipes.addUpdateListener(JEIAssortedCore::onRecipesUpdated);
    }

    /**
     * The recipes currently handed to JEI, so a later sync knows what to take back out. Only ever
     * touched from the client thread: plugin loading and packet handling both run there.
     */
    private static List<AlloyForgeRecipe> shownAlloyForge = List.of();
    private static List<GrindingMillRecipe> shownGrindingMill = List.of();

    @Nullable
    private static IJeiRuntime runtime;

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new AlloyForgeRecipeCategory(guiHelper));
        registration.addRecipeCategories(new GrindingMillRecipeCategory(guiHelper));
    }

    /**
     * The recipes come from {@link ClientMachineRecipes} rather than the recipe manager, which does
     * not exist on the client any more.
     */
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // The accepted tool list fills the grinding mill's tool slot, and JEI walks every slot as
        // the recipes go in to build its ingredient index, so it has to be built first.
        JEIHelpers.hydrateLists();

        shownAlloyForge = ClientMachineRecipes.alloyForge();
        shownGrindingMill = ClientMachineRecipes.grindingMill();

        registration.addRecipes(ALLOY_FORGE, shownAlloyForge);
        registration.addRecipes(GRINDING_MILL, shownGrindingMill);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloyForgeScreen.class, 78, 28, 24, 16, ALLOY_FORGE);
        registration.addRecipeClickArea(GrindingMillScreen.class, 78, 25, 20, 20, GRINDING_MILL);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(AlloyForgeContainer.class, CoreContainerTypes.ALLOY_FORGE.get(), ALLOY_FORGE, 0, 2, 4, 36);
        registration.addRecipeTransferHandler(GrindingMillContainer.class, CoreContainerTypes.GRINDING_MILL.get(), GRINDING_MILL, 0, 2, 4, 36);
    }

    /**
     * Catalysts are registered as crafting stations now, one call per category rather than one per
     * block. {@code RecipeTypes.FUELING} was also split per cooking block into SMELTING_FUEL /
     * BLASTING_FUEL / SMOKING_FUEL; these machines burn whatever the vanilla fuel registry accepts,
     * which is the furnace fuel list, so they are stations for the smelting fuel category.
     */
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        ItemLike[] alloyForges = new ItemLike[]{CoreBlocks.BASIC_ALLOY_FORGE.get(), CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), CoreBlocks.ADVANCED_ALLOY_FORGE.get(), CoreBlocks.EXPERT_ALLOY_FORGE.get()};
        ItemLike[] grindingMills = new ItemLike[]{CoreBlocks.BASIC_GRINDING_MILL.get(), CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), CoreBlocks.ADVANCED_GRINDING_MILL.get(), CoreBlocks.EXPERT_GRINDING_MILL.get()};

        registration.addCraftingStation(ALLOY_FORGE, alloyForges);
        registration.addCraftingStation(GRINDING_MILL, grindingMills);
        registration.addCraftingStation(RecipeTypes.SMELTING_FUEL, alloyForges);
        registration.addCraftingStation(RecipeTypes.SMELTING_FUEL, grindingMills);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        runtime = jeiRuntime;
        // The sync may have landed between registerRecipes and here, in which case what JEI holds
        // is already out of date.
        onRecipesUpdated();
    }

    @Override
    public void onRuntimeUnavailable() {
        runtime = null;
    }

    /**
     * Replaces the listed recipes after a sync.
     * <p>
     * JEI's plugins are loaded once per connection, and on Fabric there is nothing making that wait
     * for our packet, so recipes can arrive after {@link #registerRecipes} has already run. A
     * datapack reload sends them again mid-session as well. Either way the previous set is hidden
     * and the new one added; the lists are swapped wholesale, so an identity check is enough to
     * spot a set JEI has not seen.
     */
    private static void onRecipesUpdated() {
        IJeiRuntime jeiRuntime = runtime;
        if (jeiRuntime == null) {
            return;
        }

        List<AlloyForgeRecipe> alloyForge = ClientMachineRecipes.alloyForge();
        List<GrindingMillRecipe> grindingMill = ClientMachineRecipes.grindingMill();
        if (alloyForge == shownAlloyForge && grindingMill == shownGrindingMill) {
            return;
        }

        IRecipeManager recipeManager = jeiRuntime.getRecipeManager();
        recipeManager.hideRecipes(ALLOY_FORGE, shownAlloyForge);
        recipeManager.hideRecipes(GRINDING_MILL, shownGrindingMill);

        shownAlloyForge = alloyForge;
        shownGrindingMill = grindingMill;

        recipeManager.addRecipes(ALLOY_FORGE, alloyForge);
        recipeManager.addRecipes(GRINDING_MILL, grindingMill);
    }
}
