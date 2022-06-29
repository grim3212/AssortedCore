package com.grim3212.assorted.core.compat.jei.categories;

import java.util.List;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.compat.jei.JEIAssortedCore;
import com.grim3212.assorted.core.compat.jei.JEIHelpers;
import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

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
	private final Component localizedName;
	private final LoadingCache<Integer, IDrawableAnimated> cachedGears;

	public GrindingMillRecipeCategory(IGuiHelper guiHelper) {
		this.staticFlame = guiHelper.createDrawable(GUI, 176, 0, 14, 14);
		this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

		this.background = guiHelper.createDrawable(GUI, 50, 4, 86, 75);
		Block alloyForge = CoreBlocks.BASIC_GRINDING_MILL.get();
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(alloyForge));
		this.localizedName = alloyForge.getName();
		this.cachedGears = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
			@Override
			public IDrawableAnimated load(Integer cookTime) {
				return guiHelper.drawableBuilder(GUI, 176, 14, 20, 20).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});

	}

	@Override
	public Component getTitle() {
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
	public void draw(GrindingMillRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack matrixStack, double mouseX, double mouseY) {
		animatedFlame.draw(matrixStack, 30, 41);

		IDrawableAnimated gear = getGear(recipe);
		gear.draw(matrixStack, 28, 21);

		drawExperience(recipe, matrixStack, 0);
		drawCookTime(recipe, matrixStack, 65);
	}

	protected void drawExperience(GrindingMillRecipe recipe, PoseStack matrixStack, int y) {
		float experience = recipe.getExperience();
		if (experience > 0) {
			Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
			Minecraft minecraft = Minecraft.getInstance();
			Font fontRenderer = minecraft.font;
			int stringWidth = fontRenderer.width(experienceString);
			fontRenderer.draw(matrixStack, experienceString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	protected void drawCookTime(GrindingMillRecipe recipe, PoseStack matrixStack, int y) {
		int cookTime = recipe.getCookTime();
		if (cookTime > 0) {
			int cookTimeSeconds = cookTime / 20;
			Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
			Minecraft minecraft = Minecraft.getInstance();
			Font fontRenderer = minecraft.font;
			int stringWidth = fontRenderer.width(timeString);
			fontRenderer.draw(matrixStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder recipeLayout, GrindingMillRecipe recipe, IFocusGroup focusGroup) {
		List<List<ItemStack>> inputs = JEIHelpers.getMachineIngredientStacks(recipe.getIngredient());
		inputs.add(JEIHelpers.grindingMillAcceptedTools);

		recipeLayout.addSlot(RecipeIngredientRole.INPUT, 0, 22).addItemStacks(inputs.get(inputSlot));
		recipeLayout.addSlot(RecipeIngredientRole.INPUT, 29, 0).addItemStacks(inputs.get(toolSlot));
		recipeLayout.addSlot(RecipeIngredientRole.OUTPUT, 64, 22).addItemStack(recipe.getResultItem());
	}

	@Override
	public RecipeType<GrindingMillRecipe> getRecipeType() {
		return JEIAssortedCore.GRINDING_MILL;
	}

}
