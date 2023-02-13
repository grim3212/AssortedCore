package com.grim3212.assorted.core.client.screen;

import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.lib.platform.Services;

public class CoreScreens {
    public static void init() {
        Services.PLATFORM.registerScreen(CoreContainerTypes.ALLOY_FORGE.get(), AlloyForgeScreen::new);
        Services.PLATFORM.registerScreen(CoreContainerTypes.GRINDING_MILL.get(), GrindingMillScreen::new);
    }
}
