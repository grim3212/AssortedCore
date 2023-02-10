package com.grim3212.assorted.core.platform;

import com.grim3212.assorted.core.config.CoreConfig;
import com.grim3212.assorted.core.platform.services.IConfigHelper;

public class FabricConfigHelper implements IConfigHelper {
    @Override
    public boolean grindingMillHasBreakSound() {
        return CoreConfig.grindingMillBreakSound;
    }
}
