package com.github.cwise827.alhpcraft.entity;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.networking.ClientListener;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DerpRenderer extends MobRenderer<DerpEntity, DerpModel<DerpEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp.png");
    private static final ResourceLocation FULL_HEALTH_TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp_full_health.png");
    private static final ResourceLocation HIGH_HEALTH_TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp_high_health.png");
    private static final ResourceLocation MID_HEALTH_TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp_mid_health.png");
    private static final ResourceLocation LOW_HEALTH_TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/derp_low_health.png");

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
        if(entity.isHelpingTexture()) {
        	if (entity.getHealth() == entity.getMaxHealth()) return FULL_HEALTH_TEXTURE;
        	else if(entity.getHealth() < entity.getMaxHealth() && entity.getHealth() >= entity.getMaxHealth() * .66) return HIGH_HEALTH_TEXTURE;
        	else if (entity.getHealth() < entity.getMaxHealth() * .66 && entity.getHealth() >= entity.getMaxHealth() * .33) return MID_HEALTH_TEXTURE;
        	else if (entity.getHealth() < entity.getMaxHealth() * .33) return LOW_HEALTH_TEXTURE;
        }
    	return TEXTURE;
    }
}