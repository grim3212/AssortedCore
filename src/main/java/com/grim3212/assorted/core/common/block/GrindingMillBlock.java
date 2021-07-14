package com.grim3212.assorted.core.common.block;

import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.block.tileentity.GrindingMillTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import net.minecraft.block.AbstractBlock.Properties;

public class GrindingMillBlock extends BaseMachineBlock {

	private final MachineTier tier;

	public GrindingMillBlock(MachineTier tier, Properties properties) {
		super(properties);
		this.tier = tier;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		switch (this.tier) {
		case INTERMEDIATE:
			return GrindingMillTileEntity.intermediateTileEntity();
		case ADVANCED:
			return GrindingMillTileEntity.advancedTileEntity();
		case EXPERT:
			return GrindingMillTileEntity.expertTileEntity();
		case BASIC:
		default:
			return GrindingMillTileEntity.basicTileEntity();
		}
	}
}
