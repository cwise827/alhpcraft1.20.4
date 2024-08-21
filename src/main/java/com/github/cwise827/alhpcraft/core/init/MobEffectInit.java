package com.github.cwise827.alhpcraft.core.init;

import java.util.function.Supplier;

import com.github.cwise827.alhpcraft.effect.FireBreathingEffect;
import com.github.cwise827.alhpcraft.effect.GentleFallingEffect;
import com.github.cwise827.alhpcraft.effect.SweatyPalmsEffect;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobEffectInit {

	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create((Registry)BuiltInRegistries.MOB_EFFECT, (String)"alhpcraft");
	
	public static final Supplier<SweatyPalmsEffect> SWEATY_PALMS_EFFECT = MOB_EFFECTS.register("sweaty_palms", () -> new SweatyPalmsEffect(
	        MobEffectCategory.HARMFUL,
	        0xb8d4d6
	));
	
	public static final Supplier<GentleFallingEffect> GENTLE_FALLING_EFFECT = MOB_EFFECTS.register("gentle_falling", () -> new GentleFallingEffect(
	        MobEffectCategory.BENEFICIAL,
	        0xb69231
	));
	
	public static final Supplier<FireBreathingEffect> FIRE_BREATHING_EFFECT = MOB_EFFECTS.register("fire_breathing", () -> new FireBreathingEffect(
	        MobEffectCategory.BENEFICIAL,
	        0xaa4203
	));
}
