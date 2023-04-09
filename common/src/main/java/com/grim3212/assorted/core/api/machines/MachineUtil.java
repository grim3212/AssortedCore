package com.grim3212.assorted.core.api.machines;

import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.lib.platform.Services;
import com.grim3212.assorted.lib.platform.services.IPlatformHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeManager;

public class MachineUtil {

    public static boolean allowedInGrindingMillToolSlot(ItemStack stack) {
        if (stack.is(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS))
            return true;

        return Services.PLATFORM.isTieredTool(stack, Tiers.IRON, IPlatformHelper.ToolType.PICKAXE);
    }

    public static boolean isValidAlloyForgeInput(RecipeManager manager, ItemStack stack) {
        return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.ALLOY_FORGE.get()).stream().anyMatch((recipe) -> recipe.validItem(stack));
    }

    public static boolean isValidGrindingMillInput(RecipeManager manager, ItemStack stack) {
        return manager == null ? false : manager.getAllRecipesFor(CoreRecipeTypes.GRINDING_MILL.get()).stream().anyMatch((recipe) -> recipe.validItem(stack));
    }
}
