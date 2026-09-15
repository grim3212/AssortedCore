package com.grim3212.assorted.core.api.crafting;

import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.lib.manual.IManualRecipeProvider;
import com.grim3212.assorted.lib.manual.ManualRecipeView;
import com.grim3212.assorted.lib.manual.ManualSlot;

import java.util.List;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;

public class AlloyForgeRecipe extends BaseMachineRecipe implements IManualRecipeProvider {

	protected final MachineIngredient ingredient1;
	protected final MachineIngredient ingredient2;

	public AlloyForgeRecipe(String groupIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, ItemStackTemplate resultIn, float experienceIn, int cookTimeIn) {
		super(groupIn, resultIn, experienceIn, cookTimeIn);
		this.ingredient1 = ingredient1In;
		this.ingredient2 = ingredient2In;
	}

	@Override
	public boolean matches(MachineRecipeInput input, Level worldIn) {
		return (this.ingredient1.test(input.getItem(0)) && this.ingredient2.test(input.getItem(1))) || (this.ingredient1.test(input.getItem(1)) && this.ingredient2.test(input.getItem(0)));
	}

	@Override
	public RecipeSerializer<AlloyForgeRecipe> getSerializer() {
		return AlloyForgeRecipeSerializer.INSTANCE;
	}

	@Override
	public RecipeType<AlloyForgeRecipe> getType() {
		return CoreRecipeTypes.ALLOY_FORGE.get();
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

	/** No {@code RecipeDisplay} to read: these are {@code isSpecial} and kept out of the recipe book. */
	@Override
	public ManualRecipeView manualView() {
		return ManualRecipeView.shaped(2, 1, List.of(this.ingredient1.manualSlot(), this.ingredient2.manualSlot()),
				ManualSlot.of(new SlotDisplay.ItemStackSlotDisplay(this.getResultTemplate())));
	}
}
