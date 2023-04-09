package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.handlers.CoreCreativeItems;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.core.common.worldgen.CoreBiomeModifiers;
import com.grim3212.assorted.core.config.CoreCommonConfig;

public class CoreCommonMod {

    public static final CoreCommonConfig COMMON_CONFIG = new CoreCommonConfig();

    public static void init() {
        Constants.LOG.info(Constants.MOD_NAME + " starting up...");

        CoreBlocks.init();
        CoreItems.init();
        CoreBlockEntityTypes.init();
        CoreRecipeSerializers.init();
        CoreRecipeTypes.init();
        CoreContainerTypes.init();
        CoreBiomeModifiers.init();
        CoreCreativeItems.init();
    }
}
