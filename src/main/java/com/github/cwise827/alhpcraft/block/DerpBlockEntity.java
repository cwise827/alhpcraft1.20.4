package com.github.cwise827.alhpcraft.block;

import java.util.Random;

import org.slf4j.Logger;

import com.github.cwise827.alhpcraft.core.init.BlockEntityInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.neoforged.neoforge.items.ItemStackHandler;

public class DerpBlockEntity extends BlockEntity{
	
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    private static final long DISPENSE_DELAY = 600L;
    private long lastItemSetTime = -1;
    private static final Logger LOGGER = LogUtils.getLogger();
    private final Random random = new Random();
    private ItemStack randomItem;
    private int randomArrayInt, randomInt;
    private static final int DELAY_TICKS = 200; // 10 seconds
    private int timer = 0;
    
    Item junkBlocks[] = {Items.COBBLESTONE, Items.DIRT, Items.GRANITE, Items.ANDESITE, Items.DIORITE};
    Item nuggetArray[] = {Items.GOLD_NUGGET, Items.IRON_NUGGET, Items.IRON_INGOT, Items.GOLD_INGOT, Items.COPPER_INGOT};
    Item alhpItems[] = {ItemInit.BALLISTICS_JELLY.get(), ItemInit.JELLY_CREAM.get(), ItemInit.CHICKEN_SANDWICH.get(), ItemInit.SPICY_CHICKEN_SANDWICH.get(), ItemInit.WAFFLE_FRIES.get(), ItemInit.RED_PEPPER.get(), ItemInit.RED_PEPPER_SEEDS.get()};
    Item dyeArray[] = {Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE, Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.RED_DYE, Items.WHITE_DYE, Items.YELLOW_DYE};
    Item logArray[] = {Items.ACACIA_LOG, Items.BIRCH_LOG, Items.CHERRY_LOG, Items.DARK_OAK_LOG, Items.JUNGLE_LOG, Items.MANGROVE_LOG, Items.OAK_LOG, Items.SPRUCE_LOG};
    Item toolArray[] = {Items.IRON_AXE, Items.IRON_PICKAXE, Items.IRON_SHOVEL, Items.IRON_SWORD, ItemInit.COPPER_AXE.get(), ItemInit.COPPER_PICKAXE.get(), ItemInit.COPPER_SHOVEL.get(), ItemInit.COPPER_SWORD.get(), ItemInit.DERP_AXE.get(), ItemInit.DERP_PICKAXE.get(), ItemInit.DERP_SHOVEL.get(), ItemInit.DERP_SWORD.get(), Items.IRON_HOE, ItemInit.COPPER_HOE.get(), ItemInit.DERP_HOE.get(), ItemInit.KNIFE.get()};
    Item armorArray[] = {Items.IRON_BOOTS, Items.IRON_LEGGINGS, Items.IRON_CHESTPLATE, Items.IRON_HELMET, ItemInit.COPPER_BOOTS.get(), ItemInit.COPPER_LEGGINGS.get(), ItemInit.COPPER_CHESTPLATE.get(), ItemInit.COPPER_HELMET.get(), ItemInit.DERP_BOOTS.get(), ItemInit.DERP_LEGGINGS.get(), ItemInit.DERP_CHESTPLATE.get(), ItemInit.DERP_HELMET.get(), Items.LEATHER_BOOTS, Items.LEATHER_LEGGINGS, Items.LEATHER_CHESTPLATE, Items.LEATHER_HELMET};
    Item valuableMobDrops[] = {Items.ENDER_PEARL, Items.BLAZE_ROD};
    Item valuableGems[] = {Items.DIAMOND, Items.EMERALD, Items.NETHERITE_SCRAP};
    
    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    public DerpBlockEntity(BlockPos pos, BlockState state) {
        super((BlockEntityType)BlockEntityInit.DERP_BLOCK_ENTITY.get(), pos, state);
    }

