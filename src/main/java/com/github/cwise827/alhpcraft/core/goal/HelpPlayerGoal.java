package com.github.cwise827.alhpcraft.core.goal;

import java.util.EnumSet;
import java.util.List;

import org.slf4j.Logger;

import com.github.cwise827.alhpcraft.entity.DerpEntity;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class HelpPlayerGoal extends Goal{
	private final DerpEntity derpEntity;
    private ItemEntity targetItem;
    private static final Logger LOGGER = LogUtils.getLogger();

    public HelpPlayerGoal(DerpEntity derpEntity) {
        this.derpEntity = derpEntity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
    	return derpEntity.isHelping();
    }

    @Override
    public void tick() {
    	if (!derpEntity.level().isClientSide && derpEntity.isHelping()) {
    		this.targetItem = null;
    		List<ItemEntity> items = derpEntity.level().getEntitiesOfClass(ItemEntity.class, derpEntity.getBoundingBox().inflate(12.0));
		    for (ItemEntity item : items) {
		        if (item.isAlive() && !item.getItem().isEmpty()) {
		            this.targetItem = item;
		        }
		    }    
			if (derpEntity.hasItemsToPickup() && this.targetItem != null) {
		            LOGGER.debug("Current target item: " + this.targetItem + ", Is alive: " + this.targetItem.isAlive());
		            if (this.targetItem.isAlive()) {
		                // Move the entity towards the item
		                this.derpEntity.getNavigation().moveTo(this.targetItem, 1.3); // Move speed
		
		                // Check if the entity is close enough to pick up the item
		                if (this.derpEntity.distanceToSqr(this.targetItem) < 1.5 * 1.5) {
		                    ItemStack itemStack = this.targetItem.getItem().copy();
		                    Player player = derpEntity.getHelpedPlayer();
		
		                    if (player != null) {
		                        if (addItemToPlayerInventory(player, itemStack)) {
		                            // Notify that the item was added to the player's inventory
		                            this.derpEntity.lookAt(player, 0.0F, 0.0F);
		                            this.targetItem.discard(); // Remove the item from the world
		                            this.targetItem = null; // Clear the reference
		                        }
		                    }
		                }
		            } else {
		                //LOGGER.debug("Target item is no longer alive.");
		                this.targetItem = null; // Clear the reference if the item is not alive
		            }
		        } else {
		            // Switch to following player if no items to pick up
		            //LOGGER.debug("Following player");
		        	Player player = derpEntity.getHelpedPlayer();
		            if (player != null) {
		                derpEntity.getNavigation().moveTo(player, 1.3);
		                derpEntity.getLookControl().setLookAt(player, 30.0F, 30.0F);
		            }
		        }
		    }
    }

    @Override
    public boolean canContinueToUse() {
    	return derpEntity.getHelpedPlayer() != null && super.canContinueToUse();
    }

    @Override
    public void stop() {
        this.targetItem = null;
        derpEntity.getNavigation().stop();
    }

    private boolean addItemToPlayerInventory(Player player, ItemStack itemStack) {
        ItemStack remainingStack = itemStack.copy();

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack slotStack = player.getInventory().getItem(i);

            if (canCombine(slotStack, remainingStack)) {
                int transferAmount = Math.min(remainingStack.getCount(), slotStack.getMaxStackSize() - slotStack.getCount());
                slotStack.grow(transferAmount);
                remainingStack.shrink(transferAmount);

                if (remainingStack.isEmpty()) {
                    return true;
                }
            }
        }

        // If there are still items left to add, try adding to empty slots
        if (!remainingStack.isEmpty()) {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack slotStack = player.getInventory().getItem(i);
                if (slotStack.isEmpty()) {
                    player.getInventory().setItem(i, remainingStack);
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean canCombine(ItemStack stack1, ItemStack stack2) {
        return stack1.getItem() == stack2.getItem() && ItemStack.isSameItemSameTags(stack1, stack2);
    }
    

}
