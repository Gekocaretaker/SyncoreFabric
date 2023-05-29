package com.gekocaretaker.syncore.block;

import com.gekocaretaker.syncore.Syncore;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockInit {
    public static final Block ROCK_TUMBLER_BLOCK = new RockTumblerBlock(FabricBlockSettings.of(Material.METAL, MapColor.GRAY).requiresTool().strength(4.0f, 5.0f).sounds(BlockSoundGroup.STONE).nonOpaque());
    public static final Block RAW_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.DIAMOND_BLUE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_NETHERITE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_EMERALD_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.EMERALD_GREEN).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_LAPIS_LAZULI_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.LAPIS_BLUE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_REDSTONE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.BRIGHT_RED).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block CHARCOAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.0f, 6.0f));
    public static final Block RAW_QUARTZ_BLOCK = new Block(FabricBlockSettings.of(Material.STONE, MapColor.WHITE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));

    public static void init() {
        register(ROCK_TUMBLER_BLOCK, "rock_tumbler");
        register(RAW_DIAMOND_BLOCK, "raw_diamond_block");
        register(RAW_NETHERITE_BLOCK, "raw_netherite_block");
        register(RAW_EMERALD_BLOCK, "raw_emerald_block");
        register(RAW_LAPIS_LAZULI_BLOCK, "raw_lapis_lazuli_block");
        register(RAW_REDSTONE_BLOCK, "raw_redstone_block");
        register(CHARCOAL_BLOCK, "charcoal_block");
        register(RAW_QUARTZ_BLOCK, "raw_quartz_block");
    }

    private static void register(Block block, String id) {
        Syncore.LOGGER.info("Creating block with id of '" + id + "'.");
        Registry.register(Registry.BLOCK, new Identifier(Syncore.MOD_ID, id), block);
    }
}
