package com.grim3212.assorted.core.platform;

import com.grim3212.assorted.core.common.handler.CoreConfig;
import com.grim3212.assorted.core.services.IConfigHelper;

public class ForgeConfigHelper implements IConfigHelper {
    @Override
    public boolean grindingMillHasBreakSound() {
        return CoreConfig.COMMON.grindingMillBreakSound.get();
    }
}
