package com.github.cwise827.alhpcraft.core.init;

import java.util.function.Supplier;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.github.cwise827.alhpcraft.block.DerpBlockEntity;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityInit {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create((Registry)BuiltInRegistries.BLOCK_ENTITY_TYPE, (String)"alhpcraft");
	
	public static final Supplier<BlockEntityType<DerpBlockEntity>> DERP_BLOCK_ENTITY = BLOCK_ENTITIES.register("derp_block", () -> BlockEntityType.Builder.of(DerpBlockEntity::new, BlockInit.DERP_BLOCK.get()).build(null));

	public static final BlockCapability<IItemHandler, @Nullable Direction> ITEM_HANDLER_BLOCK =
		    BlockCapability.createSided(
		        // Provide a name to uniquely identify the capability.
		        new ResourceLocation("alhpcraft", "item_handler"),
		        // Provide the queried type. Here, we want to look up `IItemHandler` instances.
		        IItemHandler.class);


}
