package com.grim3212.assorted.core.common.block.tileentity;

import java.util.List;

import javax.annotation.Nullable;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.AssortedCoreAPI;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.handler.CoreConfig;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GrindingMillTileEntity extends BaseMachineTileEntity {

	private static final int[] SLOTS_UP = new int[] { 0, 1, 2 };
	private static final int[] SLOTS_DOWN = new int[] { 3 };
	private static final int[] SLOTS_HORIZONTAL = new int[] { 0, 1, 2 };

	public static GrindingMillTileEntity basicTileEntity() {
		return new GrindingMillTileEntity(CoreTileEntityTypes.BASIC_GRINDING_MILL.get(), MachineTier.BASIC);
	}

	public static GrindingMillTileEntity intermediateTileEntity() {
		return new GrindingMillTileEntity(CoreTileEntityTypes.INTERMEDIATE_GRINDING_MILL.get(), MachineTier.INTERMEDIATE);
	}

	public static GrindingMillTileEntity advancedTileEntity() {
		return new GrindingMillTileEntity(CoreTileEntityTypes.ADVANCED_GRINDING_MILL.get(), MachineTier.ADVANCED);
	}

	public static GrindingMillTileEntity expertTileEntity() {
		return new GrindingMillTileEntity(CoreTileEntityTypes.EXPERT_GRINDING_MILL.get(), MachineTier.EXPERT);
	}

	public GrindingMillTileEntity(TileEntityType<GrindingMillTileEntity> tileEntityType, MachineTier tier) {
		super(tileEntityType, tier, 4, 600, CoreRecipeTypes.GRINDING_MILL);
	}

	@Override
	protected boolean canCombine(@Nullable BaseMachineRecipe recipeIn) {
		if (!this.items.get(0).isEmpty() && !this.items.get(1).isEmpty() && recipeIn != null) {
			ItemStack itemstack = recipeIn.getRecipeOutput();
			if (itemstack.isEmpty() || !AssortedCoreAPI.allowedInGrindingMillToolSlot(this.items.get(1))) {
				return false;
			} else {
				ItemStack outputSlot = this.items.get(this.outputSlot());
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
			GrindingMillRecipe millRecipe = (GrindingMillRecipe) recipe;
			ItemStack ingredient = this.items.get(0);
			ItemStack toolSlot = this.items.get(1);
			ItemStack itemstack1 = recipe.getRecipeOutput();
			ItemStack outputSlot = this.items.get(this.outputSlot());
			if (outputSlot.isEmpty()) {
				this.items.set(this.outputSlot(), itemstack1.copy());
			} else if (outputSlot.getItem() == itemstack1.getItem()) {
				outputSlot.grow(itemstack1.getCount());
			}

			if (!this.world.isRemote) {
				this.setRecipeUsed(recipe);
			}

			ingredient.shrink(millRecipe.getIngredient().getCount());

			if (toolSlot.attemptDamageItem(1, this.getWorld().rand, (ServerPlayerEntity) null)) {
				this.items.set(1, ItemStack.EMPTY);
			}

			if (CoreConfig.COMMON.grindingMillBreakSound.get()) {
				Block b = Block.getBlockFromItem(ingredient.getItem());
				if (b != null && b != Blocks.AIR) {
					SoundType soundtype = b.getSoundType(b.getDefaultState());
					this.getWorld().playSound((PlayerEntity) null, this.getPos(), soundtype.getBreakSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
				}
			}
		}
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		return new GrindingMillContainer(windowId, playerInventory, this, this.machineData);
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent(AssortedCore.MODID + ".container.grinding_mill");
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

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == this.outputSlot()) {
			return false;
		} else if (index != this.fuelSlot()) {
			if (index == 1) {
				return AssortedCoreAPI.allowedInGrindingMillToolSlot(stack);
			} else {
				return AssortedCoreAPI.isValidGrindingMillInput(stack);
			}
		} else {
			return getBurnTime(stack) > 0;
		}
	}
}
