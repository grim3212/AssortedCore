package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CoreItemTagProvider extends ItemTagsProvider {

    public CoreItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookup, blockTags, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS).add(Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE);

        this.copy(CoreTags.Blocks.ORES, CoreTags.Items.ORES);
        this.copy(CoreTags.Blocks.ORES_TIN, CoreTags.Items.ORES_TIN);
        this.copy(CoreTags.Blocks.ORES_COPPER, CoreTags.Items.ORES_COPPER);
        this.copy(CoreTags.Blocks.ORES_SILVER, CoreTags.Items.ORES_SILVER);
        this.copy(CoreTags.Blocks.ORES_ALUMINUM, CoreTags.Items.ORES_ALUMINUM);
        this.copy(CoreTags.Blocks.ORES_NICKEL, CoreTags.Items.ORES_NICKEL);
        this.copy(CoreTags.Blocks.ORES_PLATINUM, CoreTags.Items.ORES_PLATINUM);
        this.copy(CoreTags.Blocks.ORES_LEAD, CoreTags.Items.ORES_LEAD);
        this.copy(CoreTags.Blocks.ORES_RUBY, CoreTags.Items.ORES_RUBY);
        this.copy(CoreTags.Blocks.ORES_PERIDOT, CoreTags.Items.ORES_PERIDOT);
        this.copy(CoreTags.Blocks.ORES_SAPPHIRE, CoreTags.Items.ORES_SAPPHIRE);
        this.copy(CoreTags.Blocks.ORES_TOPAZ, CoreTags.Items.ORES_TOPAZ);

        this.copy(CoreTags.Blocks.STORAGE_BLOCKS, CoreTags.Items.STORAGE_BLOCKS);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_TIN, CoreTags.Items.STORAGE_BLOCKS_TIN);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_COPPER, CoreTags.Items.STORAGE_BLOCKS_COPPER);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_SILVER, CoreTags.Items.STORAGE_BLOCKS_SILVER);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.STORAGE_BLOCKS_ALUMINUM);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_NICKEL, CoreTags.Items.STORAGE_BLOCKS_NICKEL);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_PLATINUM, CoreTags.Items.STORAGE_BLOCKS_PLATINUM);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_LEAD, CoreTags.Items.STORAGE_BLOCKS_LEAD);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_RUBY, CoreTags.Items.STORAGE_BLOCKS_RUBY);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_PERIDOT, CoreTags.Items.STORAGE_BLOCKS_PERIDOT);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.STORAGE_BLOCKS_TOPAZ);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_BRONZE, CoreTags.Items.STORAGE_BLOCKS_BRONZE);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.STORAGE_BLOCKS_ELECTRUM);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_INVAR, CoreTags.Items.STORAGE_BLOCKS_INVAR);
        this.copy(CoreTags.Blocks.STORAGE_BLOCKS_STEEL, CoreTags.Items.STORAGE_BLOCKS_STEEL);

        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_TIN, CoreTags.Items.RAW_STORAGE_BLOCKS_TIN);
        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_COPPER, CoreTags.Items.RAW_STORAGE_BLOCKS_COPPER);
        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_SILVER, CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER);
        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM);
        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_NICKEL, CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL);
        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_PLATINUM, CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM);
        this.copy(CoreTags.Blocks.RAW_STORAGE_BLOCKS_LEAD, CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD);

        this.tag(CoreTags.Items.GEMS).add(AssortedCoreItems.RUBY.get());
        this.tag(CoreTags.Items.GEMS).add(AssortedCoreItems.PERIDOT.get());
        this.tag(CoreTags.Items.GEMS).add(AssortedCoreItems.SAPPHIRE.get());
        this.tag(CoreTags.Items.GEMS).add(AssortedCoreItems.TOPAZ.get());
        this.tag(CoreTags.Items.GEMS_RUBY).add(AssortedCoreItems.RUBY.get());
        this.tag(CoreTags.Items.GEMS_PERIDOT).add(AssortedCoreItems.PERIDOT.get());
        this.tag(CoreTags.Items.GEMS_SAPPHIRE).add(AssortedCoreItems.SAPPHIRE.get());
        this.tag(CoreTags.Items.GEMS_TOPAZ).add(AssortedCoreItems.TOPAZ.get());

        this.tag(CoreTags.Items.RAW_MATERIALS).add(AssortedCoreItems.RAW_ALUMINUM.get());
        this.tag(CoreTags.Items.RAW_MATERIALS).add(AssortedCoreItems.RAW_LEAD.get());
        this.tag(CoreTags.Items.RAW_MATERIALS).add(AssortedCoreItems.RAW_NICKEL.get());
        this.tag(CoreTags.Items.RAW_MATERIALS).add(AssortedCoreItems.RAW_PLATINUM.get());
        this.tag(CoreTags.Items.RAW_MATERIALS).add(AssortedCoreItems.RAW_SILVER.get());
        this.tag(CoreTags.Items.RAW_MATERIALS).add(AssortedCoreItems.RAW_TIN.get());
        this.tag(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_IRON);
        this.tag(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_GOLD);
        this.tag(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_COPPER);
        this.tag(CoreTags.Items.RAW_MATERIALS_ALUMINUM).add(AssortedCoreItems.RAW_ALUMINUM.get());
        this.tag(CoreTags.Items.RAW_MATERIALS_LEAD).add(AssortedCoreItems.RAW_LEAD.get());
        this.tag(CoreTags.Items.RAW_MATERIALS_NICKEL).add(AssortedCoreItems.RAW_NICKEL.get());
        this.tag(CoreTags.Items.RAW_MATERIALS_PLATINUM).add(AssortedCoreItems.RAW_PLATINUM.get());
        this.tag(CoreTags.Items.RAW_MATERIALS_SILVER).add(AssortedCoreItems.RAW_SILVER.get());
        this.tag(CoreTags.Items.RAW_MATERIALS_TIN).add(AssortedCoreItems.RAW_TIN.get());
        this.tag(CoreTags.Items.RAW_MATERIALS_IRON).add(Items.RAW_IRON);
        this.tag(CoreTags.Items.RAW_MATERIALS_GOLD).add(Items.RAW_GOLD);
        this.tag(CoreTags.Items.RAW_MATERIALS_COPPER).add(Items.RAW_COPPER);

        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.TIN_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(Items.COPPER_INGOT);
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.SILVER_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.ALUMINUM_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.NICKEL_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.PLATINUM_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.LEAD_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.BRONZE_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.ELECTRUM_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.INVAR_INGOT.get());
        this.tag(CoreTags.Items.INGOTS).add(AssortedCoreItems.STEEL_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_TIN).add(AssortedCoreItems.TIN_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_COPPER).add(Items.COPPER_INGOT);
        this.tag(CoreTags.Items.INGOTS_SILVER).add(AssortedCoreItems.SILVER_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_ALUMINUM).add(AssortedCoreItems.ALUMINUM_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_NICKEL).add(AssortedCoreItems.NICKEL_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_PLATINUM).add(AssortedCoreItems.PLATINUM_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_LEAD).add(AssortedCoreItems.LEAD_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_BRONZE).add(AssortedCoreItems.BRONZE_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_ELECTRUM).add(AssortedCoreItems.ELECTRUM_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_INVAR).add(AssortedCoreItems.INVAR_INGOT.get());
        this.tag(CoreTags.Items.INGOTS_STEEL).add(AssortedCoreItems.STEEL_INGOT.get());

        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.TIN_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.COPPER_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.SILVER_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.ALUMINUM_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.NICKEL_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.PLATINUM_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.LEAD_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.BRONZE_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.ELECTRUM_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.INVAR_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS).add(AssortedCoreItems.STEEL_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_TIN).add(AssortedCoreItems.TIN_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_COPPER).add(AssortedCoreItems.COPPER_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_SILVER).add(AssortedCoreItems.SILVER_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_ALUMINUM).add(AssortedCoreItems.ALUMINUM_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_NICKEL).add(AssortedCoreItems.NICKEL_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_PLATINUM).add(AssortedCoreItems.PLATINUM_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_LEAD).add(AssortedCoreItems.LEAD_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_BRONZE).add(AssortedCoreItems.BRONZE_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_ELECTRUM).add(AssortedCoreItems.ELECTRUM_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_INVAR).add(AssortedCoreItems.INVAR_NUGGET.get());
        this.tag(CoreTags.Items.NUGGETS_STEEL).add(AssortedCoreItems.STEEL_NUGGET.get());

        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.TIN_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.COPPER_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.SILVER_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.ALUMINUM_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.NICKEL_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.PLATINUM_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.LEAD_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.BRONZE_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.ELECTRUM_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.INVAR_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.STEEL_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.IRON_DUST.get());
        this.tag(CoreTags.Items.DUSTS).add(AssortedCoreItems.GOLD_DUST.get());
        this.tag(CoreTags.Items.DUSTS_TIN).add(AssortedCoreItems.TIN_DUST.get());
        this.tag(CoreTags.Items.DUSTS_COPPER).add(AssortedCoreItems.COPPER_DUST.get());
        this.tag(CoreTags.Items.DUSTS_SILVER).add(AssortedCoreItems.SILVER_DUST.get());
        this.tag(CoreTags.Items.DUSTS_ALUMINUM).add(AssortedCoreItems.ALUMINUM_DUST.get());
        this.tag(CoreTags.Items.DUSTS_NICKEL).add(AssortedCoreItems.NICKEL_DUST.get());
        this.tag(CoreTags.Items.DUSTS_PLATINUM).add(AssortedCoreItems.PLATINUM_DUST.get());
        this.tag(CoreTags.Items.DUSTS_LEAD).add(AssortedCoreItems.LEAD_DUST.get());
        this.tag(CoreTags.Items.DUSTS_BRONZE).add(AssortedCoreItems.BRONZE_DUST.get());
        this.tag(CoreTags.Items.DUSTS_ELECTRUM).add(AssortedCoreItems.ELECTRUM_DUST.get());
        this.tag(CoreTags.Items.DUSTS_INVAR).add(AssortedCoreItems.INVAR_DUST.get());
        this.tag(CoreTags.Items.DUSTS_STEEL).add(AssortedCoreItems.STEEL_DUST.get());
        this.tag(CoreTags.Items.DUSTS_IRON).add(AssortedCoreItems.IRON_DUST.get());
        this.tag(CoreTags.Items.DUSTS_GOLD).add(AssortedCoreItems.GOLD_DUST.get());

        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.TIN_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.COPPER_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.SILVER_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.ALUMINUM_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.NICKEL_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.PLATINUM_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.LEAD_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.BRONZE_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.ELECTRUM_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.INVAR_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.STEEL_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.IRON_GEAR.get());
        this.tag(CoreTags.Items.GEARS).add(AssortedCoreItems.GOLD_GEAR.get());
        this.tag(CoreTags.Items.GEARS_TIN).add(AssortedCoreItems.TIN_GEAR.get());
        this.tag(CoreTags.Items.GEARS_COPPER).add(AssortedCoreItems.COPPER_GEAR.get());
        this.tag(CoreTags.Items.GEARS_SILVER).add(AssortedCoreItems.SILVER_GEAR.get());
        this.tag(CoreTags.Items.GEARS_ALUMINUM).add(AssortedCoreItems.ALUMINUM_GEAR.get());
        this.tag(CoreTags.Items.GEARS_NICKEL).add(AssortedCoreItems.NICKEL_GEAR.get());
        this.tag(CoreTags.Items.GEARS_PLATINUM).add(AssortedCoreItems.PLATINUM_GEAR.get());
        this.tag(CoreTags.Items.GEARS_LEAD).add(AssortedCoreItems.LEAD_GEAR.get());
        this.tag(CoreTags.Items.GEARS_BRONZE).add(AssortedCoreItems.BRONZE_GEAR.get());
        this.tag(CoreTags.Items.GEARS_ELECTRUM).add(AssortedCoreItems.ELECTRUM_GEAR.get());
        this.tag(CoreTags.Items.GEARS_INVAR).add(AssortedCoreItems.INVAR_GEAR.get());
        this.tag(CoreTags.Items.GEARS_STEEL).add(AssortedCoreItems.STEEL_GEAR.get());
        this.tag(CoreTags.Items.GEARS_IRON).add(AssortedCoreItems.IRON_GEAR.get());
        this.tag(CoreTags.Items.GEARS_GOLD).add(AssortedCoreItems.GOLD_GEAR.get());

        this.tag(ItemTags.PIGLIN_LOVED).add(AssortedCoreItems.GOLD_DUST.get(), AssortedCoreItems.GOLD_GEAR.get());
    }

    @Override
    public String getName() {
        return "Assorted Core item tags";
    }
}
