package com.grim3212.assorted.core.common.gen;

import com.grim3212.assorted.core.common.gen.feature.CorePlacements;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CoreWorldGeneration {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void generateOverworld(final BiomeLoadingEvent evt) {
		BiomeCategory category = evt.getCategory();
		BiomeGenerationSettingsBuilder builder = evt.getGeneration();

		if (category != Biome.BiomeCategory.NETHER && category != Biome.BiomeCategory.THEEND) {
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_ALUMINUM);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_TIN);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_NICKEL);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_LEAD);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_SILVER);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_PLATINUM);

			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_RUBY);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_SAPPHIRE);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_PERIDOT);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CorePlacements.ORE_TOPAZ);
		}
	}
}
