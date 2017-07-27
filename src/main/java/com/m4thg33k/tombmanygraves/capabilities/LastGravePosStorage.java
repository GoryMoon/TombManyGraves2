package com.m4thg33k.tombmanygraves.capabilities;

import com.m4thg33k.tombmanygraves.inventoryManagement.InventoryHolder;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class LastGravePosStorage implements Capability.IStorage<ILastGravePos> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ILastGravePos> capability, ILastGravePos instance, EnumFacing side) {
        NBTTagCompound compound = new NBTTagCompound();

        BlockPos pos = instance.getGravePos();

        if (pos == null)
        {
            return compound;
        }

        compound.setInteger("x", pos.getX());
        compound.setInteger("y", pos.getY());
        compound.setInteger("z", pos.getZ());

        return compound;
    }

    @Override
    public void readNBT(Capability<ILastGravePos> capability, ILastGravePos instance, EnumFacing side, NBTBase nbt) {
        BlockPos pos = null;

        if (nbt instanceof NBTTagCompound)
        {
            NBTTagCompound compound = (NBTTagCompound) nbt;

            if (compound.hasKey("x"))
            {
                pos = new BlockPos(compound.getInteger("x"), compound.getInteger("y"), compound.getInteger("z"));
            }
        }

        instance.setGravePos(pos);
    }
}
