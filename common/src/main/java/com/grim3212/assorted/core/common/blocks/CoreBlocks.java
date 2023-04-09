package com.grim3212.assorted.core.common.blocks;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.items.CoreItems;
import com.grim3212.assorted.lib.registry.IRegistryObject;
import com.grim3212.assorted.lib.registry.RegistryProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class CoreBlocks {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.create(Registries.BLOCK, Constants.MOD_ID);
    public static final RegistryProvider<Item> ITEMS = RegistryProvider.create(Registries.ITEM, Constants.MOD_ID);

    public static final IRegistryObject<CoreOreBlock> TIN_ORE = register("tin_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> SILVER_ORE = register("silver_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> ALUMINUM_ORE = register("aluminum_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> NICKEL_ORE = register("nickel_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> PLATINUM_ORE = register("platinum_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> LEAD_ORE = register("lead_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> RUBY_ORE = register("ruby_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final IRegistryObject<CoreOreBlock> PERIDOT_ORE = register("peridot_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final IRegistryObject<CoreOreBlock> SAPPHIRE_ORE = register("sapphire_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final IRegistryObject<CoreOreBlock> TOPAZ_ORE = register("topaz_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_ALUMINUM_ORE = register("deepslate_aluminum_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_NICKEL_ORE = register("deepslate_nickel_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_PLATINUM_ORE = register("deepslate_platinum_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops()));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_PERIDOT_ORE = register("deepslate_peridot_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0F).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final IRegistryObject<CoreOreBlock> DEEPSLATE_TOPAZ_ORE = register("deepslate_topaz_ore", () -> new CoreOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.STONE).strength(4.5F, 3.0F).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));

    public static final IRegistryObject<Block> TIN_BLOCK = register("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> SILVER_BLOCK = register("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> ALUMINUM_BLOCK = register("aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> NICKEL_BLOCK = register("nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> PLATINUM_BLOCK = register("platinum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> LEAD_BLOCK = register("lead_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> RUBY_BLOCK = register("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> PERIDOT_BLOCK = register("peridot_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> SAPPHIRE_BLOCK = register("sapphire_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> TOPAZ_BLOCK = register("topaz_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

    public static final IRegistryObject<Block> RAW_TIN_BLOCK = register("raw_tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> RAW_SILVER_BLOCK = register("raw_silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> RAW_ALUMINUM_BLOCK = register("raw_aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> RAW_NICKEL_BLOCK = register("raw_nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> RAW_PLATINUM_BLOCK = register("raw_platinum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> RAW_LEAD_BLOCK = register("raw_lead_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

    public static final IRegistryObject<Block> BRONZE_BLOCK = register("bronze_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> ELECTRUM_BLOCK = register("electrum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> INVAR_BLOCK = register("invar_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<Block> STEEL_BLOCK = register("steel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

    public static final IRegistryObject<Block> MACHINE_CORE = register("machine_core", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<AlloyForgeBlock> BASIC_ALLOY_FORGE = register("basic_alloy_forge", () -> new AlloyForgeBlock(MachineTier.BASIC, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
    public static final IRegistryObject<AlloyForgeBlock> INTERMEDIATE_ALLOY_FORGE = register("intermediate_alloy_forge", () -> new AlloyForgeBlock(MachineTier.INTERMEDIATE, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 8.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
    public static final IRegistryObject<AlloyForgeBlock> ADVANCED_ALLOY_FORGE = register("advanced_alloy_forge", () -> new AlloyForgeBlock(MachineTier.ADVANCED, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(5.0F, 9.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
    public static final IRegistryObject<AlloyForgeBlock> EXPERT_ALLOY_FORGE = register("expert_alloy_forge", () -> new AlloyForgeBlock(MachineTier.EXPERT, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(6.0F, 10.0F).requiresCorrectToolForDrops().lightLevel(getLightValueOn(13))));
    public static final IRegistryObject<GrindingMillBlock> BASIC_GRINDING_MILL = register("basic_grinding_mill", () -> new GrindingMillBlock(MachineTier.BASIC, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<GrindingMillBlock> INTERMEDIATE_GRINDING_MILL = register("intermediate_grinding_mill", () -> new GrindingMillBlock(MachineTier.INTERMEDIATE, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<GrindingMillBlock> ADVANCED_GRINDING_MILL = register("advanced_grinding_mill", () -> new GrindingMillBlock(MachineTier.ADVANCED, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final IRegistryObject<GrindingMillBlock> EXPERT_GRINDING_MILL = register("expert_grinding_mill", () -> new GrindingMillBlock(MachineTier.EXPERT, BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4.0F, 6.0F).requiresCorrectToolForDrops()));

    private static <T extends Block> IRegistryObject<T> register(String name, Supplier<? extends T> sup) {
        return register(name, sup, block -> item(block));
    }

    private static <T extends Block> IRegistryObject<T> register(String name, Supplier<? extends T> sup, Function<IRegistryObject<T>, Supplier<? extends Item>> itemCreator) {
        IRegistryObject<T> ret = registerNoItem(name, sup);
        ITEMS.register(name, itemCreator.apply(ret));
        return ret;
    }

    private static <T extends Block> IRegistryObject<T> registerNoItem(String name, Supplier<? extends T> sup) {
        return BLOCKS.register(name, sup);
    }

    private static Supplier<BlockItem> item(final IRegistryObject<? extends Block> block) {
        return () -> new BlockItem(block.get(), new Item.Properties());
    }

    private static ToIntFunction<BlockState> getLightValueOn(int lightValue) {
        return (state) -> {
            return state.getValue(BaseMachineBlock.ON) ? lightValue : 0;
        };
    }

    public static void init() {
    }
}
