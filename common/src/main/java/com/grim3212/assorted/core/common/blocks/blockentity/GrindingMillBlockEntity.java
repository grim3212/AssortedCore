package com.grim3212.assorted.core.common.blocks.blockentity;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.CoreCommonMod;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.api.machines.MachineUtil;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class GrindingMillBlockEntity extends BaseMachineBlockEntity {

    public GrindingMillBlockEntity(BlockEntityType<GrindingMillBlockEntity> tileEntityType, BlockPos pos, BlockState state, MachineTier tier) {
        super(tileEntityType, pos, state, tier, 4, 600, CoreRecipeTypes.GRINDING_MILL.get());
    }

    public static GrindingMillBlockEntity basicBlockEntity(BlockPos pos, BlockState state) {
        return new GrindingMillBlockEntity(CoreBlockEntityTypes.BASIC_GRINDING_MILL.get(), pos, state, MachineTier.BASIC);
    }

    public static GrindingMillBlockEntity intermediateBlockEntity(BlockPos pos, BlockState state) {
        return new GrindingMillBlockEntity(CoreBlockEntityTypes.INTERMEDIATE_GRINDING_MILL.get(), pos, state, MachineTier.INTERMEDIATE);
    }

    public static GrindingMillBlockEntity advancedBlockEntity(BlockPos pos, BlockState state) {
        return new GrindingMillBlockEntity(CoreBlockEntityTypes.ADVANCED_GRINDING_MILL.get(), pos, state, MachineTier.ADVANCED);
    }

    public static GrindingMillBlockEntity expertBlockEntity(BlockPos pos, BlockState state) {
        return new GrindingMillBlockEntity(CoreBlockEntityTypes.EXPERT_GRINDING_MILL.get(), pos, state, MachineTier.EXPERT);
    }

    @Override
    protected boolean canCombine(@Nullable BaseMachineRecipe recipeIn) {
        if (!this.items.get(0).isEmpty() && !this.items.get(1).isEmpty() && recipeIn != null) {
            ItemStack itemstack = recipeIn.getResultItem(this.level.registryAccess());
            if (itemstack.isEmpty() || !MachineUtil.allowedInGrindingMillToolSlot(this.items.get(1))) {
                return false;
            } else {
                ItemStack outputSlot = this.items.get(this.outputSlot());
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
            GrindingMillRecipe millRecipe = (GrindingMillRecipe) recipe;
            ItemStack ingredient = this.items.get(0);
            ItemStack toolSlot = this.items.get(1);
            ItemStack itemstack1 = recipe.getResultItem(this.level.registryAccess());
            ItemStack outputSlot = this.items.get(this.outputSlot());
            if (outputSlot.isEmpty()) {
                this.items.set(this.outputSlot(), itemstack1.copy());
            } else if (outputSlot.getItem() == itemstack1.getItem()) {
                outputSlot.grow(itemstack1.getCount());
            }

            this.setRecipeUsed(recipe);

            ingredient.shrink(millRecipe.getIngredient().getCount());

            if (toolSlot.hurt(1, this.getLevel().random, (ServerPlayer) null)) {
                this.items.set(1, ItemStack.EMPTY);
            }

            if (CoreCommonMod.COMMON_CONFIG.grindingMillHasBreakSound.get()) {
                Block b = Block.byItem(ingredient.getItem());
                if (b != null && b != Blocks.AIR) {
                    SoundType soundtype = b.getSoundType(b.defaultBlockState());
                    this.getLevel().playSound((Player) null, this.getBlockPos(), soundtype.getBreakSound(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                }
            }
        }
    }

    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
        return new GrindingMillContainer(windowId, playerInventory, this.getInventory(null), this.machineData);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(Constants.MOD_ID + ".container.grinding_mill");
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
            if (index == 1) {
                return MachineUtil.allowedInGrindingMillToolSlot(stack);
            } else {
                return MachineUtil.isValidGrindingMillInput(this.level.getRecipeManager(), stack);
            }
        } else {
            return getBurnTime(stack) > 0;
        }
    }
}
