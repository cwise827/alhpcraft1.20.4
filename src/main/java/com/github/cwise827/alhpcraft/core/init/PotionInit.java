package com.github.cwise827.alhpcraft.core.init;

import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PotionInit {

	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create((Registry)BuiltInRegistries.POTION, (String)"alhpcraft");
	
	public static final Supplier<Potion> SWEATY_PALMS_POTION = POTIONS.register("sweaty_palms", () -> new Potion(new MobEffectInstance(MobEffectInit.SWEATY_PALMS_EFFECT.get(), 1200)));
	
	public static final Supplier<Potion> GENTLE_FALLING_POTION = POTIONS.register("gentle_falling", () -> new Potion(new MobEffectInstance(MobEffectInit.GENTLE_FALLING_EFFECT.get(), 3000)));
	
	public static final Supplier<Potion> FIRE_BREATHING_POTION = POTIONS.register("fire_breathing", () -> new Potion(new MobEffectInstance(MobEffectInit.FIRE_BREATHING_EFFECT.get(), 1200)));
}
