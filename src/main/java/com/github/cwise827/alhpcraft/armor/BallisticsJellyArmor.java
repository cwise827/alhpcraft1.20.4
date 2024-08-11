package com.github.cwise827.alhpcraft.armor;

import com.github.cwise827.alhpcraft.core.init.ArmorMaterialInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.item.DerpAxe;
import com.github.cwise827.alhpcraft.item.DerpPickaxe;
import com.github.cwise827.alhpcraft.item.DerpShovel;
import com.github.cwise827.alhpcraft.item.DerpSword;

import net.minecraft.nbt.CompoundTag;
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

public class BallisticsJellyArmor extends ArmorItem implements IItemExtension{

	
	public BallisticsJellyArmor(Type pType) {
		super(ArmorMaterialInit.BALLISTICS_JELLY, pType, new Item.Properties());
	}
	
	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		if(pEntity instanceof Player player) {
			ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
			ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
			ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
			ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
			
			if(player.isCreative() || player.isSpectator()) return;
			
			CompoundTag tag = pStack.getOrCreateTag();
			long lastAppliedTime = tag.getLong("LastAbsorptionTime");

			if(boots.getItem() instanceof BallisticsJellyArmor && leggings.getItem() instanceof BallisticsJellyArmor && chestplate.getItem() instanceof BallisticsJellyArmor && helmet.getItem() instanceof BallisticsJellyArmor) {


	            if (pLevel.getGameTime() - lastAppliedTime >= 600) {
	            	player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 1));
	                tag.putLong("LastAbsorptionTime", pLevel.getGameTime());
	            }
	            return;
			}
			else {
				MobEffectInstance absorptionEffect = player.getEffect(MobEffects.ABSORPTION);
	            if (absorptionEffect != null && absorptionEffect.getAmplifier() == 1 && (pLevel.getGameTime() - lastAppliedTime < 600)) {
	                player.removeEffect(MobEffects.ABSORPTION);
				}	
			}
		}
	}
}
