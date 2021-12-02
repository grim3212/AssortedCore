package com.grim3212.assorted.core.common.gen.feature;

import java.util.List;

import com.grim3212.assorted.core.common.handler.CoreConfig;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class CorePlacements {

	public static final PlacedFeature ORE_ALUMINUM = PlacementUtils.register("ore_aluminum", CoreConfiguredFeatures.ORE_ALUMINUM.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateAluminum.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetAluminum.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelAluminum.get())))));
	public static final PlacedFeature ORE_NICKEL = PlacementUtils.register("ore_nickel", CoreConfiguredFeatures.ORE_NICKEL.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateNickel.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetNickel.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelNickel.get())))));
	public static final PlacedFeature ORE_TIN = PlacementUtils.register("ore_tin", CoreConfiguredFeatures.ORE_TIN.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateTin.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetTin.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelTin.get())))));
	public static final PlacedFeature ORE_LEAD = PlacementUtils.register("ore_lead", CoreConfiguredFeatures.ORE_LEAD.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateLead.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetLead.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelLead.get())))));
	public static final PlacedFeature ORE_SILVER = PlacementUtils.register("ore_silver", CoreConfiguredFeatures.ORE_SILVER.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateSilver.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetSilver.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelSilver.get())))));
	public static final PlacedFeature ORE_PLATINUM = PlacementUtils.register("ore_platinum", CoreConfiguredFeatures.ORE_PLATINUM.placed(commonOrePlacement(CoreConfig.COMMON.spawnRatePlatinum.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetPlatinum.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelPlatinum.get())))));
	
	public static final PlacedFeature ORE_RUBY = PlacementUtils.register("ore_ruby", CoreConfiguredFeatures.ORE_RUBY.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateRuby.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetRuby.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelRuby.get())))));
	public static final PlacedFeature ORE_SAPPHIRE = PlacementUtils.register("ore_sapphire", CoreConfiguredFeatures.ORE_SAPPHIRE.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateSapphire.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetSapphire.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelSapphire.get())))));
	public static final PlacedFeature ORE_TOPAZ = PlacementUtils.register("ore_topaz", CoreConfiguredFeatures.ORE_TOPAZ.placed(commonOrePlacement(CoreConfig.COMMON.spawnRateTopaz.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetTopaz.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelTopaz.get())))));
	public static final PlacedFeature ORE_PERIDOT = PlacementUtils.register("ore_peridot", CoreConfiguredFeatures.ORE_PERIDOT.placed(commonOrePlacement(CoreConfig.COMMON.spawnRatePeridot.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetPeridot.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelPeridot.get())))));
	
	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier modifier) {
		return List.of(p_195347_, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
		return orePlacement(CountPlacement.of(count), modifier);
	}
}
