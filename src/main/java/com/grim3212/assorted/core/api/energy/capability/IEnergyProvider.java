package com.grim3212.assorted.core.api.energy.capability;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.grim3212.assorted.core.api.energy.CoreEnergyStorage;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public interface IEnergyProvider extends ICapabilitySerializable<CompoundNBT> {

	BlockPos getProviderPosition();

	World getProviderWorld();

	@Nonnull
	CoreEnergyStorage getProviderEnergy();

	@Override
	default CompoundNBT serializeNBT() {
		final CompoundNBT compound = new CompoundNBT();
		compound.putInt("energy", getProviderEnergy().getEnergyStored());
		return compound;
	}

	@Override
	default void deserializeNBT(CompoundNBT nbt) {
		if (nbt.contains("energy")) {
			this.getProviderEnergy().setEnergyStored(nbt.getInt("energy"), false);
		}
	}

	default void transferEnergyToAllAround() {
		if (!canTransferEnergyToAllAround()) {
			return;
		}

		getConnectedSides().forEach(side -> {
			transferEnergyTo(side, (int) ((float) getProviderEnergy().getEnergyStored() / (float) getConnectedSides().size()), false);
		});

	}

	default boolean canTransferEnergyToAllAround() {
		if (getProviderWorld() == null || getProviderWorld().isRemote) {
			return false;
		}

		if (!getProviderEnergy().canExtract()) {
			return false;
		}

		if (getProviderEnergy().getEnergyStored() <= 0) {
			return false;
		}
		return true;
	}

	default List<Direction> getConnectedSides() {
		final List<Direction> connectedSides = new ArrayList<>();

		for (final Direction side : Direction.values()) {
			if (isConnectedTo(side)) {
				connectedSides.add(side);
			}
		}

		return connectedSides;
	}

	default boolean isConnectedTo(final Direction side) {
		if (getProviderWorld() == null) {
			return false;
		}

		final TileEntity tile = this.getProviderWorld().getTileEntity(getProviderPosition().offset(side));

		if (tile == null) {
			return false;
		}

		return tile.getCapability(CapabilityEnergy.ENERGY, side.getOpposite()) != null;
	}

	default int transferEnergyTo(final Direction side, final int energyToTransfer, final boolean simulate) {
		if (!canTransferEnergyTo(side, energyToTransfer)) {
			return 0;
		}
		final IEnergyStorage storage = getProviderWorld().getTileEntity(getProviderPosition().offset(side)).getCapability(CapabilityEnergy.ENERGY, side.getOpposite()).orElse(null);
		if (storage == null) {
			return 0;
		}
		return getProviderEnergy().extractEnergy(storage.receiveEnergy(energyToTransfer, simulate), simulate);
	}

	default boolean canTransferEnergyTo(final Direction side, final int energyToTransfer) {
		if (!getProviderEnergy().canExtract()) {
			return false;
		}

		if (getProviderWorld() == null || getProviderWorld().isRemote) {
			return false;
		}

		if (getProviderWorld().getTileEntity(getProviderPosition().offset(side)) == null) {
			return false;
		}

		final IEnergyStorage storage = getProviderWorld().getTileEntity(getProviderPosition().offset(side)).getCapability(CapabilityEnergy.ENERGY, side.getOpposite()).orElse(null);

		if (storage == null) {
			return false;
		}

		if (!storage.canReceive()) {
			return false;
		}

		return true;
	}
}
