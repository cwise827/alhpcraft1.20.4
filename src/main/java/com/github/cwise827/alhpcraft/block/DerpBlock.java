package com.github.cwise827.alhpcraft.block;

import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.github.cwise827.alhpcraft.core.init.BlockEntityInit;
import com.github.cwise827.alhpcraft.menu.DerpBlockMenu;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import com.github.cwise827.alhpcraft.block.DerpBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class DerpBlock extends BaseEntityBlock{
	
	public static final MapCodec<DerpBlock> CODEC = simpleCodec(DerpBlock::new);
	
	public DerpBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }
	
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return (BlockState) this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, ctx.getHorizontalDirection());
    }
    
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
    
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    	if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            return InteractionResult.CONSUME;
        }
    }
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new DerpBlockEntity(pPos, pState);
    }
    
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
    	BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DerpBlockEntity) {
        	 ContainerLevelAccess access = ContainerLevelAccess.create(level, pos);
        	 DerpBlockMenu.setContainerLevelAccess(access);
        	return new SimpleMenuProvider((containerId, playerInventory, player) ->
                new DerpBlockMenu(containerId, playerInventory),
                this.getName());
        }
        return null;
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
      return type == BlockEntityInit.DERP_BLOCK_ENTITY.get() ? DerpBlockEntity::tick : null;
    }
    
    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
    	if (!pLevel.isClientSide) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof DerpBlockEntity) {
                DerpBlockEntity derpBlockEntity = (DerpBlockEntity) blockEntity;
                IItemHandler itemHandler = derpBlockEntity.getItemHandler(); // Ensure you have a method to get the item handler
                for (int i = 0; i < itemHandler.getSlots(); i++) {
                    ItemStack stack = itemHandler.getStackInSlot(i);
                    if (!stack.isEmpty()) {
                        // Drop the items
                        Block.popResource(pLevel, pPos, stack);
                    }
                }
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }


	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}


}
