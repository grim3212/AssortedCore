package com.grim3212.assorted.core.common.items;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class CoreItems {
    
    public static final IRegistryObject<Item> RUBY = register("ruby", props -> new Item(props));
    public static final IRegistryObject<Item> PERIDOT = register("peridot", props -> new Item(props));
    public static final IRegistryObject<Item> SAPPHIRE = register("sapphire", props -> new Item(props));
    public static final IRegistryObject<Item> TOPAZ = register("topaz", props -> new Item(props));

    public static final IRegistryObject<Item> TIN_INGOT = register("tin_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> SILVER_INGOT = register("silver_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> ALUMINUM_INGOT = register("aluminum_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> NICKEL_INGOT = register("nickel_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> PLATINUM_INGOT = register("platinum_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> LEAD_INGOT = register("lead_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> BRONZE_INGOT = register("bronze_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> ELECTRUM_INGOT = register("electrum_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> INVAR_INGOT = register("invar_ingot", props -> new Item(props));
    public static final IRegistryObject<Item> STEEL_INGOT = register("steel_ingot", props -> new Item(props));

    public static final IRegistryObject<Item> TIN_NUGGET = register("tin_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> COPPER_NUGGET = register("copper_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> SILVER_NUGGET = register("silver_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> ALUMINUM_NUGGET = register("aluminum_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> NICKEL_NUGGET = register("nickel_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> PLATINUM_NUGGET = register("platinum_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> LEAD_NUGGET = register("lead_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> BRONZE_NUGGET = register("bronze_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> ELECTRUM_NUGGET = register("electrum_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> INVAR_NUGGET = register("invar_nugget", props -> new Item(props));
    public static final IRegistryObject<Item> STEEL_NUGGET = register("steel_nugget", props -> new Item(props));

    public static final IRegistryObject<Item> TIN_DUST = register("tin_dust", props -> new Item(props));
    public static final IRegistryObject<Item> COPPER_DUST = register("copper_dust", props -> new Item(props));
    public static final IRegistryObject<Item> SILVER_DUST = register("silver_dust", props -> new Item(props));
    public static final IRegistryObject<Item> ALUMINUM_DUST = register("aluminum_dust", props -> new Item(props));
    public static final IRegistryObject<Item> NICKEL_DUST = register("nickel_dust", props -> new Item(props));
    public static final IRegistryObject<Item> PLATINUM_DUST = register("platinum_dust", props -> new Item(props));
    public static final IRegistryObject<Item> LEAD_DUST = register("lead_dust", props -> new Item(props));
    public static final IRegistryObject<Item> BRONZE_DUST = register("bronze_dust", props -> new Item(props));
    public static final IRegistryObject<Item> ELECTRUM_DUST = register("electrum_dust", props -> new Item(props));
    public static final IRegistryObject<Item> INVAR_DUST = register("invar_dust", props -> new Item(props));
    public static final IRegistryObject<Item> STEEL_DUST = register("steel_dust", props -> new Item(props));
    public static final IRegistryObject<Item> IRON_DUST = register("iron_dust", props -> new Item(props));
    public static final IRegistryObject<Item> GOLD_DUST = register("gold_dust", props -> new Item(props));

    public static final IRegistryObject<Item> TIN_GEAR = register("tin_gear", props -> new Item(props));
    public static final IRegistryObject<Item> COPPER_GEAR = register("copper_gear", props -> new Item(props));
    public static final IRegistryObject<Item> SILVER_GEAR = register("silver_gear", props -> new Item(props));
    public static final IRegistryObject<Item> ALUMINUM_GEAR = register("aluminum_gear", props -> new Item(props));
    public static final IRegistryObject<Item> NICKEL_GEAR = register("nickel_gear", props -> new Item(props));
    public static final IRegistryObject<Item> PLATINUM_GEAR = register("platinum_gear", props -> new Item(props));
    public static final IRegistryObject<Item> LEAD_GEAR = register("lead_gear", props -> new Item(props));
    public static final IRegistryObject<Item> BRONZE_GEAR = register("bronze_gear", props -> new Item(props));
    public static final IRegistryObject<Item> ELECTRUM_GEAR = register("electrum_gear", props -> new Item(props));
    public static final IRegistryObject<Item> INVAR_GEAR = register("invar_gear", props -> new Item(props));
    public static final IRegistryObject<Item> STEEL_GEAR = register("steel_gear", props -> new Item(props));
    public static final IRegistryObject<Item> IRON_GEAR = register("iron_gear", props -> new Item(props));
    public static final IRegistryObject<Item> GOLD_GEAR = register("gold_gear", props -> new Item(props));

    public static final IRegistryObject<Item> RAW_TIN = register("raw_tin", props -> new Item(props));
    public static final IRegistryObject<Item> RAW_SILVER = register("raw_silver", props -> new Item(props));
    public static final IRegistryObject<Item> RAW_ALUMINUM = register("raw_aluminum", props -> new Item(props));
    public static final IRegistryObject<Item> RAW_NICKEL = register("raw_nickel", props -> new Item(props));
    public static final IRegistryObject<Item> RAW_PLATINUM = register("raw_platinum", props -> new Item(props));
    public static final IRegistryObject<Item> RAW_LEAD = register("raw_lead", props -> new Item(props));

    private static <T extends Item> IRegistryObject<T> register(final String name, final Function<Item.Properties, ? extends T> factory) {
        // Since 1.21.2 every item has to know its own id before it is constructed, so the
        // properties are built here where the registration name is known.
        final ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Constants.MOD_ID, name));
        return CoreBlocks.ITEMS.register(name, () -> factory.apply(new Item.Properties().setId(key)));
    }

    public static void init() {
    }
}
