package com.m4thg33k.tombmanygraves.capabilities;

import net.minecraft.util.math.BlockPos;

public interface ILastGravePos {

    void setGravePos(BlockPos pos);

    BlockPos getGravePos();
}
