package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreContainerTypes {
	public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, AssortedCore.MODID);

	public static final RegistryObject<MenuType<AlloyForgeContainer>> ALLOY_FORGE = CONTAINER_TYPES.register("alloy_forge", () -> new MenuType<>(AlloyForgeContainer::new));
	public static final RegistryObject<MenuType<GrindingMillContainer>> GRINDING_MILL = CONTAINER_TYPES.register("grinding_mill", () -> new MenuType<>(GrindingMillContainer::new));
}
