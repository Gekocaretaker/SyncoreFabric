package com.gekocaretaker.syncore.recipe;

import com.gekocaretaker.syncore.block.BlockInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeBookCategory;

public class RockTumblerRecipe extends AbstractCookingRecipe {
    public RockTumblerRecipe(String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(group, category, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<RockTumblerRecipe> getSerializer() {
        return RecipeInit.ROCK_TUMBLER_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<RockTumblerRecipe> getType() {
        return RecipeInit.ROCK_TUMBLER_RECIPE_TYPE;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return switch (this.getCategory()) {
            case BLOCKS -> RecipeBookCategoriesInit.ROCK_TUMBLER_BLOCKS;
            case FOOD, MISC -> RecipeBookCategoriesInit.ROCK_TUMBLER_MISC;
        };
    }

    @Override
    protected Item getCookerItem() {
        return BlockInit.ROCK_TUMBLER_BLOCK.asItem();
    }
}
