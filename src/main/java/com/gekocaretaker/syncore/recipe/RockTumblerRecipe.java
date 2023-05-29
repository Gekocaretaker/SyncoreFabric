package com.gekocaretaker.syncore.recipe;

import com.gekocaretaker.syncore.block.BlockInit;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class RockTumblerRecipe extends AbstractCookingRecipe {
    public RockTumblerRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(RecipeInit.ROCK_TUMBLER_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockInit.ROCK_TUMBLER_BLOCK);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.ROCK_TUMBLER_RECIPE_SERIALIZER;
    }
}
