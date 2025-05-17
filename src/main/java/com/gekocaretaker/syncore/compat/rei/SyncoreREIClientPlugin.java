package com.gekocaretaker.syncore.compat.rei;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.client.gui.screen.ingame.RockTumblerScreen;
import com.gekocaretaker.syncore.compat.rei.displays.REIClientTumblingDisplay;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.client.categories.cooking.DefaultCookingCategory;
import net.minecraft.recipe.display.FurnaceRecipeDisplay;

public class SyncoreREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.addWorkstations(SyncoreREIServerPlugin.TUMBLING, EntryStacks.of(BlockInit.ROCK_TUMBLER_BLOCK));

        registry.add(
                new DefaultCookingCategory(SyncoreREIServerPlugin.TUMBLING, EntryStacks.of(BlockInit.ROCK_TUMBLER_BLOCK), "category.rei.tumbling", 100)
        );
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.beginRecipeFiller(FurnaceRecipeDisplay.class).filterType(FurnaceRecipeDisplay.SERIALIZER).filter((display, r) -> {
            return EntryIngredients.ofSlotDisplay(display.craftingStation()).contains(EntryStacks.of(BlockInit.ROCK_TUMBLER_BLOCK));
        }).fill(REIClientTumblingDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(new Rectangle(78, 32, 28, 23), RockTumblerScreen.class, new CategoryIdentifier[]{SyncoreREIServerPlugin.TUMBLING});
    }
}
