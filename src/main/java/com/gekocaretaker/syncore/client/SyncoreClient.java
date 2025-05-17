package com.gekocaretaker.syncore.client;

import com.gekocaretaker.syncore.client.gui.screen.ingame.RockTumblerScreen;
import com.gekocaretaker.syncore.screen.ScreenHandlerInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class SyncoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RockTumblerScreen::new);
    }
}
