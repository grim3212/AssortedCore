package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
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
		genericBlock(CoreBlocks.COPPER_ORE.get());
		genericBlock(CoreBlocks.SILVER_ORE.get());
		genericBlock(CoreBlocks.ALUMINUM_ORE.get());
		genericBlock(CoreBlocks.NICKEL_ORE.get());
		genericBlock(CoreBlocks.PLATINUM_ORE.get());
		genericBlock(CoreBlocks.LEAD_ORE.get());
		genericBlock(CoreBlocks.RUBY_ORE.get());
		genericBlock(CoreBlocks.AMETHYST_ORE.get());
		genericBlock(CoreBlocks.SAPPHIRE_ORE.get());
		genericBlock(CoreBlocks.TOPAZ_ORE.get());
		genericBlock(CoreBlocks.TIN_BLOCK.get());
		genericBlock(CoreBlocks.COPPER_BLOCK.get());
		genericBlock(CoreBlocks.SILVER_BLOCK.get());
		genericBlock(CoreBlocks.ALUMINUM_BLOCK.get());
		genericBlock(CoreBlocks.NICKEL_BLOCK.get());
		genericBlock(CoreBlocks.PLATINUM_BLOCK.get());
		genericBlock(CoreBlocks.LEAD_BLOCK.get());
		genericBlock(CoreBlocks.RUBY_BLOCK.get());
		genericBlock(CoreBlocks.AMETHYST_BLOCK.get());
		genericBlock(CoreBlocks.SAPPHIRE_BLOCK.get());
		genericBlock(CoreBlocks.TOPAZ_BLOCK.get());
		genericBlock(CoreBlocks.BRONZE_BLOCK.get());
		genericBlock(CoreBlocks.ELECTRUM_BLOCK.get());
		genericBlock(CoreBlocks.INVAR_BLOCK.get());
		genericBlock(CoreBlocks.STEEL_BLOCK.get());
		genericBlock(CoreBlocks.BASIC_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.ADVANCED_ALLOY_FORGE.get());
		genericBlock(CoreBlocks.EXPERT_ALLOY_FORGE.get());

		generatedItem(CoreItems.TIN_INGOT.get());
		generatedItem(CoreItems.COPPER_INGOT.get());
		generatedItem(CoreItems.SILVER_INGOT.get());
		generatedItem(CoreItems.ALUMINUM_INGOT.get());
		generatedItem(CoreItems.NICKEL_INGOT.get());
		generatedItem(CoreItems.PLATINUM_INGOT.get());
		generatedItem(CoreItems.LEAD_INGOT.get());
		generatedItem(CoreItems.BRONZE_INGOT.get());
		generatedItem(CoreItems.ELECTRUM_INGOT.get());
		generatedItem(CoreItems.INVAR_INGOT.get());
		generatedItem(CoreItems.STEEL_INGOT.get());

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

		generatedItem(CoreItems.RUBY.get());
		generatedItem(CoreItems.AMETHYST.get());
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
