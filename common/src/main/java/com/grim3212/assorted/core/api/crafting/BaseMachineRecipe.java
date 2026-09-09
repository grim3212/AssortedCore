package com.grim3212.assorted.core.api.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;

/**
 * Shared behaviour for the machine recipes.
 * <p>
 * Two things changed shape in 26.x. Recipes no longer carry their own id - the recipe manager keys
 * them by {@code ResourceKey<Recipe<?>>} - so the {@code id} field and {@code getId()} are gone.
 * And {@code Recipe} is parameterised on {@link net.minecraft.world.item.crafting.RecipeInput}
 * rather than {@code Container}, so machines pass a {@link MachineRecipeInput} holding only the
 * slots a recipe may see.
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
     * The recipe's result.
     * <p>
     * No longer an override: {@code Recipe} dropped {@code getResultItem}, because the recipe book
     * reads results off {@link net.minecraft.world.item.crafting.display.RecipeDisplay} now. The
     * machines still need it directly, so it stays as a plain accessor.
     * <p>
     * The result is stored as an {@link ItemStackTemplate} - since 26.x a stack cannot be built
     * before its item's default data components are bound, so recipes carry the template and only
     * realise a stack when one is actually needed.
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
