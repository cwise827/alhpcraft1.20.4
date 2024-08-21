package com.github.cwise827.alhpcraft.entity;


import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.sounds.ModSounds;
import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MrpManEntity extends Monster {

	private static final Logger LOGGER = LogUtils.getLogger();
	public MrpManEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
	
	protected void registerGoals() {
        this.goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(1, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 16.0f));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, true));
        this.goalSelector.addGoal(4, (Goal)new MoveTowardsTargetGoal((PathfinderMob)this, 1.0, 24.0f));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(6, (Goal)new RandomLookAroundGoal((Mob)this));
    }
	
	@Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)ItemInit.BALLISTICS_JELLY_SWORD));
    }

	
	public SoundEvent getAmbientSound() {
        return ModSounds.MRP_MAN_AMBIENT.get();
    }
	
	@Override
    public void tick() {
        super.tick();
        
        LOGGER.debug("Weapon " + this.getHandSlots().toString() + " is in the slot");
	}
	
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.MRP_MAN_HURT.get();
    }

    public SoundEvent getDeathSound() {
        return ModSounds.MRP_MAN_DEATH.get();
    }
	
	@Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (result && source.getDirectEntity() instanceof Player player) {
            this.knockback(1F, player.getX() - this.getX(), player.getZ() - this.getZ());
        }

        return result;
    }
	
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnReason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
	    // Call the superclass method first
		spawnData = super.finalizeSpawn(world, difficulty, spawnReason, (SpawnGroupData) dataTag, dataTag);

	    return spawnData;
	}
	
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return super.removeWhenFarAway(distanceToClosestPlayer);
    }
	public boolean canAttackType(EntityType<?> type) {
        return true;
    }
	public ResourceLocation getDefaultLootTable() {
        return new ResourceLocation("alhpcraft", "entities/mrp_man");
    }
	
	public MobType getMobType() {
        return MobType.UNDEFINED;
    }
    
    public static AttributeSupplier.Builder setCustomAttributes() {
        return Monster.createMonsterAttributes()
        		.add(Attributes.MAX_HEALTH, 50.0)
        		.add(Attributes.MOVEMENT_SPEED, 0.35)
        		.add(Attributes.ATTACK_DAMAGE, 1.0)
        		.add(Attributes.ATTACK_SPEED, 1.0)
        		.add(Attributes.ATTACK_KNOCKBACK, 12.0)
        		.add(Attributes.KNOCKBACK_RESISTANCE, .7f)
        		.add(Attributes.FOLLOW_RANGE, 20.0);
    }
	
    public static boolean checkMrpManSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
    	boolean isPeaceful = world.getDifficulty() == Difficulty.PEACEFUL;

        if (isPeaceful) {
            return false;
        }

        return true;
    }


}

