package com.grim3212.assorted.core.common.data;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.MachineIngredient;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class AlloyForgeRecipeBuilder {

	private final Item result;
	private final MachineIngredient ingredient1;
	private final MachineIngredient ingredient2;
	private final float experience;
	private final int cookingTime;
	private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
	private String group;

	private AlloyForgeRecipeBuilder(IItemProvider resultIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, float experienceIn, int cookingTimeIn) {
		this.result = resultIn.asItem();
		this.ingredient1 = ingredient1In;
		this.ingredient2 = ingredient2In;
		this.experience = experienceIn;
		this.cookingTime = cookingTimeIn;
	}

	public static AlloyForgeRecipeBuilder recipe(MachineIngredient ingredient1In, MachineIngredient ingredient2In, IItemProvider resultIn, float experienceIn, int cookingTimeIn) {
		return new AlloyForgeRecipeBuilder(resultIn, ingredient1In, ingredient2In, experienceIn, cookingTimeIn);
	}

	public static AlloyForgeRecipeBuilder recipe(Ingredient ingredient1In, Ingredient ingredient2In, IItemProvider resultIn, float experienceIn, int cookingTimeIn) {
		return new AlloyForgeRecipeBuilder(resultIn, new MachineIngredient(ingredient1In), new MachineIngredient(ingredient2In), experienceIn, cookingTimeIn);
	}

	public AlloyForgeRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn) {
		this.advancementBuilder.withCriterion(name, criterionIn);
		return this;
	}

	public void build(Consumer<IFinishedRecipe> consumerIn) {
		this.build(consumerIn, Registry.ITEM.getKey(this.result));
	}

	public void build(Consumer<IFinishedRecipe> consumerIn, String save) {
		ResourceLocation resourcelocation = Registry.ITEM.getKey(this.result);
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
		consumerIn.accept(new AlloyForgeRecipeBuilder.Result(id, this.group == null ? "" : this.group, this.ingredient1, this.ingredient2, this.result, this.experience, this.cookingTime, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + this.result.getGroup().getPath() + "/" + id.getPath())));
	}

	private void validate(ResourceLocation id) {
		if (this.advancementBuilder.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	public static class Result implements IFinishedRecipe {
		private final ResourceLocation id;
		private final String group;
		private final MachineIngredient ingredient1;
		private final MachineIngredient ingredient2;
		private final Item result;
		private final float experience;
		private final int cookingTime;
		private final Advancement.Builder advancementBuilder;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation idIn, String groupIn, MachineIngredient ingredient1In, MachineIngredient ingredient2In, Item resultIn, float experienceIn, int cookingTimeIn, Advancement.Builder advancementBuilderIn, ResourceLocation advancementIdIn) {
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
		public void serialize(JsonObject json) {
			if (!this.group.isEmpty()) {
				json.addProperty("group", this.group);
			}

			json.add("ingredient1", this.ingredient1.serialize());
			json.add("ingredient2", this.ingredient2.serialize());
			json.addProperty("result", Registry.ITEM.getKey(this.result).toString());
			json.addProperty("experience", this.experience);
			json.addProperty("cookingtime", this.cookingTime);
		}

		@Override
		public IRecipeSerializer<?> getSerializer() {
			return CoreRecipeSerializers.ALLOY_FORGE.get();
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
