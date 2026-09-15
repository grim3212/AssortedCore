package com.grim3212.assorted.core.client;

import com.grim3212.assorted.core.Constants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

/** A second {@code @Mod} for the same id, constructed only on the client. */
@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class AssortedCoreForgeClient {

    public AssortedCoreForgeClient(IEventBus modBus, ModContainer modContainer) {
        CoreClient.init();
    }
}
