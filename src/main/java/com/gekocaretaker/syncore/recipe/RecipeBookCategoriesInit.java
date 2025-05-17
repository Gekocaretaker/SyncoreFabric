package com.gekocaretaker.syncore.recipe;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class RecipeBookCategoriesInit {
    public static final RecipeBookCategory ROCK_TUMBLER_BLOCKS = register("rock_tumbler_blocks");
    public static final RecipeBookCategory ROCK_TUMBLER_MISC = register("rock_tumbler_misc");

    public static void init() {
    }

    private static RecipeBookCategory register(String id) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, id, new RecipeBookCategory());
    }
}
