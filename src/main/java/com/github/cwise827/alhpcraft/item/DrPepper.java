package com.github.cwise827.alhpcraft.item;


import com.github.cwise827.alhpcraft.sounds.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;


public class DrPepper extends Item{
	
	
	public DrPepper(Item.Properties properties) {
        super(properties);
    }
	
	@Override
	public SoundEvent getEatingSound() {
        return ModSounds.DR_PEPPER_DRINK.get();
    }

	
}
