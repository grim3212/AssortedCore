package com.grim3212.assorted.core.gametest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.grim3212.assorted.lib.test.TestSupport.craft;

/**
 * Helpers and constants shared by AssortedCore's gametest classes, which import them statically,
 * alongside AssortedLib's {@code TestSupport}.
 */
final class CoreTestSupport {

    private CoreTestSupport() {
    }

    static final BlockPos MACHINE = new BlockPos(4, 1, 4);

    // Ore drops, recipes, tier speed, persistence and assets.

    /** An ore, and the item it drops when it is mined without Silk Touch. */
    record OreDrop(Block ore, Item drop) {
    }

    /** Every ore this mod adds, stone and deepslate, metal and gem. */
    static List<OreDrop> ores() {
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
    static final List<String> METALS = List.of(
            "tin", "silver", "aluminum", "nickel", "platinum", "lead", "bronze", "electrum", "invar", "steel");

    static final BlockPos ORE_A = new BlockPos(2, 1, 6);

    static final BlockPos ORE_B = new BlockPos(6, 1, 2);

    static Holder<Enchantment> enchantment(GameTestHelper helper, ResourceKey<Enchantment> key) {
        return helper.getLevel().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(key);
    }

    /**
     * Rolls a block's loot table with a fixed seed, so a Fortune roll is reproducible. {@code tool}
     * is what Silk Touch and Fortune read.
     */
    static List<ItemStack> rollDrops(GameTestHelper helper, Block block, ItemStack tool, long seed) {
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

    /** A ring of eight around a centre - the machine core and two of the three tier upgrades. */
    static List<ItemStack> ring(ItemStack corner, ItemStack edge, ItemStack centre) {
        return List.of(corner, edge, corner, edge, centre, edge, corner, edge, corner);
    }

    /** A plus of four around a centre - the expert upgrade and every gear. */
    static List<ItemStack> cross(ItemStack arm, ItemStack centre) {
        return List.of(ItemStack.EMPTY, arm, ItemStack.EMPTY, arm, centre, arm, ItemStack.EMPTY, arm, ItemStack.EMPTY);
    }

    /** {@code CraftingInput.of} wants exactly width * height stacks, so the size is passed in. */
    static void assertCrafts(GameTestHelper helper, int width, int height, List<ItemStack> grid, Item expected, int count, String what) {
        ItemStack result = craft(helper, CraftingInput.of(width, height, grid), what);
        helper.assertTrue(result.is(expected), what + " crafted " + result + " instead of " + expected);
        helper.assertValueEqual(result.getCount(), count, what + " result count");
    }

    static <T extends AbstractCookingRecipe> void assertCooks(GameTestHelper helper, RecipeType<T> type, Item input, Item expected, String what) {
        SingleRecipeInput recipeInput = new SingleRecipeInput(new ItemStack(input));
        var found = helper.getLevel().recipeAccess().getRecipeFor(type, recipeInput, helper.getLevel());
        helper.assertTrue(found.isPresent(), "no " + what + " recipe for " + BuiltInRegistries.ITEM.getKey(input));

        ItemStack result = found.get().value().assemble(recipeInput);
        helper.assertTrue(result.is(expected), what + " " + BuiltInRegistries.ITEM.getKey(input) + " gave " + result + " instead of " + expected);
    }

    static Item item(GameTestHelper helper, String name) {
        Item found = BuiltInRegistries.ITEM.getOptional(Identifier.fromNamespaceAndPath(Constants.MOD_ID, name)).orElse(null);
        helper.assertTrue(found != null, "nothing registered as " + Constants.MOD_ID + ":" + name);
        return found;
    }

    /** True when the mod ships a resource at this classpath path. */
    static boolean resourceExists(String path) {
        try (InputStream in = CoreTestSupport.class.getResourceAsStream(path)) {
            return in != null;
        } catch (IOException e) {
            return false;
        }
    }

    static JsonObject readLang(GameTestHelper helper) {
        String path = "/assets/" + Constants.MOD_ID + "/lang/en_us.json";
        try (InputStream in = CoreTestSupport.class.getResourceAsStream(path)) {
            helper.assertTrue(in != null, path + " is not on the classpath");
            return JsonParser.parseReader(new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            throw helper.assertionException("could not read " + path + ": " + e);
        }
    }
}
