package com.grim3212.assorted.core.common.block;

import java.util.function.Function;
import java.util.function.Supplier;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.item.CoreItems;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CoreBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AssortedCore.MODID);
	public static final DeferredRegister<Item> ITEMS = CoreItems.ITEMS;

	public static final RegistryObject<CoreOreBlock> TIN_ORE = register("tin_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> COPPER_ORE = register("copper_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> SILVER_ORE = register("silver_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> ALUMINUM_ORE = register("aluminum_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> NICKEL_ORE = register("nickel_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> PLATINUM_ORE = register("platinum_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> LEAD_ORE = register("lead_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> RUBY_ORE = register("ruby_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> AMETHYST_ORE = register("amethyst_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> SAPPHIRE_ORE = register("sapphire_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<CoreOreBlock> TOPAZ_ORE = register("topaz_ore", () -> new CoreOreBlock(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));

	public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> ALUMINUM_BLOCK = register("aluminum_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<Block> NICKEL_BLOCK = register("nickel_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> PLATINUM_BLOCK = register("platinum_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool()));
	public static final RegistryObject<Block> LEAD_BLOCK = register("lead_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> RUBY_BLOCK = register("ruby_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.RED).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> AMETHYST_BLOCK = register("amethyst_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.PURPLE).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> SAPPHIRE_BLOCK = register("sapphire_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> TOPAZ_BLOCK = register("topaz_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.YELLOW).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));

	public static final RegistryObject<Block> BRONZE_BLOCK = register("bronze_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> ELECTRUM_BLOCK = register("electrum_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> INVAR_BLOCK = register("invar_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));
	public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()));

	public static final RegistryObject<Block> BASIC_MACHINE_CORE = register("basic_machine_core", () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<AlloyForgeBlock> BASIC_ALLOY_FORGE = register("basic_alloy_forge", () -> new AlloyForgeBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));
	public static final RegistryObject<GrindingMillBlock> BASIC_GRINDING_MILL = register("basic_grinding_mill", () -> new GrindingMillBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.0F, 6.0F).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()));

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
		return () -> new BlockItem(block.get(), new Item.Properties().group(AssortedCore.ASSORTED_CORE_ITEM_GROUP));
	}
}
