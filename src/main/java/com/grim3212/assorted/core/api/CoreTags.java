package com.grim3212.assorted.core.api;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CoreTags {

	public static class Blocks {
		public static final TagKey<Block> ORES = forgeTag("ores");
		public static final TagKey<Block> ORES_TIN = forgeTag("ores/tin");
		public static final TagKey<Block> ORES_COPPER = forgeTag("ores/copper");
		public static final TagKey<Block> ORES_SILVER = forgeTag("ores/silver");
		public static final TagKey<Block> ORES_ALUMINUM = forgeTag("ores/aluminum");
		public static final TagKey<Block> ORES_NICKEL = forgeTag("ores/nickel");
		public static final TagKey<Block> ORES_PLATINUM = forgeTag("ores/platinum");
		public static final TagKey<Block> ORES_LEAD = forgeTag("ores/lead");
		public static final TagKey<Block> ORES_RUBY = forgeTag("ores/ruby");
		public static final TagKey<Block> ORES_PERIDOT = forgeTag("ores/peridot");
		public static final TagKey<Block> ORES_SAPPHIRE = forgeTag("ores/sapphire");
		public static final TagKey<Block> ORES_TOPAZ = forgeTag("ores/topaz");

		public static final TagKey<Block> STORAGE_BLOCKS = forgeTag("storage_blocks");
		public static final TagKey<Block> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
		public static final TagKey<Block> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");
		public static final TagKey<Block> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");
		public static final TagKey<Block> STORAGE_BLOCKS_ALUMINUM = forgeTag("storage_blocks/aluminum");
		public static final TagKey<Block> STORAGE_BLOCKS_NICKEL = forgeTag("storage_blocks/nickel");
		public static final TagKey<Block> STORAGE_BLOCKS_PLATINUM = forgeTag("storage_blocks/platinum");
		public static final TagKey<Block> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
		public static final TagKey<Block> STORAGE_BLOCKS_RUBY = forgeTag("storage_blocks/ruby");
		public static final TagKey<Block> STORAGE_BLOCKS_PERIDOT = forgeTag("storage_blocks/peridot");
		public static final TagKey<Block> STORAGE_BLOCKS_SAPPHIRE = forgeTag("storage_blocks/sapphire");
		public static final TagKey<Block> STORAGE_BLOCKS_TOPAZ = forgeTag("storage_blocks/topaz");
		public static final TagKey<Block> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");
		public static final TagKey<Block> STORAGE_BLOCKS_ELECTRUM = forgeTag("storage_blocks/electrum");
		public static final TagKey<Block> STORAGE_BLOCKS_INVAR = forgeTag("storage_blocks/invar");
		public static final TagKey<Block> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");

		public static final TagKey<Block> RAW_STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/raw_tin");
		public static final TagKey<Block> RAW_STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/raw_copper");
		public static final TagKey<Block> RAW_STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/raw_silver");
		public static final TagKey<Block> RAW_STORAGE_BLOCKS_ALUMINUM = forgeTag("storage_blocks/raw_aluminum");
		public static final TagKey<Block> RAW_STORAGE_BLOCKS_NICKEL = forgeTag("storage_blocks/raw_nickel");
		public static final TagKey<Block> RAW_STORAGE_BLOCKS_PLATINUM = forgeTag("storage_blocks/raw_platinum");
		public static final TagKey<Block> RAW_STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/raw_lead");

		private static TagKey<Block> forgeTag(String name) {
			return BlockTags.create(new ResourceLocation("forge", name));
		}
	}

	public static class Items {
		public static final TagKey<Item> GRINDING_MILL_ALLOWED_TOOLS = ItemTags.create(new ResourceLocation(AssortedCore.MODID, "grinding_mill_allowed_tools"));

		public static final TagKey<Item> ORES = forgeTag("ores");
		public static final TagKey<Item> ORES_TIN = forgeTag("ores/tin");
		public static final TagKey<Item> ORES_COPPER = forgeTag("ores/copper");
		public static final TagKey<Item> ORES_SILVER = forgeTag("ores/silver");
		public static final TagKey<Item> ORES_ALUMINUM = forgeTag("ores/aluminum");
		public static final TagKey<Item> ORES_NICKEL = forgeTag("ores/nickel");
		public static final TagKey<Item> ORES_PLATINUM = forgeTag("ores/platinum");
		public static final TagKey<Item> ORES_LEAD = forgeTag("ores/lead");
		public static final TagKey<Item> ORES_RUBY = forgeTag("ores/ruby");
		public static final TagKey<Item> ORES_PERIDOT = forgeTag("ores/peridot");
		public static final TagKey<Item> ORES_SAPPHIRE = forgeTag("ores/sapphire");
		public static final TagKey<Item> ORES_TOPAZ = forgeTag("ores/topaz");

		public static final TagKey<Item> STORAGE_BLOCKS = forgeTag("storage_blocks");
		public static final TagKey<Item> STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/tin");
		public static final TagKey<Item> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");
		public static final TagKey<Item> STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/silver");
		public static final TagKey<Item> STORAGE_BLOCKS_ALUMINUM = forgeTag("storage_blocks/aluminum");
		public static final TagKey<Item> STORAGE_BLOCKS_NICKEL = forgeTag("storage_blocks/nickel");
		public static final TagKey<Item> STORAGE_BLOCKS_PLATINUM = forgeTag("storage_blocks/platinum");
		public static final TagKey<Item> STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/lead");
		public static final TagKey<Item> STORAGE_BLOCKS_RUBY = forgeTag("storage_blocks/ruby");
		public static final TagKey<Item> STORAGE_BLOCKS_PERIDOT = forgeTag("storage_blocks/peridot");
		public static final TagKey<Item> STORAGE_BLOCKS_SAPPHIRE = forgeTag("storage_blocks/sapphire");
		public static final TagKey<Item> STORAGE_BLOCKS_TOPAZ = forgeTag("storage_blocks/topaz");
		public static final TagKey<Item> STORAGE_BLOCKS_BRONZE = forgeTag("storage_blocks/bronze");
		public static final TagKey<Item> STORAGE_BLOCKS_ELECTRUM = forgeTag("storage_blocks/electrum");
		public static final TagKey<Item> STORAGE_BLOCKS_INVAR = forgeTag("storage_blocks/invar");
		public static final TagKey<Item> STORAGE_BLOCKS_STEEL = forgeTag("storage_blocks/steel");

		public static final TagKey<Item> RAW_STORAGE_BLOCKS_TIN = forgeTag("storage_blocks/raw_tin");
		public static final TagKey<Item> RAW_STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/raw_copper");
		public static final TagKey<Item> RAW_STORAGE_BLOCKS_SILVER = forgeTag("storage_blocks/raw_silver");
		public static final TagKey<Item> RAW_STORAGE_BLOCKS_ALUMINUM = forgeTag("storage_blocks/raw_aluminum");
		public static final TagKey<Item> RAW_STORAGE_BLOCKS_NICKEL = forgeTag("storage_blocks/raw_nickel");
		public static final TagKey<Item> RAW_STORAGE_BLOCKS_PLATINUM = forgeTag("storage_blocks/raw_platinum");
		public static final TagKey<Item> RAW_STORAGE_BLOCKS_LEAD = forgeTag("storage_blocks/raw_lead");

		public static final TagKey<Item> INGOTS = forgeTag("ingots");
		public static final TagKey<Item> INGOTS_TIN = forgeTag("ingots/tin");
		public static final TagKey<Item> INGOTS_COPPER = forgeTag("ingots/copper");
		public static final TagKey<Item> INGOTS_SILVER = forgeTag("ingots/silver");
		public static final TagKey<Item> INGOTS_ALUMINUM = forgeTag("ingots/aluminum");
		public static final TagKey<Item> INGOTS_NICKEL = forgeTag("ingots/nickel");
		public static final TagKey<Item> INGOTS_PLATINUM = forgeTag("ingots/platinum");
		public static final TagKey<Item> INGOTS_LEAD = forgeTag("ingots/lead");
		public static final TagKey<Item> INGOTS_BRONZE = forgeTag("ingots/bronze");
		public static final TagKey<Item> INGOTS_ELECTRUM = forgeTag("ingots/electrum");
		public static final TagKey<Item> INGOTS_INVAR = forgeTag("ingots/invar");
		public static final TagKey<Item> INGOTS_STEEL = forgeTag("ingots/steel");

		public static final TagKey<Item> NUGGETS = forgeTag("nuggets");
		public static final TagKey<Item> NUGGETS_TIN = forgeTag("nuggets/tin");
		public static final TagKey<Item> NUGGETS_COPPER = forgeTag("nuggets/copper");
		public static final TagKey<Item> NUGGETS_SILVER = forgeTag("nuggets/silver");
		public static final TagKey<Item> NUGGETS_ALUMINUM = forgeTag("nuggets/aluminum");
		public static final TagKey<Item> NUGGETS_NICKEL = forgeTag("nuggets/nickel");
		public static final TagKey<Item> NUGGETS_PLATINUM = forgeTag("nuggets/platinum");
		public static final TagKey<Item> NUGGETS_LEAD = forgeTag("nuggets/lead");
		public static final TagKey<Item> NUGGETS_BRONZE = forgeTag("nuggets/bronze");
		public static final TagKey<Item> NUGGETS_ELECTRUM = forgeTag("nuggets/electrum");
		public static final TagKey<Item> NUGGETS_INVAR = forgeTag("nuggets/invar");
		public static final TagKey<Item> NUGGETS_STEEL = forgeTag("nuggets/steel");

		public static final TagKey<Item> DUSTS = forgeTag("dusts");
		public static final TagKey<Item> DUSTS_TIN = forgeTag("dusts/tin");
		public static final TagKey<Item> DUSTS_COPPER = forgeTag("dusts/copper");
		public static final TagKey<Item> DUSTS_SILVER = forgeTag("dusts/silver");
		public static final TagKey<Item> DUSTS_ALUMINUM = forgeTag("dusts/aluminum");
		public static final TagKey<Item> DUSTS_NICKEL = forgeTag("dusts/nickel");
		public static final TagKey<Item> DUSTS_PLATINUM = forgeTag("dusts/platinum");
		public static final TagKey<Item> DUSTS_LEAD = forgeTag("dusts/lead");
		public static final TagKey<Item> DUSTS_BRONZE = forgeTag("dusts/bronze");
		public static final TagKey<Item> DUSTS_ELECTRUM = forgeTag("dusts/electrum");
		public static final TagKey<Item> DUSTS_INVAR = forgeTag("dusts/invar");
		public static final TagKey<Item> DUSTS_STEEL = forgeTag("dusts/steel");
		public static final TagKey<Item> DUSTS_IRON = forgeTag("dusts/iron");
		public static final TagKey<Item> DUSTS_GOLD = forgeTag("dusts/gold");

		public static final TagKey<Item> GEMS = forgeTag("gems");
		public static final TagKey<Item> GEMS_RUBY = forgeTag("gems/ruby");
		public static final TagKey<Item> GEMS_PERIDOT = forgeTag("gems/peridot");
		public static final TagKey<Item> GEMS_SAPPHIRE = forgeTag("gems/sapphire");
		public static final TagKey<Item> GEMS_TOPAZ = forgeTag("gems/topaz");

		public static final TagKey<Item> GEARS = forgeTag("gear");
		public static final TagKey<Item> GEARS_TIN = forgeTag("gear/tin");
		public static final TagKey<Item> GEARS_COPPER = forgeTag("gear/copper");
		public static final TagKey<Item> GEARS_SILVER = forgeTag("gear/silver");
		public static final TagKey<Item> GEARS_ALUMINUM = forgeTag("gear/aluminum");
		public static final TagKey<Item> GEARS_NICKEL = forgeTag("gear/nickel");
		public static final TagKey<Item> GEARS_PLATINUM = forgeTag("gear/platinum");
		public static final TagKey<Item> GEARS_LEAD = forgeTag("gear/lead");
		public static final TagKey<Item> GEARS_BRONZE = forgeTag("gear/bronze");
		public static final TagKey<Item> GEARS_ELECTRUM = forgeTag("gear/electrum");
		public static final TagKey<Item> GEARS_INVAR = forgeTag("gear/invar");
		public static final TagKey<Item> GEARS_STEEL = forgeTag("gear/steel");
		public static final TagKey<Item> GEARS_IRON = forgeTag("gear/iron");
		public static final TagKey<Item> GEARS_GOLD = forgeTag("gear/gold");
		
		public static final TagKey<Item> RAW_MATERIALS = forgeTag("raw_materials");
		public static final TagKey<Item> RAW_MATERIALS_TIN = forgeTag("raw_materials/tin");
		public static final TagKey<Item> RAW_MATERIALS_SILVER = forgeTag("raw_materials/silver");
		public static final TagKey<Item> RAW_MATERIALS_ALUMINUM = forgeTag("raw_materials/aluminum");
		public static final TagKey<Item> RAW_MATERIALS_NICKEL = forgeTag("raw_materials/nickel");
		public static final TagKey<Item> RAW_MATERIALS_PLATINUM = forgeTag("raw_materials/platinum");
		public static final TagKey<Item> RAW_MATERIALS_LEAD = forgeTag("raw_materials/lead");
		public static final TagKey<Item> RAW_MATERIALS_IRON = forgeTag("raw_materials/iron");
		public static final TagKey<Item> RAW_MATERIALS_GOLD = forgeTag("raw_materials/gold");
		public static final TagKey<Item> RAW_MATERIALS_COPPER = forgeTag("raw_materials/copper");

		private static TagKey<Item> forgeTag(String name) {
			return ItemTags.create(new ResourceLocation("forge", name));
		}
	}
}
