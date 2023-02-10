package com.grim3212.assorted.core.common.creative;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class CoreCreativeTab {

    public static void registerTabs(final CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "tab"), builder -> builder.title(Component.translatable("itemGroup.assortedcore.tab")).icon(() -> new ItemStack(AssortedCoreBlocks.PLATINUM_ORE.get())).displayItems((enabledFlags, populator, hasPermissions) -> {
            populator.acceptAll(AssortedCoreItems.ITEMS.getEntries().stream().map(itm -> new ItemStack(itm.get())).toList());
        }));
    }

}
