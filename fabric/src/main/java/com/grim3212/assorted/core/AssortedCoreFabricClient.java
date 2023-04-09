package com.grim3212.assorted.core;

import com.grim3212.assorted.core.client.CoreClient;
import net.fabricmc.api.ClientModInitializer;

public class AssortedCoreFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CoreClient.init();
    }
}
