package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipeSerializer;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipeSerializer;
import com.grim3212.assorted.core.common.crafting.CoreRecipeBookCategories;
import com.grim3212.assorted.core.common.crafting.CoreRecipeDisplays;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.handlers.CoreCreativeItems;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.core.common.worldgen.CoreBiomeModifiers;
import com.grim3212.assorted.core.config.CoreCommonConfig;
import com.grim3212.assorted.lib.crafting.SyncedRecipes;

public class CoreCommonMod {

    public static final CoreCommonConfig COMMON_CONFIG = new CoreCommonConfig();

    public static void init() {
        Constants.LOG.info(Constants.MOD_NAME + " starting up...");

        CoreBlocks.init();
        CoreItems.init();
        CoreBlockEntityTypes.init();
        CoreRecipeSerializers.init();
        CoreRecipeTypes.init();
        CoreRecipeBookCategories.init();
        CoreRecipeDisplays.init();
        CoreContainerTypes.init();
        CoreBiomeModifiers.init();
        CoreCreativeItems.init();

        // The machine screens, JEI and the manual all read whole recipes on the client.
        SyncedRecipes.require(CoreRecipeTypes.ALLOY_FORGE, AlloyForgeRecipeSerializer.INSTANCE);
        SyncedRecipes.require(CoreRecipeTypes.GRINDING_MILL, GrindingMillRecipeSerializer.INSTANCE);
    }
}
