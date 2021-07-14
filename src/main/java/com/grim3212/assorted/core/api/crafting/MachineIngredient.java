package com.grim3212.assorted.core.api.crafting;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;

public class MachineIngredient implements Predicate<ItemStack> {

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

	public static MachineIngredient read(PacketBuffer buffer) {
		return new MachineIngredient(Ingredient.fromNetwork(buffer), buffer.readInt());
	}

	public void write(PacketBuffer buffer) {
		this.ingredient.toNetwork(buffer);
		buffer.writeInt(this.count);
	}

	public JsonElement serialize() {
		JsonObject obj = new JsonObject();
		obj.add("ingredient", this.ingredient.toJson());
		obj.addProperty("count", this.count);
		return obj;
	}

	public static MachineIngredient deserialize(@Nullable JsonElement json) {
		if (json != null && !json.isJsonNull() && json.isJsonObject()) {
			JsonObject obj = json.getAsJsonObject();
			return new MachineIngredient(Ingredient.fromJson(obj.get("ingredient")), obj.get("count").getAsInt());
		} else {
			throw new JsonSyntaxException("Item cannot be null");
		}
	}

	public ItemStack[] getMatchingStacks() {
		return Arrays.stream(this.ingredient.getItems()).collect(Collectors.toList()).stream().map((stack) -> {
			ItemStack clone = stack.copy();
			clone.setCount(this.count);
			return clone;
		}).toArray(ItemStack[]::new);
	}
}
