package com.grim3212.assorted.core.common.data;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.gen.CoreWorldGeneration;
import com.mojang.serialization.JsonOps;

import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
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

public class CoreOreModifier {

	private final DataGenerator generator;
	private final ExistingFileHelper existingFileHelper;
	public static final ResourceLocation NAME = new ResourceLocation(AssortedCore.MODID, "add_ores");
	private final RegistryAccess registries;
	private final RegistryOps<JsonElement> ops;

	public CoreOreModifier(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		this.generator = generator;
		this.existingFileHelper = existingFileHelper;

		registries = RegistryAccess.builtinCopy();
		ops = RegistryOps.create(JsonOps.INSTANCE, registries);
	}

}
