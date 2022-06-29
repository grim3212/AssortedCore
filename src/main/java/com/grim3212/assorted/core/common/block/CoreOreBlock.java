package com.grim3212.assorted.core.common.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;

public class CoreOreBlock extends DropExperienceBlock {

	public CoreOreBlock(Properties properties) {
		super(properties);
	}

	public CoreOreBlock(Properties properties, UniformInt xpRange) {
		super(properties, xpRange);
	}
}
