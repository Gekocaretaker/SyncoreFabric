package com.gekocaretaker.syncore.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SyncoreDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(SyncoreLootTableProviders.BlockLootTableProvider::new);
        pack.addProvider(SyncoreTagProviders.ItemTagProvider::new);
        pack.addProvider(SyncoreTagProviders.BlockTagProvider::new);
        pack.addProvider(SyncoreRecipeProvider::new);
    }
}
