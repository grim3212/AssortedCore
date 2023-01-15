package com.grim3212.assorted.core.api.crafting.builders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;

public class AlloyForgeRecipeBuilder {

	private final ItemStack result;
	private final MachineIngredient ingredient1;
	private final MachineIngredient ingredient2;
	private final float experience;
	private final int cookingTime;
	private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
	private String group;

	private AlloyForgeRecipeBuilder(ItemStack resultIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, float experienceIn, int cookingTimeIn) {
		this.result = resultIn;
		this.ingredient1 = ingredient1In;
		this.ingredient2 = ingredient2In;
		this.experience = experienceIn;
		this.cookingTime = cookingTimeIn;
	}

	public static AlloyForgeRecipeBuilder recipe(MachineIngredient ingredient1In, MachineIngredient ingredient2In, ItemStack resultIn, float experienceIn, int cookingTimeIn) {
		return new AlloyForgeRecipeBuilder(resultIn, ingredient1In, ingredient2In, experienceIn, cookingTimeIn);
	}

	public static AlloyForgeRecipeBuilder recipe(Ingredient ingredient1In, Ingredient ingredient2In, ItemStack resultIn, float experienceIn, int cookingTimeIn) {
		return new AlloyForgeRecipeBuilder(resultIn, new MachineIngredient(ingredient1In), new MachineIngredient(ingredient2In), experienceIn, cookingTimeIn);
	}

	public AlloyForgeRecipeBuilder addCriterion(String name, CriterionTriggerInstance criterionIn) {
		this.advancementBuilder.addCriterion(name, criterionIn);
		return this;
	}

	public void build(Consumer<FinishedRecipe> consumerIn) {
		this.build(consumerIn, ForgeRegistries.ITEMS.getKey(this.result.getItem()));
	}

	public void build(Consumer<FinishedRecipe> consumerIn, String save) {
		ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result.getItem());
		ResourceLocation resourcelocation1 = new ResourceLocation(save);
		if (resourcelocation1.equals(resourcelocation)) {
			throw new IllegalStateException("Recipe " + resourcelocation1 + " should remove its 'save' argument");
		} else {
			this.build(consumerIn, resourcelocation1);
		}
	}

	public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
		this.validate(id);
		this.advancementBuilder.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
		String folder = ""; // TODO: Get this somehow
		consumerIn.accept(new AlloyForgeRecipeBuilder.Result(id, this.group == null ? "" : this.group, this.ingredient1, this.ingredient2, this.result, this.experience, this.cookingTime, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + folder + "/" + id.getPath())));
	}

	private void validate(ResourceLocation id) {
		if (this.advancementBuilder.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final MachineIngredient ingredient1;
		private final MachineIngredient ingredient2;
		private final ItemStack result;
		private final float experience;
		private final int cookingTime;
		private final Advancement.Builder advancementBuilder;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation idIn, String groupIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, ItemStack resultIn, float experienceIn, int cookingTimeIn, Advancement.Builder advancementBuilderIn, ResourceLocation advancementIdIn) {
			this.id = idIn;
			this.group = groupIn;
			this.ingredient1 = ingredient1In;
			this.ingredient2 = ingredient2In;
			this.result = resultIn;
			this.experience = experienceIn;
			this.cookingTime = cookingTimeIn;
			this.advancementBuilder = advancementBuilderIn;
			this.advancementId = advancementIdIn;
		}

		@Override
		public void serializeRecipeData(JsonObject json) {
			if (!this.group.isEmpty()) {
				json.addProperty("group", this.group);
			}

			json.add("ingredient1", this.ingredient1.serialize());
			json.add("ingredient2", this.ingredient2.serialize());
			JsonObject itemstack = new JsonObject();
			itemstack.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result.getItem()).toString());
			itemstack.addProperty("count", this.result.getCount());
			json.add("result", itemstack);
			json.addProperty("experience", this.experience);
			json.addProperty("cookingtime", this.cookingTime);
		}

		@Override
		public RecipeSerializer<?> getType() {
			return CoreRecipeSerializers.ALLOY_FORGE.get();
		}

		@Override
		public ResourceLocation getId() {
			return this.id;
		}

		@Override
		@Nullable
		public JsonObject serializeAdvancement() {
			return this.advancementBuilder.serializeToJson();
		}

		@Override
		@Nullable
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}
}
