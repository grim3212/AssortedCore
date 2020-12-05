package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.lib.CoreTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CoreItemTagProvider extends ItemTagsProvider {

	public CoreItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, AssortedCore.MODID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		this.copy(CoreTags.Blocks.ORES, CoreTags.Items.ORES);
		this.copy(CoreTags.Blocks.ORES_TIN, CoreTags.Items.ORES_TIN);
		this.copy(CoreTags.Blocks.ORES_COPPER, CoreTags.Items.ORES_COPPER);
		this.copy(CoreTags.Blocks.ORES_SILVER, CoreTags.Items.ORES_SILVER);
		this.copy(CoreTags.Blocks.ORES_ALUMINUM, CoreTags.Items.ORES_ALUMINUM);
		this.copy(CoreTags.Blocks.ORES_NICKEL, CoreTags.Items.ORES_NICKEL);
		this.copy(CoreTags.Blocks.ORES_PLATINUM, CoreTags.Items.ORES_PLATINUM);
		this.copy(CoreTags.Blocks.ORES_LEAD, CoreTags.Items.ORES_LEAD);
		this.copy(CoreTags.Blocks.ORES_RUBY, CoreTags.Items.ORES_RUBY);
		this.copy(CoreTags.Blocks.ORES_AMETHYST, CoreTags.Items.ORES_AMETHYST);
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
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_AMETHYST, CoreTags.Items.STORAGE_BLOCKS_AMETHYST);
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE);
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.STORAGE_BLOCKS_TOPAZ);
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_BRONZE, CoreTags.Items.STORAGE_BLOCKS_BRONZE);
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.STORAGE_BLOCKS_ELECTRUM);
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_INVAR, CoreTags.Items.STORAGE_BLOCKS_INVAR);
		this.copy(CoreTags.Blocks.STORAGE_BLOCKS_STEEL, CoreTags.Items.STORAGE_BLOCKS_STEEL);

		this.getOrCreateBuilder(CoreTags.Items.GEMS).add(CoreItems.RUBY.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS).add(CoreItems.AMETHYST.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS).add(CoreItems.SAPPHIRE.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS).add(CoreItems.TOPAZ.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_RUBY).add(CoreItems.RUBY.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_AMETHYST).add(CoreItems.AMETHYST.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_SAPPHIRE).add(CoreItems.SAPPHIRE.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_TOPAZ).add(CoreItems.TOPAZ.get());
		
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.TIN_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.COPPER_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.SILVER_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.ALUMINUM_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.NICKEL_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.PLATINUM_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.LEAD_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.BRONZE_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.ELECTRUM_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.INVAR_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS).add(CoreItems.STEEL_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_TIN).add(CoreItems.TIN_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_COPPER).add(CoreItems.COPPER_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_SILVER).add(CoreItems.SILVER_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_ALUMINUM).add(CoreItems.ALUMINUM_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_NICKEL).add(CoreItems.NICKEL_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_PLATINUM).add(CoreItems.PLATINUM_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_LEAD).add(CoreItems.LEAD_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_BRONZE).add(CoreItems.BRONZE_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_ELECTRUM).add(CoreItems.ELECTRUM_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_INVAR).add(CoreItems.INVAR_INGOT.get());
		this.getOrCreateBuilder(CoreTags.Items.INGOTS_STEEL).add(CoreItems.STEEL_INGOT.get());
		
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.TIN_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.COPPER_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.SILVER_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.ALUMINUM_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.NICKEL_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.PLATINUM_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.LEAD_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.BRONZE_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.ELECTRUM_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.INVAR_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS).add(CoreItems.STEEL_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_TIN).add(CoreItems.TIN_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_COPPER).add(CoreItems.COPPER_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_SILVER).add(CoreItems.SILVER_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_ALUMINUM).add(CoreItems.ALUMINUM_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_NICKEL).add(CoreItems.NICKEL_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_PLATINUM).add(CoreItems.PLATINUM_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_LEAD).add(CoreItems.LEAD_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_BRONZE).add(CoreItems.BRONZE_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_ELECTRUM).add(CoreItems.ELECTRUM_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_INVAR).add(CoreItems.INVAR_NUGGET.get());
		this.getOrCreateBuilder(CoreTags.Items.NUGGETS_STEEL).add(CoreItems.STEEL_NUGGET.get());
		
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.TIN_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.COPPER_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.SILVER_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.ALUMINUM_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.NICKEL_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.PLATINUM_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.LEAD_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.BRONZE_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.ELECTRUM_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.INVAR_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS).add(CoreItems.STEEL_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_TIN).add(CoreItems.TIN_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_COPPER).add(CoreItems.COPPER_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_SILVER).add(CoreItems.SILVER_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_ALUMINUM).add(CoreItems.ALUMINUM_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_NICKEL).add(CoreItems.NICKEL_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_PLATINUM).add(CoreItems.PLATINUM_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_LEAD).add(CoreItems.LEAD_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_BRONZE).add(CoreItems.BRONZE_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_ELECTRUM).add(CoreItems.ELECTRUM_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_INVAR).add(CoreItems.INVAR_DUST.get());
		this.getOrCreateBuilder(CoreTags.Items.DUSTS_STEEL).add(CoreItems.STEEL_DUST.get());
	}

	@Override
	public String getName() {
		return "Assorted Core item tags";
	}
}
