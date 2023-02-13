package com.grim3212.assorted.core.common.blocks.blockentity;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.lib.platform.Services;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import com.grim3212.assorted.lib.registry.RegistryProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CoreBlockEntityTypes {

    public static final RegistryProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistryProvider.create(Registries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);

    public static void init() {
    }

    public static final IRegistryObject<BlockEntityType<AlloyForgeBlockEntity>> BASIC_ALLOY_FORGE = BLOCK_ENTITIES.register("basic_alloy_forge", () -> Services.REGISTRY_UTIL.createBlockEntityType(AlloyForgeBlockEntity::basicBlockEntity, CoreBlocks.BASIC_ALLOY_FORGE.get()));
    public static final IRegistryObject<BlockEntityType<AlloyForgeBlockEntity>> INTERMEDIATE_ALLOY_FORGE = BLOCK_ENTITIES.register("intermediate_alloy_forge", () -> Services.REGISTRY_UTIL.createBlockEntityType(AlloyForgeBlockEntity::intermediateBlockEntity, CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()));
    public static final IRegistryObject<BlockEntityType<AlloyForgeBlockEntity>> ADVANCED_ALLOY_FORGE = BLOCK_ENTITIES.register("advanced_alloy_forge", () -> Services.REGISTRY_UTIL.createBlockEntityType(AlloyForgeBlockEntity::advancedBlockEntity, CoreBlocks.ADVANCED_ALLOY_FORGE.get()));
    public static final IRegistryObject<BlockEntityType<AlloyForgeBlockEntity>> EXPERT_ALLOY_FORGE = BLOCK_ENTITIES.register("expert_alloy_forge", () -> Services.REGISTRY_UTIL.createBlockEntityType(AlloyForgeBlockEntity::expertBlockEntity, CoreBlocks.EXPERT_ALLOY_FORGE.get()));

    public static final IRegistryObject<BlockEntityType<GrindingMillBlockEntity>> BASIC_GRINDING_MILL = BLOCK_ENTITIES.register("basic_grinding_mill", () -> Services.REGISTRY_UTIL.createBlockEntityType(GrindingMillBlockEntity::basicBlockEntity, CoreBlocks.BASIC_GRINDING_MILL.get()));
    public static final IRegistryObject<BlockEntityType<GrindingMillBlockEntity>> INTERMEDIATE_GRINDING_MILL = BLOCK_ENTITIES.register("intermediate_grinding_mill", () -> Services.REGISTRY_UTIL.createBlockEntityType(GrindingMillBlockEntity::intermediateBlockEntity, CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()));
    public static final IRegistryObject<BlockEntityType<GrindingMillBlockEntity>> ADVANCED_GRINDING_MILL = BLOCK_ENTITIES.register("advanced_grinding_mill", () -> Services.REGISTRY_UTIL.createBlockEntityType(GrindingMillBlockEntity::advancedBlockEntity, CoreBlocks.ADVANCED_GRINDING_MILL.get()));
    public static final IRegistryObject<BlockEntityType<GrindingMillBlockEntity>> EXPERT_GRINDING_MILL = BLOCK_ENTITIES.register("expert_grinding_mill", () -> Services.REGISTRY_UTIL.createBlockEntityType(GrindingMillBlockEntity::expertBlockEntity, CoreBlocks.EXPERT_GRINDING_MILL.get()));


}
