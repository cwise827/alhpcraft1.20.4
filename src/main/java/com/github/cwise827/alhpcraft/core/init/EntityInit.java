package com.github.cwise827.alhpcraft.core.init;

import com.github.cwise827.alhpcraft.entity.CorruptedDerpEntity;
import com.github.cwise827.alhpcraft.entity.DerpEntity;
import com.github.cwise827.alhpcraft.entity.JellyCubeEntity;
import com.github.cwise827.alhpcraft.entity.JellySlimeEntity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityInit {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create((Registry)BuiltInRegistries.ENTITY_TYPE, (String)"alhpcraft");
	
	public static final DeferredHolder<EntityType<?>, EntityType<CorruptedDerpEntity>> CORRUPTED_DERP = ENTITIES.register("corrupted_derp", () -> EntityType.Builder.of(CorruptedDerpEntity::new, MobCategory.MONSTER).sized(.6f, 2.2f).build("corrupted_derp"));
    
	public static final DeferredHolder<EntityType<?>, EntityType<DerpEntity>> DERP = ENTITIES.register("derp", () -> EntityType.Builder.of(DerpEntity::new, MobCategory.CREATURE).sized(.6f, 2.2f).build("derp"));
	
	public static final DeferredHolder<EntityType<?>, EntityType<JellySlimeEntity>> JELLY_SLIME = ENTITIES.register("jelly_slime", () -> EntityType.Builder.of(JellySlimeEntity::new, MobCategory.MONSTER).sized(2f, 2f).build("jelly_slime"));
	
	public static final DeferredHolder<EntityType<?>, EntityType<JellyCubeEntity>> JELLY_CUBE = ENTITIES.register("jelly_cube", () -> EntityType.Builder.of(JellyCubeEntity::new, MobCategory.MONSTER).sized(2f, 2f).build("jelly_cube"));
}
