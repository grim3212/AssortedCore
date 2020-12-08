package com.grim3212.assorted.core.compat.jei.recipes.alloyforge;

import java.util.Arrays;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.compat.jei.JEIHelpers;
import com.mojang.blaze3d.matrix.MatrixStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.config.Constants;
import mezz.jei.util.Translator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class AlloyForgeRecipeCategory implements IRecipeCategory<AlloyForgeRecipe> {

	private static final ResourceLocation UID = new ResourceLocation(AssortedCore.MODID, "alloy_forge");

	protected static final int inputSlot1 = 0;
	protected static final int inputSlot2 = 1;
	protected static final int fuelSlot = 2;
	protected static final int outputSlot = 3;

	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;

	private final IDrawable background;
	private final int regularCookTime = 400;
	private final IDrawable icon;
	private final String localizedName;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

	public AlloyForgeRecipeCategory(IGuiHelper guiHelper) {
		this.staticFlame = guiHelper.createDrawable(Constants.RECIPE_GUI_VANILLA, 82, 114, 14, 14);
		this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

		this.background = guiHelper.createDrawable(Constants.RECIPE_GUI_VANILLA, 0, 114, 82, 54);
		Block alloyForge = CoreBlocks.BASIC_ALLOY_FORGE.get();
		this.icon = guiHelper.createDrawableIngredient(new ItemStack(alloyForge));
		this.localizedName = Translator.translateToLocal(alloyForge.getTranslationKey());
		this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
			@Override
			public IDrawableAnimated load(Integer cookTime) {
				return guiHelper.drawableBuilder(Constants.RECIPE_GUI_VANILLA, 82, 128, 24, 17).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});

	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends AlloyForgeRecipe> getRecipeClass() {
		return AlloyForgeRecipe.class;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	protected IDrawableAnimated getArrow(AlloyForgeRecipe recipe) {
		int cookTime = recipe.getCookTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		return this.cachedArrows.getUnchecked(cookTime);
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setIngredients(AlloyForgeRecipe recipe, IIngredients ingredients) {
		ingredients.setInputLists(VanillaTypes.ITEM, JEIHelpers.getMachineIngredientStacks(recipe.getIngredient1(), recipe.getIngredient2()));
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
	}

	@Override
	public void draw(AlloyForgeRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
		animatedFlame.draw(matrixStack, 1, 20);

		IDrawableAnimated arrow = getArrow(recipe);
		arrow.draw(matrixStack, 24, 18);

		drawExperience(recipe, matrixStack, 0);
		drawCookTime(recipe, matrixStack, 45);
	}

	protected void drawExperience(AlloyForgeRecipe recipe, MatrixStack matrixStack, int y) {
		float experience = recipe.getExperience();
		if (experience > 0) {
			TranslationTextComponent experienceString = new TranslationTextComponent("gui.jei.category.smelting.experience", experience);
			Minecraft minecraft = Minecraft.getInstance();
			FontRenderer fontRenderer = minecraft.fontRenderer;
			int stringWidth = fontRenderer.getStringPropertyWidth(experienceString);
			fontRenderer.func_243248_b(matrixStack, experienceString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	protected void drawCookTime(AlloyForgeRecipe recipe, MatrixStack matrixStack, int y) {
		int cookTime = recipe.getCookTime();
		if (cookTime > 0) {
			int cookTimeSeconds = cookTime / 20;
			TranslationTextComponent timeString = new TranslationTextComponent("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
			Minecraft minecraft = Minecraft.getInstance();
			FontRenderer fontRenderer = minecraft.fontRenderer;
			int stringWidth = fontRenderer.getStringPropertyWidth(timeString);
			fontRenderer.func_243248_b(matrixStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, AlloyForgeRecipe recipe, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(inputSlot1, true, 0, 0);
		guiItemStacks.set(inputSlot1, Arrays.asList(recipe.getIngredient1().getMatchingStacks()));

		guiItemStacks.init(inputSlot2, true, 30, 0);
		guiItemStacks.set(inputSlot2, Arrays.asList(recipe.getIngredient2().getMatchingStacks()));

		guiItemStacks.init(outputSlot, false, 60, 18);

		guiItemStacks.set(ingredients);
	}

}
