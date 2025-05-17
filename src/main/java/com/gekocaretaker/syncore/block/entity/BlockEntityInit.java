package com.gekocaretaker.syncore.block.entity;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockEntityInit {
    public static final BlockEntityType<RockTumblerBlockEntity> ROCK_TUMBLER_BLOCK_ENTITY = register(
            "rock_tumbler", RockTumblerBlockEntity::new, BlockInit.ROCK_TUMBLER_BLOCK
    );

    public static void init() {
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name,
                                                                       FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
                                                                       Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Syncore.identify(name), FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}
