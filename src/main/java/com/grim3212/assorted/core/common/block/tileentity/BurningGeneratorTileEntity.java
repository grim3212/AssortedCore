package com.grim3212.assorted.core.common.block.tileentity;

import javax.annotation.Nonnull;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.energy.CoreEnergyStorage;
import com.grim3212.assorted.core.api.energy.capability.IEnergyProvider;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

public class BurningGeneratorTileEntity extends TileEntity implements ITickableTileEntity, IEnergyProvider {

	@Nonnull
	private CoreEnergyStorage storage = new CoreEnergyStorage(1000, 100);

	public BurningGeneratorTileEntity() {
		super(CoreTileEntityTypes.BURNING_GENERATOR.get());
	}

	@Override
	public void tick() {
		this.storage.receiveEnergy(100, false);

		this.transferEnergyToAllAround();

		AssortedCore.LOGGER.info("stored energy :? " + this.storage.getEnergyStored() + " / " + this.storage.getMaxEnergyStored());
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityEnergy.ENERGY)
			return LazyOptional.of(() -> this.storage).cast();
		return super.getCapability(cap, side);
	}

	@Override
	public BlockPos getProviderPosition() {
		return this.getPos();
	}

	@Override
	public World getProviderWorld() {
		return this.getWorld();
	}

	@Nonnull
	@Override
	public CoreEnergyStorage getProviderEnergy() {
		return this.storage;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		this.writePacketNBT(compound);
		return compound;
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		this.readPacketNBT(nbt);
	}

	public void writePacketNBT(CompoundNBT cmp) {
		cmp.put("energy", IEnergyProvider.super.serializeNBT());
	}

	public void readPacketNBT(CompoundNBT cmp) {
		IEnergyProvider.super.deserializeNBT(cmp.getCompound("energy"));
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return write(new CompoundNBT());
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		writePacketNBT(nbtTagCompound);
		return new SUpdateTileEntityPacket(this.pos, 1, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.readPacketNBT(pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = super.serializeNBT();
		nbt.put("energy", IEnergyProvider.super.serializeNBT());
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		super.deserializeNBT(nbt);
		IEnergyProvider.super.deserializeNBT(nbt.getCompound("energy"));
	}
}