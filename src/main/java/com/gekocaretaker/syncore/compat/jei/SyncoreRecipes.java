package com.gekocaretaker.syncore.compat.jei;

import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.common.util.ErrorUtil;
import mezz.jei.library.plugins.vanilla.crafting.CategoryRecipeValidator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;

import java.util.List;

public final class SyncoreRecipes {
    private final RecipeManager recipeManager;
    private final IIngredientManager ingredientManager;

    public SyncoreRecipes(IIngredientManager ingredientManager) {
        MinecraftClient minecraft = MinecraftClient.getInstance();
        ErrorUtil.checkNotNull(minecraft, "minecraft");
        ClientWorld world = minecraft.world;
        ErrorUtil.checkNotNull(world, "minecraft world");
        this.recipeManager = world.getRecipeManager();
        this.ingredientManager = ingredientManager;
    }

    public List<RockTumblerRecipe> getTumblingRecipes(IRecipeCategory<RockTumblerRecipe> tumblingCategory) {
        CategoryRecipeValidator<RockTumblerRecipe> validator = new CategoryRecipeValidator<>(tumblingCategory, ingredientManager, 1);
        return getValidHandledRecipes(recipeManager, RecipeInit.ROCK_TUMBLER_RECIPE_TYPE, validator);
    }

    private static <C extends Inventory, T extends Recipe<C>> List<T> getValidHandledRecipes(
            RecipeManager recipeManager,
            RecipeType<T> recipeType,
            CategoryRecipeValidator<T> validator
    ) {
        return recipeManager.listAllOfType(recipeType)
                .stream()
                .filter(r -> validator.isRecipeValid(r) && validator.isRecipeHandled(r))
                .toList();
    }
}
