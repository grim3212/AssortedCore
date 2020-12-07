package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.AssortedCore;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreContainerTypes {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, AssortedCore.MODID);

	public static final RegistryObject<ContainerType<AlloyForgeContainer>> ALLOY_FORGE = CONTAINER_TYPES.register("alloy_forge", () -> new ContainerType<>(AlloyForgeContainer::new));
	public static final RegistryObject<ContainerType<GrindingMillContainer>> GRINDING_MILL = CONTAINER_TYPES.register("grinding_mill", () -> new ContainerType<>(GrindingMillContainer::new));
}
