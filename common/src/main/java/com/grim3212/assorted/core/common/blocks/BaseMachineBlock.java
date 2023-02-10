package com.grim3212.assorted.core.common.blocks;

import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import com.grim3212.assorted.core.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public abstract class BaseMachineBlock extends Block implements EntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public BaseMachineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ON, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide) {
            MenuProvider inamedcontainerprovider = this.getMenuProvider(state, worldIn, pos);
            if (inamedcontainerprovider != null) {
                Services.PLATFORM.openMenu((ServerPlayer) player, inamedcontainerprovider, buf -> buf.writeBlockPos(pos));
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        BlockEntity tileentity = world.getBlockEntity(pos);
        return tileentity instanceof MenuProvider ? (MenuProvider) tileentity : null;
    }

    @Override
    public abstract BlockEntity newBlockEntity(BlockPos pos, BlockState state);

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return (level1, blockPos, blockState, t) -> {
            if (t instanceof BaseMachineBlockEntity machine) {
                machine.tick();
            }
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof BaseMachineBlockEntity) {
                ((BaseMachineBlockEntity) tileentity).setCustomName(stack.getHoverName());
            }
        }

    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof BaseMachineBlockEntity) {
                Containers.dropContents(worldIn, pos, (BaseMachineBlockEntity) tileentity);
                ((BaseMachineBlockEntity) tileentity).grantStoredRecipeExperience(worldIn, Vec3.atCenterOf(pos));
                worldIn.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(worldIn.getBlockEntity(pos));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, ON);
    }
}