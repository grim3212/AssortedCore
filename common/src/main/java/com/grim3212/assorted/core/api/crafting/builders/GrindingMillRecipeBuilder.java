package com.grim3212.assorted.core.api.crafting.builders;

import com.google.gson.JsonObject;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.lib.platform.Services;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.triggers.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class GrindingMillRecipeBuilder {

    private final ItemStack result;
    private final MachineIngredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
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

    public GrindingMillRecipeBuilder addCriterion(String name, CriterionTriggerInstance criterionIn) {
        this.advancementBuilder.addCriterion(name, criterionIn);
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        this.build(consumerIn, Services.PLATFORM.getRegistry(Registries.ITEM).getRegistryName(this.result.getItem()));
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        Identifier resourcelocation = Services.PLATFORM.getRegistry(Registries.ITEM).getRegistryName(this.result.getItem());
        Identifier resourcelocation1 = Identifier.parse(save);
        if (resourcelocation1.equals(resourcelocation)) {
            throw new IllegalStateException("Recipe " + resourcelocation1 + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, resourcelocation1);
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, Identifier id) {
        this.validate(id);
        this.advancementBuilder.parent(Identifier.parse("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
        consumerIn.accept(new GrindingMillRecipeBuilder.Result(id, this.group == null ? "" : this.group, this.ingredient, this.result, this.experience, this.cookingTime, this.advancementBuilder, Identifier.fromNamespaceAndPath(id.getNamespace(), "recipes/" + id.getPath())));
    }

    private void validate(Identifier id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    public static class Result implements FinishedRecipe {
        private final Identifier id;
        private final String group;
        private final MachineIngredient ingredient;
        private final ItemStack result;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancementBuilder;
        private final Identifier advancementId;

        public Result(Identifier idIn, String groupIn, MachineIngredient ingredientIn, ItemStack resultIn, float experienceIn, int cookingTimeIn, Advancement.Builder advancementBuilderIn, Identifier advancementIdIn) {
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
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            json.add("ingredient", this.ingredient.serialize());
            JsonObject itemstack = new JsonObject();
            itemstack.addProperty("item", Services.PLATFORM.getRegistry(Registries.ITEM).getRegistryName(this.result.getItem()).toString());
            itemstack.addProperty("count", this.result.getCount());
            json.add("result", itemstack);
            json.addProperty("experience", this.experience);
            json.addProperty("cookingtime", this.cookingTime);
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CoreRecipeSerializers.GRINDING_MILL.get();
        }

        @Override
        public Identifier getId() {
            return this.id;
        }

        @Override
        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancementBuilder.serializeToJson();
        }

        @Override
        @Nullable
        public Identifier getAdvancementId() {
            return this.advancementId;
        }
    }
}
