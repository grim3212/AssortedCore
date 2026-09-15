package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.lib.data.LibLanguageProvider;
import com.grim3212.assorted.core.Constants;
import net.minecraft.data.PackOutput;

/**
 * Generates the en_us.json of this mod. A block, item or entity whose name is its id in title case needs
 * no line here (see {@link LibLanguageProvider}); these are the names that read differently, and
 * every key that is not a name.
 */
public class CoreLanguageProvider extends LibLanguageProvider {

    /** A blank line between paragraphs; the manual splits its text the way the font does. */
    private static final String BREAK = "\n\n";

    public CoreLanguageProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void addNames() {
        this.add("itemGroup.assortedcore", "Assorted Core");

        this.add("assortedcore.container.alloy_forge", "Alloy Forge");
        this.add("assortedcore.container.grinding_mill", "Grinding Mill");

        // The recipe book's "only what I can make" toggle, one name per machine.
        this.add("gui.assortedcore.recipebook.toggleRecipes.alloyable", "Showing Alloyable");
        this.add("gui.assortedcore.recipebook.toggleRecipes.grindable", "Showing Grindable");

        this.add("tag.item.assortedcore.grinding_mill_allowed_tools", "Grinding Mill Tools");
        this.add("tag.item.c.gear", "Gears");

        // c: item tags this mod adds that neither loader names, one family at a time.
        this.tagFamily("dusts", "%s Dusts", "aluminum", "bronze", "copper", "electrum", "gold", "invar", "iron", "lead", "nickel", "platinum", "silver", "steel", "tin");
        this.tagFamily("gear", "%s Gears", "aluminum", "bronze", "copper", "electrum", "gold", "invar", "iron", "lead", "nickel", "platinum", "silver", "steel", "tin");
        this.tagFamily("gems", "%s Gems", "peridot", "ruby", "sapphire", "topaz");
        this.tagFamily("ingots", "%s Ingots", "aluminum", "bronze", "electrum", "invar", "lead", "nickel", "platinum", "silver", "steel", "tin");
        this.tagFamily("nuggets", "%s Nuggets", "aluminum", "bronze", "electrum", "invar", "lead", "nickel", "platinum", "silver", "steel", "tin");
        this.tagFamily("ores", "%s Ores", "aluminum", "lead", "nickel", "peridot", "platinum", "ruby", "sapphire", "silver", "tin", "topaz");
        this.tagFamily("raw_materials", "Raw %s Materials", "aluminum", "lead", "nickel", "platinum", "silver", "tin");
        this.tagFamily("storage_blocks", "%s Storage Blocks", "aluminum", "bronze", "electrum", "invar", "lead", "nickel", "peridot", "platinum", "raw_aluminum", "raw_lead", "raw_nickel", "raw_platinum", "raw_silver", "raw_tin", "ruby", "sapphire", "silver", "steel", "tin", "topaz");

        // Families whose names read differently from their ids.
        this.nameBlocks("(.+)_block", m -> "Block of " + titleCase(m.group(1)));

        this.addManual();
    }

    /** The chapters in {@code assets/assortedcore/manual} name these keys. */
    private void addManual() {
        this.add("manual.assortedcore.title", "Assorted Core");
        this.add("manual.assortedcore.description",
                "The ores, metals and gems the other Assorted mods build on, and the two machines that work them.");

        this.addMachinesChapter();
        this.addMetalsChapter();
        this.addGemsChapter();
    }

    private void addMachinesChapter() {
        this.add("manual.assortedcore.chapter.machines", "Machines");

        this.add("manual.assortedcore.chapter.machines.core.title", "Machine Core");
        this.add("manual.assortedcore.chapter.machines.core",
                "Every machine is built around a machine core.");

        this.add("manual.assortedcore.chapter.machines.tiers.title", "Tiers");
        this.add("manual.assortedcore.chapter.machines.tiers",
                "Each machine comes in four tiers, doing the same work at different speeds. Basic, intermediate, advanced, and expert.");

        this.add("manual.assortedcore.chapter.machines.alloy_forge.title", "Alloy Forge");
        this.add("manual.assortedcore.chapter.machines.alloy_forge",
                "The alloy forge takes two ingredients and fuel, and melts them together.");

        this.add("manual.assortedcore.chapter.machines.alloying.title", "Alloying");
        this.add("manual.assortedcore.chapter.machines.alloying",
                "The alloy forge can make a number of different alloys. Here are the recipes for the alloys in this mod.");

        this.add("manual.assortedcore.chapter.machines.grinding_mill.title", "Grinding Mill");
        this.add("manual.assortedcore.chapter.machines.grinding_mill",
                "The grinding mill breaks one thing down into another, and doubles what an ore is worth on the way.");

        this.add("manual.assortedcore.chapter.machines.grinding.title", "Grinding");
        this.add("manual.assortedcore.chapter.machines.grinding",
                "An ore grinds into two dusts, a raw chunk into two, and an ingot back into one. Every metal works the same way.");
    }

    private void addMetalsChapter() {
        this.add("manual.assortedcore.chapter.metals", "Ores and Metals");

        this.add("manual.assortedcore.chapter.metals.ores.title", "Ores");
        this.add("manual.assortedcore.chapter.metals.ores",
                "Six metals are added to the world, each with a deepslate form deeper down.");

        this.add("manual.assortedcore.chapter.metals.dusts.title", "Dusts");
        this.add("manual.assortedcore.chapter.metals.dusts",
                "Grind an ore into dust and smelt the dust, and one ore has become two ingots.");

        this.add("manual.assortedcore.chapter.metals.steel.title", "Steel");
        this.add("manual.assortedcore.chapter.metals.steel",
                "Iron dust forged with coal. Steel is the sturdiest of the metals here and makes very strong tools.");

        this.add("manual.assortedcore.chapter.metals.gears.title", "Gears");
        this.add("manual.assortedcore.chapter.metals.gears",
                "Every metal can be made into a gear. Machines and the other Assorted mods can be built out of them.");
    }

    private void addGemsChapter() {
        this.add("manual.assortedcore.chapter.gems", "Gems");

        this.add("manual.assortedcore.chapter.gems.gems.title", "Gems");
        this.add("manual.assortedcore.chapter.gems.gems",
                "Four gems are added to the world. Ruby, peridot, sapphire and topaz. Their ores drop the gem directly.");

        this.add("manual.assortedcore.chapter.gems.smelting.title", "From Ore");
        this.add("manual.assortedcore.chapter.gems.smelting",
                "A gem ore mined without Silk Touch already drops its gem. Smelt the ore itself when you have kept one whole.");

        this.add("manual.assortedcore.chapter.gems.storage.title", "Storage");
        this.add("manual.assortedcore.chapter.gems.storage",
                "Nine of a gem pack into a block, and the block breaks back down into nine. The same holds for every gem and metal here.");
    }

    /** Names c:{@code family}/material for each material, as {@code format} around the material name. */
    private void tagFamily(String family, String format, String... materials) {
        for (String material : materials) {
            this.add("tag.item.c." + family + "." + material, String.format(format, titleCase(material)));
        }
    }
}
