package com.grim3212.assorted.core.common.inventory;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.lib.platform.Services;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import com.grim3212.assorted.lib.registry.RegistryProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

public class CoreContainerTypes {
    public static final RegistryProvider<MenuType<?>> MENU_TYPES = RegistryProvider.create(Registries.MENU, Constants.MOD_ID);
    public static final IRegistryObject<MenuType<AlloyForgeContainer>> ALLOY_FORGE = MENU_TYPES.register("alloy_forge", () -> Services.REGISTRY_UTIL.createMenuType((syncId, pInv, buf) -> new AlloyForgeContainer(syncId, pInv)));
    public static final IRegistryObject<MenuType<GrindingMillContainer>> GRINDING_MILL = MENU_TYPES.register("grinding_mill", () -> Services.REGISTRY_UTIL.createMenuType((syncId, pInv, buf) -> new GrindingMillContainer(syncId, pInv)));

    public static void init() {
    }


}