    public void setStoredItem(ItemStack itemStack) {
    	itemHandler.setStackInSlot(0, itemStack);
    	this.lastItemSetTime = this.level.getGameTime();
        setChanged();
        dispenseRandomItem();
        
    }

    
    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public ItemStack getStoredItem() {
    	return itemHandler.getStackInSlot(0);
    }
    private void dispenseRandomItem() {
        randomInt = random.nextInt(1000); // Generates a random number between 0 and 99

        if (randomInt >= 0 && randomInt <= 749) {
            randomArrayInt = random.nextInt(junkBlocks.length);
        	randomItem = new ItemStack(junkBlocks[randomArrayInt]);
        } else if (randomInt >= 750 && randomInt <= 769) {
        	randomArrayInt = random.nextInt(nuggetArray.length);
        	randomItem = new ItemStack(nuggetArray[randomArrayInt]);
        }else if (randomInt >= 770 && randomInt <= 789) {
        	randomArrayInt = random.nextInt(alhpItems.length);
        	randomItem = new ItemStack(alhpItems[randomArrayInt]);
        }else if (randomInt >= 790 && randomInt <= 889) {
            randomArrayInt = random.nextInt(dyeArray.length);
        	randomItem = new ItemStack(dyeArray[randomArrayInt]);
        }else if (randomInt >= 890 && randomInt <= 989) {
        	randomArrayInt = random.nextInt(logArray.length);
        	randomItem = new ItemStack(logArray[randomArrayInt]);
        }else if (randomInt >= 990 && randomInt <= 993) {
        	randomArrayInt = random.nextInt(toolArray.length);
        	randomItem = new ItemStack(toolArray[randomArrayInt]);
        }else if (randomInt >= 994 && randomInt <= 996) {
        	randomArrayInt = random.nextInt(armorArray.length);
        	randomItem = new ItemStack(armorArray[randomArrayInt]);
        }else if (randomInt >= 997 && randomInt <= 998) {
            randomArrayInt = random.nextInt(valuableMobDrops.length);
        	randomItem = new ItemStack(valuableMobDrops[randomArrayInt]);
        }else if (randomInt == 999) {
            randomArrayInt = random.nextInt(valuableGems.length);
        	randomItem = new ItemStack(valuableGems[randomArrayInt]);
        }else {
        	randomItem = new ItemStack(Items.DIRT);
        }
        LOGGER.debug("Random Int = " + randomInt);
        LOGGER.debug("Random array int = " + randomArrayInt);
        dispenseItem(); // Dispense the item
    }
    private void dispenseItem() {
    	if (!this.itemHandler.getStackInSlot(0).isEmpty()) {
        	BlockPos pos = getBlockPos();
        	BlockState state = getBlockState();
        	Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

            // Calculate the position in front of the block
            BlockPos frontPos = pos.relative(facing.getOpposite());
        	
        	Containers.dropItemStack(this.level, frontPos.getX(), frontPos.getY(), frontPos.getZ(), randomItem);
            this.itemHandler.setStackInSlot(0, ItemStack.EMPTY); // Clear the item after dispensing
            this.setChanged(); // Notify the block entity has changed
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, DerpBlockEntity blockEntity) {
        // Check if there is an item in the slot
    	if (blockEntity.getItemHandler().getStackInSlot(0).isEmpty()) {
            // Increment the timer
            blockEntity.timer++;
            
            // Check if the timer has reached 10 seconds
            if (blockEntity.timer >= DELAY_TICKS) {
                // Dispense the item
                blockEntity.dispenseRandomItem();
                
                // Reset the timer
                blockEntity.timer = 0;
            }
        } else {
            // Reset the timer if the slot is empty
            blockEntity.timer = 0;
        }
    }
    
    @Override
    public void load(CompoundTag tag) {
    	super.load(tag);
        CompoundTag inventoryTag = tag.getCompound("Inventory");
        itemHandler.deserializeNBT(inventoryTag);
        LOGGER.debug("Loaded Inventory NBT: " + inventoryTag.toString());
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
    	super.saveAdditional(tag);
        CompoundTag inventoryTag = itemHandler.serializeNBT();
        tag.put("Inventory", inventoryTag);
        LOGGER.debug("Saved Inventory NBT: " + inventoryTag.toString());
    }
    
    public void syncWithMenu(ItemStack itemStack) {
        setStoredItem(itemStack);
    }
}
