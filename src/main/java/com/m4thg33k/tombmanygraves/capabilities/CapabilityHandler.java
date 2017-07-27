package com.m4thg33k.tombmanygraves.capabilities;

import com.m4thg33k.tombmanygraves.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

    public static final ResourceLocation LAST_GRAVE = new ResourceLocation(Names.MODID, Names.LAST_GRAVE_CAP);

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent.Entity event)
    {
        if (!(event.getEntity() instanceof EntityPlayer))
        {
            return;
        }

        event.addCapability(LAST_GRAVE, new LastGravePosProvider());
    }
}
