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

	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
		return ITEMS.register(name, sup);
	}
}
