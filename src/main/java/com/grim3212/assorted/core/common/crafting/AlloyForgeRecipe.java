package com.grim3212.assorted.core.common.crafting;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class AlloyForgeRecipe implements IRecipe<IInventory> {

	protected final ResourceLocation id;
	protected final String group;
	protected final MachineIngredient ingredient1;
	protected final MachineIngredient ingredient2;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookTime;

	public AlloyForgeRecipe(ResourceLocation idIn, String groupIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		this.id = idIn;
		this.group = groupIn;
		this.ingredient1 = ingredient1In;
		this.ingredient2 = ingredient2In;
		this.result = resultIn;
		this.experience = experienceIn;
		this.cookTime = cookTimeIn;
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return (this.ingredient1.test(inv.getStackInSlot(0)) && this.ingredient2.test(inv.getStackInSlot(1))) || (this.ingredient1.test(inv.getStackInSlot(1)) && this.ingredient2.test(inv.getStackInSlot(0)));
	}

	@Override
	public ItemStack getCraftingResult(IInventory inv) {
		return this.result.copy();
	}

	@Override
	public boolean canFit(int width, int height) {
		return true;
	}

	public float getExperience() {
		return this.experience;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.result;
	}

	@Override
	public String getGroup() {
		return this.group;
	}

	public int getCookTime() {
		return cookTime;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return CoreRecipeSerializers.ALLOY_FORGE.get();
	}

	@Override
	public IRecipeType<?> getType() {
		return CoreRecipeTypes.ALLOY_FORGE;
	}

	public boolean validInput(ItemStack stack) {
		return this.ingredient1.test(stack) || this.ingredient2.test(stack);
	}
}
