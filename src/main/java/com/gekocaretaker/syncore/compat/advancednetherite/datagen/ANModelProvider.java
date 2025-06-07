package com.gekocaretaker.syncore.compat.advancednetherite.datagen;

import com.gekocaretaker.syncore.compat.advancednetherite.item.ANItems;
import com.gekocaretaker.syncore.util.CompatModelProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ANModelProvider implements CompatModelProvider {
    public static final ANModelProvider INSTANCE = new ANModelProvider();

    private ANModelProvider() {}

    @Override
    public void blocks(BlockStateModelGenerator gen) {
        //
    }

    @Override
    public void items(ItemModelGenerator gen) {
        gen.register(ANItems.NETHERITE_IRON_NUGGET, Models.GENERATED);
        gen.register(ANItems.NETHERITE_GOLD_NUGGET, Models.GENERATED);
        gen.register(ANItems.NETHERITE_EMERALD_NUGGET, Models.GENERATED);
        gen.register(ANItems.NETHERITE_DIAMOND_NUGGET, Models.GENERATED);
    }
}
