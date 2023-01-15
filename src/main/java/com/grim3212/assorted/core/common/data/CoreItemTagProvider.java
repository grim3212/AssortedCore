package com.grim3212.assorted.core.common.data;

import java.util.concurrent.CompletableFuture;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CoreItemTagProvider extends ItemTagsProvider {

	public CoreItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
		super(output, lookup, blockTags, AssortedCore.MODID, existingFileHelper);
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

		this.tag(CoreTags.Items.GEMS).add(CoreItems.RUBY.get());
		this.tag(CoreTags.Items.GEMS).add(CoreItems.PERIDOT.get());
		this.tag(CoreTags.Items.GEMS).add(CoreItems.SAPPHIRE.get());
		this.tag(CoreTags.Items.GEMS).add(CoreItems.TOPAZ.get());
		this.tag(CoreTags.Items.GEMS_RUBY).add(CoreItems.RUBY.get());
		this.tag(CoreTags.Items.GEMS_PERIDOT).add(CoreItems.PERIDOT.get());
		this.tag(CoreTags.Items.GEMS_SAPPHIRE).add(CoreItems.SAPPHIRE.get());
		this.tag(CoreTags.Items.GEMS_TOPAZ).add(CoreItems.TOPAZ.get());

		this.tag(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_ALUMINUM.get());
		this.tag(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_LEAD.get());
		this.tag(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_NICKEL.get());
		this.tag(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_PLATINUM.get());
		this.tag(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_SILVER.get());
		this.tag(CoreTags.Items.RAW_MATERIALS).add(CoreItems.RAW_TIN.get());
		this.tag(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_IRON);
		this.tag(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_GOLD);
		this.tag(CoreTags.Items.RAW_MATERIALS).add(Items.RAW_COPPER);
		this.tag(CoreTags.Items.RAW_MATERIALS_ALUMINUM).add(CoreItems.RAW_ALUMINUM.get());
		this.tag(CoreTags.Items.RAW_MATERIALS_LEAD).add(CoreItems.RAW_LEAD.get());
		this.tag(CoreTags.Items.RAW_MATERIALS_NICKEL).add(CoreItems.RAW_NICKEL.get());
		this.tag(CoreTags.Items.RAW_MATERIALS_PLATINUM).add(CoreItems.RAW_PLATINUM.get());
		this.tag(CoreTags.Items.RAW_MATERIALS_SILVER).add(CoreItems.RAW_SILVER.get());
		this.tag(CoreTags.Items.RAW_MATERIALS_TIN).add(CoreItems.RAW_TIN.get());
		this.tag(CoreTags.Items.RAW_MATERIALS_IRON).add(Items.RAW_IRON);
		this.tag(CoreTags.Items.RAW_MATERIALS_GOLD).add(Items.RAW_GOLD);
		this.tag(CoreTags.Items.RAW_MATERIALS_COPPER).add(Items.RAW_COPPER);

		this.tag(CoreTags.Items.INGOTS).add(CoreItems.TIN_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(Items.COPPER_INGOT);
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.SILVER_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.ALUMINUM_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.NICKEL_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.PLATINUM_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.LEAD_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.BRONZE_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.ELECTRUM_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.INVAR_INGOT.get());
		this.tag(CoreTags.Items.INGOTS).add(CoreItems.STEEL_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_TIN).add(CoreItems.TIN_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_COPPER).add(Items.COPPER_INGOT);
		this.tag(CoreTags.Items.INGOTS_SILVER).add(CoreItems.SILVER_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_ALUMINUM).add(CoreItems.ALUMINUM_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_NICKEL).add(CoreItems.NICKEL_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_PLATINUM).add(CoreItems.PLATINUM_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_LEAD).add(CoreItems.LEAD_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_BRONZE).add(CoreItems.BRONZE_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_ELECTRUM).add(CoreItems.ELECTRUM_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_INVAR).add(CoreItems.INVAR_INGOT.get());
		this.tag(CoreTags.Items.INGOTS_STEEL).add(CoreItems.STEEL_INGOT.get());

		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.TIN_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.COPPER_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.SILVER_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.ALUMINUM_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.NICKEL_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.PLATINUM_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.LEAD_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.BRONZE_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.ELECTRUM_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.INVAR_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS).add(CoreItems.STEEL_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_TIN).add(CoreItems.TIN_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_COPPER).add(CoreItems.COPPER_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_SILVER).add(CoreItems.SILVER_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_ALUMINUM).add(CoreItems.ALUMINUM_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_NICKEL).add(CoreItems.NICKEL_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_PLATINUM).add(CoreItems.PLATINUM_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_LEAD).add(CoreItems.LEAD_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_BRONZE).add(CoreItems.BRONZE_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_ELECTRUM).add(CoreItems.ELECTRUM_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_INVAR).add(CoreItems.INVAR_NUGGET.get());
		this.tag(CoreTags.Items.NUGGETS_STEEL).add(CoreItems.STEEL_NUGGET.get());

		this.tag(CoreTags.Items.DUSTS).add(CoreItems.TIN_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.COPPER_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.SILVER_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.ALUMINUM_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.NICKEL_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.PLATINUM_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.LEAD_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.BRONZE_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.ELECTRUM_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.INVAR_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.STEEL_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.IRON_DUST.get());
		this.tag(CoreTags.Items.DUSTS).add(CoreItems.GOLD_DUST.get());
		this.tag(CoreTags.Items.DUSTS_TIN).add(CoreItems.TIN_DUST.get());
		this.tag(CoreTags.Items.DUSTS_COPPER).add(CoreItems.COPPER_DUST.get());
		this.tag(CoreTags.Items.DUSTS_SILVER).add(CoreItems.SILVER_DUST.get());
		this.tag(CoreTags.Items.DUSTS_ALUMINUM).add(CoreItems.ALUMINUM_DUST.get());
		this.tag(CoreTags.Items.DUSTS_NICKEL).add(CoreItems.NICKEL_DUST.get());
		this.tag(CoreTags.Items.DUSTS_PLATINUM).add(CoreItems.PLATINUM_DUST.get());
		this.tag(CoreTags.Items.DUSTS_LEAD).add(CoreItems.LEAD_DUST.get());
		this.tag(CoreTags.Items.DUSTS_BRONZE).add(CoreItems.BRONZE_DUST.get());
		this.tag(CoreTags.Items.DUSTS_ELECTRUM).add(CoreItems.ELECTRUM_DUST.get());
		this.tag(CoreTags.Items.DUSTS_INVAR).add(CoreItems.INVAR_DUST.get());
		this.tag(CoreTags.Items.DUSTS_STEEL).add(CoreItems.STEEL_DUST.get());
		this.tag(CoreTags.Items.DUSTS_IRON).add(CoreItems.IRON_DUST.get());
		this.tag(CoreTags.Items.DUSTS_GOLD).add(CoreItems.GOLD_DUST.get());

		this.tag(CoreTags.Items.GEARS).add(CoreItems.TIN_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.COPPER_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.SILVER_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.ALUMINUM_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.NICKEL_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.PLATINUM_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.LEAD_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.BRONZE_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.ELECTRUM_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.INVAR_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.STEEL_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.IRON_GEAR.get());
		this.tag(CoreTags.Items.GEARS).add(CoreItems.GOLD_GEAR.get());
		this.tag(CoreTags.Items.GEARS_TIN).add(CoreItems.TIN_GEAR.get());
		this.tag(CoreTags.Items.GEARS_COPPER).add(CoreItems.COPPER_GEAR.get());
		this.tag(CoreTags.Items.GEARS_SILVER).add(CoreItems.SILVER_GEAR.get());
		this.tag(CoreTags.Items.GEARS_ALUMINUM).add(CoreItems.ALUMINUM_GEAR.get());
		this.tag(CoreTags.Items.GEARS_NICKEL).add(CoreItems.NICKEL_GEAR.get());
		this.tag(CoreTags.Items.GEARS_PLATINUM).add(CoreItems.PLATINUM_GEAR.get());
		this.tag(CoreTags.Items.GEARS_LEAD).add(CoreItems.LEAD_GEAR.get());
		this.tag(CoreTags.Items.GEARS_BRONZE).add(CoreItems.BRONZE_GEAR.get());
		this.tag(CoreTags.Items.GEARS_ELECTRUM).add(CoreItems.ELECTRUM_GEAR.get());
		this.tag(CoreTags.Items.GEARS_INVAR).add(CoreItems.INVAR_GEAR.get());
		this.tag(CoreTags.Items.GEARS_STEEL).add(CoreItems.STEEL_GEAR.get());
		this.tag(CoreTags.Items.GEARS_IRON).add(CoreItems.IRON_GEAR.get());
		this.tag(CoreTags.Items.GEARS_GOLD).add(CoreItems.GOLD_GEAR.get());

		this.tag(ItemTags.PIGLIN_LOVED).add(CoreItems.GOLD_DUST.get(), CoreItems.GOLD_GEAR.get());
	}

	@Override
	public String getName() {
		return "Assorted Core item tags";
	}
}
