package com.gekocaretaker.syncore.block;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BlockInit {
    public static final RegistryKey<Block> ROCK_TUMBLER_BLOCK_KEY = key("rock_tumbler");

    public static final RegistryKey<Block> RAW_NETHERITE_BLOCK_KEY = key("raw_netherite_block");
    public static final RegistryKey<Block> ROUGH_DIAMOND_BLOCK_KEY = key("rough_diamond_block");
    public static final RegistryKey<Block> ROUGH_EMERALD_BLOCK_KEY = key("rough_emerald_block");
    public static final RegistryKey<Block> ROUGH_LAPIS_LAZULI_BLOCK_KEY = key("rough_lapis_lazuli_block");
    public static final RegistryKey<Block> ROUGH_REDSTONE_BLOCK_KEY = key("rough_redstone_block");
    public static final RegistryKey<Block> ROUGH_QUARTZ_BLOCK_KEY = key("rough_quartz_block");

    public static final RegistryKey<Block> CHARCOAL_BLOCK_KEY = key("charcoal_block");
    public static final RegistryKey<Block> GRIT_KEY = key("grit");

    public static final RegistryKey<Block> NETHER_COAL_ORE_KEY = key("nether_coal_ore");
    public static final RegistryKey<Block> NETHER_IRON_ORE_KEY = key("nether_iron_ore");
    public static final RegistryKey<Block> NETHER_COPPER_ORE_KEY = key("nether_copper_ore");
    public static final RegistryKey<Block> NETHER_DIAMOND_ORE_KEY = key("nether_diamond_ore");
    public static final RegistryKey<Block> NETHER_EMERALD_ORE_KEY = key("nether_emerald_ore");
    public static final RegistryKey<Block> NETHER_LAPIS_LAZULI_ORE_KEY = key("nether_lapis_lazuli_ore");
    public static final RegistryKey<Block> NETHER_REDSTONE_ORE_KEY = key("nether_redstone_ore");
    public static final RegistryKey<Block> QUARTZ_ORE_KEY = key("quartz_ore");
    public static final RegistryKey<Block> DEEPSLATE_QUARTZ_ORE_KEY = key("deepslate_quartz_ore");

    public static final Block ROCK_TUMBLER_BLOCK = register(new RockTumblerBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.GRAY).requiresTool()
                    .strength(4.0f, 5.0f).sounds(BlockSoundGroup.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .nonOpaque().registryKey(ROCK_TUMBLER_BLOCK_KEY)
    ), "rock_tumbler");

    public static final Block RAW_NETHERITE_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)
                    .registryKey(RAW_NETHERITE_BLOCK_KEY)
    ), "raw_netherite_block");
    public static final Block ROUGH_DIAMOND_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_DIAMOND_BLOCK_KEY)
    ), "rough_diamond_block");
    public static final Block ROUGH_EMERALD_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_EMERALD_BLOCK_KEY)
    ), "rough_emerald_block");
    public static final Block ROUGH_LAPIS_LAZULI_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.LAPIS_BLUE).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_LAPIS_LAZULI_BLOCK_KEY)
    ), "rough_lapis_lazuli_block");
    public static final Block ROUGH_REDSTONE_BLOCK = register(new RoughRedstoneBlock(
            AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .registryKey(ROUGH_REDSTONE_BLOCK_KEY)
    ), "rough_redstone_block");
    public static final Block ROUGH_QUARTZ_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.WHITE).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .registryKey(ROUGH_QUARTZ_BLOCK_KEY)
    ), "rough_quartz_block");

    public static final Block CHARCOAL_BLOCK = register(new Block(
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).requiresTool()
                    .strength(5.0f, 6.0f)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .registryKey(CHARCOAL_BLOCK_KEY)
    ), "charcoal_block");
    public static final Block GRIT_BLOCK = register(new SandBlock(
            new ColorCode(3815994),
            AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)
                    .registryKey(GRIT_KEY)
    ), "grit");

    public static final Block NETHER_COAL_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM).strength(3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE)
                    .registryKey(NETHER_COAL_ORE_KEY)
    ), "nether_coal_ore");
    public static final Block NETHER_IRON_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.copyShallow(Blocks.NETHER_GOLD_ORE)
                    .registryKey(NETHER_IRON_ORE_KEY)
    ), "nether_iron_ore");
    public static final Block NETHER_COPPER_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.copyShallow(Blocks.NETHER_GOLD_ORE)
                    .registryKey(NETHER_COPPER_ORE_KEY)
    ), "nether_copper_ore");
    public static final Block NETHER_DIAMOND_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.copyShallow(Blocks.NETHER_GOLD_ORE)
                    .registryKey(NETHER_DIAMOND_ORE_KEY)
    ), "nether_diamond_ore");
    public static final Block NETHER_EMERALD_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.copyShallow(Blocks.NETHER_GOLD_ORE)
                    .registryKey(NETHER_EMERALD_ORE_KEY)
    ), "nether_emerald_ore");
    public static final Block NETHER_LAPIS_LAZULI_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.copyShallow(Blocks.NETHER_GOLD_ORE)
                    .registryKey(NETHER_LAPIS_LAZULI_ORE_KEY)
    ), "nether_lapis_lazuli_ore");
    public static final Block NETHER_REDSTONE_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(0, 1),
            AbstractBlock.Settings.copyShallow(Blocks.NETHER_GOLD_ORE)
                    .registryKey(NETHER_REDSTONE_ORE_KEY)
    ), "nether_redstone_ore");
    public static final Block QUARTZ_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresTool()
                    .strength(3.0F).sounds(BlockSoundGroup.STONE)
                    .registryKey(QUARTZ_ORE_KEY)
    ), "quartz_ore");
    public static final Block DEEPSLATE_QUARTZ_ORE = register(new ExperienceDroppingBlock(
            UniformIntProvider.create(2, 5),
            AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM).requiresTool()
                    .strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)
                    .registryKey(DEEPSLATE_QUARTZ_ORE_KEY)
    ), "deepslate_quartz_ore");

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
