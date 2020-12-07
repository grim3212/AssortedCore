package com.grim3212.assorted.core.common.block;

import com.grim3212.assorted.core.common.block.tileentity.AlloyForgeTileEntity;
import com.grim3212.assorted.core.common.lib.MachineTier;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class AlloyForgeBlock extends BaseMachineBlock {

	private final MachineTier tier;

	public AlloyForgeBlock(MachineTier tier, Properties properties) {
		super(properties);
		this.tier = tier;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		switch (this.tier) {
		case INTERMEDIATE:
			return AlloyForgeTileEntity.intermediateAlloyForgeTileEntity();
		case ADVANCED:
			return AlloyForgeTileEntity.advancedAlloyForgeTileEntity();
		case EXPERT:
			return AlloyForgeTileEntity.expertAlloyForgeTileEntity();
		case BASIC:
		default:
			return AlloyForgeTileEntity.basicAlloyForgeTileEntity();
		}
	}
}
