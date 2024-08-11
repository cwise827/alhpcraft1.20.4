package com.github.cwise827.alhpcraft.sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "alhpcraft");
    
    // All vanilla sounds use variable range events.
    public static final DeferredHolder<SoundEvent, SoundEvent> CORRUPTED_DERP_AMBIENT = SOUND_EVENTS.register(
            "corrupted_derp_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "corrupted_derp_ambient"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> CORRUPTED_DERP_HURT = SOUND_EVENTS.register(
            "corrupted_derp_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "corrupted_derp_hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> CORRUPTED_DERP_DEATH = SOUND_EVENTS.register(
            "corrupted_derp_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "corrupted_derp_death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> DR_PEPPER_DRINK = SOUND_EVENTS.register(
            "dr_pepper_drink",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "dr_pepper_drink"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> BURP = SOUND_EVENTS.register(
            "burp",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "burp"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> DERP_AMBIENT = SOUND_EVENTS.register(
            "derp_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "derp_ambient"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> DERP_HURT = SOUND_EVENTS.register(
            "derp_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "derp_hurt"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> DERP_DEATH = SOUND_EVENTS.register(
            "derp_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "derp_death"))
    );
    public static final DeferredHolder<SoundEvent, SoundEvent> CORRUPTED_DERP_CONVERSION = SOUND_EVENTS.register(
            "corrupted_derp_conversion",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("alhpcraft", "corrupted_derp_conversion"))
    );
 }