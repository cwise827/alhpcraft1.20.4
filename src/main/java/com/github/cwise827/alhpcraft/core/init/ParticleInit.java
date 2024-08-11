package com.github.cwise827.alhpcraft.core.init;


import java.util.function.Supplier;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleInit {
	
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, "alhpcraft");
	
	public static Supplier<SimpleParticleType> JELLY_SLIME_PARTICLE = PARTICLE_TYPES.register("jelly_slime_particle", () -> new SimpleParticleType(false));
	public static Supplier<SimpleParticleType> JELLY_CUBE_PARTICLE = PARTICLE_TYPES.register("jelly_cube_particle", () -> new SimpleParticleType(false));
}
