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
