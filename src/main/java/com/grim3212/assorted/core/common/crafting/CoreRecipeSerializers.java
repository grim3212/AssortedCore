package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipeSerializer;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipeSerializer;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreRecipeSerializers {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AssortedCore.MODID);

	public static final RegistryObject<RecipeSerializer<?>> ALLOY_FORGE = RECIPE_SERIALIZERS.register("alloy_forge", AlloyForgeRecipeSerializer::new);
	public static final RegistryObject<RecipeSerializer<?>> GRINDING_MILL = RECIPE_SERIALIZERS.register("grinding_mill", GrindingMillRecipeSerializer::new);
}
