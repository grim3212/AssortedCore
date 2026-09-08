package com.grim3212.assorted.core.api.crafting;

import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class GrindingMillRecipe extends BaseMachineRecipe {

	protected final MachineIngredient ingredient;

	public GrindingMillRecipe(String groupIn, MachineIngredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		super(groupIn, resultIn, experienceIn, cookTimeIn);
		this.ingredient = ingredientIn;
	}

	@Override
	public boolean matches(MachineRecipeInput input, Level worldIn) {
		return this.ingredient.test(input.getItem(0));
	}

	@Override
	public RecipeSerializer<GrindingMillRecipe> getSerializer() {
		return GrindingMillRecipeSerializer.INSTANCE;
	}

	@Override
	public RecipeType<GrindingMillRecipe> getType() {
		return CoreRecipeTypes.GRINDING_MILL.get();
	}

	@Override
	public boolean validInput(ItemStack stack) {
		return this.ingredient.test(stack);
	}

	public boolean validItem(ItemStack stack) {
		return this.ingredient.getBaseIngredient().test(stack);
	}

	public MachineIngredient getIngredient() {
		return ingredient;
	}
}
