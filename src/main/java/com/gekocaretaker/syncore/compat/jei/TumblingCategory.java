package com.gekocaretaker.syncore.compat.jei;

import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.library.plugins.vanilla.cooking.AbstractCookingCategory;

public class TumblingCategory extends AbstractCookingCategory<RockTumblerRecipe> {
    public TumblingCategory(IGuiHelper guiHelper) {
        super(guiHelper, BlockInit.ROCK_TUMBLER_BLOCK, "gui.jei.category.tumbling", 100);
    }

    @Override
    public RecipeType<RockTumblerRecipe> getRecipeType() {
        return SyncoreTypes.TUMBLING;
    }
}
