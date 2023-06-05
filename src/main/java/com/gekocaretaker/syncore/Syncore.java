package com.gekocaretaker.syncore;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.block.entity.BlockEntityInit;
import com.gekocaretaker.syncore.item.ItemInit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.stat.StatsInit;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Syncore implements ModInitializer {
    public static final String MOD_ID = "syncore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Starting Sync Ore.");

        LOGGER.info("Generating vanilla blocks...");
        BlockInit.init();
        LOGGER.info("Finished generating vanilla blocks.");

        LOGGER.info("Generating vanilla items...");
        ItemInit.init();
        LOGGER.info("Finished generating vanilla items.");

        LOGGER.info("Creating block entities...");
        BlockEntityInit.init();
        LOGGER.info("Finished creating block entities.");

        RecipeInit.init();
        StatsInit.init();
    }
}
