package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;

public class AssortedCoreCommonMod {
    public static void init() {
        AssortedCoreBlocks.init();
        AssortedCoreItems.init();
        CoreBlockEntityTypes.init();
        CoreRecipeSerializers.init();
        CoreRecipeTypes.init();
        CoreContainerTypes.init();
    }
}
