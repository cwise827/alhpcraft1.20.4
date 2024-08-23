package com.github.cwise827.alhpcraft.entity;


import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import com.github.cwise827.alhpcraft.core.goal.AttackHostileGoal;
import com.github.cwise827.alhpcraft.core.goal.HelpPlayerGoal;
import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.sounds.ModSounds;
import com.mojang.logging.LogUtils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class DerpEntity extends Animal {
	
	private boolean isHelping;
	private Player helpedPlayer;
	private static final EntityDataAccessor<Boolean> HELPING_TEXTURE = SynchedEntityData.defineId(DerpEntity.class, EntityDataSerializers.BOOLEAN);
	private static final Logger LOGGER = LogUtils.getLogger();
	
	private static final Set<Item> BREEDING_ITEMS = Set.of(
		    ItemInit.CHICKEN_SANDWICH.get(),
		    ItemInit.SPICY_CHICKEN_SANDWICH.get()
		);
	
	public DerpEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
        this.setHealth(30F);
    }
	
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new AttackHostileGoal(this));
		this.goalSelector.addGoal(2, new HelpPlayerGoal(this));
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25D, Ingredient.of(
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
		this.goalSelector.addGoal(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(7, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.3));
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

	@Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.level().isClientSide) {
	        if (!this.isBaby()) {
	            this.isHelping = !this.isHelping;
	            this.setHelpingTexture(this.isHelping);
	            if (isHelping) {
	                this.helpedPlayer = player;
	            }
	            this.level().broadcastEntityEvent(this, (byte) 10);
	        } else {
	            return InteractionResult.PASS;
	        }
	    }
	    return InteractionResult.SUCCESS;
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
    
    public boolean hasItemsToPickup() {
        List<ItemEntity> items = this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(12.0));
        for (ItemEntity item : items) {
            LOGGER.debug(item.toString() + " still exists");
        	if (item.isAlive() && !item.getItem().isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HELPING_TEXTURE, false); // Default to the normal texture
    }
    
    public boolean isHelpingTexture() {
        return this.entityData.get(HELPING_TEXTURE);
    }

    public void setHelpingTexture(boolean isSpecialTexture) {
        this.entityData.set(HELPING_TEXTURE, isSpecialTexture);
    }
    
    public boolean isHelping() {
        return isHelping;
    }

    public void setHelping(boolean isHelping) {
        this.isHelping = isHelping;
    }
    
    public Player getHelpedPlayer() {
    	return this.helpedPlayer;
    }
    
    public void setHelpedPlayer(Player player) {
    	this.helpedPlayer = player;
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
	
	public void addItem(ItemStack itemStack) {
        // Handle the item pickup logic, e.g., adding to inventory, holding, or dropping it.
        this.spawnAtLocation(itemStack); // As an example, drop it immediately
    }
	
	@Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("isHelping", this.isHelping);
        if (this.getHelpedPlayer() != null) {
            compound.putUUID("HelpedPlayerUUID", this.getHelpedPlayer().getUUID());
        }
    }
    
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
    	super.readAdditionalSaveData(compound);
        this.isHelping = compound.getBoolean("isHelping");
        this.setHelpingTexture(this.isHelping);
        
        if (compound.hasUUID("HelpedPlayerUUID")) {
            Player player = this.level().getPlayerByUUID(compound.getUUID("HelpedPlayerUUID"));
            this.setHelpedPlayer(player);
        }
    }
    
    private void clearGoals() {
        this.goalSelector.getAvailableGoals().forEach(wrappedGoal -> this.goalSelector.removeGoal(wrappedGoal.getGoal()));
    }
}

