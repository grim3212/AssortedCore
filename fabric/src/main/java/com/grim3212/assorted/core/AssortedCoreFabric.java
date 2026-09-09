package com.grim3212.assorted.core;

import com.grim3212.assorted.core.common.blocks.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipeSerializer;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipeSerializer;
import com.grim3212.assorted.lib.core.inventory.IInventoryBlockEntity;
import com.grim3212.assorted.lib.inventory.FabricPlatformInventoryStorageHandlerSided;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;

public class AssortedCoreFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CoreCommonMod.init();

        // Vanilla stopped sending recipes to the client in 1.21.2, so a recipe type whose recipes are
        // needed client side has to opt in. Fabric's counterpart to NeoForge's
        // OnDatapackSyncEvent#sendRecipes is per serializer, and it handles the sending itself: the
        // recipes land in the client's own RecipeAccess, and ClientRecipeSynchronizedEvent tells the
        // client they arrived. Registered from the main entry point so it runs on both physical
        // sides - the client has to declare which serializers it can decode.
        RecipeSynchronization.synchronizeRecipeSerializer(AlloyForgeRecipeSerializer.INSTANCE);
        RecipeSynchronization.synchronizeRecipeSerializer(GrindingMillRecipeSerializer.INSTANCE);

        ItemStorage.SIDED.registerForBlockEntities((be, direction) ->
                {
                    if (be instanceof IInventoryBlockEntity inv)
                        return ((FabricPlatformInventoryStorageHandlerSided) inv.getStorageHandler()).getFabricInventory(direction);
                    return null;
                },
                CoreBlockEntityTypes.BASIC_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.BASIC_GRINDING_MILL.get(),
                CoreBlockEntityTypes.INTERMEDIATE_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.INTERMEDIATE_GRINDING_MILL.get(),
                CoreBlockEntityTypes.ADVANCED_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.ADVANCED_GRINDING_MILL.get(),
                CoreBlockEntityTypes.EXPERT_ALLOY_FORGE.get(),
                CoreBlockEntityTypes.EXPERT_GRINDING_MILL.get()
        );
    }
}
