package com.github.cwise827.alhpcraft.armor;

import com.github.cwise827.alhpcraft.core.init.ArmorMaterialInit;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CopperArmor extends ArmorItem{

	public CopperArmor(Type pType) {
		super(ArmorMaterialInit.COPPER, pType, new Item.Properties());
	}
	
	public void InventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		/* if(pEntity instanceof Player player) {
			ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
			ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
			ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
			
			if(player.getAbilities().mayfly) return;
			
			if(player.isCreative() || player.isSpectator()) return;
			
			if(boots.getItem() instanceof CopperArmor && leggings.getItem() instanceof CopperArmor && chestplate.getItem() instanceof CopperArmor && helmet.getItem() instanceof CopperArmor) {
				player.getAbilities().mayfly = true;
				player.fallDistance = 0.0f;
			}else {
				player.getAbilities().mayfly = false;
			} 
		} */
	}
}
