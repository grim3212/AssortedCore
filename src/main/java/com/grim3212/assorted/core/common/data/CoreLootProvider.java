package com.grim3212.assorted.core.common.data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;

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

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return CoreBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
		}
	}
}
