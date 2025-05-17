package com.gekocaretaker.syncore.block;

import com.gekocaretaker.syncore.block.entity.BlockEntityInit;
import com.gekocaretaker.syncore.block.entity.RockTumblerBlockEntity;
import com.gekocaretaker.syncore.stat.StatsInit;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RockTumblerBlock extends AbstractFurnaceBlock {
    public static final MapCodec<RockTumblerBlock> CODEC = createCodec(RockTumblerBlock::new);

    public RockTumblerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends AbstractFurnaceBlock> getCodec() {
        return CODEC;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RockTumblerBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(world, type, BlockEntityInit.ROCK_TUMBLER_BLOCK_ENTITY);
    }

    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof RockTumblerBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
            player.incrementStat(StatsInit.INTERACT_WITH_ROCK_TUMBLER);
        }
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            double d = (double) pos.getX() + 0.5;
            double e = pos.getY();
            double f = (double) pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                world.playSoundClient(d, e, f, SoundEvents.BLOCK_GRAVEL_STEP, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * g : h;
            double j = random.nextDouble() * 9.0 / 16.0;
            double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * g : h;
            world.addParticleClient(ParticleTypes.ASH, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        }
    }
}
