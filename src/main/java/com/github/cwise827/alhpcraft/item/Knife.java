package com.github.cwise827.alhpcraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class Knife extends SwordItem{

	public Knife(Tier tier, Item.Properties properties){
		super(tier, 1, -1.4f, properties);
	}
}
