package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipe;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreRecipeTypes {

	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, AssortedCore.MODID);

	public static final RegistryObject<RecipeType<AlloyForgeRecipe>> ALLOY_FORGE = RECIPE_TYPES.register("alloy_forge", () -> RecipeType.simple(new ResourceLocation(AssortedCore.MODID, "alloy_forge")));
	public static final RegistryObject<RecipeType<GrindingMillRecipe>> GRINDING_MILL = RECIPE_TYPES.register("grinding_mill", () -> RecipeType.simple(new ResourceLocation(AssortedCore.MODID, "grinding_mill")));

}
