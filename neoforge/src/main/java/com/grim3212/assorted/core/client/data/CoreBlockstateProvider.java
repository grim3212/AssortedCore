package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.blocks.BaseMachineBlock;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

/**
 * Block states and block models. This owns every block and block item; {@link
 * CoreItemModelProvider} owns the rest, so the two never write the same file.
 */
public class CoreBlockstateProvider extends ModelProvider {

    public CoreBlockstateProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    private static String name(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b).getPath();
    }

    @Override
    public String getName() {
        return "Assorted Core block states";
    }

    /**
     * Only the block items belong here; every other item is {@link CoreItemModelProvider}'s, so the
     * two providers never write the same file.
     */
    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return super.getKnownItems().filter(holder -> holder.value() instanceof BlockItem);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(CoreBlocks.TIN_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.SILVER_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.ALUMINUM_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.NICKEL_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.PLATINUM_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.LEAD_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.RUBY_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.PERIDOT_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.SAPPHIRE_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.TOPAZ_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.TIN_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.SILVER_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.ALUMINUM_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.NICKEL_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.PLATINUM_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.LEAD_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.RUBY_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.PERIDOT_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.SAPPHIRE_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.TOPAZ_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.BRONZE_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.ELECTRUM_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.INVAR_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.STEEL_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.MACHINE_CORE.get());

        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_TIN_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_SILVER_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_NICKEL_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_LEAD_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_RUBY_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        blockModels.createTrivialCube(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

        blockModels.createTrivialCube(CoreBlocks.RAW_TIN_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.RAW_SILVER_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.RAW_NICKEL_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.RAW_PLATINUM_BLOCK.get());
        blockModels.createTrivialCube(CoreBlocks.RAW_LEAD_BLOCK.get());

        machine(blockModels, CoreBlocks.BASIC_ALLOY_FORGE.get(), MachineTier.BASIC);
        machine(blockModels, CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), MachineTier.INTERMEDIATE);
        machine(blockModels, CoreBlocks.ADVANCED_ALLOY_FORGE.get(), MachineTier.ADVANCED);
        machine(blockModels, CoreBlocks.EXPERT_ALLOY_FORGE.get(), MachineTier.EXPERT);

        machine(blockModels, CoreBlocks.BASIC_GRINDING_MILL.get(), MachineTier.BASIC);
        machine(blockModels, CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), MachineTier.INTERMEDIATE);
        machine(blockModels, CoreBlocks.ADVANCED_GRINDING_MILL.get(), MachineTier.ADVANCED);
        machine(blockModels, CoreBlocks.EXPERT_GRINDING_MILL.get(), MachineTier.EXPERT);
    }

    /**
     * A machine, rotated to its {@code FACING} with {@link
     * BlockModelGenerators#ROTATION_HORIZONTAL_FACING}.
     */
    private void machine(BlockModelGenerators blockModels, Block b, MachineTier tier) {
        String name = name(b);
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.SIDE, texture("block/" + tier.getName() + "_machine_side"))
                .put(TextureSlot.TOP, texture("block/" + tier.getName() + "_machine_top"))
                .put(TextureSlot.FRONT, texture("block/" + name + "_front"));

        MultiVariant machineOff = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ORIENTABLE.create(b, textures, blockModels.modelOutput));
        MultiVariant machineOn = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ORIENTABLE.createWithSuffix(b, "_on", textures.copyAndUpdate(TextureSlot.FRONT, texture("block/" + name + "_front_on")), blockModels.modelOutput));

        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(b)
                .with(BlockModelGenerators.createBooleanModelDispatch(BaseMachineBlock.ON, machineOn, machineOff))
                .with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
    }

    private Material texture(String name) {
        return new Material(Identifier.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

}
