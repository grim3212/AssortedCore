package com.grim3212.assorted.core.events;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AssortedCoreCreativeTab {

    private static final CreativeModeTab ASSORTED_CORE_GROUP = FabricItemGroup.builder(new ResourceLocation(Constants.MOD_ID, "tab")).icon(() -> new ItemStack(AssortedCoreBlocks.PLATINUM_ORE.get())).build();

    public static void init () {
        ItemGroupEvents.modifyEntriesEvent(AssortedCoreCreativeTab.ASSORTED_CORE_GROUP).register(entries -> {
            entries.acceptAll(AssortedCoreItems.ITEMS.getEntries().stream().map(itm -> new ItemStack(itm.get())).toList());
        });
    }


}
