package com.m4thg33k.tombmanygraves.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LastGravePosProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(ILastGravePos.class)
    public static final Capability<ILastGravePos> LAST_GRAVE = null;

    private ILastGravePos instance = LAST_GRAVE.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == LAST_GRAVE;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == LAST_GRAVE ? LAST_GRAVE.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return LAST_GRAVE.getStorage().writeNBT(LAST_GRAVE, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        LAST_GRAVE.getStorage().readNBT(LAST_GRAVE, this.instance, null, nbt);
    }
}
