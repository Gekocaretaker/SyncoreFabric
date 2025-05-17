package com.gekocaretaker.syncore.item;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.registry.ModRegistries;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;

public class ModGrits {
    public static final Grit SAND = register("sand", Items.SAND, Grit.baseSmeltTime() * 4); // Half as good
    public static final Grit RED_SAND = register("red_sand", Items.RED_SAND, Grit.baseSmeltTime() * 4); // Half as good
    public static final Grit GRAVEL = register("gravel", Items.GRAVEL, Grit.baseSmeltTime() * 4);
    public static final Grit GRIT = register("grit", BlockInit.GRIT_BLOCK.asItem(), Grit.baseSmeltTime() * 8); // Same as coal

    private static Grit register(String id, Item item, int time) {
        return Registry.register(ModRegistries.GRIT, Syncore.identify(id), new Grit(item, time));
    }

    public static void init() {}

    private ModGrits() {}
}
