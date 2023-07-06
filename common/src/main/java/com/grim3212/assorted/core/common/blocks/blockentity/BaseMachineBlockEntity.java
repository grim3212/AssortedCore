package com.grim3212.assorted.core.common.blocks.blockentity;

import com.google.common.collect.Lists;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.blocks.BaseMachineBlock;
import com.grim3212.assorted.core.common.inventory.BaseMachineInventory;
import com.grim3212.assorted.lib.core.inventory.IInventoryBlockEntity;
import com.grim3212.assorted.lib.core.inventory.IPlatformInventoryStorageHandler;
import com.grim3212.assorted.lib.platform.Services;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class BaseMachineBlockEntity extends BlockEntity implements IInventoryBlockEntity, MenuProvider, Nameable, RecipeHolder, StackedContentsCompatible {

    protected final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();
    protected final RecipeType<? extends BaseMachineRecipe> recipeType;
    protected final MachineTier tier;
    protected int burnTime;
    protected int recipesUsed;
    protected int cookTime;
    protected int cookTimeTotal;
    protected final ContainerData machineData = new ContainerData() {
        public int get(int index) {
            switch (index) {
                case 0:
                    return BaseMachineBlockEntity.this.burnTime;
                case 1:
                    return BaseMachineBlockEntity.this.recipesUsed;
                case 2:
                    return BaseMachineBlockEntity.this.cookTime;
                case 3:
                    return BaseMachineBlockEntity.this.cookTimeTotal;
                default:
                    return 0;
            }
        }

        public void set(int index, int value) {
            switch (index) {
                case 0:
                    BaseMachineBlockEntity.this.burnTime = value;
                    break;
                case 1:
                    BaseMachineBlockEntity.this.recipesUsed = value;
                    break;
                case 2:
                    BaseMachineBlockEntity.this.cookTime = value;
                    break;
                case 3:
                    BaseMachineBlockEntity.this.cookTimeTotal = value;
            }

        }

        public int getCount() {
            return 4;
        }
    };
    protected int defaultCookTime;
    private Component customName;
    protected NonNullList<ItemStack> items;

    protected IPlatformInventoryStorageHandler platformInventoryStorageHandler;
    private final Map<Direction, BaseMachineInventory> inventoryCache;

    public BaseMachineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, MachineTier tier, int slots, int defaultCookTime, RecipeType<? extends BaseMachineRecipe> recipeTypeIn) {
        super(type, pos, state);
        this.tier = tier;
        this.recipeType = recipeTypeIn;
        this.defaultCookTime = defaultCookTime;
        this.items = NonNullList.withSize(slots, ItemStack.EMPTY);
        this.inventoryCache = new HashMap<>();
    }

    @Override
    public IPlatformInventoryStorageHandler getStorageHandler() {
        if (this.platformInventoryStorageHandler == null) {
            this.platformInventoryStorageHandler = this.createStorageHandler();
        }

        return this.platformInventoryStorageHandler;
    }

    public BaseMachineInventory getInventory(@Nullable Direction direction) {
        if (!this.inventoryCache.containsKey(direction)) {
            this.inventoryCache.put(direction, new BaseMachineInventory(this, direction));
        }

        return this.inventoryCache.get(direction);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        if (this.platformInventoryStorageHandler != null) {
            this.platformInventoryStorageHandler.invalidate();
        }

        this.inventoryCache.clear();
    }

    public IPlatformInventoryStorageHandler createStorageHandler() {
        return Services.INVENTORY.createSidedStorageInventoryHandler(this::getInventory);
    }

    public abstract List<Integer> inputSlots();

    public abstract int fuelSlot();

    public abstract int outputSlot();

    public abstract int[] getSlotsForFace(Direction side);

    public boolean inputsWithItems() {
        return this.inputSlots().stream().allMatch((slot) -> !this.items.get(slot).isEmpty());
    }

    public boolean canPlaceItem(int index, ItemStack stack) {
        if (index == this.outputSlot()) {
            return false;
        } else if (index != this.fuelSlot()) {
            return true;
        } else {
            return this.getBurnTime(stack) > 0;
        }
    }

    private static void splitAndSpawnExperience(Level world, Vec3 pos, int craftedAmount, float experience) {
        int i = Mth.floor((float) craftedAmount * experience);
        float f = Mth.frac((float) craftedAmount * experience);
        if (f != 0.0F && Math.random() < (double) f) {
            ++i;
        }

        while (i > 0) {
            int j = ExperienceOrb.getExperienceValue(i);
            i -= j;
            world.addFreshEntity(new ExperienceOrb(world, pos.x, pos.y, pos.z, j));
        }
    }


    public Optional<BaseMachineRecipe> checkRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.items.size());
        for (int i = 0; i < this.items.size(); i++) {
            inventory.setItem(i, this.items.get(i));
        }

        return level.getRecipeManager().getRecipeFor((RecipeType<BaseMachineRecipe>) this.recipeType, inventory, level);
    }

    public void tick() {
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --this.burnTime;
        }

        ItemStack fuelSlot = this.items.get(this.fuelSlot());
        if (this.isBurning() || !fuelSlot.isEmpty() && this.inputsWithItems()) {
            BaseMachineRecipe irecipe = this.checkRecipe().orElse(null);

            if (!this.isBurning() && this.canCombine(irecipe)) {
                this.burnTime = this.getBurnTime(fuelSlot);
                this.recipesUsed = this.burnTime;
                if (this.isBurning()) {
                    flag1 = true;
                    if (fuelSlot.getItem().hasCraftingRemainingItem())
                        this.items.set(this.fuelSlot(), new ItemStack(fuelSlot.getItem().getCraftingRemainingItem()));
                    else if (!fuelSlot.isEmpty()) {
                        fuelSlot.shrink(1);
                        if (fuelSlot.isEmpty()) {
                            this.items.set(this.fuelSlot(), new ItemStack(fuelSlot.getItem().getCraftingRemainingItem()));
                        }
                    }
                }
            }

            if (this.isBurning() && this.canCombine(irecipe)) {
                ++this.cookTime;
                if (this.cookTime == this.cookTimeTotal) {
                    this.cookTime = 0;
                    this.cookTimeTotal = this.getCookTime();
                    this.combine(irecipe);
                    flag1 = true;
                }
            } else {
                this.cookTime = 0;
            }
        } else if (!this.isBurning() && this.cookTime > 0) {
            this.cookTime = Mth.clamp(this.cookTime - 2, 0, this.cookTimeTotal);
        }

        if (flag != this.isBurning()) {
            flag1 = true;
            this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BaseMachineBlock.ON, this.isBurning()), 3);
        }

        if (flag1) {
            this.setChanged();
        }
    }

    protected boolean isBurning() {
        return this.burnTime > 0;
    }

    protected abstract boolean canCombine(@Nullable BaseMachineRecipe recipeIn);

    protected abstract void combine(@Nullable BaseMachineRecipe recipe);

    public NonNullList<ItemStack> getItems() {
        return items;
    }

    public int getBurnTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        } else {
            return Services.PLATFORM.getFuelTime(fuel);
        }
    }

    public int getCookTime() {
        return (int) ((this.checkRecipe().map(BaseMachineRecipe::getCookTime).orElse(this.defaultCookTime)) * this.tier.getSpeedModifier());
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public void setCookTimeTotal(int cookTimeTotal) {
        this.cookTimeTotal = cookTimeTotal;
    }

    @Override
    public abstract AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity);

    @Override
    public Component getName() {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    @Override
    public Component getDisplayName() {
        return this.getName();
    }

    @Override
    public Component getCustomName() {
        return this.customName;
    }

    public void setCustomName(Component name) {
        this.customName = name;
    }

    protected abstract Component getDefaultName();

    @Override
    public Recipe<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void setRecipeUsed(Recipe<?> recipe) {
        if (recipe != null) {
            ResourceLocation resourcelocation = recipe.getId();
            this.recipes.addTo(resourcelocation, 1);
        }
    }

    @Override
    public void awardUsedRecipes(Player player, List<ItemStack> stacks) {
    }

    public void unlockRecipes(Player player) {
        List<Recipe<?>> list = this.grantStoredRecipeExperience(player.level(), player.position());
        player.awardRecipes(list);
        this.recipes.clear();
    }

    public List<Recipe<?>> grantStoredRecipeExperience(Level world, Vec3 pos) {
        List<Recipe<?>> list = Lists.newArrayList();

        for (Entry<ResourceLocation> entry : this.recipes.object2IntEntrySet()) {
            world.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                splitAndSpawnExperience(world, pos, entry.getIntValue(), ((BaseMachineRecipe) recipe).getExperience());
            });
        }

        return list;
    }

    @Override
    public void fillStackedContents(StackedContents helper) {
        for (ItemStack itemstack : this.items) {
            helper.accountStack(itemstack);
        }
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.items = NonNullList.withSize(this.items.size(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.items);
        this.burnTime = nbt.getInt("BurnTime");
        this.cookTime = nbt.getInt("CookTime");
        this.cookTimeTotal = nbt.getInt("CookTimeTotal");
        this.recipesUsed = this.getBurnTime(this.items.get(1));
        CompoundTag compoundnbt = nbt.getCompound("RecipesUsed");

        for (String s : compoundnbt.getAllKeys()) {
            this.recipes.put(new ResourceLocation(s), compoundnbt.getInt(s));
        }

        if (nbt.contains("CustomName", 8)) {
            this.customName = Component.Serializer.fromJson(nbt.getString("CustomName"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);

        compound.putInt("BurnTime", this.burnTime);
        compound.putInt("CookTime", this.cookTime);
        compound.putInt("CookTimeTotal", this.cookTimeTotal);
        ContainerHelper.saveAllItems(compound, this.items);
        CompoundTag compoundnbt = new CompoundTag();
        this.recipes.forEach((recipeId, craftedAmount) -> {
            compoundnbt.putInt(recipeId.toString(), craftedAmount);
        });
        compound.put("RecipesUsed", compoundnbt);

        if (this.customName != null) {
            compound.putString("CustomName", Component.Serializer.toJson(this.customName));
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
