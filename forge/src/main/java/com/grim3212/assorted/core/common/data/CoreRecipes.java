package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.api.crafting.builders.AlloyForgeRecipeBuilder;
import com.grim3212.assorted.core.api.crafting.builders.GrindingMillRecipeBuilder;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.items.AssortedCoreItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CoreRecipes extends RecipeProvider {

    public CoreRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_TIN, CoreTags.Items.INGOTS_TIN, CoreTags.Items.NUGGETS_TIN, AssortedCoreBlocks.TIN_BLOCK.get(), AssortedCoreItems.TIN_INGOT.get(), AssortedCoreItems.TIN_NUGGET.get(), consumer);
        ingotNugget(CoreTags.Items.INGOTS_COPPER, CoreTags.Items.NUGGETS_COPPER, Items.COPPER_INGOT, AssortedCoreItems.COPPER_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_SILVER, CoreTags.Items.INGOTS_SILVER, CoreTags.Items.NUGGETS_SILVER, AssortedCoreBlocks.SILVER_BLOCK.get(), AssortedCoreItems.SILVER_INGOT.get(), AssortedCoreItems.SILVER_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.INGOTS_ALUMINUM, CoreTags.Items.NUGGETS_ALUMINUM, AssortedCoreBlocks.ALUMINUM_BLOCK.get(), AssortedCoreItems.ALUMINUM_INGOT.get(), AssortedCoreItems.ALUMINUM_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_NICKEL, CoreTags.Items.INGOTS_NICKEL, CoreTags.Items.NUGGETS_NICKEL, AssortedCoreBlocks.NICKEL_BLOCK.get(), AssortedCoreItems.NICKEL_INGOT.get(), AssortedCoreItems.NICKEL_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_PLATINUM, CoreTags.Items.INGOTS_PLATINUM, CoreTags.Items.NUGGETS_PLATINUM, AssortedCoreBlocks.PLATINUM_BLOCK.get(), AssortedCoreItems.PLATINUM_INGOT.get(), AssortedCoreItems.PLATINUM_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_LEAD, CoreTags.Items.INGOTS_LEAD, CoreTags.Items.NUGGETS_LEAD, AssortedCoreBlocks.LEAD_BLOCK.get(), AssortedCoreItems.LEAD_INGOT.get(), AssortedCoreItems.LEAD_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_BRONZE, CoreTags.Items.INGOTS_BRONZE, CoreTags.Items.NUGGETS_BRONZE, AssortedCoreBlocks.BRONZE_BLOCK.get(), AssortedCoreItems.BRONZE_INGOT.get(), AssortedCoreItems.BRONZE_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.INGOTS_ELECTRUM, CoreTags.Items.NUGGETS_ELECTRUM, AssortedCoreBlocks.ELECTRUM_BLOCK.get(), AssortedCoreItems.ELECTRUM_INGOT.get(), AssortedCoreItems.ELECTRUM_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_INVAR, CoreTags.Items.INGOTS_INVAR, CoreTags.Items.NUGGETS_INVAR, AssortedCoreBlocks.INVAR_BLOCK.get(), AssortedCoreItems.INVAR_INGOT.get(), AssortedCoreItems.INVAR_NUGGET.get(), consumer);
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_STEEL, CoreTags.Items.INGOTS_STEEL, CoreTags.Items.NUGGETS_STEEL, AssortedCoreBlocks.STEEL_BLOCK.get(), AssortedCoreItems.STEEL_INGOT.get(), AssortedCoreItems.STEEL_NUGGET.get(), consumer);

        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.RAW_MATERIALS_ALUMINUM, AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get(), AssortedCoreItems.RAW_ALUMINUM.get(), consumer);
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD, CoreTags.Items.RAW_MATERIALS_LEAD, AssortedCoreBlocks.RAW_LEAD_BLOCK.get(), AssortedCoreItems.RAW_LEAD.get(), consumer);
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL, CoreTags.Items.RAW_MATERIALS_NICKEL, AssortedCoreBlocks.RAW_NICKEL_BLOCK.get(), AssortedCoreItems.RAW_NICKEL.get(), consumer);
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM, CoreTags.Items.RAW_MATERIALS_PLATINUM, AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get(), AssortedCoreItems.RAW_PLATINUM.get(), consumer);
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER, CoreTags.Items.RAW_MATERIALS_SILVER, AssortedCoreBlocks.RAW_SILVER_BLOCK.get(), AssortedCoreItems.RAW_SILVER.get(), consumer);
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_TIN, CoreTags.Items.RAW_MATERIALS_TIN, AssortedCoreBlocks.RAW_TIN_BLOCK.get(), AssortedCoreItems.RAW_TIN.get(), consumer);

        gemStorage(CoreTags.Items.STORAGE_BLOCKS_RUBY, CoreTags.Items.GEMS_RUBY, AssortedCoreBlocks.RUBY_BLOCK.get(), AssortedCoreItems.RUBY.get(), consumer);
        gemStorage(CoreTags.Items.STORAGE_BLOCKS_PERIDOT, CoreTags.Items.GEMS_PERIDOT, AssortedCoreBlocks.PERIDOT_BLOCK.get(), AssortedCoreItems.PERIDOT.get(), consumer);
        gemStorage(CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.GEMS_SAPPHIRE, AssortedCoreBlocks.SAPPHIRE_BLOCK.get(), AssortedCoreItems.SAPPHIRE.get(), consumer);
        gemStorage(CoreTags.Items.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.GEMS_TOPAZ, AssortedCoreBlocks.TOPAZ_BLOCK.get(), AssortedCoreItems.TOPAZ.get(), consumer);

        blastingSmelting(CoreTags.Items.ORES_TIN, AssortedCoreItems.TIN_INGOT.get(), 0.5f, consumer);
        blastingSmelting(CoreTags.Items.ORES_SILVER, AssortedCoreItems.SILVER_INGOT.get(), 1.0f, consumer);
        blastingSmelting(CoreTags.Items.ORES_ALUMINUM, AssortedCoreItems.ALUMINUM_INGOT.get(), 0.7f, consumer);
        blastingSmelting(CoreTags.Items.ORES_NICKEL, AssortedCoreItems.NICKEL_INGOT.get(), 0.7f, consumer);
        blastingSmelting(CoreTags.Items.ORES_PLATINUM, AssortedCoreItems.PLATINUM_INGOT.get(), 1.5f, consumer);
        blastingSmelting(CoreTags.Items.ORES_LEAD, AssortedCoreItems.LEAD_INGOT.get(), 1.0f, consumer);
        blastingSmelting(CoreTags.Items.ORES_RUBY, AssortedCoreItems.RUBY.get(), 1.0f, consumer);
        blastingSmelting(CoreTags.Items.ORES_PERIDOT, AssortedCoreItems.PERIDOT.get(), 1.0f, consumer);
        blastingSmelting(CoreTags.Items.ORES_SAPPHIRE, AssortedCoreItems.SAPPHIRE.get(), 1.0f, consumer);
        blastingSmelting(CoreTags.Items.ORES_TOPAZ, AssortedCoreItems.TOPAZ.get(), 1.0f, consumer);

        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_TIN, AssortedCoreItems.TIN_INGOT.get(), 0.5f, consumer);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_SILVER, AssortedCoreItems.SILVER_INGOT.get(), 1.0f, consumer);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_ALUMINUM, AssortedCoreItems.ALUMINUM_INGOT.get(), 0.7f, consumer);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_NICKEL, AssortedCoreItems.NICKEL_INGOT.get(), 0.7f, consumer);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_PLATINUM, AssortedCoreItems.PLATINUM_INGOT.get(), 1.5f, consumer);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_LEAD, AssortedCoreItems.LEAD_INGOT.get(), 1.0f, consumer);

        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_TIN, AssortedCoreBlocks.TIN_BLOCK.get(), 1.0f, consumer);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER, AssortedCoreBlocks.SILVER_BLOCK.get(), 2.0f, consumer);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM, AssortedCoreBlocks.ALUMINUM_BLOCK.get(), 1.4f, consumer);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL, AssortedCoreBlocks.NICKEL_BLOCK.get(), 1.4f, consumer);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM, AssortedCoreBlocks.PLATINUM_BLOCK.get(), 3.0f, consumer);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD, AssortedCoreBlocks.LEAD_BLOCK.get(), 1.0f, consumer);

        ingotDust(CoreTags.Items.DUSTS_TIN, AssortedCoreItems.TIN_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_COPPER, Items.COPPER_INGOT, consumer);
        ingotDust(CoreTags.Items.DUSTS_SILVER, AssortedCoreItems.SILVER_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_ALUMINUM, AssortedCoreItems.ALUMINUM_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_NICKEL, AssortedCoreItems.NICKEL_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_PLATINUM, AssortedCoreItems.PLATINUM_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_LEAD, AssortedCoreItems.LEAD_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_BRONZE, AssortedCoreItems.BRONZE_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_ELECTRUM, AssortedCoreItems.ELECTRUM_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_INVAR, AssortedCoreItems.INVAR_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_STEEL, AssortedCoreItems.STEEL_INGOT.get(), consumer);
        ingotDust(CoreTags.Items.DUSTS_IRON, Items.IRON_INGOT, consumer);
        ingotDust(CoreTags.Items.DUSTS_GOLD, Items.GOLD_INGOT, consumer);

        gear(CoreTags.Items.INGOTS_TIN, AssortedCoreItems.TIN_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_COPPER, AssortedCoreItems.COPPER_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_SILVER, AssortedCoreItems.SILVER_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_ALUMINUM, AssortedCoreItems.ALUMINUM_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_NICKEL, AssortedCoreItems.NICKEL_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_PLATINUM, AssortedCoreItems.PLATINUM_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_LEAD, AssortedCoreItems.LEAD_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_BRONZE, AssortedCoreItems.BRONZE_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_ELECTRUM, AssortedCoreItems.ELECTRUM_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_INVAR, AssortedCoreItems.INVAR_GEAR.get(), consumer);
        gear(CoreTags.Items.INGOTS_STEEL, AssortedCoreItems.STEEL_GEAR.get(), consumer);
        gear(Tags.Items.INGOTS_IRON, AssortedCoreItems.IRON_GEAR.get(), consumer);
        gear(Tags.Items.INGOTS_GOLD, AssortedCoreItems.GOLD_GEAR.get(), consumer);

        alloy(ItemTags.COALS, 4, CoreTags.Items.DUSTS_IRON, 1, new ItemStack(AssortedCoreItems.STEEL_INGOT.get(), 1), 0.5F, 800, consumer);
        alloy(CoreTags.Items.DUSTS_COPPER, 3, CoreTags.Items.DUSTS_TIN, 1, new ItemStack(AssortedCoreItems.BRONZE_INGOT.get(), 4), 0.5F, consumer);
        alloy(CoreTags.Items.DUSTS_IRON, 2, CoreTags.Items.DUSTS_NICKEL, 1, new ItemStack(AssortedCoreItems.INVAR_INGOT.get(), 3), 0.7F, 500, consumer);
        alloy(CoreTags.Items.DUSTS_SILVER, CoreTags.Items.DUSTS_GOLD, new ItemStack(AssortedCoreItems.ELECTRUM_INGOT.get(), 2), 0.7F, consumer);

        grinding(CoreTags.Items.ORES_TIN, new ItemStack(AssortedCoreItems.TIN_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(CoreTags.Items.ORES_COPPER, new ItemStack(AssortedCoreItems.COPPER_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(CoreTags.Items.ORES_SILVER, new ItemStack(AssortedCoreItems.SILVER_DUST.get(), 2), 0.4F, 600, consumer);
        grinding(CoreTags.Items.ORES_ALUMINUM, new ItemStack(AssortedCoreItems.ALUMINUM_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(CoreTags.Items.ORES_NICKEL, new ItemStack(AssortedCoreItems.NICKEL_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(CoreTags.Items.ORES_PLATINUM, new ItemStack(AssortedCoreItems.PLATINUM_DUST.get(), 2), 0.5F, 600, consumer);
        grinding(CoreTags.Items.ORES_LEAD, new ItemStack(AssortedCoreItems.LEAD_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(CoreTags.Items.ORES_RUBY, new ItemStack(AssortedCoreItems.RUBY.get(), 2), 0.3F, 600, consumer);
        grinding(CoreTags.Items.ORES_PERIDOT, new ItemStack(AssortedCoreItems.PERIDOT.get(), 2), 0.3F, 600, consumer);
        grinding(CoreTags.Items.ORES_SAPPHIRE, new ItemStack(AssortedCoreItems.SAPPHIRE.get(), 2), 0.3F, 600, consumer);
        grinding(CoreTags.Items.ORES_TOPAZ, new ItemStack(AssortedCoreItems.TOPAZ.get(), 2), 0.3F, 600, consumer);

        grinding(Tags.Items.ORES_GOLD, new ItemStack(AssortedCoreItems.GOLD_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(Tags.Items.ORES_IRON, new ItemStack(AssortedCoreItems.IRON_DUST.get(), 2), 0.2F, 600, consumer);
        grinding(Tags.Items.ORES_DIAMOND, new ItemStack(Items.DIAMOND, 2), 0.3F, 600, consumer);
        grinding(Tags.Items.ORES_EMERALD, new ItemStack(Items.EMERALD, 2), 0.3F, 600, consumer);
        grinding(Tags.Items.ORES_COAL, new ItemStack(Items.COAL, 3), 0.1F, 600, consumer);
        grinding(Tags.Items.ORES_REDSTONE, new ItemStack(Items.REDSTONE, 5), 0.2F, 600, consumer);
        grinding(Tags.Items.ORES_LAPIS, new ItemStack(Items.LAPIS_LAZULI, 5), 0.2F, 600, consumer);
        grinding(Tags.Items.ORES_QUARTZ, new ItemStack(Items.QUARTZ, 2), 0.2F, 600, consumer);

        grindingDustFromIngot(Tags.Items.INGOTS_GOLD, new ItemStack(AssortedCoreItems.GOLD_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(Tags.Items.INGOTS_IRON, new ItemStack(AssortedCoreItems.IRON_DUST.get(), 1), 0.0F, 300, consumer);

        grindingDustFromIngot(CoreTags.Items.INGOTS_TIN, new ItemStack(AssortedCoreItems.TIN_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_COPPER, new ItemStack(AssortedCoreItems.COPPER_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_SILVER, new ItemStack(AssortedCoreItems.SILVER_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_ALUMINUM, new ItemStack(AssortedCoreItems.ALUMINUM_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_NICKEL, new ItemStack(AssortedCoreItems.NICKEL_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_PLATINUM, new ItemStack(AssortedCoreItems.PLATINUM_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_LEAD, new ItemStack(AssortedCoreItems.LEAD_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_BRONZE, new ItemStack(AssortedCoreItems.BRONZE_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_ELECTRUM, new ItemStack(AssortedCoreItems.ELECTRUM_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_STEEL, new ItemStack(AssortedCoreItems.STEEL_DUST.get(), 1), 0.0F, 300, consumer);
        grindingDustFromIngot(CoreTags.Items.INGOTS_INVAR, new ItemStack(AssortedCoreItems.INVAR_DUST.get(), 1), 0.0F, 300, consumer);

        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_GOLD, new ItemStack(AssortedCoreItems.GOLD_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_IRON, new ItemStack(AssortedCoreItems.IRON_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_TIN, new ItemStack(AssortedCoreItems.TIN_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_COPPER, new ItemStack(AssortedCoreItems.COPPER_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_SILVER, new ItemStack(AssortedCoreItems.SILVER_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_ALUMINUM, new ItemStack(AssortedCoreItems.ALUMINUM_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_NICKEL, new ItemStack(AssortedCoreItems.NICKEL_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_PLATINUM, new ItemStack(AssortedCoreItems.PLATINUM_DUST.get(), 2), 0.0F, 300, consumer);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_LEAD, new ItemStack(AssortedCoreItems.LEAD_DUST.get(), 2), 0.0F, 300, consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.MACHINE_CORE.get()).define('A', CoreTags.Items.INGOTS_ALUMINUM).define('C', CoreTags.Items.GEARS_COPPER).define('I', Tags.Items.INGOTS_IRON).pattern("IAI").pattern("ACA").pattern("IAI").unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.BASIC_ALLOY_FORGE.get()).define('X', AssortedCoreBlocks.MACHINE_CORE.get()).define('B', Blocks.BLAST_FURNACE).define('I', Tags.Items.INGOTS_IRON).pattern("III").pattern("BXB").pattern("III").unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).unlockedBy("has_blast_furnace", has(Blocks.BLAST_FURNACE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()).define('X', AssortedCoreBlocks.BASIC_ALLOY_FORGE.get()).define('S', CoreTags.Items.INGOTS_STEEL).pattern("SSS").pattern("SXS").pattern("SSS").unlockedBy("has_steel", has(CoreTags.Items.INGOTS_STEEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get()).define('X', AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()).define('E', CoreTags.Items.INGOTS_ELECTRUM).define('V', CoreTags.Items.INGOTS_INVAR).pattern("VEV").pattern("EXE").pattern("VEV").unlockedBy("has_electrum", has(CoreTags.Items.INGOTS_ELECTRUM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.EXPERT_ALLOY_FORGE.get()).define('X', AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get()).define('P', CoreTags.Items.INGOTS_PLATINUM).pattern(" P ").pattern("PXP").pattern(" P ").unlockedBy("has_platinum", has(CoreTags.Items.INGOTS_PLATINUM)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.BASIC_GRINDING_MILL.get()).define('X', AssortedCoreBlocks.MACHINE_CORE.get()).define('F', Blocks.FURNACE).define('I', Tags.Items.INGOTS_IRON).define('P', Items.IRON_PICKAXE).define('G', CoreTags.Items.GEARS_IRON).pattern("IPI").pattern("GXG").pattern("IFI").unlockedBy("has_iron_pickaxe", has(Items.IRON_PICKAXE)).unlockedBy("has_furnace", has(Blocks.FURNACE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get()).define('X', AssortedCoreBlocks.BASIC_GRINDING_MILL.get()).define('S', CoreTags.Items.INGOTS_STEEL).pattern("SSS").pattern("SXS").pattern("SSS").unlockedBy("has_steel", has(CoreTags.Items.INGOTS_STEEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get()).define('X', AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get()).define('E', CoreTags.Items.INGOTS_ELECTRUM).define('V', CoreTags.Items.INGOTS_INVAR).pattern("VEV").pattern("EXE").pattern("VEV").unlockedBy("has_electrum", has(CoreTags.Items.INGOTS_ELECTRUM)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AssortedCoreBlocks.EXPERT_GRINDING_MILL.get()).define('X', AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get()).define('P', CoreTags.Items.INGOTS_PLATINUM).pattern(" P ").pattern("PXP").pattern(" P ").unlockedBy("has_platinum", has(CoreTags.Items.INGOTS_PLATINUM)).save(consumer);
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
        GrindingMillRecipeBuilder.recipe(new MachineIngredient(Ingredient.of(ingredient)), result, experience, cookTime).addCriterion("has_ingredient", has(ingredient)).build(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(result.getItem()) + name));
    }

    private void gear(TagKey<Item> material, ItemLike gear, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, gear).define('M', material).define('S', Tags.Items.RODS_WOODEN).pattern(" M ").pattern("MSM").pattern(" M ").unlockedBy("has_material", has(material)).save(consumer);
    }

    private void ingotDust(TagKey<Item> dust, ItemLike ingot, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(dust), RecipeCategory.MISC, ingot, 0.1F, 100).unlockedBy("has_dust", has(dust)).save(consumer, new ResourceLocation(Constants.MOD_ID, dust.location().getPath() + "_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), RecipeCategory.MISC, ingot, 0.1F, 200).unlockedBy("has_dust", has(dust)).save(consumer, new ResourceLocation(Constants.MOD_ID, dust.location().getPath() + "_smelting"));
    }

    private void rawStorageBlastingSmelting(TagKey<Item> rawStorage, ItemLike output, float experience, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(rawStorage), RecipeCategory.MISC, output, experience, 100).unlockedBy("has_storage", has(rawStorage)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(output.asItem()) + "_blasting_raw_storage"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(rawStorage), RecipeCategory.MISC, output, experience, 200).unlockedBy("has_storage", has(rawStorage)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(output.asItem()) + "_smelting_raw_storage"));
    }

    private void rawOreBlastingSmelting(TagKey<Item> ore, ItemLike output, float experience, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), RecipeCategory.MISC, output, experience, 100).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(output.asItem()) + "_blasting_raw_ore"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), RecipeCategory.MISC, output, experience, 200).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(output.asItem()) + "_smelting_raw_ore"));
    }

    private void blastingSmelting(TagKey<Item> ore, ItemLike output, float experience, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), RecipeCategory.MISC, output, experience, 100).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(output.asItem()) + "_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ore), RecipeCategory.MISC, output, experience, 200).unlockedBy("has_ore", has(ore)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(output.asItem()) + "_smelting"));
    }

    private void gemStorage(TagKey<Item> storageBlockTag, TagKey<Item> gemTag, ItemLike storageBlock, ItemLike gem, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, gem, 9).requires(Ingredient.of(storageBlockTag)).unlockedBy("has_gem", has(storageBlockTag)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(gem.asItem()) + "_storage_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, storageBlock, 1).requires(Ingredient.of(gemTag), 9).unlockedBy("has_gem", has(gemTag)).save(consumer);
    }

    private void storage(TagKey<Item> storageBlockTag, TagKey<Item> nonStoreTag, ItemLike storageBlock, ItemLike nonStore, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nonStore, 9).requires(Ingredient.of(storageBlockTag)).unlockedBy("has_storage_item", has(nonStoreTag)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(nonStore.asItem()) + "_storage_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, storageBlock, 1).requires(Ingredient.of(nonStoreTag), 9).unlockedBy("has_storage_item", has(nonStoreTag)).save(consumer);
    }

    private void storageIngotNugget(TagKey<Item> storageBlockTag, TagKey<Item> ingotTag, TagKey<Item> nuggetTag, ItemLike storageBlock, ItemLike ingot, ItemLike nugget, Consumer<FinishedRecipe> consumer) {
        storage(storageBlockTag, ingotTag, storageBlock, ingot, consumer);
        ingotNugget(ingotTag, nuggetTag, ingot, nugget, consumer);
    }

    private void ingotNugget(TagKey<Item> ingotTag, TagKey<Item> nuggetTag, ItemLike ingot, ItemLike nugget, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9).requires(Ingredient.of(ingotTag)).unlockedBy("has_ingot", has(ingotTag)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 1).requires(Ingredient.of(nuggetTag), 9).unlockedBy("has_ingot", has(ingotTag)).save(consumer, new ResourceLocation(Constants.MOD_ID, getKeyPath(ingot.asItem()) + "_nuggets"));
    }

    public String getKeyPath(Item i) {
        return ForgeRegistries.ITEMS.getKey(i).getPath();
    }
}
