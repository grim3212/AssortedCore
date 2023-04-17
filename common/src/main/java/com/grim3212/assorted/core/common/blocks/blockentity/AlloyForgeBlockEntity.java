package com.grim3212.assorted.core.common.blocks.blockentity;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.api.machines.MachineUtil;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class AlloyForgeBlockEntity extends BaseMachineBlockEntity {

    public AlloyForgeBlockEntity(BlockEntityType<AlloyForgeBlockEntity> tileEntityType, BlockPos pos, BlockState state, MachineTier tier) {
        super(tileEntityType, pos, state, tier, 4, 400, CoreRecipeTypes.ALLOY_FORGE.get());
    }

    public static AlloyForgeBlockEntity basicBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyForgeBlockEntity(CoreBlockEntityTypes.BASIC_ALLOY_FORGE.get(), pos, state, MachineTier.BASIC);
    }

    public static AlloyForgeBlockEntity intermediateBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyForgeBlockEntity(CoreBlockEntityTypes.INTERMEDIATE_ALLOY_FORGE.get(), pos, state, MachineTier.INTERMEDIATE);
    }

    public static AlloyForgeBlockEntity advancedBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyForgeBlockEntity(CoreBlockEntityTypes.ADVANCED_ALLOY_FORGE.get(), pos, state, MachineTier.ADVANCED);
    }

    public static AlloyForgeBlockEntity expertBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyForgeBlockEntity(CoreBlockEntityTypes.EXPERT_ALLOY_FORGE.get(), pos, state, MachineTier.EXPERT);
    }

    @Override
    protected boolean canCombine(@Nullable BaseMachineRecipe recipeIn) {
        if (!this.items.get(0).isEmpty() && !this.items.get(1).isEmpty() && recipeIn != null) {
            ItemStack itemstack = recipeIn.getResultItem(this.level.registryAccess());
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack outputSlot = this.items.get(outputSlot());
                if (outputSlot.isEmpty()) {
                    return true;
                } else if (!outputSlot.sameItem(itemstack)) {
                    return false;
                } else if (outputSlot.getCount() + itemstack.getCount() <= this.getInventory(null).getSlotLimit(outputSlot()) && outputSlot.getCount() + itemstack.getCount() <= outputSlot.getMaxStackSize()) {
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
            ItemStack itemstack1 = recipe.getResultItem(this.level.registryAccess());
            ItemStack outputSlot = this.items.get(this.outputSlot());
            if (outputSlot.isEmpty()) {
                this.items.set(this.outputSlot(), itemstack1.copy());
            } else if (outputSlot.getItem() == itemstack1.getItem()) {
                outputSlot.grow(itemstack1.getCount());
            }

            this.setRecipeUsed(recipe);

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
    public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
        return new AlloyForgeContainer(windowId, playerInventory, this.getInventory(null), this.machineData);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(Constants.MOD_ID + ".container.alloy_forge");
    }


    private static final int[] SLOTS = new int[]{0, 1, 2};
    private static final int[] SLOTS_DOWN = new int[]{3};
    private static final List<Integer> INPUT_SLOTS = NonNullList.of(0, 1);

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_DOWN;
        } else {
            return SLOTS;
        }
    }

    @Override
    public List<Integer> inputSlots() {
        return INPUT_SLOTS;
    }

    @Override
    public int fuelSlot() {
        return 2;
    }

    @Override
    public int outputSlot() {
        return 3;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        if (index == this.outputSlot()) {
            return false;
        } else if (index != this.fuelSlot()) {
            return MachineUtil.isValidAlloyForgeInput(this.level.getRecipeManager(), stack);
        } else {
            return getBurnTime(stack) > 0;
        }
    }
}
