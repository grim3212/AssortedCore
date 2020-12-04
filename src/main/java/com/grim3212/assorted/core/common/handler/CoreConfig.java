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

		public final ForgeConfigSpec.BooleanValue generateCopper;
		public final ForgeConfigSpec.IntValue veinSizeCopper;
		public final ForgeConfigSpec.IntValue botOffsetCopper;
		public final ForgeConfigSpec.IntValue topOffsetCopper;
		public final ForgeConfigSpec.IntValue maxSpawnLevelCopper;
		public final ForgeConfigSpec.IntValue spawnRateCopper;

		public final ForgeConfigSpec.BooleanValue generateAluminum;
		public final ForgeConfigSpec.IntValue veinSizeAluminum;
		public final ForgeConfigSpec.IntValue botOffsetAluminum;
		public final ForgeConfigSpec.IntValue topOffsetAluminum;
		public final ForgeConfigSpec.IntValue maxSpawnLevelAluminum;
		public final ForgeConfigSpec.IntValue spawnRateAluminum;

		public final ForgeConfigSpec.BooleanValue generateNickel;
		public final ForgeConfigSpec.IntValue veinSizeNickel;
		public final ForgeConfigSpec.IntValue botOffsetNickel;
		public final ForgeConfigSpec.IntValue topOffsetNickel;
		public final ForgeConfigSpec.IntValue maxSpawnLevelNickel;
		public final ForgeConfigSpec.IntValue spawnRateNickel;

		public final ForgeConfigSpec.BooleanValue generateTin;
		public final ForgeConfigSpec.IntValue veinSizeTin;
		public final ForgeConfigSpec.IntValue botOffsetTin;
		public final ForgeConfigSpec.IntValue topOffsetTin;
		public final ForgeConfigSpec.IntValue maxSpawnLevelTin;
		public final ForgeConfigSpec.IntValue spawnRateTin;

		public final ForgeConfigSpec.BooleanValue generateLead;
		public final ForgeConfigSpec.IntValue veinSizeLead;
		public final ForgeConfigSpec.IntValue botOffsetLead;
		public final ForgeConfigSpec.IntValue topOffsetLead;
		public final ForgeConfigSpec.IntValue maxSpawnLevelLead;
		public final ForgeConfigSpec.IntValue spawnRateLead;

		public final ForgeConfigSpec.BooleanValue generateSilver;
		public final ForgeConfigSpec.IntValue veinSizeSilver;
		public final ForgeConfigSpec.IntValue botOffsetSilver;
		public final ForgeConfigSpec.IntValue topOffsetSilver;
		public final ForgeConfigSpec.IntValue maxSpawnLevelSilver;
		public final ForgeConfigSpec.IntValue spawnRateSilver;

		public final ForgeConfigSpec.BooleanValue generatePlatinum;
		public final ForgeConfigSpec.IntValue veinSizePlatinum;
		public final ForgeConfigSpec.IntValue botOffsetPlatinum;
		public final ForgeConfigSpec.IntValue topOffsetPlatinum;
		public final ForgeConfigSpec.IntValue maxSpawnLevelPlatinum;
		public final ForgeConfigSpec.IntValue spawnRatePlatinum;

		public final ForgeConfigSpec.BooleanValue generateRuby;
		public final ForgeConfigSpec.IntValue veinSizeRuby;
		public final ForgeConfigSpec.IntValue botOffsetRuby;
		public final ForgeConfigSpec.IntValue topOffsetRuby;
		public final ForgeConfigSpec.IntValue maxSpawnLevelRuby;
		public final ForgeConfigSpec.IntValue spawnRateRuby;

		public final ForgeConfigSpec.BooleanValue generateSapphire;
		public final ForgeConfigSpec.IntValue veinSizeSapphire;
		public final ForgeConfigSpec.IntValue botOffsetSapphire;
		public final ForgeConfigSpec.IntValue topOffsetSapphire;
		public final ForgeConfigSpec.IntValue maxSpawnLevelSapphire;
		public final ForgeConfigSpec.IntValue spawnRateSapphire;

		public final ForgeConfigSpec.BooleanValue generateTopaz;
		public final ForgeConfigSpec.IntValue veinSizeTopaz;
		public final ForgeConfigSpec.IntValue botOffsetTopaz;
		public final ForgeConfigSpec.IntValue topOffsetTopaz;
		public final ForgeConfigSpec.IntValue maxSpawnLevelTopaz;
		public final ForgeConfigSpec.IntValue spawnRateTopaz;

		public final ForgeConfigSpec.BooleanValue generateAmethyst;
		public final ForgeConfigSpec.IntValue veinSizeAmethyst;
		public final ForgeConfigSpec.IntValue botOffsetAmethyst;
		public final ForgeConfigSpec.IntValue topOffsetAmethyst;
		public final ForgeConfigSpec.IntValue maxSpawnLevelAmethyst;
		public final ForgeConfigSpec.IntValue spawnRateAmethyst;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("Copper");
			builder.push("World Gen");
			generateCopper = builder.comment("Set to true if you would like Copper to generate in your world.").define("generateCopper", true);
			veinSizeCopper = builder.comment("Set to the max vein size you a Copper cluster could generate with.").defineInRange("veinSizeCopper", 12, 0, 64);
			botOffsetCopper = builder.comment("Set to the number of blocks above the world bottom that Copper should try and generate.").defineInRange("botOffsetCopper", 20, 0, 256);
			topOffsetCopper = builder.comment("Set to the number of blocks below the max spawn level that Copper should try and generate.").defineInRange("topOffsetCopper", 0, 0, 256);
			maxSpawnLevelCopper = builder.comment("Set to the max level that Copper could generate in the world.").defineInRange("maxSpawnLevelCopper", 80, 0, 256);
			spawnRateCopper = builder.comment("Set to the number of attempts that Copper will try to generate in a chunk.").defineInRange("spawnRateCopper", 18, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Aluminum");
			builder.push("World Gen");
			generateAluminum = builder.comment("Set to true if you would like Aluminum to generate in your world.").define("generateAluminum", true);
			veinSizeAluminum = builder.comment("Set to the max vein size you a Aluminum cluster could generate with.").defineInRange("veinSizeAluminum", 12, 0, 64);
			botOffsetAluminum = builder.comment("Set to the number of blocks above the world bottom that Aluminum should try and generate.").defineInRange("botOffsetAluminum", 16, 0, 256);
			topOffsetAluminum = builder.comment("Set to the number of blocks below the max spawn level that Aluminum should try and generate.").defineInRange("topOffsetAluminum", 0, 0, 256);
			maxSpawnLevelAluminum = builder.comment("Set to the max level that Aluminum could generate in the world.").defineInRange("maxSpawnLevelAluminum", 80, 0, 256);
			spawnRateAluminum = builder.comment("Set to the number of attempts that Aluminum will try to generate in a chunk.").defineInRange("spawnRateAluminum", 20, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Nickel");
			builder.push("World Gen");
			generateNickel = builder.comment("Set to true if you would like Nickel to generate in your world.").define("generateNickel", true);
			veinSizeNickel = builder.comment("Set to the max vein size you a Nickel cluster could generate with.").defineInRange("veinSizeNickel", 9, 0, 64);
			botOffsetNickel = builder.comment("Set to the number of blocks above the world bottom that Nickel should try and generate.").defineInRange("botOffsetNickel", 6, 0, 256);
			topOffsetNickel = builder.comment("Set to the number of blocks below the max spawn level that Nickel should try and generate.").defineInRange("topOffsetNickel", 0, 0, 256);
			maxSpawnLevelNickel = builder.comment("Set to the max level that Nickel could generate in the world.").defineInRange("maxSpawnLevelNickel", 40, 0, 256);
			spawnRateNickel = builder.comment("Set to the number of attempts that Nickel will try to generate in a chunk.").defineInRange("spawnRateNickel", 14, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Tin");
			builder.push("World Gen");
			generateTin = builder.comment("Set to true if you would like Tin to generate in your world.").define("generateTin", true);
			veinSizeTin = builder.comment("Set to the max vein size you a Tin cluster could generate with.").defineInRange("veinSizeTin", 9, 0, 64);
			botOffsetTin = builder.comment("Set to the number of blocks above the world bottom that Tin should try and generate.").defineInRange("botOffsetTin", 20, 0, 256);
			topOffsetTin = builder.comment("Set to the number of blocks below the max spawn level that Tin should try and generate.").defineInRange("topOffsetTin", 0, 0, 256);
			maxSpawnLevelTin = builder.comment("Set to the max level that Tin could generate in the world.").defineInRange("maxSpawnLevelTin", 64, 0, 256);
			spawnRateTin = builder.comment("Set to the number of attempts that Tin will try to generate in a chunk.").defineInRange("spawnRateTin", 16, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Lead");
			builder.push("World Gen");
			generateLead = builder.comment("Set to true if you would like Lead to generate in your world.").define("generateLead", true);
			veinSizeLead = builder.comment("Set to the max vein size you a Lead cluster could generate with.").defineInRange("veinSizeLead", 8, 0, 64);
			botOffsetLead = builder.comment("Set to the number of blocks above the world bottom that Lead should try and generate.").defineInRange("botOffsetLead", 0, 0, 256);
			topOffsetLead = builder.comment("Set to the number of blocks below the max spawn level that Lead should try and generate.").defineInRange("topOffsetLead", 0, 0, 256);
			maxSpawnLevelLead = builder.comment("Set to the max level that Lead could generate in the world.").defineInRange("maxSpawnLevelLead", 32, 0, 256);
			spawnRateLead = builder.comment("Set to the number of attempts that Lead will try to generate in a chunk.").defineInRange("spawnRateLead", 14, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Silver");
			builder.push("World Gen");
			generateSilver = builder.comment("Set to true if you would like Silver to generate in your world.").define("generateSilver", true);
			veinSizeSilver = builder.comment("Set to the max vein size you a Silver cluster could generate with.").defineInRange("veinSizeSilver", 8, 0, 64);
			botOffsetSilver = builder.comment("Set to the number of blocks above the world bottom that Silver should try and generate.").defineInRange("botOffsetSilver", 0, 0, 256);
			topOffsetSilver = builder.comment("Set to the number of blocks below the max spawn level that Silver should try and generate.").defineInRange("topOffsetSilver", 0, 0, 256);
			maxSpawnLevelSilver = builder.comment("Set to the max level that Silver could generate in the world.").defineInRange("maxSpawnLevelSilver", 24, 0, 256);
			spawnRateSilver = builder.comment("Set to the number of attempts that Silver will try to generate in a chunk.").defineInRange("spawnRateSilver", 8, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Platinum");
			builder.push("World Gen");
			generatePlatinum = builder.comment("Set to true if you would like Platinum to generate in your world.").define("generatePlatinum", true);
			veinSizePlatinum = builder.comment("Set to the max vein size you a Platinum cluster could generate with.").defineInRange("veinSizePlatinum", 7, 0, 64);
			botOffsetPlatinum = builder.comment("Set to the number of blocks above the world bottom that Platinum should try and generate.").defineInRange("botOffsetPlatinum", 0, 0, 256);
			topOffsetPlatinum = builder.comment("Set to the number of blocks below the max spawn level that Platinum should try and generate.").defineInRange("topOffsetPlatinum", 0, 0, 256);
			maxSpawnLevelPlatinum = builder.comment("Set to the max level that Platinum could generate in the world.").defineInRange("maxSpawnLevelPlatinum", 16, 0, 256);
			spawnRatePlatinum = builder.comment("Set to the number of attempts that Platinum will try to generate in a chunk.").defineInRange("spawnRatePlatinum", 4, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Ruby");
			builder.push("World Gen");
			generateRuby = builder.comment("Set to true if you would like Ruby to generate in your world.").define("generateRuby", true);
			veinSizeRuby = builder.comment("Set to the max vein size you a Ruby cluster could generate with.").defineInRange("veinSizeRuby", 8, 0, 64);
			botOffsetRuby = builder.comment("Set to the number of blocks above the world bottom that Ruby should try and generate.").defineInRange("botOffsetRuby", 0, 0, 256);
			topOffsetRuby = builder.comment("Set to the number of blocks below the max spawn level that Ruby should try and generate.").defineInRange("topOffsetRuby", 0, 0, 256);
			maxSpawnLevelRuby = builder.comment("Set to the max level that Ruby could generate in the world.").defineInRange("maxSpawnLevelRuby", 16, 0, 256);
			spawnRateRuby = builder.comment("Set to the number of attempts that Ruby will try to generate in a chunk.").defineInRange("spawnRateRuby", 6, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Sapphire");
			builder.push("World Gen");
			generateSapphire = builder.comment("Set to true if you would like Sapphire to generate in your world.").define("generateSapphire", true);
			veinSizeSapphire = builder.comment("Set to the max vein size you a Sapphire cluster could generate with.").defineInRange("veinSizeSapphire", 8, 0, 64);
			botOffsetSapphire = builder.comment("Set to the number of blocks above the world bottom that Sapphire should try and generate.").defineInRange("botOffsetSapphire", 12, 0, 256);
			topOffsetSapphire = builder.comment("Set to the number of blocks below the max spawn level that Sapphire should try and generate.").defineInRange("topOffsetSapphire", 0, 0, 256);
			maxSpawnLevelSapphire = builder.comment("Set to the max level that Sapphire could generate in the world.").defineInRange("maxSpawnLevelSapphire", 40, 0, 256);
			spawnRateSapphire = builder.comment("Set to the number of attempts that Sapphire will try to generate in a chunk.").defineInRange("spawnRateSapphire", 8, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Topaz");
			builder.push("World Gen");
			generateTopaz = builder.comment("Set to true if you would like Topaz to generate in your world.").define("generateTopaz", true);
			veinSizeTopaz = builder.comment("Set to the max vein size you a Topaz cluster could generate with.").defineInRange("veinSizeTopaz", 8, 0, 64);
			botOffsetTopaz = builder.comment("Set to the number of blocks above the world bottom that Topaz should try and generate.").defineInRange("botOffsetTopaz", 32, 0, 256);
			topOffsetTopaz = builder.comment("Set to the number of blocks below the max spawn level that Topaz should try and generate.").defineInRange("topOffsetTopaz", 0, 0, 256);
			maxSpawnLevelTopaz = builder.comment("Set to the max level that Topaz could generate in the world.").defineInRange("maxSpawnLevelTopaz", 52, 0, 256);
			spawnRateTopaz = builder.comment("Set to the number of attempts that Topaz will try to generate in a chunk.").defineInRange("spawnRateTopaz", 8, 0, 64);
			builder.pop();
			builder.pop();

			builder.push("Amethyst");
			builder.push("World Gen");
			generateAmethyst = builder.comment("Set to true if you would like Amethyst to generate in your world.").define("generateAmethyst", true);
			veinSizeAmethyst = builder.comment("Set to the max vein size you a Amethyst cluster could generate with.").defineInRange("veinSizeAmethyst", 8, 0, 64);
			botOffsetAmethyst = builder.comment("Set to the number of blocks above the world bottom that Amethyst should try and generate.").defineInRange("botOffsetAmethyst", 48, 0, 256);
			topOffsetAmethyst = builder.comment("Set to the number of blocks below the max spawn level that Amethyst should try and generate.").defineInRange("topOffsetAmethyst", 0, 0, 256);
			maxSpawnLevelAmethyst = builder.comment("Set to the max level that Amethyst could generate in the world.").defineInRange("maxSpawnLevelAmethyst", 68, 0, 256);
			spawnRateAmethyst = builder.comment("Set to the number of attempts that Amethyst will try to generate in a chunk.").defineInRange("spawnRateAmethyst", 10, 0, 64);
			builder.pop();
			builder.pop();
		}
	}
}
