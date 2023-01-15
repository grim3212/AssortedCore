package com.grim3212.assorted.core.common.item;

import java.util.function.Supplier;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AssortedCore.MODID);

	public static final RegistryObject<Item> RUBY = register("ruby", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PERIDOT = register("peridot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SAPPHIRE = register("sapphire", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> TOPAZ = register("topaz", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> TIN_INGOT = register("tin_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ALUMINUM_INGOT = register("aluminum_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NICKEL_INGOT = register("nickel_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_INGOT = register("platinum_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LEAD_INGOT = register("lead_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BRONZE_INGOT = register("bronze_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ELECTRUM_INGOT = register("electrum_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INVAR_INGOT = register("invar_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> TIN_NUGGET = register("tin_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> COPPER_NUGGET = register("copper_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SILVER_NUGGET = register("silver_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ALUMINUM_NUGGET = register("aluminum_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NICKEL_NUGGET = register("nickel_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_NUGGET = register("platinum_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LEAD_NUGGET = register("lead_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BRONZE_NUGGET = register("bronze_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ELECTRUM_NUGGET = register("electrum_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INVAR_NUGGET = register("invar_nugget", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_NUGGET = register("steel_nugget", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> TIN_DUST = register("tin_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> COPPER_DUST = register("copper_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SILVER_DUST = register("silver_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ALUMINUM_DUST = register("aluminum_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NICKEL_DUST = register("nickel_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_DUST = register("platinum_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LEAD_DUST = register("lead_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BRONZE_DUST = register("bronze_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ELECTRUM_DUST = register("electrum_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INVAR_DUST = register("invar_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_DUST = register("steel_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> IRON_DUST = register("iron_dust", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GOLD_DUST = register("gold_dust", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> TIN_GEAR = register("tin_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> COPPER_GEAR = register("copper_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SILVER_GEAR = register("silver_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ALUMINUM_GEAR = register("aluminum_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> NICKEL_GEAR = register("nickel_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_GEAR = register("platinum_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LEAD_GEAR = register("lead_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> BRONZE_GEAR = register("bronze_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> ELECTRUM_GEAR = register("electrum_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> INVAR_GEAR = register("invar_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STEEL_GEAR = register("steel_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> IRON_GEAR = register("iron_gear", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> GOLD_GEAR = register("gold_gear", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> RAW_TIN = register("raw_tin", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_SILVER = register("raw_silver", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_ALUMINUM = register("raw_aluminum", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_NICKEL = register("raw_nickel", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_PLATINUM = register("raw_platinum", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_LEAD = register("raw_lead", () -> new Item(new Item.Properties()));

	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
		return ITEMS.register(name, sup);
	}
}
