package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import com.grim3212.assorted.core.common.blocks.BaseMachineBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreBlockstateProvider extends BlockStateProvider {

    public CoreBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    private static String name(Block i) {
        return ForgeRegistries.BLOCKS.getKey(i).getPath();
    }

    public ExistingFileHelper getExistingFileHelper() {
        return this.models().existingFileHelper;
    }

    @Override
    public String getName() {
        return "Assorted Core block states";
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(AssortedCoreBlocks.TIN_ORE.get());
        simpleBlock(AssortedCoreBlocks.SILVER_ORE.get());
        simpleBlock(AssortedCoreBlocks.ALUMINUM_ORE.get());
        simpleBlock(AssortedCoreBlocks.NICKEL_ORE.get());
        simpleBlock(AssortedCoreBlocks.PLATINUM_ORE.get());
        simpleBlock(AssortedCoreBlocks.LEAD_ORE.get());
        simpleBlock(AssortedCoreBlocks.RUBY_ORE.get());
        simpleBlock(AssortedCoreBlocks.PERIDOT_ORE.get());
        simpleBlock(AssortedCoreBlocks.SAPPHIRE_ORE.get());
        simpleBlock(AssortedCoreBlocks.TOPAZ_ORE.get());
        simpleBlock(AssortedCoreBlocks.TIN_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.SILVER_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.ALUMINUM_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.NICKEL_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.PLATINUM_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.LEAD_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.RUBY_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.PERIDOT_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.SAPPHIRE_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.TOPAZ_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.BRONZE_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.ELECTRUM_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.INVAR_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.STEEL_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.MACHINE_CORE.get());

        simpleBlock(AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        simpleBlock(AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

        simpleBlock(AssortedCoreBlocks.RAW_TIN_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.RAW_SILVER_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.RAW_ALUMINUM_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.RAW_NICKEL_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.RAW_PLATINUM_BLOCK.get());
        simpleBlock(AssortedCoreBlocks.RAW_LEAD_BLOCK.get());

        machine(AssortedCoreBlocks.BASIC_ALLOY_FORGE.get(), MachineTier.BASIC);
        machine(AssortedCoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), MachineTier.INTERMEDIATE);
        machine(AssortedCoreBlocks.ADVANCED_ALLOY_FORGE.get(), MachineTier.ADVANCED);
        machine(AssortedCoreBlocks.EXPERT_ALLOY_FORGE.get(), MachineTier.EXPERT);

        machine(AssortedCoreBlocks.BASIC_GRINDING_MILL.get(), MachineTier.BASIC);
        machine(AssortedCoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), MachineTier.INTERMEDIATE);
        machine(AssortedCoreBlocks.ADVANCED_GRINDING_MILL.get(), MachineTier.ADVANCED);
        machine(AssortedCoreBlocks.EXPERT_GRINDING_MILL.get(), MachineTier.EXPERT);
    }

    private void machine(Block b, MachineTier tier) {
        String name = name(b);

        ModelFile machineOff = models().orientable(name, loc("block/" + tier.getName() + "_machine_side"), loc("block/" + name + "_front"), loc("block/" + tier.getName() + "_machine_top"));
        ModelFile machineOn = models().orientable(name + "_on", loc("block/" + tier.getName() + "_machine_side"), loc("block/" + name + "_front_on"), loc("block/" + tier.getName() + "_machine_top"));

        getVariantBuilder(b).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(BaseMachineBlock.ON) ? machineOn : machineOff).rotationY((int) state.getValue(BaseMachineBlock.FACING).getOpposite().toYRot()).build());
    }

    private ResourceLocation loc(String name) {
        return new ResourceLocation(Constants.MOD_ID, name);
    }

}
