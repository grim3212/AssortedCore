package com.grim3212.assorted.core.common.gen.feature;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.handler.CoreConfig;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class CoreConfiguredFeatures {

	public static ConfiguredFeature<?, ?> ORE_ALUMINUM = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.ALUMINUM_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeAluminum.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetAluminum.get(), CoreConfig.COMMON.topOffsetAluminum.get(), CoreConfig.COMMON.maxSpawnLevelAluminum.get()))).squared().count(CoreConfig.COMMON.spawnRateAluminum.get());
	public static ConfiguredFeature<?, ?> ORE_COPPER = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.COPPER_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeCopper.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetCopper.get(), CoreConfig.COMMON.topOffsetCopper.get(), CoreConfig.COMMON.maxSpawnLevelCopper.get()))).squared().count(CoreConfig.COMMON.spawnRateCopper.get());
	public static ConfiguredFeature<?, ?> ORE_NICKEL = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.NICKEL_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeNickel.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetNickel.get(), CoreConfig.COMMON.topOffsetNickel.get(), CoreConfig.COMMON.maxSpawnLevelNickel.get()))).squared().count(CoreConfig.COMMON.spawnRateNickel.get());
	public static ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.TIN_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeTin.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetTin.get(), CoreConfig.COMMON.topOffsetTin.get(), CoreConfig.COMMON.maxSpawnLevelTin.get()))).squared().count(CoreConfig.COMMON.spawnRateTin.get());
	public static ConfiguredFeature<?, ?> ORE_LEAD = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.LEAD_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeLead.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetLead.get(), CoreConfig.COMMON.topOffsetLead.get(), CoreConfig.COMMON.maxSpawnLevelLead.get()))).squared().count(CoreConfig.COMMON.spawnRateLead.get());
	public static ConfiguredFeature<?, ?> ORE_SILVER = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.SILVER_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeSilver.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetSilver.get(), CoreConfig.COMMON.topOffsetSilver.get(), CoreConfig.COMMON.maxSpawnLevelSilver.get()))).squared().count(CoreConfig.COMMON.spawnRateSilver.get());
	public static ConfiguredFeature<?, ?> ORE_PLATINUM = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.PLATINUM_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizePlatinum.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetPlatinum.get(), CoreConfig.COMMON.topOffsetPlatinum.get(), CoreConfig.COMMON.maxSpawnLevelPlatinum.get()))).squared().count(CoreConfig.COMMON.spawnRatePlatinum.get());
	
	
	public static ConfiguredFeature<?, ?> ORE_RUBY = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.RUBY_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeRuby.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetRuby.get(), CoreConfig.COMMON.topOffsetRuby.get(), CoreConfig.COMMON.maxSpawnLevelRuby.get()))).squared().count(CoreConfig.COMMON.spawnRateRuby.get());
	public static ConfiguredFeature<?, ?> ORE_SAPPHIRE = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.SAPPHIRE_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeSapphire.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetSapphire.get(), CoreConfig.COMMON.topOffsetSapphire.get(), CoreConfig.COMMON.maxSpawnLevelSapphire.get()))).squared().count(CoreConfig.COMMON.spawnRateSapphire.get());
	public static ConfiguredFeature<?, ?> ORE_TOPAZ = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.TOPAZ_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeTopaz.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetTopaz.get(), CoreConfig.COMMON.topOffsetTopaz.get(), CoreConfig.COMMON.maxSpawnLevelTopaz.get()))).squared().count(CoreConfig.COMMON.spawnRateTopaz.get());
	public static ConfiguredFeature<?, ?> ORE_AMETHYST = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CoreBlocks.AMETHYST_ORE.get().defaultBlockState(), CoreConfig.COMMON.veinSizeAmethyst.get()))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetAmethyst.get(), CoreConfig.COMMON.topOffsetAmethyst.get(), CoreConfig.COMMON.maxSpawnLevelAmethyst.get()))).squared().count(CoreConfig.COMMON.spawnRateAmethyst.get());

	public static void registerConfiguredFeatures() {
		Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_aluminum"), ORE_ALUMINUM);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_copper"), ORE_COPPER);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_nickel"), ORE_NICKEL);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_tin"), ORE_TIN);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_lead"), ORE_LEAD);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_silver"), ORE_SILVER);
		Registry.register(registry, new ResourceLocation(AssortedCore.MODID, "ore_platinum"), ORE_PLATINUM);
	}
}
