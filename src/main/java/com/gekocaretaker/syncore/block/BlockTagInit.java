package com.gekocaretaker.syncore.block;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BlockTagInit {
    public static final TagKey<Block> STORAGE_BLOCKS_CHARCOAL = rC("storage_blocks/charcoal");
    public static final TagKey<Block> STORAGE_BLOCKS_ROUGH_DIAMOND = rC("storage_blocks/rough_diamond");
    public static final TagKey<Block> STORAGE_BLOCKS_ROUGH_EMERALD = rC("storage_blocks/rough_emerald");
    public static final TagKey<Block> STORAGE_BLOCKS_ROUGH_LAPIS = rC("storage_blocks/rough_lapis");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_NETHERITE = rC("storage_blocks/raw_netherite");
    public static final TagKey<Block> STORAGE_BLOCKS_ROUGH_QUARTZ = rC("storage_blocks/rough_quartz");
    public static final TagKey<Block> STORAGE_BLOCKS_ROUGH_REDSTONE = rC("storage_blocks/rough_redstone");

    private BlockTagInit() {}

    private static TagKey<Block> rS(String path) {
        return r(Syncore.identify(path));
    }

    private static TagKey<Block> rC(String path) {
        return r(Identifier.of("c", path));
    }

    private static TagKey<Block> r(Identifier id) {
        return TagKey.of(RegistryKeys.BLOCK, id);
    }

    public static void init() {}
}
