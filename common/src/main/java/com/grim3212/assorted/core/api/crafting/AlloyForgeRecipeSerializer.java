package com.grim3212.assorted.core.api.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;

/**
 * Codecs for {@link AlloyForgeRecipe}.
 * <p>
 * {@code RecipeSerializer} is a record of a {@link MapCodec} and a {@link StreamCodec} in 26.x
 * rather than an interface with {@code fromJson}/{@code fromNetwork}/{@code toNetwork}, so this is
 * no longer something to implement - it holds the codecs and the single serializer instance.
 */
public final class AlloyForgeRecipeSerializer {

    public static final MapCodec<AlloyForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
            MachineIngredient.CODEC.fieldOf("ingredient1").forGetter(AlloyForgeRecipe::getIngredient1),
            MachineIngredient.CODEC.fieldOf("ingredient2").forGetter(AlloyForgeRecipe::getIngredient2),
            ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
            Codec.FLOAT.optionalFieldOf("experience", 0.0F).forGetter(recipe -> recipe.experience),
            Codec.INT.optionalFieldOf("cookingtime", 400).forGetter(recipe -> recipe.cookTime)
    ).apply(instance, AlloyForgeRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, AlloyForgeRecipe> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, recipe -> recipe.group,
            MachineIngredient.STREAM_CODEC, AlloyForgeRecipe::getIngredient1,
            MachineIngredient.STREAM_CODEC, AlloyForgeRecipe::getIngredient2,
            ItemStack.STREAM_CODEC, recipe -> recipe.result,
            ByteBufCodecs.FLOAT, recipe -> recipe.experience,
            ByteBufCodecs.VAR_INT, recipe -> recipe.cookTime,
            AlloyForgeRecipe::new);

    public static final RecipeSerializer<AlloyForgeRecipe> INSTANCE = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    private AlloyForgeRecipeSerializer() {
    }
}
