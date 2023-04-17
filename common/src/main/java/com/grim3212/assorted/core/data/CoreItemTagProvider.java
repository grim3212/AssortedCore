package com.grim3212.assorted.core.data;

import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.lib.data.LibItemTagProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CoreItemTagProvider extends LibItemTagProvider {


    public CoreItemTagProvider(PackOutput output, CompletableFuture<Provider> lookup, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookup, blockTags);
    }

    @Override
    public void addCommonTags(Function<TagKey<Item>, IntrinsicTagAppender<Item>> tagger, BiConsumer<TagKey<Block>, TagKey<Item>> copier) {
        tagger.apply(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS).add(Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE);

        copier.accept(CoreTags.Blocks.ORES, CoreTags.Items.ORES);
        copier.accept(CoreTags.Blocks.ORES_TIN, CoreTags.Items.ORES_TIN);
        copier.accept(CoreTags.Blocks.ORES_COPPER, CoreTags.Items.ORES_COPPER);
        copier.accept(CoreTags.Blocks.ORES_SILVER, CoreTags.Items.ORES_SILVER);
        copier.accept(CoreTags.Blocks.ORES_ALUMINUM, CoreTags.Items.ORES_ALUMINUM);
        copier.accept(CoreTags.Blocks.ORES_NICKEL, CoreTags.Items.ORES_NICKEL);
        copier.accept(CoreTags.Blocks.ORES_PLATINUM, CoreTags.Items.ORES_PLATINUM);
        copier.accept(CoreTags.Blocks.ORES_LEAD, CoreTags.Items.ORES_LEAD);
        copier.accept(CoreTags.Blocks.ORES_RUBY, CoreTags.Items.ORES_RUBY);
        copier.accept(CoreTags.Blocks.ORES_PERIDOT, CoreTags.Items.ORES_PERIDOT);
        copier.accept(CoreTags.Blocks.ORES_SAPPHIRE, CoreTags.Items.ORES_SAPPHIRE);
        copier.accept(CoreTags.Blocks.ORES_TOPAZ, CoreTags.Items.ORES_TOPAZ);

        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS, CoreTags.Items.STORAGE_BLOCKS);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_TIN, CoreTags.Items.STORAGE_BLOCKS_TIN);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_COPPER, CoreTags.Items.STORAGE_BLOCKS_COPPER);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_SILVER, CoreTags.Items.STORAGE_BLOCKS_SILVER);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.STORAGE_BLOCKS_ALUMINUM);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_NICKEL, CoreTags.Items.STORAGE_BLOCKS_NICKEL);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_PLATINUM, CoreTags.Items.STORAGE_BLOCKS_PLATINUM);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_LEAD, CoreTags.Items.STORAGE_BLOCKS_LEAD);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_RUBY, CoreTags.Items.STORAGE_BLOCKS_RUBY);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_PERIDOT, CoreTags.Items.STORAGE_BLOCKS_PERIDOT);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.STORAGE_BLOCKS_TOPAZ);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_BRONZE, CoreTags.Items.STORAGE_BLOCKS_BRONZE);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.STORAGE_BLOCKS_ELECTRUM);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_INVAR, CoreTags.Items.STORAGE_BLOCKS_INVAR);
        copier.accept(CoreTags.Blocks.STORAGE_BLOCKS_STEEL, CoreTags.Items.STORAGE_BLOCKS_STEEL);

        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_TIN, CoreTags.Items.RAW_STORAGE_BLOCKS_TIN);
        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_COPPER, CoreTags.Items.RAW_STORAGE_BLOCKS_COPPER);
        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_SILVER, CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER);
        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM);
        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_NICKEL, CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL);
        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_PLATINUM, CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM);
        copier.accept(CoreTags.Blocks.RAW_STORAGE_BLOCKS_LEAD, CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD);

        tagger.apply(CoreTags.Items.GEMS).add(CoreItems.RUBY.get());
        tagger.apply(CoreTags.Items.GEMS).add(CoreItems.PERIDOT.get());
        tagger.apply(CoreTags.Items.GEMS).add(CoreItems.SAPPHIRE.get());
        tagger.apply(CoreTags.Items.GEMS).add(CoreItems.TOPAZ.get());
        tagger.apply(CoreTags.Items.GEMS_RUBY).add(CoreItems.RUBY.get());
        tagger.apply(CoreTags.Items.GEMS_PERIDOT).add(CoreItems.PERIDOT.get());
        tagger.apply(CoreTags.Items.GEMS_SAPPHIRE).add(CoreItems.SAPPHIRE.get());
        tagger.apply(CoreTags.Items.GEMS_TOPAZ).add(CoreItems.TOPAZ.get());

        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_ALUMINUM.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_LEAD.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_NICKEL.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_PLATINUM.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_SILVER.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_TIN.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_IRON);
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_GOLD);
        tagger.apply(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_COPPER);
        tagger.apply(CoreTags.Items.RAW_MATERIALS_ALUMINUM).add(CoreItems.RAW_ALUMINUM.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS_LEAD).add(CoreItems.RAW_LEAD.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS_NICKEL).add(CoreItems.RAW_NICKEL.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS_PLATINUM).add(CoreItems.RAW_PLATINUM.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS_SILVER).add(CoreItems.RAW_SILVER.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS_TIN).add(CoreItems.RAW_TIN.get());
        tagger.apply(CoreTags.Items.RAW_MATERIALS_IRON).add(Items.RAW_IRON);
        tagger.apply(CoreTags.Items.RAW_MATERIALS_GOLD).add(Items.RAW_GOLD);
        tagger.apply(CoreTags.Items.RAW_MATERIALS_COPPER).add(Items.RAW_COPPER);

        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.TIN_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(Items.COPPER_INGOT);
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.SILVER_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.ALUMINUM_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.NICKEL_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.PLATINUM_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.LEAD_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.BRONZE_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.ELECTRUM_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.INVAR_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS).add(CoreItems.STEEL_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_TIN).add(CoreItems.TIN_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_COPPER).add(Items.COPPER_INGOT);
        tagger.apply(CoreTags.Items.INGOTS_SILVER).add(CoreItems.SILVER_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_ALUMINUM).add(CoreItems.ALUMINUM_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_NICKEL).add(CoreItems.NICKEL_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_PLATINUM).add(CoreItems.PLATINUM_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_LEAD).add(CoreItems.LEAD_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_BRONZE).add(CoreItems.BRONZE_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_ELECTRUM).add(CoreItems.ELECTRUM_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_INVAR).add(CoreItems.INVAR_INGOT.get());
        tagger.apply(CoreTags.Items.INGOTS_STEEL).add(CoreItems.STEEL_INGOT.get());

        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.TIN_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.COPPER_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.SILVER_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.ALUMINUM_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.NICKEL_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.PLATINUM_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.LEAD_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.BRONZE_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.ELECTRUM_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.INVAR_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS).add(CoreItems.STEEL_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_TIN).add(CoreItems.TIN_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_COPPER).add(CoreItems.COPPER_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_SILVER).add(CoreItems.SILVER_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_ALUMINUM).add(CoreItems.ALUMINUM_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_NICKEL).add(CoreItems.NICKEL_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_PLATINUM).add(CoreItems.PLATINUM_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_LEAD).add(CoreItems.LEAD_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_BRONZE).add(CoreItems.BRONZE_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_ELECTRUM).add(CoreItems.ELECTRUM_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_INVAR).add(CoreItems.INVAR_NUGGET.get());
        tagger.apply(CoreTags.Items.NUGGETS_STEEL).add(CoreItems.STEEL_NUGGET.get());

        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.TIN_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.COPPER_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.SILVER_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.ALUMINUM_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.NICKEL_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.PLATINUM_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.LEAD_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.BRONZE_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.ELECTRUM_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.INVAR_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.STEEL_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.IRON_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS).add(CoreItems.GOLD_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_TIN).add(CoreItems.TIN_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_COPPER).add(CoreItems.COPPER_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_SILVER).add(CoreItems.SILVER_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_ALUMINUM).add(CoreItems.ALUMINUM_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_NICKEL).add(CoreItems.NICKEL_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_PLATINUM).add(CoreItems.PLATINUM_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_LEAD).add(CoreItems.LEAD_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_BRONZE).add(CoreItems.BRONZE_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_ELECTRUM).add(CoreItems.ELECTRUM_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_INVAR).add(CoreItems.INVAR_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_STEEL).add(CoreItems.STEEL_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_IRON).add(CoreItems.IRON_DUST.get());
        tagger.apply(CoreTags.Items.DUSTS_GOLD).add(CoreItems.GOLD_DUST.get());

        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.TIN_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.COPPER_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.SILVER_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.ALUMINUM_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.NICKEL_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.PLATINUM_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.LEAD_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.BRONZE_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.ELECTRUM_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.INVAR_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.STEEL_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.IRON_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS).add(CoreItems.GOLD_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_TIN).add(CoreItems.TIN_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_COPPER).add(CoreItems.COPPER_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_SILVER).add(CoreItems.SILVER_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_ALUMINUM).add(CoreItems.ALUMINUM_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_NICKEL).add(CoreItems.NICKEL_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_PLATINUM).add(CoreItems.PLATINUM_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_LEAD).add(CoreItems.LEAD_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_BRONZE).add(CoreItems.BRONZE_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_ELECTRUM).add(CoreItems.ELECTRUM_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_INVAR).add(CoreItems.INVAR_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_STEEL).add(CoreItems.STEEL_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_IRON).add(CoreItems.IRON_GEAR.get());
        tagger.apply(CoreTags.Items.GEARS_GOLD).add(CoreItems.GOLD_GEAR.get());

        tagger.apply(ItemTags.PIGLIN_LOVED).add(CoreItems.GOLD_DUST.get(), CoreItems.GOLD_GEAR.get());
    }
}
