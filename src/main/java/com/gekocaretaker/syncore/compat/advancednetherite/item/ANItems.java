package com.gekocaretaker.syncore.compat.advancednetherite.item;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ANItems {
    public static final RegistryKey<Item> NETHERITE_IRON_NUGGET_KEY = key("netherite_iron_nugget");
    public static final RegistryKey<Item> NETHERITE_GOLD_NUGGET_KEY = key("netherite_gold_nugget");
    public static final RegistryKey<Item> NETHERITE_EMERALD_NUGGET_KEY = key("netherite_emerald_nugget");
    public static final RegistryKey<Item> NETHERITE_DIAMOND_NUGGET_KEY = key("netherite_diamond_nugget");

    public static final Item NETHERITE_IRON_NUGGET = register(new Item(new Item.Settings()
            .registryKey(NETHERITE_IRON_NUGGET_KEY)), "netherite_iron_nugget");
    public static final Item NETHERITE_GOLD_NUGGET = register(new Item(new Item.Settings()
            .registryKey(NETHERITE_GOLD_NUGGET_KEY)), "netherite_gold_nugget");
    public static final Item NETHERITE_EMERALD_NUGGET = register(new Item(new Item.Settings()
            .registryKey(NETHERITE_EMERALD_NUGGET_KEY)), "netherite_emerald_nugget");
    public static final Item NETHERITE_DIAMOND_NUGGET = register(new Item(new Item.Settings()
            .registryKey(NETHERITE_DIAMOND_NUGGET_KEY)), "netherite_diamond_nugget");

    public static void init() {}

    private ANItems() {}

    private static RegistryKey<Item> key(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Syncore.identify(id));
    }

    private static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Syncore.identify(id), item);
    }
}
