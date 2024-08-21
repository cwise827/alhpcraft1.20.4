package com.github.cwise827.alhpcraft.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class BallisticsJellySword extends SwordItem{

	public BallisticsJellySword(Tier tier, Item.Properties properties) {
		super(tier, 1, -2.4f, properties);
	}

	@Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.knockback(6.0F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());

        return super.hurtEnemy(stack, target, attacker);
    }
}
