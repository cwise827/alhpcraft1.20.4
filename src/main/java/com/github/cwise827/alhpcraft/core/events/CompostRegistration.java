package com.github.cwise827.alhpcraft.core.events;

import com.github.cwise827.alhpcraft.core.init.ItemInit;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class CompostRegistration {

	public static void register() {
		ComposterBlock.COMPOSTABLES.put((ItemLike)((ItemLike)ItemInit.RED_PEPPER.get()), 0.65f);
		ComposterBlock.COMPOSTABLES.put((ItemLike)((ItemLike)ItemInit.RED_PEPPER_SEEDS.get()), 0.65f);
	}
}
