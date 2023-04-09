package com.grim3212.assorted.core.client;

import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.lib.platform.ClientServices;
import com.grim3212.assorted.lib.platform.Services;

public class CoreClient {
    public static void init() {
        ClientServices.CLIENT.registerScreen(CoreContainerTypes.ALLOY_FORGE::get, AlloyForgeScreen::new);
        ClientServices.CLIENT.registerScreen(CoreContainerTypes.GRINDING_MILL::get, GrindingMillScreen::new);
    }
}
