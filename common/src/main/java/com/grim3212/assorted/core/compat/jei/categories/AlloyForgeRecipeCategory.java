package com.grim3212.assorted.core.compat.jei.categories;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
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

import java.util.List;

public class AlloyForgeRecipeCategory implements IRecipeCategory<AlloyForgeRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Constants.MOD_ID, "alloy_forge");
    protected static final int inputSlot1 = 0;
    protected static final int inputSlot2 = 1;
    protected static final int fuelSlot = 2;
    protected static final int outputSlot = 3;
    private static final ResourceLocation GUI = new ResourceLocation(Constants.MOD_ID, "textures/gui/container/alloy_forge.png");
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;

    private final IDrawable background;
    private final int regularCookTime = 400;
    private final IDrawable icon;
    private final Component localizedName;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public AlloyForgeRecipeCategory(IGuiHelper guiHelper) {
        this.staticFlame = guiHelper.createDrawable(GUI, 176, 0, 14, 14);
        this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

        this.background = guiHelper.createDrawable(GUI, 31, 22, 105, 57);
        Block alloyForge = CoreBlocks.BASIC_ALLOY_FORGE.get();
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(alloyForge));
        this.localizedName = alloyForge.getName();
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<Integer, IDrawableAnimated>() {
            @Override
            public IDrawableAnimated load(Integer cookTime) {
                return guiHelper.drawableBuilder(GUI, 176, 14, 24, 17).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });

    }

    @Override
    public Component getTitle() {
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
    public void draw(AlloyForgeRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack matrixStack, double mouseX, double mouseY) {
        animatedFlame.draw(matrixStack, 49, 23);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(matrixStack, 47, 6);

        drawExperience(recipe, matrixStack, 45);
        drawCookTime(recipe, matrixStack, 45);
    }

    protected void drawExperience(AlloyForgeRecipe recipe, PoseStack matrixStack, int y) {
        float experience = recipe.getExperience();
        if (experience > 0) {
            Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            fontRenderer.draw(matrixStack, experienceString, 0, y, 0xFF808080);
        }
    }

    protected void drawCookTime(AlloyForgeRecipe recipe, PoseStack matrixStack, int y) {
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
    public void setRecipe(IRecipeLayoutBuilder recipeLayout, AlloyForgeRecipe recipe, IFocusGroup focusGroup) {
        List<List<ItemStack>> inputs = JEIHelpers.getMachineIngredientStacks(recipe.getIngredient1(), recipe.getIngredient2());

        recipeLayout.addSlot(RecipeIngredientRole.INPUT, 1, 5).addItemStacks(inputs.get(inputSlot1));
        recipeLayout.addSlot(RecipeIngredientRole.INPUT, 25, 5).addItemStacks(inputs.get(inputSlot2));
        recipeLayout.addSlot(RecipeIngredientRole.OUTPUT, 84, 5).addItemStack(JEIHelpers.getResultItem(recipe));
    }

    @Override
    public RecipeType<AlloyForgeRecipe> getRecipeType() {
        return JEIAssortedCore.ALLOY_FORGE;
    }

}
