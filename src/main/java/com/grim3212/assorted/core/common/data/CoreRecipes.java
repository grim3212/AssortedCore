package com.grim3212.assorted.core.common.data;

import java.util.function.Consumer;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.crafting.MachineIngredient;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.lib.CoreTags;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

public class CoreRecipes extends RecipeProvider {

	public CoreRecipes(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_TIN, CoreTags.Items.INGOTS_TIN, CoreTags.Items.NUGGETS_TIN, CoreBlocks.TIN_BLOCK.get(), CoreItems.TIN_INGOT.get(), CoreItems.TIN_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_COPPER, CoreTags.Items.INGOTS_COPPER, CoreTags.Items.NUGGETS_COPPER, CoreBlocks.COPPER_BLOCK.get(), CoreItems.COPPER_INGOT.get(), CoreItems.COPPER_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_SILVER, CoreTags.Items.INGOTS_SILVER, CoreTags.Items.NUGGETS_SILVER, CoreBlocks.SILVER_BLOCK.get(), CoreItems.SILVER_INGOT.get(), CoreItems.SILVER_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.INGOTS_ALUMINUM, CoreTags.Items.NUGGETS_ALUMINUM, CoreBlocks.ALUMINUM_BLOCK.get(), CoreItems.ALUMINUM_INGOT.get(), CoreItems.ALUMINUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_NICKEL, CoreTags.Items.INGOTS_NICKEL, CoreTags.Items.NUGGETS_NICKEL, CoreBlocks.NICKEL_BLOCK.get(), CoreItems.NICKEL_INGOT.get(), CoreItems.NICKEL_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_PLATINUM, CoreTags.Items.INGOTS_PLATINUM, CoreTags.Items.NUGGETS_PLATINUM, CoreBlocks.PLATINUM_BLOCK.get(), CoreItems.PLATINUM_INGOT.get(), CoreItems.PLATINUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_LEAD, CoreTags.Items.INGOTS_LEAD, CoreTags.Items.NUGGETS_LEAD, CoreBlocks.LEAD_BLOCK.get(), CoreItems.LEAD_INGOT.get(), CoreItems.LEAD_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_BRONZE, CoreTags.Items.INGOTS_BRONZE, CoreTags.Items.NUGGETS_BRONZE, CoreBlocks.BRONZE_BLOCK.get(), CoreItems.BRONZE_INGOT.get(), CoreItems.BRONZE_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.INGOTS_ELECTRUM, CoreTags.Items.NUGGETS_ELECTRUM, CoreBlocks.ELECTRUM_BLOCK.get(), CoreItems.ELECTRUM_INGOT.get(), CoreItems.ELECTRUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_INVAR, CoreTags.Items.INGOTS_INVAR, CoreTags.Items.NUGGETS_INVAR, CoreBlocks.INVAR_BLOCK.get(), CoreItems.INVAR_INGOT.get(), CoreItems.INVAR_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_STEEL, CoreTags.Items.INGOTS_STEEL, CoreTags.Items.NUGGETS_STEEL, CoreBlocks.STEEL_BLOCK.get(), CoreItems.STEEL_INGOT.get(), CoreItems.STEEL_NUGGET.get(), consumer);

		gemStorage(CoreTags.Items.STORAGE_BLOCKS_RUBY, CoreTags.Items.GEMS_RUBY, CoreBlocks.RUBY_BLOCK.get(), CoreItems.RUBY.get(), consumer);
		gemStorage(CoreTags.Items.STORAGE_BLOCKS_AMETHYST, CoreTags.Items.GEMS_AMETHYST, CoreBlocks.AMETHYST_BLOCK.get(), CoreItems.AMETHYST.get(), consumer);
		gemStorage(CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.GEMS_SAPPHIRE, CoreBlocks.SAPPHIRE_BLOCK.get(), CoreItems.SAPPHIRE.get(), consumer);
		gemStorage(CoreTags.Items.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.GEMS_TOPAZ, CoreBlocks.TOPAZ_BLOCK.get(), CoreItems.TOPAZ.get(), consumer);

		blastingSmelting(CoreTags.Items.ORES_TIN, CoreItems.TIN_INGOT.get(), 0.5f, consumer);
		blastingSmelting(CoreTags.Items.ORES_COPPER, CoreItems.COPPER_INGOT.get(), 0.5f, consumer);
		blastingSmelting(CoreTags.Items.ORES_SILVER, CoreItems.SILVER_INGOT.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_ALUMINUM, CoreItems.ALUMINUM_INGOT.get(), 0.7f, consumer);
		blastingSmelting(CoreTags.Items.ORES_NICKEL, CoreItems.NICKEL_INGOT.get(), 0.7f, consumer);
		blastingSmelting(CoreTags.Items.ORES_PLATINUM, CoreItems.PLATINUM_INGOT.get(), 1.5f, consumer);
		blastingSmelting(CoreTags.Items.ORES_LEAD, CoreItems.LEAD_INGOT.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_RUBY, CoreItems.RUBY.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_AMETHYST, CoreItems.AMETHYST.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_SAPPHIRE, CoreItems.SAPPHIRE.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_TOPAZ, CoreItems.TOPAZ.get(), 1.0f, consumer);

