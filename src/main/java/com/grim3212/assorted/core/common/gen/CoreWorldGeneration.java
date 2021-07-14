package com.grim3212.assorted.core.common.gen;

import com.grim3212.assorted.core.common.gen.feature.CoreConfiguredFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CoreWorldGeneration {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void generateOverworld(final BiomeLoadingEvent evt) {
		Category category = evt.getCategory();
		BiomeGenerationSettingsBuilder builder = evt.getGeneration();

		if (category != Biome.Category.NETHER && category != Biome.Category.THEEND) {
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_ALUMINUM);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_COPPER);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_TIN);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_NICKEL);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_LEAD);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_SILVER);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_PLATINUM);

			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_RUBY);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_SAPPHIRE);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_AMETHYST);
			builder.addFeature(Decoration.UNDERGROUND_ORES, CoreConfiguredFeatures.ORE_TOPAZ);
		}
	}
}
