package com.gekocaretaker.syncore.screen;

import com.gekocaretaker.syncore.recipe.RecipeInit;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class RockTumblerScreenHandler extends AbstractFurnaceScreenHandler {
    public RockTumblerScreenHandler(int i, PlayerInventory playerInventory) {
        super(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RecipeInit.ROCK_TUMBLER_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public RockTumblerScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RecipeInit.ROCK_TUMBLER_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
