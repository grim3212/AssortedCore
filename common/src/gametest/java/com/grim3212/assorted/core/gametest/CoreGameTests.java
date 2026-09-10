package com.grim3212.assorted.core.gametest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.machines.MachineUtil;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.blocks.blockentity.AlloyForgeBlockEntity;
import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import com.grim3212.assorted.core.common.blocks.blockentity.GrindingMillBlockEntity;
import com.grim3212.assorted.core.common.handlers.CoreCreativeItems;
import com.grim3212.assorted.core.common.items.CoreItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Automated in-world checks for AssortedCore.
 * <p>
 * The bodies live in common because the behaviour they check is common; each loader module only
 * registers them into {@code Registries.TEST_FUNCTION} through its own hook, and
 * {@code data/assortedcore/test_instance/*.json} pairs each one with the shared {@code test_box}
 * structure. Every test that runs the game forward uses the EXPERT tier - its 0.25 speed modifier
 * keeps a smelt inside a sane {@code max_ticks}.
 * <p>
 * Manual checks that need a human are in {@code TESTING-CHECKLIST.md}.
 */
public final class CoreGameTests {

    private CoreGameTests() {
    }

    /** Every test in this mod, named once, so both loaders register the same set. */
    public static void forEach(BiConsumer<String, Consumer<GameTestHelper>> out) {
        out.accept("alloy_forge_makes_bronze", CoreGameTests::alloyForgeMakesBronze);
        out.accept("grinding_mill_makes_dust", CoreGameTests::grindingMillMakesDust);
        out.accept("grinding_mill_tool_slot", CoreGameTests::grindingMillToolSlot);
        out.accept("machine_drops_contents", CoreGameTests::machineDropsContents);
        out.accept("hoppers_feed_and_empty_machine", CoreGameTests::hoppersFeedAndEmptyMachine);
        out.accept("ore_drops_raw_metal_and_gem", CoreGameTests::oreDropsRawMetalAndGem);
        out.accept("ore_fortune_multiplies_drops", CoreGameTests::oreFortuneMultipliesDrops);
        out.accept("ore_silk_touch_drops_the_ore", CoreGameTests::oreSilkTouchDropsTheOre);
        out.accept("machine_recipes_craft", CoreGameTests::machineRecipesCraft);
        out.accept("metal_families_round_trip", CoreGameTests::metalFamiliesRoundTrip);
        out.accept("raw_ore_and_dust_smelt_to_ingots", CoreGameTests::rawOreAndDustSmeltToIngots);
        out.accept("machine_tiers_get_faster", CoreGameTests::machineTiersGetFaster);
        out.accept("machine_keeps_contents_across_reload", CoreGameTests::machineKeepsContentsAcrossReload);
        out.accept("every_block_and_item_has_model_and_name", CoreGameTests::everyBlockAndItemHasModelAndName);
    }

    private static final BlockPos MACHINE = new BlockPos(4, 1, 4);

    /** 3 copper dust + 1 tin dust -> 4 bronze ingots. */
    private static void alloyForgeMakesBronze(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.EXPERT_ALLOY_FORGE.get());
        AlloyForgeBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);

        // Through the inventory handler, not getItems(): only the handler sets cookTimeTotal.
        forge.getInventory(null).setStackInSlot(0, new ItemStack(CoreItems.COPPER_DUST.get(), 3));
        forge.getInventory(null).setStackInSlot(1, new ItemStack(CoreItems.TIN_DUST.get(), 1));
        forge.getInventory(null).setStackInSlot(2, new ItemStack(Items.COAL, 8));

        helper.succeedWhen(() -> {
            ItemStack result = forge.getInventory(null).getStackInSlot(3);
            helper.assertTrue(result.is(CoreItems.BRONZE_INGOT.get()), "alloy forge did not produce bronze");
            helper.assertValueEqual(result.getCount(), 4, "bronze ingot count");
        });
    }

    /** A copper ingot plus a pickaxe in the tool slot grinds to copper dust. */
    private static void grindingMillMakesDust(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.EXPERT_GRINDING_MILL.get());
        GrindingMillBlockEntity mill = helper.getBlockEntity(MACHINE, GrindingMillBlockEntity.class);

        mill.getInventory(null).setStackInSlot(0, new ItemStack(Items.COPPER_INGOT, 1));
        mill.getInventory(null).setStackInSlot(1, new ItemStack(Items.IRON_PICKAXE));
        mill.getInventory(null).setStackInSlot(2, new ItemStack(Items.COAL, 8));

        helper.succeedWhen(() -> helper.assertTrue(
                mill.getInventory(null).getStackInSlot(3).is(CoreItems.COPPER_DUST.get()),
                "grinding mill did not produce copper dust"));
    }

    /** The tool slot takes iron and above, and nothing softer. */
    private static void grindingMillToolSlot(GameTestHelper helper) {
        helper.assertTrue(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.IRON_PICKAXE)),
                "iron pickaxe rejected by the grinding mill tool slot");
        helper.assertTrue(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.NETHERITE_PICKAXE)),
                "netherite pickaxe rejected by the grinding mill tool slot");
        helper.assertFalse(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.WOODEN_PICKAXE)),
                "wooden pickaxe accepted by the grinding mill tool slot");
        helper.assertFalse(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.IRON_SWORD)),
                "iron sword accepted by the grinding mill tool slot");
        helper.succeed();
    }

    /** Breaking a machine spills what was inside it - this regressed once already. */
    private static void machineDropsContents(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.BASIC_ALLOY_FORGE.get());
        BaseMachineBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);
        forge.getInventory(null).setStackInSlot(0, new ItemStack(CoreItems.COPPER_DUST.get(), 2));

        helper.destroyBlock(MACHINE);
        helper.succeedWhen(() -> helper.assertItemEntityPresent(CoreItems.COPPER_DUST.get(), MACHINE, 3.0D));
    }

    /**
     * A hopper above pushes an ingredient in, a hopper below pulls the result out. This is the
     * sided inventory bridge - {@code ResourceHandler} on NeoForge, the transfer API on Fabric -
     * and it is the part of the port most likely to differ between the two.
     * <p>
     * Insertion goes to the first slot that accepts the stack, which for every face but DOWN is
     * input 1; only DOWN exposes the output slot, so the hopper below can take the result and
     * nothing else.
     */
    private static void hoppersFeedAndEmptyMachine(GameTestHelper helper) {
        BlockPos above = MACHINE.above();
        BlockPos below = MACHINE.below();

        helper.setBlock(MACHINE, CoreBlocks.BASIC_ALLOY_FORGE.get());
        helper.setBlock(above, Blocks.HOPPER.defaultBlockState().setValue(HopperBlock.FACING, Direction.DOWN));
        helper.setBlock(below, Blocks.HOPPER.defaultBlockState().setValue(HopperBlock.FACING, Direction.DOWN));

        helper.getBlockEntity(above, HopperBlockEntity.class)
                .setItem(0, new ItemStack(CoreItems.COPPER_DUST.get(), 1));

        BaseMachineBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);
        forge.getInventory(null).setStackInSlot(3, new ItemStack(CoreItems.BRONZE_INGOT.get(), 1));

        helper.succeedWhen(() -> {
            helper.assertTrue(forge.getInventory(null).getStackInSlot(0).is(CoreItems.COPPER_DUST.get()),
                    "hopper above did not insert into the machine");
            helper.assertContainerContains(below, CoreItems.BRONZE_INGOT.get());
        });
    }

    // ------------------------------------------------------------------------------------------
    // Wave two: ore drops, the recipe tree, tier speed, persistence and assets. These lean on two
    // things that turn out to work headlessly - ServerLevel#recipeAccess resolves real recipes, and
    // the mod's own assets are on the classpath - which is what makes these checklist lines
    // automatable at all.
    // ------------------------------------------------------------------------------------------

    /** An ore, and the item it drops when it is mined without Silk Touch. */
    private record OreDrop(Block ore, Item drop) {
    }

    /** Every ore this mod adds, stone and deepslate, metal and gem. */
    private static List<OreDrop> ores() {
        return List.of(
                new OreDrop(CoreBlocks.TIN_ORE.get(), CoreItems.RAW_TIN.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_TIN_ORE.get(), CoreItems.RAW_TIN.get()),
                new OreDrop(CoreBlocks.SILVER_ORE.get(), CoreItems.RAW_SILVER.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_SILVER_ORE.get(), CoreItems.RAW_SILVER.get()),
                new OreDrop(CoreBlocks.ALUMINUM_ORE.get(), CoreItems.RAW_ALUMINUM.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get(), CoreItems.RAW_ALUMINUM.get()),
                new OreDrop(CoreBlocks.NICKEL_ORE.get(), CoreItems.RAW_NICKEL.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_NICKEL_ORE.get(), CoreItems.RAW_NICKEL.get()),
                new OreDrop(CoreBlocks.PLATINUM_ORE.get(), CoreItems.RAW_PLATINUM.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get(), CoreItems.RAW_PLATINUM.get()),
                new OreDrop(CoreBlocks.LEAD_ORE.get(), CoreItems.RAW_LEAD.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_LEAD_ORE.get(), CoreItems.RAW_LEAD.get()),
                new OreDrop(CoreBlocks.RUBY_ORE.get(), CoreItems.RUBY.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_RUBY_ORE.get(), CoreItems.RUBY.get()),
                new OreDrop(CoreBlocks.PERIDOT_ORE.get(), CoreItems.PERIDOT.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get(), CoreItems.PERIDOT.get()),
                new OreDrop(CoreBlocks.SAPPHIRE_ORE.get(), CoreItems.SAPPHIRE.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), CoreItems.SAPPHIRE.get()),
                new OreDrop(CoreBlocks.TOPAZ_ORE.get(), CoreItems.TOPAZ.get()),
                new OreDrop(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get(), CoreItems.TOPAZ.get()));
    }

    /** The metals that own a full ingot / nugget / dust / gear / storage block family. */
    private static final List<String> METALS = List.of(
            "tin", "silver", "aluminum", "nickel", "platinum", "lead", "bronze", "electrum", "invar", "steel");

    private static final BlockPos ORE_A = new BlockPos(2, 1, 6);
    private static final BlockPos ORE_B = new BlockPos(6, 1, 2);

    private static Holder<Enchantment> enchantment(GameTestHelper helper, ResourceKey<Enchantment> key) {
        return helper.getLevel().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(key);
    }

    /**
     * Rolls a block's own loot table against a fixed random source, so a Fortune roll is
     * reproducible rather than a coin flip. The BLOCK parameter set wants BLOCK_STATE, ORIGIN and
     * TOOL; the tool is what both {@code match_tool} (Silk Touch) and {@code apply_bonus} (Fortune)
     * read.
     */
    private static List<ItemStack> rollDrops(GameTestHelper helper, Block block, ItemStack tool, long seed) {
        ResourceKey<LootTable> key = block.getLootTable().orElse(null);
        helper.assertTrue(key != null, BuiltInRegistries.BLOCK.getKey(block) + " has no loot table");

        LootTable table = helper.getLevel().getServer().reloadableRegistries().getLootTable(key);
        helper.assertFalse(table == LootTable.EMPTY, "loot table " + key.identifier() + " does not exist");

        LootParams params = new LootParams.Builder(helper.getLevel())
                .withParameter(LootContextParams.BLOCK_STATE, block.defaultBlockState())
                .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(helper.absolutePos(MACHINE)))
                .withParameter(LootContextParams.TOOL, tool)
                .create(LootContextParamSets.BLOCK);

        return table.getRandomItems(params, RandomSource.create(seed));
    }

    /** Every ore drops its raw metal or its gem, one per block, for a plain pickaxe. */
    private static void oreDropsRawMetalAndGem(GameTestHelper helper) {
        ItemStack pickaxe = new ItemStack(Items.IRON_PICKAXE);

        for (OreDrop ore : ores()) {
            String name = String.valueOf(BuiltInRegistries.BLOCK.getKey(ore.ore()));
            List<ItemStack> drops = rollDrops(helper, ore.ore(), pickaxe, 7L);
            helper.assertValueEqual(drops.size(), 1, name + " drop count");
            helper.assertTrue(drops.get(0).is(ore.drop()), name + " dropped " + drops.get(0) + " instead of " + ore.drop());
            helper.assertValueEqual(drops.get(0).getCount(), 1, name + " drop stack size");
        }

        // And once for real, because a correct loot table still drops nothing if the block is not
        // wired to it. GameTestHelper#destroyBlock passes dropBlock = false, so break it on the
        // level instead.
        helper.setBlock(ORE_A, CoreBlocks.TIN_ORE.get());
        helper.setBlock(ORE_B, CoreBlocks.RUBY_ORE.get());
        helper.getLevel().destroyBlock(helper.absolutePos(ORE_A), true);
        helper.getLevel().destroyBlock(helper.absolutePos(ORE_B), true);

        helper.succeedWhen(() -> {
            helper.assertItemEntityPresent(CoreItems.RAW_TIN.get(), ORE_A, 2.0D);
            helper.assertItemEntityPresent(CoreItems.RUBY.get(), ORE_B, 2.0D);
        });
    }

    /**
     * Fortune multiplies every ore's drop. {@code ore_drops} is a random multiplier, so this rolls
     * a fixed set of seeds and asserts the spread instead: never zero, and more than one somewhere.
     * The same seeds are used for every ore, so this either holds for all of them or for none.
     */
    private static void oreFortuneMultipliesDrops(GameTestHelper helper) {
        ItemStack pickaxe = new ItemStack(Items.IRON_PICKAXE);
        pickaxe.enchant(enchantment(helper, Enchantments.FORTUNE), 3);

        for (OreDrop ore : ores()) {
            String name = String.valueOf(BuiltInRegistries.BLOCK.getKey(ore.ore()));
            int min = Integer.MAX_VALUE;
            int max = 0;

            for (long seed = 0L; seed < 32L; seed++) {
                List<ItemStack> drops = rollDrops(helper, ore.ore(), pickaxe, seed);
                helper.assertValueEqual(drops.size(), 1, name + " Fortune drop count");
                helper.assertTrue(drops.get(0).is(ore.drop()), name + " Fortune changed what it drops");
                min = Math.min(min, drops.get(0).getCount());
                max = Math.max(max, drops.get(0).getCount());
            }

            helper.assertTrue(min >= 1, name + " with Fortune dropped nothing on some rolls");
            helper.assertTrue(max > 1, name + " with Fortune never dropped more than one");
        }

        helper.succeed();
    }

    /** Silk Touch drops the ore block itself, not what is inside it. */
    private static void oreSilkTouchDropsTheOre(GameTestHelper helper) {
        ItemStack pickaxe = new ItemStack(Items.IRON_PICKAXE);
        pickaxe.enchant(enchantment(helper, Enchantments.SILK_TOUCH), 1);

        for (OreDrop ore : ores()) {
            String name = String.valueOf(BuiltInRegistries.BLOCK.getKey(ore.ore()));
            List<ItemStack> drops = rollDrops(helper, ore.ore(), pickaxe, 7L);
            helper.assertValueEqual(drops.size(), 1, name + " Silk Touch drop count");
            helper.assertTrue(drops.get(0).is(ore.ore().asItem()), name + " Silk Touch dropped " + drops.get(0) + " instead of the ore");
            helper.assertValueEqual(drops.get(0).getCount(), 1, name + " Silk Touch drop stack size");
        }

        helper.succeed();
    }

    /** A ring of eight around a centre - the machine core and two of the three tier upgrades. */
    private static List<ItemStack> ring(ItemStack corner, ItemStack edge, ItemStack centre) {
        return List.of(corner, edge, corner, edge, centre, edge, corner, edge, corner);
    }

    /** A plus of four around a centre - the expert upgrade and every gear. */
    private static List<ItemStack> cross(ItemStack arm, ItemStack centre) {
        return List.of(ItemStack.EMPTY, arm, ItemStack.EMPTY, arm, centre, arm, ItemStack.EMPTY, arm, ItemStack.EMPTY);
    }

    /** {@code CraftingInput.of} wants exactly width * height stacks, so the size is passed in. */
    private static void assertCrafts(GameTestHelper helper, int width, int height, List<ItemStack> grid, Item expected, int count, String what) {
        CraftingInput input = CraftingInput.of(width, height, grid);
        var found = helper.getLevel().recipeAccess().getRecipeFor(RecipeType.CRAFTING, input, helper.getLevel());
        helper.assertTrue(found.isPresent(), "no crafting recipe matched for " + what);

        // assemble takes only the input in 26.2; the registries argument is gone.
        ItemStack result = found.get().value().assemble(input);
        helper.assertTrue(result.is(expected), what + " crafted " + result + " instead of " + expected);
        helper.assertValueEqual(result.getCount(), count, what + " result count");
    }

    private static <T extends AbstractCookingRecipe> void assertCooks(GameTestHelper helper, RecipeType<T> type, Item input, Item expected, String what) {
        SingleRecipeInput recipeInput = new SingleRecipeInput(new ItemStack(input));
        var found = helper.getLevel().recipeAccess().getRecipeFor(type, recipeInput, helper.getLevel());
        helper.assertTrue(found.isPresent(), "no " + what + " recipe for " + BuiltInRegistries.ITEM.getKey(input));

        ItemStack result = found.get().value().assemble(recipeInput);
        helper.assertTrue(result.is(expected), what + " " + BuiltInRegistries.ITEM.getKey(input) + " gave " + result + " instead of " + expected);
    }

    private static Item item(GameTestHelper helper, String name) {
        Item found = BuiltInRegistries.ITEM.getOptional(Identifier.fromNamespaceAndPath(Constants.MOD_ID, name)).orElse(null);
        helper.assertTrue(found != null, "nothing registered as " + Constants.MOD_ID + ":" + name);
        return found;
    }

    /**
     * The machine core, then all four grinding mills and all four alloy forges. The three tier
     * upgrades share their shape between the two machine lines, so they are driven off the block
     * list rather than written out six times.
     */
    private static void machineRecipesCraft(GameTestHelper helper) {
        ItemStack iron = new ItemStack(Items.IRON_INGOT);
        ItemStack ironGear = new ItemStack(CoreItems.IRON_GEAR.get());
        ItemStack aluminum = new ItemStack(CoreItems.ALUMINUM_INGOT.get());
        ItemStack steel = new ItemStack(CoreItems.STEEL_INGOT.get());
        ItemStack invar = new ItemStack(CoreItems.INVAR_INGOT.get());
        ItemStack electrum = new ItemStack(CoreItems.ELECTRUM_INGOT.get());
        ItemStack platinum = new ItemStack(CoreItems.PLATINUM_INGOT.get());

        assertCrafts(helper, 3, 3, ring(iron, aluminum, new ItemStack(CoreItems.COPPER_GEAR.get())),
                CoreBlocks.MACHINE_CORE.get().asItem(), 1, "machine core");

        ItemStack core = new ItemStack(CoreBlocks.MACHINE_CORE.get());
        assertCrafts(helper, 3, 3, List.of(iron, new ItemStack(Items.IRON_PICKAXE), iron,
                        ironGear, core, ironGear,
                        iron, new ItemStack(Items.FURNACE), iron),
                CoreBlocks.BASIC_GRINDING_MILL.get().asItem(), 1, "basic grinding mill");
        assertCrafts(helper, 3, 3, List.of(iron, iron, iron,
                        new ItemStack(Items.BLAST_FURNACE), core, new ItemStack(Items.BLAST_FURNACE),
                        iron, iron, iron),
                CoreBlocks.BASIC_ALLOY_FORGE.get().asItem(), 1, "basic alloy forge");

        Block[][] lines = {
                {CoreBlocks.BASIC_GRINDING_MILL.get(), CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(),
                        CoreBlocks.ADVANCED_GRINDING_MILL.get(), CoreBlocks.EXPERT_GRINDING_MILL.get()},
                {CoreBlocks.BASIC_ALLOY_FORGE.get(), CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(),
                        CoreBlocks.ADVANCED_ALLOY_FORGE.get(), CoreBlocks.EXPERT_ALLOY_FORGE.get()}};

        for (Block[] line : lines) {
            assertCrafts(helper, 3, 3, ring(steel, steel, new ItemStack(line[0])), line[1].asItem(), 1,
                    String.valueOf(BuiltInRegistries.BLOCK.getKey(line[1])));
            assertCrafts(helper, 3, 3, ring(invar, electrum, new ItemStack(line[1])), line[2].asItem(), 1,
                    String.valueOf(BuiltInRegistries.BLOCK.getKey(line[2])));
            assertCrafts(helper, 3, 3, cross(platinum, new ItemStack(line[2])), line[3].asItem(), 1,
                    String.valueOf(BuiltInRegistries.BLOCK.getKey(line[3])));
        }

        helper.succeed();
    }

    /**
     * Every metal owns an ingot, a nugget, a dust, a gear and a storage block, and the ingot goes
     * to nuggets and to a block and back again. Driven off the metal names, so a metal added with a
     * part or a recipe missing fails here instead of being spotted by eye.
     */
    private static void metalFamiliesRoundTrip(GameTestHelper helper) {
        for (String metal : METALS) {
            Item ingot = item(helper, metal + "_ingot");
            Item nugget = item(helper, metal + "_nugget");
            Item block = item(helper, metal + "_block");
            Item gear = item(helper, metal + "_gear");
            item(helper, metal + "_dust");

            ItemStack ingotStack = new ItemStack(ingot);
            ItemStack nuggetStack = new ItemStack(nugget);

            assertCrafts(helper, 1, 1, List.of(ingotStack), nugget, 9, metal + " ingot -> nuggets");
            assertCrafts(helper, 3, 3, List.of(nuggetStack, nuggetStack, nuggetStack, nuggetStack, nuggetStack,
                    nuggetStack, nuggetStack, nuggetStack, nuggetStack), ingot, 1, metal + " nuggets -> ingot");
            assertCrafts(helper, 3, 3, List.of(ingotStack, ingotStack, ingotStack, ingotStack, ingotStack,
                    ingotStack, ingotStack, ingotStack, ingotStack), block, 1, metal + " ingots -> block");
            assertCrafts(helper, 1, 1, List.of(new ItemStack(block)), ingot, 9, metal + " block -> ingots");
            assertCrafts(helper, 3, 3, cross(ingotStack, new ItemStack(Items.STICK)), gear, 1, metal + " gear");
        }

        helper.succeed();
    }

    /** Raw ore, the ore block itself and every dust all smelt and blast into an ingot. */
    private static void rawOreAndDustSmeltToIngots(GameTestHelper helper) {
        for (String metal : List.of("tin", "silver", "aluminum", "nickel", "platinum", "lead")) {
            Item ingot = item(helper, metal + "_ingot");
            Item raw = item(helper, "raw_" + metal);
            Item ore = item(helper, metal + "_ore");

            assertCooks(helper, RecipeType.SMELTING, raw, ingot, "smelting");
            assertCooks(helper, RecipeType.BLASTING, raw, ingot, "blasting");
            assertCooks(helper, RecipeType.SMELTING, ore, ingot, "smelting");
            assertCooks(helper, RecipeType.BLASTING, ore, ingot, "blasting");
        }

        for (String metal : METALS) {
            Item ingot = item(helper, metal + "_ingot");
            Item dust = item(helper, metal + "_dust");
            assertCooks(helper, RecipeType.SMELTING, dust, ingot, "smelting");
            assertCooks(helper, RecipeType.BLASTING, dust, ingot, "blasting");
        }

        // The three vanilla metals this mod grinds have no ingot of its own to smelt back to.
        assertCooks(helper, RecipeType.SMELTING, CoreItems.IRON_DUST.get(), Items.IRON_INGOT, "smelting");
        assertCooks(helper, RecipeType.BLASTING, CoreItems.IRON_DUST.get(), Items.IRON_INGOT, "blasting");
        assertCooks(helper, RecipeType.SMELTING, CoreItems.GOLD_DUST.get(), Items.GOLD_INGOT, "smelting");
        assertCooks(helper, RecipeType.BLASTING, CoreItems.GOLD_DUST.get(), Items.GOLD_INGOT, "blasting");
        assertCooks(helper, RecipeType.SMELTING, CoreItems.COPPER_DUST.get(), Items.COPPER_INGOT, "smelting");
        assertCooks(helper, RecipeType.BLASTING, CoreItems.COPPER_DUST.get(), Items.COPPER_INGOT, "blasting");

        helper.succeed();
    }

    /**
     * Each tier is faster than the one below it. {@code getCookTime()} is the recipe's own cook
     * time scaled by the tier's speed modifier, and it is exactly what {@code tick()} counts up to,
     * so asserting it shrinks is the same claim as "the bar fills quicker" without spending 400
     * ticks on the basic tier to prove it. One machine per position, so nothing has to be replaced.
     */
    private static void machineTiersGetFaster(GameTestHelper helper) {
        Block[] mills = {CoreBlocks.BASIC_GRINDING_MILL.get(), CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(),
                CoreBlocks.ADVANCED_GRINDING_MILL.get(), CoreBlocks.EXPERT_GRINDING_MILL.get()};
        Block[] forges = {CoreBlocks.BASIC_ALLOY_FORGE.get(), CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(),
                CoreBlocks.ADVANCED_ALLOY_FORGE.get(), CoreBlocks.EXPERT_ALLOY_FORGE.get()};

        int[] millTimes = new int[4];
        int[] forgeTimes = new int[4];

        for (int tier = 0; tier < 4; tier++) {
            BlockPos millPos = new BlockPos(1 + tier * 2, 1, 1);
            helper.setBlock(millPos, mills[tier]);
            GrindingMillBlockEntity mill = helper.getBlockEntity(millPos, GrindingMillBlockEntity.class);
            mill.getInventory(null).setStackInSlot(1, new ItemStack(Items.IRON_PICKAXE));
            mill.getInventory(null).setStackInSlot(0, new ItemStack(Items.COPPER_INGOT));
            millTimes[tier] = mill.getCookTime();

            BlockPos forgePos = new BlockPos(1 + tier * 2, 1, 3);
            helper.setBlock(forgePos, forges[tier]);
            AlloyForgeBlockEntity forge = helper.getBlockEntity(forgePos, AlloyForgeBlockEntity.class);
            forge.getInventory(null).setStackInSlot(0, new ItemStack(CoreItems.COPPER_DUST.get(), 3));
            forge.getInventory(null).setStackInSlot(1, new ItemStack(CoreItems.TIN_DUST.get(), 1));
            forgeTimes[tier] = forge.getCookTime();
        }

        helper.assertTrue(millTimes[0] > 0, "the basic grinding mill has no cook time at all");
        helper.assertTrue(forgeTimes[0] > 0, "the basic alloy forge has no cook time at all");

        for (int tier = 1; tier < 4; tier++) {
            helper.assertTrue(millTimes[tier] < millTimes[tier - 1],
                    "grinding mill tier " + tier + " cooks in " + millTimes[tier] + ", no faster than " + millTimes[tier - 1]);
            helper.assertTrue(forgeTimes[tier] < forgeTimes[tier - 1],
                    "alloy forge tier " + tier + " cooks in " + forgeTimes[tier] + ", no faster than " + forgeTimes[tier - 1]);
        }

        helper.succeed();
    }

    /**
     * A machine caught mid-smelt survives being written out and read back: its items, its burn time
     * and its cook progress all come back. It is run forward first so the progress being saved is
     * real rather than poked into the fields.
     */
    private static void machineKeepsContentsAcrossReload(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.EXPERT_ALLOY_FORGE.get());
        AlloyForgeBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);
        forge.getInventory(null).setStackInSlot(0, new ItemStack(CoreItems.COPPER_DUST.get(), 3));
        forge.getInventory(null).setStackInSlot(1, new ItemStack(CoreItems.TIN_DUST.get(), 1));
        forge.getInventory(null).setStackInSlot(2, new ItemStack(Items.COAL, 8));

        helper.runAfterDelay(20L, () -> {
            AlloyForgeBlockEntity running = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);
            RegistryAccess registries = helper.getLevel().registryAccess();
            BlockPos absolute = helper.absolutePos(MACHINE);
            BlockState state = helper.getLevel().getBlockState(absolute);

            CompoundTag saved = running.saveWithFullMetadata(registries);
            helper.assertTrue(saved.getIntOr("BurnTime", 0) > 0, "the machine was not burning, so the reload would prove nothing");
            helper.assertTrue(saved.getIntOr("CookTime", 0) > 0, "the machine had no cook progress, so the reload would prove nothing");

            BlockEntity reloaded = BlockEntity.loadStatic(absolute, state, saved, registries);
            helper.assertTrue(reloaded instanceof AlloyForgeBlockEntity, "the saved machine did not load back as an alloy forge");

            AlloyForgeBlockEntity loaded = (AlloyForgeBlockEntity) reloaded;
            helper.assertValueEqual(loaded.getItems().size(), running.getItems().size(), "reloaded machine slot count");
            for (int slot = 0; slot < running.getItems().size(); slot++) {
                helper.assertTrue(ItemStack.matches(running.getItems().get(slot), loaded.getItems().get(slot)),
                        "slot " + slot + " did not survive the reload: " + running.getItems().get(slot) + " became " + loaded.getItems().get(slot));
            }
            helper.assertTrue(saved.equals(loaded.saveWithFullMetadata(registries)),
                    "the machine's saved data changed across a save/load round trip");

            helper.succeed();
        });
    }

    /** True when the mod ships a resource at this classpath path. */
    private static boolean resourceExists(String path) {
        try (InputStream in = CoreGameTests.class.getResourceAsStream(path)) {
            return in != null;
        } catch (IOException e) {
            return false;
        }
    }

    private static JsonObject readLang(GameTestHelper helper) {
        String path = "/assets/" + Constants.MOD_ID + "/lang/en_us.json";
        try (InputStream in = CoreGameTests.class.getResourceAsStream(path)) {
            helper.assertTrue(in != null, path + " is not on the classpath");
            return JsonParser.parseReader(new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            throw helper.assertionException("could not read " + path + ": " + e);
        }
    }

    /**
     * Every block and item this mod registers has a model and an English name, and the creative tab
     * they live in exists. Missing models and missing lang keys are the most repeated regression of
     * this port and neither one shows up on a server, so this walks the registries rather than
     * trusting datagen to have covered everything. Every gap is reported at once - fixing them one
     * failure at a time is a slow loop.
     */
    private static void everyBlockAndItemHasModelAndName(GameTestHelper helper) {
        JsonObject lang = readLang(helper);
        List<String> problems = new ArrayList<>();

        for (Map.Entry<ResourceKey<Block>, Block> entry : BuiltInRegistries.BLOCK.entrySet()) {
            Identifier id = entry.getKey().identifier();
            if (!Constants.MOD_ID.equals(id.getNamespace())) {
                continue;
            }
            if (!resourceExists("/assets/" + Constants.MOD_ID + "/blockstates/" + id.getPath() + ".json")) {
                problems.add("no blockstate for block " + id);
            }
            if (!lang.has(entry.getValue().getDescriptionId())) {
                problems.add("no lang key " + entry.getValue().getDescriptionId());
            }
        }

        for (Map.Entry<ResourceKey<Item>, Item> entry : BuiltInRegistries.ITEM.entrySet()) {
            Identifier id = entry.getKey().identifier();
            if (!Constants.MOD_ID.equals(id.getNamespace())) {
                continue;
            }
            // Item models moved out of models/item into items/ in 1.21.4.
            if (!resourceExists("/assets/" + Constants.MOD_ID + "/items/" + id.getPath() + ".json")) {
                problems.add("no item model for " + id);
            }
            if (!lang.has(entry.getValue().getDescriptionId())) {
                problems.add("no lang key " + entry.getValue().getDescriptionId());
            }
        }

        if (!BuiltInRegistries.CREATIVE_MODE_TAB.containsKey(CoreCreativeItems.CREATIVE_TAB_KEY)) {
            problems.add("the creative tab " + CoreCreativeItems.CREATIVE_TAB_KEY.identifier() + " is not registered");
        }
        if (!lang.has("itemGroup." + Constants.MOD_ID)) {
            problems.add("no lang key itemGroup." + Constants.MOD_ID);
        }

        helper.assertTrue(problems.isEmpty(), problems.size() + " missing assets: " + String.join("; ", problems));
        helper.succeed();
    }
}
