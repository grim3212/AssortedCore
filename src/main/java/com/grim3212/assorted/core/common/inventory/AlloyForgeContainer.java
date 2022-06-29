package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;

public class AlloyForgeContainer extends BaseMachineContainer {

	protected AlloyForgeContainer(int id, Inventory playerInventory) {
		this(id, playerInventory, new SimpleContainer(4), new SimpleContainerData(4));
	}

	public AlloyForgeContainer(int id, Inventory playerInventory, Container alloyForgeInventory, ContainerData alloyForgeData) {
		super(CoreContainerTypes.ALLOY_FORGE.get(), CoreRecipeTypes.ALLOY_FORGE.get(), id, playerInventory, 4, alloyForgeInventory, alloyForgeData);

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
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == 3) {
				if (!this.moveItemStackTo(itemstack1, 4, 40, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (index != 2 && index != 1 && index != 0) {
				if (ForgeHooks.getBurnTime(itemstack1, null) > 0) {
					if (!this.moveItemStackTo(itemstack1, 2, 3, false)) {
						return ItemStack.EMPTY;
					}
				} else if (this.hasRecipe(itemstack1)) {
					if (!this.moveItemStackTo(itemstack1, 0, 2, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 4 && index < 31) {
					if (!this.moveItemStackTo(itemstack1, 31, 40, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 31 && index < 40 && !this.moveItemStackTo(itemstack1, 4, 31, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 4, 40, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getCookProgressionScaled() {
		int i = this.machineData.get(2);
		int j = this.machineData.get(3);
		return j != 0 && i != 0 ? i * 24 / j : 0;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getBurnLeftScaled() {
		int i = this.machineData.get(1);
		if (i == 0) {
			i = 200;
		}

		return this.machineData.get(0) * 13 / i;
	}
}
