package com.grim3212.assorted.core.common.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MachineResultSlot extends Slot {
    private final Player player;
    private int removeCount;

    public MachineResultSlot(Player player, Container inventoryIn, int slotIndex, int xPosition, int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        this.player = player;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }

        return super.remove(amount);
    }

    @Override
    public void onTake(Player player, ItemStack stack) {
        this.checkTakeAchievements(stack);
        super.onTake(player, stack);
    }

    @Override
    protected void onQuickCraft(ItemStack stack, int amount) {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }

    @Override
    protected void checkTakeAchievements(ItemStack stack) {
        stack.onCraftedBy(this.player.level, this.player, this.removeCount);
        // TODO: Fix this
//		if (!this.player.level.isClientSide && this.container instanceof BaseMachineBlockEntity) {
//			((BaseMachineBlockEntity) this.container).unlockRecipes(this.player);
//		}

        this.removeCount = 0;
    }

}
