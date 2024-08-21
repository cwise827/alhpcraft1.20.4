package com.github.cwise827.alhpcraft.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LaunchpadBlock extends HalfTransparentBlock {

	public static final MapCodec<HalfTransparentBlock> CODEC = simpleCodec(LaunchpadBlock::new);
	private boolean wearingElytra = false;
	
	public LaunchpadBlock(Properties properties) {
		super(properties);
	}
	
	@Override
    public MapCodec<? extends HalfTransparentBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pSide) {
        return pAdjacentBlockState.is(this) ? true : super.skipRendering(pState, pAdjacentBlockState, pSide);
    }

    @Override
    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (pEntity.isSuppressingBounce()) {
            super.fallOn(pLevel, pState, pPos, pEntity, pFallDistance);
        } else {
            pEntity.causeFallDamage(pFallDistance, 0.0F, pLevel.damageSources().fall());
        }
    }
    
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    	if(entity instanceof Player player) {
    		ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
    		if(chestplate.getItem() == Items.ELYTRA){
    			wearingElytra = true;
    			
    		}else {
    			wearingElytra = false;
    		}
    	}
    }
    
    @Override
    public float getJumpFactor() {
        if (wearingElytra)
        	return 20f;
        else
        	return 1.0f;
    }

}
