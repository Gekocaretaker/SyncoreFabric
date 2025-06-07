package com.gekocaretaker.syncore.compat.advancednetherite.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ANItemGroup {
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("advancednetherite", "tab"))).register(c -> {
            c.add(ANItems.NETHERITE_IRON_NUGGET);
            c.add(ANItems.NETHERITE_GOLD_NUGGET);
            c.add(ANItems.NETHERITE_EMERALD_NUGGET);
            c.add(ANItems.NETHERITE_DIAMOND_NUGGET);
        });
    }
}
