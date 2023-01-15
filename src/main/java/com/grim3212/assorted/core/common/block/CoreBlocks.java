package com.grim3212.assorted.core.common.block;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoreBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AssortedCore.MODID);
	public static final DeferredRegister<Item> ITEMS = CoreItems.ITEMS;

	public static final RegistryObject<CoreOreBlock> TIN_ORE = register("tin_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> SILVER_ORE = register("silver_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> ALUMINUM_ORE = register("aluminum_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> NICKEL_ORE = register("nickel_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> PLATINUM_ORE = register("platinum_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> LEAD_ORE = register("lead_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> RUBY_ORE = register("ruby_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<CoreOreBlock> PERIDOT_ORE = register("peridot_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
	public static final RegistryObject<CoreOreBlock> SAPPHIRE_ORE = register("sapphire_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<CoreOreBlock> TOPAZ_ORE = register("topaz_ore", () -> new CoreOreBlock(Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

	public static final RegistryObject<CoreOreBlock> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_ALUMINUM_ORE = register("deepslate_aluminum_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_NICKEL_ORE = register("deepslate_nickel_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_PLATINUM_ORE = register("deepslate_platinum_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_PERIDOT_ORE = register("deepslate_peridot_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0F).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<CoreOreBlock> DEEPSLATE_TOPAZ_ORE = register("deepslate_topaz_ore", () -> new CoreOreBlock(Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0F).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

	public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> ALUMINUM_BLOCK = register("aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> NICKEL_BLOCK = register("nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> PLATINUM_BLOCK = register("platinum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> LEAD_BLOCK = register("lead_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RUBY_BLOCK = register("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> PERIDOT_BLOCK = register("peridot_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = register("sapphire_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> TOPAZ_BLOCK = register("topaz_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> RAW_TIN_BLOCK = register("raw_tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_SILVER_BLOCK = register("raw_silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = register("raw_aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_NICKEL_BLOCK = register("raw_nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = register("raw_platinum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> RAW_LEAD_BLOCK = register("raw_lead_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> BRONZE_BLOCK = register("bronze_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> ELECTRUM_BLOCK = register("electrum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> INVAR_BLOCK = register("invar_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> MACHINE_CORE = register("machine_core", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<AlloyForgeBlock> BASIC_ALLOY_FORGE = register("basic_alloy_forge", () -> new AlloyForgeBlock(MachineTier.BASIC, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
	public static final RegistryObject<AlloyForgeBlock> INTERMEDIATE_ALLOY_FORGE = register("intermediate_alloy_forge", () -> new AlloyForgeBlock(MachineTier.INTERMEDIATE, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 8.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
	public static final RegistryObject<AlloyForgeBlock> ADVANCED_ALLOY_FORGE = register("advanced_alloy_forge", () -> new AlloyForgeBlock(MachineTier.ADVANCED, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 9.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
	public static final RegistryObject<AlloyForgeBlock> EXPERT_ALLOY_FORGE = register("expert_alloy_forge", () -> new AlloyForgeBlock(MachineTier.EXPERT, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(6.0F, 10.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
	public static final RegistryObject<GrindingMillBlock> BASIC_GRINDING_MILL = register("basic_grinding_mill", () -> new GrindingMillBlock(MachineTier.BASIC, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<GrindingMillBlock> INTERMEDIATE_GRINDING_MILL = register("intermediate_grinding_mill", () -> new GrindingMillBlock(MachineTier.INTERMEDIATE, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<GrindingMillBlock> ADVANCED_GRINDING_MILL = register("advanced_grinding_mill", () -> new GrindingMillBlock(MachineTier.ADVANCED, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<GrindingMillBlock> EXPERT_GRINDING_MILL = register("expert_grinding_mill", () -> new GrindingMillBlock(MachineTier.EXPERT, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<? extends T> sup) {
		return register(name, sup, block -> item(block));
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<? extends T> sup, Function<RegistryObject<T>, Supplier<? extends Item>> itemCreator) {
		RegistryObject<T> ret = registerNoItem(name, sup);
		ITEMS.register(name, itemCreator.apply(ret));
		return ret;
	}

	private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<? extends T> sup) {
		return BLOCKS.register(name, sup);
	}

	private static Supplier<BlockItem> item(final RegistryObject<? extends Block> block) {
		return () -> new BlockItem(block.get(), new Item.Properties());
	}

	private static ToIntFunction<BlockState> getLightValueOn(int lightValue) {
		return (state) -> {
			return state.getValue(BaseMachineBlock.ON) ? lightValue : 0;
		};
	}
}
