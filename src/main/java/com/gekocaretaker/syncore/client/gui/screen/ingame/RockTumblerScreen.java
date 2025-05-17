package com.gekocaretaker.syncore.client.gui.screen.ingame;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.recipe.RecipeBookCategoriesInit;
import com.gekocaretaker.syncore.screen.RockTumblerScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookWidget;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.recipebook.RecipeBookType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

@Environment(EnvType.CLIENT)
public class RockTumblerScreen extends HandledScreen<RockTumblerScreenHandler> {
    private static final Identifier LIT_PROGRESS_TEXTURE = Syncore.identify("container/rock_tumbler/lit_progress");
    private static final Identifier BURN_PROGRESS_TEXTURE = Syncore.identify("container/rock_tumbler/burn_progress");
    private static final Identifier TEXTURE = Syncore.identify("textures/gui/container/rock_tumbler.png");

    public RockTumblerScreen(RockTumblerScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, i, j, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 256);
        int l;
        if (this.handler.isBurning()) {
            l = MathHelper.ceil(this.handler.getFuelProgress() * 13.0F) + 1;
            context.drawGuiTexture(RenderLayer::getGuiTextured, LIT_PROGRESS_TEXTURE, 14, 14, 0, 14 - l, i + 56, j + 36 + 14 - l, 14, l);
        }
        l = MathHelper.ceil(this.handler.getCookProgress() * 24.0F);
        context.drawGuiTexture(RenderLayer::getGuiTextured, BURN_PROGRESS_TEXTURE, 24, 16, 0, 0, i + 79, j + 34, l, 16);
    }
}
