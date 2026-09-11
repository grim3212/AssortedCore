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

    public CoreLanguageProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void addNames() {
        this.add("itemGroup.assortedcore", "Assorted Core");

        this.add("assortedcore.container.alloy_forge", "Alloy Forge");
        this.add("assortedcore.container.grinding_mill", "Grinding Mill");

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
    }

    /** Names c:{@code family}/material for each material, as {@code format} around the material name. */
    private void tagFamily(String family, String format, String... materials) {
        for (String material : materials) {
            this.add("tag.item.c." + family + "." + material, String.format(format, titleCase(material)));
        }
    }
}
