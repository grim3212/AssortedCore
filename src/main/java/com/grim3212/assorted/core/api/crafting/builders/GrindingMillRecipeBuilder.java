package com.grim3212.assorted.core.api.crafting.builders;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class GrindingMillRecipeBuilder {

	private final ItemStack result;
	private final MachineIngredient ingredient;
	private final float experience;
	private final int cookingTime;
	private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
	private String group;

	private GrindingMillRecipeBuilder(ItemStack resultIn, MachineIngredient ingredientIn, float experienceIn, int cookingTimeIn) {
		this.result = resultIn;
		this.ingredient = ingredientIn;
		this.experience = experienceIn;
		this.cookingTime = cookingTimeIn;
	}

	public static GrindingMillRecipeBuilder recipe(MachineIngredient ingredientIn, ItemStack resultIn, float experienceIn, int cookingTimeIn) {
		return new GrindingMillRecipeBuilder(resultIn, ingredientIn, experienceIn, cookingTimeIn);
	}

	public static GrindingMillRecipeBuilder recipe(Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookingTimeIn) {
		return new GrindingMillRecipeBuilder(resultIn, new MachineIngredient(ingredientIn), experienceIn, cookingTimeIn);
	}

	public GrindingMillRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
		this.advancementBuilder.withCriterion(name, criterionIn);
		return this;
	}

	public void build(Consumer<IFinishedRecipe> consumerIn) {
		this.build(consumerIn, Registry.ITEM.getKey(this.result.getItem()));
	}

	public void build(Consumer<IFinishedRecipe> consumerIn, String save) {
		ResourceLocation resourcelocation = Registry.ITEM.getKey(this.result.getItem());
		ResourceLocation resourcelocation1 = new ResourceLocation(save);
		if (resourcelocation1.equals(resourcelocation)) {
			throw new IllegalStateException("Recipe " + resourcelocation1 + " should remove its 'save' argument");
		} else {
			this.build(consumerIn, resourcelocation1);
		}
	}

	public void build(Consumer<IFinishedRecipe> consumerIn, ResourceLocation id) {
		this.validate(id);
		this.advancementBuilder.withParentId(new ResourceLocation("recipes/root")).withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(id)).withRewards(AdvancementRewards.Builder.recipe(id)).withRequirementsStrategy(IRequirementsStrategy.OR);
		consumerIn.accept(new GrindingMillRecipeBuilder.Result(id, this.group == null ? "" : this.group, this.ingredient, this.result, this.experience, this.cookingTime, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + this.result.getItem().getGroup().getPath() + "/" + id.getPath())));
	}

	private void validate(ResourceLocation id) {
		if (this.advancementBuilder.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	public static class Result implements IFinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final MachineIngredient ingredient;
		private final ItemStack result;
		private final float experience;
		private final int cookingTime;
		private final Advancement.Builder advancementBuilder;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation idIn, String groupIn, MachineIngredient ingredientIn, ItemStack resultIn, float experienceIn, int cookingTimeIn, Advancement.Builder advancementBuilderIn, ResourceLocation advancementIdIn) {
			this.id = idIn;
			this.group = groupIn;
			this.ingredient = ingredientIn;
			this.result = resultIn;
			this.experience = experienceIn;
			this.cookingTime = cookingTimeIn;
			this.advancementBuilder = advancementBuilderIn;
			this.advancementId = advancementIdIn;
		}

		@Override
		public void serialize(JsonObject json) {
			if (!this.group.isEmpty()) {
				json.addProperty("group", this.group);
			}

			json.add("ingredient", this.ingredient.serialize());
			JsonObject itemstack = new JsonObject();
			itemstack.addProperty("item", Registry.ITEM.getKey(this.result.getItem()).toString());
			itemstack.addProperty("count", this.result.getCount());
			json.add("result", itemstack);
			json.addProperty("experience", this.experience);
			json.addProperty("cookingtime", this.cookingTime);
		}

		@Override
		public IRecipeSerializer<?> getSerializer() {
			return CoreRecipeSerializers.GRINDING_MILL.get();
		}

		@Override
		public ResourceLocation getID() {
			return this.id;
		}

		@Override
		@Nullable
		public JsonObject getAdvancementJson() {
			return this.advancementBuilder.serialize();
		}

		@Override
		@Nullable
		public ResourceLocation getAdvancementID() {
			return this.advancementId;
		}
	}
}
