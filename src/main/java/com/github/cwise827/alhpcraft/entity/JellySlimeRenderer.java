package com.github.cwise827.alhpcraft.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Slime;

public class JellySlimeRenderer extends SlimeRenderer{
	private static final ResourceLocation CUSTOM_SLIME_TEXTURE = new ResourceLocation("alhpcraft", "textures/entity/jelly_slime.png");

    public JellySlimeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Slime entity) {
        return CUSTOM_SLIME_TEXTURE;
    }
    

}
