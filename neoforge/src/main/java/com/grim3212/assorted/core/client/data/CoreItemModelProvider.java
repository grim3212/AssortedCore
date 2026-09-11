package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.items.CoreItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

/** Item models for everything but block items, which {@link CoreBlockstateProvider} models. */
public class CoreItemModelProvider extends ModelProvider {

    public CoreItemModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    public String getName() {
        return "Assorted Core item models";
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Stream.empty();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return super.getKnownItems().filter(holder -> !(holder.value() instanceof BlockItem));
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        generatedItem(itemModels, CoreItems.TIN_INGOT.get());
        generatedItem(itemModels, CoreItems.SILVER_INGOT.get());
        generatedItem(itemModels, CoreItems.ALUMINUM_INGOT.get());
        generatedItem(itemModels, CoreItems.NICKEL_INGOT.get());
        generatedItem(itemModels, CoreItems.PLATINUM_INGOT.get());
        generatedItem(itemModels, CoreItems.LEAD_INGOT.get());
        generatedItem(itemModels, CoreItems.BRONZE_INGOT.get());
        generatedItem(itemModels, CoreItems.ELECTRUM_INGOT.get());
        generatedItem(itemModels, CoreItems.INVAR_INGOT.get());
        generatedItem(itemModels, CoreItems.STEEL_INGOT.get());

        generatedItem(itemModels, CoreItems.RAW_TIN.get());
        generatedItem(itemModels, CoreItems.RAW_SILVER.get());
        generatedItem(itemModels, CoreItems.RAW_ALUMINUM.get());
        generatedItem(itemModels, CoreItems.RAW_NICKEL.get());
        generatedItem(itemModels, CoreItems.RAW_PLATINUM.get());
        generatedItem(itemModels, CoreItems.RAW_LEAD.get());

        generatedItem(itemModels, CoreItems.TIN_NUGGET.get());
        generatedItem(itemModels, CoreItems.COPPER_NUGGET.get());
        generatedItem(itemModels, CoreItems.SILVER_NUGGET.get());
        generatedItem(itemModels, CoreItems.ALUMINUM_NUGGET.get());
        generatedItem(itemModels, CoreItems.NICKEL_NUGGET.get());
        generatedItem(itemModels, CoreItems.PLATINUM_NUGGET.get());
        generatedItem(itemModels, CoreItems.LEAD_NUGGET.get());
        generatedItem(itemModels, CoreItems.BRONZE_NUGGET.get());
        generatedItem(itemModels, CoreItems.ELECTRUM_NUGGET.get());
        generatedItem(itemModels, CoreItems.INVAR_NUGGET.get());
        generatedItem(itemModels, CoreItems.STEEL_NUGGET.get());

        generatedItem(itemModels, CoreItems.TIN_DUST.get());
        generatedItem(itemModels, CoreItems.COPPER_DUST.get());
        generatedItem(itemModels, CoreItems.SILVER_DUST.get());
        generatedItem(itemModels, CoreItems.ALUMINUM_DUST.get());
        generatedItem(itemModels, CoreItems.NICKEL_DUST.get());
        generatedItem(itemModels, CoreItems.PLATINUM_DUST.get());
        generatedItem(itemModels, CoreItems.LEAD_DUST.get());
        generatedItem(itemModels, CoreItems.BRONZE_DUST.get());
        generatedItem(itemModels, CoreItems.ELECTRUM_DUST.get());
        generatedItem(itemModels, CoreItems.INVAR_DUST.get());
        generatedItem(itemModels, CoreItems.STEEL_DUST.get());
        generatedItem(itemModels, CoreItems.IRON_DUST.get());
        generatedItem(itemModels, CoreItems.GOLD_DUST.get());

        generatedItem(itemModels, CoreItems.TIN_GEAR.get());
        generatedItem(itemModels, CoreItems.COPPER_GEAR.get());
        generatedItem(itemModels, CoreItems.SILVER_GEAR.get());
        generatedItem(itemModels, CoreItems.ALUMINUM_GEAR.get());
        generatedItem(itemModels, CoreItems.NICKEL_GEAR.get());
        generatedItem(itemModels, CoreItems.PLATINUM_GEAR.get());
        generatedItem(itemModels, CoreItems.LEAD_GEAR.get());
        generatedItem(itemModels, CoreItems.BRONZE_GEAR.get());
        generatedItem(itemModels, CoreItems.ELECTRUM_GEAR.get());
        generatedItem(itemModels, CoreItems.INVAR_GEAR.get());
        generatedItem(itemModels, CoreItems.STEEL_GEAR.get());
        generatedItem(itemModels, CoreItems.IRON_GEAR.get());
        generatedItem(itemModels, CoreItems.GOLD_GEAR.get());

        generatedItem(itemModels, CoreItems.RUBY.get());
        generatedItem(itemModels, CoreItems.PERIDOT.get());
        generatedItem(itemModels, CoreItems.SAPPHIRE.get());
        generatedItem(itemModels, CoreItems.TOPAZ.get());
    }

    private void generatedItem(ItemModelGenerators itemModels, Item i) {
        itemModels.generateFlatItem(i, ModelTemplates.FLAT_ITEM);
    }
}
