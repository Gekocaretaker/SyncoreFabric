package com.gekocaretaker.syncore.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public interface CompatLangProvider {
    public void provide(FabricLanguageProvider.TranslationBuilder trans);
}
