package com.gekocaretaker.syncore.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class RoughRedstoneBlock extends Block {
    public static final MapCodec<RoughRedstoneBlock> CODEC = createCodec(RoughRedstoneBlock::new);

    @Override
    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    public RoughRedstoneBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 10;
    }
}
