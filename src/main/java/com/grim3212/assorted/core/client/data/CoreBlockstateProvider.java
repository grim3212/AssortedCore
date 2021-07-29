package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.block.BaseMachineBlock;
import com.grim3212.assorted.core.common.block.CoreBlocks;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CoreBlockstateProvider extends BlockStateProvider {

	public CoreBlockstateProvider(DataGenerator generator, ExistingFileHelper exFileHelper) {
		super(generator, AssortedCore.MODID, exFileHelper);
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
		simpleBlock(CoreBlocks.TIN_ORE.get());
		simpleBlock(CoreBlocks.SILVER_ORE.get());
		simpleBlock(CoreBlocks.ALUMINUM_ORE.get());
		simpleBlock(CoreBlocks.NICKEL_ORE.get());
		simpleBlock(CoreBlocks.PLATINUM_ORE.get());
		simpleBlock(CoreBlocks.LEAD_ORE.get());
		simpleBlock(CoreBlocks.RUBY_ORE.get());
		simpleBlock(CoreBlocks.PERIDOT_ORE.get());
		simpleBlock(CoreBlocks.SAPPHIRE_ORE.get());
		simpleBlock(CoreBlocks.TOPAZ_ORE.get());
		simpleBlock(CoreBlocks.TIN_BLOCK.get());
		simpleBlock(CoreBlocks.SILVER_BLOCK.get());
		simpleBlock(CoreBlocks.ALUMINUM_BLOCK.get());
		simpleBlock(CoreBlocks.NICKEL_BLOCK.get());
		simpleBlock(CoreBlocks.PLATINUM_BLOCK.get());
		simpleBlock(CoreBlocks.LEAD_BLOCK.get());
		simpleBlock(CoreBlocks.RUBY_BLOCK.get());
		simpleBlock(CoreBlocks.PERIDOT_BLOCK.get());
		simpleBlock(CoreBlocks.SAPPHIRE_BLOCK.get());
		simpleBlock(CoreBlocks.TOPAZ_BLOCK.get());
		simpleBlock(CoreBlocks.BRONZE_BLOCK.get());
		simpleBlock(CoreBlocks.ELECTRUM_BLOCK.get());
		simpleBlock(CoreBlocks.INVAR_BLOCK.get());
		simpleBlock(CoreBlocks.STEEL_BLOCK.get());
		simpleBlock(CoreBlocks.MACHINE_CORE.get());

		simpleBlock(CoreBlocks.DEEPSLATE_TIN_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_SILVER_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_NICKEL_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_PLATINUM_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_LEAD_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_RUBY_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_PERIDOT_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
		simpleBlock(CoreBlocks.DEEPSLATE_TOPAZ_ORE.get());

		simpleBlock(CoreBlocks.RAW_TIN_BLOCK.get());
		simpleBlock(CoreBlocks.RAW_SILVER_BLOCK.get());
		simpleBlock(CoreBlocks.RAW_ALUMINUM_BLOCK.get());
		simpleBlock(CoreBlocks.RAW_NICKEL_BLOCK.get());
		simpleBlock(CoreBlocks.RAW_PLATINUM_BLOCK.get());
		simpleBlock(CoreBlocks.RAW_LEAD_BLOCK.get());

		machine(CoreBlocks.BASIC_ALLOY_FORGE.get(), MachineTier.BASIC);
		machine(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get(), MachineTier.INTERMEDIATE);
		machine(CoreBlocks.ADVANCED_ALLOY_FORGE.get(), MachineTier.ADVANCED);
		machine(CoreBlocks.EXPERT_ALLOY_FORGE.get(), MachineTier.EXPERT);

		machine(CoreBlocks.BASIC_GRINDING_MILL.get(), MachineTier.BASIC);
		machine(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get(), MachineTier.INTERMEDIATE);
		machine(CoreBlocks.ADVANCED_GRINDING_MILL.get(), MachineTier.ADVANCED);
		machine(CoreBlocks.EXPERT_GRINDING_MILL.get(), MachineTier.EXPERT);
	}

	private void machine(Block b, MachineTier tier) {
		String name = name(b);

		ModelFile machineOff = models().orientable(name, loc("block/" + tier.getName() + "_machine_side"), loc("block/" + name + "_front"), loc("block/" + tier.getName() + "_machine_top"));
		ModelFile machineOn = models().orientable(name + "_on", loc("block/" + tier.getName() + "_machine_side"), loc("block/" + name + "_front_on"), loc("block/" + tier.getName() + "_machine_top"));

		getVariantBuilder(b).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(BaseMachineBlock.ON) ? machineOn : machineOff).rotationY((int) state.getValue(BaseMachineBlock.FACING).getOpposite().toYRot()).build());
	}

	private ResourceLocation loc(String name) {
		return new ResourceLocation(AssortedCore.MODID, name);
	}

	private static String name(Block i) {
		return Registry.BLOCK.getKey(i).getPath();
	}

}
