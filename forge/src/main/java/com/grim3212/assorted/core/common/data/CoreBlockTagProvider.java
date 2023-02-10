package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
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
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(AssortedCoreBlocks.TIN_ORE.get(), AssortedCoreBlocks.SILVER_ORE.get(), AssortedCoreBlocks.ALUMINUM_ORE.get(), AssortedCoreBlocks.NICKEL_ORE.get(), AssortedCoreBlocks.PLATINUM_ORE.get(), AssortedCoreBlocks.LEAD_ORE.get(), AssortedCoreBlocks.RUBY_ORE.get(), AssortedCoreBlocks.PERIDOT_ORE.get(), AssortedCoreBlocks.SAPPHIRE_ORE.get(), AssortedCoreBlocks.TOPAZ_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get(), AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get(), AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get(), AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get(), AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get(), AssortedCoreBlocks.PERIDOT_ORE.get(), AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(AssortedCoreBlocks.TIN_BLOCK.get(), AssortedCoreBlocks.SILVER_BLOCK.get(), AssortedCoreBlocks.ALUMINUM_BLOCK.get(), AssortedCoreBlocks.NICKEL_BLOCK.get(), AssortedCoreBlocks.PLATINUM_BLOCK.get(), AssortedCoreBlocks.LEAD_BLOCK.get(), AssortedCoreBlocks.RUBY_BLOCK.get(), AssortedCoreBlocks.PERIDOT_BLOCK.get(), AssortedCoreBlocks.SAPPHIRE_BLOCK.get(), AssortedCoreBlocks.TOPAZ_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(AssortedCoreBlocks.RAW_TIN_BLOCK.get(), AssortedCoreBlocks.RAW_SILVER_BLOCK.get(), AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get(), AssortedCoreBlocks.RAW_NICKEL_BLOCK.get(), AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get(), AssortedCoreBlocks.RAW_LEAD_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(AssortedCoreBlocks.BRONZE_BLOCK.get(), AssortedCoreBlocks.ELECTRUM_BLOCK.get(), AssortedCoreBlocks.INVAR_BLOCK.get(), AssortedCoreBlocks.STEEL_BLOCK.get(), AssortedCoreBlocks.MACHINE_CORE.get(), AssortedCoreBlocks.BASIC_ALLOY_FORGE.get(), AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get(), AssortedCoreBlocks.EXPERT_ALLOY_FORGE.get(), AssortedCoreBlocks.BASIC_GRINDING_MILL.get(), AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get(),
                AssortedCoreBlocks.EXPERT_GRINDING_MILL.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(AssortedCoreBlocks.TIN_ORE.get(), AssortedCoreBlocks.TIN_BLOCK.get(), AssortedCoreBlocks.ALUMINUM_ORE.get(), AssortedCoreBlocks.ALUMINUM_BLOCK.get(), AssortedCoreBlocks.MACHINE_CORE.get(), AssortedCoreBlocks.BASIC_ALLOY_FORGE.get(), AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get(), AssortedCoreBlocks.EXPERT_ALLOY_FORGE.get(), AssortedCoreBlocks.BASIC_GRINDING_MILL.get(), AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get(),
                AssortedCoreBlocks.EXPERT_GRINDING_MILL.get(), AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get(), AssortedCoreBlocks.RAW_TIN_BLOCK.get(), AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(AssortedCoreBlocks.SILVER_ORE.get(), AssortedCoreBlocks.SILVER_BLOCK.get(), AssortedCoreBlocks.NICKEL_ORE.get(), AssortedCoreBlocks.NICKEL_BLOCK.get(), AssortedCoreBlocks.LEAD_ORE.get(), AssortedCoreBlocks.RUBY_ORE.get(), AssortedCoreBlocks.PERIDOT_ORE.get(), AssortedCoreBlocks.SAPPHIRE_ORE.get(), AssortedCoreBlocks.TOPAZ_ORE.get(), AssortedCoreBlocks.LEAD_BLOCK.get(), AssortedCoreBlocks.RUBY_BLOCK.get(), AssortedCoreBlocks.PERIDOT_BLOCK.get(), AssortedCoreBlocks.SAPPHIRE_BLOCK.get(), AssortedCoreBlocks.TOPAZ_BLOCK.get(), AssortedCoreBlocks.BRONZE_BLOCK.get(),
                AssortedCoreBlocks.ELECTRUM_BLOCK.get(), AssortedCoreBlocks.INVAR_BLOCK.get(), AssortedCoreBlocks.STEEL_BLOCK.get(), AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get(), AssortedCoreBlocks.RAW_SILVER_BLOCK.get(), AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get(), AssortedCoreBlocks.RAW_NICKEL_BLOCK.get(), AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get(), AssortedCoreBlocks.RAW_LEAD_BLOCK.get(), AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get(), AssortedCoreBlocks.DEEPSLATE_PERIDOT_ORE.get(), AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(AssortedCoreBlocks.PLATINUM_ORE.get(), AssortedCoreBlocks.PLATINUM_BLOCK.get(), AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get());

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

        this.tag(CoreTags.Blocks.ORES_TIN).add(AssortedCoreBlocks.TIN_ORE.get(), AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get());
        this.tag(CoreTags.Blocks.ORES_COPPER).add(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
        this.tag(CoreTags.Blocks.ORES_SILVER).add(AssortedCoreBlocks.SILVER_ORE.get(), AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get());
        this.tag(CoreTags.Blocks.ORES_ALUMINUM).add(AssortedCoreBlocks.ALUMINUM_ORE.get(), AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        this.tag(CoreTags.Blocks.ORES_NICKEL).add(AssortedCoreBlocks.NICKEL_ORE.get(), AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get());
        this.tag(CoreTags.Blocks.ORES_PLATINUM).add(AssortedCoreBlocks.PLATINUM_ORE.get(), AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
        this.tag(CoreTags.Blocks.ORES_LEAD).add(AssortedCoreBlocks.LEAD_ORE.get(), AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get());
        this.tag(CoreTags.Blocks.ORES_RUBY).add(AssortedCoreBlocks.RUBY_ORE.get(), AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get());
        this.tag(CoreTags.Blocks.ORES_PERIDOT).add(AssortedCoreBlocks.PERIDOT_ORE.get(), AssortedCoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
        this.tag(CoreTags.Blocks.ORES_SAPPHIRE).add(AssortedCoreBlocks.SAPPHIRE_ORE.get(), AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        this.tag(CoreTags.Blocks.ORES_TOPAZ).add(AssortedCoreBlocks.TOPAZ_ORE.get(), AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.TIN_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(Blocks.COPPER_BLOCK);
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.SILVER_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.ALUMINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.NICKEL_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.PLATINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.LEAD_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.RUBY_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.PERIDOT_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.SAPPHIRE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.TOPAZ_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.BRONZE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.ELECTRUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.INVAR_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(AssortedCoreBlocks.STEEL_BLOCK.get());

        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_TIN).add(AssortedCoreBlocks.TIN_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_COPPER).add(Blocks.COPPER_BLOCK);
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_SILVER).add(AssortedCoreBlocks.SILVER_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_ALUMINUM).add(AssortedCoreBlocks.ALUMINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_NICKEL).add(AssortedCoreBlocks.NICKEL_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_PLATINUM).add(AssortedCoreBlocks.PLATINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_LEAD).add(AssortedCoreBlocks.LEAD_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_RUBY).add(AssortedCoreBlocks.RUBY_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_PERIDOT).add(AssortedCoreBlocks.PERIDOT_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_SAPPHIRE).add(AssortedCoreBlocks.SAPPHIRE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_TOPAZ).add(AssortedCoreBlocks.TOPAZ_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_BRONZE).add(AssortedCoreBlocks.BRONZE_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_ELECTRUM).add(AssortedCoreBlocks.ELECTRUM_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_INVAR).add(AssortedCoreBlocks.INVAR_BLOCK.get());
        this.tag(CoreTags.Blocks.STORAGE_BLOCKS_STEEL).add(AssortedCoreBlocks.STEEL_BLOCK.get());

        this.tag(CoreTags.Blocks.STORAGE_BLOCKS).add(Blocks.RAW_COPPER_BLOCK, AssortedCoreBlocks.RAW_TIN_BLOCK.get(), AssortedCoreBlocks.RAW_SILVER_BLOCK.get(), AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get(), AssortedCoreBlocks.RAW_NICKEL_BLOCK.get(), AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get(), AssortedCoreBlocks.RAW_LEAD_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_TIN).add(AssortedCoreBlocks.RAW_TIN_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_COPPER).add(Blocks.RAW_COPPER_BLOCK);
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_SILVER).add(AssortedCoreBlocks.RAW_SILVER_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_ALUMINUM).add(AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_NICKEL).add(AssortedCoreBlocks.RAW_NICKEL_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_PLATINUM).add(AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get());
        this.tag(CoreTags.Blocks.RAW_STORAGE_BLOCKS_LEAD).add(AssortedCoreBlocks.RAW_LEAD_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Assorted Core block tags";
    }
}
