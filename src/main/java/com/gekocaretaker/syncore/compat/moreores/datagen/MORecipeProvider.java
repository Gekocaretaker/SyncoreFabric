package com.gekocaretaker.syncore.compat.moreores.datagen;

import com.gekocaretaker.syncore.compat.moreores.item.MOItems;
import com.gekocaretaker.syncore.util.CompatRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import rvl.more_ores.item.ModItems;

import java.util.List;

public class MORecipeProvider implements CompatRecipeProvider {
    public static final MORecipeProvider INSTANCE = new MORecipeProvider();

    private MORecipeProvider() {}

    @Override
    public void provide(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
        RecipeGenerator generator = new RecipeGenerator(wrapperLookup, exporter) {
            @Override
            public void generate() {
                smelt(List.of(ModItems.ALUMINIUM_AXE, ModItems.ALUMINIUM_PICKAXE, ModItems.ALUMINIUM_SHOVEL,
                                ModItems.ALUMINIUM_HOE, ModItems.ALUMINIUM_SWORD, ModItems.ALUMINIUM_HELMET,
                                ModItems.ALUMINIUM_CHESTPLATE, ModItems.ALUMINIUM_LEGGINGS, ModItems.ALUMINIUM_BOOTS),
                        MOItems.ALUMINIUM_NUGGET, "aluminium");
                nuggetRecipes(ModItems.ALUMINIUM_INGOT, MOItems.ALUMINIUM_NUGGET, "aluminium_ingot");

                smelt(List.of(ModItems.BRONZE_AXE, ModItems.BRONZE_PICKAXE, ModItems.BRONZE_SHOVEL,
                        ModItems.BRONZE_HOE, ModItems.BRONZE_SWORD, ModItems.BRONZE_HELMET,
                        ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS),
                        MOItems.BRONZE_NUGGET, "bronze");
                nuggetRecipes(ModItems.BRONZE_INGOT, MOItems.BRONZE_NUGGET, "bronze_ingot");

                smelt(List.of(ModItems.CHROME_AXE, ModItems.CHROME_PICKAXE, ModItems.CHROME_SHOVEL,
                        ModItems.CHROME_HOE, ModItems.CHROME_SWORD, ModItems.CHROME_HELMET,
                        ModItems.CHROME_CHESTPLATE, ModItems.CHROME_LEGGINGS, ModItems.CHROME_BOOTS),
                        MOItems.CHROME_NUGGET, "chrome");
                nuggetRecipes(ModItems.CHROME_INGOT, MOItems.CHROME_NUGGET, "chrome_ingot");

                smelt(List.of(ModItems.ENDERITE_AXE, ModItems.ENDERITE_PICKAXE, ModItems.ENDERITE_SHOVEL,
                                ModItems.ENDERITE_HOE, ModItems.ENDERITE_SWORD, ModItems.ENDERITE_HELMET,
                                ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS),
                        MOItems.ENDERITE_NUGGET, "enderite");
                nuggetRecipes(ModItems.ENDERITE_INGOT, MOItems.ENDERITE_NUGGET, "enderite_ingot");

                nuggetRecipes(ModItems.LITHIUM_INGOT, MOItems.LITHIUM_NUGGET, "lithium_ingot");

                smelt(List.of(ModItems.NICKEL_AXE, ModItems.NICKEL_PICKAXE, ModItems.NICKEL_SHOVEL,
                                ModItems.NICKEL_HOE, ModItems.NICKEL_SWORD, ModItems.NICKEL_HELMET,
                                ModItems.NICKEL_CHESTPLATE, ModItems.NICKEL_LEGGINGS, ModItems.NICKEL_BOOTS),
                        MOItems.NICKEL_NUGGET, "nickel");
                nuggetRecipes(ModItems.NICKEL_INGOT, MOItems.NICKEL_NUGGET, "nickel_ingot");

                smelt(List.of(ModItems.PLOMB_AXE, ModItems.PLOMB_PICKAXE, ModItems.PLOMB_SHOVEL,
                                ModItems.PLOMB_HOE, ModItems.PLOMB_SWORD, ModItems.PLOMB_HELMET,
                                ModItems.PLOMB_CHESTPLATE, ModItems.PLOMB_LEGGINGS, ModItems.PLOMB_BOOTS),
                        MOItems.PLOMB_NUGGET, "plomb");
                nuggetRecipes(ModItems.PLOMB_INGOT, MOItems.PLOMB_NUGGET, "plomb_ingot");

                smelt(List.of(ModItems.RACKNITE_AXE, ModItems.RACKNITE_PICKAXE, ModItems.RACKNITE_SHOVEL,
                                ModItems.RACKNITE_HOE, ModItems.RACKNITE_SWORD, ModItems.RACKNITE_HELMET,
                                ModItems.RACKNITE_CHESTPLATE, ModItems.RACKNITE_LEGGINGS, ModItems.RACKNITE_BOOTS),
                        MOItems.RACKNITE_NUGGET, "racknite");
                nuggetRecipes(ModItems.RACKNITE_INGOT, MOItems.RACKNITE_NUGGET, "racknite_ingot");

                nuggetRecipes(ModItems.SILICON_INGOT, MOItems.SILICON_NUGGET, "silicon_ingot");

                smelt(List.of(ModItems.SILVER_AXE, ModItems.SILVER_PICKAXE, ModItems.SILVER_SHOVEL,
                                ModItems.SILVER_HOE, ModItems.SILVER_SWORD, ModItems.SILVER_HELMET,
                                ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS),
                        MOItems.SILVER_NUGGET, "silver");
                nuggetRecipes(ModItems.SILVER_INGOT, MOItems.SILVER_NUGGET, "silver_ingot");

                nuggetRecipes(ModItems.SODIUM_INGOT, MOItems.SODIUM_NUGGET, "sodium_ingot");

                smelt(List.of(ModItems.SOULRITE_AXE, ModItems.SOULRITE_PICKAXE, ModItems.SOULRITE_SHOVEL,
                                ModItems.SOULRITE_HOE, ModItems.SOULRITE_SWORD, ModItems.SOULRITE_HELMET,
                                ModItems.SOULRITE_CHESTPLATE, ModItems.SOULRITE_LEGGINGS, ModItems.SOULRITE_BOOTS),
                        MOItems.SOULRITE_NUGGET, "soulrite");
                nuggetRecipes(ModItems.SOULRITE_INGOT, MOItems.SOULRITE_NUGGET, "soulrite_ingot");

                smelt(List.of(ModItems.STEEL_AXE, ModItems.STEEL_PICKAXE, ModItems.STEEL_SHOVEL,
                                ModItems.STEEL_HOE, ModItems.STEEL_SWORD, ModItems.STEEL_HELMET,
                                ModItems.STEEL_CHESTPLATE, ModItems.STEEL_LEGGINGS, ModItems.STEEL_BOOTS),
                        MOItems.STEEL_NUGGET, "steel");
                nuggetRecipes(ModItems.STEEL_INGOT, MOItems.STEEL_NUGGET, "steel_ingot");

                smelt(List.of(ModItems.TIN_AXE, ModItems.TIN_PICKAXE, ModItems.TIN_SHOVEL,
                                ModItems.TIN_HOE, ModItems.TIN_SWORD, ModItems.TIN_HELMET,
                                ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS),
                        MOItems.TIN_NUGGET, "tin");
                nuggetRecipes(ModItems.TIN_INGOT, MOItems.TIN_NUGGET, "tin_ingot");

                smelt(List.of(ModItems.TITANIUM_AXE, ModItems.TITANIUM_PICKAXE, ModItems.TITANIUM_SHOVEL,
                                ModItems.TITANIUM_HOE, ModItems.TITANIUM_SWORD, ModItems.TITANIUM_HELMET,
                                ModItems.TITANIUM_CHESTPLATE, ModItems.TITANIUM_LEGGINGS, ModItems.TITANIUM_BOOTS),
                        MOItems.TITANIUM_NUGGET, "titanium");
                nuggetRecipes(ModItems.TITANIUM_INGOT, MOItems.TITANIUM_NUGGET, "titanium_ingot");

                smelt(List.of(ModItems.VOLCANITE_AXE, ModItems.VOLCANITE_PICKAXE, ModItems.VOLCANITE_SHOVEL,
                                ModItems.VOLCANITE_HOE, ModItems.VOLCANITE_SWORD, ModItems.VOLCANITE_HELMET,
                                ModItems.VOLCANITE_CHESTPLATE, ModItems.VOLCANITE_LEGGINGS, ModItems.VOLCANITE_BOOTS),
                        MOItems.VOLCANITE_NUGGET, "volcanite");
                nuggetRecipes(ModItems.VOLCANITE_INGOT, MOItems.VOLCANITE_NUGGET, "volcanite_ingot");

                smelt(List.of(ModItems.ZINC_AXE, ModItems.ZINC_PICKAXE, ModItems.ZINC_SHOVEL,
                                ModItems.ZINC_HOE, ModItems.ZINC_SWORD, ModItems.ZINC_HELMET,
                                ModItems.ZINC_CHESTPLATE, ModItems.ZINC_LEGGINGS, ModItems.ZINC_BOOTS),
                        MOItems.ZINC_NUGGET, "zinc");
                nuggetRecipes(ModItems.ZINC_INGOT, MOItems.ZINC_NUGGET, "zinc_ingot");
            }

            private void nuggetRecipes(Item ingot, Item nugget, String group) {
                createShaped(RecipeCategory.MISC, ingot)
                        .group(group)
                        .pattern("nnn")
                        .pattern("nnn")
                        .pattern("nnn")
                        .input('n', nugget)
                        .criterion("has_ingot", this.conditionsFromItem(ingot))
                        .offerTo(exporter, group + "_from_nuggets");
                createShapeless(RecipeCategory.MISC, nugget, 9)
                        .input(ingot)
                        .criterion("has_ingot", this.conditionsFromItem(ingot))
                        .offerTo(exporter);
            }

            private void smelt(List<ItemConvertible> in, Item out, String material) {
                offerSmelting(in, RecipeCategory.MISC, out, 0.1f, 200, material + "_nugget");
                offerBlasting(in, RecipeCategory.MISC, out, 0.1f, 100, material + "_nugget");
            }
        };
        generator.generate();
    }
}
