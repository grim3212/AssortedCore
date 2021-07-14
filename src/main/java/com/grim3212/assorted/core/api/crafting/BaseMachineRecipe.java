package com.grim3212.assorted.core.api.crafting;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

public abstract class BaseMachineRecipe implements IRecipe<IInventory> {

	protected final ResourceLocation id;
	protected final String group;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookTime;

	public BaseMachineRecipe(ResourceLocation idIn, String groupIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		this.id = idIn;
		this.group = groupIn;
		this.result = resultIn;
		this.experience = experienceIn;
		this.cookTime = cookTimeIn;
	}

	@Override
	public ItemStack assemble(IInventory inv) {
		return this.result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	public float getExperience() {
		return this.experience;
	}

	@Override
	public ItemStack getResultItem() {
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
	public boolean isSpecial() {
		return true;
	}

	public abstract boolean validInput(ItemStack stack);
}