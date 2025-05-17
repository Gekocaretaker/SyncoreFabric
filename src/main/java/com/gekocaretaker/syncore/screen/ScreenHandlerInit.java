package com.gekocaretaker.syncore.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;

public class ScreenHandlerInit {
    public static final ScreenHandlerType<RockTumblerScreenHandler> ROCK_TUMBLER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, "rock_tumbler",
            new ScreenHandlerType<>(RockTumblerScreenHandler::new, FeatureFlags.VANILLA_FEATURES));
}
