package com.grim3212.assorted.core.common.blocks;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;

public class CoreOreBlock extends DropExperienceBlock {

    public CoreOreBlock(Properties properties) {
        super(ConstantInt.of(0), properties);
    }

    public CoreOreBlock(Properties properties, UniformInt xpRange) {
        super(xpRange, properties);
    }
}
