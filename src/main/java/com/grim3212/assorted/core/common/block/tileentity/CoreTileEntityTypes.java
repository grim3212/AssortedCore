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

	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> BASIC_ALLOY_FORGE = TILE_ENTITIES.register("basic_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::basicAlloyForgeTileEntity, Sets.newHashSet(CoreBlocks.BASIC_ALLOY_FORGE.get()), null));
	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> INTERMEDIATE_ALLOY_FORGE = TILE_ENTITIES.register("intermediate_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::intermediateAlloyForgeTileEntity, Sets.newHashSet(CoreBlocks.INTERMEDIATE_ALLOY_FORGE.get()), null));
	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> ADVANCED_ALLOY_FORGE = TILE_ENTITIES.register("advanced_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::advancedAlloyForgeTileEntity, Sets.newHashSet(CoreBlocks.ADVANCED_ALLOY_FORGE.get()), null));
	public static final RegistryObject<TileEntityType<AlloyForgeTileEntity>> EXPERT_ALLOY_FORGE = TILE_ENTITIES.register("expert_alloy_forge", () -> new TileEntityType<>(AlloyForgeTileEntity::expertAlloyForgeTileEntity, Sets.newHashSet(CoreBlocks.EXPERT_ALLOY_FORGE.get()), null));
}
