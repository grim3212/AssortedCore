package com.grim3212.assorted.core.common.data;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;

public class CoreLootProvider extends LootTableProvider {

	public CoreLootProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
		return ImmutableList.of(Pair.of(BlockTables::new, LootParameterSets.BLOCK));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
	}

	@Override
	public String getName() {
		return "Assorted Core loot tables";
	}

	public static class BlockTables extends BlockLootTables {
		@Override
		protected void addTables() {
			this.registerDropSelfLootTable(CoreBlocks.TIN_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.COPPER_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.SILVER_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.ALUMINUM_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.NICKEL_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.PLATINUM_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.LEAD_ORE.get());
			this.registerDropSelfLootTable(CoreBlocks.TIN_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.COPPER_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.SILVER_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.ALUMINUM_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.NICKEL_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.PLATINUM_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.LEAD_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.RUBY_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.AMETHYST_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.SAPPHIRE_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.TOPAZ_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.BRONZE_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.ELECTRUM_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.INVAR_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.STEEL_BLOCK.get());
			this.registerDropSelfLootTable(CoreBlocks.MACHINE_CORE.get());
			this.registerDropSelfLootTable(CoreBlocks.BASIC_ALLOY_FORGE.get());
			this.registerDropSelfLootTable(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
			this.registerDropSelfLootTable(CoreBlocks.ADVANCED_ALLOY_FORGE.get());
			this.registerDropSelfLootTable(CoreBlocks.EXPERT_ALLOY_FORGE.get());
			this.registerDropSelfLootTable(CoreBlocks.BASIC_GRINDING_MILL.get());
			this.registerDropSelfLootTable(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
			this.registerDropSelfLootTable(CoreBlocks.ADVANCED_GRINDING_MILL.get());
			this.registerDropSelfLootTable(CoreBlocks.EXPERT_GRINDING_MILL.get());

			this.registerLootTable(CoreBlocks.RUBY_ORE.get(), (ruby) -> {
				return droppingItemWithFortune(ruby, CoreItems.RUBY.get());
			});

			this.registerLootTable(CoreBlocks.AMETHYST_ORE.get(), (amethyst) -> {
				return droppingItemWithFortune(amethyst, CoreItems.AMETHYST.get());
			});

			this.registerLootTable(CoreBlocks.SAPPHIRE_ORE.get(), (sapphire) -> {
				return droppingItemWithFortune(sapphire, CoreItems.SAPPHIRE.get());
			});

			this.registerLootTable(CoreBlocks.TOPAZ_ORE.get(), (topaz) -> {
				return droppingItemWithFortune(topaz, CoreItems.TOPAZ.get());
			});
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return CoreBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
		}
	}
}
