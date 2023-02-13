package com.grim3212.assorted.core.common.creative;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.items.CoreItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class CoreCreativeTab {

    public static void registerTabs(final CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(Constants.MOD_ID, "tab"), builder -> builder.title(Component.translatable("itemGroup.assortedcore.tab")).icon(() -> new ItemStack(CoreBlocks.PLATINUM_ORE.get())).displayItems((enabledFlags, populator, hasPermissions) -> {
            populator.accept(CoreBlocks.BASIC_GRINDING_MILL.get());
            populator.accept(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get());
            populator.accept(CoreBlocks.ADVANCED_GRINDING_MILL.get());
            populator.accept(CoreBlocks.EXPERT_GRINDING_MILL.get());

            populator.accept(CoreBlocks.BASIC_ALLOY_FORGE.get());
            populator.accept(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get());
            populator.accept(CoreBlocks.ADVANCED_ALLOY_FORGE.get());
            populator.accept(CoreBlocks.EXPERT_ALLOY_FORGE.get());

            populator.accept(CoreBlocks.MACHINE_CORE.get());

            populator.accept(CoreBlocks.TIN_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_TIN_ORE.get());
            populator.accept(CoreBlocks.RAW_TIN_BLOCK.get());
            populator.accept(CoreBlocks.TIN_BLOCK.get());
            populator.accept(CoreItems.TIN_DUST.get());
            populator.accept(CoreItems.TIN_NUGGET.get());
            populator.accept(CoreItems.TIN_INGOT.get());
            populator.accept(CoreItems.RAW_TIN.get());
            populator.accept(CoreItems.TIN_GEAR.get());

            populator.accept(CoreBlocks.SILVER_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_SILVER_ORE.get());
            populator.accept(CoreBlocks.RAW_SILVER_BLOCK.get());
            populator.accept(CoreBlocks.SILVER_BLOCK.get());
            populator.accept(CoreItems.SILVER_DUST.get());
            populator.accept(CoreItems.SILVER_NUGGET.get());
            populator.accept(CoreItems.SILVER_INGOT.get());
            populator.accept(CoreItems.RAW_SILVER.get());
            populator.accept(CoreItems.SILVER_GEAR.get());

            populator.accept(CoreBlocks.ALUMINUM_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
            populator.accept(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
            populator.accept(CoreBlocks.ALUMINUM_BLOCK.get());
            populator.accept(CoreItems.ALUMINUM_DUST.get());
            populator.accept(CoreItems.ALUMINUM_NUGGET.get());
            populator.accept(CoreItems.ALUMINUM_INGOT.get());
            populator.accept(CoreItems.RAW_ALUMINUM.get());
            populator.accept(CoreItems.ALUMINUM_GEAR.get());

            populator.accept(CoreBlocks.NICKEL_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_NICKEL_ORE.get());
            populator.accept(CoreBlocks.RAW_NICKEL_BLOCK.get());
            populator.accept(CoreBlocks.NICKEL_BLOCK.get());
            populator.accept(CoreItems.NICKEL_DUST.get());
            populator.accept(CoreItems.NICKEL_NUGGET.get());
            populator.accept(CoreItems.NICKEL_INGOT.get());
            populator.accept(CoreItems.RAW_NICKEL.get());
            populator.accept(CoreItems.NICKEL_GEAR.get());

            populator.accept(CoreBlocks.PLATINUM_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
            populator.accept(CoreBlocks.RAW_PLATINUM_BLOCK.get());
            populator.accept(CoreBlocks.PLATINUM_BLOCK.get());
            populator.accept(CoreItems.PLATINUM_DUST.get());
            populator.accept(CoreItems.PLATINUM_NUGGET.get());
            populator.accept(CoreItems.PLATINUM_INGOT.get());
            populator.accept(CoreItems.RAW_PLATINUM.get());
            populator.accept(CoreItems.PLATINUM_GEAR.get());

            populator.accept(CoreBlocks.LEAD_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_LEAD_ORE.get());
            populator.accept(CoreBlocks.RAW_LEAD_BLOCK.get());
            populator.accept(CoreBlocks.LEAD_BLOCK.get());
            populator.accept(CoreItems.LEAD_DUST.get());
            populator.accept(CoreItems.LEAD_NUGGET.get());
            populator.accept(CoreItems.LEAD_INGOT.get());
            populator.accept(CoreItems.RAW_LEAD.get());
            populator.accept(CoreItems.LEAD_GEAR.get());

            populator.accept(CoreBlocks.RUBY_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_RUBY_ORE.get());
            populator.accept(CoreBlocks.RUBY_BLOCK.get());
            populator.accept(CoreItems.RUBY.get());

            populator.accept(CoreBlocks.PERIDOT_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
            populator.accept(CoreBlocks.PERIDOT_BLOCK.get());
            populator.accept(CoreItems.PERIDOT.get());

            populator.accept(CoreBlocks.SAPPHIRE_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
            populator.accept(CoreBlocks.SAPPHIRE_BLOCK.get());
            populator.accept(CoreItems.SAPPHIRE.get());

            populator.accept(CoreBlocks.TOPAZ_ORE.get());
            populator.accept(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());
            populator.accept(CoreBlocks.TOPAZ_BLOCK.get());
            populator.accept(CoreItems.TOPAZ.get());

            populator.accept(CoreBlocks.BRONZE_BLOCK.get());
            populator.accept(CoreItems.BRONZE_DUST.get());
            populator.accept(CoreItems.BRONZE_NUGGET.get());
            populator.accept(CoreItems.BRONZE_INGOT.get());
            populator.accept(CoreItems.BRONZE_GEAR.get());

            populator.accept(CoreBlocks.ELECTRUM_BLOCK.get());
            populator.accept(CoreItems.ELECTRUM_DUST.get());
            populator.accept(CoreItems.ELECTRUM_NUGGET.get());
            populator.accept(CoreItems.ELECTRUM_INGOT.get());
            populator.accept(CoreItems.ELECTRUM_GEAR.get());

            populator.accept(CoreBlocks.INVAR_BLOCK.get());
            populator.accept(CoreItems.INVAR_DUST.get());
            populator.accept(CoreItems.INVAR_NUGGET.get());
            populator.accept(CoreItems.INVAR_INGOT.get());
            populator.accept(CoreItems.INVAR_GEAR.get());

            populator.accept(CoreBlocks.STEEL_BLOCK.get());
            populator.accept(CoreItems.STEEL_DUST.get());
            populator.accept(CoreItems.STEEL_NUGGET.get());
            populator.accept(CoreItems.STEEL_INGOT.get());
            populator.accept(CoreItems.STEEL_GEAR.get());
        }));
    }

}
