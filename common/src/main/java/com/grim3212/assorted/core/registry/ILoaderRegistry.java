package com.grim3212.assorted.core.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.Optional;
import java.util.stream.Stream;

public interface ILoaderRegistry<T> {
    Stream<T> getValues();

    Optional<T> getValue(ResourceLocation resourceLocation);

    boolean contains(T entry);

    ResourceLocation getRegistryName(T entry);
}
