package com.gekocaretaker.syncore.item;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ItemTagInit {
    public static final TagKey<Item> SHARDS = rS("shards");
    public static final TagKey<Item> CHARCOAL_NUGGETS = rC("nuggets/charcoal");
    public static final TagKey<Item> COAL_NUGGETS = rC("nuggets/coal");
    public static final TagKey<Item> COPPER_NUGGETS = rC("nuggets/copper");
    public static final TagKey<Item> DIAMOND_SHARDS = rS("shards/diamond");
    public static final TagKey<Item> EMERALD_SHARDS = rS("shards/emerald");
    public static final TagKey<Item> LAPIS_SHARDS = rS("shards/lapis");
    public static final TagKey<Item> NETHERITE_NUGGETS = rC("nuggets/netherite");
    public static final TagKey<Item> RESIN_NUGGETS = rC("nuggets/resin");
    public static final TagKey<Item> QUARTZ_SHARDS = rS("shards/quartz");
    public static final TagKey<Item> REDSTONE_GEMS = rC("gems/redstone");
    public static final TagKey<Item> STORAGE_BLOCKS_CHARCOAL = rC("storage_blocks/charcoal");
    public static final TagKey<Item> STORAGE_BLOCKS_ROUGH_DIAMOND = rC("storage_blocks/rough_diamond");
    public static final TagKey<Item> STORAGE_BLOCKS_ROUGH_EMERALD = rC("storage_blocks/rough_emerald");
    public static final TagKey<Item> STORAGE_BLOCKS_ROUGH_LAPIS = rC("storage_blocks/rough_lapis");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_NETHERITE = rC("storage_blocks/raw_netherite");
    public static final TagKey<Item> STORAGE_BLOCKS_ROUGH_QUARTZ = rC("storage_blocks/rough_quartz");
    public static final TagKey<Item> STORAGE_BLOCKS_ROUGH_REDSTONE = rC("storage_blocks/rough_redstone");
    public static final TagKey<Item> DIAMOND_ROUGH_MATERIALS = rC("raw_materials/diamond");
    public static final TagKey<Item> EMERALD_ROUGH_MATERIALS = rC("raw_materials/emerald");
    public static final TagKey<Item> LAPIS_ROUGH_MATERIALS = rC("raw_materials/lapis");
    public static final TagKey<Item> QUARTZ_ROUGH_MATERIALS = rC("raw_materials/quartz");
    public static final TagKey<Item> REDSTONE_ROUGH_MATERIALS = rC("raw_materials/redstone");

    private ItemTagInit() {}

    private static TagKey<Item> rS(String path) {
        return r(Syncore.identify(path));
    }

    private static TagKey<Item> rC(String path) {
        return r(Identifier.of("c", path));
    }

    private static TagKey<Item> r(Identifier id) {
        return TagKey.of(RegistryKeys.ITEM, id);
    }

    public static void init() {}
}
