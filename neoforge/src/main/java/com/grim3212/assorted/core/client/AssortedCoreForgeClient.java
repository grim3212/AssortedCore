package com.grim3212.assorted.core.client;

import com.grim3212.assorted.core.Constants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = Constants.MOD_ID)
public class AssortedCoreForgeClient {

    @SubscribeEvent
    public static void initClientSide(final FMLConstructModEvent event) {
        CoreClient.init();
    }
}
