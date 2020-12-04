package com.grim3212.assorted.core.common.data;

import com.grim3212.assorted.core.AssortedCore;
import com.grim3212.assorted.core.common.item.CoreItems;
import com.grim3212.assorted.core.common.lib.CoreTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CoreItemTagProvider extends ItemTagsProvider {

	public CoreItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagProvider, AssortedCore.MODID, existingFileHelper);
	}

	@Override
	protected void registerTags() {
		this.copy(CoreTags.Blocks.ORES_TIN, CoreTags.Items.ORES_TIN);
		this.copy(CoreTags.Blocks.ORES_COPPER, CoreTags.Items.ORES_COPPER);
		this.copy(CoreTags.Blocks.ORES_SILVER, CoreTags.Items.ORES_SILVER);
		this.copy(CoreTags.Blocks.ORES_ALUMINUM, CoreTags.Items.ORES_ALUMINUM);
		this.copy(CoreTags.Blocks.ORES_NICKEL, CoreTags.Items.ORES_NICKEL);
		this.copy(CoreTags.Blocks.ORES_PLATINUM, CoreTags.Items.ORES_PLATINUM);
		this.copy(CoreTags.Blocks.ORES_LEAD, CoreTags.Items.ORES_LEAD);
		this.copy(CoreTags.Blocks.ORES_RUBY, CoreTags.Items.ORES_RUBY);
		this.copy(CoreTags.Blocks.ORES_AMETHYST, CoreTags.Items.ORES_AMETHYST);
		this.copy(CoreTags.Blocks.ORES_SAPPHIRE, CoreTags.Items.ORES_SAPPHIRE);
		this.copy(CoreTags.Blocks.ORES_TOPAZ, CoreTags.Items.ORES_TOPAZ);

		this.getOrCreateBuilder(CoreTags.Items.GEMS_RUBY).add(CoreItems.RUBY.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_AMETHYST).add(CoreItems.AMETHYST.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_SAPPHIRE).add(CoreItems.SAPPHIRE.get());
		this.getOrCreateBuilder(CoreTags.Items.GEMS_TOPAZ).add(CoreItems.TOPAZ.get());
	}

	@Override
	public String getName() {
		return "Assorted Core item tags";
	}
}
