package com.github.cwise827.alhpcraft;

import com.github.cwise827.alhpcraft.core.events.CompostRegistration;
import com.github.cwise827.alhpcraft.core.events.CreativeTabsRegistration;
import com.github.cwise827.alhpcraft.core.init.BlockInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.core.init.ParticleInit;
import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.sounds.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(AlhpCraft.MODID)
public class AlhpCraft
{
    public static final String MODID = "alhpcraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AlhpCraft(IEventBus modEventBus)
    {
        modEventBus.addListener(this::commonSetup);
        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        EntityInit.ENTITIES.register(modEventBus);
        ParticleInit.PARTICLE_TYPES.register(modEventBus);
        CreativeTabsRegistration.CREATIVE_MODE_TABS.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);
        
        NeoForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    	// Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        event.enqueueWork(() -> CompostRegistration.register());
    }

    
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
