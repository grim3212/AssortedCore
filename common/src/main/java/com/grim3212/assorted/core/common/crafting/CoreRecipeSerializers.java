package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.AlloyForgeRecipeSerializer;
import com.grim3212.assorted.core.api.crafting.GrindingMillRecipeSerializer;
import com.grim3212.assorted.core.registry.IRegistryObject;
import com.grim3212.assorted.core.registry.RegistryProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class CoreRecipeSerializers {

    public static final RegistryProvider<RecipeSerializer<?>> RECIPE_SERIALIZERS = RegistryProvider.create(Registries.RECIPE_SERIALIZER, Constants.MOD_ID);

    public static final IRegistryObject<RecipeSerializer<?>> ALLOY_FORGE = RECIPE_SERIALIZERS.register("alloy_forge", AlloyForgeRecipeSerializer::new);
    public static final IRegistryObject<RecipeSerializer<?>> GRINDING_MILL = RECIPE_SERIALIZERS.register("grinding_mill", GrindingMillRecipeSerializer::new);

    public static void init() {
    }
}
