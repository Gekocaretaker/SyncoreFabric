package com.gekocaretaker.syncore.item;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ItemInit {
    public static final RegistryKey<Item> COAL_NUGGET_KEY = key("coal_nugget");
    public static final RegistryKey<Item> COPPER_NUGGET_KEY = key("copper_nugget");
    public static final RegistryKey<Item> ROUGH_DIAMOND_KEY = key("rough_diamond");
    public static final RegistryKey<Item> DIAMOND_SHARD_KEY = key("diamond_shard");
    public static final RegistryKey<Item> NETHERITE_NUGGET_KEY = key("netherite_nugget");
    public static final RegistryKey<Item> ROUGH_EMERALD_KEY = key("rough_emerald");
    public static final RegistryKey<Item> EMERALD_SHARD_KEY = key("emerald_shard");
    public static final RegistryKey<Item> ROUGH_LAPIS_LAZULI_KEY = key("rough_lapis_lazuli");
    public static final RegistryKey<Item> LAPIS_LAZULI_SHARD_KEY = key("lapis_lazuli_shard");
    public static final RegistryKey<Item> ROUGH_REDSTONE_KEY = key("rough_redstone");
    public static final RegistryKey<Item> REDSTONE_GEMSTONE_KEY = key("redstone_gemstone");
    public static final RegistryKey<Item> CHARCOAL_NUGGET_KEY = key("charcoal_nugget");
    public static final RegistryKey<Item> ROUGH_QUARTZ_KEY = key("rough_quartz");
    public static final RegistryKey<Item> QUARTZ_SHARD_KEY = key("quartz_shard");
    public static final RegistryKey<Item> RESIN_NUGGET_KEY = key("resin_nugget");

    public static final Item COAL_NUGGET = register(new Item(new Item.Settings()
            .registryKey(COAL_NUGGET_KEY)), "coal_nugget");
    public static final Item COPPER_NUGGET = register(new Item(new Item.Settings()
            .registryKey(COPPER_NUGGET_KEY)), "copper_nugget");
    public static final Item ROUGH_DIAMOND = register(new Item(new Item.Settings()
            .registryKey(ROUGH_DIAMOND_KEY)), "rough_diamond");
    public static final Item DIAMOND_SHARD = register(new Item(new Item.Settings()
            .registryKey(DIAMOND_SHARD_KEY)), "diamond_shard");
    public static final Item NETHERITE_NUGGET = register(new Item(new Item.Settings()
            .registryKey(NETHERITE_NUGGET_KEY)), "netherite_nugget");
    public static final Item ROUGH_EMERALD = register(new Item(new Item.Settings()
            .registryKey(ROUGH_EMERALD_KEY)), "rough_emerald");
    public static final Item EMERALD_SHARD = register(new Item(new Item.Settings()
            .registryKey(EMERALD_SHARD_KEY)), "emerald_shard");
    public static final Item ROUGH_LAPIS_LAZULI = register(new Item(new Item.Settings()
            .registryKey(ROUGH_LAPIS_LAZULI_KEY)), "rough_lapis_lazuli");
    public static final Item LAPIS_LAZULI_SHARD = register(new Item(new Item.Settings()
            .registryKey(LAPIS_LAZULI_SHARD_KEY)), "lapis_lazuli_shard");
    public static final Item ROUGH_REDSTONE = register(new Item(new Item.Settings()
            .registryKey(ROUGH_REDSTONE_KEY)), "rough_redstone");
    public static final Item REDSTONE_GEMSTONE = register(new Item(new Item.Settings()
            .registryKey(REDSTONE_GEMSTONE_KEY)
            .trimMaterial(ArmorTrimMaterials.REDSTONE)), "redstone_gemstone");
    public static final Item CHARCOAL_NUGGET = register(new Item(new Item.Settings()
            .registryKey(CHARCOAL_NUGGET_KEY)), "charcoal_nugget");
    public static final Item ROUGH_QUARTZ = register(new Item(new Item.Settings()
            .registryKey(ROUGH_QUARTZ_KEY)), "rough_quartz");
    public static final Item QUARTZ_SHARD = register(new Item(new Item.Settings()
            .registryKey(QUARTZ_SHARD_KEY)), "quartz_shard");
    public static final Item RESIN_NUGGET = register(new Item(new Item.Settings()
            .registryKey(RESIN_NUGGET_KEY)), "resin_nugget");

    public static void init() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(CHARCOAL_NUGGET, context.baseSmeltTime());
            builder.add(BlockInit.CHARCOAL_BLOCK, context.baseSmeltTime() * 80);
        });
    }

    private static RegistryKey<Item> key(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Syncore.identify(id));
    }

    private static Item register(Item item, String id) {
        Registry.register(Registries.ITEM, Syncore.identify(id), item);
        return item;
    }
}
