package com.grim3212.assorted.core.client.screen;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.common.inventory.GrindingMillContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GrindingMillScreen extends AbstractContainerScreen<GrindingMillContainer> {

    private static final ResourceLocation GRINDING_MILL_GUI_TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/gui/container/grinding_mill.png");

    public GrindingMillScreen(GrindingMillContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int x, int y) {
        RenderSystem.clearColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GRINDING_MILL_GUI_TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(GRINDING_MILL_GUI_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isBurning()) {
            int k = this.menu.getBurnLeftScaled();
            guiGraphics.blit(GRINDING_MILL_GUI_TEXTURE, i + 81, j + 46 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getCookProgressionScaled();
        guiGraphics.blit(GRINDING_MILL_GUI_TEXTURE, i + 77, j + 25, 176, 14, l + 1, 20);
    }
}
