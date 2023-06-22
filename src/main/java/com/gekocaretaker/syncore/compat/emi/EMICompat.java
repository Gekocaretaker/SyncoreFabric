package com.gekocaretaker.syncore.compat.emi;

import static com.gekocaretaker.syncore.compat.emi.SyncoreEmiRecipeCategories.TUMBLING;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import com.gekocaretaker.syncore.screen.RockTumblerScreenHandler;
import com.gekocaretaker.syncore.screen.ScreenHandlerInit;
import dev.emi.emi.runtime.EmiDrawContext;
import dev.emi.emi.runtime.EmiReloadLog;
import dev.emi.emi.EmiRenderHelper;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiRecipeSorting;
import dev.emi.emi.api.render.EmiRenderable;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.handler.CookingRecipeHandler;
import dev.emi.emi.recipe.EmiCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class EMICompat implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        TUMBLING = new EmiRecipeCategory(new Identifier(Syncore.MOD_ID, "tumbling"),
                EmiStack.of(BlockInit.ROCK_TUMBLER_BLOCK), simplifiedRenderer(208, 240), EmiRecipeSorting.compareOutputThenInput());

        registry.addCategory(TUMBLING);

        registry.addWorkstation(TUMBLING, EmiStack.of(BlockInit.ROCK_TUMBLER_BLOCK));

        registry.addRecipeHandler(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, new CookingRecipeHandler<RockTumblerScreenHandler>(TUMBLING));

        for (RockTumblerRecipe recipe : registry.getRecipeManager().listAllOfType(RecipeInit.ROCK_TUMBLER_RECIPE_TYPE)) {
            addRecipeSafe(registry, () -> new EmiCookingRecipe(recipe, TUMBLING, 2, false), recipe);
        }
    }

    private static EmiRenderable simplifiedRenderer(int u, int v) {
        return (raw, x, y, delta) -> {
            EmiDrawContext context = EmiDrawContext.wrap(raw);
            context.drawTexture(EmiRenderHelper.WIDGETS, x, y, u, v, 16, 16);
        };
    }

    private static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception when parsing syncore recipe " + recipe.getId());
            EmiReloadLog.error(e);
        }
    }
}
