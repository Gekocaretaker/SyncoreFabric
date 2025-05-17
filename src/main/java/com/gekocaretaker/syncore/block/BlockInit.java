package com.gekocaretaker.syncore.block;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.SandBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.ColorCode;

public class BlockInit {
    public static final RegistryKey<Block> ROCK_TUMBLER_BLOCK_KEY = key("rock_tumbler");
    public static final RegistryKey<Block> ROUGH_DIAMOND_BLOCK_KEY = key("rough_diamond_block");
    public static final RegistryKey<Block> RAW_NETHERITE_BLOCK_KEY = key("raw_netherite_block");
    public static final RegistryKey<Block> ROUGH_EMERALD_BLOCK_KEY = key("rough_emerald_block");
    public static final RegistryKey<Block> ROUGH_LAPIS_LAZULI_BLOCK_KEY = key("rough_lapis_lazuli_block");
    public static final RegistryKey<Block> ROUGH_REDSTONE_BLOCK_KEY = key("rough_redstone_block");
    public static final RegistryKey<Block> CHARCOAL_BLOCK_KEY = key("charcoal_block");
    public static final RegistryKey<Block> ROUGH_QUARTZ_BLOCK_KEY = key("rough_quartz_block");
    public static final RegistryKey<Block> GRIT_KEY = key("grit");

    public static final Block ROCK_TUMBLER_BLOCK = register(new RockTumblerBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.GRAY).requiresTool()
                    .strength(4.0f, 5.0f).sounds(BlockSoundGroup.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .nonOpaque().registryKey(ROCK_TUMBLER_BLOCK_KEY)), "rock_tumbler");
    public static final Block ROUGH_DIAMOND_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_DIAMOND_BLOCK_KEY)), "rough_diamond_block");
    public static final Block RAW_NETHERITE_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)
                    .registryKey(RAW_NETHERITE_BLOCK_KEY)), "raw_netherite_block");
    public static final Block ROUGH_EMERALD_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_EMERALD_BLOCK_KEY)), "rough_emerald_block");
    public static final Block ROUGH_LAPIS_LAZULI_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.LAPIS_BLUE).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_LAPIS_LAZULI_BLOCK_KEY)), "rough_lapis_lazuli_block");
    public static final Block ROUGH_REDSTONE_BLOCK = register(new RoughRedstoneBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .registryKey(ROUGH_REDSTONE_BLOCK_KEY)), "rough_redstone_block");
    public static final Block CHARCOAL_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).requiresTool()
                    .strength(5.0f, 6.0f)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .registryKey(CHARCOAL_BLOCK_KEY)), "charcoal_block");
    public static final Block ROUGH_QUARTZ_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.WHITE).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_QUARTZ_BLOCK_KEY)), "rough_quartz_block");
    public static final Block GRIT_BLOCK = register(new SandBlock(
            new ColorCode(3815994),
            AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)
                    .registryKey(GRIT_KEY)), "grit");

    public static void init() {
    }

    private static Block register(Block block, String id) {
        Registry.register(Registries.BLOCK, Syncore.identify(id), block);
        Registry.register(Registries.ITEM, Syncore.identify(id), new BlockItem(block, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Syncore.identify(id)))
                .useBlockPrefixedTranslationKey()));
        return block;
    }

    private static RegistryKey<Block> key(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Syncore.identify(id));
    }
}
