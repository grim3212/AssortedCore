package com.grim3212.assorted.core.api.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Predicate;

/**
 * An {@link Ingredient} paired with a required count.
 * <p>
 * Hand-rolled JSON and {@code FriendlyByteBuf} serialization is gone in 26.x: recipes round-trip
 * through a {@link MapCodec} and a {@link StreamCodec}, so this exposes those instead of the old
 * {@code deserialize}/{@code read}/{@code write}/{@code serialize} pairs.
 */
public class MachineIngredient implements Predicate<ItemStack> {

    public static final MapCodec<MachineIngredient> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(MachineIngredient::getBaseIngredient),
            Codec.INT.optionalFieldOf("count", 1).forGetter(MachineIngredient::getCount)
    ).apply(instance, MachineIngredient::new));

    public static final Codec<MachineIngredient> CODEC = MAP_CODEC.codec();

    public static final StreamCodec<RegistryFriendlyByteBuf, MachineIngredient> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, MachineIngredient::getBaseIngredient,
            ByteBufCodecs.VAR_INT, MachineIngredient::getCount,
            MachineIngredient::new);

    private final Ingredient ingredient;
    private final int count;

    public MachineIngredient(Ingredient ingredient) {
        this(ingredient, 1);
    }

    public MachineIngredient(Ingredient ingredient, int count) {
        this.ingredient = ingredient;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Ingredient getBaseIngredient() {
        return this.ingredient;
    }

    @Override
    public boolean test(ItemStack t) {
        if (t == null)
            return false;
        return ingredient.test(t) && t.getCount() >= this.count;
    }

    /**
     * The stacks this ingredient accepts, each at the required count. Used for display.
     * <p>
     * {@code Ingredient.getItems()} returned baked {@code ItemStack}s; in 26.x an ingredient is a
     * {@code HolderSet} and {@link Ingredient#items()} yields the item holders instead.
     */
    public ItemStack[] getMatchingStacks() {
        return this.ingredient.items()
                .map(holder -> new ItemStack(holder, this.count))
                .toArray(ItemStack[]::new);
    }
}
