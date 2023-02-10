package com.grim3212.assorted.core.common.worldgen;

import com.google.common.collect.ImmutableList;
import com.grim3212.assorted.core.common.blocks.AssortedCoreBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class CoreWorldGenTargets {

    static RuleTest stoneOreTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    static RuleTest deepslateOreTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_NICKEL_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.NICKEL_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_NICKEL_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_LEAD_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SILVER_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PLATINUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.PLATINUM_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TOPAZ_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.TOPAZ_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_PERIDOT_TARGET_LIST = ImmutableList.of(OreConfiguration.target(stoneOreTest, AssortedCoreBlocks.PERIDOT_ORE.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, AssortedCoreBlocks.DEEPSLATE_PERIDOT_ORE.get().defaultBlockState()));

}
