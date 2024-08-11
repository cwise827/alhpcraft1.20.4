package com.github.cwise827.alhpcraft.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

public class JellySlimeParticleProvider implements ParticleProvider<SimpleParticleType> {

    private final SpriteSet spriteSet;
    

    public JellySlimeParticleProvider(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
    }
    
    @Override
    public Particle createParticle(SimpleParticleType type, ClientLevel level,
            double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        return new JellySlimeParticle(level, x, y, z, spriteSet);
    }
}
