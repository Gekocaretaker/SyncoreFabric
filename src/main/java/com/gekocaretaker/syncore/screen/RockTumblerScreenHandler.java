package com.gekocaretaker.syncore.screen;

import com.gekocaretaker.syncore.item.Grit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class RockTumblerScreenHandler extends AbstractRecipeScreenHandler {
    final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    protected final World world;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;
    private final RecipePropertySet recipePropertySet;
    private final RecipeBookType category;

    public RockTumblerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RecipeInit.ROCK_TUMBLER_RECIPE_TYPE, RecipeInit.ROCK_TUMBLER_INPUT_PROPERTY_SET, RecipeBookType.FURNACE, syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(4));
    }

    public RockTumblerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        this(ScreenHandlerInit.ROCK_TUMBLER_SCREEN_HANDLER, RecipeInit.ROCK_TUMBLER_RECIPE_TYPE, RecipeInit.ROCK_TUMBLER_INPUT_PROPERTY_SET, RecipeBookType.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }

    protected RockTumblerScreenHandler(ScreenHandlerType<?> type, RecipeType<?extends AbstractCookingRecipe> recipeType, RegistryKey<RecipePropertySet> recipePropertySetKey, RecipeBookType category, int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(type, syncId);
        this.recipeType = recipeType;
        this.category = category;
        checkSize(inventory, 3);
        checkDataCount(propertyDelegate, 4);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.getWorld();
        this.recipePropertySet = this.world.getRecipeManager().getPropertySet(recipePropertySetKey);
        this.addSlot(new Slot(inventory, 0, 56, 17));
        this.addSlot(new TumblerGritSlot(this, inventory, 1, 56, 53));
        this.addSlot(new FurnaceOutputSlot(playerInventory.player, inventory, 2, 116, 35));
        this.addPlayerSlots(playerInventory, 8, 84);
        this.addProperties(propertyDelegate);
    }

    public void populateRecipeFinder(RecipeFinder finder) {
        if (this.inventory instanceof RecipeInputProvider) {
            ((RecipeInputProvider) this.inventory).provideRecipeInputs(finder);
        }
    }

    public Slot getOutputSlot() {
        return this.slots.get(2);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 2) {
                if (!this.insertItem(itemStack2, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot != 1 && slot != 0) {
                if (this.isSmeltable(itemStack2)) {
                    if (!this.insertItem(itemStack2, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemStack2)) {
                    if (!this.insertItem(itemStack2, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 3 && slot < 30) {
                    if (!this.insertItem(itemStack2, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slot >= 30 && slot < 39 && !this.insertItem(itemStack2, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
        }

        return itemStack;
    }

    protected boolean isSmeltable(ItemStack itemStack) {
        return this.recipePropertySet.canUse(itemStack);
    }

    protected boolean isFuel(ItemStack item) {
        return Grit.isGrit(item);
    }

    public float getCookProgress() {
        int i = this.propertyDelegate.get(2);
        int j = this.propertyDelegate.get(3);
        return j != 0 && i != 0 ? MathHelper.clamp((float) i / (float) j, 0.0F, 1.0F) : 0.0F;
    }

    public float getFuelProgress() {
        int i = this.propertyDelegate.get(1);
        if (i == 0) {
            i = 200;
        }

        return MathHelper.clamp((float)this.propertyDelegate.get(0) / (float)i, 0.0F, 1.0F);
    }

    public AbstractRecipeScreenHandler.PostFillAction fillInputSlots(boolean craftAll, boolean creative, RecipeEntry<?> recipe, final ServerWorld world, PlayerInventory inventory) {
        final List<Slot> list = List.of(this.getSlot(0), this.getSlot(2));
        RecipeEntry<AbstractCookingRecipe> recipeEntry = (RecipeEntry<AbstractCookingRecipe>) recipe;
        return InputSlotFiller.fill(new InputSlotFiller.Handler<AbstractCookingRecipe>() {
            public void populateRecipeFinder(RecipeFinder finder) {
                RockTumblerScreenHandler.this.populateRecipeFinder(finder);
            }

            public void clear() {
                list.forEach((slot) -> {
                    slot.setStackNoCallbacks(ItemStack.EMPTY);
                });
            }

            public boolean matches(RecipeEntry<AbstractCookingRecipe> entry) {
                return ((AbstractCookingRecipe)entry.value()).matches(new SingleStackRecipeInput(RockTumblerScreenHandler.this.inventory.getStack(0)), world);
            }
        }, 1, 1, List.of(this.getSlot(0)), list, inventory, recipeEntry, craftAll, creative);
    }

    public boolean isBurning() {
        return this.propertyDelegate.get(0) > 0;
    }

    public RecipeBookType getCategory() {
        return this.category;
    }

    public static class TumblerGritSlot extends Slot {
        private final RockTumblerScreenHandler handler;

        public TumblerGritSlot(RockTumblerScreenHandler handler, Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
            this.handler = handler;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return this.handler.isFuel(stack);
        }
    }
}
