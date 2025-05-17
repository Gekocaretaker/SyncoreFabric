package com.gekocaretaker.syncore.recipe;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class RecipeInit {
    public static final RecipeType<RockTumblerRecipe> ROCK_TUMBLER_RECIPE_TYPE = register("tumbling");
    public static final RecipeSerializer<RockTumblerRecipe> ROCK_TUMBLER_RECIPE_SERIALIZER =
            registerSerializer("tumbling",
                    new AbstractCookingRecipe.Serializer<>(RockTumblerRecipe::new, 100));
    public static final RegistryKey<RecipePropertySet> ROCK_TUMBLER_INPUT_PROPERTY_SET = RegistryKey.of(RecipePropertySet.REGISTRY, Syncore.identify("tumbling_input"));

    public static <T extends Recipe<?>> RecipeType<T> register(final String id) {
        return Registry.register(Registries.RECIPE_TYPE, Syncore.identify(id), new RecipeType<T>(){});
    }

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Syncore.identify(id), serializer);
    }

    public static void init() {
    }
}
