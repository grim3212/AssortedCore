package com.grim3212.assorted.core.data;

import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.lib.data.LibBlockLootProvider;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CoreBlockLoot extends LibBlockLootProvider {

    public CoreBlockLoot() {
        super(() -> CoreBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList()));
    }

    @Override
    public void generate() {
        this.dropSelf(CoreBlocks.TIN_BLOCK.get());
        this.dropSelf(CoreBlocks.SILVER_BLOCK.get());
        this.dropSelf(CoreBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(CoreBlocks.NICKEL_BLOCK.get());
        this.dropSelf(CoreBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(CoreBlocks.LEAD_BLOCK.get());
        this.dropSelf(CoreBlocks.RUBY_BLOCK.get());
        this.dropSelf(CoreBlocks.PERIDOT_BLOCK.get());
        this.dropSelf(CoreBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(CoreBlocks.TOPAZ_BLOCK.get());
        this.dropSelf(CoreBlocks.BRONZE_BLOCK.get());
        this.dropSelf(CoreBlocks.ELECTRUM_BLOCK.get());
        this.dropSelf(CoreBlocks.INVAR_BLOCK.get());
        this.dropSelf(CoreBlocks.STEEL_BLOCK.get());

        this.dropSelf(CoreBlocks.RAW_TIN_BLOCK.get());
        this.dropSelf(CoreBlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
        this.dropSelf(CoreBlocks.RAW_NICKEL_BLOCK.get());
        this.dropSelf(CoreBlocks.RAW_PLATINUM_BLOCK.get());
        this.dropSelf(CoreBlocks.RAW_LEAD_BLOCK.get());

        this.dropSelf(CoreBlocks.MACHINE_CORE.get());
        this.dropSelf(CoreBlocks.BASIC_ALLOY_FORGE.get());
        this.dropSelf(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
        this.dropSelf(CoreBlocks.ADVANCED_ALLOY_FORGE.get());
        this.dropSelf(CoreBlocks.EXPERT_ALLOY_FORGE.get());
        this.dropSelf(CoreBlocks.BASIC_GRINDING_MILL.get());
        this.dropSelf(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
        this.dropSelf(CoreBlocks.ADVANCED_GRINDING_MILL.get());
        this.dropSelf(CoreBlocks.EXPERT_GRINDING_MILL.get());

        this.add(CoreBlocks.TIN_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_TIN.get());
        });
        this.add(CoreBlocks.DEEPSLATE_TIN_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_TIN.get());
        });
        this.add(CoreBlocks.SILVER_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_SILVER.get());
        });
        this.add(CoreBlocks.DEEPSLATE_SILVER_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_SILVER.get());
        });
        this.add(CoreBlocks.ALUMINUM_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_ALUMINUM.get());
        });
        this.add(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_ALUMINUM.get());
        });
        this.add(CoreBlocks.NICKEL_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_NICKEL.get());
        });
        this.add(CoreBlocks.DEEPSLATE_NICKEL_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_NICKEL.get());
        });
        this.add(CoreBlocks.PLATINUM_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_PLATINUM.get());
        });
        this.add(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_PLATINUM.get());
        });
        this.add(CoreBlocks.LEAD_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_LEAD.get());
        });
        this.add(CoreBlocks.DEEPSLATE_LEAD_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RAW_LEAD.get());
        });

        this.add(CoreBlocks.RUBY_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RUBY.get());
        });
        this.add(CoreBlocks.DEEPSLATE_RUBY_ORE.get(), (ruby) -> {
            return createOreDrop(ruby, CoreItems.RUBY.get());
        });
        this.add(CoreBlocks.PERIDOT_ORE.get(), (amethyst) -> {
            return createOreDrop(amethyst, CoreItems.PERIDOT.get());
        });
        this.add(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get(), (amethyst) -> {
            return createOreDrop(amethyst, CoreItems.PERIDOT.get());
        });
        this.add(CoreBlocks.SAPPHIRE_ORE.get(), (sapphire) -> {
            return createOreDrop(sapphire, CoreItems.SAPPHIRE.get());
        });
        this.add(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), (sapphire) -> {
            return createOreDrop(sapphire, CoreItems.SAPPHIRE.get());
        });
        this.add(CoreBlocks.TOPAZ_ORE.get(), (topaz) -> {
            return createOreDrop(topaz, CoreItems.TOPAZ.get());
        });
        this.add(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get(), (topaz) -> {
            return createOreDrop(topaz, CoreItems.TOPAZ.get());
        });
    }
}
