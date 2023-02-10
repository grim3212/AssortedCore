package com.grim3212.assorted.core.common.capabilities;

import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.Nullable;

public class MachineBlockContainerWrapper extends InvWrapper implements ICapabilityProvider {
    private final LazyOptional<? extends IItemHandler>[] handlers;
    private final BaseMachineBlockEntity container;

    public MachineBlockContainerWrapper(BaseMachineBlockEntity inv) {
        super(inv);
        this.container = inv;
        handlers = SidedInvWrapper.create(inv, Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else if (facing == Direction.NORTH)
                return handlers[2].cast();
            else if (facing == Direction.SOUTH)
                return handlers[3].cast();
            else if (facing == Direction.WEST)
                return handlers[4].cast();
            else if (facing == Direction.EAST)
                return handlers[5].cast();
        }
        return LazyOptional.empty();
    }
}
