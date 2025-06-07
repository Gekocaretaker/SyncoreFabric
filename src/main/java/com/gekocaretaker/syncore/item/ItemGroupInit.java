package com.gekocaretaker.syncore.item;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ItemGroupInit {
    public static final RegistryKey<ItemGroup> SYNCORE_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Syncore.identify("general"));

    public static void init() {
        register(SYNCORE_GROUP, new ItemStack(ItemInit.ROUGH_DIAMOND), Text.translatable("itemGroup.syncore.general"));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(c -> {
            c.addAfter(Items.BLAST_FURNACE, new ItemStack(BlockInit.ROCK_TUMBLER_BLOCK));
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(c -> {
            c.add(new ItemStack(BlockInit.GRIT_BLOCK));
        });

        ItemGroupEvents.modifyEntriesEvent(SYNCORE_GROUP).register(c -> {
            // Amethyst
            c.add(new ItemStack(Items.BUDDING_AMETHYST));
            c.add(new ItemStack(Items.AMETHYST_CLUSTER));
            c.add(new ItemStack(Items.AMETHYST_SHARD));
            c.add(new ItemStack(Items.AMETHYST_BLOCK));
            // Charcoal
            c.add(new ItemStack(ItemInit.CHARCOAL_NUGGET));
            c.add(new ItemStack(Items.CHARCOAL));
            c.add(new ItemStack(BlockInit.CHARCOAL_BLOCK));
            // Coal
            c.add(new ItemStack(Items.COAL_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_COAL_ORE));
            c.add(new ItemStack(BlockInit.NETHER_COAL_ORE));
            c.add(new ItemStack(ItemInit.COAL_NUGGET));
            c.add(new ItemStack(Items.COAL));
            c.add(new ItemStack(Items.COAL_BLOCK));
            // Copper
            c.add(new ItemStack(Items.COPPER_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_COPPER_ORE));
            c.add(new ItemStack(BlockInit.NETHER_COPPER_ORE));
            c.add(new ItemStack(Items.RAW_COPPER));
            c.add(new ItemStack(Items.RAW_COPPER_BLOCK));
            c.add(new ItemStack(ItemInit.COPPER_NUGGET));
            c.add(new ItemStack(Items.COPPER_INGOT));
            c.add(new ItemStack(Items.COPPER_BLOCK));
            // Diamond
            c.add(new ItemStack(Items.DIAMOND_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_DIAMOND_ORE));
            c.add(new ItemStack(BlockInit.NETHER_DIAMOND_ORE));
            c.add(new ItemStack(ItemInit.ROUGH_DIAMOND));
            c.add(new ItemStack(BlockInit.ROUGH_DIAMOND_BLOCK));
            c.add(new ItemStack(ItemInit.DIAMOND_SHARD));
            c.add(new ItemStack(Items.DIAMOND));
            c.add(new ItemStack(Items.DIAMOND_BLOCK));
            // Emerald
            c.add(new ItemStack(Items.EMERALD_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_EMERALD_ORE));
            c.add(new ItemStack(BlockInit.NETHER_EMERALD_ORE));
            c.add(new ItemStack(ItemInit.ROUGH_EMERALD));
            c.add(new ItemStack(BlockInit.ROUGH_EMERALD_BLOCK));
            c.add(new ItemStack(ItemInit.EMERALD_SHARD));
            c.add(new ItemStack(Items.EMERALD));
            c.add(new ItemStack(Items.EMERALD_BLOCK));
            // Gold
            c.add(new ItemStack(Items.GOLD_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_GOLD_ORE));
            c.add(new ItemStack(Items.NETHER_GOLD_ORE));
            c.add(new ItemStack(Items.RAW_GOLD));
            c.add(new ItemStack(Items.RAW_GOLD_BLOCK));
            c.add(new ItemStack(Items.GOLD_NUGGET));
            c.add(new ItemStack(Items.GOLD_INGOT));
            c.add(new ItemStack(Items.GOLD_BLOCK));
            // Iron
            c.add(new ItemStack(Items.IRON_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_IRON_ORE));
            c.add(new ItemStack(BlockInit.NETHER_IRON_ORE));
            c.add(new ItemStack(Items.RAW_IRON));
            c.add(new ItemStack(Items.RAW_IRON_BLOCK));
            c.add(new ItemStack(Items.IRON_NUGGET));
            c.add(new ItemStack(Items.IRON_INGOT));
            c.add(new ItemStack(Items.IRON_BLOCK));
            // Lapis Lazuli
            c.add(new ItemStack(Items.LAPIS_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_LAPIS_ORE));
            c.add(new ItemStack(BlockInit.NETHER_LAPIS_LAZULI_ORE));
            c.add(new ItemStack(ItemInit.ROUGH_LAPIS_LAZULI));
            c.add(new ItemStack(BlockInit.ROUGH_LAPIS_LAZULI_BLOCK));
            c.add(new ItemStack(ItemInit.LAPIS_LAZULI_SHARD));
            c.add(new ItemStack(Items.LAPIS_LAZULI));
            c.add(new ItemStack(Items.LAPIS_BLOCK));
            // Netherite
            c.add(new ItemStack(Items.ANCIENT_DEBRIS));
            c.add(new ItemStack(Items.NETHERITE_SCRAP));
            c.add(new ItemStack(BlockInit.RAW_NETHERITE_BLOCK));
            c.add(new ItemStack(ItemInit.NETHERITE_NUGGET));
            c.add(new ItemStack(Items.NETHERITE_INGOT));
            c.add(new ItemStack(Items.NETHERITE_BLOCK));
            // Quartz
            c.add(new ItemStack(BlockInit.QUARTZ_ORE));
            c.add(new ItemStack(BlockInit.DEEPSLATE_QUARTZ_ORE));
            c.add(new ItemStack(Items.NETHER_QUARTZ_ORE));
            c.add(new ItemStack(ItemInit.ROUGH_QUARTZ));
            c.add(new ItemStack(BlockInit.ROUGH_QUARTZ_BLOCK));
            c.add(new ItemStack(ItemInit.QUARTZ_SHARD));
            c.add(new ItemStack(Items.QUARTZ));
            c.add(new ItemStack(Items.QUARTZ_BLOCK));
            // Redstone
            c.add(new ItemStack(Items.REDSTONE_ORE));
            c.add(new ItemStack(Items.DEEPSLATE_REDSTONE_ORE));
            c.add(new ItemStack(BlockInit.NETHER_REDSTONE_ORE));
            c.add(new ItemStack(ItemInit.ROUGH_REDSTONE));
            c.add(new ItemStack(BlockInit.ROUGH_REDSTONE_BLOCK));
            c.add(new ItemStack(Items.REDSTONE));
            c.add(new ItemStack(ItemInit.REDSTONE_GEMSTONE));
            c.add(new ItemStack(Items.REDSTONE_BLOCK));
            // Resin
            c.add(new ItemStack(Items.RESIN_CLUMP));
            c.add(new ItemStack(Items.RESIN_BLOCK));
            c.add(new ItemStack(ItemInit.RESIN_NUGGET));
            c.add(new ItemStack(Items.RESIN_BRICK));
            c.add(new ItemStack(Items.RESIN_BRICKS));
        });
    }

    private static void register(RegistryKey<ItemGroup> group, ItemStack icon, Text name) {
        Registry.register(Registries.ITEM_GROUP, group, FabricItemGroup.builder()
                .icon(() -> icon)
                .displayName(name)
                .build());
    }
}
