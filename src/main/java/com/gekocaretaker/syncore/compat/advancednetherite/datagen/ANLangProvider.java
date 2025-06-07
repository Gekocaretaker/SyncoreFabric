package com.gekocaretaker.syncore.compat.advancednetherite.datagen;

import com.gekocaretaker.syncore.compat.advancednetherite.item.ANItems;
import com.gekocaretaker.syncore.util.CompatLangProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ANLangProvider implements CompatLangProvider {
    public static final ANLangProvider INSTANCE = new ANLangProvider();

    private ANLangProvider() {}

    @Override
    public void provide(FabricLanguageProvider.TranslationBuilder trans) {
        trans.add(ANItems.NETHERITE_IRON_NUGGET, "Netherite-Iron Nugget");
        trans.add(ANItems.NETHERITE_GOLD_NUGGET, "Netherite-Gold Nugget");
        trans.add(ANItems.NETHERITE_EMERALD_NUGGET, "Netherite-Emerald Nugget");
        trans.add(ANItems.NETHERITE_DIAMOND_NUGGET, "Netherite-Diamond Nugget");
    }
}
