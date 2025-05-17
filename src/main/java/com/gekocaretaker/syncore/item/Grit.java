package com.gekocaretaker.syncore.item;

import com.gekocaretaker.syncore.registry.ModRegistries;
import com.mojang.serialization.Codec;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.Iterator;

public record Grit(Item grit, int gritTicks) {
    public static final Codec<RegistryEntry<Grit>> CODEC = ModRegistries.GRIT.getEntryCodec();
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<Grit>> PACKET_CODEC = PacketCodecs.registryEntry(ModRegistries.GRIT_KEY);

    public static int baseSmeltTime() {
        return 200;
    }

    public static int getTumbleTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Iterator<Grit> grits = ModRegistries.GRIT.iterator();
            Grit currentGrit;
            do {
                if (!grits.hasNext()) {
                    return 0;
                }
                currentGrit = grits.next();
            } while (!stack.itemMatches(Registries.ITEM.getEntry(currentGrit.grit())));
            return currentGrit.gritTicks();
        }
    }

    public static boolean isGrit(ItemStack stack) {
        Iterator<Grit> grits = ModRegistries.GRIT.iterator();
        Grit currentGrit;
        do {
            if (!grits.hasNext()) {
                return false;
            }
            currentGrit = grits.next();
        } while (!stack.itemMatches(Registries.ITEM.getEntry(currentGrit.grit())));
        return true;
    }
}
