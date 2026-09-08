package com.grim3212.assorted.core.api.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

/**
 * The inputs a machine offers to a recipe.
 * <p>
 * Recipes used to match against a raw {@code Container}, which meant handing a recipe the whole
 * machine inventory including fuel and output slots. 26.x introduced {@link RecipeInput} for
 * exactly this, so a machine now passes just the slots a recipe is allowed to see.
 *
 * @param items The input slots, in the order the recipe expects them.
 */
public record MachineRecipeInput(List<ItemStack> items) implements RecipeInput {

    public static MachineRecipeInput of(ItemStack... stacks) {
        return new MachineRecipeInput(List.of(stacks));
    }

    @Override
    public ItemStack getItem(int index) {
        return index >= 0 && index < this.items.size() ? this.items.get(index) : ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return this.items.size();
    }
}
