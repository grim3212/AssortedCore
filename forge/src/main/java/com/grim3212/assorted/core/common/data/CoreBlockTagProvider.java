package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CoreBlockTagProvider extends BlockTagsProvider {

    public CoreBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CoreBlocks.TIN_ORE.get(), CoreBlocks.SILVER_ORE.get(), CoreBlocks.ALUMINUM_ORE.get(), CoreBlocks.NICKEL_ORE.get(), CoreBlocks.PLATINUM_ORE.get(), CoreBlocks.LEAD_ORE.get(), CoreBlocks.RUBY_ORE.get(), CoreBlocks.PERIDOT_ORE.get(), CoreBlocks.SAPPHIRE_ORE.get(), CoreBlocks.TOPAZ_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CoreBlocks.DEEPSLATE_TIN_ORE.get(), CoreBlocks.DEEPSLATE_SILVER_ORE.get(), CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), CoreBlocks.DEEPSLATE_NICKEL_ORE.get(), CoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), CoreBlocks.DEEPSLATE_LEAD_ORE.get(), CoreBlocks.DEEPSLATE_RUBY_ORE.get(), CoreBlocks.PERIDOT_ORE.get(), CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CoreBlocks.TIN_BLOCK.get(), CoreBlocks.SILVER_BLOCK.get(), CoreBlocks.ALUMINUM_BLOCK.get(), CoreBlocks.NICKEL_BLOCK.get(), CoreBlocks.PLATINUM_BLOCK.get(), CoreBlocks.LEAD_BLOCK.get(), CoreBlocks.RUBY_BLOCK.get(), CoreBlocks.PERIDOT_BLOCK.get(), CoreBlocks.SAPPHIRE_BLOCK.get(), CoreBlocks.TOPAZ_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CoreBlocks.RAW_TIN_BLOCK.get(), CoreBlocks.RAW_SILVER_BLOCK.get(), CoreBlocks.RAW_ALUMINUM_BLOCK.get(), CoreBlocks.RAW_NICKEL_BLOCK.get(), CoreBlocks.RAW_PLATINUM_BLOCK.get(), CoreBlocks.RAW_LEAD_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CoreBlocks.BRONZE_BLOCK.get(), CoreBlocks.ELECTRUM_BLOCK.get(), CoreBlocks.INVAR_BLOCK.get(), CoreBlocks.STEEL_BLOCK.get(), CoreBlocks.MACHINE_CORE.get(), CoreBlocks.BASIC_ALLOY_FORGE.get(), CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), CoreBlocks.ADVANCED_ALLOY_FORGE.get(), CoreBlocks.EXPERT_ALLOY_FORGE.get(), CoreBlocks.BASIC_GRINDING_MILL.get(), CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), CoreBlocks.ADVANCED_GRINDING_MILL.get(),
                CoreBlocks.EXPERT_GRINDING_MILL.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(CoreBlocks.TIN_ORE.get(), CoreBlocks.TIN_BLOCK.get(), CoreBlocks.ALUMINUM_ORE.get(), CoreBlocks.ALUMINUM_BLOCK.get(), CoreBlocks.MACHINE_CORE.get(), CoreBlocks.BASIC_ALLOY_FORGE.get(), CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), CoreBlocks.ADVANCED_ALLOY_FORGE.get(), CoreBlocks.EXPERT_ALLOY_FORGE.get(), CoreBlocks.BASIC_GRINDING_MILL.get(), CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), CoreBlocks.ADVANCED_GRINDING_MILL.get(),
                CoreBlocks.EXPERT_GRINDING_MILL.get(), CoreBlocks.DEEPSLATE_TIN_ORE.get(), CoreBlocks.RAW_TIN_BLOCK.get(), CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), CoreBlocks.RAW_ALUMINUM_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(CoreBlocks.SILVER_ORE.get(), CoreBlocks.SILVER_BLOCK.get(), CoreBlocks.NICKEL_ORE.get(), CoreBlocks.NICKEL_BLOCK.get(), CoreBlocks.LEAD_ORE.get(), CoreBlocks.RUBY_ORE.get(), CoreBlocks.PERIDOT_ORE.get(), CoreBlocks.SAPPHIRE_ORE.get(), CoreBlocks.TOPAZ_ORE.get(), CoreBlocks.LEAD_BLOCK.get(), CoreBlocks.RUBY_BLOCK.get(), CoreBlocks.PERIDOT_BLOCK.get(), CoreBlocks.SAPPHIRE_BLOCK.get(), CoreBlocks.TOPAZ_BLOCK.get(), CoreBlocks.BRONZE_BLOCK.get(),
                CoreBlocks.ELECTRUM_BLOCK.get(), CoreBlocks.INVAR_BLOCK.get(), CoreBlocks.STEEL_BLOCK.get(), CoreBlocks.DEEPSLATE_SILVER_ORE.get(), CoreBlocks.RAW_SILVER_BLOCK.get(), CoreBlocks.DEEPSLATE_NICKEL_ORE.get(), CoreBlocks.RAW_NICKEL_BLOCK.get(), CoreBlocks.DEEPSLATE_LEAD_ORE.get(), CoreBlocks.RAW_LEAD_BLOCK.get(), CoreBlocks.DEEPSLATE_RUBY_ORE.get(), CoreBlocks.DEEPSLATE_PERIDOT_ORE.get(), CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(CoreBlocks.PLATINUM_ORE.get(), CoreBlocks.PLATINUM_BLOCK.get(), CoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), CoreBlocks.RAW_PLATINUM_BLOCK.get());

        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_TIN);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_COPPER);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_SILVER);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_ALUMINUM);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_NICKEL);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_PLATINUM);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_LEAD);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_RUBY);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_PERIDOT);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_SAPPHIRE);
        this.tag(CoreTags.Blocks.ORES).addTag(CoreTags.Blocks.ORES_TOPAZ);

        this.tag(CoreTags.Blocks.ORES_TIN).add(CoreBlocks.TIN_ORE.get(), CoreBlocks.DEEPSLATE_TIN_ORE.get());
        this.tag(CoreTags.Blocks.ORES_COPPER).add(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
        this.tag(CoreTags.Blocks.ORES_SILVER).add(CoreBlocks.SILVER_ORE.get(), CoreBlocks.DEEPSLATE_SILVER_ORE.get());
        this.tag(CoreTags.Blocks.ORES_ALUMINUM).add(CoreBlocks.ALUMINUM_ORE.get(), CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        this.tag(CoreTags.Blocks.ORES_NICKEL).add(CoreBlocks.NICKEL_ORE.get(), CoreBlocks.DEEPSLATE_NICKEL_ORE.get());
        this.tag(CoreTags.Blocks.ORES_PLATINUM).add(CoreBlocks.PLATINUM_ORE.get(), CoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
        this.tag(CoreTags.Blocks.ORES_LEAD).add(CoreBlocks.LEAD_ORE.get(), CoreBlocks.DEEPSLATE_LEAD_ORE.get());
        this.tag(CoreTags.Blocks.ORES_RUBY).add(CoreBlocks.RUBY_ORE.get(), CoreBlocks.DEEPSLATE_RUBY_ORE.get());
        this.tag(CoreTags.Blocks.ORES_PERIDOT).add(CoreBlocks.PERIDOT_ORE.get(), CoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
        this.tag(CoreTags.Blocks.ORES_SAPPHIRE).add(CoreBlocks.SAPPHIRE_ORE.get(), CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        this.tag(CoreTags.Blocks.ORES_TOPAZ).add(CoreBlocks.TOPAZ_ORE.get(), CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.TIN_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(Blocks.COPPER_BLOCK);
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.SILVER_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.ALUMINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.NICKEL_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.PLATINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.LEAD_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.RUBY_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.PERIDOT_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.SAPPHIRE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.TOPAZ_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.BRONZE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.ELECTRUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.INVAR_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(CoreBlocks.STEEL_BLOCK.get());

        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_TIN).add(CoreBlocks.TIN_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_COPPER).add(Blocks.COPPER_BLOCK);
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_SILVER).add(CoreBlocks.SILVER_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_ALUMINUM).add(CoreBlocks.ALUMINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_NICKEL).add(CoreBlocks.NICKEL_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_PLATINUM).add(CoreBlocks.PLATINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_LEAD).add(CoreBlocks.LEAD_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_RUBY).add(CoreBlocks.RUBY_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_PERIDOT).add(CoreBlocks.PERIDOT_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_SAPPHIRE).add(CoreBlocks.SAPPHIRE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_TOPAZ).add(CoreBlocks.TOPAZ_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_BRONZE).add(CoreBlocks.BRONZE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_ELECTRUM).add(CoreBlocks.ELECTRUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_INVAR).add(CoreBlocks.INVAR_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_STEEL).add(CoreBlocks.STEEL_BLOCK.get());

        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(Blocks.RAW_COPPER_BLOCK, CoreBlocks.RAW_TIN_BLOCK.get(), CoreBlocks.RAW_SILVER_BLOCK.get(), CoreBlocks.RAW_ALUMINUM_BLOCK.get(), CoreBlocks.RAW_NICKEL_BLOCK.get(), CoreBlocks.RAW_PLATINUM_BLOCK.get(), CoreBlocks.RAW_LEAD_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_TIN).add(CoreBlocks.RAW_TIN_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_COPPER).add(Blocks.RAW_COPPER_BLOCK);
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_SILVER).add(CoreBlocks.RAW_SILVER_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_ALUMINUM).add(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_NICKEL).add(CoreBlocks.RAW_NICKEL_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_PLATINUM).add(CoreBlocks.RAW_PLATINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_LEAD).add(CoreBlocks.RAW_LEAD_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Assorted Core block tags";
    }
}
