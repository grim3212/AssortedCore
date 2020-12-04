package com.grim3212.assorted.core.client.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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
		simpleBlock(CoreBlocks.COPPER_ORE.get());
		simpleBlock(CoreBlocks.SILVER_ORE.get());
		simpleBlock(CoreBlocks.ALUMINUM_ORE.get());
		simpleBlock(CoreBlocks.NICKEL_ORE.get());
		simpleBlock(CoreBlocks.PLATINUM_ORE.get());
		simpleBlock(CoreBlocks.LEAD_ORE.get());
		simpleBlock(CoreBlocks.RUBY_ORE.get());
		simpleBlock(CoreBlocks.AMETHYST_ORE.get());
		simpleBlock(CoreBlocks.SAPPHIRE_ORE.get());
		simpleBlock(CoreBlocks.TOPAZ_ORE.get());
	}
}
