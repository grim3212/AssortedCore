package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class BaseMachineContainer extends Container {

	private final IInventory machineInventory;
	protected final IIntArray machineData;
	protected final World world;
	protected final IRecipeType<? extends BaseMachineRecipe> recipeType;

	public BaseMachineContainer(ContainerType<? extends BaseMachineContainer> containerType, IRecipeType<? extends BaseMachineRecipe> recipeType, int id, PlayerInventory playerInventory, int slots, IInventory machineInventory, IIntArray machineData) {
		super(containerType, id);
		checkContainerSize(machineInventory, slots);
		checkContainerDataCount(machineData, 4);
		this.recipeType = recipeType;
		this.machineInventory = machineInventory;
		this.machineData = machineData;
		this.world = playerInventory.player.level;

		this.addDataSlots(machineData);
	}

	@Override
	public abstract ItemStack quickMoveStack(PlayerEntity playerIn, int index);

	@Override
	public boolean stillValid(PlayerEntity playerIn) {
		return this.machineInventory.stillValid(playerIn);
	}

	protected boolean hasRecipe(ItemStack stack) {
		return this.world.getRecipeManager().getAllRecipesFor((IRecipeType<BaseMachineRecipe>) this.recipeType).stream().anyMatch((recipe) -> {
			return recipe.validInput(stack);
		});
	}

	@OnlyIn(Dist.CLIENT)
	public abstract int getCookProgressionScaled();

	@OnlyIn(Dist.CLIENT)
	public abstract int getBurnLeftScaled();

	@OnlyIn(Dist.CLIENT)
	public boolean isBurning() {
		return this.machineData.get(0) > 0;
	}

}