package com.grim3212.assorted.core.compat.jei.categories;

import java.util.List;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
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
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class GrindingMillRecipeCategory implements IRecipeCategory<GrindingMillRecipe> {

	public static final ResourceLocation UID = new ResourceLocation(AssortedCore.MODID, "grinding_mill");
	private static final ResourceLocation GUI = new ResourceLocation(AssortedCore.MODID, "textures/gui/container/grinding_mill.png");

	protected static final int inputSlot = 0;
	protected static final int toolSlot = 1;
	protected static final int fuelSlot = 2;
	protected static final int outputSlot = 3;

	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;

	private final IDrawable background;
	private final int regularCookTime = 400;
	private final IDrawable icon;
	private final String localizedName;
	private final LoadingCache<Integer, IDrawableAnimated> cachedGears;

	public GrindingMillRecipeCategory(IGuiHelper guiHelper) {
		this.staticFlame = guiHelper.createDrawable(GUI, 176, 0, 14, 14);
		this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

		this.background = guiHelper.createDrawable(GUI, 50, 4, 86, 75);
		Block alloyForge = CoreBlocks.BASIC_GRINDING_MILL.get();
		this.icon = guiHelper.createDrawableIngredient(new ItemStack(alloyForge));
		this.localizedName = I18n.format(alloyForge.getTranslationKey());
		this.cachedGears = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
			@Override
			public IDrawableAnimated load(Integer cookTime) {
				return guiHelper.drawableBuilder(GUI, 176, 14, 20, 20).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});

	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends GrindingMillRecipe> getRecipeClass() {
		return GrindingMillRecipe.class;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	protected IDrawableAnimated getGear(GrindingMillRecipe recipe) {
		int cookTime = recipe.getCookTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		return this.cachedGears.getUnchecked(cookTime);
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
	public void setIngredients(GrindingMillRecipe recipe, IIngredients ingredients) {
		List<List<ItemStack>> inputs = JEIHelpers.getMachineIngredientStacks(recipe.getIngredient());
		inputs.add(JEIHelpers.grindingMillAcceptedTools);

		ingredients.setInputLists(VanillaTypes.ITEM, inputs);
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
	}

	@Override
	public void draw(GrindingMillRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
		animatedFlame.draw(matrixStack, 30, 41);

		IDrawableAnimated gear = getGear(recipe);
		gear.draw(matrixStack, 28, 21);

		drawExperience(recipe, matrixStack, 0);
		drawCookTime(recipe, matrixStack, 65);
	}

	protected void drawExperience(GrindingMillRecipe recipe, MatrixStack matrixStack, int y) {
		float experience = recipe.getExperience();
		if (experience > 0) {
			TranslationTextComponent experienceString = new TranslationTextComponent("gui.jei.category.smelting.experience", experience);
			Minecraft minecraft = Minecraft.getInstance();
			FontRenderer fontRenderer = minecraft.fontRenderer;
			int stringWidth = fontRenderer.getStringPropertyWidth(experienceString);
			fontRenderer.drawText(matrixStack, experienceString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	protected void drawCookTime(GrindingMillRecipe recipe, MatrixStack matrixStack, int y) {
		int cookTime = recipe.getCookTime();
		if (cookTime > 0) {
			int cookTimeSeconds = cookTime / 20;
			TranslationTextComponent timeString = new TranslationTextComponent("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
			Minecraft minecraft = Minecraft.getInstance();
			FontRenderer fontRenderer = minecraft.fontRenderer;
			int stringWidth = fontRenderer.getStringPropertyWidth(timeString);
			fontRenderer.drawText(matrixStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, GrindingMillRecipe recipe, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(inputSlot, true, 0, 22);
		guiItemStacks.init(toolSlot, true, 29, 0);
		guiItemStacks.init(outputSlot, false, 64, 22);

		guiItemStacks.set(ingredients);
	}

}
