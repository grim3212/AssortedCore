package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreItemModelProvider extends ItemModelProvider {

    public CoreItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    private static String name(Item i) {
        return ForgeRegistries.ITEMS.getKey(i).getPath();
    }

    private static String name(Block i) {
        return ForgeRegistries.BLOCKS.getKey(i).getPath();
    }

    @Override
    public String getName() {
        return "Assorted Core item models";
    }

    @Override
    protected void registerModels() {
        genericBlock(AssortedCoreBlocks.TIN_ORE.get());
        genericBlock(AssortedCoreBlocks.SILVER_ORE.get());
        genericBlock(AssortedCoreBlocks.ALUMINUM_ORE.get());
        genericBlock(AssortedCoreBlocks.NICKEL_ORE.get());
        genericBlock(AssortedCoreBlocks.PLATINUM_ORE.get());
        genericBlock(AssortedCoreBlocks.LEAD_ORE.get());
        genericBlock(AssortedCoreBlocks.RUBY_ORE.get());
        genericBlock(AssortedCoreBlocks.PERIDOT_ORE.get());
        genericBlock(AssortedCoreBlocks.SAPPHIRE_ORE.get());
        genericBlock(AssortedCoreBlocks.TOPAZ_ORE.get());
        genericBlock(AssortedCoreBlocks.TIN_BLOCK.get());
        genericBlock(AssortedCoreBlocks.SILVER_BLOCK.get());
        genericBlock(AssortedCoreBlocks.ALUMINUM_BLOCK.get());
        genericBlock(AssortedCoreBlocks.NICKEL_BLOCK.get());
        genericBlock(AssortedCoreBlocks.PLATINUM_BLOCK.get());
        genericBlock(AssortedCoreBlocks.LEAD_BLOCK.get());
        genericBlock(AssortedCoreBlocks.RUBY_BLOCK.get());
        genericBlock(AssortedCoreBlocks.PERIDOT_BLOCK.get());
        genericBlock(AssortedCoreBlocks.SAPPHIRE_BLOCK.get());
        genericBlock(AssortedCoreBlocks.TOPAZ_BLOCK.get());
        genericBlock(AssortedCoreBlocks.BRONZE_BLOCK.get());
        genericBlock(AssortedCoreBlocks.ELECTRUM_BLOCK.get());
        genericBlock(AssortedCoreBlocks.INVAR_BLOCK.get());
        genericBlock(AssortedCoreBlocks.STEEL_BLOCK.get());

        genericBlock(AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        genericBlock(AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

        genericBlock(AssortedCoreBlocks.RAW_TIN_BLOCK.get());
        genericBlock(AssortedCoreBlocks.RAW_SILVER_BLOCK.get());
        genericBlock(AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get());
        genericBlock(AssortedCoreBlocks.RAW_NICKEL_BLOCK.get());
        genericBlock(AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get());
        genericBlock(AssortedCoreBlocks.RAW_LEAD_BLOCK.get());

        genericBlock(AssortedCoreBlocks.MACHINE_CORE.get());
        genericBlock(AssortedCoreBlocks.BASIC_ALLOY_FORGE.get());
        genericBlock(AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
        genericBlock(AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get());
        genericBlock(AssortedCoreBlocks.EXPERT_ALLOY_FORGE.get());
        genericBlock(AssortedCoreBlocks.BASIC_GRINDING_MILL.get());
        genericBlock(AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
        genericBlock(AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get());
        genericBlock(AssortedCoreBlocks.EXPERT_GRINDING_MILL.get());

        generatedItem(AssortedCoreItems.TIN_INGOT.get());
        generatedItem(AssortedCoreItems.SILVER_INGOT.get());
        generatedItem(AssortedCoreItems.ALUMINUM_INGOT.get());
        generatedItem(AssortedCoreItems.NICKEL_INGOT.get());
        generatedItem(AssortedCoreItems.PLATINUM_INGOT.get());
        generatedItem(AssortedCoreItems.LEAD_INGOT.get());
        generatedItem(AssortedCoreItems.BRONZE_INGOT.get());
        generatedItem(AssortedCoreItems.ELECTRUM_INGOT.get());
        generatedItem(AssortedCoreItems.INVAR_INGOT.get());
        generatedItem(AssortedCoreItems.STEEL_INGOT.get());

        generatedItem(AssortedCoreItems.RAW_TIN.get());
        generatedItem(AssortedCoreItems.RAW_SILVER.get());
        generatedItem(AssortedCoreItems.RAW_ALUMINUM.get());
        generatedItem(AssortedCoreItems.RAW_NICKEL.get());
        generatedItem(AssortedCoreItems.RAW_PLATINUM.get());
        generatedItem(AssortedCoreItems.RAW_LEAD.get());

        generatedItem(AssortedCoreItems.TIN_NUGGET.get());
        generatedItem(AssortedCoreItems.COPPER_NUGGET.get());
        generatedItem(AssortedCoreItems.SILVER_NUGGET.get());
        generatedItem(AssortedCoreItems.ALUMINUM_NUGGET.get());
        generatedItem(AssortedCoreItems.NICKEL_NUGGET.get());
        generatedItem(AssortedCoreItems.PLATINUM_NUGGET.get());
        generatedItem(AssortedCoreItems.LEAD_NUGGET.get());
        generatedItem(AssortedCoreItems.BRONZE_NUGGET.get());
        generatedItem(AssortedCoreItems.ELECTRUM_NUGGET.get());
        generatedItem(AssortedCoreItems.INVAR_NUGGET.get());
        generatedItem(AssortedCoreItems.STEEL_NUGGET.get());

        generatedItem(AssortedCoreItems.TIN_DUST.get());
        generatedItem(AssortedCoreItems.COPPER_DUST.get());
        generatedItem(AssortedCoreItems.SILVER_DUST.get());
        generatedItem(AssortedCoreItems.ALUMINUM_DUST.get());
        generatedItem(AssortedCoreItems.NICKEL_DUST.get());
        generatedItem(AssortedCoreItems.PLATINUM_DUST.get());
        generatedItem(AssortedCoreItems.LEAD_DUST.get());
        generatedItem(AssortedCoreItems.BRONZE_DUST.get());
        generatedItem(AssortedCoreItems.ELECTRUM_DUST.get());
        generatedItem(AssortedCoreItems.INVAR_DUST.get());
        generatedItem(AssortedCoreItems.STEEL_DUST.get());
        generatedItem(AssortedCoreItems.IRON_DUST.get());
        generatedItem(AssortedCoreItems.GOLD_DUST.get());

        generatedItem(AssortedCoreItems.TIN_GEAR.get());
        generatedItem(AssortedCoreItems.COPPER_GEAR.get());
        generatedItem(AssortedCoreItems.SILVER_GEAR.get());
        generatedItem(AssortedCoreItems.ALUMINUM_GEAR.get());
        generatedItem(AssortedCoreItems.NICKEL_GEAR.get());
        generatedItem(AssortedCoreItems.PLATINUM_GEAR.get());
        generatedItem(AssortedCoreItems.LEAD_GEAR.get());
        generatedItem(AssortedCoreItems.BRONZE_GEAR.get());
        generatedItem(AssortedCoreItems.ELECTRUM_GEAR.get());
        generatedItem(AssortedCoreItems.INVAR_GEAR.get());
        generatedItem(AssortedCoreItems.STEEL_GEAR.get());
        generatedItem(AssortedCoreItems.IRON_GEAR.get());
        generatedItem(AssortedCoreItems.GOLD_GEAR.get());

        generatedItem(AssortedCoreItems.RUBY.get());
        generatedItem(AssortedCoreItems.PERIDOT.get());
        generatedItem(AssortedCoreItems.SAPPHIRE.get());
        generatedItem(AssortedCoreItems.TOPAZ.get());
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

    private ResourceLocation prefix(String name) {
        return new ResourceLocation(Constants.MOD_ID, name);
    }
}
