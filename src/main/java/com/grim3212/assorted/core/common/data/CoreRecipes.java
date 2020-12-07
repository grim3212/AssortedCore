package com.grim3212.assorted.core.common.data;

import java.util.function.Consumer;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.lib.CoreTags;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

public class CoreRecipes extends RecipeProvider {

	public CoreRecipes(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		storageIngotNugget(CoreBlocks.TIN_BLOCK.get(), CoreItems.TIN_INGOT.get(), CoreItems.TIN_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.COPPER_BLOCK.get(), CoreItems.COPPER_INGOT.get(), CoreItems.COPPER_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.SILVER_BLOCK.get(), CoreItems.SILVER_INGOT.get(), CoreItems.SILVER_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.ALUMINUM_BLOCK.get(), CoreItems.ALUMINUM_INGOT.get(), CoreItems.ALUMINUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.NICKEL_BLOCK.get(), CoreItems.NICKEL_INGOT.get(), CoreItems.NICKEL_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.PLATINUM_BLOCK.get(), CoreItems.PLATINUM_INGOT.get(), CoreItems.PLATINUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.LEAD_BLOCK.get(), CoreItems.LEAD_INGOT.get(), CoreItems.LEAD_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.BRONZE_BLOCK.get(), CoreItems.BRONZE_INGOT.get(), CoreItems.BRONZE_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.ELECTRUM_BLOCK.get(), CoreItems.ELECTRUM_INGOT.get(), CoreItems.ELECTRUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.INVAR_BLOCK.get(), CoreItems.INVAR_INGOT.get(), CoreItems.INVAR_NUGGET.get(), consumer);
		storageIngotNugget(CoreBlocks.STEEL_BLOCK.get(), CoreItems.STEEL_INGOT.get(), CoreItems.STEEL_NUGGET.get(), consumer);

		gemStorage(CoreBlocks.RUBY_BLOCK.get(), CoreItems.RUBY.get(), consumer);
		gemStorage(CoreBlocks.AMETHYST_BLOCK.get(), CoreItems.AMETHYST.get(), consumer);
		gemStorage(CoreBlocks.SAPPHIRE_BLOCK.get(), CoreItems.SAPPHIRE.get(), consumer);
		gemStorage(CoreBlocks.TOPAZ_BLOCK.get(), CoreItems.TOPAZ.get(), consumer);

		blastingSmelting(CoreBlocks.TIN_ORE.get(), CoreItems.TIN_INGOT.get(), 0.5f, consumer);
		blastingSmelting(CoreBlocks.COPPER_ORE.get(), CoreItems.COPPER_INGOT.get(), 0.5f, consumer);
		blastingSmelting(CoreBlocks.SILVER_ORE.get(), CoreItems.SILVER_INGOT.get(), 1.0f, consumer);
		blastingSmelting(CoreBlocks.ALUMINUM_ORE.get(), CoreItems.ALUMINUM_INGOT.get(), 0.7f, consumer);
		blastingSmelting(CoreBlocks.NICKEL_ORE.get(), CoreItems.NICKEL_INGOT.get(), 0.7f, consumer);
		blastingSmelting(CoreBlocks.PLATINUM_ORE.get(), CoreItems.PLATINUM_INGOT.get(), 1.5f, consumer);
		blastingSmelting(CoreBlocks.LEAD_ORE.get(), CoreItems.LEAD_INGOT.get(), 1.0f, consumer);
		blastingSmelting(CoreBlocks.RUBY_ORE.get(), CoreItems.RUBY.get(), 1.0f, consumer);
		blastingSmelting(CoreBlocks.AMETHYST_ORE.get(), CoreItems.AMETHYST.get(), 1.0f, consumer);
		blastingSmelting(CoreBlocks.SAPPHIRE_ORE.get(), CoreItems.SAPPHIRE.get(), 1.0f, consumer);
		blastingSmelting(CoreBlocks.TOPAZ_ORE.get(), CoreItems.TOPAZ.get(), 1.0f, consumer);

		AlloyForgeRecipeBuilder.recipe(Ingredient.fromTag(CoreTags.Items.DUSTS_SILVER), Ingredient.fromTag(CoreTags.Items.DUSTS_GOLD), CoreItems.ELECTRUM_DUST.get(), 0.8F, 400).addCriterion("has_gold_dust", hasItem(CoreTags.Items.DUSTS_GOLD)).addCriterion("has_silver_dust", hasItem(CoreTags.Items.DUSTS_SILVER)).build(consumer);
	}

	private void blastingSmelting(IItemProvider ore, IItemProvider output, float experience, Consumer<IFinishedRecipe> consumer) {
		CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ore), output, experience, 100).addCriterion("has_ore", hasItem(ore)).build(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_blasting"));
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ore), output, experience, 200).addCriterion("has_ore", hasItem(ore)).build(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_smelting"));
	}

	private void gemStorage(IItemProvider storageBlock, IItemProvider gem, Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(gem, 9).addIngredient(storageBlock).addCriterion("has_gem", hasItem(gem)).build(consumer, new ResourceLocation(AssortedCore.MODID, gem.asItem().getRegistryName().getPath() + "_storage_block"));
		ShapelessRecipeBuilder.shapelessRecipe(storageBlock, 1).addIngredient(gem, 9).addCriterion("has_gem", hasItem(gem)).build(consumer);
	}

	private void storageIngotNugget(IItemProvider storageBlock, IItemProvider ingot, IItemProvider nugget, Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(ingot, 9).addIngredient(storageBlock).addCriterion("has_ingot", hasItem(ingot)).build(consumer, new ResourceLocation(AssortedCore.MODID, ingot.asItem().getRegistryName().getPath() + "_block"));
		ShapelessRecipeBuilder.shapelessRecipe(storageBlock, 1).addIngredient(ingot, 9).addCriterion("has_ingot", hasItem(ingot)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(nugget, 9).addIngredient(ingot).addCriterion("has_ingot", hasItem(ingot)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(ingot, 1).addIngredient(nugget, 9).addCriterion("has_ingot", hasItem(ingot)).build(consumer, new ResourceLocation(AssortedCore.MODID, ingot.asItem().getRegistryName().getPath() + "_nuggets"));
	}

	@Override
	public String getName() {
		return "Assorted Core recipes";
	}
}
