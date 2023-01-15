package com.grim3212.assorted.core.common.gen;

import com.google.common.collect.ImmutableList;
import com.grim3212.assorted.core.common.block.CoreBlocks;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class CoreWorldGenTargets {

	static RuleTest stoneOreTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
	static RuleTest deepslateOreTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_NICKEL_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_LEAD_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SILVER_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PLATINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TOPAZ_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));
	public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PERIDOT_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, CoreBlocks.PERIDOT_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, CoreBlocks.DEEPSLATE_PERIDOT_ORE.get().defaultBlockState()));

}
