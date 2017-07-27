package com.m4thg33k.tombmanygraves.capabilities;

import net.minecraft.util.math.BlockPos;

public class PlayerLastGravePos implements ILastGravePos {

    private BlockPos lastGravePos = null;

    @Override
    public void setGravePos(BlockPos pos) {
        this.lastGravePos = pos;
    }

    @Override
    public BlockPos getGravePos() {
        return this.lastGravePos;
    }
}
