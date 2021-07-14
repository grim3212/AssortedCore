package com.grim3212.assorted.core.api.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class GrindingMillRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<GrindingMillRecipe> {

	@Override
	public GrindingMillRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
		String s = JSONUtils.getAsString(json, "group", "");
		JsonElement jsonelementIngredient = (JsonElement) (JSONUtils.isArrayNode(json, "ingredient") ? JSONUtils.getAsJsonArray(json, "ingredient") : JSONUtils.getAsJsonObject(json, "ingredient"));
		MachineIngredient ingredient = MachineIngredient.deserialize(jsonelementIngredient);
		if (!json.has("result")) {
			throw new JsonSyntaxException("Missing result, expected to find a string or object");
		}
		ItemStack itemstack;
		if (json.get("result").isJsonObject()) {
			itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
		} else {
			String s1 = JSONUtils.getAsString(json, "result");
			ResourceLocation resourcelocation = new ResourceLocation(s1);
			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
				return new IllegalStateException("Item: " + s1 + " does not exist");
			}));
		}
		float f = JSONUtils.getAsFloat(json, "experience", 0.0F);
		int i = JSONUtils.getAsInt(json, "cookingtime", 400);
		return new GrindingMillRecipe(recipeId, s, ingredient, itemstack, f, i);
	}

	@Override
	public GrindingMillRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
		String s = buffer.readUtf(32767);
		MachineIngredient ingredient = MachineIngredient.read(buffer);
		ItemStack itemstack = buffer.readItem();
		float f = buffer.readFloat();
		int i = buffer.readVarInt();
		return new GrindingMillRecipe(recipeId, s, ingredient, itemstack, f, i);
	}

	@Override
	public void toNetwork(PacketBuffer buffer, GrindingMillRecipe recipe) {
		buffer.writeUtf(recipe.group);
		recipe.ingredient.write(buffer);
		buffer.writeItem(recipe.result);
		buffer.writeFloat(recipe.experience);
		buffer.writeVarInt(recipe.cookTime);
	}

}
