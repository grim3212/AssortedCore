package com.grim3212.assorted.core.platform;

import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.platform.services.IMachineHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;

public class FabricMachineHelper implements IMachineHelper {
    @Override
    public boolean allowedInGrindingMillToolSlot(ItemStack stack) {
        if (stack.is(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS))
            return true;

        if (stack.getItem() instanceof TieredItem itemTier) {
            return itemTier.getTier().getLevel() >= 2;
        }

        return false;
    }
}
