package com.gekocaretaker.syncore.client.datagen;

import com.gekocaretaker.syncore.Syncore;
import com.gekocaretaker.syncore.block.BlockInit;
import com.gekocaretaker.syncore.client.datagen.recipe.TumblingRecipeJsonBuilder;
import com.gekocaretaker.syncore.compat.advancednetherite.datagen.ANRecipeProvider;
import com.gekocaretaker.syncore.compat.moreores.datagen.MORecipeProvider;
import com.gekocaretaker.syncore.item.ItemInit;
import com.gekocaretaker.syncore.item.ItemTagInit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.recipe.RockTumblerRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SyncoreRecipeProvider extends FabricRecipeProvider {
    public SyncoreRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, BlockInit.ROCK_TUMBLER_BLOCK)
                        .group("rock_tumbler")
                        .pattern("EDE")
                        .pattern("RFR")
                        .pattern("SSS")
                        .input('E', ConventionalItemTags.EMERALD_GEMS)
                        .input('D', ConventionalItemTags.DIAMOND_GEMS)
                        .input('R', ItemTagInit.REDSTONE_GEMS)
                        .input('F', Items.FURNACE)
                        .input('S', Items.SMOOTH_STONE)
                        .criterion("has_furnace", this.conditionsFromItem(Items.FURNACE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.CHARCOAL_BLOCK)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', Items.CHARCOAL)
                        .criterion("has_charcoal", this.conditionsFromItem(Items.CHARCOAL))
                        .offerTo(exporter, "charcoal_from_nuggets");
                createShapeless(RecipeCategory.MISC, Items.CHARCOAL, 9)
                        .input(ItemTagInit.STORAGE_BLOCKS_CHARCOAL)
                        .group("charcoal")
                        .criterion("has_charcoal", this.conditionsFromItem(Items.CHARCOAL))
                        .offerTo(exporter, "charcoal_from_block");
                createShapeless(RecipeCategory.MISC, Items.CHARCOAL)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .input(ItemTagInit.CHARCOAL_NUGGETS)
                        .group("charcoal")
                        .criterion("has_charcoal", this.conditionsFromItem(Items.CHARCOAL))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.CHARCOAL_NUGGET, 8)
                        .input(Items.CHARCOAL)
                        .criterion("has_charcoal", this.conditionsFromItem(Items.CHARCOAL))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.COAL_NUGGET, 8)
                        .input(Items.COAL)
                        .criterion("has_coal", this.conditionsFromItem(Items.COAL))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, Items.COAL)
                        .group("coal")
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .input(ItemTagInit.COAL_NUGGETS)
                        .criterion("has_coal", this.conditionsFromItem(Items.COAL))
                        .offerTo(exporter, "coal_from_nuggets");
                createShapeless(RecipeCategory.MISC, ItemInit.COPPER_NUGGET, 9)
                        .input(ConventionalItemTags.COPPER_INGOTS)
                        .criterion("has_copper", this.conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.COPPER_INGOT)
                        .group("copper")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemTagInit.COPPER_NUGGETS)
                        .criterion("has_copper", this.conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter, "copper_ingot_from_nuggets");
                offerSmelting(List.of(Items.BRUSH, Items.SPYGLASS), RecipeCategory.MISC, ItemInit.COPPER_NUGGET, 0.1f, 200, "copper_nugget");
                offerBlasting(List.of(Items.BRUSH, Items.SPYGLASS), RecipeCategory.MISC, ItemInit.COPPER_NUGGET, 0.1f, 100, "copper_nugget");
                createShaped(RecipeCategory.MISC, Items.DIAMOND)
                        .group("diamond")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemTagInit.DIAMOND_SHARDS)
                        .criterion("has_diamond", this.conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter, "diamond_from_shards");
                offerSmelting(List.of(ItemInit.ROUGH_DIAMOND), RecipeCategory.MISC, Items.DIAMOND, 1, 200, "diamond");
                offerTumbling(List.of(ItemInit.ROUGH_DIAMOND, Items.DIAMOND_ORE, Items.DEEPSLATE_DIAMOND_ORE),
                        RecipeCategory.MISC, Items.DIAMOND, 1, 100, "diamond");
                offerTumbling(List.of(Items.DIAMOND_SWORD, Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL,
                                Items.DIAMOND_HOE, Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS,
                                Items.DIAMOND_BOOTS, Items.DIAMOND_HORSE_ARMOR),
                        RecipeCategory.MISC, ItemInit.DIAMOND_SHARD, 0.1F, 100, "diamond_shard");
                createShapeless(RecipeCategory.MISC, ItemInit.DIAMOND_SHARD, 9)
                        .input(ConventionalItemTags.DIAMOND_GEMS)
                        .criterion("has_diamond", this.conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.ROUGH_DIAMOND_BLOCK)
                        .input('n', ItemInit.ROUGH_DIAMOND)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .criterion("has_rough_diamond", this.conditionsFromItem(ItemInit.ROUGH_DIAMOND))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.ROUGH_DIAMOND, 9)
                        .input(BlockInit.ROUGH_DIAMOND_BLOCK)
                        .criterion("has_rough_diamond", this.conditionsFromItem(ItemInit.ROUGH_DIAMOND))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.EMERALD)
                        .group("emerald")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemTagInit.EMERALD_SHARDS)
                        .criterion("has_emerald", this.conditionsFromItem(Items.EMERALD))
                        .offerTo(exporter, "emerald_from_shards");
                offerSmelting(List.of(ItemInit.ROUGH_EMERALD), RecipeCategory.MISC, Items.EMERALD, 1, 200, "emerald");
                offerTumbling(List.of(ItemInit.ROUGH_EMERALD, Items.EMERALD_ORE, Items.DEEPSLATE_EMERALD_ORE),
                        RecipeCategory.MISC, Items.EMERALD, 1, 100, "emerald");
                createShapeless(RecipeCategory.MISC, ItemInit.EMERALD_SHARD, 9)
                        .input(ConventionalItemTags.EMERALD_GEMS)
                        .criterion("has_emerald", this.conditionsFromItem(Items.EMERALD))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.ROUGH_EMERALD_BLOCK)
                        .input('n', ItemInit.ROUGH_EMERALD)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .criterion("has_rough_emerald", this.conditionsFromItem(ItemInit.ROUGH_EMERALD))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.ROUGH_EMERALD, 9)
                        .input(BlockInit.ROUGH_EMERALD_BLOCK)
                        .criterion("has_rough_emerald", this.conditionsFromItem(ItemInit.ROUGH_EMERALD))
                        .offerTo(exporter);
                offerSmelting(List.of(Items.SHEARS, Items.FLINT_AND_STEEL), RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 200, "iron_nugget");
                offerBlasting(List.of(Items.SHEARS, Items.FLINT_AND_STEEL), RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 100, "iron_nugget");
                createShaped(RecipeCategory.MISC, Items.LAPIS_LAZULI)
                        .group("lapis_lazuli")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemTagInit.LAPIS_SHARDS)
                        .criterion("has_lapis", this.conditionsFromItem(Items.LAPIS_LAZULI))
                        .offerTo(exporter, "lapis_lazuli_from_shards");
                offerSmelting(List.of(ItemInit.ROUGH_LAPIS_LAZULI), RecipeCategory.MISC, Items.LAPIS_LAZULI, 1, 200, "lapis_lazuli");
                offerTumbling(List.of(ItemInit.ROUGH_LAPIS_LAZULI, Items.LAPIS_ORE, Items.DEEPSLATE_LAPIS_ORE),
                        RecipeCategory.MISC, Items.LAPIS_LAZULI, 1, 100, "lapis_lazuli");
                createShapeless(RecipeCategory.MISC, ItemInit.LAPIS_LAZULI_SHARD, 9)
                        .input(ConventionalItemTags.LAPIS_GEMS)
                        .criterion("has_lapis", this.conditionsFromItem(Items.LAPIS_LAZULI))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.ROUGH_LAPIS_LAZULI_BLOCK)
                        .input('n', ItemInit.ROUGH_LAPIS_LAZULI)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .criterion("has_rough_lapis", this.conditionsFromItem(ItemInit.ROUGH_LAPIS_LAZULI))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.ROUGH_LAPIS_LAZULI, 9)
                        .input(BlockInit.ROUGH_LAPIS_LAZULI_BLOCK)
                        .criterion("has_rough_lapis", this.conditionsFromItem(ItemInit.ROUGH_LAPIS_LAZULI))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.NETHERITE_INGOT)
                        .group("netherite")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemTagInit.NETHERITE_NUGGETS)
                        .criterion("has_netherite", this.conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(exporter, "netherite_ingot_from_nuggets");
                createShapeless(RecipeCategory.MISC, ItemInit.NETHERITE_NUGGET, 9)
                        .input(ConventionalItemTags.NETHERITE_INGOTS)
                        .criterion("has_netherite", this.conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, Items.NETHERITE_SCRAP, 9)
                        .input(BlockInit.RAW_NETHERITE_BLOCK)
                        .criterion("has_netherite_scrap", this.conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.RAW_NETHERITE_BLOCK)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', Items.NETHERITE_SCRAP)
                        .criterion("has_netherite_scrap", this.conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(exporter);
                offerBlasting(List.of(Items.NETHERITE_SWORD, Items.NETHERITE_AXE, Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL,
                        Items.NETHERITE_HOE, Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS,
                        Items.NETHERITE_BOOTS), RecipeCategory.MISC, ItemInit.NETHERITE_NUGGET, 0.1f, 100, "netherite_nugget");
                createShapeless(RecipeCategory.MISC, Items.QUARTZ, 4)
                        .group("quartz")
                        .input(Items.QUARTZ_BLOCK)
                        .criterion("has_quartz", this.conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, "quartz_from_block");
                createShaped(RecipeCategory.MISC, Items.QUARTZ)
                        .group("quartz")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemTagInit.QUARTZ_SHARDS)
                        .criterion("has_quartz", this.conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, "quartz_from_shards");
                offerSmelting(List.of(ItemInit.ROUGH_QUARTZ), RecipeCategory.MISC, Items.QUARTZ, 1, 200, "quartz");
                offerTumbling(List.of(ItemInit.ROUGH_QUARTZ, Items.NETHER_QUARTZ_ORE),
                        RecipeCategory.MISC, Items.QUARTZ, 1, 100, "quartz");
                createShapeless(RecipeCategory.MISC, ItemInit.QUARTZ_SHARD, 9)
                        .input(ConventionalItemTags.QUARTZ_GEMS)
                        .criterion("has_quartz", this.conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.ROUGH_QUARTZ_BLOCK)
                        .input('n', ItemInit.ROUGH_QUARTZ)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .criterion("has_rough_quartz", this.conditionsFromItem(ItemInit.ROUGH_QUARTZ))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.ROUGH_QUARTZ, 9)
                        .input(BlockInit.ROUGH_QUARTZ_BLOCK)
                        .criterion("has_rough_quartz", this.conditionsFromItem(ItemInit.ROUGH_QUARTZ))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ItemInit.REDSTONE_GEMSTONE)
                        .group("redstone_gem")
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ConventionalItemTags.REDSTONE_DUSTS)
                        .criterion("has_redstone", this.conditionsFromItem(ItemInit.REDSTONE_GEMSTONE))
                        .offerTo(exporter);
                offerSmelting(List.of(ItemInit.ROUGH_REDSTONE), RecipeCategory.MISC, ItemInit.REDSTONE_GEMSTONE, 1, 200, "redstone_gem");
                offerTumbling(List.of(ItemInit.ROUGH_REDSTONE, Items.REDSTONE_ORE, Items.DEEPSLATE_REDSTONE_ORE),
                        RecipeCategory.MISC, ItemInit.REDSTONE_GEMSTONE, 1, 100, "redstone_gem");
                createShapeless(RecipeCategory.MISC, Items.REDSTONE, 9)
                        .input(ItemTagInit.REDSTONE_GEMS)
                        .criterion("has_redstone", this.conditionsFromItem(ItemInit.REDSTONE_GEMSTONE))
                        .offerTo(exporter, "redstone_dust_from_gem");
                createShaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.ROUGH_REDSTONE_BLOCK)
                        .input('n', ItemInit.ROUGH_REDSTONE)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .criterion("has_rough_redstone", this.conditionsFromItem(ItemInit.ROUGH_REDSTONE))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.ROUGH_REDSTONE, 9)
                        .input(BlockInit.ROUGH_REDSTONE_BLOCK)
                        .criterion("has_rough_redstone", this.conditionsFromItem(ItemInit.ROUGH_REDSTONE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.RESIN_BRICK)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', ItemInit.RESIN_NUGGET)
                        .criterion("has_resin_brick", this.conditionsFromItem(Items.RESIN_BRICK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.RESIN_NUGGET, 9)
                        .input(Items.RESIN_BRICK)
                        .criterion("has_resin_brick", this.conditionsFromItem(Items.RESIN_BRICK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.GRIT_BLOCK, 8)
                        .input(Blocks.GRAVEL)
                        .input(Blocks.GRAVEL)
                        .input(Blocks.SAND)
                        .input(Blocks.SAND)
                        .input(Blocks.SAND)
                        .input(Blocks.CLAY)
                        .input(Blocks.CLAY)
                        .input(Blocks.CLAY)
                        .input(Items.BLACK_DYE)
                        .criterion("has_sand", this.conditionsFromItem(Blocks.SAND))
                        .criterion("has_clay", this.conditionsFromItem(Blocks.GRAVEL))
                        .offerTo(exporter);

                offerSmelting(List.of(BlockInit.NETHER_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1F, 200, "coal");
                offerBlasting(List.of(BlockInit.NETHER_COAL_ORE), RecipeCategory.MISC, Items.COAL, 0.1F, 100, "coal");
                offerSmelting(List.of(BlockInit.NETHER_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 200, "iron_ingot");
                offerBlasting(List.of(BlockInit.NETHER_IRON_ORE), RecipeCategory.MISC, Items.IRON_INGOT, 0.7F, 100, "iron_ingot");
                offerSmelting(List.of(BlockInit.NETHER_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7F, 200, "copper_ingot");
                offerBlasting(List.of(BlockInit.NETHER_COPPER_ORE), RecipeCategory.MISC, Items.COPPER_INGOT, 0.7F, 100, "copper_ingot");
                offerSmelting(List.of(BlockInit.NETHER_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1, 200, "diamond");
                offerTumbling(List.of(BlockInit.NETHER_DIAMOND_ORE), RecipeCategory.MISC, Items.DIAMOND, 1, 100, "diamond");
                offerSmelting(List.of(BlockInit.NETHER_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1, 200, "emerald");
                offerTumbling(List.of(BlockInit.NETHER_EMERALD_ORE), RecipeCategory.MISC, Items.EMERALD, 1, 100, "emerald");
                offerSmelting(List.of(BlockInit.NETHER_LAPIS_LAZULI_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2F, 200, "lapis_lazuli");
                offerTumbling(List.of(BlockInit.NETHER_LAPIS_LAZULI_ORE), RecipeCategory.MISC, Items.LAPIS_LAZULI, 1, 100, "lapis_lazuli");
                offerSmelting(List.of(BlockInit.NETHER_REDSTONE_ORE), RecipeCategory.MISC, ItemInit.REDSTONE_GEMSTONE, 0.7F, 200, "redstone");
                offerTumbling(List.of(BlockInit.NETHER_REDSTONE_ORE), RecipeCategory.MISC, ItemInit.REDSTONE_GEMSTONE, 1, 100, "redstone");
                offerSmelting(List.of(BlockInit.QUARTZ_ORE, BlockInit.DEEPSLATE_QUARTZ_ORE), RecipeCategory.MISC, Items.QUARTZ, 0.2F, 200, "quartz");
                offerTumbling(List.of(BlockInit.QUARTZ_ORE, BlockInit.DEEPSLATE_QUARTZ_ORE), RecipeCategory.MISC, Items.QUARTZ, 1, 100, "quartz");

                if (Syncore.isModPresent("more-ores")) {
                    MORecipeProvider.INSTANCE.provide(wrapperLookup, exporter);
                }
                if (Syncore.isModPresent("advancednetherite")) {
                    ANRecipeProvider.INSTANCE.provide(wrapperLookup, exporter);
                }
            }

            public void offerTumbling(List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group) {
                this.offerMultipleTumblingOptions(RecipeInit.ROCK_TUMBLER_RECIPE_SERIALIZER, RockTumblerRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_tumbling");
            }

            public final <T extends AbstractCookingRecipe> void offerMultipleTumblingOptions(RecipeSerializer<T> serializer, AbstractCookingRecipe.RecipeFactory<T> recipeFactory, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group, String suffix) {
                for (ItemConvertible itemConvertible : inputs) {
                    TumblingRecipeJsonBuilder.create(Ingredient.ofItem(itemConvertible), category, output, experience, cookingTime, serializer, recipeFactory).group(group).criterion(hasItem(itemConvertible), this.conditionsFromItem(itemConvertible)).offerTo(this.exporter, getItemPath(output) + suffix + "_" + getItemPath(itemConvertible));
                }
            }
        };
    }

    @Override
    public String getName() {
        return "SyncoreRecipeProvider";
    }
}
