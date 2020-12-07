package com.grim3212.assorted.core.common.crafting;

import java.util.function.Predicate;

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

	@Override
	public boolean test(ItemStack t) {
		if (t == null)
			return false;
		return ingredient.test(t) && t.getCount() >= this.count;
	}

	public static MachineIngredient read(PacketBuffer buffer) {
		return new MachineIngredient(Ingredient.read(buffer), buffer.readInt());
	}

	public void write(PacketBuffer buffer) {
		this.ingredient.write(buffer);
		buffer.writeInt(this.count);
	}

	public JsonElement serialize() {
		JsonObject obj = new JsonObject();
		obj.add("ingredient", this.ingredient.serialize());
		obj.addProperty("count", this.count);
		return obj;
	}

	public static MachineIngredient deserialize(@Nullable JsonElement json) {
		if (json != null && !json.isJsonNull() && json.isJsonObject()) {
			JsonObject obj = json.getAsJsonObject();
			return new MachineIngredient(Ingredient.deserialize(obj.get("ingredient")), obj.get("count").getAsInt());
		} else {
			throw new JsonSyntaxException("Item cannot be null");
		}
	}
}
