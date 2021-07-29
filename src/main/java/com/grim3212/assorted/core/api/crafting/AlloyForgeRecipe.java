package com.grim3212.assorted.core.api.crafting;

import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class AlloyForgeRecipe extends BaseMachineRecipe {

	protected final MachineIngredient ingredient1;
	protected final MachineIngredient ingredient2;

	public AlloyForgeRecipe(ResourceLocation idIn, String groupIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		super(idIn, groupIn, resultIn, experienceIn, cookTimeIn);
		this.ingredient1 = ingredient1In;
		this.ingredient2 = ingredient2In;
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {
		return (this.ingredient1.test(inv.getItem(0)) && this.ingredient2.test(inv.getItem(1))) || (this.ingredient1.test(inv.getItem(1)) && this.ingredient2.test(inv.getItem(0)));
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return CoreRecipeSerializers.ALLOY_FORGE.get();
	}

	@Override
	public RecipeType<?> getType() {
		return CoreRecipeTypes.ALLOY_FORGE;
	}

	@Override
	public boolean validInput(ItemStack stack) {
		return this.ingredient1.test(stack) || this.ingredient2.test(stack);
	}

	public boolean validItem(ItemStack stack) {
		return this.ingredient1.getBaseIngredient().test(stack) || this.ingredient2.getBaseIngredient().test(stack);
	}

	public MachineIngredient getIngredient1() {
		return ingredient1;
	}

	public MachineIngredient getIngredient2() {
		return ingredient2;
	}
}
