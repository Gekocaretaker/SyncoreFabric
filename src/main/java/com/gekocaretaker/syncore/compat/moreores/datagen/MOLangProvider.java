package com.gekocaretaker.syncore.compat.moreores.datagen;

import com.gekocaretaker.syncore.compat.moreores.item.MOItemGroup;
import com.gekocaretaker.syncore.compat.moreores.item.MOItems;
import com.gekocaretaker.syncore.util.CompatLangProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class MOLangProvider implements CompatLangProvider {
    public static final MOLangProvider INSTANCE = new MOLangProvider();

    private MOLangProvider() {}

    public void provide(FabricLanguageProvider.TranslationBuilder trans) {
        trans.add(MOItemGroup.SYNCORE_MORE_ORES_GROUP, "Sync Ore (More Ores)");
        trans.add(MOItems.ALUMINIUM_NUGGET, "Aluminium Nugget");
        trans.add(MOItems.BRONZE_NUGGET, "Bronze Nugget");
        trans.add(MOItems.CHROME_NUGGET, "Chrome Nugget");
        trans.add(MOItems.ENDERITE_NUGGET, "Enderite Nugget");
        trans.add(MOItems.LITHIUM_NUGGET, "Lithium Nugget");
        trans.add(MOItems.NICKEL_NUGGET, "Nickel Nugget");
        trans.add(MOItems.PLOMB_NUGGET, "Plomb Nugget");
        trans.add(MOItems.RACKNITE_NUGGET, "Racknite Nugget");
        trans.add(MOItems.SILICON_NUGGET, "Silicon Nugget");
        trans.add(MOItems.SILVER_NUGGET, "Silver Nugget");
        trans.add(MOItems.SODIUM_NUGGET, "Sodium Nugget");
        trans.add(MOItems.SOULRITE_NUGGET, "Soulrite Nugget");
        trans.add(MOItems.STEEL_NUGGET, "Steel Nugget");
        trans.add(MOItems.TIN_NUGGET, "Tin Nugget");
        trans.add(MOItems.TITANIUM_NUGGET, "Titanium Nugget");
        trans.add(MOItems.VOLCANITE_NUGGET, "Volcanite Nugget");
        trans.add(MOItems.ZINC_NUGGET, "Zinc Nugget");
    }
}
