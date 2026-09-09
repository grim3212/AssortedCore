package com.grim3212.assorted.core.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.api.crafting.MachineIngredient;
import com.grim3212.assorted.core.api.crafting.builders.AlloyForgeRecipeBuilder;
import com.grim3212.assorted.core.api.crafting.builders.GrindingMillRecipeBuilder;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.lib.core.conditions.ConditionalRecipeProvider;
import com.grim3212.assorted.lib.platform.Services;
import com.grim3212.assorted.lib.util.LibCommonTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class CoreRecipes extends ConditionalRecipeProvider {

    private final HolderGetter<Item> items;

    public CoreRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output, Constants.MOD_ID);
        this.items = registries.lookupOrThrow(Registries.ITEM);
    }

    @Override
    public void registerConditions() {
    }

    @Override
    public void buildRecipes() {
        super.buildRecipes();

        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_TIN, CoreTags.Items.INGOTS_TIN, CoreTags.Items.NUGGETS_TIN, CoreBlocks.TIN_BLOCK.get(), CoreItems.TIN_INGOT.get(), CoreItems.TIN_NUGGET.get());
        ingotNugget(CoreTags.Items.INGOTS_COPPER, CoreTags.Items.NUGGETS_COPPER, Items.COPPER_INGOT, CoreItems.COPPER_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_SILVER, CoreTags.Items.INGOTS_SILVER, CoreTags.Items.NUGGETS_SILVER, CoreBlocks.SILVER_BLOCK.get(), CoreItems.SILVER_INGOT.get(), CoreItems.SILVER_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.INGOTS_ALUMINUM, CoreTags.Items.NUGGETS_ALUMINUM, CoreBlocks.ALUMINUM_BLOCK.get(), CoreItems.ALUMINUM_INGOT.get(), CoreItems.ALUMINUM_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_NICKEL, CoreTags.Items.INGOTS_NICKEL, CoreTags.Items.NUGGETS_NICKEL, CoreBlocks.NICKEL_BLOCK.get(), CoreItems.NICKEL_INGOT.get(), CoreItems.NICKEL_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_PLATINUM, CoreTags.Items.INGOTS_PLATINUM, CoreTags.Items.NUGGETS_PLATINUM, CoreBlocks.PLATINUM_BLOCK.get(), CoreItems.PLATINUM_INGOT.get(), CoreItems.PLATINUM_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_LEAD, CoreTags.Items.INGOTS_LEAD, CoreTags.Items.NUGGETS_LEAD, CoreBlocks.LEAD_BLOCK.get(), CoreItems.LEAD_INGOT.get(), CoreItems.LEAD_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_BRONZE, CoreTags.Items.INGOTS_BRONZE, CoreTags.Items.NUGGETS_BRONZE, CoreBlocks.BRONZE_BLOCK.get(), CoreItems.BRONZE_INGOT.get(), CoreItems.BRONZE_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_ELECTRUM, CoreTags.Items.INGOTS_ELECTRUM, CoreTags.Items.NUGGETS_ELECTRUM, CoreBlocks.ELECTRUM_BLOCK.get(), CoreItems.ELECTRUM_INGOT.get(), CoreItems.ELECTRUM_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_INVAR, CoreTags.Items.INGOTS_INVAR, CoreTags.Items.NUGGETS_INVAR, CoreBlocks.INVAR_BLOCK.get(), CoreItems.INVAR_INGOT.get(), CoreItems.INVAR_NUGGET.get());
        storageIngotNugget(CoreTags.Items.STORAGE_BLOCKS_STEEL, CoreTags.Items.INGOTS_STEEL, CoreTags.Items.NUGGETS_STEEL, CoreBlocks.STEEL_BLOCK.get(), CoreItems.STEEL_INGOT.get(), CoreItems.STEEL_NUGGET.get());

        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM, CoreTags.Items.RAW_MATERIALS_ALUMINUM, CoreBlocks.RAW_ALUMINUM_BLOCK.get(), CoreItems.RAW_ALUMINUM.get());
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD, CoreTags.Items.RAW_MATERIALS_LEAD, CoreBlocks.RAW_LEAD_BLOCK.get(), CoreItems.RAW_LEAD.get());
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL, CoreTags.Items.RAW_MATERIALS_NICKEL, CoreBlocks.RAW_NICKEL_BLOCK.get(), CoreItems.RAW_NICKEL.get());
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM, CoreTags.Items.RAW_MATERIALS_PLATINUM, CoreBlocks.RAW_PLATINUM_BLOCK.get(), CoreItems.RAW_PLATINUM.get());
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER, CoreTags.Items.RAW_MATERIALS_SILVER, CoreBlocks.RAW_SILVER_BLOCK.get(), CoreItems.RAW_SILVER.get());
        storage(CoreTags.Items.RAW_STORAGE_BLOCKS_TIN, CoreTags.Items.RAW_MATERIALS_TIN, CoreBlocks.RAW_TIN_BLOCK.get(), CoreItems.RAW_TIN.get());

        gemStorage(CoreTags.Items.STORAGE_BLOCKS_RUBY, CoreTags.Items.GEMS_RUBY, CoreBlocks.RUBY_BLOCK.get(), CoreItems.RUBY.get());
        gemStorage(CoreTags.Items.STORAGE_BLOCKS_PERIDOT, CoreTags.Items.GEMS_PERIDOT, CoreBlocks.PERIDOT_BLOCK.get(), CoreItems.PERIDOT.get());
        gemStorage(CoreTags.Items.STORAGE_BLOCKS_SAPPHIRE, CoreTags.Items.GEMS_SAPPHIRE, CoreBlocks.SAPPHIRE_BLOCK.get(), CoreItems.SAPPHIRE.get());
        gemStorage(CoreTags.Items.STORAGE_BLOCKS_TOPAZ, CoreTags.Items.GEMS_TOPAZ, CoreBlocks.TOPAZ_BLOCK.get(), CoreItems.TOPAZ.get());

        blastingSmelting(CoreTags.Items.ORES_TIN, CoreItems.TIN_INGOT.get(), 0.5f);
        blastingSmelting(CoreTags.Items.ORES_SILVER, CoreItems.SILVER_INGOT.get(), 1.0f);
        blastingSmelting(CoreTags.Items.ORES_ALUMINUM, CoreItems.ALUMINUM_INGOT.get(), 0.7f);
        blastingSmelting(CoreTags.Items.ORES_NICKEL, CoreItems.NICKEL_INGOT.get(), 0.7f);
        blastingSmelting(CoreTags.Items.ORES_PLATINUM, CoreItems.PLATINUM_INGOT.get(), 1.5f);
        blastingSmelting(CoreTags.Items.ORES_LEAD, CoreItems.LEAD_INGOT.get(), 1.0f);
        blastingSmelting(CoreTags.Items.ORES_RUBY, CoreItems.RUBY.get(), 1.0f);
        blastingSmelting(CoreTags.Items.ORES_PERIDOT, CoreItems.PERIDOT.get(), 1.0f);
        blastingSmelting(CoreTags.Items.ORES_SAPPHIRE, CoreItems.SAPPHIRE.get(), 1.0f);
        blastingSmelting(CoreTags.Items.ORES_TOPAZ, CoreItems.TOPAZ.get(), 1.0f);

        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_TIN, CoreItems.TIN_INGOT.get(), 0.5f);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_SILVER, CoreItems.SILVER_INGOT.get(), 1.0f);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_ALUMINUM, CoreItems.ALUMINUM_INGOT.get(), 0.7f);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_NICKEL, CoreItems.NICKEL_INGOT.get(), 0.7f);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_PLATINUM, CoreItems.PLATINUM_INGOT.get(), 1.5f);
        rawOreBlastingSmelting(CoreTags.Items.RAW_MATERIALS_LEAD, CoreItems.LEAD_INGOT.get(), 1.0f);

        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_TIN, CoreBlocks.TIN_BLOCK.get(), 1.0f);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_SILVER, CoreBlocks.SILVER_BLOCK.get(), 2.0f);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_ALUMINUM, CoreBlocks.ALUMINUM_BLOCK.get(), 1.4f);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_NICKEL, CoreBlocks.NICKEL_BLOCK.get(), 1.4f);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_PLATINUM, CoreBlocks.PLATINUM_BLOCK.get(), 3.0f);
        rawStorageBlastingSmelting(CoreTags.Items.RAW_STORAGE_BLOCKS_LEAD, CoreBlocks.LEAD_BLOCK.get(), 1.0f);

        ingotDust(CoreTags.Items.DUSTS_TIN, CoreItems.TIN_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_COPPER, Items.COPPER_INGOT);
        ingotDust(CoreTags.Items.DUSTS_SILVER, CoreItems.SILVER_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_ALUMINUM, CoreItems.ALUMINUM_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_NICKEL, CoreItems.NICKEL_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_PLATINUM, CoreItems.PLATINUM_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_LEAD, CoreItems.LEAD_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_BRONZE, CoreItems.BRONZE_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_ELECTRUM, CoreItems.ELECTRUM_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_INVAR, CoreItems.INVAR_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_STEEL, CoreItems.STEEL_INGOT.get());
        ingotDust(CoreTags.Items.DUSTS_IRON, Items.IRON_INGOT);
        ingotDust(CoreTags.Items.DUSTS_GOLD, Items.GOLD_INGOT);

        gear(CoreTags.Items.INGOTS_TIN, CoreItems.TIN_GEAR.get());
        gear(CoreTags.Items.INGOTS_COPPER, CoreItems.COPPER_GEAR.get());
        gear(CoreTags.Items.INGOTS_SILVER, CoreItems.SILVER_GEAR.get());
        gear(CoreTags.Items.INGOTS_ALUMINUM, CoreItems.ALUMINUM_GEAR.get());
        gear(CoreTags.Items.INGOTS_NICKEL, CoreItems.NICKEL_GEAR.get());
        gear(CoreTags.Items.INGOTS_PLATINUM, CoreItems.PLATINUM_GEAR.get());
        gear(CoreTags.Items.INGOTS_LEAD, CoreItems.LEAD_GEAR.get());
        gear(CoreTags.Items.INGOTS_BRONZE, CoreItems.BRONZE_GEAR.get());
        gear(CoreTags.Items.INGOTS_ELECTRUM, CoreItems.ELECTRUM_GEAR.get());
        gear(CoreTags.Items.INGOTS_INVAR, CoreItems.INVAR_GEAR.get());
        gear(CoreTags.Items.INGOTS_STEEL, CoreItems.STEEL_GEAR.get());
        gear(LibCommonTags.Items.INGOTS_IRON, CoreItems.IRON_GEAR.get());
        gear(LibCommonTags.Items.INGOTS_GOLD, CoreItems.GOLD_GEAR.get());

        alloy(ItemTags.COALS, 4, CoreTags.Items.DUSTS_IRON, 1, new ItemStackTemplate(CoreItems.STEEL_INGOT.get(), 1), 0.5F, 800);
        alloy(CoreTags.Items.DUSTS_COPPER, 3, CoreTags.Items.DUSTS_TIN, 1, new ItemStackTemplate(CoreItems.BRONZE_INGOT.get(), 4), 0.5F);
        alloy(CoreTags.Items.DUSTS_IRON, 2, CoreTags.Items.DUSTS_NICKEL, 1, new ItemStackTemplate(CoreItems.INVAR_INGOT.get(), 3), 0.7F, 500);
        alloy(CoreTags.Items.DUSTS_SILVER, CoreTags.Items.DUSTS_GOLD, new ItemStackTemplate(CoreItems.ELECTRUM_INGOT.get(), 2), 0.7F);

        grinding(CoreTags.Items.ORES_TIN, new ItemStackTemplate(CoreItems.TIN_DUST.get(), 2), 0.2F, 600);
        grinding(CoreTags.Items.ORES_COPPER, new ItemStackTemplate(CoreItems.COPPER_DUST.get(), 2), 0.2F, 600);
        grinding(CoreTags.Items.ORES_SILVER, new ItemStackTemplate(CoreItems.SILVER_DUST.get(), 2), 0.4F, 600);
        grinding(CoreTags.Items.ORES_ALUMINUM, new ItemStackTemplate(CoreItems.ALUMINUM_DUST.get(), 2), 0.2F, 600);
        grinding(CoreTags.Items.ORES_NICKEL, new ItemStackTemplate(CoreItems.NICKEL_DUST.get(), 2), 0.2F, 600);
        grinding(CoreTags.Items.ORES_PLATINUM, new ItemStackTemplate(CoreItems.PLATINUM_DUST.get(), 2), 0.5F, 600);
        grinding(CoreTags.Items.ORES_LEAD, new ItemStackTemplate(CoreItems.LEAD_DUST.get(), 2), 0.2F, 600);
        grinding(CoreTags.Items.ORES_RUBY, new ItemStackTemplate(CoreItems.RUBY.get(), 2), 0.3F, 600);
        grinding(CoreTags.Items.ORES_PERIDOT, new ItemStackTemplate(CoreItems.PERIDOT.get(), 2), 0.3F, 600);
        grinding(CoreTags.Items.ORES_SAPPHIRE, new ItemStackTemplate(CoreItems.SAPPHIRE.get(), 2), 0.3F, 600);
        grinding(CoreTags.Items.ORES_TOPAZ, new ItemStackTemplate(CoreItems.TOPAZ.get(), 2), 0.3F, 600);

        grinding(LibCommonTags.Items.ORES_GOLD, new ItemStackTemplate(CoreItems.GOLD_DUST.get(), 2), 0.2F, 600);
        grinding(LibCommonTags.Items.ORES_IRON, new ItemStackTemplate(CoreItems.IRON_DUST.get(), 2), 0.2F, 600);
        grinding(LibCommonTags.Items.ORES_DIAMOND, new ItemStackTemplate(Items.DIAMOND, 2), 0.3F, 600);
        grinding(LibCommonTags.Items.ORES_EMERALD, new ItemStackTemplate(Items.EMERALD, 2), 0.3F, 600);
        grinding(LibCommonTags.Items.ORES_COAL, new ItemStackTemplate(Items.COAL, 3), 0.1F, 600);
        grinding(LibCommonTags.Items.ORES_REDSTONE, new ItemStackTemplate(Items.REDSTONE, 5), 0.2F, 600);
        grinding(LibCommonTags.Items.ORES_LAPIS, new ItemStackTemplate(Items.LAPIS_LAZULI, 5), 0.2F, 600);
        grinding(LibCommonTags.Items.ORES_QUARTZ, new ItemStackTemplate(Items.QUARTZ, 2), 0.2F, 600);

        grindingDustFromIngot(LibCommonTags.Items.INGOTS_GOLD, new ItemStackTemplate(CoreItems.GOLD_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(LibCommonTags.Items.INGOTS_IRON, new ItemStackTemplate(CoreItems.IRON_DUST.get(), 1), 0.0F, 300);

        grindingDustFromIngot(CoreTags.Items.INGOTS_TIN, new ItemStackTemplate(CoreItems.TIN_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_COPPER, new ItemStackTemplate(CoreItems.COPPER_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_SILVER, new ItemStackTemplate(CoreItems.SILVER_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_ALUMINUM, new ItemStackTemplate(CoreItems.ALUMINUM_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_NICKEL, new ItemStackTemplate(CoreItems.NICKEL_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_PLATINUM, new ItemStackTemplate(CoreItems.PLATINUM_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_LEAD, new ItemStackTemplate(CoreItems.LEAD_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_BRONZE, new ItemStackTemplate(CoreItems.BRONZE_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_ELECTRUM, new ItemStackTemplate(CoreItems.ELECTRUM_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_STEEL, new ItemStackTemplate(CoreItems.STEEL_DUST.get(), 1), 0.0F, 300);
        grindingDustFromIngot(CoreTags.Items.INGOTS_INVAR, new ItemStackTemplate(CoreItems.INVAR_DUST.get(), 1), 0.0F, 300);

        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_GOLD, new ItemStackTemplate(CoreItems.GOLD_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_IRON, new ItemStackTemplate(CoreItems.IRON_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_TIN, new ItemStackTemplate(CoreItems.TIN_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_COPPER, new ItemStackTemplate(CoreItems.COPPER_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_SILVER, new ItemStackTemplate(CoreItems.SILVER_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_ALUMINUM, new ItemStackTemplate(CoreItems.ALUMINUM_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_NICKEL, new ItemStackTemplate(CoreItems.NICKEL_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_PLATINUM, new ItemStackTemplate(CoreItems.PLATINUM_DUST.get(), 2), 0.0F, 300);
        grindingDustFromRawOre(CoreTags.Items.RAW_MATERIALS_LEAD, new ItemStackTemplate(CoreItems.LEAD_DUST.get(), 2), 0.0F, 300);

        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.MACHINE_CORE.get()).define('A', CoreTags.Items.INGOTS_ALUMINUM).define('C', CoreTags.Items.GEARS_COPPER).define('I', LibCommonTags.Items.INGOTS_IRON).pattern("IAI").pattern("ACA").pattern("IAI").unlockedBy("has_iron", has(LibCommonTags.Items.INGOTS_IRON)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.BASIC_ALLOY_FORGE.get()).define('X', CoreBlocks.MACHINE_CORE.get()).define('B', Blocks.BLAST_FURNACE).define('I', LibCommonTags.Items.INGOTS_IRON).pattern("III").pattern("BXB").pattern("III").unlockedBy("has_iron", has(LibCommonTags.Items.INGOTS_IRON)).unlockedBy("has_blast_furnace", has(Blocks.BLAST_FURNACE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()).define('X', CoreBlocks.BASIC_ALLOY_FORGE.get()).define('S', CoreTags.Items.INGOTS_STEEL).pattern("SSS").pattern("SXS").pattern("SSS").unlockedBy("has_steel", has(CoreTags.Items.INGOTS_STEEL)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.ADVANCED_ALLOY_FORGE.get()).define('X', CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()).define('E', CoreTags.Items.INGOTS_ELECTRUM).define('V', CoreTags.Items.INGOTS_INVAR).pattern("VEV").pattern("EXE").pattern("VEV").unlockedBy("has_electrum", has(CoreTags.Items.INGOTS_ELECTRUM)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.EXPERT_ALLOY_FORGE.get()).define('X', CoreBlocks.ADVANCED_ALLOY_FORGE.get()).define('P', CoreTags.Items.INGOTS_PLATINUM).pattern(" P ").pattern("PXP").pattern(" P ").unlockedBy("has_platinum", has(CoreTags.Items.INGOTS_PLATINUM)).save(this.output);

        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.BASIC_GRINDING_MILL.get()).define('X', CoreBlocks.MACHINE_CORE.get()).define('F', Blocks.FURNACE).define('I', LibCommonTags.Items.INGOTS_IRON).define('P', Items.IRON_PICKAXE).define('G', CoreTags.Items.GEARS_IRON).pattern("IPI").pattern("GXG").pattern("IFI").unlockedBy("has_iron_pickaxe", has(Items.IRON_PICKAXE)).unlockedBy("has_furnace", has(Blocks.FURNACE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()).define('X', CoreBlocks.BASIC_GRINDING_MILL.get()).define('S', CoreTags.Items.INGOTS_STEEL).pattern("SSS").pattern("SXS").pattern("SSS").unlockedBy("has_steel", has(CoreTags.Items.INGOTS_STEEL)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.ADVANCED_GRINDING_MILL.get()).define('X', CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()).define('E', CoreTags.Items.INGOTS_ELECTRUM).define('V', CoreTags.Items.INGOTS_INVAR).pattern("VEV").pattern("EXE").pattern("VEV").unlockedBy("has_electrum", has(CoreTags.Items.INGOTS_ELECTRUM)).save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, CoreBlocks.EXPERT_GRINDING_MILL.get()).define('X', CoreBlocks.ADVANCED_GRINDING_MILL.get()).define('P', CoreTags.Items.INGOTS_PLATINUM).pattern(" P ").pattern("PXP").pattern(" P ").unlockedBy("has_platinum", has(CoreTags.Items.INGOTS_PLATINUM)).save(this.output);
    }

    private void alloy(TagKey<Item> ingredient1, int ingredient1Count, TagKey<Item> ingredient2, int ingredient2Count, ItemStackTemplate result, float experience) {
        alloy(ingredient1, ingredient1Count, ingredient2, ingredient2Count, result, experience, 400);
    }

    private void alloy(TagKey<Item> ingredient1, TagKey<Item> ingredient2, ItemStackTemplate result, float experience) {
        alloy(ingredient1, ingredient2, result, experience, 400);
    }

    private void alloy(TagKey<Item> ingredient1, TagKey<Item> ingredient2, ItemStackTemplate result, float experience, int cookTime) {
        alloy(ingredient1, 1, ingredient2, 1, result, experience, cookTime);
    }

    private void alloy(TagKey<Item> ingredient1, int ingredient1Count, TagKey<Item> ingredient2, int ingredient2Count, ItemStackTemplate result, float experience, int cookTime) {
        AlloyForgeRecipeBuilder.recipe(new MachineIngredient(this.tag(ingredient1), ingredient1Count), new MachineIngredient(this.tag(ingredient2), ingredient2Count), result, experience, cookTime).unlockedBy("has_ingredient1", has(ingredient1)).unlockedBy("has_ingredient2", has(ingredient2)).save(this.output);
    }

    private void grindingDustFromRawOre(TagKey<Item> ingredient, ItemStackTemplate result, float experience, int cookTime) {
        grinding(ingredient, result, experience, cookTime, "_from_raw_ore");
    }

    private void grindingDustFromIngot(TagKey<Item> ingredient, ItemStackTemplate result, float experience, int cookTime) {
        grinding(ingredient, result, experience, cookTime, "_from_ingot");
    }

    private void grinding(TagKey<Item> ingredient, ItemStackTemplate result, float experience, int cookTime) {
        grinding(ingredient, result, experience, cookTime, "");
    }

    private void grinding(TagKey<Item> ingredient, ItemStackTemplate result, float experience, int cookTime, String name) {
        GrindingMillRecipeBuilder.recipe(new MachineIngredient(this.tag(ingredient)), result, experience, cookTime).unlockedBy("has_ingredient", has(ingredient)).save(this.output, key(getKeyPath(result.item().value()) + name));
    }

    private void gear(TagKey<Item> material, ItemLike gear) {
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, gear).define('M', material).define('S', LibCommonTags.Items.RODS_WOODEN).pattern(" M ").pattern("MSM").pattern(" M ").unlockedBy("has_material", has(material)).save(this.output);
    }

    private void ingotDust(TagKey<Item> dust, ItemLike ingot) {
        SimpleCookingRecipeBuilder.blasting(this.tag(dust), RecipeCategory.MISC, CookingBookCategory.MISC, ingot, 0.1F, 100).unlockedBy("has_dust", has(dust)).save(this.output, key(dust.location().getPath() + "_blasting"));
        SimpleCookingRecipeBuilder.smelting(this.tag(dust), RecipeCategory.MISC, CookingBookCategory.MISC, ingot, 0.1F, 200).unlockedBy("has_dust", has(dust)).save(this.output, key(dust.location().getPath() + "_smelting"));
    }

    private void rawStorageBlastingSmelting(TagKey<Item> rawStorage, ItemLike result, float experience) {
        SimpleCookingRecipeBuilder.blasting(this.tag(rawStorage), RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 100).unlockedBy("has_storage", has(rawStorage)).save(this.output, key(getKeyPath(result.asItem()) + "_blasting_raw_storage"));
        SimpleCookingRecipeBuilder.smelting(this.tag(rawStorage), RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 200).unlockedBy("has_storage", has(rawStorage)).save(this.output, key(getKeyPath(result.asItem()) + "_smelting_raw_storage"));
    }

    private void rawOreBlastingSmelting(TagKey<Item> ore, ItemLike result, float experience) {
        SimpleCookingRecipeBuilder.blasting(this.tag(ore), RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 100).unlockedBy("has_ore", has(ore)).save(this.output, key(getKeyPath(result.asItem()) + "_blasting_raw_ore"));
        SimpleCookingRecipeBuilder.smelting(this.tag(ore), RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 200).unlockedBy("has_ore", has(ore)).save(this.output, key(getKeyPath(result.asItem()) + "_smelting_raw_ore"));
    }

    private void blastingSmelting(TagKey<Item> ore, ItemLike result, float experience) {
        SimpleCookingRecipeBuilder.blasting(this.tag(ore), RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 100).unlockedBy("has_ore", has(ore)).save(this.output, key(getKeyPath(result.asItem()) + "_blasting"));
        SimpleCookingRecipeBuilder.smelting(this.tag(ore), RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 200).unlockedBy("has_ore", has(ore)).save(this.output, key(getKeyPath(result.asItem()) + "_smelting"));
    }

    private void gemStorage(TagKey<Item> storageBlockTag, TagKey<Item> gemTag, ItemLike storageBlock, ItemLike gem) {
        ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, gem, 9).requires(this.tag(storageBlockTag)).unlockedBy("has_gem", has(storageBlockTag)).save(this.output, key(getKeyPath(gem.asItem()) + "_storage_block"));
        ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, storageBlock, 1).requires(this.tag(gemTag), 9).unlockedBy("has_gem", has(gemTag)).save(this.output);
    }

    private void storage(TagKey<Item> storageBlockTag, TagKey<Item> nonStoreTag, ItemLike storageBlock, ItemLike nonStore) {
        ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, nonStore, 9).requires(this.tag(storageBlockTag)).unlockedBy("has_storage_item", has(nonStoreTag)).save(this.output, key(getKeyPath(nonStore.asItem()) + "_storage_block"));
        ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, storageBlock, 1).requires(this.tag(nonStoreTag), 9).unlockedBy("has_storage_item", has(nonStoreTag)).save(this.output);
    }

    private void storageIngotNugget(TagKey<Item> storageBlockTag, TagKey<Item> ingotTag, TagKey<Item> nuggetTag, ItemLike storageBlock, ItemLike ingot, ItemLike nugget) {
        storage(storageBlockTag, ingotTag, storageBlock, ingot);
        ingotNugget(ingotTag, nuggetTag, ingot, nugget);
    }

    private void ingotNugget(TagKey<Item> ingotTag, TagKey<Item> nuggetTag, ItemLike ingot, ItemLike nugget) {
        ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, nugget, 9).requires(this.tag(ingotTag)).unlockedBy("has_ingot", has(ingotTag)).save(this.output);
        ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, ingot, 1).requires(this.tag(nuggetTag), 9).unlockedBy("has_ingot", has(ingotTag)).save(this.output, key(getKeyPath(ingot.asItem()) + "_nuggets"));
    }

    public String getKeyPath(Item i) {
        return Services.PLATFORM.getRegistry(Registries.ITEM).getRegistryName(i).getPath();
    }

    /**
     * Recipe providers are not data providers any more - a {@link RecipeProvider.Runner} owns the
     * file writing and builds a fresh provider around the {@link RecipeOutput} it hands out. This is
     * what the loader datagen entry points register.
     */
    public static class Runner extends ConditionalRecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries, Constants.MOD_ID);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new CoreRecipes(registries, output);
        }

        @Override
        public String getName() {
            return "Recipes: " + Constants.MOD_ID;
        }
    }

    /**
     * Recipes are addressed by {@code ResourceKey<Recipe<?>>} rather than a raw id now.
     */
    private static ResourceKey<Recipe<?>> key(String path) {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(Constants.MOD_ID, path));
    }
}
