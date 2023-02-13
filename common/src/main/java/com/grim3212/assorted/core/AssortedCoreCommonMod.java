package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.items.CoreItems;

public class AssortedCoreCommonMod {
    public static void init() {
        CoreBlocks.init();
        CoreItems.init();
        CoreBlockEntityTypes.init();
        CoreRecipeSerializers.init();
        CoreRecipeTypes.init();
        CoreContainerTypes.init();
    }
}
