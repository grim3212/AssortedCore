package com.grim3212.assorted.core.compat.jei;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.BaseMachineScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.api.machines.MachineUtil;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.lib.crafting.SyncedRecipes;
import net.minecraft.world.item.crafting.RecipeMap;
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
        SyncedRecipes.addUpdateListener(JEIAssortedCore::onRecipesUpdated);
    }

    /**
     * The recipes currently handed to JEI, so a later sync knows what to take back out. Only ever
     * touched from the client thread: plugin loading and packet handling both run there.
     */
    private static List<AlloyForgeRecipe> shownAlloyForge = List.of();
    private static List<GrindingMillRecipe> shownGrindingMill = List.of();

    /** Replaced wholesale on each sync, so identity spots a fresh one. */
    private static RecipeMap shownFrom = RecipeMap.EMPTY;

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

    /** From {@link SyncedRecipes}: there is no recipe manager on the client. */
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        // The accepted tool list fills the grinding mill's tool slot, and JEI walks every slot as
        // the recipes go in to build its ingredient index, so it has to be built first.
        JEIHelpers.hydrateLists();

        shownFrom = SyncedRecipes.recipes();
        shownAlloyForge = alloyForgeRecipes();
        shownGrindingMill = grindingMillRecipes();

        registration.addRecipes(ALLOY_FORGE, shownAlloyForge);
        registration.addRecipes(GRINDING_MILL, shownGrindingMill);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloyForgeScreen.class, 78, 28, 24, 16, ALLOY_FORGE);
        registration.addRecipeClickArea(GrindingMillScreen.class, 78, 25, 20, 20, GRINDING_MILL);
        registration.addGenericGuiContainerHandler(BaseMachineScreen.class, new MachineRecipeBookGuiHandler());
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(AlloyForgeContainer.class, CoreContainerTypes.ALLOY_FORGE.get(), ALLOY_FORGE, 0, 2, 4, 36);
        registration.addRecipeTransferHandler(GrindingMillContainer.class, CoreContainerTypes.GRINDING_MILL.get(), GRINDING_MILL, 0, 2, 4, 36);
    }

    /**
     * Registers the machines as crafting stations. They burn furnace fuel, so they are stations for
     * {@code SMELTING_FUEL} too.
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
     * Replaces the listed recipes after a sync. On Fabric they can arrive after {@link
     * #registerRecipes}, and a reload sends them again; the lists are replaced wholesale, so
     * identity spots a new set.
     */
    private static void onRecipesUpdated() {
        IJeiRuntime jeiRuntime = runtime;
        if (jeiRuntime == null) {
            return;
        }

        RecipeMap current = SyncedRecipes.recipes();
        if (current == shownFrom) {
            return;
        }

        IRecipeManager recipeManager = jeiRuntime.getRecipeManager();
        recipeManager.hideRecipes(ALLOY_FORGE, shownAlloyForge);
        recipeManager.hideRecipes(GRINDING_MILL, shownGrindingMill);

        shownFrom = current;
        shownAlloyForge = alloyForgeRecipes();
        shownGrindingMill = grindingMillRecipes();

        recipeManager.addRecipes(ALLOY_FORGE, shownAlloyForge);
        recipeManager.addRecipes(GRINDING_MILL, shownGrindingMill);
    }

    private static List<AlloyForgeRecipe> alloyForgeRecipes() {
        return MachineUtil.recipesOfType(null, CoreRecipeTypes.ALLOY_FORGE.get()).toList();
    }

    private static List<GrindingMillRecipe> grindingMillRecipes() {
        return MachineUtil.recipesOfType(null, CoreRecipeTypes.GRINDING_MILL.get()).toList();
    }
}
