package com.grim3212.assorted.core.api.crafting;

import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class GrindingMillRecipe extends BaseMachineRecipe {

	protected final MachineIngredient ingredient;

	public GrindingMillRecipe(ResourceLocation idIn, String groupIn, MachineIngredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		super(idIn, groupIn, resultIn, experienceIn, cookTimeIn);
		this.ingredient = ingredientIn;
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {
		return this.ingredient.test(inv.getItem(0));
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return CoreRecipeSerializers.GRINDING_MILL.get();
	}

	@Override
	public RecipeType<?> getType() {
		return CoreRecipeTypes.GRINDING_MILL;
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