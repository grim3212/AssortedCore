package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.block.CoreBlocks;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CoreBlockTagProvider extends BlockTagsProvider {

	public CoreBlockTagProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, AssortedCore.MODID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_TIN);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_COPPER);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_SILVER);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_ALUMINUM);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_NICKEL);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_PLATINUM);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_LEAD);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_RUBY);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_AMETHYST);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_SAPPHIRE);
		this.getOrCreateBuilder(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_TOPAZ);

		this.getOrCreateBuilder(CoreTags.Blocks.ORES_TIN).add(CoreBlocks.TIN_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_COPPER).add(CoreBlocks.COPPER_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_SILVER).add(CoreBlocks.SILVER_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_ALUMINUM).add(CoreBlocks.ALUMINUM_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_NICKEL).add(CoreBlocks.NICKEL_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_PLATINUM).add(CoreBlocks.PLATINUM_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_LEAD).add(CoreBlocks.LEAD_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_RUBY).add(CoreBlocks.RUBY_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_AMETHYST).add(CoreBlocks.AMETHYST_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_SAPPHIRE).add(CoreBlocks.SAPPHIRE_ORE.get());
		this.getOrCreateBuilder(CoreTags.Blocks.ORES_TOPAZ).add(CoreBlocks.TOPAZ_ORE.get());

		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.TIN_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.COPPER_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.SILVER_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.ALUMINUM_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.NICKEL_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.PLATINUM_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.LEAD_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.RUBY_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.AMETHYST_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.SAPPHIRE_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.TOPAZ_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.BRONZE_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.ELECTRUM_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.INVAR_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.STEEL_BLOCK.get());

		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_TIN).add(CoreBlocks.TIN_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_COPPER).add(CoreBlocks.COPPER_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_SILVER).add(CoreBlocks.SILVER_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_ALUMINUM).add(CoreBlocks.ALUMINUM_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_NICKEL).add(CoreBlocks.NICKEL_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_PLATINUM).add(CoreBlocks.PLATINUM_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_LEAD).add(CoreBlocks.LEAD_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_RUBY).add(CoreBlocks.RUBY_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_AMETHYST).add(CoreBlocks.AMETHYST_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_SAPPHIRE).add(CoreBlocks.SAPPHIRE_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_TOPAZ).add(CoreBlocks.TOPAZ_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_BRONZE).add(CoreBlocks.BRONZE_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_ELECTRUM).add(CoreBlocks.ELECTRUM_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_INVAR).add(CoreBlocks.INVAR_BLOCK.get());
		this.getOrCreateBuilder(CoreTags.Blocks.STORAGE_BLOCKS_STEEL).add(CoreBlocks.STEEL_BLOCK.get());
	}

	@Override
	public String getName() {
		return "Assorted Core block tags";
	}
}
