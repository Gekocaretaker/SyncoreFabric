package com.gekocaretaker.syncore.stat;

import com.gekocaretaker.syncore.Syncore;
import net.minecraft.registry.Registries;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class StatsInit {
    public static void init() {
        //
    }

    public static final Identifier INTERACT_WITH_ROCK_TUMBLER = StatsInit.register("interact_with_rock_tumbler", StatFormatter.DEFAULT);

    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = new Identifier(Syncore.MOD_ID, id);
        Registry.register(Registries.CUSTOM_STAT, id, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }
}
