package com.github.cwise827.alhpcraft.networking;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import com.github.cwise827.alhpcraft.AlhpCraft;
import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.entity.CorruptedDerpEntity;
import com.github.cwise827.alhpcraft.entity.DerpEntity;
import com.github.cwise827.alhpcraft.entity.JellySlimeEntity;
import com.github.cwise827.alhpcraft.entity.MrpManEntity;

import net.minecraft.world.entity.EntityType;

@EventBusSubscriber(modid="alhpcraft", bus=EventBusSubscriber.Bus.MOD)
public class EntityAttributesRegistration {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)EntityInit.CORRUPTED_DERP.get(), CorruptedDerpEntity.setCustomAttributes().build());
        event.put((EntityType)EntityInit.DERP.get(), DerpEntity.setCustomAttributes().build());
        event.put((EntityType)EntityInit.MRP_MAN.get(), MrpManEntity.setCustomAttributes().build());
        event.put((EntityType)EntityInit.JELLY_SLIME.get(), JellySlimeEntity.setCustomAttributes().build());
        event.put((EntityType)EntityInit.JELLY_CUBE.get(), JellySlimeEntity.setCustomAttributes().build());
    }
}