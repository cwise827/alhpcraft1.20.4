package com.github.cwise827.alhpcraft;

import com.github.cwise827.alhpcraft.block.DerpBlockEntity;
import com.github.cwise827.alhpcraft.core.events.BrewingRecipeRegistration;
import com.github.cwise827.alhpcraft.core.events.CompostRegistration;
import com.github.cwise827.alhpcraft.core.events.CreativeTabsRegistration;
import com.github.cwise827.alhpcraft.core.events.MenuRegistration;
import com.github.cwise827.alhpcraft.core.events.ScreenRegistration;
import com.github.cwise827.alhpcraft.core.init.BlockEntityInit;
import com.github.cwise827.alhpcraft.core.init.BlockInit;
import com.github.cwise827.alhpcraft.core.init.ItemInit;
import com.github.cwise827.alhpcraft.core.init.MobEffectInit;
import com.github.cwise827.alhpcraft.core.init.ParticleInit;
import com.github.cwise827.alhpcraft.core.init.PotionInit;
import com.github.cwise827.alhpcraft.core.init.EntityInit;
import com.github.cwise827.alhpcraft.sounds.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.items.IItemHandler;

import org.slf4j.Logger;

@Mod(AlhpCraft.MODID)
public class AlhpCraft
{
    public static final String MODID = "alhpcraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AlhpCraft(IEventBus modEventBus)
    {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerCapabilities);
        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        EntityInit.ENTITIES.register(modEventBus);
        ParticleInit.PARTICLE_TYPES.register(modEventBus);
        CreativeTabsRegistration.CREATIVE_MODE_TABS.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);
        MenuRegistration.REGISTER.register(modEventBus);
        BlockEntityInit.BLOCK_ENTITIES.register(modEventBus);
        MobEffectInit.MOB_EFFECTS.register(modEventBus);
        PotionInit.POTIONS.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    	// Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        event.enqueueWork(() -> CompostRegistration.register());
        new BrewingRecipeRegistration().register(event);
    }
    
    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            BlockEntityInit.DERP_BLOCK_ENTITY.get(),
            (be, side) -> {
                if (be instanceof DerpBlockEntity) {
                    return (IItemHandler) be;
                }
                return null;
            });
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
            
        	ItemBlockRenderTypes.setRenderLayer(BlockInit.BALLISTICS_JELLY_BLOCK.get(), RenderType.translucent());
        	ItemBlockRenderTypes.setRenderLayer(BlockInit.COMPACT_BALLISTICS_JELLY_BLOCK.get(), RenderType.translucent());
        	ItemBlockRenderTypes.setRenderLayer(BlockInit.LAUNCHPAD_BLOCK.get(), RenderType.translucent());
        	
        	// Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            ScreenRegistration.registerScreens();
        }
    }
}
