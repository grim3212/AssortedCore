package com.grim3212.assorted.core.platform;

import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.services.IMachineHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.crafting.RecipeType;

public class FabricMachineHelper implements IMachineHelper {
    @Override
    public boolean allowedInGrindingMillToolSlot(ItemStack stack) {
        if (stack.is(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS))
            return true;

        if (stack.getItem() instanceof TieredItem itemTier) {
            return itemTier.getTier().getLevel() >= 2 && itemTier instanceof PickaxeItem;
        }

        return false;
    }

    @Override
    public int getFuelTime(ItemStack stack) {
        Integer fuelTime = FuelRegistry.INSTANCE.get(stack.getItem());
        return fuelTime != null ? fuelTime : 0;
    }
}
