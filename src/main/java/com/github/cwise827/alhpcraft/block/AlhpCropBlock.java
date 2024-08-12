package com.github.cwise827.alhpcraft.block;


import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class AlhpCropBlock extends CropBlock{

	public static final MapCodec<AlhpCropBlock> CODEC = AlhpCropBlock.simpleCodec(AlhpCropBlock::new);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

    public AlhpCropBlock(BlockBehaviour.Properties builder) {
        super(builder);
        this.registerDefaultState((BlockState)((BlockState)this.getStateDefinition().any()).setValue((Property)this.getAgeProperty(), (Comparable)Integer.valueOf(0)));
    }

    public MapCodec<? extends CropBlock> codec() {
        return CODEC;
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AGE});
    }

    protected ItemLike getBaseSeedId() {
        return this.asItem();
    }
}
