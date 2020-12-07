package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.common.crafting.BaseMachineContainer;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraftforge.common.ForgeHooks;

public class AlloyForgeContainer extends BaseMachineContainer {

	protected AlloyForgeContainer(int id, PlayerInventory playerInventory) {
		this(id, playerInventory, new Inventory(4), new IntArray(4));
	}

	public AlloyForgeContainer(int id, PlayerInventory playerInventory, IInventory alloyForgeInventory, IIntArray alloyForgeData) {
		super(CoreContainerTypes.ALLOY_FORGE.get(), CoreRecipeTypes.ALLOY_FORGE, id, playerInventory, 4, alloyForgeInventory, alloyForgeData);

		this.addSlot(new Slot(alloyForgeInventory, 0, 32, 27));
		this.addSlot(new Slot(alloyForgeInventory, 1, 56, 27));
		this.addSlot(new MachineFuelSlot(alloyForgeInventory, 2, 80, 62));
		this.addSlot(new MachineResultSlot(playerInventory.player, alloyForgeInventory, 3, 115, 27));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 3) {
				if (!this.mergeItemStack(itemstack1, 4, 40, true)) {
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (index != 2 && index != 1 && index != 0) {
				if (this.hasRecipe(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 0, 2, false)) {
						return ItemStack.EMPTY;
					}
				} else if (ForgeHooks.getBurnTime(itemstack1) > 0) {
					if (!this.mergeItemStack(itemstack1, 2, 3, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 4 && index < 31) {
					if (!this.mergeItemStack(itemstack1, 31, 40, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 31 && index < 40 && !this.mergeItemStack(itemstack1, 4, 31, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 4, 40, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}

}
