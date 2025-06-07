package com.gekocaretaker.syncore.util;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;

public interface CompatRecipeProvider {
    public void provide(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter);
}
