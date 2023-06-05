package com.gekocaretaker.syncore.compat.rei.displays;

import com.gekocaretaker.syncore.compat.rei.SyncoreREIServerPlugin;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.plugin.common.displays.cooking.DefaultCookingDisplay;
import net.minecraft.nbt.NbtCompound;

import java.util.List;

public class REITumblingDisplay extends DefaultCookingDisplay {
    public REITumblingDisplay(RockTumblerRecipe recipe) {
        super(recipe);
    }

    public REITumblingDisplay(List<EntryIngredient> input, List<EntryIngredient> output, NbtCompound tag) {
        super(input, output, tag);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SyncoreREIServerPlugin.TUMBLING;
    }
}
