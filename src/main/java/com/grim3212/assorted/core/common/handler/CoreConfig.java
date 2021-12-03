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

		public final ForgeConfigSpec.IntValue veinSizeAluminum;
		public final ForgeConfigSpec.IntValue botOffsetAluminum;
		public final ForgeConfigSpec.IntValue maxSpawnLevelAluminum;
		public final ForgeConfigSpec.IntValue spawnRateAluminum;

		public final ForgeConfigSpec.IntValue veinSizeNickel;
		public final ForgeConfigSpec.IntValue botOffsetNickel;
		public final ForgeConfigSpec.IntValue maxSpawnLevelNickel;
		public final ForgeConfigSpec.IntValue spawnRateNickel;

		public final ForgeConfigSpec.IntValue veinSizeTin;
		public final ForgeConfigSpec.IntValue botOffsetTin;
		public final ForgeConfigSpec.IntValue maxSpawnLevelTin;
		public final ForgeConfigSpec.IntValue spawnRateTin;

		public final ForgeConfigSpec.IntValue veinSizeLead;
		public final ForgeConfigSpec.IntValue botOffsetLead;
		public final ForgeConfigSpec.IntValue maxSpawnLevelLead;
		public final ForgeConfigSpec.IntValue spawnRateLead;

		public final ForgeConfigSpec.IntValue veinSizeSilver;
		public final ForgeConfigSpec.IntValue botOffsetSilver;
		public final ForgeConfigSpec.IntValue maxSpawnLevelSilver;
		public final ForgeConfigSpec.IntValue spawnRateSilver;

		public final ForgeConfigSpec.IntValue veinSizePlatinum;
		public final ForgeConfigSpec.IntValue botOffsetPlatinum;
		public final ForgeConfigSpec.IntValue maxSpawnLevelPlatinum;
		public final ForgeConfigSpec.IntValue spawnRatePlatinum;

		public final ForgeConfigSpec.IntValue veinSizeRuby;
		public final ForgeConfigSpec.IntValue botOffsetRuby;
		public final ForgeConfigSpec.IntValue maxSpawnLevelRuby;
		public final ForgeConfigSpec.IntValue spawnRateRuby;

		public final ForgeConfigSpec.IntValue veinSizeSapphire;
		public final ForgeConfigSpec.IntValue botOffsetSapphire;
		public final ForgeConfigSpec.IntValue maxSpawnLevelSapphire;
		public final ForgeConfigSpec.IntValue spawnRateSapphire;

		public final ForgeConfigSpec.IntValue veinSizeTopaz;
		public final ForgeConfigSpec.IntValue botOffsetTopaz;
		public final ForgeConfigSpec.IntValue maxSpawnLevelTopaz;
		public final ForgeConfigSpec.IntValue spawnRateTopaz;

		public final ForgeConfigSpec.IntValue veinSizePeridot;
		public final ForgeConfigSpec.IntValue botOffsetPeridot;
		public final ForgeConfigSpec.IntValue maxSpawnLevelPeridot;
		public final ForgeConfigSpec.IntValue spawnRatePeridot;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("Machines");
			grindingMillBreakSound = builder.comment("Set to true if you want the grinding mill to play the break sound when a block is broken.").define("grindingMillBreakSound", true);
			builder.pop();

			builder.push("Materials");

			builder.push("Aluminum");
			builder.push("World Gen");
			veinSizeAluminum = builder.comment("Set to the max vein size you a Aluminum cluster could generate with.").defineInRange("veinSizeAluminum", 12, 0, 64);
			botOffsetAluminum = builder.comment("Set to the number of blocks above the world bottom that Aluminum should try and generate.").defineInRange("botOffsetAluminum", 16, -64, 320);
			maxSpawnLevelAluminum = builder.comment("Set to the max level that Aluminum could generate in the world.").defineInRange("maxSpawnLevelAluminum", 125, -64, 320);
			spawnRateAluminum = builder.comment("Set to the number of attempts that Aluminum will try to generate in a chunk.").defineInRange("spawnRateAluminum", 20, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Nickel");
			builder.push("World Gen");
			veinSizeNickel = builder.comment("Set to the max vein size you a Nickel cluster could generate with.").defineInRange("veinSizeNickel", 9, 0, 64);
			botOffsetNickel = builder.comment("Set to the number of blocks above the world bottom that Nickel should try and generate.").defineInRange("botOffsetNickel", -40, -64, 320);
			maxSpawnLevelNickel = builder.comment("Set to the max level that Nickel could generate in the world.").defineInRange("maxSpawnLevelNickel", 40, -64, 320);
			spawnRateNickel = builder.comment("Set to the number of attempts that Nickel will try to generate in a chunk.").defineInRange("spawnRateNickel", 14, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Tin");
			builder.push("World Gen");
			veinSizeTin = builder.comment("Set to the max vein size you a Tin cluster could generate with.").defineInRange("veinSizeTin", 9, 0, 64);
			botOffsetTin = builder.comment("Set to the number of blocks above the world bottom that Tin should try and generate.").defineInRange("botOffsetTin", 20, -64, 320);
			maxSpawnLevelTin = builder.comment("Set to the max level that Tin could generate in the world.").defineInRange("maxSpawnLevelTin", 256, -64, 320);
			spawnRateTin = builder.comment("Set to the number of attempts that Tin will try to generate in a chunk.").defineInRange("spawnRateTin", 16, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Lead");
			builder.push("World Gen");
			veinSizeLead = builder.comment("Set to the max vein size you a Lead cluster could generate with.").defineInRange("veinSizeLead", 8, 0, 64);
			botOffsetLead = builder.comment("Set to the number of blocks above the world bottom that Lead should try and generate.").defineInRange("botOffsetLead", -32, -64, 320);
			maxSpawnLevelLead = builder.comment("Set to the max level that Lead could generate in the world.").defineInRange("maxSpawnLevelLead", 32, -64, 320);
			spawnRateLead = builder.comment("Set to the number of attempts that Lead will try to generate in a chunk.").defineInRange("spawnRateLead", 14, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Silver");
			builder.push("World Gen");
			veinSizeSilver = builder.comment("Set to the max vein size you a Silver cluster could generate with.").defineInRange("veinSizeSilver", 8, 0, 64);
			botOffsetSilver = builder.comment("Set to the number of blocks above the world bottom that Silver should try and generate.").defineInRange("botOffsetSilver", -64, -64, 320);
			maxSpawnLevelSilver = builder.comment("Set to the max level that Silver could generate in the world.").defineInRange("maxSpawnLevelSilver", 12, -64, 320);
			spawnRateSilver = builder.comment("Set to the number of attempts that Silver will try to generate in a chunk.").defineInRange("spawnRateSilver", 8, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Platinum");
			builder.push("World Gen");
			veinSizePlatinum = builder.comment("Set to the max vein size you a Platinum cluster could generate with.").defineInRange("veinSizePlatinum", 7, 0, 64);
			botOffsetPlatinum = builder.comment("Set to the number of blocks above the world bottom that Platinum should try and generate.").defineInRange("botOffsetPlatinum", -64, -64, 320);
			maxSpawnLevelPlatinum = builder.comment("Set to the max level that Platinum could generate in the world.").defineInRange("maxSpawnLevelPlatinum", -16, -64, 320);
			spawnRatePlatinum = builder.comment("Set to the number of attempts that Platinum will try to generate in a chunk.").defineInRange("spawnRatePlatinum", 4, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Ruby");
			builder.push("World Gen");
			veinSizeRuby = builder.comment("Set to the max vein size you a Ruby cluster could generate with.").defineInRange("veinSizeRuby", 8, 0, 64);
			botOffsetRuby = builder.comment("Set to the number of blocks above the world bottom that Ruby should try and generate.").defineInRange("botOffsetRuby", -64, -64, 320);
			maxSpawnLevelRuby = builder.comment("Set to the max level that Ruby could generate in the world.").defineInRange("maxSpawnLevelRuby", 0, -64, 320);
			spawnRateRuby = builder.comment("Set to the number of attempts that Ruby will try to generate in a chunk.").defineInRange("spawnRateRuby", 4, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Sapphire");
			builder.push("World Gen");
			veinSizeSapphire = builder.comment("Set to the max vein size you a Sapphire cluster could generate with.").defineInRange("veinSizeSapphire", 8, 0, 64);
			botOffsetSapphire = builder.comment("Set to the number of blocks above the world bottom that Sapphire should try and generate.").defineInRange("botOffsetSapphire", -12, -64, 320);
			maxSpawnLevelSapphire = builder.comment("Set to the max level that Sapphire could generate in the world.").defineInRange("maxSpawnLevelSapphire", 50, -64, 320);
			spawnRateSapphire = builder.comment("Set to the number of attempts that Sapphire will try to generate in a chunk.").defineInRange("spawnRateSapphire", 6, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Topaz");
			builder.push("World Gen");
			veinSizeTopaz = builder.comment("Set to the max vein size you a Topaz cluster could generate with.").defineInRange("veinSizeTopaz", 8, 0, 64);
			botOffsetTopaz = builder.comment("Set to the number of blocks above the world bottom that Topaz should try and generate.").defineInRange("botOffsetTopaz", 0, -64, 320);
			maxSpawnLevelTopaz = builder.comment("Set to the max level that Topaz could generate in the world.").defineInRange("maxSpawnLevelTopaz", 128, -64, 320);
			spawnRateTopaz = builder.comment("Set to the number of attempts that Topaz will try to generate in a chunk.").defineInRange("spawnRateTopaz", 6, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Peridot");
			builder.push("World Gen");
			veinSizePeridot = builder.comment("Set to the max vein size you a Peridot cluster could generate with.").defineInRange("veinSizePeridot", 8, 0, 64);
			botOffsetPeridot = builder.comment("Set to the number of blocks above the world bottom that Peridot should try and generate.").defineInRange("botOffsetPeridot", 48, -64, 320);
			maxSpawnLevelPeridot = builder.comment("Set to the max level that Peridot could generate in the world.").defineInRange("maxSpawnLevelPeridot", 256, -64, 320);
			spawnRatePeridot = builder.comment("Set to the number of attempts that Peridot will try to generate in a chunk.").defineInRange("spawnRatePeridot", 6, 0, 64);
			builder.pop();
			builder.pop();
			builder.pop();
		}
	}
}
