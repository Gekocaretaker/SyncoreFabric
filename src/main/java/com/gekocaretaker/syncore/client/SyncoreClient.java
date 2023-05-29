package com.gekocaretaker.syncore.client;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.client.gui.screen.ingame.RockTumblerScreen;
import com.gekocaretaker.syncore.screen.ScreenHandlerInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SyncoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FabricLoader.getInstance().getModContainer(Syncore.MOD_ID).ifPresent(modContainer -> {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(Syncore.MOD_ID, "clear_crystals"), modContainer, ResourcePackActivationType.NORMAL);
        });

        ScreenRegistry.register(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RockTumblerScreen::new);
    }
}
