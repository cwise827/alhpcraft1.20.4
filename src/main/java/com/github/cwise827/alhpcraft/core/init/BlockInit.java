package com.github.cwise827.alhpcraft.core.init;

import com.github.cwise827.alhpcraft.block.DerpBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockInit {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("alhpcraft");
	public static final DeferredBlock<Block> DERP_BLOCK = BLOCKS.register("derp_block", () -> new DerpBlock(BlockBehaviour.Properties.of()
    		.mapColor(MapColor.COLOR_GREEN)
    		.destroyTime(2.5f)
    		.explosionResistance(9.0f)
    		.requiresCorrectToolForDrops()));
}
