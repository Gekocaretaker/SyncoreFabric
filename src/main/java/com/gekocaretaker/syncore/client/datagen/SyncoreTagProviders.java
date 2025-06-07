package com.gekocaretaker.syncore.client.datagen;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.block.BlockTagInit;
import com.gekocaretaker.syncore.item.ItemInit;
import com.gekocaretaker.syncore.item.ItemTagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public final class SyncoreTagProviders {
    private SyncoreTagProviders() {}

    public static class ItemTagProvider extends FabricTagProvider<Item> {
        public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.ITEM, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            // Conventional
            build(ItemTagInit.CHARCOAL_NUGGETS, ItemInit.CHARCOAL_NUGGET);
            build(ItemTagInit.COAL_NUGGETS, ItemInit.COAL_NUGGET);
            build(ItemTagInit.COPPER_NUGGETS, ItemInit.COPPER_NUGGET);
            build(ItemTagInit.NETHERITE_NUGGETS, ItemInit.NETHERITE_NUGGET);
            build(ItemTagInit.RESIN_NUGGETS, ItemInit.RESIN_NUGGET);
            build(ItemTagInit.REDSTONE_GEMS, ItemInit.REDSTONE_GEMSTONE);
            build(ItemTagInit.DIAMOND_ROUGH_MATERIALS, ItemInit.ROUGH_DIAMOND);
            build(ItemTagInit.EMERALD_ROUGH_MATERIALS, ItemInit.ROUGH_EMERALD);
            build(ItemTagInit.LAPIS_ROUGH_MATERIALS, ItemInit.ROUGH_LAPIS_LAZULI);
            build(ItemTagInit.QUARTZ_ROUGH_MATERIALS, ItemInit.ROUGH_QUARTZ);
            build(ItemTagInit.REDSTONE_ROUGH_MATERIALS, ItemInit.ROUGH_REDSTONE);
            build(ItemTagInit.STORAGE_BLOCKS_CHARCOAL, BlockInit.CHARCOAL_BLOCK.asItem());
            build(ItemTagInit.STORAGE_BLOCKS_ROUGH_DIAMOND, BlockInit.ROUGH_DIAMOND_BLOCK.asItem());
            build(ItemTagInit.STORAGE_BLOCKS_ROUGH_EMERALD, BlockInit.ROUGH_EMERALD_BLOCK.asItem());
            build(ItemTagInit.STORAGE_BLOCKS_ROUGH_LAPIS, BlockInit.ROUGH_LAPIS_LAZULI_BLOCK.asItem());
            build(ItemTagInit.STORAGE_BLOCKS_RAW_NETHERITE, BlockInit.RAW_NETHERITE_BLOCK.asItem());
            build(ItemTagInit.STORAGE_BLOCKS_ROUGH_QUARTZ, BlockInit.ROUGH_QUARTZ_BLOCK.asItem());
            build(ItemTagInit.STORAGE_BLOCKS_ROUGH_REDSTONE, BlockInit.ROUGH_REDSTONE_BLOCK.asItem());
            getOrCreateTagBuilder(ConventionalItemTags.GEMS).addTag(ItemTagInit.REDSTONE_GEMS).setReplace(false);
            getOrCreateTagBuilder(ConventionalItemTags.NUGGETS).addTags(
                    ItemTagInit.COAL_NUGGETS, ItemTagInit.CHARCOAL_NUGGETS,
                    ItemTagInit.COPPER_NUGGETS, ItemTagInit.NETHERITE_NUGGETS,
                    ItemTagInit.RESIN_NUGGETS
            ).setReplace(false);
            getOrCreateTagBuilder(ConventionalItemTags.RAW_MATERIALS).addTags(
                    ItemTagInit.DIAMOND_ROUGH_MATERIALS, ItemTagInit.EMERALD_ROUGH_MATERIALS,
                    ItemTagInit.LAPIS_ROUGH_MATERIALS, ItemTagInit.QUARTZ_ROUGH_MATERIALS,
                    ItemTagInit.REDSTONE_ROUGH_MATERIALS
            ).setReplace(false);
            getOrCreateTagBuilder(ConventionalItemTags.STORAGE_BLOCKS).addTags(
                    ItemTagInit.STORAGE_BLOCKS_CHARCOAL, ItemTagInit.STORAGE_BLOCKS_ROUGH_DIAMOND,
                    ItemTagInit.STORAGE_BLOCKS_ROUGH_EMERALD, ItemTagInit.STORAGE_BLOCKS_ROUGH_LAPIS,
                    ItemTagInit.STORAGE_BLOCKS_RAW_NETHERITE, ItemTagInit.STORAGE_BLOCKS_ROUGH_QUARTZ,
                    ItemTagInit.STORAGE_BLOCKS_ROUGH_REDSTONE
            ).setReplace(false);
            build(ConventionalItemTags.QUARTZ_ORES, BlockInit.QUARTZ_ORE.asItem(),
                    BlockInit.DEEPSLATE_QUARTZ_ORE.asItem());

            // Vanilla
            build(ItemTags.TRIM_MATERIALS, ItemInit.REDSTONE_GEMSTONE);
            build(ItemTags.COAL_ORES, BlockInit.NETHER_COAL_ORE.asItem());
            build(ItemTags.IRON_ORES, BlockInit.NETHER_IRON_ORE.asItem());
            build(ItemTags.COPPER_ORES, BlockInit.NETHER_COPPER_ORE.asItem());
            build(ItemTags.DIAMOND_ORES, BlockInit.NETHER_DIAMOND_ORE.asItem());
            build(ItemTags.EMERALD_ORES, BlockInit.NETHER_EMERALD_ORE.asItem());
            build(ItemTags.LAPIS_ORES, BlockInit.NETHER_LAPIS_LAZULI_ORE.asItem());
            build(ItemTags.REDSTONE_ORES, BlockInit.NETHER_REDSTONE_ORE.asItem());

            // Syncore
            build(ItemTagInit.DIAMOND_SHARDS, ItemInit.DIAMOND_SHARD);
            build(ItemTagInit.EMERALD_SHARDS, ItemInit.EMERALD_SHARD);
            build(ItemTagInit.LAPIS_SHARDS, ItemInit.LAPIS_LAZULI_SHARD);
            build(ItemTagInit.QUARTZ_SHARDS, ItemInit.QUARTZ_SHARD);
            getOrCreateTagBuilder(ItemTagInit.SHARDS)
                    .addTags(
                            ItemTagInit.DIAMOND_SHARDS, ItemTagInit.EMERALD_SHARDS,
                            ItemTagInit.LAPIS_SHARDS, ItemTagInit.QUARTZ_SHARDS).setReplace(false);
        }

        private void build(TagKey<Item> tag, Item... items) {
            getOrCreateTagBuilder(tag).add(items).setReplace(false);
        }
    }

    public static class BlockTagProvider extends FabricTagProvider<Block> {
        public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, RegistryKeys.BLOCK, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            // Conventional
            build(BlockTagInit.STORAGE_BLOCKS_CHARCOAL, BlockInit.CHARCOAL_BLOCK);
            build(BlockTagInit.STORAGE_BLOCKS_ROUGH_DIAMOND, BlockInit.ROUGH_DIAMOND_BLOCK);
            build(BlockTagInit.STORAGE_BLOCKS_ROUGH_EMERALD, BlockInit.ROUGH_EMERALD_BLOCK);
            build(BlockTagInit.STORAGE_BLOCKS_ROUGH_LAPIS, BlockInit.ROUGH_LAPIS_LAZULI_BLOCK);
            build(BlockTagInit.STORAGE_BLOCKS_RAW_NETHERITE, BlockInit.RAW_NETHERITE_BLOCK);
            build(BlockTagInit.STORAGE_BLOCKS_ROUGH_QUARTZ, BlockInit.ROUGH_QUARTZ_BLOCK);
            build(BlockTagInit.STORAGE_BLOCKS_ROUGH_REDSTONE, BlockInit.ROUGH_REDSTONE_BLOCK);
            getOrCreateTagBuilder(ConventionalBlockTags.STORAGE_BLOCKS).addTags(
                    BlockTagInit.STORAGE_BLOCKS_CHARCOAL, BlockTagInit.STORAGE_BLOCKS_ROUGH_DIAMOND,
                    BlockTagInit.STORAGE_BLOCKS_ROUGH_EMERALD, BlockTagInit.STORAGE_BLOCKS_ROUGH_LAPIS,
                    BlockTagInit.STORAGE_BLOCKS_RAW_NETHERITE, BlockTagInit.STORAGE_BLOCKS_ROUGH_QUARTZ,
                    BlockTagInit.STORAGE_BLOCKS_ROUGH_REDSTONE
            ).setReplace(false);
            build(ConventionalBlockTags.QUARTZ_ORES, BlockInit.QUARTZ_ORE,
                    BlockInit.DEEPSLATE_QUARTZ_ORE);
            // Maybe will add ore spawning?
            /*build(ConventionalBlockTags.ORE_RATES_SPARSE, BlockInit.NETHER_COAL_ORE,
                    BlockInit.NETHER_IRON_ORE, BlockInit.NETHER_COPPER_ORE, BlockInit.NETHER_DIAMOND_ORE,
                    BlockInit.NETHER_EMERALD_ORE, BlockInit.NETHER_LAPIS_LAZULI, BlockInit.NETHER_REDSTONE_ORE);
            build(ConventionalBlockTags.ORES_IN_GROUND_NETHERRACK, BlockInit.NETHER_COAL_ORE,
                    BlockInit.NETHER_IRON_ORE, BlockInit.NETHER_COPPER_ORE, BlockInit.NETHER_DIAMOND_ORE,
                    BlockInit.NETHER_EMERALD_ORE, BlockInit.NETHER_LAPIS_LAZULI, BlockInit.NETHER_REDSTONE_ORE);*/

            // Vanilla
            build(BlockTags.PICKAXE_MINEABLE, BlockInit.ROCK_TUMBLER_BLOCK,
                    BlockInit.ROUGH_DIAMOND_BLOCK, BlockInit.ROUGH_EMERALD_BLOCK, BlockInit.RAW_NETHERITE_BLOCK,
                    BlockInit.ROUGH_LAPIS_LAZULI_BLOCK, BlockInit.ROUGH_REDSTONE_BLOCK, BlockInit.ROUGH_QUARTZ_BLOCK,
                    BlockInit.CHARCOAL_BLOCK, BlockInit.NETHER_COAL_ORE, BlockInit.NETHER_IRON_ORE,
                    BlockInit.NETHER_COPPER_ORE, BlockInit.NETHER_DIAMOND_ORE, BlockInit.NETHER_EMERALD_ORE,
                    BlockInit.NETHER_LAPIS_LAZULI_ORE, BlockInit.NETHER_REDSTONE_ORE);
            build(BlockTags.NEEDS_DIAMOND_TOOL, BlockInit.RAW_NETHERITE_BLOCK);
            build(BlockTags.NEEDS_IRON_TOOL, BlockInit.ROUGH_DIAMOND_BLOCK,
                    BlockInit.ROUGH_EMERALD_BLOCK, BlockInit.ROUGH_REDSTONE_BLOCK, BlockInit.NETHER_DIAMOND_ORE,
                    BlockInit.NETHER_EMERALD_ORE, BlockInit.NETHER_REDSTONE_ORE);
            build(BlockTags.NEEDS_STONE_TOOL, BlockInit.ROUGH_LAPIS_LAZULI_BLOCK,
                    BlockInit.CHARCOAL_BLOCK, BlockInit.ROUGH_QUARTZ_BLOCK, BlockInit.NETHER_IRON_ORE,
                    BlockInit.NETHER_COPPER_ORE, BlockInit.NETHER_REDSTONE_ORE);
            build(BlockTags.COAL_ORES, BlockInit.NETHER_COAL_ORE);
            build(BlockTags.IRON_ORES, BlockInit.NETHER_IRON_ORE);
            build(BlockTags.COPPER_ORES, BlockInit.NETHER_COPPER_ORE);
            build(BlockTags.DIAMOND_ORES, BlockInit.NETHER_DIAMOND_ORE);
            build(BlockTags.EMERALD_ORES, BlockInit.NETHER_EMERALD_ORE);
            build(BlockTags.LAPIS_ORES, BlockInit.NETHER_LAPIS_LAZULI_ORE);
            build(BlockTags.REDSTONE_ORES, BlockInit.NETHER_REDSTONE_ORE);
        }

        private void build(TagKey<Block> tag, Block... blocks) {
            getOrCreateTagBuilder(tag).add(blocks).setReplace(false);
        }
    }
}
