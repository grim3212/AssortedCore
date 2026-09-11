package com.grim3212.assorted.core.gametest;

import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantments;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.grim3212.assorted.core.gametest.CoreTestSupport.*;

/**
 * Ores and metals: drops, fortune, silk touch, smelting and the metal block families.
 */
final class OreTests {

    private OreTests() {
    }

    static void register(BiConsumer<String, Consumer<GameTestHelper>> out) {
        out.accept("ore_drops_raw_metal_and_gem", OreTests::oreDropsRawMetalAndGem);
        out.accept("ore_fortune_multiplies_drops", OreTests::oreFortuneMultipliesDrops);
        out.accept("ore_silk_touch_drops_the_ore", OreTests::oreSilkTouchDropsTheOre);
        out.accept("metal_families_round_trip", OreTests::metalFamiliesRoundTrip);
        out.accept("raw_ore_and_dust_smelt_to_ingots", OreTests::rawOreAndDustSmeltToIngots);
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
}
