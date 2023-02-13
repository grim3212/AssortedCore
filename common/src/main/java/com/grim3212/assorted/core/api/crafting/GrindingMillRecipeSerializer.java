package com.grim3212.assorted.core.api.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.grim3212.assorted.lib.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class GrindingMillRecipeSerializer implements RecipeSerializer<GrindingMillRecipe> {

    @Override
    public GrindingMillRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
        String s = GsonHelper.getAsString(json, "group", "");
        JsonElement jsonelementIngredient = (JsonElement) (GsonHelper.isArrayNode(json, "ingredient") ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient"));
        MachineIngredient ingredient = MachineIngredient.deserialize(jsonelementIngredient);
        if (!json.has("result")) {
            throw new JsonSyntaxException("Missing result, expected to find a string or object");
        }
        ItemStack itemstack;
        if (json.get("result").isJsonObject()) {
            itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
        } else {
            String s1 = GsonHelper.getAsString(json, "result");
            ResourceLocation resourcelocation = new ResourceLocation(s1);
            itemstack = new ItemStack(Services.PLATFORM.getRegistry(Registries.ITEM).getValue(resourcelocation).orElseThrow(() -> {
                return new IllegalStateException("Item: " + s1 + " does not exist");
            }));
        }
        float f = GsonHelper.getAsFloat(json, "experience", 0.0F);
        int i = GsonHelper.getAsInt(json, "cookingtime", 400);
        return new GrindingMillRecipe(recipeId, s, ingredient, itemstack, f, i);
    }

    @Override
    public GrindingMillRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        String s = buffer.readUtf(32767);
        MachineIngredient ingredient = MachineIngredient.read(buffer);
        ItemStack itemstack = buffer.readItem();
        float f = buffer.readFloat();
        int i = buffer.readVarInt();
        return new GrindingMillRecipe(recipeId, s, ingredient, itemstack, f, i);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, GrindingMillRecipe recipe) {
        buffer.writeUtf(recipe.group);
        recipe.ingredient.write(buffer);
        buffer.writeItem(recipe.result);
        buffer.writeFloat(recipe.experience);
        buffer.writeVarInt(recipe.cookTime);
    }

}
