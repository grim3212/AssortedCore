package com.grim3212.assorted.core.common.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.Lists;

import com.google.gson.JsonElement;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.gen.CoreWorldGeneration;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreOreWorldGen {

	public static final ResourceLocation BIOME_MODIFIER_NAME = new ResourceLocation(AssortedCore.MODID, "add_ores");

	public static DataProvider getConfiguredFeatures(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final RegistryAccess registries, final RegistryOps<JsonElement> ops) {
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, AssortedCore.MODID, ops, Registry.CONFIGURED_FEATURE_REGISTRY, getConfiguredFeatures(registries));
	}

	private static Map<ResourceLocation, ConfiguredFeature<?, ?>> getConfiguredFeatures(RegistryAccess registries) {
		Map<ResourceLocation, ConfiguredFeature<?, ?>> map = new HashMap<>();

		CoreWorldGeneration.CONFIGURED_FEATURES.getEntries().forEach((feature) -> {
			Registry<ConfiguredFeature<?, ?>> configuredFeatures = registries.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
			ConfiguredFeature<?, ?> configFeature = configuredFeatures.get(feature.getId());
			map.put(feature.getId(), configFeature);
		});

		return map;
	}

	public static DataProvider getPlacedFeatures(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final RegistryAccess registries, final RegistryOps<JsonElement> ops) {
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, AssortedCore.MODID, ops, Registry.PLACED_FEATURE_REGISTRY, getPlacedFeatures(registries));
	}

	private static Map<ResourceLocation, PlacedFeature> getPlacedFeatures(RegistryAccess registries) {
		Map<ResourceLocation, PlacedFeature> map = new HashMap<>();

		CoreWorldGeneration.PLACED_FEATURES.getEntries().forEach((feature) -> {
			Registry<PlacedFeature> placedFeatures = registries.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);
			PlacedFeature placedFeature = placedFeatures.get(feature.getId());
			map.put(feature.getId(), placedFeature);
		});

		return map;
	}

	public static DataProvider getPlacedFeaturesForBiome(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final RegistryAccess registries, final RegistryOps<JsonElement> ops) {
		final HolderSet.Named<Biome> overworldTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_OVERWORLD);
		final BiomeModifier addOres = new AddFeaturesBiomeModifier(overworldTag, getPlacedFeaturesForBiome(registries), Decoration.UNDERGROUND_ORES);
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, AssortedCore.MODID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS, Map.of(BIOME_MODIFIER_NAME, addOres));
	}

	private static HolderSet.Direct<PlacedFeature> getPlacedFeaturesForBiome(RegistryAccess registries) {
		List<Holder<PlacedFeature>> features = Lists.newArrayList();

		CoreWorldGeneration.PLACED_FEATURES.getEntries().forEach((feature) -> {
			Registry<PlacedFeature> placedFeatures = registries.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);
			features.add(placedFeatures.getHolderOrThrow(feature.getKey()));
		});

		return HolderSet.direct(features);
	}
}
