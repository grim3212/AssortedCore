package com.grim3212.assorted.core.common.gen.feature;

import com.google.common.collect.ImmutableList;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.handler.CoreConfig;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class CoreConfiguredFeatures {

	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_NICKEL_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_LEAD_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SILVER_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PLATINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TOPAZ_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PERIDOT_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, CoreBlocks.PERIDOT_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, CoreBlocks.DEEPSLATE_PERIDOT_ORE.get().defaultBlockState()));

	public static ConfiguredFeature<?, ?> ORE_ALUMINUM = Feature.ORE.configured(new OreConfiguration(ORE_ALUMINUM_TARGET_LIST, CoreConfig.COMMON.veinSizeAluminum.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetAluminum.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelAluminum.get())).squared().count(CoreConfig.COMMON.spawnRateAluminum.get());
	public static ConfiguredFeature<?, ?> ORE_NICKEL = Feature.ORE.configured(new OreConfiguration(ORE_NICKEL_TARGET_LIST, CoreConfig.COMMON.veinSizeNickel.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetNickel.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelNickel.get())).squared().count(CoreConfig.COMMON.spawnRateNickel.get());
	public static ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(new OreConfiguration(ORE_TIN_TARGET_LIST, CoreConfig.COMMON.veinSizeTin.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetTin.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelTin.get())).squared().count(CoreConfig.COMMON.spawnRateTin.get());
	public static ConfiguredFeature<?, ?> ORE_LEAD = Feature.ORE.configured(new OreConfiguration(ORE_LEAD_TARGET_LIST, CoreConfig.COMMON.veinSizeLead.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetLead.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelLead.get())).squared().count(CoreConfig.COMMON.spawnRateLead.get());
	public static ConfiguredFeature<?, ?> ORE_SILVER = Feature.ORE.configured(new OreConfiguration(ORE_SILVER_TARGET_LIST, CoreConfig.COMMON.veinSizeSilver.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetSilver.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelSilver.get())).squared().count(CoreConfig.COMMON.spawnRateSilver.get());
	public static ConfiguredFeature<?, ?> ORE_PLATINUM = Feature.ORE.configured(new OreConfiguration(ORE_PLATINUM_TARGET_LIST, CoreConfig.COMMON.veinSizePlatinum.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetPlatinum.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelPlatinum.get())).squared().count(CoreConfig.COMMON.spawnRatePlatinum.get());

	public static ConfiguredFeature<?, ?> ORE_RUBY = Feature.ORE.configured(new OreConfiguration(ORE_RUBY_TARGET_LIST, CoreConfig.COMMON.veinSizeRuby.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetRuby.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelRuby.get())).squared().count(CoreConfig.COMMON.spawnRateRuby.get());
	public static ConfiguredFeature<?, ?> ORE_SAPPHIRE = Feature.ORE.configured(new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, CoreConfig.COMMON.veinSizeSapphire.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetSapphire.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelSapphire.get())).squared().count(CoreConfig.COMMON.spawnRateSapphire.get());
	public static ConfiguredFeature<?, ?> ORE_TOPAZ = Feature.ORE.configured(new OreConfiguration(ORE_TOPAZ_TARGET_LIST, CoreConfig.COMMON.veinSizeTopaz.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetTopaz.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelTopaz.get())).squared().count(CoreConfig.COMMON.spawnRateTopaz.get());
	public static ConfiguredFeature<?, ?> ORE_PERIDOT = Feature.ORE.configured(new OreConfiguration(ORE_PERIDOT_TARGET_LIST, CoreConfig.COMMON.veinSizePeridot.get())).rangeUniform(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetPeridot.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelPeridot.get())).squared().count(CoreConfig.COMMON.spawnRatePeridot.get());

	public static void registerConfiguredFeatures() {
		Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_aluminum"), ORE_ALUMINUM);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_nickel"), ORE_NICKEL);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_tin"), ORE_TIN);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_lead"), ORE_LEAD);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_silver"), ORE_SILVER);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_platinum"), ORE_PLATINUM);

		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_ruby"), ORE_RUBY);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_sapphire"), ORE_SAPPHIRE);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_topaz"), ORE_TOPAZ);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_peridot"), ORE_PERIDOT);
	}
}
