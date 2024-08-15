package com.github.cwise827.alhpcraft.screen;

import com.github.cwise827.alhpcraft.menu.DerpBlockMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class DerpBlockScreen extends AbstractContainerScreen<DerpBlockMenu> {
    
	private static final ResourceLocation BACKGROUND_TEXTURE_LOCATION = new ResourceLocation("alhpcraft", "textures/gui/container/derp_block_gui.png");

	
	public DerpBlockScreen(DerpBlockMenu menu, Inventory inv, Component title) {
		super(menu, inv, title);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int x, int y) {
    	int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
    	graphics.blit(BACKGROUND_TEXTURE_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    
    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
    	
    }
    
    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}