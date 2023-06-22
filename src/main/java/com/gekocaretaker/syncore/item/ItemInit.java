package com.gekocaretaker.syncore.item;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ItemInit {
    public static final Item COAL_NUGGET = new Item(new FabricItemSettings());
    public static final Item COPPER_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_DIAMOND = new Item(new FabricItemSettings());
    public static final Item DIAMOND_NUGGET = new Item(new FabricItemSettings());
    public static final Item NETHERITE_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_EMERALD = new Item(new FabricItemSettings());
    public static final Item EMERALD_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_LAPIS_LAZULI = new Item(new FabricItemSettings());
    public static final Item LAPIS_LAZULI_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_REDSTONE = new Item(new FabricItemSettings());
    public static final Item REDSTONE_GEMSTONE = new Item(new FabricItemSettings());
    public static final Item CHARCOAL_NUGGET = new Item(new FabricItemSettings());
    public static final Item RAW_QUARTZ = new Item(new FabricItemSettings());
    public static final Item QUARTZ_NUGGET = new Item(new FabricItemSettings());
    public static final Item AMETHYST_NUGGET = new Item(new FabricItemSettings());

    public static void init() {
        register(new BlockItem(BlockInit.ROCK_TUMBLER_BLOCK, new FabricItemSettings()), "rock_tumbler");
        register(COAL_NUGGET, "coal_nugget");
        FuelRegistry.INSTANCE.add(COAL_NUGGET, 200);
        register(COPPER_NUGGET, "copper_nugget");
        register(RAW_DIAMOND, "raw_diamond");
        register(DIAMOND_NUGGET, "diamond_nugget");
        register(new BlockItem(BlockInit.RAW_DIAMOND_BLOCK, new FabricItemSettings()), "raw_diamond_block");
        register(new BlockItem(BlockInit.RAW_NETHERITE_BLOCK, new FabricItemSettings()), "raw_netherite_block");
        register(NETHERITE_NUGGET, "netherite_nugget");
        register(RAW_EMERALD, "raw_emerald");
        register(new BlockItem(BlockInit.RAW_EMERALD_BLOCK, new FabricItemSettings()), "raw_emerald_block");
        register(EMERALD_NUGGET, "emerald_nugget");
        register(RAW_LAPIS_LAZULI, "raw_lapis_lazuli");
        register(new BlockItem(BlockInit.RAW_LAPIS_LAZULI_BLOCK, new FabricItemSettings()), "raw_lapis_lazuli_block");
        register(LAPIS_LAZULI_NUGGET, "lapis_lazuli_nugget");
        register(RAW_REDSTONE, "raw_redstone");
        register(new BlockItem(BlockInit.RAW_REDSTONE_BLOCK, new FabricItemSettings()), "raw_redstone_block");
        register(REDSTONE_GEMSTONE, "redstone_gemstone");
        register(CHARCOAL_NUGGET, "charcoal_nugget");
        FuelRegistry.INSTANCE.add(CHARCOAL_NUGGET, 200);
        register(new BlockItem(BlockInit.CHARCOAL_BLOCK, new FabricItemSettings()), "charcoal_block");
        FuelRegistry.INSTANCE.add(BlockInit.CHARCOAL_BLOCK, 16000);
        register(RAW_QUARTZ, "raw_quartz");
        register(new BlockItem(BlockInit.RAW_QUARTZ_BLOCK, new FabricItemSettings()), "raw_quartz_block");
        register(QUARTZ_NUGGET, "quartz_nugget");
        register(AMETHYST_NUGGET, "amethyst_nugget");
    }

    private static void register(Item item, String id) {
        Syncore.LOGGER.info("Creating item with id of '" + id + "'.");
        Registry.register(Registries.ITEM, new Identifier(Syncore.MOD_ID, id), item);
    }

    /*private static final ItemGroup SYNCORE_GROUP = FabricItemGroupBuilder.create(
            new Identifier(Syncore.MOD_ID, "general"))
            .icon(() -> new ItemStack(RAW_DIAMOND))
            .appendItems(stacks -> {
                // <editor-fold desc="Misc. Row">
                stacks.add(new ItemStack(Items.FURNACE));
                stacks.add(new ItemStack(Items.BLAST_FURNACE));
                stacks.add(new ItemStack(BlockInit.ROCK_TUMBLER_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Coal">
                stacks.add(new ItemStack(Items.COAL_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_COAL_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(COAL_NUGGET));
                stacks.add(new ItemStack(Items.COAL));
                stacks.add(new ItemStack(Items.COAL_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Iron">
                stacks.add(new ItemStack(Items.IRON_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_IRON_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.RAW_IRON));
                stacks.add(new ItemStack(Items.RAW_IRON_BLOCK));
                stacks.add(new ItemStack(Items.IRON_NUGGET));
                stacks.add(new ItemStack(Items.IRON_INGOT));
                stacks.add(new ItemStack(Items.IRON_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Gold">
                stacks.add(new ItemStack(Items.GOLD_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_GOLD_ORE));
                stacks.add(new ItemStack(Items.NETHER_GOLD_ORE));
                stacks.add(new ItemStack(Items.RAW_GOLD));
                stacks.add(new ItemStack(Items.RAW_GOLD_BLOCK));
                stacks.add(new ItemStack(Items.GOLD_NUGGET));
                stacks.add(new ItemStack(Items.GOLD_INGOT));
                stacks.add(new ItemStack(Items.GOLD_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Copper">
                stacks.add(new ItemStack(Items.COPPER_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_COPPER_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.RAW_COPPER));
                stacks.add(new ItemStack(Items.RAW_COPPER_BLOCK));
                stacks.add(new ItemStack(COPPER_NUGGET));
                stacks.add(new ItemStack(Items.COPPER_INGOT));
                stacks.add(new ItemStack(Items.COPPER_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Diamond">
                stacks.add(new ItemStack(Items.DIAMOND_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_DIAMOND_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(RAW_DIAMOND));
                stacks.add(new ItemStack(BlockInit.RAW_DIAMOND_BLOCK));
                stacks.add(new ItemStack(DIAMOND_NUGGET));
                stacks.add(new ItemStack(Items.DIAMOND));
                stacks.add(new ItemStack(Items.DIAMOND_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Netherite">
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.ANCIENT_DEBRIS));
                stacks.add(new ItemStack(Items.NETHERITE_SCRAP));
                stacks.add(new ItemStack(BlockInit.RAW_NETHERITE_BLOCK));
                stacks.add(new ItemStack(NETHERITE_NUGGET));
                stacks.add(new ItemStack(Items.NETHERITE_INGOT));
                stacks.add(new ItemStack(Items.NETHERITE_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Emerald">
                stacks.add(new ItemStack(Items.EMERALD_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_EMERALD_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(RAW_EMERALD));
                stacks.add(new ItemStack(BlockInit.RAW_EMERALD_BLOCK));
                stacks.add(new ItemStack(EMERALD_NUGGET));
                stacks.add(new ItemStack(Items.EMERALD));
                stacks.add(new ItemStack(Items.EMERALD_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Lapis Lazuli">
                stacks.add(new ItemStack(Items.LAPIS_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_LAPIS_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(RAW_LAPIS_LAZULI));
                stacks.add(new ItemStack(BlockInit.RAW_LAPIS_LAZULI_BLOCK));
                stacks.add(new ItemStack(LAPIS_LAZULI_NUGGET));
                stacks.add(new ItemStack(Items.LAPIS_LAZULI));
                stacks.add(new ItemStack(Items.LAPIS_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Redstone">
                stacks.add(new ItemStack(Items.REDSTONE_ORE));
                stacks.add(new ItemStack(Items.DEEPSLATE_REDSTONE_ORE));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(RAW_REDSTONE));
                stacks.add(new ItemStack(BlockInit.RAW_REDSTONE_BLOCK));
                stacks.add(new ItemStack(Items.REDSTONE));
                stacks.add(new ItemStack(REDSTONE_GEMSTONE));
                stacks.add(new ItemStack(Items.REDSTONE_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Charcoal">
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(CHARCOAL_NUGGET));
                stacks.add(new ItemStack(Items.CHARCOAL));
                stacks.add(new ItemStack(BlockInit.CHARCOAL_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Quartz">
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.AIR));
                stacks.add(new ItemStack(Items.NETHER_QUARTZ_ORE));
                stacks.add(new ItemStack(RAW_QUARTZ));
                stacks.add(new ItemStack(BlockInit.RAW_QUARTZ_BLOCK));
                stacks.add(new ItemStack(QUARTZ_NUGGET));
                stacks.add(new ItemStack(Items.QUARTZ));
                stacks.add(new ItemStack(Items.QUARTZ_BLOCK));
                stacks.add(new ItemStack(Items.AIR));
                // </editor-fold>
                // <editor-fold desc="Loose">
                stacks.add(new ItemStack(AMETHYST_NUGGET));
                // </editor-fold>
            })
            .build();*/
}
