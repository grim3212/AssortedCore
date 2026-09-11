package com.grim3212.assorted.core.gametest;

import net.minecraft.gametest.framework.GameTestHelper;
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
 * <p>
 * The tests themselves are split by feature into the {@code *Tests} classes in this package,
 * with shared helpers in {@code CoreTestSupport}; this only lists them.
 */
public final class CoreGameTests {

    private CoreGameTests() {
    }

    /** Every test in this mod, named once, so both loaders register the same set. */
    public static void forEach(BiConsumer<String, Consumer<GameTestHelper>> out) {
        MachineTests.register(out);
        OreTests.register(out);
        AssetTests.register(out);
    }
}
