package com.gekocaretaker.syncore.compat.rei.displays;

import com.gekocaretaker.syncore.compat.rei.SyncoreREIServerPlugin;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.plugin.common.displays.cooking.DefaultCookingDisplay;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class REICommonTumblingDisplay extends DefaultCookingDisplay {
    public static DisplaySerializer<REICommonTumblingDisplay> SERIALIZER = serializer(REICommonTumblingDisplay::new);

    public REICommonTumblingDisplay(List<EntryIngredient> input, List<EntryIngredient> output, Optional<Identifier> id, float xp, double cookTime) {
        super(input, output, id, xp, cookTime);
    }

    public REICommonTumblingDisplay(RecipeEntry<RockTumblerRecipe> rockTumblerRecipeRecipeEntry) {
        super(rockTumblerRecipeRecipeEntry);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SyncoreREIServerPlugin.TUMBLING;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }
}
