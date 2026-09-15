package com.grim3212.assorted.core.common.crafting;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.crafting.MachineRecipeDisplay;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import com.grim3212.assorted.lib.registry.RegistryProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;

/** Registered on both sides: a {@code RecipeDisplay} reaches a client by its registered id. */
public class CoreRecipeDisplays {

    public static final RegistryProvider<RecipeDisplay.Type<?>> RECIPE_DISPLAYS = RegistryProvider.create(Registries.RECIPE_DISPLAY, Constants.MOD_ID);

    public static final IRegistryObject<RecipeDisplay.Type<MachineRecipeDisplay>> MACHINE = RECIPE_DISPLAYS.register("machine", () -> MachineRecipeDisplay.TYPE);

    public static void init() {
    }
}
