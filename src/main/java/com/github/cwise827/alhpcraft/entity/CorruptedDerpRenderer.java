package com.github.cwise827.alhpcraft.entity;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.networking.ClientListener;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CorruptedDerpRenderer extends MobRenderer<CorruptedDerpEntity, CorruptedDerpModel<CorruptedDerpEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/corrupted_derp.png");

    public CorruptedDerpRenderer(EntityRendererProvider.Context context) {
        super(context, new CorruptedDerpModel(context.bakeLayer(ClientListener.CORRUPTED_DERP_LAYER)), 0.5f);
    }

    protected void scale(CorruptedDerpEntity squid, PoseStack pose, float p_116462_) {
        pose.translate(0.0f, 0f, 0.0f);
        pose.scale(.85f, .85f, .85f);
    }
    
    @Override
    public ResourceLocation getTextureLocation(CorruptedDerpEntity entity) {
        return TEXTURE;
    }
}