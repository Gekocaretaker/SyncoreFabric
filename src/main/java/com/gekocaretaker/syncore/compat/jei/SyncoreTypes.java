package com.gekocaretaker.syncore.compat.jei;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import mezz.jei.api.recipe.RecipeType;

public class SyncoreTypes {
    public static final RecipeType<RockTumblerRecipe> TUMBLING =
            RecipeType.create(Syncore.MOD_ID, "tumbling", RockTumblerRecipe.class);
}
