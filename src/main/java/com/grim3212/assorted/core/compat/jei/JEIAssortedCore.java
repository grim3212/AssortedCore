package com.grim3212.assorted.core.compat.jei;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;
import com.grim3212.assorted.core.compat.jei.categories.AlloyForgeRecipeCategory;
import com.grim3212.assorted.core.compat.jei.categories.GrindingMillRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaRecipeCategoryUid;
import mezz.jei.api.helpers.IGuiHelper;
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
		registration.addRecipes(assortedCoreRecipes.getAlloyForgeRecipes(), AlloyForgeRecipeCategory.UID);
		registration.addRecipes(assortedCoreRecipes.getGrindingMillRecipes(), GrindingMillRecipeCategory.UID);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
		registration.addRecipeClickArea(AlloyForgeScreen.class, 78, 28, 24, 16, AlloyForgeRecipeCategory.UID);
		registration.addRecipeClickArea(GrindingMillScreen.class, 78, 25, 20, 20, GrindingMillRecipeCategory.UID);
	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
		registration.addRecipeTransferHandler(AlloyForgeContainer.class, AlloyForgeRecipeCategory.UID, 0, 2, 4, 36);
		registration.addRecipeTransferHandler(GrindingMillContainer.class, GrindingMillRecipeCategory.UID, 0, 2, 4, 36);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.BASIC_ALLOY_FORGE.get()), AlloyForgeRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()), AlloyForgeRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.ADVANCED_ALLOY_FORGE.get()), AlloyForgeRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.EXPERT_ALLOY_FORGE.get()), AlloyForgeRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);

		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.BASIC_GRINDING_MILL.get()), GrindingMillRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()), GrindingMillRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.ADVANCED_GRINDING_MILL.get()), GrindingMillRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
		registration.addRecipeCatalyst(new ItemStack(CoreBlocks.EXPERT_GRINDING_MILL.get()), GrindingMillRecipeCategory.UID, VanillaRecipeCategoryUid.FUEL);
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		JEIHelpers.hydrateLists();
	}
}
