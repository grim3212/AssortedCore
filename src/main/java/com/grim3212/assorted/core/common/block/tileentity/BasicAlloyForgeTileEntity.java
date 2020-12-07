package com.grim3212.assorted.core.common.block.tileentity;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BasicAlloyForgeTileEntity extends AbstractAlloyForgeTileEntity {

	public BasicAlloyForgeTileEntity() {
		super(CoreTileEntityTypes.BASIC_ALLOY_FORGE.get(), CoreRecipeTypes.ALLOY_FORGE);
	}

	@Override
	public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		return new AlloyForgeContainer(windowId, playerInventory, this, this.alloyForgeData);
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent(AssortedCore.MODID + ".container.basic_alloy_forge");
	}

}
