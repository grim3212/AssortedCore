package com.grim3212.assorted.core.common.block.tileentity;

import java.util.List;

import javax.annotation.Nullable;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AlloyForgeTileEntity extends BaseMachineTileEntity {

	private static final int[] SLOTS_UP = new int[] { 0, 1, 2 };
	private static final int[] SLOTS_DOWN = new int[] { 3 };
	private static final int[] SLOTS_HORIZONTAL = new int[] { 0, 1, 2 };

	public static AlloyForgeTileEntity basicTileEntity() {
		return new AlloyForgeTileEntity(CoreTileEntityTypes.BASIC_ALLOY_FORGE.get(), MachineTier.BASIC);
	}

	public static AlloyForgeTileEntity intermediateTileEntity() {
		return new AlloyForgeTileEntity(CoreTileEntityTypes.INTERMEDIATE_ALLOY_FORGE.get(), MachineTier.INTERMEDIATE);
	}

	public static AlloyForgeTileEntity advancedTileEntity() {
		return new AlloyForgeTileEntity(CoreTileEntityTypes.ADVANCED_ALLOY_FORGE.get(), MachineTier.ADVANCED);
	}

	public static AlloyForgeTileEntity expertTileEntity() {
		return new AlloyForgeTileEntity(CoreTileEntityTypes.EXPERT_ALLOY_FORGE.get(), MachineTier.EXPERT);
	}

	public AlloyForgeTileEntity(TileEntityType<AlloyForgeTileEntity> tileEntityType, MachineTier tier) {
		super(tileEntityType, tier, 4, 400, CoreRecipeTypes.ALLOY_FORGE);
	}

	@Override
	protected boolean canCombine(@Nullable BaseMachineRecipe recipeIn) {
		if (!this.items.get(0).isEmpty() && !this.items.get(1).isEmpty() && recipeIn != null) {
			ItemStack itemstack = recipeIn.getRecipeOutput();
			if (itemstack.isEmpty()) {
				return false;
			} else {
				ItemStack outputSlot = this.items.get(3);
				if (outputSlot.isEmpty()) {
					return true;
				} else if (!outputSlot.isItemEqual(itemstack)) {
					return false;
				} else if (outputSlot.getCount() + itemstack.getCount() <= this.getInventoryStackLimit() && outputSlot.getCount() + itemstack.getCount() <= outputSlot.getMaxStackSize()) {
					return true;
				} else {
					return outputSlot.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
				}
			}
		} else {
			return false;
		}
	}

	@Override
	protected void combine(@Nullable BaseMachineRecipe recipe) {
		if (recipe != null && this.canCombine(recipe)) {
			AlloyForgeRecipe forgeRecipe = (AlloyForgeRecipe) recipe;
			ItemStack ingredient1 = this.items.get(0);
			ItemStack ingredient2 = this.items.get(1);
			ItemStack itemstack1 = recipe.getRecipeOutput();
			ItemStack outputSlot = this.items.get(3);
			if (outputSlot.isEmpty()) {
				this.items.set(3, itemstack1.copy());
			} else if (outputSlot.getItem() == itemstack1.getItem()) {
				outputSlot.grow(itemstack1.getCount());
			}

			if (!this.world.isRemote) {
				this.setRecipeUsed(recipe);
			}

			// Flip shrink amounts if the recipe is in opposite positions
			if (forgeRecipe.getIngredient1().test(ingredient1)) {
				ingredient1.shrink(forgeRecipe.getIngredient1().getCount());
				ingredient2.shrink(forgeRecipe.getIngredient2().getCount());
			} else {
				ingredient1.shrink(forgeRecipe.getIngredient2().getCount());
				ingredient2.shrink(forgeRecipe.getIngredient1().getCount());
			}
		}
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		return new AlloyForgeContainer(windowId, playerInventory, this, this.machineData);
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent(AssortedCore.MODID + ".container.alloy_forge");
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		if (side == Direction.DOWN) {
			return SLOTS_DOWN;
		} else {
			return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
		}
	}

	@Override
	protected List<Integer> inputSlots() {
		return NonNullList.from(0, 0, 1);
	}

	@Override
	protected int fuelSlot() {
		return 2;
	}

	@Override
	protected int outputSlot() {
		return 3;
	}
}
