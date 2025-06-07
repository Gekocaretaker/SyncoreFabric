package com.gekocaretaker.syncore.client.datagen;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.compat.advancednetherite.datagen.ANModelProvider;
import com.gekocaretaker.syncore.compat.moreores.datagen.MOModelProvider;
import com.gekocaretaker.syncore.item.ItemInit;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.item.Item;

public class SyncoreModelProvider extends FabricModelProvider {
    public SyncoreModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        gen.registerSimpleCubeAll(BlockInit.CHARCOAL_BLOCK);
        gen.registerSimpleCubeAll(BlockInit.DEEPSLATE_QUARTZ_ORE);
        gen.registerSimpleCubeAll(BlockInit.GRIT_BLOCK);
        gen.registerSimpleCubeAll(BlockInit.NETHER_COAL_ORE);
        gen.registerSimpleCubeAll(BlockInit.NETHER_COPPER_ORE);
        gen.registerSimpleCubeAll(BlockInit.NETHER_DIAMOND_ORE);
        gen.registerSimpleCubeAll(BlockInit.NETHER_EMERALD_ORE);
        gen.registerSimpleCubeAll(BlockInit.NETHER_IRON_ORE);
        gen.registerSimpleCubeAll(BlockInit.NETHER_LAPIS_LAZULI_ORE);
        gen.registerSimpleCubeAll(BlockInit.NETHER_REDSTONE_ORE);
        gen.registerSimpleCubeAll(BlockInit.QUARTZ_ORE);
        gen.registerSingleton(BlockInit.RAW_NETHERITE_BLOCK, TexturedModel.CUBE_COLUMN);
        gen.registerCooker(BlockInit.ROCK_TUMBLER_BLOCK, TexturedModel.ORIENTABLE_WITH_BOTTOM);
        gen.registerSimpleCubeAll(BlockInit.ROUGH_DIAMOND_BLOCK);
        gen.registerSimpleCubeAll(BlockInit.ROUGH_EMERALD_BLOCK);
        gen.registerSimpleCubeAll(BlockInit.ROUGH_LAPIS_LAZULI_BLOCK);
        gen.registerSimpleCubeAll(BlockInit.ROUGH_QUARTZ_BLOCK);
        gen.registerSimpleCubeAll(BlockInit.ROUGH_REDSTONE_BLOCK);

        if (Syncore.isModPresent("more-ores")) {
            MOModelProvider.INSTANCE.blocks(gen);
        }
        if (Syncore.isModPresent("advancednetherite")) {
            ANModelProvider.INSTANCE.blocks(gen);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        genDefault(ItemInit.COAL_NUGGET, gen);
        genDefault(ItemInit.CHARCOAL_NUGGET, gen);
        genDefault(ItemInit.COPPER_NUGGET, gen);
        genDefault(ItemInit.DIAMOND_SHARD, gen);
        genDefault(ItemInit.EMERALD_SHARD, gen);
        genDefault(ItemInit.LAPIS_LAZULI_SHARD, gen);
        genDefault(ItemInit.NETHERITE_NUGGET, gen);
        genDefault(ItemInit.QUARTZ_SHARD, gen);
        genDefault(ItemInit.REDSTONE_GEMSTONE, gen);
        genDefault(ItemInit.RESIN_NUGGET, gen);
        genDefault(ItemInit.ROUGH_DIAMOND, gen);
        genDefault(ItemInit.ROUGH_EMERALD, gen);
        genDefault(ItemInit.ROUGH_LAPIS_LAZULI, gen);
        genDefault(ItemInit.ROUGH_REDSTONE, gen);

        if (Syncore.isModPresent("more-ores")) {
            MOModelProvider.INSTANCE.items(gen);
        }
        if (Syncore.isModPresent("advancednetherite")) {
            ANModelProvider.INSTANCE.items(gen);
        }
    }

    public static void genDefault(Item item, ItemModelGenerator gen) {
        gen.register(item, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Syncore Model Provider";
    }
}
