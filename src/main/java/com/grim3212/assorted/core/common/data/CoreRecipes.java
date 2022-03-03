package com.grim3212.assorted.core.common.data;

import java.util.function.Consumer;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.api.crafting.builders.AlloyForgeRecipeBuilder;
import com.grim3212.assorted.core.api.crafting.builders.GrindingMillRecipeBuilder;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

public class CoreRecipes extends RecipeProvider {

	public CoreRecipes(DataGenerator generatorIn) {
		super(generatorIn);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_TIN, CoreTags.Items.INGOTS_TIN, CoreTags.Items.NUGGETS_TIN, CoreBlocks.TIN_BLOCK.get(), CoreItems.TIN_INGOT.get(), CoreItems.TIN_NUGGET.get(), consumer);
		ingotNugget(CoreTags.Items.INGOTS_COPPER, CoreTags.Items.NUGGETS_COPPER, Items.COPPER_INGOT, CoreItems.COPPER_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_SILVER, CoreTags.Items.INGOTS_SILVER, CoreTags.Items.NUGGETS_SILVER, CoreBlocks.SILVER_BLOCK.get(), CoreItems.SILVER_INGOT.get(), CoreItems.SILVER_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.INGOTS_ALUMINUM, CoreTags.Items.NUGGETS_ALUMINUM, CoreBlocks.ALUMINUM_BLOCK.get(), CoreItems.ALUMINUM_INGOT.get(), CoreItems.ALUMINUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_NICKEL, CoreTags.Items.INGOTS_NICKEL, CoreTags.Items.NUGGETS_NICKEL, CoreBlocks.NICKEL_BLOCK.get(), CoreItems.NICKEL_INGOT.get(), CoreItems.NICKEL_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_PLATINUM, CoreTags.Items.INGOTS_PLATINUM, CoreTags.Items.NUGGETS_PLATINUM, CoreBlocks.PLATINUM_BLOCK.get(), CoreItems.PLATINUM_INGOT.get(), CoreItems.PLATINUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_LEAD, CoreTags.Items.INGOTS_LEAD, CoreTags.Items.NUGGETS_LEAD, CoreBlocks.LEAD_BLOCK.get(), CoreItems.LEAD_INGOT.get(), CoreItems.LEAD_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_BRONZE, CoreTags.Items.INGOTS_BRONZE, CoreTags.Items.NUGGETS_BRONZE, CoreBlocks.BRONZE_BLOCK.get(), CoreItems.BRONZE_INGOT.get(), CoreItems.BRONZE_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.INGOTS_ELECTRUM, CoreTags.Items.NUGGETS_ELECTRUM, CoreBlocks.ELECTRUM_BLOCK.get(), CoreItems.ELECTRUM_INGOT.get(), CoreItems.ELECTRUM_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_INVAR, CoreTags.Items.INGOTS_INVAR, CoreTags.Items.NUGGETS_INVAR, CoreBlocks.INVAR_BLOCK.get(), CoreItems.INVAR_INGOT.get(), CoreItems.INVAR_NUGGET.get(), consumer);
		storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_STEEL, CoreTags.Items.INGOTS_STEEL, CoreTags.Items.NUGGETS_STEEL, CoreBlocks.STEEL_BLOCK.get(), CoreItems.STEEL_INGOT.get(), CoreItems.STEEL_NUGGET.get(), consumer);

		storage(CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.RAW_MATERIALS_ALUMINUM, CoreBlocks.RAW_ALUMINUM_BLOCK.get(), CoreItems.RAW_ALUMINUM.get(), consumer);
		storage(CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD, CoreTags.Items.RAW_MATERIALS_LEAD, CoreBlocks.RAW_LEAD_BLOCK.get(), CoreItems.RAW_LEAD.get(), consumer);
		storage(CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL, CoreTags.Items.RAW_MATERIALS_NICKEL, CoreBlocks.RAW_NICKEL_BLOCK.get(), CoreItems.RAW_NICKEL.get(), consumer);
		storage(CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM, CoreTags.Items.RAW_MATERIALS_PLATINUM, CoreBlocks.RAW_PLATINUM_BLOCK.get(), CoreItems.RAW_PLATINUM.get(), consumer);
		storage(CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER, CoreTags.Items.RAW_MATERIALS_SILVER, CoreBlocks.RAW_SILVER_BLOCK.get(), CoreItems.RAW_SILVER.get(), consumer);
		storage(CoreTags.Items.RAW_STORAGE_BLOCKS_TIN, CoreTags.Items.RAW_MATERIALS_TIN, CoreBlocks.RAW_TIN_BLOCK.get(), CoreItems.RAW_TIN.get(), consumer);

		gemStorage(CoreTags.Items.STORAGE_BLOCKS_RUBY, CoreTags.Items.GEMS_RUBY, CoreBlocks.RUBY_BLOCK.get(), CoreItems.RUBY.get(), consumer);
		gemStorage(CoreTags.Items.STORAGE_BLOCKS_PERIDOT, CoreTags.Items.GEMS_PERIDOT, CoreBlocks.PERIDOT_BLOCK.get(), CoreItems.PERIDOT.get(), consumer);
		gemStorage(CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.GEMS_SAPPHIRE, CoreBlocks.SAPPHIRE_BLOCK.get(), CoreItems.SAPPHIRE.get(), consumer);
		gemStorage(CoreTags.Items.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.GEMS_TOPAZ, CoreBlocks.TOPAZ_BLOCK.get(), CoreItems.TOPAZ.get(), consumer);

		blastingSmelting(CoreTags.Items.ORES_TIN, CoreItems.TIN_INGOT.get(), 0.5f, consumer);
		blastingSmelting(CoreTags.Items.ORES_SILVER, CoreItems.SILVER_INGOT.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_ALUMINUM, CoreItems.ALUMINUM_INGOT.get(), 0.7f, consumer);
		blastingSmelting(CoreTags.Items.ORES_NICKEL, CoreItems.NICKEL_INGOT.get(), 0.7f, consumer);
		blastingSmelting(CoreTags.Items.ORES_PLATINUM, CoreItems.PLATINUM_INGOT.get(), 1.5f, consumer);
		blastingSmelting(CoreTags.Items.ORES_LEAD, CoreItems.LEAD_INGOT.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_RUBY, CoreItems.RUBY.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_PERIDOT, CoreItems.PERIDOT.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_SAPPHIRE, CoreItems.SAPPHIRE.get(), 1.0f, consumer);
		blastingSmelting(CoreTags.Items.ORES_TOPAZ, CoreItems.TOPAZ.get(), 1.0f, consumer);

		rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_TIN, CoreItems.TIN_INGOT.get(), 0.5f, consumer);
		rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_SILVER, CoreItems.SILVER_INGOT.get(), 1.0f, consumer);
		rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_ALUMINUM, CoreItems.ALUMINUM_INGOT.get(), 0.7f, consumer);
		rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_NICKEL, CoreItems.NICKEL_INGOT.get(), 0.7f, consumer);
		rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_PLATINUM, CoreItems.PLATINUM_INGOT.get(), 1.5f, consumer);
		rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_LEAD, CoreItems.LEAD_INGOT.get(), 1.0f, consumer);

		rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_TIN, CoreBlocks.TIN_BLOCK.get(), 1.0f, consumer);
		rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER, CoreBlocks.SILVER_BLOCK.get(), 2.0f, consumer);
		rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM, CoreBlocks.ALUMINUM_BLOCK.get(), 1.4f, consumer);
		rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL, CoreBlocks.NICKEL_BLOCK.get(), 1.4f, consumer);
		rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM, CoreBlocks.PLATINUM_BLOCK.get(), 3.0f, consumer);
		rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD, CoreBlocks.LEAD_BLOCK.get(), 1.0f, consumer);

		ingotDust(CoreTags.Items.DUSTS_TIN, CoreItems.TIN_INGOT.get(), consumer);
		ingotDust(CoreTags.Items.DUSTS_COPPER, Items.COPPER_INGOT, consumer);
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

		gear(CoreTags.Items.INGOTS_TIN, CoreItems.TIN_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_COPPER, CoreItems.COPPER_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_SILVER, CoreItems.SILVER_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_ALUMINUM, CoreItems.ALUMINUM_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_NICKEL, CoreItems.NICKEL_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_PLATINUM, CoreItems.PLATINUM_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_LEAD, CoreItems.LEAD_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_BRONZE, CoreItems.BRONZE_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_ELECTRUM, CoreItems.ELECTRUM_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_INVAR, CoreItems.INVAR_GEAR.get(), consumer);
		gear(CoreTags.Items.INGOTS_STEEL, CoreItems.STEEL_GEAR.get(), consumer);
		gear(Tags.Items.INGOTS_IRON, CoreItems.IRON_GEAR.get(), consumer);
		gear(Tags.Items.INGOTS_GOLD, CoreItems.GOLD_GEAR.get(), consumer);

		alloy(ItemTags.COALS, 4, CoreTags.Items.DUSTS_IRON, 1, new ItemStack(CoreItems.STEEL_INGOT.get(), 1), 0.5F, 800, consumer);
		alloy(CoreTags.Items.DUSTS_COPPER, 3, CoreTags.Items.DUSTS_TIN, 1, new ItemStack(CoreItems.BRONZE_INGOT.get(), 4), 0.5F, consumer);
		alloy(CoreTags.Items.DUSTS_IRON, 2, CoreTags.Items.DUSTS_NICKEL, 1, new ItemStack(CoreItems.INVAR_INGOT.get(), 3), 0.7F, 500, consumer);
		alloy(CoreTags.Items.DUSTS_SILVER, CoreTags.Items.DUSTS_GOLD, new ItemStack(CoreItems.ELECTRUM_INGOT.get(), 2), 0.7F, consumer);

		grinding(CoreTags.Items.ORES_TIN, new ItemStack(CoreItems.TIN_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(CoreTags.Items.ORES_COPPER, new ItemStack(CoreItems.COPPER_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(CoreTags.Items.ORES_SILVER, new ItemStack(CoreItems.SILVER_DUST.get(), 2), 0.4F, 600, consumer);
		grinding(CoreTags.Items.ORES_ALUMINUM, new ItemStack(CoreItems.ALUMINUM_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(CoreTags.Items.ORES_NICKEL, new ItemStack(CoreItems.NICKEL_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(CoreTags.Items.ORES_PLATINUM, new ItemStack(CoreItems.PLATINUM_DUST.get(), 2), 0.5F, 600, consumer);
		grinding(CoreTags.Items.ORES_LEAD, new ItemStack(CoreItems.LEAD_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(CoreTags.Items.ORES_RUBY, new ItemStack(CoreItems.RUBY.get(), 2), 0.3F, 600, consumer);
		grinding(CoreTags.Items.ORES_PERIDOT, new ItemStack(CoreItems.PERIDOT.get(), 2), 0.3F, 600, consumer);
		grinding(CoreTags.Items.ORES_SAPPHIRE, new ItemStack(CoreItems.SAPPHIRE.get(), 2), 0.3F, 600, consumer);
		grinding(CoreTags.Items.ORES_TOPAZ, new ItemStack(CoreItems.TOPAZ.get(), 2), 0.3F, 600, consumer);

		grinding(Tags.Items.ORES_GOLD, new ItemStack(CoreItems.GOLD_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(Tags.Items.ORES_IRON, new ItemStack(CoreItems.IRON_DUST.get(), 2), 0.2F, 600, consumer);
		grinding(Tags.Items.ORES_DIAMOND, new ItemStack(Items.DIAMOND, 2), 0.3F, 600, consumer);
		grinding(Tags.Items.ORES_EMERALD, new ItemStack(Items.EMERALD, 2), 0.3F, 600, consumer);
		grinding(Tags.Items.ORES_COAL, new ItemStack(Items.COAL, 3), 0.1F, 600, consumer);
		grinding(Tags.Items.ORES_REDSTONE, new ItemStack(Items.REDSTONE, 5), 0.2F, 600, consumer);
		grinding(Tags.Items.ORES_LAPIS, new ItemStack(Items.LAPIS_LAZULI, 5), 0.2F, 600, consumer);
		grinding(Tags.Items.ORES_QUARTZ, new ItemStack(Items.QUARTZ, 2), 0.2F, 600, consumer);

		grindingDustFromIngot(Tags.Items.INGOTS_GOLD, new ItemStack(CoreItems.GOLD_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(Tags.Items.INGOTS_IRON, new ItemStack(CoreItems.IRON_DUST.get(), 1), 0.0F, 300, consumer);

		grindingDustFromIngot(CoreTags.Items.INGOTS_TIN, new ItemStack(CoreItems.TIN_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_COPPER, new ItemStack(CoreItems.COPPER_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_SILVER, new ItemStack(CoreItems.SILVER_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_ALUMINUM, new ItemStack(CoreItems.ALUMINUM_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_NICKEL, new ItemStack(CoreItems.NICKEL_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_PLATINUM, new ItemStack(CoreItems.PLATINUM_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_LEAD, new ItemStack(CoreItems.LEAD_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_BRONZE, new ItemStack(CoreItems.BRONZE_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_ELECTRUM, new ItemStack(CoreItems.ELECTRUM_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_STEEL, new ItemStack(CoreItems.STEEL_DUST.get(), 1), 0.0F, 300, consumer);
		grindingDustFromIngot(CoreTags.Items.INGOTS_INVAR, new ItemStack(CoreItems.INVAR_DUST.get(), 1), 0.0F, 300, consumer);

		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_GOLD, new ItemStack(CoreItems.GOLD_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_IRON, new ItemStack(CoreItems.IRON_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_TIN, new ItemStack(CoreItems.TIN_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_COPPER, new ItemStack(CoreItems.COPPER_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_SILVER, new ItemStack(CoreItems.SILVER_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_ALUMINUM, new ItemStack(CoreItems.ALUMINUM_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_NICKEL, new ItemStack(CoreItems.NICKEL_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_PLATINUM, new ItemStack(CoreItems.PLATINUM_DUST.get(), 2), 0.0F, 300, consumer);
		grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_LEAD, new ItemStack(CoreItems.LEAD_DUST.get(), 2), 0.0F, 300, consumer);

		ShapedRecipeBuilder.shaped(CoreBlocks.MACHINE_CORE.get()).define('A', CoreTags.Items.INGOTS_ALUMINUM).define('C', CoreTags.Items.GEARS_COPPER).define('I', Tags.Items.INGOTS_IRON).pattern("IAI").pattern("ACA").pattern("IAI").unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.BASIC_ALLOY_FORGE.get()).define('X', CoreBlocks.MACHINE_CORE.get()).define('B', Blocks.BLAST_FURNACE).define('I', Tags.Items.INGOTS_IRON).pattern("III").pattern("BXB").pattern("III").unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).unlockedBy("has_blast_furnace", has(Blocks.BLAST_FURNACE)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()).define('X', CoreBlocks.BASIC_ALLOY_FORGE.get()).define('S', CoreTags.Items.INGOTS_STEEL).pattern("SSS").pattern("SXS").pattern("SSS").unlockedBy("has_steel", has(CoreTags.Items.INGOTS_STEEL)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.ADVANCED_ALLOY_FORGE.get()).define('X', CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()).define('E', CoreTags.Items.INGOTS_ELECTRUM).define('V', CoreTags.Items.INGOTS_INVAR).pattern("VEV").pattern("EXE").pattern("VEV").unlockedBy("has_electrum", has(CoreTags.Items.INGOTS_ELECTRUM)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.EXPERT_ALLOY_FORGE.get()).define('X', CoreBlocks.ADVANCED_ALLOY_FORGE.get()).define('P', CoreTags.Items.INGOTS_PLATINUM).pattern(" P ").pattern("PXP").pattern(" P ").unlockedBy("has_platinum", has(CoreTags.Items.INGOTS_PLATINUM)).save(consumer);

		ShapedRecipeBuilder.shaped(CoreBlocks.BASIC_GRINDING_MILL.get()).define('X', CoreBlocks.MACHINE_CORE.get()).define('F', Blocks.FURNACE).define('I', Tags.Items.INGOTS_IRON).define('P', Items.IRON_PICKAXE).define('G', CoreTags.Items.GEARS_IRON).pattern("IPI").pattern("GXG").pattern("IFI").unlockedBy("has_iron_pickaxe", has(Items.IRON_PICKAXE)).unlockedBy("has_furnace", has(Blocks.FURNACE)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()).define('X', CoreBlocks.BASIC_GRINDING_MILL.get()).define('S', CoreTags.Items.INGOTS_STEEL).pattern("SSS").pattern("SXS").pattern("SSS").unlockedBy("has_steel", has(CoreTags.Items.INGOTS_STEEL)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.ADVANCED_GRINDING_MILL.get()).define('X', CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()).define('E', CoreTags.Items.INGOTS_ELECTRUM).define('V', CoreTags.Items.INGOTS_INVAR).pattern("VEV").pattern("EXE").pattern("VEV").unlockedBy("has_electrum", has(CoreTags.Items.INGOTS_ELECTRUM)).save(consumer);
		ShapedRecipeBuilder.shaped(CoreBlocks.EXPERT_GRINDING_MILL.get()).define('X', CoreBlocks.ADVANCED_GRINDING_MILL.get()).define('P', CoreTags.Items.INGOTS_PLATINUM).pattern(" P ").pattern("PXP").pattern(" P ").unlockedBy("has_platinum", has(CoreTags.Items.INGOTS_PLATINUM)).save(consumer);
	}

	private void alloy(TagKey<Item> ingredient1, int ingredient1Count, TagKey<Item> ingredient2, int ingredient2Count, ItemStack result, float experience, Consumer<FinishedRecipe> consumer) {
		alloy(ingredient1, ingredient1Count, ingredient2, ingredient2Count, result, experience, 400, consumer);
	}

	private void alloy(TagKey<Item> ingredient1, TagKey<Item> ingredient2, ItemStack result, float experience, Consumer<FinishedRecipe> consumer) {
		alloy(ingredient1, ingredient2, result, experience, 400, consumer);
	}

	private void alloy(TagKey<Item> ingredient1, TagKey<Item> ingredient2, ItemStack result, float experience, int cookTime, Consumer<FinishedRecipe> consumer) {
		alloy(ingredient1, 1, ingredient2, 1, result, experience, cookTime, consumer);
	}

	private void alloy(TagKey<Item> ingredient1, int ingredient1Count, TagKey<Item> ingredient2, int ingredient2Count, ItemStack result, float experience, int cookTime, Consumer<FinishedRecipe> consumer) {
		AlloyForgeRecipeBuilder.recipe(new MachineIngredient(Ingredient.of(ingredient1), ingredient1Count), new MachineIngredient(Ingredient.of(ingredient2), ingredient2Count), result, experience, cookTime).addCriterion("has_ingredient1", has(ingredient1)).addCriterion("has_ingredient2", has(ingredient2)).build(consumer);
	}

	private void grindingDustFromRawOre(TagKey<Item> ingredient, ItemStack result, float experience, int cookTime, Consumer<FinishedRecipe> consumer) {
		grinding(ingredient, result, experience, cookTime, consumer, "_from_raw_ore");
	}

	private void grindingDustFromIngot(TagKey<Item> ingredient, ItemStack result, float experience, int cookTime, Consumer<FinishedRecipe> consumer) {
		grinding(ingredient, result, experience, cookTime, consumer, "_from_ingot");
	}

	private void grinding(TagKey<Item> ingredient, ItemStack result, float experience, int cookTime, Consumer<FinishedRecipe> consumer) {
		grinding(ingredient, result, experience, cookTime, consumer, "");
	}

	private void grinding(TagKey<Item> ingredient, ItemStack result, float experience, int cookTime, Consumer<FinishedRecipe> consumer, String name) {
		GrindingMillRecipeBuilder.recipe(new MachineIngredient(Ingredient.of(ingredient)), result, experience, cookTime).addCriterion("has_ingredient", has(ingredient)).build(consumer, new ResourceLocation(AssortedCore.MODID, result.getItem().getRegistryName().getPath() + name));
	}

	private void gear(TagKey<Item> material, ItemLike gear, Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(gear).define('M', material).define('S', Tags.Items.RODS_WOODEN).pattern(" M ").pattern("MSM").pattern(" M ").unlockedBy("has_material", has(material)).save(consumer);
	}

	private void ingotDust(TagKey<Item> dust, ItemLike ingot, Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(dust), ingot, 0.1F, 100).unlockedBy("has_dust", has(dust)).save(consumer, new ResourceLocation(AssortedCore.MODID, dust.location().getPath() + "_blasting"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), ingot, 0.1F, 200).unlockedBy("has_dust", has(dust)).save(consumer, new ResourceLocation(AssortedCore.MODID, dust.location().getPath() + "_smelting"));
	}

	private void rawStorageBlastingSmelting(TagKey<Item> rawStorage, ItemLike output, float experience, Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(rawStorage), output, experience, 100).unlockedBy("has_storage", has(rawStorage)).save(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_blasting_raw_storage"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(rawStorage), output, experience, 200).unlockedBy("has_storage", has(rawStorage)).save(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_smelting_raw_storage"));
	}

	private void rawOreBlastingSmelting(TagKey<Item> ore, ItemLike output, float experience, Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), output, experience, 100).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_blasting_raw_ore"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), output, experience, 200).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_smelting_raw_ore"));
	}

	private void blastingSmelting(TagKey<Item> ore, ItemLike output, float experience, Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), output, experience, 100).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_blasting"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), output, experience, 200).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(AssortedCore.MODID, output.asItem().getRegistryName().getPath() + "_smelting"));
	}

	private void gemStorage(TagKey<Item> storageBlockTag, TagKey<Item> gemTag, ItemLike storageBlock, ItemLike gem, Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(gem, 9).requires(Ingredient.of(storageBlockTag)).unlockedBy("has_gem", has(storageBlockTag)).save(consumer, new ResourceLocation(AssortedCore.MODID, gem.asItem().getRegistryName().getPath() + "_storage_block"));
		ShapelessRecipeBuilder.shapeless(storageBlock, 1).requires(Ingredient.of(gemTag), 9).unlockedBy("has_gem", has(gemTag)).save(consumer);
	}

	private void storage(TagKey<Item> storageBlockTag, TagKey<Item> nonStoreTag, ItemLike storageBlock, ItemLike nonStore, Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(nonStore, 9).requires(Ingredient.of(storageBlockTag)).unlockedBy("has_storage_item", has(nonStoreTag)).save(consumer, new ResourceLocation(AssortedCore.MODID, nonStore.asItem().getRegistryName().getPath() + "_storage_block"));
		ShapelessRecipeBuilder.shapeless(storageBlock, 1).requires(Ingredient.of(nonStoreTag), 9).unlockedBy("has_storage_item", has(nonStoreTag)).save(consumer);
	}

	private void storageIngotNugget(TagKey<Item> storageBlockTag, TagKey<Item> ingotTag, TagKey<Item> nuggetTag, ItemLike storageBlock, ItemLike ingot, ItemLike nugget, Consumer<FinishedRecipe> consumer) {
		storage(storageBlockTag, ingotTag, storageBlock, ingot, consumer);
		ingotNugget(ingotTag, nuggetTag, ingot, nugget, consumer);
	}

	private void ingotNugget(TagKey<Item> ingotTag, TagKey<Item> nuggetTag, ItemLike ingot, ItemLike nugget, Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(nugget, 9).requires(Ingredient.of(ingotTag)).unlockedBy("has_ingot", has(ingotTag)).save(consumer);
		ShapelessRecipeBuilder.shapeless(ingot, 1).requires(Ingredient.of(nuggetTag), 9).unlockedBy("has_ingot", has(ingotTag)).save(consumer, new ResourceLocation(AssortedCore.MODID, ingot.asItem().getRegistryName().getPath() + "_nuggets"));
	}

	@Override
	public String getName() {
		return "Assorted Core recipes";
	}
}
