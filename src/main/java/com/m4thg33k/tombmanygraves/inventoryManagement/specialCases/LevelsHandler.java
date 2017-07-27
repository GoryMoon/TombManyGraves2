package com.m4thg33k.tombmanygraves.inventoryManagement.specialCases;

import com.thexfactor117.levels.leveling.Attribute;
import com.thexfactor117.levels.util.NBTHelper;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

public class LevelsHandler {

    public static boolean hasLevelsSoulbound(ItemStack stack)
    {
        if (stack == null || stack.isEmpty())
        {
            return false;
        }

        Item item = stack.getItem();

        if (!(item instanceof ItemSword ||
                item instanceof ItemShield ||
                item instanceof ItemArmor ||
                item instanceof ItemBow))
        {
            return false;
        }

        NBTTagCompound nbt = NBTHelper.loadStackNBT(stack);

        return (nbt != null) && (Attribute.SOUL_BOUND.hasAttribute(nbt) && Attribute.SOUL_BOUND.isActive(nbt));
    }
}
