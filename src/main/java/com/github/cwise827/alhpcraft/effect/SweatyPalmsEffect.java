package com.github.cwise827.alhpcraft.effect;

import java.util.Random;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SweatyPalmsEffect extends MobEffect{
	private int timer = -2;
	private static final int SWEATY_PALMS_COLOR = 0xb8d4d6;
	Random random = new Random();
	private int randomInt = random.nextInt(25);
	private static final Logger LOGGER = LogUtils.getLogger();

	public SweatyPalmsEffect(MobEffectCategory category, int color) {
		super(category, SWEATY_PALMS_COLOR);
	}
	
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
	    if(entity instanceof Player player) {
	    	if(!player.level().isClientSide) {
	    		timer++;
	    		//LOGGER.debug("timer is " + timer);
	    		if(timer >= randomInt) {
	    			ItemStack itemStack = player.getMainHandItem();
		            if (!itemStack.isEmpty()) {
	                	player.drop(itemStack, isBeneficial());
		                player.getInventory().removeItem(player.getMainHandItem());
		            }
		            timer = -2;
	                randomInt = random.nextInt(25);
	                //LOGGER.debug("Random int is " + randomInt);
	    		}
	    	}
	    }
	}

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount % 20 == 0;
    }
    
    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
    	if(timer == -2) {
    		randomInt = random.nextInt(25);
        	timer = -2;
        	//LOGGER.debug("Random int at start is " + randomInt);
    	}
    }
}
