package com.grim3212.assorted.core.config;

import com.grim3212.assorted.core.Constants;
import io.github.fablabsmc.fablabs.api.fiber.v1.builder.ConfigTreeBuilder;
import io.github.fablabsmc.fablabs.api.fiber.v1.exception.ValueDeserializationException;
import io.github.fablabsmc.fablabs.api.fiber.v1.schema.type.derived.ConfigTypes;
import io.github.fablabsmc.fablabs.api.fiber.v1.serialization.FiberSerialization;
import io.github.fablabsmc.fablabs.api.fiber.v1.serialization.JanksonValueSerializer;
import io.github.fablabsmc.fablabs.api.fiber.v1.tree.ConfigTree;
import io.github.fablabsmc.fablabs.api.fiber.v1.tree.PropertyMirror;

import java.io.*;
import java.nio.file.*;

public class CoreConfig {

    private static void writeDefaultConfig(ConfigTree config, Path path, JanksonValueSerializer serializer) {
        try (OutputStream s = new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW))) {
            FiberSerialization.serialize(config, s, serializer);
        } catch (FileAlreadyExistsException ignored) {
        } catch (IOException e) {
            Constants.LOG.error("Error writing default config", e);
        }
    }

    private static void setupConfig(ConfigTree config, Path p, JanksonValueSerializer serializer) {
        writeDefaultConfig(config, p, serializer);

        try (InputStream s = new BufferedInputStream(Files.newInputStream(p, StandardOpenOption.READ, StandardOpenOption.CREATE))) {
            FiberSerialization.deserialize(config, s, serializer);
        } catch (IOException | ValueDeserializationException e) {
            Constants.LOG.error("Error loading config from {}", p, e);
        }
    }

    public static void setup() {
        try {
            Files.createDirectory(Paths.get("config"));
        } catch (FileAlreadyExistsException ignored) {
        } catch (IOException e) {
            Constants.LOG.warn("Failed to make config dir", e);
        }

        JanksonValueSerializer serializer = new JanksonValueSerializer(false);
        ConfigTree common = new Common().configure(ConfigTree.builder());
        setupConfig(common, Paths.get("config", Constants.MOD_ID + "-common.json5"), serializer);
    }

    public static final class Common {
        private static PropertyMirror<Boolean> grindingMillBreakSound = PropertyMirror.create(ConfigTypes.BOOLEAN);

        public static ConfigTree configure(ConfigTreeBuilder builder) {
            builder.beginValue("grindingMillBreakSound", ConfigTypes.BOOLEAN, true).finishValue(grindingMillBreakSound::mirror);
            return builder.build();
        }

        public static boolean grindingMillHasBreakSound() {
            return grindingMillBreakSound.getValue();
        }
    }

}
