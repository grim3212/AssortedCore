package com.grim3212.assorted.core.common.block;

import com.grim3212.assorted.core.common.block.tileentity.BurningGeneratorTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BurningGeneratorBlock extends Block {

	public BurningGeneratorBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new BurningGeneratorTileEntity();
	}

}
