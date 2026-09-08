package com.grim3212.assorted.core.api.machines;

import com.grim3212.assorted.core.api.CoreTags;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.lib.platform.Services;
import com.grim3212.assorted.lib.platform.services.IPlatformHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class MachineUtil {

    public static boolean allowedInGrindingMillToolSlot(ItemStack stack) {
        if (stack.is(CoreTags.Items.GRINDING_MILL_ALLOWED_TOOLS))
            return true;

        return Services.PLATFORM.isTieredTool(stack, IPlatformHelper.ToolTier.IRON, IPlatformHelper.ToolType.PICKAXE);
    }

    /**
     * Every recipe of one type currently loaded.
     * <p>
     * {@code RecipeManager#getAllRecipesFor} is gone, and the recipe manager itself only exists on
     * the server now - {@link Level#recipeAccess()} hands back a {@code RecipeAccess} that carries
     * nothing but property sets and stonecutter recipes. So this walks
     * {@code ServerLevel#recipeAccess()} and filters by type, and is simply empty on the client.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Recipe<?>> Stream<T> recipesOfType(@Nullable Level level, RecipeType<T> recipeType) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return Stream.empty();
        }

        return serverLevel.recipeAccess().getRecipes().stream().map(RecipeHolder::value).filter((recipe) -> recipe.getType() == recipeType).map((recipe) -> (T) recipe);
    }

    public static boolean isValidAlloyForgeInput(@Nullable Level level, ItemStack stack) {
        return recipesOfType(level, CoreRecipeTypes.ALLOY_FORGE.get()).anyMatch((recipe) -> recipe.validItem(stack));
    }

    public static boolean isValidGrindingMillInput(@Nullable Level level, ItemStack stack) {
        return recipesOfType(level, CoreRecipeTypes.GRINDING_MILL.get()).anyMatch((recipe) -> recipe.validItem(stack));
    }
}
