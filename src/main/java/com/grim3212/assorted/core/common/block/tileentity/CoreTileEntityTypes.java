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

	public static final RegistryObject<TileEntityType<AbstractAlloyForgeTileEntity>> BASIC_ALLOY_FORGE = TILE_ENTITIES.register("basic_alloy_forge", () -> new TileEntityType<>(BasicAlloyForgeTileEntity::new, Sets.newHashSet(CoreBlocks.BASIC_ALLOY_FORGE.get()), null));
}
