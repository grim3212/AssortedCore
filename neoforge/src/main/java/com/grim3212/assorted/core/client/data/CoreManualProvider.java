package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.lib.data.LibManualProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.function.Predicate;

/**
 * This mod's section of the instruction manual. The dust and gear families are matched by the shape
 * of their ids; everything else is named, since each group belongs to a different page.
 */
public class CoreManualProvider extends LibManualProvider {

    /** The metals with an ore, a raw form and a full ingot family. */
    private static final List<String> ORE_METALS =
            List.of("tin", "silver", "aluminum", "nickel", "platinum", "lead");

    /** The metals the alloy forge makes, which have no ore of their own. */
    private static final List<String> ALLOYS = List.of("bronze", "electrum", "invar");

    private static final List<String> GEMS = List.of("ruby", "peridot", "sapphire", "topaz");

    public CoreManualProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void addChapters() {
        this.section(0, CoreBlocks.MACHINE_CORE.get());

        this.addMachines();
        this.addMetals();
        this.addGems();
    }

    private void addMachines() {
        ChapterBuilder machines = this.chapter("machines");

        machines.recipes("core", CoreBlocks.MACHINE_CORE.get()).opens(CoreBlocks.MACHINE_CORE.get());
        machines.recipes("tiers", CoreBlocks.BASIC_ALLOY_FORGE.get().asItem(),
                CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get().asItem(),
                CoreBlocks.ADVANCED_ALLOY_FORGE.get().asItem(),
                CoreBlocks.EXPERT_ALLOY_FORGE.get().asItem());
        machines.recipes("alloy_forge", CoreBlocks.BASIC_ALLOY_FORGE.get())
                .opens(CoreBlocks.BASIC_ALLOY_FORGE.get(), CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(),
                        CoreBlocks.ADVANCED_ALLOY_FORGE.get(), CoreBlocks.EXPERT_ALLOY_FORGE.get());
        machines.recipes("alloying", CoreItems.STEEL_INGOT.get(), CoreItems.BRONZE_INGOT.get(), CoreItems.ELECTRUM_INGOT.get(), CoreItems.INVAR_INGOT.get()).every(60)
                .opensEveryItem(family(ALLOYS, "_ingot", "_nugget"))
                .opensEveryBlock(family(ALLOYS, "_block"));
        machines.recipes("grinding_mill", CoreBlocks.BASIC_GRINDING_MILL.get())
                .opens(CoreBlocks.BASIC_GRINDING_MILL.get(), CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(),
                        CoreBlocks.ADVANCED_GRINDING_MILL.get(), CoreBlocks.EXPERT_GRINDING_MILL.get());
        machines.recipesById("grinding", recipeId(CoreItems.ALUMINUM_DUST.get()), recipeId("aluminum_dust_from_ingot"), recipeId("aluminum_dust_from_raw_ore"))
                .every(60);
    }

    private void addMetals() {
        ChapterBuilder metals = this.chapter("metals");

        metals.items("ores", CoreBlocks.TIN_ORE.get().asItem(), CoreBlocks.SILVER_ORE.get().asItem(),
                        CoreBlocks.ALUMINUM_ORE.get().asItem(), CoreBlocks.NICKEL_ORE.get().asItem(),
                        CoreBlocks.PLATINUM_ORE.get().asItem(), CoreBlocks.LEAD_ORE.get().asItem()).every(50)
                .opensEveryBlock(family(ORE_METALS, "_ore", "_block", "_raw_block"))
                .opensEveryBlock(deepslate(ORE_METALS))
                .opensEveryBlock(rawBlocks(ORE_METALS))
                .opensEveryItem(family(ORE_METALS, "_ingot", "_nugget"))
                .opensEveryItem(raw(ORE_METALS))
                .opensEveryItem(id -> id.getPath().equals("copper_nugget"));
        metals.recipesById("dusts", recipeId("dusts/aluminum_smelting"), recipeId("dusts/aluminum_blasting")).every(60)
                .opensEveryItem(suffix("_dust"));
        metals.recipes("steel", CoreItems.STEEL_INGOT.get())
                .opens(CoreItems.STEEL_INGOT.get(), CoreItems.STEEL_NUGGET.get())
                .opens(CoreBlocks.STEEL_BLOCK.get());
        metals.recipes("gears", CoreItems.STEEL_GEAR.get(), CoreItems.COPPER_GEAR.get(), CoreItems.IRON_GEAR.get()).every(60)
                .opensEveryItem(suffix("_gear"));
    }

    private void addGems() {
        ChapterBuilder gems = this.chapter("gems");

        gems.recipes("gems", CoreItems.RUBY.get(), CoreItems.PERIDOT.get(), CoreItems.SAPPHIRE.get(),
                        CoreItems.TOPAZ.get()).every(50)
                .opens(CoreItems.RUBY.get(), CoreItems.PERIDOT.get(), CoreItems.SAPPHIRE.get(), CoreItems.TOPAZ.get());
        gems.recipesById("smelting", recipeId("ruby_smelting"), recipeId("peridot_smelting"), recipeId("sapphire_smelting"), recipeId("topaz_smelting"))
                .every(60)
                .opensEveryBlock(family(GEMS, "_ore"))
                .opensEveryBlock(deepslate(GEMS));
        gems.recipes("storage", CoreBlocks.RUBY_BLOCK.get(), CoreBlocks.PERIDOT_BLOCK.get(), CoreBlocks.SAPPHIRE_BLOCK.get(), CoreBlocks.TOPAZ_BLOCK.get()).every(60)
                .opensEveryBlock(family(GEMS, "_block"));
    }

    private static Predicate<Identifier> suffix(String suffix) {
        return id -> id.getPath().endsWith(suffix);
    }

    /** {@code <material><suffix>} for any of the materials and any of the suffixes. */
    private static Predicate<Identifier> family(List<String> materials, String... suffixes) {
        return id -> {
            for (String material : materials) {
                for (String suffix : suffixes) {
                    if (id.getPath().equals(material + suffix)) {
                        return true;
                    }
                }
            }
            return false;
        };
    }

    private static Predicate<Identifier> deepslate(List<String> materials) {
        return id -> materials.stream().anyMatch(m -> id.getPath().equals("deepslate_" + m + "_ore"));
    }

    private static Predicate<Identifier> rawBlocks(List<String> materials) {
        return id -> materials.stream().anyMatch(m -> id.getPath().equals("raw_" + m + "_block"));
    }

    private static Predicate<Identifier> raw(List<String> materials) {
        return id -> materials.stream().anyMatch(m -> id.getPath().equals("raw_" + m));
    }
}
