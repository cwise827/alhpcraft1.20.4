package com.github.cwise827.alhpcraft.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MagmaCubeRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.MagmaCube;

public class JellyCubeRenderer extends MagmaCubeRenderer{
	private static final ResourceLocation CUSTOM_SLIME_TEXTURE = new ResourceLocation("alhpcraft", "textures/entity/jelly_cube.png");

    public JellyCubeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(MagmaCube entity) {
        return CUSTOM_SLIME_TEXTURE;
    }
    

}
