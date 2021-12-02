package com.grim3212.assorted.core.common.block.blockentity;

import com.google.common.collect.Sets;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreBlockEntityTypes {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, AssortedCore.MODID);

	public static final RegistryObject<BlockEntityType<AlloyForgeBlockEntity>> BASIC_ALLOY_FORGE = BLOCK_ENTITIES.register("basic_alloy_forge", () -> new BlockEntityType<>(AlloyForgeBlockEntity::basicBlockEntity, Sets.newHashSet(CoreBlocks.BASIC_ALLOY_FORGE.get()), null));
	public static final RegistryObject<BlockEntityType<AlloyForgeBlockEntity>> INTERMEDIATE_ALLOY_FORGE = BLOCK_ENTITIES.register("intermediate_alloy_forge", () -> new BlockEntityType<>(AlloyForgeBlockEntity::intermediateBlockEntity, Sets.newHashSet(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()), null));
	public static final RegistryObject<BlockEntityType<AlloyForgeBlockEntity>> ADVANCED_ALLOY_FORGE = BLOCK_ENTITIES.register("advanced_alloy_forge", () -> new BlockEntityType<>(AlloyForgeBlockEntity::advancedBlockEntity, Sets.newHashSet(CoreBlocks.ADVANCED_ALLOY_FORGE.get()), null));
	public static final RegistryObject<BlockEntityType<AlloyForgeBlockEntity>> EXPERT_ALLOY_FORGE = BLOCK_ENTITIES.register("expert_alloy_forge", () -> new BlockEntityType<>(AlloyForgeBlockEntity::expertBlockEntity, Sets.newHashSet(CoreBlocks.EXPERT_ALLOY_FORGE.get()), null));

	public static final RegistryObject<BlockEntityType<GrindingMillBlockEntity>> BASIC_GRINDING_MILL = BLOCK_ENTITIES.register("basic_grinding_mill", () -> new BlockEntityType<>(GrindingMillBlockEntity::basicBlockEntity, Sets.newHashSet(CoreBlocks.BASIC_GRINDING_MILL.get()), null));
	public static final RegistryObject<BlockEntityType<GrindingMillBlockEntity>> INTERMEDIATE_GRINDING_MILL = BLOCK_ENTITIES.register("intermediate_grinding_mill", () -> new BlockEntityType<>(GrindingMillBlockEntity::intermediateBlockEntity, Sets.newHashSet(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()), null));
	public static final RegistryObject<BlockEntityType<GrindingMillBlockEntity>> ADVANCED_GRINDING_MILL = BLOCK_ENTITIES.register("advanced_grinding_mill", () -> new BlockEntityType<>(GrindingMillBlockEntity::advancedBlockEntity, Sets.newHashSet(CoreBlocks.ADVANCED_GRINDING_MILL.get()), null));
	public static final RegistryObject<BlockEntityType<GrindingMillBlockEntity>> EXPERT_GRINDING_MILL = BLOCK_ENTITIES.register("expert_grinding_mill", () -> new BlockEntityType<>(GrindingMillBlockEntity::expertBlockEntity, Sets.newHashSet(CoreBlocks.EXPERT_GRINDING_MILL.get()), null));
}
