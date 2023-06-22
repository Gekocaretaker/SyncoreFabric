package com.gekocaretaker.syncore.block.entity;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class BlockEntityInit {
    public static final BlockEntityType ROCK_TUMBLER_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Syncore.MOD_ID, "rock_tumbler"),
            BlockEntityType.Builder.create(RockTumblerBlockEntity::new, BlockInit.ROCK_TUMBLER_BLOCK)
                    .build(null));;

    public static void init() {
        Syncore.LOGGER.info("Rock Tumbler initialized.");
    }
}
