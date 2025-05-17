package com.gekocaretaker.syncore.registry;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.item.Grit;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModRegistries {
    public static final RegistryKey<Registry<Grit>> GRIT_KEY = RegistryKey.ofRegistry(Syncore.identify("grit"));

    public static final Registry<Grit> GRIT = FabricRegistryBuilder
            .createSimple(GRIT_KEY)
            .attribute(RegistryAttribute.SYNCED)
            .buildAndRegister();

    public static void init() {}

    private ModRegistries() {}
}
