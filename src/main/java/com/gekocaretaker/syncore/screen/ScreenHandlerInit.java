package com.gekocaretaker.syncore.screen;

import com.gekocaretaker.syncore.Syncore;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlerInit {
    public static final ScreenHandlerType<RockTumblerScreenHandler> ROCK_TUMBLER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(Syncore.MOD_ID, "rock_tumbler"),
                    RockTumblerScreenHandler::new);
}
