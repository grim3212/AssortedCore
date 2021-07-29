package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CoreItemModelProvider extends ItemModelProvider {

	public CoreItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AssortedCore.MODID, existingFileHelper);
	}

	@Override
	public String getName() {
		return "Assorted Core item models";
	}

	@Override
	protected void registerModels() {
		genericBlock(CoreBlocks.TIN_ORE.get());
		genericBlock(CoreBlocks.SILVER_ORE.get());
		genericBlock(CoreBlocks.ALUMINUM_ORE.get());
		genericBlock(CoreBlocks.NICKEL_ORE.get());
		genericBlock(CoreBlocks.PLATINUM_ORE.get());
		genericBlock(CoreBlocks.LEAD_ORE.get());
		genericBlock(CoreBlocks.RUBY_ORE.get());
		genericBlock(CoreBlocks.PERIDOT_ORE.get());
		genericBlock(CoreBlocks.SAPPHIRE_ORE.get());
		genericBlock(CoreBlocks.TOPAZ_ORE.get());
		genericBlock(CoreBlocks.TIN_BLOCK.get());
		genericBlock(CoreBlocks.SILVER_BLOCK.get());
		genericBlock(CoreBlocks.ALUMINUM_BLOCK.get());
		genericBlock(CoreBlocks.NICKEL_BLOCK.get());
		genericBlock(CoreBlocks.PLATINUM_BLOCK.get());
		genericBlock(CoreBlocks.LEAD_BLOCK.get());
		genericBlock(CoreBlocks.RUBY_BLOCK.get());
		genericBlock(CoreBlocks.PERIDOT_BLOCK.get());
		genericBlock(CoreBlocks.SAPPHIRE_BLOCK.get());
		genericBlock(CoreBlocks.TOPAZ_BLOCK.get());
		genericBlock(CoreBlocks.BRONZE_BLOCK.get());
		genericBlock(CoreBlocks.ELECTRUM_BLOCK.get());
		genericBlock(CoreBlocks.INVAR_BLOCK.get());
		genericBlock(CoreBlocks.STEEL_BLOCK.get());

		genericBlock(CoreBlocks.DEEPSLATE_TIN_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_SILVER_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_NICKEL_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_LEAD_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_RUBY_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
		genericBlock(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

		genericBlock(CoreBlocks.RAW_TIN_BLOCK.get());
		genericBlock(CoreBlocks.RAW_SILVER_BLOCK.get());
		genericBlock(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
		genericBlock(CoreBlocks.RAW_NICKEL_BLOCK.get());
		genericBlock(CoreBlocks.RAW_PLATINUM_BLOCK.get());
		genericBlock(CoreBlocks.RAW_LEAD_BLOCK.get());

		genericBlock(CoreBlocks.MACHINE_CORE.get());
		genericBlock(CoreBlocks.BASIC_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.ADVANCED_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.EXPERT_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.BASIC_GRINDING_MILL.get());
		genericBlock(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
		genericBlock(CoreBlocks.ADVANCED_GRINDING_MILL.get());
		genericBlock(CoreBlocks.EXPERT_GRINDING_MILL.get());

		generatedItem(CoreItems.TIN_INGOT.get());
		generatedItem(CoreItems.SILVER_INGOT.get());
		generatedItem(CoreItems.ALUMINUM_INGOT.get());
		generatedItem(CoreItems.NICKEL_INGOT.get());
		generatedItem(CoreItems.PLATINUM_INGOT.get());
		generatedItem(CoreItems.LEAD_INGOT.get());
		generatedItem(CoreItems.BRONZE_INGOT.get());
		generatedItem(CoreItems.ELECTRUM_INGOT.get());
		generatedItem(CoreItems.INVAR_INGOT.get());
		generatedItem(CoreItems.STEEL_INGOT.get());

		generatedItem(CoreItems.RAW_TIN.get());
		generatedItem(CoreItems.RAW_SILVER.get());
		generatedItem(CoreItems.RAW_ALUMINUM.get());
		generatedItem(CoreItems.RAW_NICKEL.get());
		generatedItem(CoreItems.RAW_PLATINUM.get());
		generatedItem(CoreItems.RAW_LEAD.get());

		generatedItem(CoreItems.TIN_NUGGET.get());
		generatedItem(CoreItems.COPPER_NUGGET.get());
		generatedItem(CoreItems.SILVER_NUGGET.get());
		generatedItem(CoreItems.ALUMINUM_NUGGET.get());
		generatedItem(CoreItems.NICKEL_NUGGET.get());
		generatedItem(CoreItems.PLATINUM_NUGGET.get());
		generatedItem(CoreItems.LEAD_NUGGET.get());
		generatedItem(CoreItems.BRONZE_NUGGET.get());
		generatedItem(CoreItems.ELECTRUM_NUGGET.get());
		generatedItem(CoreItems.INVAR_NUGGET.get());
		generatedItem(CoreItems.STEEL_NUGGET.get());

		generatedItem(CoreItems.TIN_DUST.get());
		generatedItem(CoreItems.COPPER_DUST.get());
		generatedItem(CoreItems.SILVER_DUST.get());
		generatedItem(CoreItems.ALUMINUM_DUST.get());
		generatedItem(CoreItems.NICKEL_DUST.get());
		generatedItem(CoreItems.PLATINUM_DUST.get());
		generatedItem(CoreItems.LEAD_DUST.get());
		generatedItem(CoreItems.BRONZE_DUST.get());
		generatedItem(CoreItems.ELECTRUM_DUST.get());
		generatedItem(CoreItems.INVAR_DUST.get());
		generatedItem(CoreItems.STEEL_DUST.get());
		generatedItem(CoreItems.IRON_DUST.get());
		generatedItem(CoreItems.GOLD_DUST.get());

		generatedItem(CoreItems.TIN_GEAR.get());
		generatedItem(CoreItems.COPPER_GEAR.get());
		generatedItem(CoreItems.SILVER_GEAR.get());
		generatedItem(CoreItems.ALUMINUM_GEAR.get());
		generatedItem(CoreItems.NICKEL_GEAR.get());
		generatedItem(CoreItems.PLATINUM_GEAR.get());
		generatedItem(CoreItems.LEAD_GEAR.get());
		generatedItem(CoreItems.BRONZE_GEAR.get());
		generatedItem(CoreItems.ELECTRUM_GEAR.get());
		generatedItem(CoreItems.INVAR_GEAR.get());
		generatedItem(CoreItems.STEEL_GEAR.get());
		generatedItem(CoreItems.IRON_GEAR.get());
		generatedItem(CoreItems.GOLD_GEAR.get());

		generatedItem(CoreItems.RUBY.get());
		generatedItem(CoreItems.PERIDOT.get());
		generatedItem(CoreItems.SAPPHIRE.get());
		generatedItem(CoreItems.TOPAZ.get());
	}

	private ItemModelBuilder generatedItem(String name) {
		return withExistingParent(name, "item/generated").texture("layer0", prefix("item/" + name));
	}

	private ItemModelBuilder generatedItem(Item i) {
		return generatedItem(name(i));
	}

	private ItemModelBuilder genericBlock(Block b) {
		String name = name(b);
		return withExistingParent(name, prefix("block/" + name));
	}

	private static String name(Item i) {
		return Registry.ITEM.getKey(i).getPath();
	}

	private static String name(Block i) {
		return Registry.BLOCK.getKey(i).getPath();
	}

	private ResourceLocation prefix(String name) {
		return new ResourceLocation(AssortedCore.MODID, name);
	}
}
