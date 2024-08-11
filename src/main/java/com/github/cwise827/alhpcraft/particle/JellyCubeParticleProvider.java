package com.github.cwise827.alhpcraft.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

public class JellyCubeParticleProvider implements ParticleProvider<SimpleParticleType> {

    private final SpriteSet spriteSet;
    

    public JellyCubeParticleProvider(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
    }
    
    @Override
    public Particle createParticle(SimpleParticleType type, ClientLevel level,
            double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        return new JellyCubeParticle(level, x, y, z, spriteSet);
    }
}
