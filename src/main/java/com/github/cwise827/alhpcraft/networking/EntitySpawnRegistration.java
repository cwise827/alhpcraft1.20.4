package com.github.cwise827.alhpcraft.networking;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.entity.CorruptedDerpEntity;

import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;

@EventBusSubscriber(modid="alhpcraft", bus=EventBusSubscriber.Bus.MOD)
public class EntitySpawnRegistration {

	 @SubscribeEvent
	    public static void registerEntitySpawn(SpawnPlacementRegisterEvent event) {
	        //event.register((EntityType)ModEntities.CORRUPTED_DERP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CorruptedDerpEntity::checkCorruptedDerpSpawnRules);
	        
	    }
}
