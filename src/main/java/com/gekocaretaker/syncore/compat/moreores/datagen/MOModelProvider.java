package com.gekocaretaker.syncore.compat.moreores.datagen;

import com.gekocaretaker.syncore.client.datagen.SyncoreModelProvider;
import com.gekocaretaker.syncore.compat.moreores.item.MOItems;
import com.gekocaretaker.syncore.util.CompatModelProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class MOModelProvider implements CompatModelProvider {
    public static final MOModelProvider INSTANCE = new MOModelProvider();

    private MOModelProvider() {}

    @Override
    public void blocks(BlockStateModelGenerator gen) {
        //
    }

    @Override
    public void items(ItemModelGenerator gen) {
        SyncoreModelProvider.genDefault(MOItems.ALUMINIUM_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.BRONZE_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.CHROME_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.ENDERITE_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.LITHIUM_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.NICKEL_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.PLOMB_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.RACKNITE_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.SILICON_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.SILVER_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.SODIUM_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.SOULRITE_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.STEEL_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.TIN_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.TITANIUM_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.VOLCANITE_NUGGET, gen);
        SyncoreModelProvider.genDefault(MOItems.ZINC_NUGGET, gen);
    }
}
