package com.grim3212.assorted.core.api.crafting;

import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GrindingMillRecipe extends BaseMachineRecipe {

	protected final MachineIngredient ingredient;

	public GrindingMillRecipe(ResourceLocation idIn, String groupIn, MachineIngredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		super(idIn, groupIn, resultIn, experienceIn, cookTimeIn);
		this.ingredient = ingredientIn;
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return this.ingredient.test(inv.getStackInSlot(0));
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return CoreRecipeSerializers.GRINDING_MILL.get();
	}

	@Override
	public IRecipeType<?> getType() {
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