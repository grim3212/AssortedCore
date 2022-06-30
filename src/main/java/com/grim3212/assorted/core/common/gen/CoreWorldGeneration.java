package com.grim3212.assorted.core.common.gen;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.gen.feature.CoreConfiguredFeatures;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CoreWorldGeneration {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, AssortedCore.MODID);
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, AssortedCore.MODID);

//	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_ALUMINUM_CONFIGURED = CONFIGURED_FEATURES.register("ore_aluminum", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreConfiguredFeatures.ORE_ALUMINUM_TARGET_LIST, 12)));
	public static final RegistryObject<PlacedFeature> ORE_ALUMINUM = PLACED_FEATURES.register("ore_aluminum", () -> new PlacedFeature(ORE_ALUMINUM_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(16), VerticalAnchor.absolute(125)))));

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier modifier) {
		return List.of(p_195347_, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
		return orePlacement(CountPlacement.of(count), modifier);
	}

	static String prefix(String s) {
		return AssortedCore.MODID + ":" + s;
	}
}
