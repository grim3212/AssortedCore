package com.grim3212.assorted.core;

import com.grim3212.assorted.lib.data.FabricConditionalRecipeProvider;
import com.grim3212.assorted.core.data.*;
import com.grim3212.assorted.lib.data.FabricBlockTagProvider;
import com.grim3212.assorted.lib.data.FabricItemTagProvider;
import com.grim3212.assorted.lib.data.FabricDatapackRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;

public class AssortedCoreFabricDatagen implements DataGeneratorEntrypoint {


    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((output, registriesFuture) -> new FabricConditionalRecipeProvider(output, registriesFuture, new CoreRecipes.Runner(output, registriesFuture)));
        FabricBlockTagProvider provider = pack.addProvider((output, registriesFuture) -> new FabricBlockTagProvider(output, registriesFuture, new CoreBlockTagProvider(output, registriesFuture)));
        pack.addProvider((output, registriesFuture) -> new FabricItemTagProvider(output, registriesFuture, provider.contentsGetter(), new CoreItemTagProvider(output, registriesFuture, provider.contentsGetter())));
        pack.addProvider((output, registriesFuture) -> new LootTableProvider(output, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(CoreBlockLoot::new, LootContextParamSets.BLOCK)), registriesFuture));
        pack.addProvider((output, registriesFuture) -> new FabricDatapackRegistryProvider(output, registriesFuture, Constants.MOD_ID, getWorldGenData()));
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        getWorldGenData().addEntries(registryBuilder);
    }

    private CoreWorldGenData worldGenData;

    private CoreWorldGenData getWorldGenData() {
        if (this.worldGenData == null) {
            this.worldGenData = new CoreWorldGenData();
        }
        return this.worldGenData;
    }
}
