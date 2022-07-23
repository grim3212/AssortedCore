package com.grim3212.assorted.core.common.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.Lists;

import com.google.gson.JsonElement;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.gen.CoreWorldGenTargets;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
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
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreFeatureProvider {

	public static final ResourceLocation BIOME_MODIFIER_NAME = new ResourceLocation(AssortedCore.MODID, "add_ores");

	private static final ResourceLocation ORE_ALUMINUM_KEY = new ResourceLocation(AssortedCore.MODID, "ore_aluminum");
	private static final ResourceLocation ORE_NICKEL_KEY = new ResourceLocation(AssortedCore.MODID, "ore_nickel");
	private static final ResourceLocation ORE_TIN_KEY = new ResourceLocation(AssortedCore.MODID, "ore_tin");
	private static final ResourceLocation ORE_LEAD_KEY = new ResourceLocation(AssortedCore.MODID, "ore_lead");
	private static final ResourceLocation ORE_SILVER_KEY = new ResourceLocation(AssortedCore.MODID, "ore_silver");
	private static final ResourceLocation ORE_PLATINUM_KEY = new ResourceLocation(AssortedCore.MODID, "ore_platinum");

	private static final ResourceLocation ORE_RUBY_KEY = new ResourceLocation(AssortedCore.MODID, "ore_ruby");
	private static final ResourceLocation ORE_SAPPHIRE_KEY = new ResourceLocation(AssortedCore.MODID, "ore_sapphire");
	private static final ResourceLocation ORE_TOPAZ_KEY = new ResourceLocation(AssortedCore.MODID, "ore_topaz");
	private static final ResourceLocation ORE_PERIDOT_KEY = new ResourceLocation(AssortedCore.MODID, "ore_peridot");

	private static ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureResourceKey(ResourceLocation key) {
		return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, key);
	}

	private static ResourceKey<PlacedFeature> placedFeatureResourceKey(ResourceLocation key) {
		return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, key);
	}

	public static DataProvider getConfiguredFeatures(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final RegistryAccess registries, final RegistryOps<JsonElement> ops) {
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, AssortedCore.MODID, ops, Registry.CONFIGURED_FEATURE_REGISTRY, getConfiguredFeatures(registries));
	}

	private static Map<ResourceLocation, ConfiguredFeature<?, ?>> getConfiguredFeatures(RegistryAccess registries) {
		Map<ResourceLocation, ConfiguredFeature<?, ?>> map = new HashMap<>();

		map.put(ORE_ALUMINUM_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_ALUMINUM_TARGET_LIST, 12)));
		map.put(ORE_NICKEL_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_NICKEL_TARGET_LIST, 9)));
		map.put(ORE_TIN_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_TIN_TARGET_LIST, 9)));
		map.put(ORE_LEAD_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_LEAD_TARGET_LIST, 8)));
		map.put(ORE_SILVER_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_SILVER_TARGET_LIST, 8)));
		map.put(ORE_PLATINUM_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_PLATINUM_TARGET_LIST, 7)));

		map.put(ORE_RUBY_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_RUBY_TARGET_LIST, 8)));
		map.put(ORE_SAPPHIRE_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_SAPPHIRE_TARGET_LIST, 8)));
		map.put(ORE_TOPAZ_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_TOPAZ_TARGET_LIST, 8)));
		map.put(ORE_PERIDOT_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(CoreWorldGenTargets.ORE_PERIDOT_TARGET_LIST, 8)));

		return map;
	}

	public static DataProvider getPlacedFeatures(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final RegistryAccess registries, final RegistryOps<JsonElement> ops) {
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, AssortedCore.MODID, ops, Registry.PLACED_FEATURE_REGISTRY, getPlacedFeatures(registries));
	}

	private static Map<ResourceLocation, PlacedFeature> getPlacedFeatures(RegistryAccess registries) {
		Map<ResourceLocation, PlacedFeature> map = new HashMap<>();

		Registry<ConfiguredFeature<?, ?>> configuredFeatures = registries.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);

		map.put(ORE_ALUMINUM_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_ALUMINUM_KEY)), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(16), VerticalAnchor.absolute(125)))));
		map.put(ORE_NICKEL_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_NICKEL_KEY)), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40)))));
		map.put(ORE_TIN_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_TIN_KEY)), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(256)))));
		map.put(ORE_LEAD_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_LEAD_KEY)), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
		map.put(ORE_SILVER_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_SILVER_KEY)), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(12)))));
		map.put(ORE_PLATINUM_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_PLATINUM_KEY)), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16)))));

		map.put(ORE_RUBY_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_RUBY_KEY)), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));
		map.put(ORE_SAPPHIRE_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_SAPPHIRE_KEY)), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(50)))));
		map.put(ORE_TOPAZ_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_TOPAZ_KEY)), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)))));
		map.put(ORE_PERIDOT_KEY, new PlacedFeature(configuredFeatures.getOrCreateHolderOrThrow(configuredFeatureResourceKey(ORE_PERIDOT_KEY)), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(48), VerticalAnchor.absolute(256)))));

		return map;
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier modifier) {
		return List.of(p_195347_, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
		return orePlacement(CountPlacement.of(count), modifier);
	}

	public static DataProvider getPlacedFeaturesForBiome(final DataGenerator generator, final ExistingFileHelper existingFileHelper, final RegistryAccess registries, final RegistryOps<JsonElement> ops) {
		final HolderSet.Named<Biome> overworldTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_OVERWORLD);
		final BiomeModifier addOres = new AddFeaturesBiomeModifier(overworldTag, getPlacedFeaturesForBiome(registries), Decoration.UNDERGROUND_ORES);
		return JsonCodecProvider.forDatapackRegistry(generator, existingFileHelper, AssortedCore.MODID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS, Map.of(BIOME_MODIFIER_NAME, addOres));
	}

	private static HolderSet.Direct<PlacedFeature> getPlacedFeaturesForBiome(RegistryAccess registries) {
		List<Holder<PlacedFeature>> features = Lists.newArrayList();

		Registry<PlacedFeature> placedFeatures = registries.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);

		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_ALUMINUM_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_NICKEL_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_TIN_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_LEAD_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_SILVER_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_PLATINUM_KEY)));

		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_RUBY_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_SAPPHIRE_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_TOPAZ_KEY)));
		features.add(placedFeatures.getOrCreateHolderOrThrow(placedFeatureResourceKey(ORE_PERIDOT_KEY)));

		return HolderSet.direct(features);
	}
}
