package com.grim3212.assorted.core.compat.jei;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;
import com.grim3212.assorted.core.compat.jei.categories.AlloyForgeRecipeCategory;
import com.grim3212.assorted.core.compat.jei.categories.GrindingMillRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEIAssortedCore implements IModPlugin {

	public static final RecipeType<AlloyForgeRecipe> ALLOY_FORGE = RecipeType.create(AssortedCore.MODID, "alloy_forge", AlloyForgeRecipe.class);
	public static final RecipeType<GrindingMillRecipe> GRINDING_MILL = RecipeType.create(AssortedCore.MODID, "grinding_mill", GrindingMillRecipe.class);

	private static final ResourceLocation PLUGIN_ID = new ResourceLocation(AssortedCore.MODID, "assortedcore");

	@Override
	public ResourceLocation getPluginUid() {
		return PLUGIN_ID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
		registration.addRecipeCategories(new AlloyForgeRecipeCategory(guiHelper));
		registration.addRecipeCategories(new GrindingMillRecipeCategory(guiHelper));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		AssortedCoreRecipes assortedCoreRecipes = new AssortedCoreRecipes();
		registration.addRecipes(ALLOY_FORGE, assortedCoreRecipes.getAlloyForgeRecipes());
		registration.addRecipes(GRINDING_MILL, assortedCoreRecipes.getGrindingMillRecipes());
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

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.BASIC_ALLOY_FORGE.get()), ALLOY_FORGE, RecipeTypes.FUELING);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()), ALLOY_FORGE, RecipeTypes.FUELING);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.ADVANCED_ALLOY_FORGE.get()), ALLOY_FORGE, RecipeTypes.FUELING);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.EXPERT_ALLOY_FORGE.get()), ALLOY_FORGE, RecipeTypes.FUELING);

		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.BASIC_GRINDING_MILL.get()), GRINDING_MILL, RecipeTypes.FUELING);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()), GRINDING_MILL, RecipeTypes.FUELING);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.ADVANCED_GRINDING_MILL.get()), GRINDING_MILL, RecipeTypes.FUELING);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.EXPERT_GRINDING_MILL.get()), GRINDING_MILL, RecipeTypes.FUELING);
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		JEIHelpers.hydrateLists();
	}
}
