package com.gekocaretaker.syncore.compat.rei;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.compat.rei.displays.REITumblingDisplay;
import com.gekocaretaker.syncore.screen.RockTumblerScreenHandler;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;
import me.shedaniel.rei.api.common.transfer.info.MenuInfoRegistry;
import me.shedaniel.rei.api.common.transfer.info.simple.RecipeBookGridMenuInfo;
import me.shedaniel.rei.api.common.transfer.info.simple.SimpleMenuInfoProvider;
import me.shedaniel.rei.plugin.common.displays.cooking.DefaultCookingDisplay;

public class SyncoreREIServerPlugin implements REIServerPlugin {
    public static final CategoryIdentifier<REITumblingDisplay> TUMBLING = CategoryIdentifier.of(Syncore.MOD_ID, "tumbling");

    @Override
    public void registerMenuInfo(MenuInfoRegistry registry) {
        registry.register(TUMBLING, RockTumblerScreenHandler.class, SimpleMenuInfoProvider.of(RecipeBookGridMenuInfo::new));
    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(TUMBLING, DefaultCookingDisplay.serializer(REITumblingDisplay::new));
    }
}
