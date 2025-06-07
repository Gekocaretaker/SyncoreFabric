package com.gekocaretaker.syncore.client.datagen;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.item.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public final class SyncoreLootTableProviders {
    private SyncoreLootTableProviders() {}

    public static class BlockLootTableProvider extends FabricBlockLootTableProvider {
        protected BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);

            // Vanilla
            qOre(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP);
            qOre(Blocks.DEEPSLATE_DIAMOND_ORE, ItemInit.ROUGH_DIAMOND);
            qOre(Blocks.DEEPSLATE_EMERALD_ORE, ItemInit.ROUGH_EMERALD);
            qOre(Blocks.DEEPSLATE_LAPIS_ORE, ItemInit.ROUGH_LAPIS_LAZULI);
            qOre(Blocks.DEEPSLATE_REDSTONE_ORE, ItemInit.ROUGH_REDSTONE);
            qOre(Blocks.DIAMOND_ORE, ItemInit.ROUGH_DIAMOND);
            qOre(Blocks.EMERALD_ORE, ItemInit.ROUGH_EMERALD);
            qOre(Blocks.LAPIS_ORE, ItemInit.ROUGH_LAPIS_LAZULI);
            qOre(Blocks.NETHER_QUARTZ_ORE, ItemInit.ROUGH_QUARTZ);
            qOre(Blocks.REDSTONE_ORE, ItemInit.ROUGH_REDSTONE);

            // Syncore
            addDrop(BlockInit.CHARCOAL_BLOCK);
            addDrop(BlockInit.ROUGH_DIAMOND_BLOCK);
            addDrop(BlockInit.ROUGH_EMERALD_BLOCK);
            addDrop(BlockInit.ROUGH_LAPIS_LAZULI_BLOCK);
            addDrop(BlockInit.RAW_NETHERITE_BLOCK);
            addDrop(BlockInit.ROUGH_QUARTZ_BLOCK);
            addDrop(BlockInit.ROUGH_REDSTONE_BLOCK);
            addDrop(BlockInit.ROCK_TUMBLER_BLOCK);
            addDrop(BlockInit.GRIT_BLOCK);
            nuggetOre(BlockInit.NETHER_COAL_ORE, ItemInit.COAL_NUGGET, impl);
            nuggetOre(BlockInit.NETHER_IRON_ORE, Items.IRON_NUGGET, impl);
            nuggetOre(BlockInit.NETHER_COPPER_ORE, ItemInit.COPPER_NUGGET, impl);
            nuggetOre(BlockInit.NETHER_DIAMOND_ORE, ItemInit.DIAMOND_SHARD, impl);
            nuggetOre(BlockInit.NETHER_EMERALD_ORE, ItemInit.EMERALD_SHARD, impl);
            nuggetOre(BlockInit.NETHER_LAPIS_LAZULI_ORE, ItemInit.LAPIS_LAZULI_SHARD, impl);
            nuggetOre(BlockInit.NETHER_REDSTONE_ORE, Items.REDSTONE, impl);
            qOre(BlockInit.QUARTZ_ORE, ItemInit.ROUGH_QUARTZ);
            qOre(BlockInit.DEEPSLATE_QUARTZ_ORE, ItemInit.ROUGH_QUARTZ);
        }

        private void qOre(Block block, Item drop) {
            addDrop(block, q -> {
                return this.oreDrops(q, drop);
            });
        }

        private void nuggetOre(Block block, Item drop, RegistryWrapper.Impl<Enchantment> impl) {
            addDrop(block , q -> {
                return this.dropsWithSilkTouch(block, this.applyExplosionDecay(block, ItemEntry.builder(drop).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
            });
        }
    }
}
