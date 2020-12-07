package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreRecipeSerializers {
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AssortedCore.MODID);
	
	public static final RegistryObject<IRecipeSerializer<?>> ALLOY_FORGE = RECIPE_SERIALIZERS.register("alloy_forge", AlloyForgeRecipeSerializer::new);
	public static final RegistryObject<IRecipeSerializer<?>> GRINDING_MILL = RECIPE_SERIALIZERS.register("grinding_mill", GrindingMillRecipeSerializer::new);
}
