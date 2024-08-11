package com.github.cwise827.alhpcraft.armor;

import com.github.cwise827.alhpcraft.core.init.ArmorMaterialInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.item.DerpAxe;
import com.github.cwise827.alhpcraft.item.DerpPickaxe;
import com.github.cwise827.alhpcraft.item.DerpShovel;
import com.github.cwise827.alhpcraft.item.DerpSword;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class DerpArmor extends ArmorItem implements IItemExtension{

	public DerpArmor(Type pType) {
		super(ArmorMaterialInit.DERP, pType, new Item.Properties());
	}
	
	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		if(pEntity instanceof Player player) {
			ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
			ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
			ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
			ItemStack rightHand = player.getItemInHand(InteractionHand.MAIN_HAND);
			
			if(player.isCreative() || player.isSpectator()) return;


			if(boots.getItem() instanceof DerpArmor && leggings.getItem() instanceof DerpArmor && chestplate.getItem() instanceof DerpArmor && helmet.getItem() instanceof DerpArmor) {
				player.removeEffect(MobEffects.CONFUSION);
				if(rightHand.getItem() instanceof DerpPickaxe || rightHand.getItem() instanceof DerpShovel || rightHand.getItem() instanceof DerpAxe) player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 1));
				else if(rightHand.getItem() instanceof DerpSword) player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1));

			}
		}
	}
}
