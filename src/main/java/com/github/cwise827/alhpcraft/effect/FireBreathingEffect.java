package com.github.cwise827.alhpcraft.effect;

import java.util.List;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FireBreathingEffect extends MobEffect{
	private static final int FIRE_BREATHING_COLOR = 0xaa4203;

	public FireBreathingEffect(MobEffectCategory category, int color) {
		super(category, FIRE_BREATHING_COLOR);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
	    if(!entity.level().isClientSide) {
	    	
	    	ServerLevel world = (ServerLevel) entity.level();

            // Loop through the three blocks in front of the player
            for (int i = 2; i <= 4; i++) {
                
                Vec3 playerPos = entity.getEyePosition();
                Vec3 playerDirection = entity.getLookAngle();

                // Calculate the end position 4 blocks in front of the player
                Vec3 endPos = playerPos.add(playerDirection.scale(4));

                // Create an AABB (axis-aligned bounding box) for detecting entities in the path
                AABB box = new AABB(playerPos, endPos);

                // Get entities within the bounding box
                List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, box);

                for (LivingEntity targetEntity : entities) {
                    if (targetEntity != entity && targetEntity.getType() != entity.getType()) {
                        // Set the entity on fire for 5 seconds
                        targetEntity.setSecondsOnFire(5);
                    }
                }
            }
	    }
	}

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }
    
    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
    	
    }
    
    

}
