package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.worldgen.CoreWorldGenTargets;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.utils.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CoreFeatureProvider {

    public static final ResourceLocation BIOME_MODIFIER_NAME = new ResourceLocation(Constants.MOD_ID, "add_ores");

    private static final ResourceLocation ORE_ALUMINUM_KEY = new ResourceLocation(Constants.MOD_ID, "ore_aluminum");
    private static final ResourceLocation ORE_NICKEL_KEY = new ResourceLocation(Constants.MOD_ID, "ore_nickel");
    private static final ResourceLocation ORE_TIN_KEY = new ResourceLocation(Constants.MOD_ID, "ore_tin");
    private static final ResourceLocation ORE_LEAD_KEY = new ResourceLocation(Constants.MOD_ID, "ore_lead");
    private static final ResourceLocation ORE_SILVER_KEY = new ResourceLocation(Constants.MOD_ID, "ore_silver");
    private static final ResourceLocation ORE_PLATINUM_KEY = new ResourceLocation(Constants.MOD_ID, "ore_platinum");

    private static final ResourceLocation ORE_RUBY_KEY = new ResourceLocation(Constants.MOD_ID, "ore_ruby");
    private static final ResourceLocation ORE_SAPPHIRE_KEY = new ResourceLocation(Constants.MOD_ID, "ore_sapphire");
    private static final ResourceLocation ORE_TOPAZ_KEY = new ResourceLocation(Constants.MOD_ID, "ore_topaz");
    private static final ResourceLocation ORE_PERIDOT_KEY = new ResourceLocation(Constants.MOD_ID, "ore_peridot");

    private static ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureResourceKey(ResourceLocation key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, key);
    }

    private static ResourceKey<PlacedFeature> placedFeatureResourceKey(ResourceLocation key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, key);
    }

    public static DatapackBuiltinEntriesProvider datpackEntriesProvider(final PackOutput output, final CompletableFuture<HolderLookup.Provider> registries) {
        RegistrySetBuilder coreBuilder = new RegistrySetBuilder();

        coreBuilder.add(Registries.CONFIGURED_FEATURE, context -> {
            getConfiguredFeatures().forEach((r, f) -> {
                context.register(ResourceKey.create(Registries.CONFIGURED_FEATURE, r), f);
            });
        });

        coreBuilder.add(Registries.PLACED_FEATURE, context -> {
            getPlacedFeatures(context).forEach((r, f) -> {
                context.register(ResourceKey.create(Registries.PLACED_FEATURE, r), f);
            });
        });

        coreBuilder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
            final HolderSet.Named<Biome> overworldTag = context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD);
            final BiomeModifier addOres = new AddFeaturesBiomeModifier(overworldTag, getPlacedFeaturesForBiome(context), Decoration.UNDERGROUND_ORES);
            context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, BIOME_MODIFIER_NAME), addOres);
        });

        return new DatapackBuiltinEntriesProvider(output, registries, coreBuilder, Set.of(Constants.MOD_ID));
    }

    private static Map<ResourceLocation, ConfiguredFeature<?, ?>> getConfiguredFeatures() {
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

    private static Map<ResourceLocation, PlacedFeature> getPlacedFeatures(BootstapContext<PlacedFeature> context) {
        Map<ResourceLocation, PlacedFeature> map = new HashMap<>();

        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        map.put(ORE_ALUMINUM_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_ALUMINUM_KEY)), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(16), VerticalAnchor.absolute(125)))));
        map.put(ORE_NICKEL_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_NICKEL_KEY)), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40)))));
        map.put(ORE_TIN_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_TIN_KEY)), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(256)))));
        map.put(ORE_LEAD_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_LEAD_KEY)), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
        map.put(ORE_SILVER_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_SILVER_KEY)), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(12)))));
        map.put(ORE_PLATINUM_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_PLATINUM_KEY)), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16)))));

        map.put(ORE_RUBY_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_RUBY_KEY)), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));
        map.put(ORE_SAPPHIRE_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_SAPPHIRE_KEY)), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(50)))));
        map.put(ORE_TOPAZ_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_TOPAZ_KEY)), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)))));
        map.put(ORE_PERIDOT_KEY, new PlacedFeature(holderGetter.getOrThrow(configuredFeatureResourceKey(ORE_PERIDOT_KEY)), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(48), VerticalAnchor.absolute(256)))));

        return map;
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier modifier) {
        return List.of(p_195347_, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(count), modifier);
    }

    private static HolderSet.Direct<PlacedFeature> getPlacedFeaturesForBiome(BootstapContext<BiomeModifier> context) {
        List<Holder<PlacedFeature>> features = Lists.newArrayList();
        HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);

        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_ALUMINUM_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_NICKEL_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_TIN_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_LEAD_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_SILVER_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_PLATINUM_KEY)));

        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_RUBY_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_SAPPHIRE_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_TOPAZ_KEY)));
        features.add(holdergetter.getOrThrow(placedFeatureResourceKey(ORE_PERIDOT_KEY)));

        return HolderSet.direct(features);
    }
}
