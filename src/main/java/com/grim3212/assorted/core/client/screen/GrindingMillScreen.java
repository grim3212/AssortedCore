package com.grim3212.assorted.core.client.screen;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GrindingMillScreen extends ContainerScreen<GrindingMillContainer> {

	private static final ResourceLocation GRINDING_MILL_GUI_TEXTURE = new ResourceLocation(AssortedCore.MODID, "textures/gui/container/grinding_mill.png");

	public GrindingMillScreen(GrindingMillContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(GRINDING_MILL_GUI_TEXTURE);
		int i = this.leftPos;
		int j = this.topPos;
		this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
		if (this.menu.isBurning()) {
			int k = this.menu.getBurnLeftScaled();
			this.blit(matrixStack, i + 81, j + 46 + 12 - k, 176, 12 - k, 14, k + 1);
		}

		int l = this.menu.getCookProgressionScaled();
		this.blit(matrixStack, i + 77, j + 25, 176, 14, l + 1, 20);
	}
}
