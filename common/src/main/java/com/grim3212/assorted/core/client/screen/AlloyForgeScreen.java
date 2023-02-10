package com.grim3212.assorted.core.client.screen;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.inventory.AlloyForgeContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlloyForgeScreen extends AbstractContainerScreen<AlloyForgeContainer> {

    private static final ResourceLocation ALLOY_FORGE_GUI_TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/gui/container/alloy_forge.png");

    public AlloyForgeScreen(AlloyForgeContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    protected void renderBg(PoseStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.clearColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, ALLOY_FORGE_GUI_TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isBurning()) {
            int k = this.menu.getBurnLeftScaled();
            this.blit(matrixStack, i + 81, j + 46 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getCookProgressionScaled();
        this.blit(matrixStack, i + 77, j + 28, 176, 14, l + 1, 16);
    }
}
