package com.github.cwise827.alhpcraft.entity;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.item.BallisticsJellySword;
import com.github.cwise827.alhpcraft.networking.ClientListener;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.ItemLike;


public class MrpManRenderer extends MobRenderer<MrpManEntity, MrpManModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(AlhpCraft.MODID, "textures/entity/mrp_man.png");

    public MrpManRenderer(EntityRendererProvider.Context context) {
        super(context, new MrpManModel(context.bakeLayer(ClientListener.MRP_MAN_LAYER)), 0.5f);
        //this.addLayer(new ItemInHandLayer<MrpManEntity, MrpManModel<MrpManEntity>>(this);
    }
    
    @Override
    protected void scale(MrpManEntity mrpManEntity, PoseStack pose, float partialTickTime) {
       pose.scale(1F, 1F, 1F); // Adjust these values to your preference

       super.scale(mrpManEntity, pose, partialTickTime);
    }
    
    @Override
    public void render(MrpManEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        ItemStack mainHandItem = entity.getMainHandItem();
        if (!mainHandItem.isEmpty() && mainHandItem.getItem() instanceof SwordItem) {
            Minecraft minecraft = Minecraft.getInstance();
            ItemRenderer itemRenderer = minecraft.getItemRenderer();
            
            poseStack.pushPose();
            
            Quaternionf rotation = new Quaternionf().rotationYXZ(0.0F, (float) Math.toRadians(90.0), 0.0F);
            poseStack.rotateAround(rotation, 0.0F, 0.0F, 0.0F);
            this.getModel().rightArm.translateAndRotate(poseStack);
            float yaw = entity.yBodyRotO + (entity.yBodyRot - entity.yBodyRotO) * partialTicks;
            float pitch = entity.xRotO + (entity.getXRot() - entity.xRotO) * partialTicks;
            //poseStack.mulPoseMatrix(new Matrix4f().rotationY(yaw)); // Apply yaw rotation
            //poseStack.mulPoseMatrix(new Matrix4f().rotationX(pitch)); // Apply pitch rotation

            poseStack.translate(.06F, .06F, -1.15F);
            itemRenderer.renderStatic(mainHandItem, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, entity.level(), packedLight);
            
            poseStack.popPose();
        }
    }

    
    @Override
    public ResourceLocation getTextureLocation(MrpManEntity entity) {
        return TEXTURE;
    }

}