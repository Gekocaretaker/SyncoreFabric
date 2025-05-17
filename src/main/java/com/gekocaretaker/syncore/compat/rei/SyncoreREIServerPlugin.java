package com.gekocaretaker.syncore.compat.rei;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.compat.rei.displays.REIClientTumblingDisplay;
import com.gekocaretaker.syncore.compat.rei.displays.REICommonTumblingDisplay;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;

public class SyncoreREIServerPlugin implements REICommonPlugin {
    public static final CategoryIdentifier<REIClientTumblingDisplay> TUMBLING = CategoryIdentifier.of(Syncore.MOD_ID, "tumbling");

    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(RockTumblerRecipe.class).filterType(RecipeInit.ROCK_TUMBLER_RECIPE_TYPE).fill(REICommonTumblingDisplay::new);
    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(Syncore.identify("client/tumbling"), REIClientTumblingDisplay.SERIALIZER);
        registry.register(Syncore.identify("tumbling"), REICommonTumblingDisplay.SERIALIZER);
    }
}
