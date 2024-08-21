package com.github.cwise827.alhpcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class GentleFallingEffect extends MobEffect{
	
	private static final int GENTLE_FALLING_COLOR = 0xb69231;

	
	public GentleFallingEffect(MobEffectCategory category, int color) {
		super(category, GENTLE_FALLING_COLOR);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if (entity.fallDistance > 0) {
            entity.fallDistance = 0.0F;
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
