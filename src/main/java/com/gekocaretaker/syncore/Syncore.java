package com.gekocaretaker.syncore;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.block.BlockTagInit;
import com.gekocaretaker.syncore.block.entity.BlockEntityInit;
import com.gekocaretaker.syncore.item.ItemInit;
import com.gekocaretaker.syncore.item.ItemTagInit;
import com.gekocaretaker.syncore.item.ModGrits;
import com.gekocaretaker.syncore.recipe.RecipeBookCategoriesInit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.registry.ModRegistries;
import com.gekocaretaker.syncore.stat.StatsInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
Plans:
Nether ores - Coal, Iron, Copper, Diamond, Emerald, Lapis Lazuli, Redstone
Compatibility for: (modrinth id)
    More Ores: (rayvaxmodmore_ores)
        - Recipes to turn equipment into nuggets instead of ingots using furnace & blast furnace, to match vanilla
        - Volcanite Nugget
        - Soulrite Nugget
        - Racknite Nugget
        - Enderite Nugget
        - Aluminum Nugget
        - Tin Nugget
        - Bronze Nugget
        - Steel Nugget
        - Chrome Nugget
        - Nickel Nugget
        - Plomb Nugget
        - Silicon Nugget
        - Silver Nugget
        - Zinc Nugget
        - Sodium Nugget
        - Lithium Nugget
    Advanced Netherite: (advanced-netherite)
        - Recipes to turn equipment into nuggets using blast furnace, to match vanilla
        - Netherite-Iron Nugget
        - Netherite-Gold Nugget
        - Netherite-Emerald Nugget
        - Netherite-Diamond Nugget
    Many More Ores: (many-more-ores-and-crafts)
        - For the entries in this section, smelting refers to both the furnace and blast furnace.
        - Adamantite: Stone Ore, Smelting Equipment
        - Cobalt: Deepslate Ore, Smelting Equipment
        - Infernal: Blasting Equipment
        - Lead: Deepslate Ore, Smelting Equipment
        - Mythril: Stone Ore, Smelting Equipment
        - Obsidian: Tumble Equipment
        - Orichalcum: Stone Ore, Smelting Equipment
        - Palladium: Deepslate Ore, Smelting Equipment
        - Platinum: Deepslate Ore, Smelting Equipment
        - Silver: Deepslate Ore, Smelting Equipment
        - Tin: Deepslate Ore, Smelting Equipment
        - Titanium: Stone Ore, Smelting Equipment
        - Tungsten: Deepslate Ore, Smelting Equipment
        - Copper: Smelting Equipment
        - Amethyst: Tumbling Equipment
        - Emerald: Tumbling Equipment
    Biomes O' Plenty: (biomes-o-plenty)
        - Allow to be grits: White Sand, Orange Sand, Black Sand
*/

public class Syncore implements ModInitializer {
    public static final String MOD_ID = "syncore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModRegistries.init();
        ItemGroupInit.init();
        BlockInit.init();
        ItemInit.init();
        BlockEntityInit.init();
        RecipeBookCategoriesInit.init();
        RecipeInit.init();
        StatsInit.init();
        BlockTagInit.init();
        ItemTagInit.init();
        ModGrits.init();

        registerAliases();
    }

    public static Identifier identify(String path) {
        return Identifier.of(MOD_ID, path);
    }

    private static void registerAliases() {
        Registries.ITEM.addAlias(identify("amethyst_nugget"), Identifier.ofVanilla("amethyst_shard"));
        registerItemAlias("diamond_nugget", "diamond_shard");
        registerItemAlias("emerald_nugget", "emerald_shard");
        registerItemAlias("lapis_lazuli_nugget", "lapis_lazuli_shard");
        registerItemAlias("quartz_nugget", "quartz_shard");

        registerItemAlias("raw_diamond", "rough_diamond");
        registerItemAlias("raw_emerald", "rough_emerald");
        registerItemAlias("raw_lapis_lazuli", "rough_lapis_lazuli");
        registerItemAlias("raw_redstone", "rough_redstone");
        registerItemAlias("raw_quartz", "rough_quartz");

        registerBlockWithItemAlias("raw_diamond_block", "rough_diamond_block");
        registerBlockWithItemAlias("raw_emerald_block", "rough_emerald_block");
        registerBlockWithItemAlias("raw_lapis_lazuli_block", "rough_lapis_lazuli_block");
        registerBlockWithItemAlias("raw_redstone_block", "rough_redstone_block");
        registerBlockWithItemAlias("raw_quartz_block", "rough_quartz_block");
    }

    private static void registerItemAlias(String oldId, String newId) {
        Registries.ITEM.addAlias(identify(oldId), identify(newId));
    }

    private static void registerBlockAlias(String oldId, String newId) {
        Registries.BLOCK.addAlias(identify(oldId), identify(newId));
    }

    private static void registerBlockWithItemAlias(String oldId, String newId) {
        registerBlockAlias(oldId, newId);
        registerItemAlias(oldId, newId);
    }
}
