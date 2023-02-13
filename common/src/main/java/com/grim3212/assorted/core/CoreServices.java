package com.grim3212.assorted.core;

import com.grim3212.assorted.core.services.IConfigHelper;
import com.grim3212.assorted.core.services.IMachineHelper;
import com.grim3212.assorted.lib.platform.Services;

public class CoreServices {

    public static final IMachineHelper MACHINES = Services.load(IMachineHelper.class);
    public static final IConfigHelper CONFIG = Services.load(IConfigHelper.class);
}
