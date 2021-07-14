package com.grim3212.assorted.core.common.block;

import java.util.Random;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import net.minecraft.block.AbstractBlock.Properties;

public class CoreOreBlock extends OreBlock {

	public CoreOreBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected int xpOnDrop(Random rand) {
		if (this == CoreBlocks.RUBY_ORE.get()) {
			return MathHelper.nextInt(rand, 3, 7);
		} else if (this == CoreBlocks.AMETHYST_ORE.get()) {
			return MathHelper.nextInt(rand, 2, 5);
		} else if (this == CoreBlocks.SAPPHIRE_ORE.get()) {
			return MathHelper.nextInt(rand, 3, 7);
		} else if (this == CoreBlocks.TOPAZ_ORE.get()) {
			return MathHelper.nextInt(rand, 2, 5);
		} else {
			return 0;
		}
	}
}
