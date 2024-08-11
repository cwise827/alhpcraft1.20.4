package com.github.cwise827.alhpcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class CopperPickaxe extends PickaxeItem{
	
	public CopperPickaxe(Tier tier, Item.Properties properties) {
		super(tier, 2, -2.8f, properties);
	}
}
