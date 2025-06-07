package com.gekocaretaker.syncore.util;

import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public interface CompatModelProvider {
    public void blocks(BlockStateModelGenerator gen);
    public void items(ItemModelGenerator gen);
}
