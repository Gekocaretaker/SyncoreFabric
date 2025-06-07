package com.gekocaretaker.syncore;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.block.BlockTagInit;
import com.gekocaretaker.syncore.block.entity.BlockEntityInit;
import com.gekocaretaker.syncore.compat.CompatManager;
import com.gekocaretaker.syncore.item.ItemGroupInit;
import com.gekocaretaker.syncore.item.ItemInit;
import com.gekocaretaker.syncore.item.ItemTagInit;
import com.gekocaretaker.syncore.item.ModGrits;
import com.gekocaretaker.syncore.recipe.RecipeBookCategoriesInit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.registry.ModRegistries;
import com.gekocaretaker.syncore.stat.StatsInit;
import com.gekocaretaker.syncore.village.ModTradeOffers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        ModTradeOffers.init();

        CompatManager.init();

        registerAliases();
    }

    public static Identifier identify(String path) {
        return Identifier.of(MOD_ID, path);
    }

    public static boolean isModPresent(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
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
