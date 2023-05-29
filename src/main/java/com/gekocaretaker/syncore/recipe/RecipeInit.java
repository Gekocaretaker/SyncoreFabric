package com.gekocaretaker.syncore.recipe;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RecipeInit {
    public static final RecipeType<RockTumblerRecipe> ROCK_TUMBLER_RECIPE_TYPE = register("tumbling");
    public static final RecipeSerializer<RockTumblerRecipe> ROCK_TUMBLER_RECIPE_SERIALIZER =
            RecipeSerializer.register("tumbling",
                    new CookingRecipeSerializer<RockTumblerRecipe>(RockTumblerRecipe::new, 100));

    public static <T extends Recipe<?>> RecipeType<T> register(final String id) {
        return Registry.register(Registry.RECIPE_TYPE, new Identifier(Syncore.MOD_ID, id), new RecipeType<T>(){

            public String toString() {
                return id;
            }
        });
    }

    public static void init() {
        Syncore.LOGGER.info("Creating recipe types...");
        Syncore.LOGGER.info("Creating recipe type with id of '" + ROCK_TUMBLER_RECIPE_TYPE.toString() + "'.");
        Syncore.LOGGER.info("Finished creating recipe types.");

        Syncore.LOGGER.info("Creating recipe serializers...");
        Syncore.LOGGER.info("Creating recipe serializer with id of '" + ROCK_TUMBLER_RECIPE_SERIALIZER.toString() + "'.");
        Syncore.LOGGER.info("Finished creating recipe serializers.");
    }
}
