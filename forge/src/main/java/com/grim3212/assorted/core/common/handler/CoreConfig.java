package com.grim3212.assorted.core.common.handler;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public final class CoreConfig {

	public static final Common COMMON;
	public static final ForgeConfigSpec COMMON_SPEC;
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static class Common {

		public final ForgeConfigSpec.BooleanValue grindingMillBreakSound;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("Machines");
			grindingMillBreakSound = builder.comment("Set to true if you want the grinding mill to play the break sound when a block is broken.").define("grindingMillBreakSound", true);
			builder.pop();
		}
	}
}
