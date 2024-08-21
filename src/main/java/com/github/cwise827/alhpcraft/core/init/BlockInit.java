package com.github.cwise827.alhpcraft.core.init;

import com.github.cwise827.alhpcraft.block.DerpBlock;
import com.github.cwise827.alhpcraft.block.LaunchpadBlock;
import com.github.cwise827.alhpcraft.block.AlhpCropBlock;
import com.github.cwise827.alhpcraft.block.BallisticsJellyBlock;
import com.github.cwise827.alhpcraft.block.CompactBallisticsJellyBlock;

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

	
	public static final DeferredBlock<Block> RED_PEPPER_CROP_BLOCK = BLOCKS.register("red_pepper_crop_block", () -> new AlhpCropBlock(BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.WHEAT).mapColor(MapColor.COLOR_RED)));
	
	public static final DeferredBlock<Block> BALLISTICS_JELLY_BLOCK = BLOCKS.register("ballistics_jelly_block", () -> new BallisticsJellyBlock(BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.SLIME_BLOCK).jumpFactor(2.5f).mapColor(MapColor.COLOR_YELLOW).noOcclusion()));
	
	public static final DeferredBlock<Block> COMPACT_BALLISTICS_JELLY_BLOCK = BLOCKS.register("compact_ballistics_jelly_block", () -> new CompactBallisticsJellyBlock(BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.SLIME_BLOCK).jumpFactor(4f).mapColor(MapColor.COLOR_YELLOW).noOcclusion()));
	
	public static final DeferredBlock<Block> LAUNCHPAD_BLOCK = BLOCKS.register("launchpad", () -> new LaunchpadBlock(BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.SLIME_BLOCK).jumpFactor(1f).mapColor(MapColor.COLOR_YELLOW).noOcclusion()));
}
