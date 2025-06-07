package com.gekocaretaker.syncore.client.datagen;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.compat.advancednetherite.datagen.ANLangProvider;
import com.gekocaretaker.syncore.compat.moreores.datagen.MOLangProvider;
import com.gekocaretaker.syncore.item.ItemGroupInit;
import com.gekocaretaker.syncore.item.ItemInit;
import com.gekocaretaker.syncore.item.ItemTagInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SyncoreLanguageProvider extends FabricLanguageProvider {
    protected SyncoreLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder trans) {
        trans.add(BlockInit.ROCK_TUMBLER_BLOCK, "Rock Tumbler");
        trans.add(BlockInit.ROUGH_DIAMOND_BLOCK, "Block of Rough Diamond");
        trans.add(BlockInit.RAW_NETHERITE_BLOCK, "Block of Raw Netherite");
        trans.add(BlockInit.ROUGH_EMERALD_BLOCK, "Block of Rough Emerald");
        trans.add(BlockInit.ROUGH_LAPIS_LAZULI_BLOCK, "Block of Rough Lapis Lazuli");
        trans.add(BlockInit.ROUGH_REDSTONE_BLOCK, "Block of Rough Redstone");
        trans.add(BlockInit.CHARCOAL_BLOCK, "Block of Charcoal");
        trans.add(BlockInit.ROUGH_QUARTZ_BLOCK, "Block of Rough Quartz");
        trans.add(BlockInit.GRIT_BLOCK, "Tumbling Grit");
        trans.add(BlockInit.NETHER_COAL_ORE, "Nether Coal Ore");
        trans.add(BlockInit.NETHER_IRON_ORE, "Nether Iron Ore");
        trans.add(BlockInit.NETHER_COPPER_ORE, "Nether Copper Ore");
        trans.add(BlockInit.NETHER_DIAMOND_ORE, "Nether Diamond Ore");
        trans.add(BlockInit.NETHER_EMERALD_ORE, "Nether Emerald Ore");
        trans.add(BlockInit.NETHER_LAPIS_LAZULI_ORE, "Nether Lapis Lazuli Ore");
        trans.add(BlockInit.NETHER_REDSTONE_ORE, "Nether Redstone Ore");
        trans.add(BlockInit.QUARTZ_ORE, "Quartz Ore");
        trans.add(BlockInit.DEEPSLATE_QUARTZ_ORE, "Deepslate Quartz Ore");

        trans.add("container.rock_tumbler", "Rock Tumbler");
        trans.add("gui.recipebook.toggleRecipes.tumblable", "Showing Tumblable");

        trans.add("category.rei.tumbling", "Tumbling");
        trans.add("emi.category.syncore.tumbling", "Tumbling");
        trans.add("gui.jei.category.tumbling", "Tumbling");

        trans.add(ItemGroupInit.SYNCORE_GROUP, "Sync Ore (Vanilla)");

        trans.add(ItemInit.COAL_NUGGET, "Coal Nugget");
        trans.add(ItemInit.COPPER_NUGGET, "Copper Nugget");
        trans.add(ItemInit.ROUGH_DIAMOND, "Rough Diamond");
        trans.add(ItemInit.DIAMOND_SHARD, "Diamond Shard");
        trans.add(ItemInit.NETHERITE_NUGGET, "Netherite Nugget");
        trans.add(ItemInit.ROUGH_EMERALD, "Rough Emerald");
        trans.add(ItemInit.EMERALD_SHARD, "Emerald Shard");
        trans.add(ItemInit.ROUGH_LAPIS_LAZULI, "Rough Lapis Lazuli");
        trans.add(ItemInit.LAPIS_LAZULI_SHARD, "Lapis Lazuli Shard");
        trans.add(ItemInit.ROUGH_REDSTONE, "Rough Redstone");
        trans.add(ItemInit.REDSTONE_GEMSTONE, "Redstone Gemstone");
        trans.add(ItemInit.CHARCOAL_NUGGET, "Charcoal Nugget");
        trans.add(ItemInit.ROUGH_QUARTZ, "Rough Quartz");
        trans.add(ItemInit.QUARTZ_SHARD, "Quartz Shard");
        trans.add(ItemInit.RESIN_NUGGET, "Resin Nugget");

        trans.add("stat.syncore.interact_with_rock_tumbler", "Interactions with Rock Tumbler");

        advancement(trans, "adventure.trade_tumble",
                "First We Trade, Then We Tumble",
                "Tumble a piece of diamond gear you got from a villager, then question why you play TradeTumble instead of MineCraft.");
        advancement(trans, "nether.blast_it_all",
                "Blast it All",
                "You blasted all 9 pieces of netherite gear and crafted the resulting nuggets into an ingot. Congrats! Now reevaluate everything that led you here.");

        /*advancement(trans, "collection.root",
                "Syncore Collection",
                "Try to collect one of each item & block!");*/

        trans.add(ItemTagInit.SHARDS, "Shards");
        trans.add(ItemTagInit.DIAMOND_SHARDS, "Diamond Shards");
        trans.add(ItemTagInit.EMERALD_SHARDS, "Emerald Shards");
        trans.add(ItemTagInit.QUARTZ_SHARDS, "Quartz Shards");
        trans.add(ItemTagInit.LAPIS_SHARDS, "Lapis Shards");

        trans.add(ItemTagInit.STORAGE_BLOCKS_ROUGH_QUARTZ, "Rough Quartz Storage Blocks");
        trans.add(ItemTagInit.DIAMOND_ROUGH_MATERIALS, "Rough Diamond Materials");
        trans.add(ItemTagInit.QUARTZ_ROUGH_MATERIALS, "Rough Quartz Materials");
        trans.add(ItemTagInit.COAL_NUGGETS, "Coal Nuggets");
        trans.add(ItemTagInit.STORAGE_BLOCKS_ROUGH_LAPIS, "Rough Lapis Storage Blocks");
        trans.add(ItemTagInit.STORAGE_BLOCKS_RAW_NETHERITE, "Raw Netherite Storage Blocks");
        trans.add(ItemTagInit.EMERALD_ROUGH_MATERIALS, "Rough Emerald Materials");
        trans.add(ItemTagInit.COPPER_NUGGETS, "Copper Nuggets");
        trans.add(ItemTagInit.REDSTONE_GEMS, "Redstone Gems");
        trans.add(ItemTagInit.STORAGE_BLOCKS_ROUGH_DIAMOND, "Rough Diamond Storage Blocks");
        trans.add(ItemTagInit.LAPIS_ROUGH_MATERIALS, "Rough Lapis Materials");
        trans.add(ItemTagInit.STORAGE_BLOCKS_ROUGH_REDSTONE, "Rough Redstone Storage Blocks");
        trans.add(ItemTagInit.STORAGE_BLOCKS_ROUGH_EMERALD, "Rough Emerald Storage Blocks");
        trans.add(ItemTagInit.NETHERITE_NUGGETS, "Netherite Nuggets");
        trans.add(ItemTagInit.REDSTONE_ROUGH_MATERIALS, "Rough Redstone Materials");
        trans.add(ItemTagInit.CHARCOAL_NUGGETS, "Charcoal Nuggets");
        trans.add(ItemTagInit.STORAGE_BLOCKS_CHARCOAL, "Charcoal Storage Blocks");

        if (Syncore.isModPresent("more-ores")) {
            MOLangProvider.INSTANCE.provide(trans);
        }
        if (Syncore.isModPresent("advancednetherite")) {
            ANLangProvider.INSTANCE.provide(trans);
        }
    }

    private void advancement(TranslationBuilder trans, String path, String title, String description) {
        trans.add("advancements.syncore." + path + ".title", title);
        trans.add("advancements.syncore." + path + ".description", description);
    }
}
