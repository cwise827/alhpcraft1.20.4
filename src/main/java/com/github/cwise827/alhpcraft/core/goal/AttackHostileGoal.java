package com.github.cwise827.alhpcraft.core.goal;

import java.util.EnumSet;
import java.util.List;

import com.github.cwise827.alhpcraft.entity.DerpEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;

public class AttackHostileGoal extends Goal{
	private final Animal animal;
    private LivingEntity target;

    public AttackHostileGoal(Animal animal) {
        this.animal = animal;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Find a hostile entity within range
        if (animal instanceof DerpEntity derpEntity) {
        	if(!derpEntity.isHelping()) return false;
        }
    	List<Monster> hostiles = animal.level().getEntitiesOfClass(Monster.class, animal.getBoundingBox().inflate(10.0));
        if (hostiles.isEmpty()) {
            return false;
        }
        this.target = hostiles.stream()
                .min((e1, e2) -> Double.compare(animal.distanceToSqr(e1), animal.distanceToSqr(e2)))
                .orElse(null);

        return this.target != null && this.target.isAlive() && !this.target.isUnderWater();
    }

    @Override
    public void tick() {
    	if (animal instanceof DerpEntity derpEntity) {
    		if (derpEntity.isHelping()) {
    			if (this.target != null) {
    	            // Move towards the target
    	            this.animal.getNavigation().moveTo(this.target, 1.3);
    	            this.animal.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

    	            // Attack logic
    	            if (this.animal.distanceToSqr(this.target) < 1.5 * 1.5 && !this.target.isUnderWater()) {
    	                this.attackTarget();
    	                this.target.knockback(1, this.animal.getX() - this.target.getX(), this.animal.getZ() - this.target.getZ());
    	            }
    	        }
    		}
    	}
    }

    @Override
    public boolean canContinueToUse() {
        return this.target != null && this.target.isAlive() && !this.target.isDeadOrDying() && !this.target.isUnderWater() && super.canContinueToUse();
    }

    @Override
    public void stop() {
        this.target = null;
        this.animal.getNavigation().stop();
    }

    private void attackTarget() {
    	this.target.hurt(animal.damageSources().mobAttack(animal), 8.0F);
    }
}
