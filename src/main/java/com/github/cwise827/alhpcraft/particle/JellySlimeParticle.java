package com.github.cwise827.alhpcraft.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public class JellySlimeParticle extends TextureSheetParticle  {

	private final SpriteSet spriteSet;
    
    public JellySlimeParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);
        this.spriteSet = spriteSet;
        this.setSpriteFromAge(spriteSet);
    }
    
    @Override
    public void tick() {
        setSpriteFromAge(spriteSet);
        super.tick();
    }

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

}
