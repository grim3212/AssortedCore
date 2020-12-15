package com.grim3212.assorted.core.api.energy;

import net.minecraftforge.energy.EnergyStorage;

public class CoreEnergyStorage extends EnergyStorage {

	public CoreEnergyStorage(int capacity) {
		super(capacity);
	}

	public CoreEnergyStorage(int capacity, int maxTransfer) {
		super(capacity, maxTransfer);
	}

	public CoreEnergyStorage(int capacity, int maxReceive, int maxExtract) {
		super(capacity, maxReceive, maxExtract);
	}

	public CoreEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
		super(capacity, maxReceive, maxExtract, energy);
	}

	@Override
	public int receiveEnergy(final int maxReceive, final boolean simulate) {
		if (!this.canReceive()) {
			return 0;
		}

		final int energyReceived = Math.min(this.capacity - this.getEnergyStored(), Math.min(this.maxReceive, maxReceive));
		if (!simulate) {
			this.setEnergyStored(this.getEnergyStored() + energyReceived, false);
			this.onEnergyChanged();
		}
		return energyReceived;
	}

	@Override
	public int extractEnergy(final int maxExtract, final boolean simulate) {
		if (!this.canExtract()) {
			return 0;
		}

		final int energyExtracted = Math.min(this.getEnergyStored(), Math.min(this.maxExtract, maxExtract));
		if (!simulate) {
			this.setEnergyStored(this.getEnergyStored() - energyExtracted, false);
		}
		return energyExtracted;
	}

	public int setEnergyStored(final int energy, final boolean simulate) {
		this.onEnergyChanged();
		final int toSet = Math.min(energy, this.getMaxEnergyStored());
		if (!simulate) {
			this.energy = toSet;
		}
		return toSet;
	}

	public void onEnergyChanged() {
	}
}
