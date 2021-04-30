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

	public static ConfiguredFeature<?, ?> ORE_ALUMINUM = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.ALUMINUM_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeAluminum.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetAluminum.get(), CoreConfig.COMMON.topOffsetAluminum.get(), CoreConfig.COMMON.maxSpawnLevelAluminum.get()))).square().count(CoreConfig.COMMON.spawnRateAluminum.get());
	public static ConfiguredFeature<?, ?> ORE_COPPER = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.COPPER_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeCopper.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetCopper.get(), CoreConfig.COMMON.topOffsetCopper.get(), CoreConfig.COMMON.maxSpawnLevelCopper.get()))).square().count(CoreConfig.COMMON.spawnRateCopper.get());
	public static ConfiguredFeature<?, ?> ORE_NICKEL = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.NICKEL_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeNickel.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetNickel.get(), CoreConfig.COMMON.topOffsetNickel.get(), CoreConfig.COMMON.maxSpawnLevelNickel.get()))).square().count(CoreConfig.COMMON.spawnRateNickel.get());
	public static ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.TIN_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeTin.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetTin.get(), CoreConfig.COMMON.topOffsetTin.get(), CoreConfig.COMMON.maxSpawnLevelTin.get()))).square().count(CoreConfig.COMMON.spawnRateTin.get());
	public static ConfiguredFeature<?, ?> ORE_LEAD = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.LEAD_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeLead.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetLead.get(), CoreConfig.COMMON.topOffsetLead.get(), CoreConfig.COMMON.maxSpawnLevelLead.get()))).square().count(CoreConfig.COMMON.spawnRateLead.get());
	public static ConfiguredFeature<?, ?> ORE_SILVER = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.SILVER_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeSilver.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetSilver.get(), CoreConfig.COMMON.topOffsetSilver.get(), CoreConfig.COMMON.maxSpawnLevelSilver.get()))).square().count(CoreConfig.COMMON.spawnRateSilver.get());
	public static ConfiguredFeature<?, ?> ORE_PLATINUM = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.PLATINUM_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizePlatinum.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetPlatinum.get(), CoreConfig.COMMON.topOffsetPlatinum.get(), CoreConfig.COMMON.maxSpawnLevelPlatinum.get()))).square().count(CoreConfig.COMMON.spawnRatePlatinum.get());
	
	
	public static ConfiguredFeature<?, ?> ORE_RUBY = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.RUBY_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeRuby.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetRuby.get(), CoreConfig.COMMON.topOffsetRuby.get(), CoreConfig.COMMON.maxSpawnLevelRuby.get()))).square().count(CoreConfig.COMMON.spawnRateRuby.get());
	public static ConfiguredFeature<?, ?> ORE_SAPPHIRE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.SAPPHIRE_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeSapphire.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetSapphire.get(), CoreConfig.COMMON.topOffsetSapphire.get(), CoreConfig.COMMON.maxSpawnLevelSapphire.get()))).square().count(CoreConfig.COMMON.spawnRateSapphire.get());
	public static ConfiguredFeature<?, ?> ORE_TOPAZ = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.TOPAZ_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeTopaz.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetTopaz.get(), CoreConfig.COMMON.topOffsetTopaz.get(), CoreConfig.COMMON.maxSpawnLevelTopaz.get()))).square().count(CoreConfig.COMMON.spawnRateTopaz.get());
	public static ConfiguredFeature<?, ?> ORE_AMETHYST = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CoreBlocks.AMETHYST_ORE.get().getDefaultState(), CoreConfig.COMMON.veinSizeAmethyst.get()))
			.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(CoreConfig.COMMON.botOffsetAmethyst.get(), CoreConfig.COMMON.topOffsetAmethyst.get(), CoreConfig.COMMON.maxSpawnLevelAmethyst.get()))).square().count(CoreConfig.COMMON.spawnRateAmethyst.get());

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
