package com.grim3212.assorted.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.grim3212.assorted.core.client.data.CoreBlockstateProvider;
import com.grim3212.assorted.core.client.data.CoreItemModelProvider;
import com.grim3212.assorted.core.client.proxy.ClientProxy;
import com.grim3212.assorted.core.client.screen.AlloyForgeScreen;
import com.grim3212.assorted.core.client.screen.GrindingMillScreen;
import com.grim3212.assorted.core.common.block.CoreBlocks;
import com.grim3212.assorted.core.common.block.blockentity.CoreBlockEntityTypes;
import com.grim3212.assorted.core.common.crafting.CoreRecipeSerializers;
import com.grim3212.assorted.core.common.crafting.CoreRecipeTypes;
import com.grim3212.assorted.core.common.data.CoreBlockTagProvider;
import com.grim3212.assorted.core.common.data.CoreItemTagProvider;
import com.grim3212.assorted.core.common.data.CoreLootProvider;
import com.grim3212.assorted.core.common.data.CoreRecipes;
import com.grim3212.assorted.core.common.gen.CoreWorldGeneration;
import com.grim3212.assorted.core.common.handler.CoreConfig;
import com.grim3212.assorted.core.common.inventory.CoreContainerTypes;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.proxy.IProxy;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod(AssortedCore.MODID)
public class AssortedCore {
	public static final String MODID = "assortedcore";
	public static final String MODNAME = "Assorted Core";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static IProxy proxy = new IProxy() {
	};

	public static final CreativeModeTab ASSORTED_CORE_ITEM_GROUP = (new CreativeModeTab(AssortedCore.MODID) {
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(CoreBlocks.PLATINUM_ORE.get());
		}
	});

	public AssortedCore() {
		DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
		proxy.starting();

		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		modBus.addListener(this::setup);
		modBus.addListener(this::setupClient);
		modBus.addListener(this::gatherData);

		CoreBlocks.BLOCKS.register(modBus);
		CoreItems.ITEMS.register(modBus);
		CoreBlockEntityTypes.BLOCK_ENTITIES.register(modBus);
		CoreContainerTypes.CONTAINER_TYPES.register(modBus);
		CoreRecipeSerializers.RECIPE_SERIALIZERS.register(modBus);

		ModLoadingContext.get().registerConfig(Type.COMMON, CoreConfig.COMMON_SPEC);

		MinecraftForge.EVENT_BUS.register(new CoreWorldGeneration());
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CoreRecipeTypes.register();
		});
	}

	private void setupClient(final FMLClientSetupEvent event) {
		MenuScreens.register(CoreContainerTypes.ALLOY_FORGE.get(), AlloyForgeScreen::new);
		MenuScreens.register(CoreContainerTypes.GRINDING_MILL.get(), GrindingMillScreen::new);
	}

	private void gatherData(GatherDataEvent event) {
		DataGenerator datagenerator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			CoreBlockTagProvider blockTagProvider = new CoreBlockTagProvider(datagenerator, fileHelper);
			datagenerator.addProvider(blockTagProvider);
			datagenerator.addProvider(new CoreItemTagProvider(datagenerator, blockTagProvider, fileHelper));
			datagenerator.addProvider(new CoreLootProvider(datagenerator));
			datagenerator.addProvider(new CoreRecipes(datagenerator));
		}

		if (event.includeClient()) {
			CoreBlockstateProvider blockStatesProvider = new CoreBlockstateProvider(datagenerator, fileHelper);
			datagenerator.addProvider(blockStatesProvider);
			datagenerator.addProvider(new CoreItemModelProvider(datagenerator, blockStatesProvider.getExistingFileHelper()));
		}
	}
}
