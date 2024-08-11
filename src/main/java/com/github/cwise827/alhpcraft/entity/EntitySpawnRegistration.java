package com.github.cwise827.alhpcraft.entity;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.cwise827.alhpcraft.core.init.EntityInit;


@EventBusSubscriber(modid="alhpcraft", bus=EventBusSubscriber.Bus.MOD)
public class EntitySpawnRegistration {
    @SubscribeEvent
    public static void registerEntitySpawn(SpawnPlacementRegisterEvent event) {

        try {
            event.register(
                EntityInit.CORRUPTED_DERP.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                CorruptedDerpEntity::checkCorruptedDerpSpawnRules,
                SpawnPlacementRegisterEvent.Operation.REPLACE
            );

        } catch (Exception e) {

        }
    }
}
