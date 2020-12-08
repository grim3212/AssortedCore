package com.grim3212.assorted.core.compat.jei;

import java.util.ArrayList;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.compat.jei.recipes.alloyforge.AlloyForgeRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIAssortedCore implements IModPlugin {

	private static final ResourceLocation PLUGIN_ID = new ResourceLocation(AssortedCore.MODID, "jei_plugin");

	@Override
	public ResourceLocation getPluginUid() {
		return PLUGIN_ID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
		registration.addRecipeCategories(new AlloyForgeRecipeCategory(guiHelper));
	}
	
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(new ArrayList<>(AlloyRecipe.recipeList.values()), AlloySmelterRecipeCategory.UID);
	}
}
