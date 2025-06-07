package com.gekocaretaker.syncore.compat.moreores.item;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class MOItems {
    public static final RegistryKey<Item> ALUMINIUM_NUGGET_KEY = key("aluminium_nugget");
    public static final RegistryKey<Item> BRONZE_NUGGET_KEY = key("bronze_nugget");
    public static final RegistryKey<Item> CHROME_NUGGET_KEY = key("chrome_nugget");
    public static final RegistryKey<Item> ENDERITE_NUGGET_KEY = key("enderite_nugget");
    public static final RegistryKey<Item> LITHIUM_NUGGET_KEY = key("lithium_nugget");
    public static final RegistryKey<Item> NICKEL_NUGGET_KEY = key("nickel_nugget");
    public static final RegistryKey<Item> PLOMB_NUGGET_KEY = key("plomb_nugget");
    public static final RegistryKey<Item> RACKNITE_NUGGET_KEY = key("racknite_nugget");
    public static final RegistryKey<Item> SILICON_NUGGET_KEY = key("silicon_nugget");
    public static final RegistryKey<Item> SILVER_NUGGET_KEY = key("silver_nugget");
    public static final RegistryKey<Item> SODIUM_NUGGET_KEY = key("sodium_nugget");
    public static final RegistryKey<Item> SOULRITE_NUGGET_KEY = key("soulrite_nugget");
    public static final RegistryKey<Item> STEEL_NUGGET_KEY = key("steel_nugget");
    public static final RegistryKey<Item> TIN_NUGGET_KEY = key("tin_nugget");
    public static final RegistryKey<Item> TITANIUM_NUGGET_KEY = key("titanium_nugget");
    public static final RegistryKey<Item> VOLCANITE_NUGGET_KEY = key("volcanite_nugget");
    public static final RegistryKey<Item> ZINC_NUGGET_KEY = key("zinc_nugget");

    public static final Item ALUMINIUM_NUGGET = register(new Item(new Item.Settings()
            .registryKey(ALUMINIUM_NUGGET_KEY)), "aluminium_nugget");
    public static final Item BRONZE_NUGGET = register(new Item(new Item.Settings()
            .registryKey(BRONZE_NUGGET_KEY)), "bronze_nugget");
    public static final Item ENDERITE_NUGGET = register(new Item(new Item.Settings()
            .registryKey(ENDERITE_NUGGET_KEY)), "enderite_nugget");
    public static final Item CHROME_NUGGET = register(new Item(new Item.Settings()
            .registryKey(CHROME_NUGGET_KEY)), "chrome_nugget");
    public static final Item LITHIUM_NUGGET = register(new Item(new Item.Settings()
            .registryKey(LITHIUM_NUGGET_KEY)), "lithium_nugget");
    public static final Item NICKEL_NUGGET = register(new Item(new Item.Settings()
            .registryKey(NICKEL_NUGGET_KEY)), "nickel_nugget");
    public static final Item PLOMB_NUGGET = register(new Item(new Item.Settings()
            .registryKey(PLOMB_NUGGET_KEY)), "plomb_nugget");
    public static final Item RACKNITE_NUGGET = register(new Item(new Item.Settings()
            .registryKey(RACKNITE_NUGGET_KEY)), "racknite_nugget");
    public static final Item SILICON_NUGGET = register(new Item(new Item.Settings()
            .registryKey(SILICON_NUGGET_KEY)), "silicon_nugget");
    public static final Item SILVER_NUGGET = register(new Item(new Item.Settings()
            .registryKey(SILVER_NUGGET_KEY)), "silver_nugget");
    public static final Item SODIUM_NUGGET = register(new Item(new Item.Settings()
            .registryKey(SODIUM_NUGGET_KEY)), "sodium_nugget");
    public static final Item SOULRITE_NUGGET = register(new Item(new Item.Settings()
            .registryKey(SOULRITE_NUGGET_KEY)), "soulrite_nugget");
    public static final Item STEEL_NUGGET = register(new Item(new Item.Settings()
            .registryKey(STEEL_NUGGET_KEY)), "steel_nugget");
    public static final Item TIN_NUGGET = register(new Item(new Item.Settings()
            .registryKey(TIN_NUGGET_KEY)), "tin_nugget");
    public static final Item TITANIUM_NUGGET = register(new Item(new Item.Settings()
            .registryKey(TITANIUM_NUGGET_KEY)), "titanium_nugget");
    public static final Item VOLCANITE_NUGGET = register(new Item(new Item.Settings()
            .registryKey(VOLCANITE_NUGGET_KEY)), "volcanite_nugget");
    public static final Item ZINC_NUGGET = register(new Item(new Item.Settings()
            .registryKey(ZINC_NUGGET_KEY)), "zinc_nugget");

    public static void init() {}

    private MOItems() {}

    private static RegistryKey<Item> key(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Syncore.identify(id));
    }

    private static Item register(Item item, String id) {
        return Registry.register(Registries.ITEM, Syncore.identify(id), item);
    }
}
