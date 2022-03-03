package com.grim3212.assorted.core.common.gen.feature;

import com.google.common.collect.ImmutableList;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.handler.CoreConfig;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class CoreConfiguredFeatures {

	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_NICKEL_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_LEAD_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SILVER_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PLATINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TOPAZ_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PERIDOT_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, CoreBlocks.PERIDOT_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_PERIDOT_ORE.get().defaultBlockState()));

	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ALUMINUM = FeatureUtils.register(CorePlacements.prefix("ore_aluminum"), Feature.ORE, new OreConfiguration(ORE_ALUMINUM_TARGET_LIST, CoreConfig.COMMON.veinSizeAluminum.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_NICKEL = FeatureUtils.register(CorePlacements.prefix("ore_nickel"), Feature.ORE, new OreConfiguration(ORE_NICKEL_TARGET_LIST, CoreConfig.COMMON.veinSizeNickel.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_TIN = FeatureUtils.register(CorePlacements.prefix("ore_tin"), Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, CoreConfig.COMMON.veinSizeTin.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_LEAD = FeatureUtils.register(CorePlacements.prefix("ore_lead"), Feature.ORE, new OreConfiguration(ORE_LEAD_TARGET_LIST, CoreConfig.COMMON.veinSizeLead.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SILVER = FeatureUtils.register(CorePlacements.prefix("ore_silver"), Feature.ORE, new OreConfiguration(ORE_SILVER_TARGET_LIST, CoreConfig.COMMON.veinSizeSilver.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_PLATINUM = FeatureUtils.register(CorePlacements.prefix("ore_platinum"), Feature.ORE, new OreConfiguration(ORE_PLATINUM_TARGET_LIST, CoreConfig.COMMON.veinSizePlatinum.get()));

	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY = FeatureUtils.register(CorePlacements.prefix("ore_ruby"), Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, CoreConfig.COMMON.veinSizeRuby.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE = FeatureUtils.register(CorePlacements.prefix("ore_sapphire"), Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, CoreConfig.COMMON.veinSizeSapphire.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_TOPAZ = FeatureUtils.register(CorePlacements.prefix("ore_topaz"), Feature.ORE, new OreConfiguration(ORE_TOPAZ_TARGET_LIST, CoreConfig.COMMON.veinSizeTopaz.get()));
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_PERIDOT = FeatureUtils.register(CorePlacements.prefix("ore_peridot"), Feature.ORE, new OreConfiguration(ORE_PERIDOT_TARGET_LIST, CoreConfig.COMMON.veinSizePeridot.get()));
}
