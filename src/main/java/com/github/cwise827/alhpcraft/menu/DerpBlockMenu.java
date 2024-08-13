package com.github.cwise827.alhpcraft.menu;


import org.slf4j.Logger;

import com.github.cwise827.alhpcraft.block.DerpBlockEntity;
import com.github.cwise827.alhpcraft.core.events.MenuRegistration;
import com.github.cwise827.alhpcraft.core.init.BlockInit;
import com.github.cwise827.alhpcraft.item.FabricEdge;
import com.mojang.logging.LogUtils;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;


public class DerpBlockMenu extends AbstractContainerMenu {
    private static ContainerLevelAccess access;
    private final DerpBlockMenu.PaymentSlot paymentSlot;
    private static final Logger LOGGER = LogUtils.getLogger();
    
    private final Container derpBlock = new SimpleContainer(1) {
        @Override
        public boolean canPlaceItem(int index, ItemStack item) {
            return item.getItem() instanceof FabricEdge;
        }

        @Override
        public int getMaxStackSize() {
            return 1;
        }
        
    };

    public DerpBlockMenu(int containerId, Inventory playerInventory) {
    	this(containerId, playerInventory, new ItemStackHandler(36), DataSlot.standalone());
    }
    
    
    public DerpBlockMenu(int containerId, Inventory playerInventory, IItemHandler dataInventory, DataSlot dataSingle) {
        
		super(MenuRegistration.DERP_BLOCK_MENU.get(), containerId);
		this.access = access != null ? access : ContainerLevelAccess.NULL;
        
        this.paymentSlot = new DerpBlockMenu.PaymentSlot(this.derpBlock, 0, 129, 32);
        this.addSlot(this.paymentSlot);
  
        // Player Inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
        	this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    
    @Override
    public boolean stillValid(Player player) {
    	return AbstractContainerMenu.stillValid(this.access, player, BlockInit.DERP_BLOCK.get());
    }
    
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
    	ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stackInSlot = slot.getItem();
            itemstack = stackInSlot.copy();

            int slotIndex = 0; // The index of your single custom slot
            int playerInventoryStart = 1; // Player inventory starts after your single slot
            int hotbarStart = this.slots.size() - 9; // The hotbar is the last 9 slots
            int playerInventoryEnd = this.slots.size();

            // If the clicked slot is your single custom slot
            if (index == slotIndex) {
            	// Move item from your single slot to player's inventory
                if (!this.moveItemStackTo(stackInSlot, playerInventoryStart, playerInventoryEnd, true)) {
                	return ItemStack.EMPTY;
                }
                slot.setChanged();
            } else {
            	// The clicked slot is in the player inventory or hotbar
                boolean moved = false;
                // Try to move to the custom slot if it's empty
                if (this.slots.get(slotIndex).getItem().isEmpty()) {
                    if (this.moveItemStackTo(stackInSlot, slotIndex, slotIndex + 1, false)) {
                        moved = true;
                    }
                }
                // If not moved, move between inventory and hotbar
                if (!moved) {
                    if (index >= playerInventoryStart && index < hotbarStart) {
                        // Move from main inventory to hotbar
                        if (!this.moveItemStackTo(stackInSlot, hotbarStart, playerInventoryEnd, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (index >= hotbarStart && index < playerInventoryEnd) {
                        // Move from hotbar to main inventory
                        if (!this.moveItemStackTo(stackInSlot, playerInventoryStart, hotbarStart, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                }
            }

            if (stackInSlot.isEmpty()) {
            	slot.set(ItemStack.EMPTY);
            } else {
            	slot.setChanged();
            }

            if (stackInSlot.getCount() == itemstack.getCount()) {
            	return ItemStack.EMPTY;
            }

            slot.onTake(player, stackInSlot);
        }

        return itemstack;
    }
    
    public static void setContainerLevelAccess(ContainerLevelAccess staticAccess) {
        access = staticAccess;
    }
    
    @Override
    public void removed(Player player) {
        super.removed(player);
        if (this.access != ContainerLevelAccess.NULL) {
        	this.access.execute((world, pos) -> {
                // Save the item to the block entity
                if (world.getBlockEntity(pos) instanceof DerpBlockEntity blockEntity) {
                	blockEntity.syncWithMenu(this.paymentSlot.getItem());
                    LOGGER.debug("The item is " + this.paymentSlot.getItem().toString());
                }
            });
        }
    }
    
    @Override
    public void broadcastChanges() {
    	super.broadcastChanges();
        if (this.access != ContainerLevelAccess.NULL) {
            this.access.execute((world, pos) -> {
                if (world.getBlockEntity(pos) instanceof DerpBlockEntity blockEntity) {
                    ItemStack storedItem = blockEntity.getStoredItem();
                    // Ensure the item is not empty before setting it
                    if (!storedItem.isEmpty()) {
                        this.paymentSlot.set(storedItem);
                    }
                }
            });
        }
    }
    
    class PaymentSlot extends Slot {
        public PaymentSlot(Container pContainer, int pContainerIndex, int pXPosition, int pYPosition) {
            super(pContainer, pContainerIndex, pXPosition, pYPosition);
        }

        @Override
        public boolean mayPlace(ItemStack pStack) {
            return pStack.getItem() instanceof FabricEdge;
        }

        @Override
        public int getMaxStackSize() {
            return 1;
        }
        
        @Override
        public void set(ItemStack stack) {
            // Set the item in the slot
            super.set(stack);

            // Notify that the container's state has changed
            this.container.setChanged();
        }

    }
}