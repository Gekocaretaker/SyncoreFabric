package com.gekocaretaker.syncore.block.entity;

import com.gekocaretaker.syncore.item.Grit;
import com.gekocaretaker.syncore.recipe.RecipeInit;
import com.gekocaretaker.syncore.registry.ModRegistries;
import com.gekocaretaker.syncore.screen.RockTumblerScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.Iterator;

public class RockTumblerBlockEntity extends AbstractFurnaceBlockEntity {
    public RockTumblerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.ROCK_TUMBLER_BLOCK_ENTITY, pos, state, RecipeInit.ROCK_TUMBLER_RECIPE_TYPE);
    }

    @Override
    public Text getContainerName() {
        return Text.translatable("container.rock_tumbler");
    }

    @Override
    protected int getFuelTime(FuelRegistry fuelRegistry, ItemStack stack) {
        return Grit.getTumbleTime(stack) / 2;
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new RockTumblerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (slot == 2) {
            return false;
        } else if (slot != 1) {
            return true;
        } else {
            return Grit.isGrit(stack);
        }
    }
}
