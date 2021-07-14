package com.grim3212.assorted.core.common.block.tileentity;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.grim3212.assorted.core.api.crafting.BaseMachineRecipe;
import com.grim3212.assorted.core.api.machines.MachineTier;
import com.grim3212.assorted.core.common.block.BaseMachineBlock;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.INameable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public abstract class BaseMachineTileEntity extends TileEntity implements ISidedInventory, INamedContainerProvider, INameable, ITickableTileEntity, IRecipeHolder, IRecipeHelperPopulator {

	protected NonNullList<ItemStack> items;
	private ITextComponent customName;

	protected int burnTime;
	protected int recipesUsed;
	protected int cookTime;
	protected int cookTimeTotal;
	protected int defaultCookTime;

	protected final IIntArray machineData = new IIntArray() {
		public int get(int index) {
			switch (index) {
			case 0:
				return BaseMachineTileEntity.this.burnTime;
			case 1:
				return BaseMachineTileEntity.this.recipesUsed;
			case 2:
				return BaseMachineTileEntity.this.cookTime;
			case 3:
				return BaseMachineTileEntity.this.cookTimeTotal;
			default:
				return 0;
			}
		}

		public void set(int index, int value) {
			switch (index) {
			case 0:
				BaseMachineTileEntity.this.burnTime = value;
				break;
			case 1:
				BaseMachineTileEntity.this.recipesUsed = value;
				break;
			case 2:
				BaseMachineTileEntity.this.cookTime = value;
				break;
			case 3:
				BaseMachineTileEntity.this.cookTimeTotal = value;
			}

		}

		public int getCount() {
			return 4;
		}
	};

	protected final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();
	protected final IRecipeType<? extends BaseMachineRecipe> recipeType;
	protected final MachineTier tier;

	public BaseMachineTileEntity(TileEntityType<?> type, MachineTier tier, int slots, int defaultCookTime, IRecipeType<? extends BaseMachineRecipe> recipeTypeIn) {
		super(type);
		this.tier = tier;
		this.items = NonNullList.withSize(slots, ItemStack.EMPTY);
		this.recipeType = recipeTypeIn;
		this.defaultCookTime = defaultCookTime;
	}

	@Override
	public int getContainerSize() {
		return this.items.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.items) {
			if (!itemstack.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public ItemStack getItem(int index) {
		return this.items.get(index);
	}

	@Override
	public ItemStack removeItem(int index, int count) {
		return ItemStackHelper.removeItem(this.items, index, count);
	}

	@Override
	public ItemStack removeItemNoUpdate(int index) {
		return ItemStackHelper.takeItem(this.items, index);
	}

	protected abstract List<Integer> inputSlots();

	protected abstract int fuelSlot();

	protected abstract int outputSlot();

	@Override
	public void setItem(int index, ItemStack stack) {
		ItemStack itemstack = this.items.get(index);
		boolean flag = !stack.isEmpty() && stack.sameItem(itemstack) && ItemStack.tagMatches(stack, itemstack);
		this.items.set(index, stack);
		if (stack.getCount() > this.getMaxStackSize()) {
			stack.setCount(this.getMaxStackSize());
		}

		if (inputSlots().stream().anyMatch((slot) -> slot == index) && !flag) {
			this.cookTimeTotal = this.getCookTime();
			this.cookTime = 0;
			this.setChanged();
		}
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		if (this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		} else {
			return player.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
		}
	}

	protected boolean inputsWithItems() {
		return this.inputSlots().stream().allMatch((slot) -> !this.items.get(slot).isEmpty());
	}

	@Override
	public void tick() {
		boolean flag = this.isBurning();
		boolean flag1 = false;
		if (this.isBurning()) {
			--this.burnTime;
		}

		if (!this.level.isClientSide) {
			ItemStack fuelSlot = this.items.get(this.fuelSlot());
			if (this.isBurning() || !fuelSlot.isEmpty() && this.inputsWithItems()) {
				BaseMachineRecipe irecipe = this.level.getRecipeManager().getRecipeFor((IRecipeType<BaseMachineRecipe>) this.recipeType, this, this.level).orElse(null);

				if (!this.isBurning() && this.canCombine(irecipe)) {
					this.burnTime = this.getBurnTime(fuelSlot);
					this.recipesUsed = this.burnTime;
					if (this.isBurning()) {
						flag1 = true;
						if (fuelSlot.hasContainerItem())
							this.items.set(this.fuelSlot(), fuelSlot.getContainerItem());
						else if (!fuelSlot.isEmpty()) {
							fuelSlot.shrink(1);
							if (fuelSlot.isEmpty()) {
								this.items.set(this.fuelSlot(), fuelSlot.getContainerItem());
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
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.cookTimeTotal);
			}

			if (flag != this.isBurning()) {
				flag1 = true;
				this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(BaseMachineBlock.ON, this.isBurning()), 3);
			}
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

	protected int getBurnTime(ItemStack fuel) {
		if (fuel.isEmpty()) {
			return 0;
		} else {
			return ForgeHooks.getBurnTime(fuel);
		}
	}

	protected int getCookTime() {
		return (int) ((this.level.getRecipeManager().getRecipeFor((IRecipeType<BaseMachineRecipe>) this.recipeType, this, this.level).map(BaseMachineRecipe::getCookTime).orElse(this.defaultCookTime)) * this.tier.getSpeedModifier());
	}

	@Override
	public void clearContent() {
		this.items.clear();
	}

	@Override
	public abstract Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity);

	public void setCustomName(ITextComponent name) {
		this.customName = name;
	}

	@Override
	public ITextComponent getName() {
		return this.customName != null ? this.customName : this.getDefaultName();
	}

	@Override
	public ITextComponent getDisplayName() {
		return this.getName();
	}

	@Override
	public ITextComponent getCustomName() {
		return this.customName;
	}

	protected abstract ITextComponent getDefaultName();

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, Direction direction) {
		return this.canPlaceItem(index, itemStackIn);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		if (index == this.outputSlot()) {
			return false;
		} else if (index != this.fuelSlot()) {
			return true;
		} else {
			return getBurnTime(stack) > 0;
		}
	}

	@Override
	public void setRecipeUsed(IRecipe<?> recipe) {
		if (recipe != null) {
			ResourceLocation resourcelocation = recipe.getId();
			this.recipes.addTo(resourcelocation, 1);
		}
	}

	@Override
	public IRecipe<?> getRecipeUsed() {
		return null;
	}

	@Override
	public void awardUsedRecipes(PlayerEntity player) {
	}

	public void unlockRecipes(PlayerEntity player) {
		List<IRecipe<?>> list = this.grantStoredRecipeExperience(player.level, player.position());
		player.awardRecipes(list);
		this.recipes.clear();
	}

	public List<IRecipe<?>> grantStoredRecipeExperience(World world, Vector3d pos) {
		List<IRecipe<?>> list = Lists.newArrayList();

		for (Entry<ResourceLocation> entry : this.recipes.object2IntEntrySet()) {
			world.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
				list.add(recipe);
				splitAndSpawnExperience(world, pos, entry.getIntValue(), ((BaseMachineRecipe) recipe).getExperience());
			});
		}

		return list;
	}

	private static void splitAndSpawnExperience(World world, Vector3d pos, int craftedAmount, float experience) {
		int i = MathHelper.floor((float) craftedAmount * experience);
		float f = MathHelper.frac((float) craftedAmount * experience);
		if (f != 0.0F && Math.random() < (double) f) {
			++i;
		}

		while (i > 0) {
			int j = ExperienceOrbEntity.getExperienceValue(i);
			i -= j;
			world.addFreshEntity(new ExperienceOrbEntity(world, pos.x, pos.y, pos.z, j));
		}

	}

	@Override
	public void fillStackedContents(RecipeItemHelper helper) {
		for (ItemStack itemstack : this.items) {
			helper.accountStack(itemstack);
		}
	}

	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(nbt, this.items);
		this.burnTime = nbt.getInt("BurnTime");
		this.cookTime = nbt.getInt("CookTime");
		this.cookTimeTotal = nbt.getInt("CookTimeTotal");
		this.recipesUsed = this.getBurnTime(this.items.get(1));
		CompoundNBT compoundnbt = nbt.getCompound("RecipesUsed");

		for (String s : compoundnbt.getAllKeys()) {
			this.recipes.put(new ResourceLocation(s), compoundnbt.getInt(s));
		}

		if (nbt.contains("CustomName", 8)) {
			this.customName = ITextComponent.Serializer.fromJson(nbt.getString("CustomName"));
		}
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		compound.putInt("BurnTime", this.burnTime);
		compound.putInt("CookTime", this.cookTime);
		compound.putInt("CookTimeTotal", this.cookTimeTotal);
		ItemStackHelper.saveAllItems(compound, this.items);
		CompoundNBT compoundnbt = new CompoundNBT();
		this.recipes.forEach((recipeId, craftedAmount) -> {
			compoundnbt.putInt(recipeId.toString(), craftedAmount);
		});
		compound.put("RecipesUsed", compoundnbt);

		if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}

		return compound;
	}

	@Override
	public CompoundNBT getUpdateTag() {
		return save(new CompoundNBT());
	}

	LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (facing == Direction.UP)
				return handlers[0].cast();
			else if (facing == Direction.DOWN)
				return handlers[1].cast();
			else if (facing == Direction.NORTH)
				return handlers[2].cast();
			else if (facing == Direction.SOUTH)
				return handlers[3].cast();
			else if (facing == Direction.WEST)
				return handlers[4].cast();
			else if (facing == Direction.EAST)
				return handlers[5].cast();
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		for (int x = 0; x < handlers.length; x++)
			handlers[x].invalidate();
	}

}
