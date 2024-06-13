package cn.dancingsnow.epcore.api.item.armor;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

public interface IOxygenArmor {
    long getMaxOxygen();

    default long getOxygen(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            if (tag.contains("Oxygen", Tag.TAG_LONG)) {
                return tag.getLong("Oxygen");
            }
        }
        return 0;
    }

    default boolean hasOxygen(ItemStack stack) {
        return getOxygen(stack) > 0;
    }

    default void setOxygen(ItemStack stack, long oxygen) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putLong("Oxygen", oxygen);
    }

    default long insertOxygen(ItemStack stack, long toInsert, boolean simulate) {
        long amount = getOxygen(stack);
        if (amount + toInsert <= getMaxOxygen()) {
            amount += toInsert;
            if (!simulate) {
                setOxygen(stack, amount);
            }
            return toInsert;
        } else {
            if (!simulate) {
                setOxygen(stack, getMaxOxygen());
            }
            return getMaxOxygen() - amount;
        }
    }

    default long extractOxygen(ItemStack stack, long toExtract, boolean simulate) {
        long amount = getOxygen(stack);
        if (amount >= toExtract) {
            amount -= toExtract;
            if (!simulate) {
                setOxygen(stack, amount);
            }
            return toExtract;
        } else {
            if (!simulate) {
                setOxygen(stack, 0);
            }
            return amount;
        }
    }
}
