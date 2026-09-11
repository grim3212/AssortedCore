package com.grim3212.assorted.core.api.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;

/**
 * Shared behaviour for the machine recipes, which match a {@link MachineRecipeInput} of just the
 * input slots.
 */
public abstract class BaseMachineRecipe implements Recipe<MachineRecipeInput> {

    protected final String group;
    protected final ItemStackTemplate result;
    protected final float experience;
    protected final int cookTime;

    public BaseMachineRecipe(String groupIn, ItemStackTemplate resultIn, float experienceIn, int cookTimeIn) {
        this.group = groupIn;
        this.result = resultIn;
        this.experience = experienceIn;
        this.cookTime = cookTimeIn;
    }

    @Override
    public ItemStack assemble(MachineRecipeInput input) {
        return this.result.create();
    }

    public float getExperience() {
        return this.experience;
    }

    /**
     * The recipe's result. Stored as an {@link ItemStackTemplate} because a stack cannot be built
     * before item components are bound.
     */
    public ItemStack getResultItem() {
        return this.result.create();
    }

    public ItemStackTemplate getResultTemplate() {
        return this.result;
    }

    @Override
    public String group() {
        return this.group;
    }

    public int getCookTime() {
        return cookTime;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    /**
     * These recipes are crafted in their own machine blocks, never placed from the recipe book, so
     * there is nothing to lay out into a crafting grid.
     */
    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    /**
     * Required by the interface, but not meaningfully used: {@link #isSpecial()} keeps these
     * recipes out of the recipe book entirely. Reusing the closest vanilla category rather than
     * registering a custom one that nothing would ever display.
     */
    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.BLAST_FURNACE_MISC;
    }

    public abstract boolean validInput(ItemStack stack);
}
