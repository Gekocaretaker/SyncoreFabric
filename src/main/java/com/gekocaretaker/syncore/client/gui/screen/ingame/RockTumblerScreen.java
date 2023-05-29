package com.gekocaretaker.syncore.client.gui.screen.ingame;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.screen.RockTumblerScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RockTumblerScreen extends AbstractFurnaceScreen<RockTumblerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Syncore.MOD_ID, "textures/gui/container/rock_tumbler.png");

    public RockTumblerScreen(RockTumblerScreenHandler container, PlayerInventory inventory, Text title) {
        super(container, new FurnaceRecipeBookScreen(), inventory, title, TEXTURE);
    }
}
