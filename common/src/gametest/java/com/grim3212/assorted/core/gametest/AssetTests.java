package com.grim3212.assorted.core.gametest;

import net.minecraft.locale.Language;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.server.MinecraftServer;
import com.grim3212.assorted.lib.platform.Services;
import java.io.BufferedReader;
import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.handlers.CoreCreativeItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.grim3212.assorted.core.gametest.CoreTestSupport.*;

/**
 * What the mod ships: a model and a name for everything, and recipes that load.
 */
final class AssetTests {

    private AssetTests() {
    }

    static void register(BiConsumer<String, Consumer<GameTestHelper>> out) {
        out.accept("every_block_and_item_has_model_and_name", AssetTests::everyBlockAndItemHasModelAndName);
        out.accept("every_recipe_loads_or_is_conditioned_off", AssetTests::everyRecipeLoadsOrIsConditionedOff);
        out.accept("every_item_tag_has_a_name", AssetTests::everyItemTagHasAName);
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

    /**
     * Every recipe file this mod ships either loaded, or carries this loader's load conditions and was
     * skipped by them. A file with neither failed to parse. On Fabric that was every conditional
     * recipe for a while: Fabric's datagen wrote them without conditions, and the NeoForge copy that
     * shadowed it carries a key Fabric ignores - so only this loader's own key counts.
     */
    private static void everyRecipeLoadsOrIsConditionedOff(GameTestHelper helper) {
        MinecraftServer server = helper.getLevel().getServer();
        FileToIdConverter recipes = FileToIdConverter.json("recipe");
        String conditionsKey = Services.PLATFORM.getPlatformName().equals("Fabric") ? "fabric:load_conditions" : "neoforge:conditions";
        List<String> failed = new ArrayList<>();

        recipes.listMatchingResources(server.getResourceManager()).forEach((file, resource) -> {
            Identifier id = recipes.fileToId(file);
            if (!id.getNamespace().equals(Constants.MOD_ID) || server.getRecipeManager().byKey(ResourceKey.create(Registries.RECIPE, id)).isPresent()) {
                return;
            }

            try (BufferedReader reader = resource.openAsReader()) {
                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
                if (!json.has(conditionsKey)) {
                    failed.add(id.toString());
                }
            } catch (IOException e) {
                failed.add(id + " (" + e.getMessage() + ")");
            }
        });

        helper.assertTrue(failed.isEmpty(), failed.size() + " recipes failed to load without being conditioned off: " + String.join(", ", failed.subList(0, Math.min(10, failed.size()))));
        helper.succeed();
    }

    /**
     * Every item tag outside minecraft has a name. Recipe viewers show it in place of the raw id,
     * and it is the check Fabric API runs at dev startup ("Untranslated Item Tags detected"), made
     * to fail here: the key is {@code tag.item.<namespace>.<path>} with each '/' in the path turned
     * into '.'. Both loaders load every mod's lang file on a dedicated server and name the standard
     * c: tags themselves, so whatever is still missing is one of ours.
     */
    private static void everyItemTagHasAName(GameTestHelper helper) {
        Language language = Language.getInstance();
        List<String> missing = helper.getLevel().registryAccess().lookupOrThrow(Registries.ITEM).getTags()
                .map(tag -> tag.key().location())
                .filter(id -> !"minecraft".equals(id.getNamespace()))
                .map(id -> "tag.item." + id.getNamespace() + "." + id.getPath().replace('/', '.'))
                .filter(key -> !language.has(key))
                .sorted()
                .toList();
        helper.assertTrue(missing.isEmpty(), "item tags with no name in any lang file: " + missing);
        helper.succeed();
    }
}
