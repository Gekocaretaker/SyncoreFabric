package com.gekocaretaker.syncore.compat.rei.displays;

import com.gekocaretaker.syncore.compat.rei.SyncoreREIServerPlugin;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.plugin.client.displays.ClientsidedCookingDisplay;
import net.minecraft.recipe.NetworkRecipeId;
import net.minecraft.recipe.display.FurnaceRecipeDisplay;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class REIClientTumblingDisplay extends ClientsidedCookingDisplay {
    public static DisplaySerializer<REIClientTumblingDisplay> SERIALIZER = serializer(REIClientTumblingDisplay::new);
    public REIClientTumblingDisplay(FurnaceRecipeDisplay recipe, Optional<NetworkRecipeId> id) {
        super(recipe, id);
    }

    public REIClientTumblingDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Optional<NetworkRecipeId> location) {
        super(inputs, outputs, location);
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
