package com.grim3212.assorted.core.gametest;

import com.grim3212.assorted.core.Constants;
import com.grim3212.assorted.core.api.machines.MachineUtil;
import com.grim3212.assorted.core.common.blocks.CoreBlocks;
import com.grim3212.assorted.core.common.blocks.blockentity.AlloyForgeBlockEntity;
import com.grim3212.assorted.core.common.blocks.blockentity.BaseMachineBlockEntity;
import com.grim3212.assorted.core.common.blocks.blockentity.GrindingMillBlockEntity;
import com.grim3212.assorted.core.common.items.CoreItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.HopperBlockEntity;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Automated in-world checks for AssortedCore.
 * <p>
 * The bodies live in common because the behaviour they check is common; each loader module only
 * registers them into {@code Registries.TEST_FUNCTION} through its own hook, and
 * {@code data/assortedcore/test_instance/*.json} pairs each one with the shared {@code test_box}
 * structure. Every test that runs the game forward uses the EXPERT tier - its 0.25 speed modifier
 * keeps a smelt inside a sane {@code max_ticks}.
 * <p>
 * Manual checks that need a human are in {@code TESTING-CHECKLIST.md}.
 */
public final class CoreGameTests {

    private CoreGameTests() {
    }

    /** Every test in this mod, named once, so both loaders register the same set. */
    public static void forEach(BiConsumer<String, Consumer<GameTestHelper>> out) {
        out.accept("alloy_forge_makes_bronze", CoreGameTests::alloyForgeMakesBronze);
        out.accept("grinding_mill_makes_dust", CoreGameTests::grindingMillMakesDust);
        out.accept("grinding_mill_tool_slot", CoreGameTests::grindingMillToolSlot);
        out.accept("machine_drops_contents", CoreGameTests::machineDropsContents);
        out.accept("hoppers_feed_and_empty_machine", CoreGameTests::hoppersFeedAndEmptyMachine);
    }

    private static final BlockPos MACHINE = new BlockPos(4, 1, 4);

    /** 3 copper dust + 1 tin dust -> 4 bronze ingots. */
    private static void alloyForgeMakesBronze(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.EXPERT_ALLOY_FORGE.get());
        AlloyForgeBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);

        // Through the inventory handler, not getItems(): only the handler sets cookTimeTotal.
        forge.getInventory(null).setStackInSlot(0, new ItemStack(CoreItems.COPPER_DUST.get(), 3));
        forge.getInventory(null).setStackInSlot(1, new ItemStack(CoreItems.TIN_DUST.get(), 1));
        forge.getInventory(null).setStackInSlot(2, new ItemStack(Items.COAL, 8));

        helper.succeedWhen(() -> {
            ItemStack result = forge.getInventory(null).getStackInSlot(3);
            helper.assertTrue(result.is(CoreItems.BRONZE_INGOT.get()), "alloy forge did not produce bronze");
            helper.assertValueEqual(result.getCount(), 4, "bronze ingot count");
        });
    }

    /** A copper ingot plus a pickaxe in the tool slot grinds to copper dust. */
    private static void grindingMillMakesDust(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.EXPERT_GRINDING_MILL.get());
        GrindingMillBlockEntity mill = helper.getBlockEntity(MACHINE, GrindingMillBlockEntity.class);

        mill.getInventory(null).setStackInSlot(0, new ItemStack(Items.COPPER_INGOT, 1));
        mill.getInventory(null).setStackInSlot(1, new ItemStack(Items.IRON_PICKAXE));
        mill.getInventory(null).setStackInSlot(2, new ItemStack(Items.COAL, 8));

        helper.succeedWhen(() -> helper.assertTrue(
                mill.getInventory(null).getStackInSlot(3).is(CoreItems.COPPER_DUST.get()),
                "grinding mill did not produce copper dust"));
    }

    /** The tool slot takes iron and above, and nothing softer. */
    private static void grindingMillToolSlot(GameTestHelper helper) {
        helper.assertTrue(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.IRON_PICKAXE)),
                "iron pickaxe rejected by the grinding mill tool slot");
        helper.assertTrue(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.NETHERITE_PICKAXE)),
                "netherite pickaxe rejected by the grinding mill tool slot");
        helper.assertFalse(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.WOODEN_PICKAXE)),
                "wooden pickaxe accepted by the grinding mill tool slot");
        helper.assertFalse(MachineUtil.allowedInGrindingMillToolSlot(new ItemStack(Items.IRON_SWORD)),
                "iron sword accepted by the grinding mill tool slot");
        helper.succeed();
    }

    /** Breaking a machine spills what was inside it - this regressed once already. */
    private static void machineDropsContents(GameTestHelper helper) {
        helper.setBlock(MACHINE, CoreBlocks.BASIC_ALLOY_FORGE.get());
        BaseMachineBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);
        forge.getInventory(null).setStackInSlot(0, new ItemStack(CoreItems.COPPER_DUST.get(), 2));

        helper.destroyBlock(MACHINE);
        helper.succeedWhen(() -> helper.assertItemEntityPresent(CoreItems.COPPER_DUST.get(), MACHINE, 3.0D));
    }

    /**
     * A hopper above pushes an ingredient in, a hopper below pulls the result out. This is the
     * sided inventory bridge - {@code ResourceHandler} on NeoForge, the transfer API on Fabric -
     * and it is the part of the port most likely to differ between the two.
     * <p>
     * Insertion goes to the first slot that accepts the stack, which for every face but DOWN is
     * input 1; only DOWN exposes the output slot, so the hopper below can take the result and
     * nothing else.
     */
    private static void hoppersFeedAndEmptyMachine(GameTestHelper helper) {
        BlockPos above = MACHINE.above();
        BlockPos below = MACHINE.below();

        helper.setBlock(MACHINE, CoreBlocks.BASIC_ALLOY_FORGE.get());
        helper.setBlock(above, Blocks.HOPPER.defaultBlockState().setValue(HopperBlock.FACING, Direction.DOWN));
        helper.setBlock(below, Blocks.HOPPER.defaultBlockState().setValue(HopperBlock.FACING, Direction.DOWN));

        helper.getBlockEntity(above, HopperBlockEntity.class)
                .setItem(0, new ItemStack(CoreItems.COPPER_DUST.get(), 1));

        BaseMachineBlockEntity forge = helper.getBlockEntity(MACHINE, AlloyForgeBlockEntity.class);
        forge.getInventory(null).setStackInSlot(3, new ItemStack(CoreItems.BRONZE_INGOT.get(), 1));

        helper.succeedWhen(() -> {
            helper.assertTrue(forge.getInventory(null).getStackInSlot(0).is(CoreItems.COPPER_DUST.get()),
                    "hopper above did not insert into the machine");
            helper.assertContainerContains(below, CoreItems.BRONZE_INGOT.get());
        });
    }
}
