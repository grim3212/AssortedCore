package com.grim3212.assorted.core.common.gen.feature;

import java.util.List;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class CorePlacements {

//	public static final Holder<PlacedFeature> ORE_ALUMINUM = PlacementUtils.register(prefix("ore_aluminum"), CoreConfiguredFeatures.ORE_ALUMINUM, commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(16), VerticalAnchor.absolute(125))));
//	public static final Holder<PlacedFeature> ORE_NICKEL = PlacementUtils.register(prefix("ore_nickel"), CoreConfiguredFeatures.ORE_NICKEL, commonOrePlacement(CoreConfig.COMMON.spawnRateNickel.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetNickel.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelNickel.get()))));
//	public static final Holder<PlacedFeature> ORE_TIN = PlacementUtils.register(prefix("ore_tin"), CoreConfiguredFeatures.ORE_TIN, commonOrePlacement(CoreConfig.COMMON.spawnRateTin.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetTin.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelTin.get()))));
//	public static final Holder<PlacedFeature> ORE_LEAD = PlacementUtils.register(prefix("ore_lead"), CoreConfiguredFeatures.ORE_LEAD, commonOrePlacement(CoreConfig.COMMON.spawnRateLead.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetLead.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelLead.get()))));
//	public static final Holder<PlacedFeature> ORE_SILVER = PlacementUtils.register(prefix("ore_silver"), CoreConfiguredFeatures.ORE_SILVER, commonOrePlacement(CoreConfig.COMMON.spawnRateSilver.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetSilver.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelSilver.get()))));
//	public static final Holder<PlacedFeature> ORE_PLATINUM = PlacementUtils.register(prefix("ore_platinum"), CoreConfiguredFeatures.ORE_PLATINUM, commonOrePlacement(CoreConfig.COMMON.spawnRatePlatinum.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetPlatinum.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelPlatinum.get()))));
//
//	public static final Holder<PlacedFeature> ORE_RUBY = PlacementUtils.register(prefix("ore_ruby"), CoreConfiguredFeatures.ORE_RUBY, commonOrePlacement(CoreConfig.COMMON.spawnRateRuby.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetRuby.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelRuby.get()))));
//	public static final Holder<PlacedFeature> ORE_SAPPHIRE = PlacementUtils.register(prefix("ore_sapphire"), CoreConfiguredFeatures.ORE_SAPPHIRE, commonOrePlacement(CoreConfig.COMMON.spawnRateSapphire.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetSapphire.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelSapphire.get()))));
//	public static final Holder<PlacedFeature> ORE_TOPAZ = PlacementUtils.register(prefix("ore_topaz"), CoreConfiguredFeatures.ORE_TOPAZ, commonOrePlacement(CoreConfig.COMMON.spawnRateTopaz.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetTopaz.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelTopaz.get()))));
//	public static final Holder<PlacedFeature> ORE_PERIDOT = PlacementUtils.register(prefix("ore_peridot"), CoreConfiguredFeatures.ORE_PERIDOT, commonOrePlacement(CoreConfig.COMMON.spawnRatePeridot.get(), HeightRangePlacement.triangle(VerticalAnchor.absolute(CoreConfig.COMMON.botOffsetPeridot.get()), VerticalAnchor.absolute(CoreConfig.COMMON.maxSpawnLevelPeridot.get()))));

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
