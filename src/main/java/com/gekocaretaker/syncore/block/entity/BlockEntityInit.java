package com.gekocaretaker.syncore.block.entity;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityInit {
    public static final BlockEntityType ROCK_TUMBLER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
            new Identifier(Syncore.MOD_ID, "rock_tumbler"),
            BlockEntityType.Builder.create(RockTumblerBlockEntity::new, BlockInit.ROCK_TUMBLER_BLOCK)
                    .build(null));;

    public static void init() {
        Syncore.LOGGER.info("Rock Tumbler initialized.");
    }
}
