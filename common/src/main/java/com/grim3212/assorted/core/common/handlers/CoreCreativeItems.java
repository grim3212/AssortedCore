package com.grim3212.assorted.core.common.handlers;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.lib.core.creative.CreativeTabItems;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import com.grim3212.assorted.lib.registry.RegistryProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class CoreCreativeItems {

    public static final RegistryProvider<CreativeModeTab> CREATIVE_TABS = RegistryProvider.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final IRegistryObject CREATIVE_TAB = CREATIVE_TABS.register("tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup." + Constants.MOD_ID))
            .icon(() -> new ItemStack(CoreBlocks.PLATINUM_ORE.get()))
            .displayItems((props, output) -> output.acceptAll(CoreCreativeItems.getCreativeItems())).build());


    private static List<ItemStack> getCreativeItems() {
        CreativeTabItems items = new CreativeTabItems();

        items.add(CoreBlocks.BASIC_GRINDING_MILL.get());
        items.add(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
        items.add(CoreBlocks.ADVANCED_GRINDING_MILL.get());
        items.add(CoreBlocks.EXPERT_GRINDING_MILL.get());

        items.add(CoreBlocks.BASIC_ALLOY_FORGE.get());
        items.add(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
        items.add(CoreBlocks.ADVANCED_ALLOY_FORGE.get());
        items.add(CoreBlocks.EXPERT_ALLOY_FORGE.get());

        items.add(CoreBlocks.MACHINE_CORE.get());

        items.add(CoreBlocks.TIN_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_TIN_ORE.get());
        items.add(CoreBlocks.RAW_TIN_BLOCK.get());
        items.add(CoreBlocks.TIN_BLOCK.get());
        items.add(CoreItems.TIN_DUST.get());
        items.add(CoreItems.TIN_NUGGET.get());
        items.add(CoreItems.TIN_INGOT.get());
        items.add(CoreItems.RAW_TIN.get());
        items.add(CoreItems.TIN_GEAR.get());

        items.add(CoreBlocks.SILVER_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_SILVER_ORE.get());
        items.add(CoreBlocks.RAW_SILVER_BLOCK.get());
        items.add(CoreBlocks.SILVER_BLOCK.get());
        items.add(CoreItems.SILVER_DUST.get());
        items.add(CoreItems.SILVER_NUGGET.get());
        items.add(CoreItems.SILVER_INGOT.get());
        items.add(CoreItems.RAW_SILVER.get());
        items.add(CoreItems.SILVER_GEAR.get());

        items.add(CoreBlocks.ALUMINUM_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        items.add(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
        items.add(CoreBlocks.ALUMINUM_BLOCK.get());
        items.add(CoreItems.ALUMINUM_DUST.get());
        items.add(CoreItems.ALUMINUM_NUGGET.get());
        items.add(CoreItems.ALUMINUM_INGOT.get());
        items.add(CoreItems.RAW_ALUMINUM.get());
        items.add(CoreItems.ALUMINUM_GEAR.get());

        items.add(CoreBlocks.NICKEL_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_NICKEL_ORE.get());
        items.add(CoreBlocks.RAW_NICKEL_BLOCK.get());
        items.add(CoreBlocks.NICKEL_BLOCK.get());
        items.add(CoreItems.NICKEL_DUST.get());
        items.add(CoreItems.NICKEL_NUGGET.get());
        items.add(CoreItems.NICKEL_INGOT.get());
        items.add(CoreItems.RAW_NICKEL.get());
        items.add(CoreItems.NICKEL_GEAR.get());

        items.add(CoreBlocks.PLATINUM_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
        items.add(CoreBlocks.RAW_PLATINUM_BLOCK.get());
        items.add(CoreBlocks.PLATINUM_BLOCK.get());
        items.add(CoreItems.PLATINUM_DUST.get());
        items.add(CoreItems.PLATINUM_NUGGET.get());
        items.add(CoreItems.PLATINUM_INGOT.get());
        items.add(CoreItems.RAW_PLATINUM.get());
        items.add(CoreItems.PLATINUM_GEAR.get());

        items.add(CoreBlocks.LEAD_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_LEAD_ORE.get());
        items.add(CoreBlocks.RAW_LEAD_BLOCK.get());
        items.add(CoreBlocks.LEAD_BLOCK.get());
        items.add(CoreItems.LEAD_DUST.get());
        items.add(CoreItems.LEAD_NUGGET.get());
        items.add(CoreItems.LEAD_INGOT.get());
        items.add(CoreItems.RAW_LEAD.get());
        items.add(CoreItems.LEAD_GEAR.get());

        items.add(CoreBlocks.RUBY_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_RUBY_ORE.get());
        items.add(CoreBlocks.RUBY_BLOCK.get());
        items.add(CoreItems.RUBY.get());

        items.add(CoreBlocks.PERIDOT_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
        items.add(CoreBlocks.PERIDOT_BLOCK.get());
        items.add(CoreItems.PERIDOT.get());

        items.add(CoreBlocks.SAPPHIRE_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        items.add(CoreBlocks.SAPPHIRE_BLOCK.get());
        items.add(CoreItems.SAPPHIRE.get());

        items.add(CoreBlocks.TOPAZ_ORE.get());
        items.add(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());
        items.add(CoreBlocks.TOPAZ_BLOCK.get());
        items.add(CoreItems.TOPAZ.get());

        items.add(CoreBlocks.BRONZE_BLOCK.get());
        items.add(CoreItems.BRONZE_DUST.get());
        items.add(CoreItems.BRONZE_NUGGET.get());
        items.add(CoreItems.BRONZE_INGOT.get());
        items.add(CoreItems.BRONZE_GEAR.get());

        items.add(CoreBlocks.ELECTRUM_BLOCK.get());
        items.add(CoreItems.ELECTRUM_DUST.get());
        items.add(CoreItems.ELECTRUM_NUGGET.get());
        items.add(CoreItems.ELECTRUM_INGOT.get());
        items.add(CoreItems.ELECTRUM_GEAR.get());

        items.add(CoreBlocks.INVAR_BLOCK.get());
        items.add(CoreItems.INVAR_DUST.get());
        items.add(CoreItems.INVAR_NUGGET.get());
        items.add(CoreItems.INVAR_INGOT.get());
        items.add(CoreItems.INVAR_GEAR.get());

        items.add(CoreBlocks.STEEL_BLOCK.get());
        items.add(CoreItems.STEEL_DUST.get());
        items.add(CoreItems.STEEL_NUGGET.get());
        items.add(CoreItems.STEEL_INGOT.get());
        items.add(CoreItems.STEEL_GEAR.get());

        items.add(CoreItems.IRON_DUST.get());
        items.add(CoreItems.IRON_GEAR.get());

        items.add(CoreItems.GOLD_DUST.get());
        items.add(CoreItems.GOLD_GEAR.get());

        items.add(CoreItems.COPPER_DUST.get());
        items.add(CoreItems.COPPER_NUGGET.get());
        items.add(CoreItems.COPPER_GEAR.get());

        return items.getItems();
    }

    public static void init() {
    }
}