		ingotDust(CoreTags.Items.DUSTS_TIN, CoreItems.TIN_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_COPPER, CoreItems.COPPER_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_SILVER, CoreItems.SILVER_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_ALUMINUM, CoreItems.ALUMINUM_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_NICKEL, CoreItems.NICKEL_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_PLATINUM, CoreItems.PLATINUM_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_LEAD, CoreItems.LEAD_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_BRONZE, CoreItems.BRONZE_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_ELECTRUM, CoreItems.ELECTRUM_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_INVAR, CoreItems.INVAR_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_STEEL, CoreItems.STEEL_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_IRON, Items.IRON_INGOT, consumer);
		ingotDust(CoreTags.Items.DUSTS_GOLD, Items.GOLD_INGOT, consumer);

		alloy(ItemTags.COALS, 4, CoreTags.Items.DUSTS_IRON, 1, new ItemStack(CoreItems.STEEL_INGOT.get(), 1), 0.5F, 800, consumer);
		alloy(CoreTags.Items.DUSTS_COPPER, 3, CoreTags.Items.DUSTS_TIN, 1, new ItemStack(CoreItems.BRONZE_INGOT.get(), 4), 0.5F, consumer);
		alloy(CoreTags.Items.DUSTS_IRON, 2, CoreTags.Items.DUSTS_NICKEL, 1, new ItemStack(CoreItems.INVAR_INGOT.get(), 3), 0.7F, 500, consumer);
		alloy(CoreTags.Items.DUSTS_SILVER, CoreTags.Items.DUSTS_GOLD, new ItemStack(CoreItems.ELECTRUM_DUST.get(), 2), 0.7F, consumer);
	}

	private void alloy(INamedTag<Item> ingredient1, int ingredient1Count, INamedTag<Item> ingredient2, int ingredient2Count, ItemStack result, float experience, Consumer<IFinishedRecipe> consumer) {
		alloy(ingredient1, ingredient1Count, ingredient2, ingredient2Count, result, experience, 400, consumer);
	}

	private void alloy(INamedTag<Item> ingredient1, INamedTag<Item> ingredient2, ItemStack result, float experience, Consumer<IFinishedRecipe> consumer) {
		alloy(ingredient1, ingredient2, result, experience, 400, consumer);
	}

	private void alloy(INamedTag<Item> ingredient1, INamedTag<Item> ingredient2, ItemStack result, float experience, int cookTime, Consumer<IFinishedRecipe> consumer) {
		alloy(ingredient1, 1, ingredient2, 1, result, experience, cookTime, consumer);
	}

	private void alloy(INamedTag<Item> ingredient1, int ingredient1Count, INamedTag<Item> ingredient2, int ingredient2Count, ItemStack result, float experience, int cookTime, Consumer<IFinishedRecipe> consumer) {
		AlloyForgeRecipeBuilder.recipe(new MachineIngredient(Ingredient.fromTag(ingredient1), ingredient1Count), new MachineIngredient(Ingredient.fromTag(ingredient2), ingredient2Count), result, experience, cookTime).addCriterion("has_ingredient1", hasItem(ingredient1)).addCriterion("has_ingredient2", hasItem(ingredient2)).build(consumer);
	}

	private void ingotDust(INamedTag<Item> dust, IItemProvider ingot, Consumer<IFinishedRecipe> consumer) {
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromTag(dust), ingot, 0.1F, 100).addCriterion("has_dust", hasItem(dust)).build(consumer, new ResourceLocation(AssortedCore.MODID, dust.getName().getPath() + "_smelting"));
	}

	private void blastingSmelting(ITag<Item> ore, IItemProvider output, float experience, Consumer<IFinishedRecipe> consumer) {
		CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(ore), output, experience, 100).addCriterion("has_ore", hasItem(ore)).build(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_blasting"));
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromTag(ore), output, experience, 200).addCriterion("has_ore", hasItem(ore)).build(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_smelting"));
	}

	private void gemStorage(ITag<Item> storageBlockTag, ITag<Item> gemTag, IItemProvider storageBlock, IItemProvider gem, Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(gem, 9).addIngredient(Ingredient.fromTag(storageBlockTag)).addCriterion("has_gem", hasItem(storageBlockTag)).build(consumer, new ResourceLocation(AssortedCore.MODID, gem.asItem().getRegistryName().getPath() + "_storage_block"));
		ShapelessRecipeBuilder.shapelessRecipe(storageBlock, 1).addIngredient(Ingredient.fromTag(gemTag), 9).addCriterion("has_gem", hasItem(gemTag)).build(consumer);
	}

	private void storageIngotNugget(ITag<Item> storageBlockTag, ITag<Item> ingotTag, ITag<Item> nuggetTag, IItemProvider storageBlock, IItemProvider ingot, IItemProvider nugget, Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(ingot, 9).addIngredient(Ingredient.fromTag(storageBlockTag)).addCriterion("has_ingot", hasItem(ingotTag)).build(consumer, new ResourceLocation(AssortedCore.MODID, ingot.asItem().getRegistryName().getPath() + "_block"));
		ShapelessRecipeBuilder.shapelessRecipe(storageBlock, 1).addIngredient(Ingredient.fromTag(ingotTag), 9).addCriterion("has_ingot", hasItem(ingotTag)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(nugget, 9).addIngredient(Ingredient.fromTag(ingotTag)).addCriterion("has_ingot", hasItem(ingotTag)).build(consumer);
		ShapelessRecipeBuilder.shapelessRecipe(ingot, 1).addIngredient(Ingredient.fromTag(nuggetTag), 9).addCriterion("has_ingot", hasItem(ingotTag)).build(consumer, new ResourceLocation(AssortedCore.MODID, ingot.asItem().getRegistryName().getPath() + "_nuggets"));
	}

	@Override
	public String getName() {
		return "Assorted Core recipes";
	}
}
