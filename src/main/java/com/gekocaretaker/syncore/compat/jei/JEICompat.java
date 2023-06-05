package com.gekocaretaker.syncore.compat.jei;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.client.gui.screen.ingame.RockTumblerScreen;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import com.gekocaretaker.syncore.screen.RockTumblerScreenHandler;
import com.gekocaretaker.syncore.screen.ScreenHandlerInit;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.common.util.ErrorUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class JEICompat implements IModPlugin {
    @Nullable
    private IRecipeCategory<RockTumblerRecipe> tumblingCategory;

    @Override
    public Identifier getPluginUid() {
        return new Identifier(Syncore.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(
                tumblingCategory = new TumblingCategory(guiHelper)
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ErrorUtil.checkNotNull(tumblingCategory, "tumblingCategory");

        IIngredientManager ingredientManager = registration.getIngredientManager();
        SyncoreRecipes syncoreRecipes = new SyncoreRecipes(ingredientManager);

        registration.addRecipes(SyncoreTypes.TUMBLING, syncoreRecipes.getTumblingRecipes(tumblingCategory));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(RockTumblerScreen.class, 78, 32, 28, 23, SyncoreTypes.TUMBLING, RecipeTypes.FUELING);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(RockTumblerScreenHandler.class, ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, SyncoreTypes.TUMBLING, 0, 1, 3, 36);
        registration.addRecipeTransferHandler(RockTumblerScreenHandler.class, ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RecipeTypes.FUELING, 1, 1, 3, 36);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockInit.ROCK_TUMBLER_BLOCK), SyncoreTypes.TUMBLING, RecipeTypes.FUELING);
    }
}
