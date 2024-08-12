package com.github.cwise827.alhpcraft.core.init;

import com.github.cwise827.alhpcraft.block.DerpBlock;
import com.github.cwise827.alhpcraft.block.AlhpCropBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
	
	public static final DeferredBlock<Block> RED_PEPPER_CROP_BLOCK = BLOCKS.register("red_pepper_crop_block", () -> new AlhpCropBlock(BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.WHEAT)));
}
