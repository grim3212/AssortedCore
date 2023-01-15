package com.grim3212.assorted.core.common.creative;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class CoreCreativeTab {

	public static void registerTabs(final CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(AssortedCore.MODID, "tab"), builder -> builder.title(Component.translatable("itemGroup.assortedcore")).icon(() -> new ItemStack(CoreBlocks.PLATINUM_ORE.get())).displayItems((enabledFlags, populator, hasPermissions) -> {
			populator.acceptAll(CoreItems.ITEMS.getEntries().stream().map(itm -> new ItemStack(itm.get())).toList());
		}));
	}

}
