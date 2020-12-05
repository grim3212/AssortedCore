package com.grim3212.assorted.core.common.item;

import java.util.function.Supplier;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AssortedCore.MODID);

	public static final RegistryObject<Item> RUBY = register("ruby", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> AMETHYST = register("amethyst", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> SAPPHIRE = register("sapphire", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> TOPAZ = register("topaz", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	
	public static final RegistryObject<Item> TIN_INGOT = register("tin_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> COPPER_INGOT = register("copper_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> SILVER_INGOT = register("silver_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_INGOT = register("aluminum_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> NICKEL_INGOT = register("nickel_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> PLATINUM_INGOT = register("platinum_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> LEAD_INGOT = register("lead_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> BRONZE_INGOT = register("bronze_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> ELECTRUM_INGOT = register("electrum_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> INVAR_INGOT = register("invar_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	
	public static final RegistryObject<Item> TIN_NUGGET = register("tin_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> COPPER_NUGGET = register("copper_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> SILVER_NUGGET = register("silver_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_NUGGET = register("aluminum_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> NICKEL_NUGGET = register("nickel_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> PLATINUM_NUGGET = register("platinum_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> LEAD_NUGGET = register("lead_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> BRONZE_NUGGET = register("bronze_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> ELECTRUM_NUGGET = register("electrum_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> INVAR_NUGGET = register("invar_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> STEEL_NUGGET = register("steel_nugget", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	
	public static final RegistryObject<Item> TIN_DUST = register("tin_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> COPPER_DUST = register("copper_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> SILVER_DUST = register("silver_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> ALUMINUM_DUST = register("aluminum_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> NICKEL_DUST = register("nickel_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> PLATINUM_DUST = register("platinum_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> LEAD_DUST = register("lead_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> BRONZE_DUST = register("bronze_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> ELECTRUM_DUST = register("electrum_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> INVAR_DUST = register("invar_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	public static final RegistryObject<Item> STEEL_DUST = register("steel_dust", () -> new Item(new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
		return ITEMS.register(name, sup);
	}
}
