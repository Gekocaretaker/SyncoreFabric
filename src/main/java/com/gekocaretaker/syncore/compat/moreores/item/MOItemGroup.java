package com.gekocaretaker.syncore.compat.moreores.item;

import com.gekocaretaker.syncore.Syncore;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import rvl.more_ores.block.ModBlocks;
import rvl.more_ores.item.ModItems;

public class MOItemGroup {
    public static final RegistryKey<ItemGroup> SYNCORE_MORE_ORES_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Syncore.identify("more_ores"));

    public static void init() {
        register(SYNCORE_MORE_ORES_GROUP, new ItemStack(MOItems.VOLCANITE_NUGGET), Text.translatable("itemGroup.syncore.more_ores"));

        ItemGroupEvents.modifyEntriesEvent(SYNCORE_MORE_ORES_GROUP).register(c -> {
            // Aluminium
            c.add(ModBlocks.ALUMINIUM_ORE);
            c.add(ModBlocks.DEEPSLATE_ALUMINIUM_ORE);
            c.add(ModItems.ALUMINIUM_RAW);
            c.add(ModBlocks.ALUMINIUM_ORE_BLOCK);
            c.add(MOItems.ALUMINIUM_NUGGET);
            c.add(ModItems.ALUMINIUM_INGOT);
            c.add(ModBlocks.ALUMINIUM_BLOCK);
            // Bronze
            c.add(ModItems.BRONZE_ALLOY);
            c.add(ModBlocks.ALLOY_BRONZE_BLOCK);
            c.add(MOItems.BRONZE_NUGGET);
            c.add(ModItems.BRONZE_INGOT);
            c.add(ModBlocks.BRONZE_BLOCK);
            // Chrome
            c.add(ModBlocks.CHROME_ORE);
            c.add(ModBlocks.DEEPSLATE_CHROME_ORE);
            c.add(ModItems.CHROME_RAW);
            c.add(ModBlocks.CHROME_ORE_BLOCK);
            c.add(MOItems.CHROME_NUGGET);
            c.add(ModItems.CHROME_INGOT);
            c.add(ModBlocks.CHROME_BLOCK);
            // Enderite
            c.add(ModBlocks.ENDERITE_ORE);
            c.add(ModItems.ENDERITE_RAW);
            c.add(ModBlocks.ENDERITE_ORE_BLOCK);
            c.add(MOItems.ENDERITE_NUGGET);
            c.add(ModItems.ENDERITE_INGOT);
            c.add(ModBlocks.ENDERITE_BLOCK);
            // Lithium
            c.add(ModBlocks.LITHIUM_ORE);
            c.add(ModBlocks.DEEPSLATE_LITHIUM_ORE);
            c.add(ModItems.LITHIUM_RAW);
            c.add(ModBlocks.LITHIUM_ORE_BLOCK);
            c.add(MOItems.LITHIUM_NUGGET);
            c.add(ModItems.LITHIUM_INGOT);
            c.add(ModBlocks.LITHIUM_BLOCK);
            // Nickel
            c.add(ModBlocks.NICKEL_ORE);
            c.add(ModBlocks.DEEPSLATE_NICKEL_ORE);
            c.add(ModItems.NICKEL_RAW);
            c.add(ModBlocks.NICKEL_ORE_BLOCK);
            c.add(MOItems.NICKEL_NUGGET);
            c.add(ModItems.NICKEL_INGOT);
            c.add(ModBlocks.NICKEL_BLOCK);
            // Plomb
            c.add(ModBlocks.PLOMB_ORE);
            c.add(ModBlocks.DEEPSLATE_PLOMB_ORE);
            c.add(ModItems.PLOMB_RAW);
            c.add(ModBlocks.PLOMB_ORE_BLOCK);
            c.add(MOItems.PLOMB_NUGGET);
            c.add(ModItems.PLOMB_INGOT);
            c.add(ModBlocks.PLOMB_BLOCK);
            // Racknite
            c.add(ModBlocks.RACKNITE_ORE);
            c.add(ModItems.RACKNITE_RAW);
            c.add(ModBlocks.RACKNITE_ORE_BLOCK);
            c.add(MOItems.RACKNITE_NUGGET);
            c.add(ModItems.RACKNITE_INGOT);
            c.add(ModBlocks.RACKNITE_BLOCK);
            // Silicon
            c.add(ModBlocks.SILICON_ORE);
            c.add(ModBlocks.DEEPSLATE_SILICON_ORE);
            c.add(ModItems.SILICON_RAW);
            c.add(ModBlocks.SILICON_ORE_BLOCK);
            c.add(MOItems.SILICON_NUGGET);
            c.add(ModItems.SILICON_INGOT);
            c.add(ModBlocks.SILICON_BLOCK);
            // Silver
            c.add(ModBlocks.SILVER_ORE);
            c.add(ModBlocks.DEEPSLATE_SILVER_ORE);
            c.add(ModItems.SILVER_RAW);
            c.add(ModBlocks.SILVER_ORE_BLOCK);
            c.add(MOItems.SILVER_NUGGET);
            c.add(ModItems.SILVER_INGOT);
            c.add(ModBlocks.SILVER_BLOCK);
            // Sodium
            c.add(ModBlocks.SALT_ORE);
            c.add(ModBlocks.DEEPSLATE_SALT_ORE);
            c.add(ModItems.SALT);
            c.add(ModBlocks.SALT_BLOCK);
            c.add(MOItems.SODIUM_NUGGET);
            c.add(ModItems.SODIUM_INGOT);
            c.add(ModBlocks.SODIUM_BLOCK);
            // Soulrite
            c.add(ModBlocks.SOUL_SAND_SOULRITE_ORE);
            c.add(ModBlocks.SOUL_SOIL_SOULRITE_ORE);
            c.add(ModItems.SOULRITE_RAW);
            c.add(ModBlocks.SOULRITE_ORE_BLOCK);
            c.add(MOItems.SOULRITE_NUGGET);
            c.add(ModItems.SOULRITE_INGOT);
            c.add(ModBlocks.SOULRITE_BLOCK);
            // Steel
            c.add(ModItems.STEEL_ALLOY);
            c.add(ModBlocks.ALLOY_STEEL_BLOCK);
            c.add(MOItems.STEEL_NUGGET);
            c.add(ModItems.STEEL_INGOT);
            c.add(ModBlocks.STEEL_BLOCK);
            // Tin
            c.add(ModBlocks.TIN_ORE);
            c.add(ModBlocks.DEEPSLATE_TIN_ORE);
            c.add(ModItems.TIN_RAW);
            c.add(ModBlocks.TIN_ORE_BLOCK);
            c.add(MOItems.TIN_NUGGET);
            c.add(ModItems.TIN_INGOT);
            c.add(ModBlocks.TIN_BLOCK);
            // Titanium
            c.add(ModBlocks.TITANIUM_ORE);
            c.add(ModBlocks.DEEPSLATE_TITANIUM_ORE);
            c.add(ModItems.TITANIUM_RAW);
            c.add(ModBlocks.TITANIUM_ORE_BLOCK);
            c.add(MOItems.TITANIUM_NUGGET);
            c.add(ModItems.TITANIUM_INGOT);
            c.add(ModBlocks.TITANIUM_BLOCK);
            // Volcanite
            c.add(ModBlocks.BASALT_VOLCANITE_ORE);
            c.add(ModBlocks.BLACKSTONE_VOLCANITE_ORE);
            c.add(ModItems.VOLCANITE_RAW);
            c.add(ModBlocks.VOLCANITE_ORE_BLOCK);
            c.add(MOItems.VOLCANITE_NUGGET);
            c.add(ModItems.VOLCANITE_INGOT);
            c.add(ModBlocks.VOLCANITE_BLOCK);
            // Zinc
            c.add(ModBlocks.ZINC_ORE);
            c.add(ModBlocks.DEEPSLATE_ZINC_ORE);
            c.add(ModItems.ZINC_RAW);
            c.add(ModBlocks.ZINC_ORE_BLOCK);
            c.add(MOItems.ZINC_NUGGET);
            c.add(ModItems.ZINC_INGOT);
            c.add(ModBlocks.ZINC_BLOCK);
        });
    }

    private static void register(RegistryKey<ItemGroup> group, ItemStack icon, Text name) {
        Registry.register(Registries.ITEM_GROUP, group, FabricItemGroup.builder()
                .icon(() -> icon)
                .displayName(name)
                .build());
    }

    private MOItemGroup() {}
}
