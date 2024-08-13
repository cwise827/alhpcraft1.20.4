package com.github.cwise827.alhpcraft.core.init;

import java.util.function.Supplier;

import com.github.cwise827.alhpcraft.block.DerpBlockEntity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityInit {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create((Registry)BuiltInRegistries.BLOCK_ENTITY_TYPE, (String)"alhpcraft");
	
	public static final Supplier<BlockEntityType<DerpBlockEntity>> DERP_BLOCK_ENTITY = BLOCK_ENTITIES.register("derp_block", () -> BlockEntityType.Builder.of(DerpBlockEntity::new, BlockInit.DERP_BLOCK.get()).build(null));
	
}
