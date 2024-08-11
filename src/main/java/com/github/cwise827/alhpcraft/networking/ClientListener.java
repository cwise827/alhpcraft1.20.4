package com.github.cwise827.alhpcraft.networking;

import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.core.init.ParticleInit;
import com.github.cwise827.alhpcraft.entity.CorruptedDerpModel;
import com.github.cwise827.alhpcraft.entity.CorruptedDerpRenderer;
import com.github.cwise827.alhpcraft.entity.DerpModel;
import com.github.cwise827.alhpcraft.entity.DerpRenderer;
import com.github.cwise827.alhpcraft.entity.JellyCubeRenderer;
import com.github.cwise827.alhpcraft.entity.JellySlimeEntity;
import com.github.cwise827.alhpcraft.entity.JellySlimeRenderer;
import com.github.cwise827.alhpcraft.particle.JellySlimeParticle;
import com.github.cwise827.alhpcraft.particle.JellySlimeParticleProvider;
import com.github.cwise827.alhpcraft.particle.JellyCubeParticleProvider;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;

@EventBusSubscriber(modid="alhpcraft", bus=EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
public class ClientListener {

	public static final ModelLayerLocation CORRUPTED_DERP_LAYER = new ModelLayerLocation(new ResourceLocation((String)"alhpcraft", (String)"corrupted_derp"), "main");
	public static final ModelLayerLocation DERP_LAYER = new ModelLayerLocation(new ResourceLocation((String)"alhpcraft", (String)"derp"), "main");
	
	@SubscribeEvent
	public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
	    event.registerLayerDefinition(CORRUPTED_DERP_LAYER, CorruptedDerpModel::createBodyLayer);
	    event.registerLayerDefinition(DERP_LAYER, DerpModel::createBodyLayer);
	}
	
	@SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)EntityInit.CORRUPTED_DERP.get(), CorruptedDerpRenderer::new);
        event.registerEntityRenderer((EntityType)EntityInit.DERP.get(), DerpRenderer::new);
        event.registerEntityRenderer((EntityType)EntityInit.JELLY_SLIME.get(), JellySlimeRenderer::new);
        event.registerEntityRenderer((EntityType)EntityInit.JELLY_CUBE.get(), JellyCubeRenderer::new);
    }
	
	@SubscribeEvent
	public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
	    
	    event.registerSpriteSet(ParticleInit.JELLY_SLIME_PARTICLE.get(), JellySlimeParticleProvider::new);
	    event.registerSpriteSet(ParticleInit.JELLY_CUBE_PARTICLE.get(), JellyCubeParticleProvider::new);
	    
	}

}