package com.github.cwise827.alhpcraft.entity;

import com.github.cwise827.alhpcraft.core.init.ParticleInit;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class JellyCubeEntity extends MagmaCube{

	public JellyCubeEntity(EntityType<? extends MagmaCube> type, Level level) {
		super(type, level);
	}
	
	public ResourceLocation getDefaultLootTable() {
        return new ResourceLocation("alhpcraft", "entities/jelly_cube");
    }
	
	public static AttributeSupplier.Builder setCustomAttributes() {
        return LivingEntity.createLivingAttributes()
            .add(Attributes.MAX_HEALTH, 30.0)
            .add(Attributes.ATTACK_DAMAGE, 7.0)
            .add(Attributes.MOVEMENT_SPEED, 0.6)
            .add(Attributes.FOLLOW_RANGE, 16.0)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.4);
    }
	
	@Override
	public ParticleOptions getParticleType() {
	    return ParticleInit.JELLY_CUBE_PARTICLE.get();
	}
	
}
