package com.grim3212.assorted.core.compat.jei.categories;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.compat.jei.JEIAssortedCore;
import com.grim3212.assorted.core.compat.jei.JEIHelpers;
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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class GrindingMillRecipeCategory implements IRecipeCategory<GrindingMillRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Constants.MOD_ID, "grinding_mill");
    protected static final int inputSlot = 0;
    protected static final int toolSlot = 1;
    protected static final int fuelSlot = 2;
    protected static final int outputSlot = 3;
    private static final ResourceLocation GUI = new ResourceLocation(Constants.MOD_ID, "textures/gui/container/grinding_mill.png");
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
    public void draw(GrindingMillRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        animatedFlame.draw(guiGraphics, 30, 41);

        IDrawableAnimated gear = getGear(recipe);
        gear.draw(guiGraphics, 28, 21);

        drawExperience(recipe, guiGraphics, 0);
        drawCookTime(recipe, guiGraphics, 65);
    }

    protected void drawExperience(GrindingMillRecipe recipe, GuiGraphics guiGraphics, int y) {
        float experience = recipe.getExperience();
        if (experience > 0) {
            Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(experienceString);
            guiGraphics.drawString(fontRenderer, experienceString, background.getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    protected void drawCookTime(GrindingMillRecipe recipe, GuiGraphics guiGraphics, int y) {
        int cookTime = recipe.getCookTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, background.getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder recipeLayout, GrindingMillRecipe recipe, IFocusGroup focusGroup) {
        List<List<ItemStack>> inputs = JEIHelpers.getMachineIngredientStacks(recipe.getIngredient());
        inputs.add(JEIHelpers.grindingMillAcceptedTools);

        recipeLayout.addSlot(RecipeIngredientRole.INPUT, 1, 23).addItemStacks(inputs.get(inputSlot));
        recipeLayout.addSlot(RecipeIngredientRole.INPUT, 30, 1).addItemStacks(inputs.get(toolSlot));
        recipeLayout.addSlot(RecipeIngredientRole.OUTPUT, 65, 23).addItemStack(JEIHelpers.getResultItem(recipe));
    }

    @Override
    public RecipeType<GrindingMillRecipe> getRecipeType() {
        return JEIAssortedCore.GRINDING_MILL;
    }

}
