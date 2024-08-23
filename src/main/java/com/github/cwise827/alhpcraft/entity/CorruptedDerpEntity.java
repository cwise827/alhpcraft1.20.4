package com.github.cwise827.alhpcraft.entity;


import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CorruptedDerpEntity extends Monster {

	 private long lastInteractionTime = -1L;
	 private static final EntityDataAccessor<Boolean> CONVERTING =
		        SynchedEntityData.defineId(CorruptedDerpEntity.class, EntityDataSerializers.BOOLEAN);
	 
	public CorruptedDerpEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
	
	protected void registerGoals() {
        this.goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, (Goal)new MoveTowardsTargetGoal((PathfinderMob)this, 0.9, 64.0f));
        this.targetSelector.addGoal(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, true));
        this.goalSelector.addGoal(4, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(5, (Goal)new RandomLookAroundGoal((Mob)this));
		this.goalSelector.addGoal(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
    }

	
	public SoundEvent getAmbientSound() {
        return ModSounds.CORRUPTED_DERP_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.CORRUPTED_DERP_HURT.get();
    }

    public SoundEvent getDeathSound() {
        return ModSounds.CORRUPTED_DERP_DEATH.get();
    }

    
	public boolean doHurtTarget(Entity entity) {
        if (!super.doHurtTarget(entity)) {
            return false;
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200), (Entity)this);
        }
        return true;
    }
	
	@Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (result && source.getDirectEntity() instanceof Player player) {
            this.knockback(1F, player.getX() - this.getX(), player.getZ() - this.getZ());
        }

        return result;
    }
	
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return super.removeWhenFarAway(distanceToClosestPlayer);
    }
	public boolean canAttackType(EntityType<?> type) {
        return true;
    }
	public ResourceLocation getDefaultLootTable() {
        return new ResourceLocation("alhpcraft", "entities/corrupted_derp");
    }
	
	public MobType getMobType() {
        return MobType.UNDEAD;
    }
	
	public static boolean isDarkEnoughToSpawn(ServerLevelAccessor world, BlockPos pos, RandomSource random) {
	    // Example check for darkness level
	    return world.getBrightness(LightLayer.BLOCK, pos) < 8;
	}
    
    public static AttributeSupplier.Builder setCustomAttributes() {
        return Monster.createMonsterAttributes()
        		.add(Attributes.MAX_HEALTH, 30.0)
        		.add(Attributes.MOVEMENT_SPEED, 0.18)
        		.add(Attributes.ATTACK_DAMAGE, 5.0)
        		.add(Attributes.ATTACK_SPEED, 1.0)
        		.add(Attributes.ATTACK_KNOCKBACK, 1.2)
        		.add(Attributes.KNOCKBACK_RESISTANCE, 0.7f)
        		.add(Attributes.FOLLOW_RANGE, 30.0);
    }
	
    public static boolean checkCorruptedDerpSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
    	boolean isPeaceful = world.getDifficulty() == Difficulty.PEACEFUL;
        boolean isDarkEnough = world.getBrightness(LightLayer.BLOCK, pos) < 8;

        if (isPeaceful) {
            return false;
        }
        if (!isDarkEnough) {
            return false;
        }
        return true;
    }
    
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CONVERTING, false);
    }
    
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
    	ItemStack itemStack = player.getItemInHand(hand);
        
    	
    	if(isConverting()) {
    		return InteractionResult.PASS;
    	}
        // Check if the item is the one that should trigger the conversion
        if (itemStack.getItem() == ItemInit.COMPACT_BALLISTICS_JELLY.get()) {
            // Record the time of interaction
            lastInteractionTime = this.level().getGameTime();
        	setConverting(true);
            itemStack.shrink(1);
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.CORRUPTED_DERP_CONVERSION.get(), SoundSource.PLAYERS, 1.4f, 1.0f);
            return InteractionResult.SUCCESS;
        }
        else {
        	return InteractionResult.PASS;
        }

    }
    
    @Override
    public void tick() {
        super.tick();
        
        if (this.level().isDay() && !this.level().isClientSide) {
            float brightness = this.level().getBrightness(null, this.blockPosition());
            if (brightness > 0.5F && this.level().canSeeSky(this.blockPosition())) {
                boolean shouldBurn = true;

                // Check if the entity is in water or in the rain
                if (this.isInWaterRainOrBubble()) {
                    shouldBurn = false;
                }

                if (shouldBurn) {
                	if (this.tickCount % 20 == 0) { 
                        this.hurt(damageSources().inFire(), 1.0F);
                        this.setSecondsOnFire(2);
                    }
                	
                }
            }
        }
        
        if (lastInteractionTime != -1L && this.level().getGameTime() - lastInteractionTime >= 100) {
        	convertToDerp();
            lastInteractionTime = -1L;
        }
    }
    
    private void convertToDerp() {
    	DerpEntity derp = new DerpEntity(EntityInit.DERP.get(), this.level());
    	derp.setPos(this.getX(), this.getY(), this.getZ());
        this.level().addFreshEntity(derp);
        this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ZOMBIE_VILLAGER_CONVERTED, SoundSource.PLAYERS, 1.0f, 1.0f);
        this.discard();
    }
    
    public void setConverting(boolean converting) {
        this.entityData.set(CONVERTING, converting);
    }

    public boolean isConverting() {
        return this.entityData.get(CONVERTING);
    }

}

