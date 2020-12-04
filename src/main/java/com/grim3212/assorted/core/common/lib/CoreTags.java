package com.grim3212.assorted.core.common.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class CoreTags {

	public static class Blocks {
		public static final IOptionalNamedTag<Block> ORES = forgeTag("ores");
		public static final IOptionalNamedTag<Block> ORES_TIN = forgeTag("ores/tin");
		public static final IOptionalNamedTag<Block> ORES_COPPER = forgeTag("ores/copper");
		public static final IOptionalNamedTag<Block> ORES_SILVER = forgeTag("ores/silver");
		public static final IOptionalNamedTag<Block> ORES_ALUMINUM = forgeTag("ores/aluminum");
		public static final IOptionalNamedTag<Block> ORES_NICKEL = forgeTag("ores/nickel");
		public static final IOptionalNamedTag<Block> ORES_PLATINUM = forgeTag("ores/platinum");
		public static final IOptionalNamedTag<Block> ORES_LEAD = forgeTag("ores/lead");
		public static final IOptionalNamedTag<Block> ORES_RUBY = forgeTag("ores/ruby");
		public static final IOptionalNamedTag<Block> ORES_AMETHYST = forgeTag("ores/amethyst");
		public static final IOptionalNamedTag<Block> ORES_SAPPHIRE = forgeTag("ores/sapphire");
		public static final IOptionalNamedTag<Block> ORES_TOPAZ = forgeTag("ores/topaz");

		private static IOptionalNamedTag<Block> forgeTag(String name) {
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}
	}

	public static class Items {
		public static final IOptionalNamedTag<Item> ORES = forgeTag("ores");
		public static final IOptionalNamedTag<Item> ORES_TIN = forgeTag("ores/tin");
		public static final IOptionalNamedTag<Item> ORES_COPPER = forgeTag("ores/copper");
		public static final IOptionalNamedTag<Item> ORES_SILVER = forgeTag("ores/silver");
		public static final IOptionalNamedTag<Item> ORES_ALUMINUM = forgeTag("ores/aluminum");
		public static final IOptionalNamedTag<Item> ORES_NICKEL = forgeTag("ores/nickel");
		public static final IOptionalNamedTag<Item> ORES_PLATINUM = forgeTag("ores/platinum");
		public static final IOptionalNamedTag<Item> ORES_LEAD = forgeTag("ores/lead");
		public static final IOptionalNamedTag<Item> ORES_RUBY = forgeTag("ores/ruby");
		public static final IOptionalNamedTag<Item> ORES_AMETHYST = forgeTag("ores/amethyst");
		public static final IOptionalNamedTag<Item> ORES_SAPPHIRE = forgeTag("ores/sapphire");
		public static final IOptionalNamedTag<Item> ORES_TOPAZ = forgeTag("ores/topaz");

		public static final IOptionalNamedTag<Item> GEMS = forgeTag("gems");
		public static final IOptionalNamedTag<Item> GEMS_RUBY = forgeTag("gems/ruby");
		public static final IOptionalNamedTag<Item> GEMS_AMETHYST = forgeTag("gems/amethyst");
		public static final IOptionalNamedTag<Item> GEMS_SAPPHIRE = forgeTag("gems/sapphire");
		public static final IOptionalNamedTag<Item> GEMS_TOPAZ = forgeTag("gems/topaz");

		private static IOptionalNamedTag<Item> forgeTag(String name) {
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}
	}
}
