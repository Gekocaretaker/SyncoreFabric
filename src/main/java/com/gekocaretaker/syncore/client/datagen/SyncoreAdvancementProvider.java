package com.gekocaretaker.syncore.client.datagen;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SyncoreAdvancementProvider extends FabricAdvancementProvider {
    protected SyncoreAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    // Figuring out if I want to include collecting advancements
    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        /*AdvancementEntry root = Advancement.Builder.create()
                .display(
                        BlockInit.GRIT_BLOCK, translate("root.title"),
                        translate("root.description"), Syncore.identify("textures/gui/advancements/backgrounds/collection.png"),
                        AdvancementFrame.TASK, false, false, false
                ).criterion("tick", TickCriterion.Conditions.createTick())
                .build(consumer, id("root"));
        AdvancementEntry vanilla = Advancement.Builder.create()
                .display(
                        Items.GRASS_BLOCK, translate("vanilla.title"),
                        translate("vanilla.description"), null,
                        AdvancementFrame.TASK, false, false, false
                ).criterion("tick", TickCriterion.Conditions.createTick())
                .parent(root)
                .build(consumer, id("vanilla"));*/
    }

    private Text translate(String path) {
        return Text.translatable("advancements.syncore.collection." + path);
    }

    private String id(String path) {
        return Syncore.MOD_ID + ":collection/" + path;
    }
}
