package com.github.cwise827.alhpcraft.entity;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.networking.ClientListener;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DerpRenderer extends MobRenderer<DerpEntity, DerpModel<DerpEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp.png");
    private static final ResourceLocation HELPING_TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp_helping.png");

    public DerpRenderer(EntityRendererProvider.Context context) {
        super(context, new DerpModel(context.bakeLayer(ClientListener.DERP_LAYER)), 0.5f);
    }
    
    @Override
    protected void scale(DerpEntity derp, PoseStack pose, float partialTickTime) {
        if (derp.isBaby()) {
            pose.scale(0.42F, 0.42F, 0.42F); // Adjust these values to your preference
        }else {
        	pose.scale(.85f,  .85f,  .85f);
        }
        super.scale(derp, pose, partialTickTime);
    }
    
    @Override
    public ResourceLocation getTextureLocation(DerpEntity entity) {
        return entity.isHelpingTexture() ? HELPING_TEXTURE : TEXTURE;
    }
}