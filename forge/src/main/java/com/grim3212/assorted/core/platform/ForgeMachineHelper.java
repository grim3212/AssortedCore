package com.grim3212.assorted.core.platform;

import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.platform.services.IMachineHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolActions;

public class ForgeMachineHelper implements IMachineHelper {
    @Override
    public boolean allowedInGrindingMillToolSlot(ItemStack stack) {
        if (stack.is(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS))
            return true;

        if (stack.getItem() instanceof TieredItem itemTier) {
            if (stack.getItem().canPerformAction(stack, ToolActions.PICKAXE_DIG)) {
                if (TierSortingRegistry.isTierSorted(itemTier.getTier())) {
                    // Iron is our benchmark so the tools should be greater than iron at least
                    return TierSortingRegistry.getTiersLowerThan(itemTier.getTier()).contains(Tiers.IRON);
                } else {
                    // Fallback to old method of determining if a pick is the correct level
                    return itemTier.getTier().getLevel() >= 2;
                }
            }
        }
        return false;
    }
}
