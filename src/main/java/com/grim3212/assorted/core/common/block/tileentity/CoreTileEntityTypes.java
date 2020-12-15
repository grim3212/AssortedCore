package com.grim3212.assorted.core.common.block.tileentity;

import com.google.common.collect.Sets;
import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.block.CoreBlocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AssortedCore.MODID);

	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> BASIC_ALLOY_FORGE = TILE_ENTITIES.register("basic_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::basicTileEntity, Sets.newHashSet(CoreBlocks.BASIC_ALLOY_FORGE.get()), null));
	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> INTERMEDIATE_ALLOY_FORGE = TILE_ENTITIES.register("intermediate_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::intermediateTileEntity, Sets.newHashSet(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()), null));
	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> ADVANCED_ALLOY_FORGE = TILE_ENTITIES.register("advanced_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::advancedTileEntity, Sets.newHashSet(CoreBlocks.ADVANCED_ALLOY_FORGE.get()), null));
	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> EXPERT_ALLOY_FORGE = TILE_ENTITIES.register("expert_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::expertTileEntity, Sets.newHashSet(CoreBlocks.EXPERT_ALLOY_FORGE.get()), null));

	public static final RegistryObject<TileEntityType<GrindingMillTileEntity>> BASIC_GRINDING_MILL = TILE_ENTITIES.register("basic_grinding_mill", () -> new TileEntityType<>(GrindingMillTileEntity::basicTileEntity, Sets.newHashSet(CoreBlocks.BASIC_GRINDING_MILL.get()), null));
	public static final RegistryObject<TileEntityType<GrindingMillTileEntity>> INTERMEDIATE_GRINDING_MILL = TILE_ENTITIES.register("intermediate_grinding_mill", () -> new TileEntityType<>(GrindingMillTileEntity::intermediateTileEntity, Sets.newHashSet(CoreBlocks.INTERMEDIATE_GRINDING_MILL.get()), null));
	public static final RegistryObject<TileEntityType<GrindingMillTileEntity>> ADVANCED_GRINDING_MILL = TILE_ENTITIES.register("advanced_grinding_mill", () -> new TileEntityType<>(GrindingMillTileEntity::advancedTileEntity, Sets.newHashSet(CoreBlocks.ADVANCED_GRINDING_MILL.get()), null));
	public static final RegistryObject<TileEntityType<GrindingMillTileEntity>> EXPERT_GRINDING_MILL = TILE_ENTITIES.register("expert_grinding_mill", () -> new TileEntityType<>(GrindingMillTileEntity::expertTileEntity, Sets.newHashSet(CoreBlocks.EXPERT_GRINDING_MILL.get()), null));

	public static final RegistryObject<TileEntityType<BurningGeneratorTileEntity>> BURNING_GENERATOR = TILE_ENTITIES.register("burning_generator", () -> new TileEntityType<>(BurningGeneratorTileEntity::new, Sets.newHashSet(CoreBlocks.BURNING_GENERATOR.get()), null));

	public static final RegistryObject<TileEntityType<EnergyCellTileEntity>> ENERGY_CELL = TILE_ENTITIES.register("energy_cell", () -> new TileEntityType<>(EnergyCellTileEntity::new, Sets.newHashSet(CoreBlocks.ENERGY_CELL.get()), null));
}
