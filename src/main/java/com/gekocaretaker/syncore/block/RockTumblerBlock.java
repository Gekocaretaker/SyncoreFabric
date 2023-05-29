package com.gekocaretaker.syncore.block;

import com.gekocaretaker.syncore.block.entity.BlockEntityInit;
import com.gekocaretaker.syncore.block.entity.RockTumblerBlockEntity;
import com.gekocaretaker.syncore.stat.StatsInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class RockTumblerBlock extends AbstractFurnaceBlock {
    public RockTumblerBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(3, 0, 0, 13, 8, 4),
            Block.createCuboidShape(4, 8, 4, 12, 16, 12),
            Block.createCuboidShape(3, 0, 4, 13, 5.375, 12),
            Block.createCuboidShape(3, 0, 12, 13, 8, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static VoxelShape SHAPE_EAST = Stream.of(
            Block.createCuboidShape(12, 0, 3, 16, 8, 13),
            Block.createCuboidShape(4, 8, 4, 12, 16, 12),
            Block.createCuboidShape(4, 0, 3, 12, 5.375, 13),
            Block.createCuboidShape(0, 0, 3, 4, 8, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(3, 0, 12, 13, 8, 16),
            Block.createCuboidShape(4, 8, 4, 12, 16, 12),
            Block.createCuboidShape(3, 0, 4, 13, 5.375, 12),
            Block.createCuboidShape(3, 0, 0, 13, 8, 4)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static VoxelShape SHAPE_WEST = Stream.of(
            Block.createCuboidShape(0, 0, 3, 4, 8, 13),
            Block.createCuboidShape(4, 8, 4, 12, 16, 12),
            Block.createCuboidShape(4, 0, 3, 12, 5.375, 13),
            Block.createCuboidShape(12, 0, 3, 16, 8, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        switch (direction) {
            case NORTH -> {
                return SHAPE_NORTH;
            }
            case EAST -> {
                return SHAPE_EAST;
            }
            case SOUTH -> {
                return SHAPE_SOUTH;
            }
            case WEST -> {
                return SHAPE_WEST;
            }
            default -> {
                return SHAPE_NORTH;
            }
        }
    }

    /* BLOCK ENTITY */

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RockTumblerBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return RockTumblerBlock.checkType(world, type, BlockEntityInit.ROCK_TUMBLER_BLOCK_ENTITY);
    }

    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof RockTumblerBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
            player.incrementStat(StatsInit.INTERACT_WITH_ROCK_TUMBLER);
        }
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if ((Boolean)state.get(LIT)) {
            double d = (double)pos.getX() + 0.5;
            double e = (double)pos.getY();
            double f = (double)pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                world.playSound(d, e, f, SoundEvents.BLOCK_GRAVEL_STEP, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
            double j = random.nextDouble() * 9.0 / 16.0;
            double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;
            world.addParticle(ParticleTypes.ASH, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        }
    }
}
