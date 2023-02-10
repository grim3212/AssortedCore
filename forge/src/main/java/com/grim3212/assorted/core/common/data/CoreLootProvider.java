package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CoreLootProvider extends LootTableProvider {

    public CoreLootProvider(PackOutput output, Set<ResourceLocation> requiredTables, List<LootTableProvider.SubProviderEntry> subProviders) {
        super(output, requiredTables, subProviders);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((location, lootTable) -> {
            LootTables.validate(validationtracker, location, lootTable);
        });
    }

    public static class BlockTables extends VanillaBlockLoot {

        @Override
        protected void generate() {
            this.dropSelf(AssortedCoreBlocks.TIN_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.SILVER_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.ALUMINUM_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.NICKEL_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.PLATINUM_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.LEAD_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.RUBY_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.PERIDOT_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.SAPPHIRE_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.TOPAZ_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.BRONZE_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.ELECTRUM_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.INVAR_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.STEEL_BLOCK.get());

            this.dropSelf(AssortedCoreBlocks.RAW_TIN_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.RAW_SILVER_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.RAW_NICKEL_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get());
            this.dropSelf(AssortedCoreBlocks.RAW_LEAD_BLOCK.get());

            this.dropSelf(AssortedCoreBlocks.MACHINE_CORE.get());
            this.dropSelf(AssortedCoreBlocks.BASIC_ALLOY_FORGE.get());
            this.dropSelf(AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
            this.dropSelf(AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get());
            this.dropSelf(AssortedCoreBlocks.EXPERT_ALLOY_FORGE.get());
            this.dropSelf(AssortedCoreBlocks.BASIC_GRINDING_MILL.get());
            this.dropSelf(AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
            this.dropSelf(AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get());
            this.dropSelf(AssortedCoreBlocks.EXPERT_GRINDING_MILL.get());

            this.add(AssortedCoreBlocks.TIN_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_TIN.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_TIN.get());
            });
            this.add(AssortedCoreBlocks.SILVER_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_SILVER.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_SILVER.get());
            });
            this.add(AssortedCoreBlocks.ALUMINUM_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_ALUMINUM.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_ALUMINUM.get());
            });
            this.add(AssortedCoreBlocks.NICKEL_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_NICKEL.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_NICKEL.get());
            });
            this.add(AssortedCoreBlocks.PLATINUM_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_PLATINUM.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_PLATINUM.get());
            });
            this.add(AssortedCoreBlocks.LEAD_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_LEAD.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RAW_LEAD.get());
            });

            this.add(AssortedCoreBlocks.RUBY_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RUBY.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get(), (ruby) -> {
                return createOreDrop(ruby, AssortedCoreItems.RUBY.get());
            });
            this.add(AssortedCoreBlocks.PERIDOT_ORE.get(), (amethyst) -> {
                return createOreDrop(amethyst, AssortedCoreItems.PERIDOT.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_PERIDOT_ORE.get(), (amethyst) -> {
                return createOreDrop(amethyst, AssortedCoreItems.PERIDOT.get());
            });
            this.add(AssortedCoreBlocks.SAPPHIRE_ORE.get(), (sapphire) -> {
                return createOreDrop(sapphire, AssortedCoreItems.SAPPHIRE.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), (sapphire) -> {
                return createOreDrop(sapphire, AssortedCoreItems.SAPPHIRE.get());
            });
            this.add(AssortedCoreBlocks.TOPAZ_ORE.get(), (topaz) -> {
                return createOreDrop(topaz, AssortedCoreItems.TOPAZ.get());
            });
            this.add(AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get(), (topaz) -> {
                return createOreDrop(topaz, AssortedCoreItems.TOPAZ.get());
            });
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return AssortedCoreBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }
}
