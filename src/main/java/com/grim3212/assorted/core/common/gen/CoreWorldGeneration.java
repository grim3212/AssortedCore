package com.grim3212.assorted.core.common.gen;

import java.util.List;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.core.Registry;
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

	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_ALUMINUM_CONFIGURED = CONFIGURED_FEATURES.register("ore_aluminum", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_ALUMINUM_TARGET_LIST, 12)));
	public static final RegistryObject<PlacedFeature> ORE_ALUMINUM = PLACED_FEATURES.register("ore_aluminum", () -> new PlacedFeature(ORE_ALUMINUM_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(16), VerticalAnchor.absolute(125)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_NICKEL_CONFIGURED = CONFIGURED_FEATURES.register("ore_nickel", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_NICKEL_TARGET_LIST, 9)));
	public static final RegistryObject<PlacedFeature> ORE_NICKEL = PLACED_FEATURES.register("ore_nickel", () -> new PlacedFeature(ORE_NICKEL_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_TIN_CONFIGURED = CONFIGURED_FEATURES.register("ore_tin", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_TIN_TARGET_LIST, 9)));
	public static final RegistryObject<PlacedFeature> ORE_TIN = PLACED_FEATURES.register("ore_tin", () -> new PlacedFeature(ORE_TIN_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(256)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LEAD_CONFIGURED = CONFIGURED_FEATURES.register("ore_lead", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_LEAD_TARGET_LIST, 8)));
	public static final RegistryObject<PlacedFeature> ORE_LEAD = PLACED_FEATURES.register("ore_lead", () -> new PlacedFeature(ORE_LEAD_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SILVER_CONFIGURED = CONFIGURED_FEATURES.register("ore_silver", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_SILVER_TARGET_LIST, 8)));
	public static final RegistryObject<PlacedFeature> ORE_SILVER = PLACED_FEATURES.register("ore_silver", () -> new PlacedFeature(ORE_SILVER_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(12)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_PLATINUM_CONFIGURED = CONFIGURED_FEATURES.register("ore_platinum", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_PLATINUM_TARGET_LIST, 7)));
	public static final RegistryObject<PlacedFeature> ORE_PLATINUM = PLACED_FEATURES.register("ore_platinum", () -> new PlacedFeature(ORE_PLATINUM_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16)))));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_RUBY_CONFIGURED = CONFIGURED_FEATURES.register("ore_ruby", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_RUBY_TARGET_LIST, 8)));
	public static final RegistryObject<PlacedFeature> ORE_RUBY = PLACED_FEATURES.register("ore_ruby", () -> new PlacedFeature(ORE_RUBY_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_SAPPHIRE_CONFIGURED = CONFIGURED_FEATURES.register("ore_sapphire", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_SAPPHIRE_TARGET_LIST, 8)));
	public static final RegistryObject<PlacedFeature> ORE_SAPPHIRE = PLACED_FEATURES.register("ore_sapphire", () -> new PlacedFeature(ORE_SAPPHIRE_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(50)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_TOPAZ_CONFIGURED = CONFIGURED_FEATURES.register("ore_topaz", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_TOPAZ_TARGET_LIST, 8)));
	public static final RegistryObject<PlacedFeature> ORE_TOPAZ = PLACED_FEATURES.register("ore_topaz", () -> new PlacedFeature(ORE_TOPAZ_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)))));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_PERIDOT_CONFIGURED = CONFIGURED_FEATURES.register("ore_peridot", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_PERIDOT_TARGET_LIST, 8)));
	public static final RegistryObject<PlacedFeature> ORE_PERIDOT = PLACED_FEATURES.register("ore_peridot", () -> new PlacedFeature(ORE_PERIDOT_CONFIGURED.getHolder().orElseThrow(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(48), VerticalAnchor.absolute(256)))));
	
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
