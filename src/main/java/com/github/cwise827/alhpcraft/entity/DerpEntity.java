package com.github.cwise827.alhpcraft.entity;


import java.util.Set;

import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.item.FabricEdge;
import com.github.cwise827.alhpcraft.sounds.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class DerpEntity extends Animal {
	
	private static final Set<Item> BREEDING_ITEMS = Set.of(
		    ItemInit.CHICKEN_SANDWICH.get(),
		    ItemInit.SPICY_CHICKEN_SANDWICH.get()
		);
	
	public DerpEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
        this.setHealth(30F);
    }
	
	protected void registerGoals() {
        this.goalSelector.addGoal(3, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(4, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25D, Ingredient.of(
                ItemInit.FABRIC_EDGE_WHITE.get(),
                ItemInit.FABRIC_EDGE_ORANGE.get(),
                ItemInit.FABRIC_EDGE_MAGENTA.get(),
                ItemInit.FABRIC_EDGE_LIGHT_BLUE.get(),
                ItemInit.FABRIC_EDGE_YELLOW.get(),
                ItemInit.FABRIC_EDGE_LIME.get(),
                ItemInit.FABRIC_EDGE_PINK.get(),
                ItemInit.FABRIC_EDGE_GRAY.get(),
                ItemInit.FABRIC_EDGE_LIGHT_GRAY.get(),
                ItemInit.FABRIC_EDGE_CYAN.get(),
                ItemInit.FABRIC_EDGE_PURPLE.get(),
                ItemInit.FABRIC_EDGE_BLUE.get(),
                ItemInit.FABRIC_EDGE_BROWN.get(),
                ItemInit.FABRIC_EDGE_GREEN.get(),
                ItemInit.FABRIC_EDGE_RED.get(),
                ItemInit.FABRIC_EDGE_BLACK.get(),
                ItemInit.CHICKEN_SANDWICH.get(),
                ItemInit.SPICY_CHICKEN_SANDWICH.get(),
                ItemInit.WAFFLE_FRIES.get()
            ), false));
        this.goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(6, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0));
	}

	private void pickUpItems() {
        AABB aabb = this.getBoundingBox().inflate(1.0D);
        for (ItemEntity itemEntity : this.level().getEntitiesOfClass(ItemEntity.class, aabb)) {
            if (this.canTakeItem(itemEntity)) {
                ItemStack itemStack = itemEntity.getItem();
                this.onItemPickup(itemEntity);
                itemEntity.discard();
            }
        }
    }
	
	private boolean canTakeItem(ItemEntity itemEntity) {
		ItemStack itemStack = itemEntity.getItem();
		
		if(itemStack.getItem() instanceof FabricEdge || itemStack.getItem() == ItemInit.CHICKEN_SANDWICH.get() 
			|| itemStack.getItem() == ItemInit.SPICY_CHICKEN_SANDWICH.get() || itemStack.getItem() == ItemInit.WAFFLE_FRIES.get()) {
			return true;
		}
		return false;
	}
	
	public SoundEvent getAmbientSound() {
        return ModSounds.DERP_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.DERP_HURT.get();
    }

    public SoundEvent getDeathSound() {
        return ModSounds.DERP_DEATH.get();
    }
	
	@Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (result && source.getDirectEntity() instanceof Player player) {
            this.knockback(1F, player.getX() - this.getX(), player.getZ() - this.getZ());
        }

        return result;
    }

	public ResourceLocation getDefaultLootTable() {
        return new ResourceLocation("alhpcraft", "entities/derp");
    }
	
	public MobType getMobType() {
        return MobType.UNDEFINED;
    }
    
    public static AttributeSupplier.Builder setCustomAttributes() {
        return Monster.createMobAttributes()
        		.add(Attributes.MAX_HEALTH, 24.0)
        		.add(Attributes.MOVEMENT_SPEED, 0.3)
        		.add(Attributes.KNOCKBACK_RESISTANCE, 0.8)
        		.add(Attributes.FOLLOW_RANGE, 50.0);
    }
    
    @Override
    public boolean isFood(ItemStack stack) {
        return BREEDING_ITEMS.contains(stack.getItem());
    }


	@Override
	public DerpEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
	    return EntityInit.DERP.get().create(pLevel);
	}

	@Override
	public boolean canMate(Animal otherAnimal) {
		if (this == otherAnimal) return false;
	    if (!(otherAnimal instanceof DerpEntity)) return false;
	    return this.isInLove() && otherAnimal.isInLove();
	} 
}

