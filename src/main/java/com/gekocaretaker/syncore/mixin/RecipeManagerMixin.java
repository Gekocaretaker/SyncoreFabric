package com.gekocaretaker.syncore.mixin;

import com.gekocaretaker.syncore.recipe.RecipeInit;
import net.minecraft.recipe.*;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Mixin(ServerRecipeManager.class)
public class RecipeManagerMixin {
    @Mutable
    @Shadow
    @Final
    private static Map<RegistryKey<RecipePropertySet>, ServerRecipeManager.SoleIngredientGetter> SOLE_INGREDIENT_GETTERS;

    @Shadow
    private static ServerRecipeManager.SoleIngredientGetter cookingIngredientGetter(RecipeType<? extends SingleStackRecipe> expectedType) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void syncore$serverRecipeManagerInit(CallbackInfo ci) {
        SOLE_INGREDIENT_GETTERS = new HashMap<>(SOLE_INGREDIENT_GETTERS);
        SOLE_INGREDIENT_GETTERS.put(RecipeInit.ROCK_TUMBLER_INPUT_PROPERTY_SET, cookingIngredientGetter(RecipeInit.ROCK_TUMBLER_RECIPE_TYPE));
        SOLE_INGREDIENT_GETTERS = Collections.unmodifiableMap(SOLE_INGREDIENT_GETTERS);
    }
}
