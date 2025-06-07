package com.gekocaretaker.syncore.compat.advancednetherite.datagen;

import com.autovw.advancednetherite.core.ModItems;
import com.gekocaretaker.syncore.compat.advancednetherite.item.ANItems;
import com.gekocaretaker.syncore.util.CompatRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;

public class ANRecipeProvider implements CompatRecipeProvider {
    public static final ANRecipeProvider INSTANCE = new ANRecipeProvider();

    private ANRecipeProvider() {}

    @Override
    public void provide(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
        RecipeGenerator generator = new RecipeGenerator(wrapperLookup, exporter) {
            @Override
            public void generate() {
                smelt(List.of(ModItems.NETHERITE_IRON_AXE, ModItems.NETHERITE_IRON_HOE, ModItems.NETHERITE_IRON_PICKAXE,
                        ModItems.NETHERITE_IRON_SHOVEL, ModItems.NETHERITE_IRON_SWORD, ModItems.NETHERITE_IRON_HELMET,
                        ModItems.NETHERITE_IRON_CHESTPLATE, ModItems.NETHERITE_IRON_LEGGINGS, ModItems.NETHERITE_IRON_BOOTS),
                        ANItems.NETHERITE_IRON_NUGGET, "netherite_iron");
                nuggetRecipes(ModItems.NETHERITE_IRON_INGOT, ANItems.NETHERITE_IRON_NUGGET, "netherite_iron");

                smelt(List.of(ModItems.NETHERITE_GOLD_AXE, ModItems.NETHERITE_GOLD_HOE, ModItems.NETHERITE_GOLD_PICKAXE,
                                ModItems.NETHERITE_GOLD_SHOVEL, ModItems.NETHERITE_GOLD_SWORD, ModItems.NETHERITE_GOLD_HELMET,
                                ModItems.NETHERITE_GOLD_CHESTPLATE, ModItems.NETHERITE_GOLD_LEGGINGS, ModItems.NETHERITE_GOLD_BOOTS),
                        ANItems.NETHERITE_GOLD_NUGGET, "netherite_gold");
                nuggetRecipes(ModItems.NETHERITE_GOLD_INGOT, ANItems.NETHERITE_GOLD_NUGGET, "netherite_gold");

                smelt(List.of(ModItems.NETHERITE_EMERALD_AXE, ModItems.NETHERITE_EMERALD_HOE, ModItems.NETHERITE_EMERALD_PICKAXE,
                                ModItems.NETHERITE_EMERALD_SHOVEL, ModItems.NETHERITE_EMERALD_SWORD, ModItems.NETHERITE_EMERALD_HELMET,
                                ModItems.NETHERITE_EMERALD_CHESTPLATE, ModItems.NETHERITE_EMERALD_LEGGINGS, ModItems.NETHERITE_EMERALD_BOOTS),
                        ANItems.NETHERITE_EMERALD_NUGGET, "netherite_emerald");
                nuggetRecipes(ModItems.NETHERITE_EMERALD_INGOT, ANItems.NETHERITE_EMERALD_NUGGET, "netherite_emerald");

                smelt(List.of(ModItems.NETHERITE_DIAMOND_AXE, ModItems.NETHERITE_DIAMOND_HOE, ModItems.NETHERITE_DIAMOND_PICKAXE,
                                ModItems.NETHERITE_DIAMOND_SHOVEL, ModItems.NETHERITE_DIAMOND_SWORD, ModItems.NETHERITE_DIAMOND_HELMET,
                                ModItems.NETHERITE_DIAMOND_CHESTPLATE, ModItems.NETHERITE_DIAMOND_LEGGINGS, ModItems.NETHERITE_DIAMOND_BOOTS),
                        ANItems.NETHERITE_DIAMOND_NUGGET, "netherite_diamond");
                nuggetRecipes(ModItems.NETHERITE_DIAMOND_INGOT, ANItems.NETHERITE_DIAMOND_NUGGET, "netherite_diamond");
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
                offerBlasting(in, RecipeCategory.MISC, out, 0.1f, 100, material + "_nugget");
            }
        };
        generator.generate();
    }
}
