package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class BaseMachineContainer extends AbstractContainerMenu {

    protected final ContainerData machineData;
    protected final Level world;
    protected final RecipeType<? extends BaseMachineRecipe> recipeType;
    private final Container machineInventory;

    public BaseMachineContainer(MenuType<? extends BaseMachineContainer> containerType, RecipeType<? extends BaseMachineRecipe> recipeType, int id, Inventory playerInventory, int slots, Container machineInventory, ContainerData machineData) {
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
    public abstract ItemStack quickMoveStack(Player playerIn, int index);

    @Override
    public boolean stillValid(Player playerIn) {
        return this.machineInventory.stillValid(playerIn);
    }

    protected boolean hasRecipe(ItemStack stack) {
        return this.world.getRecipeManager().getAllRecipesFor((RecipeType<BaseMachineRecipe>) this.recipeType).stream().anyMatch((recipe) -> {
            return recipe.validInput(stack);
        });
    }

    public abstract int getCookProgressionScaled();

    public abstract int getBurnLeftScaled();

    public boolean isBurning() {
        return this.machineData.get(0) > 0;
    }

}