package com.grim3212.assorted.core.client.proxy;

import com.grim3212.assorted.core.common.crafting.RecipeReloadHandler;
import com.grim3212.assorted.core.common.proxy.IProxy;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy implements IProxy {

	@Override
	public void starting() {
		MinecraftForge.EVENT_BUS.register(new RecipeReloadHandler());
	}
}
