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

		public int size() {
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
	public int getSizeInventory() {
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
	public ItemStack getStackInSlot(int index) {
		return this.items.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.items, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.items, index);
	}

	protected abstract List<Integer> inputSlots();

	protected abstract int fuelSlot();

	protected abstract int outputSlot();

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = this.items.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.items.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if (inputSlots().stream().anyMatch((slot) -> slot == index) && !flag) {
			this.cookTimeTotal = this.getCookTime();
			this.cookTime = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
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

		if (!this.world.isRemote) {
			ItemStack fuelSlot = this.items.get(this.fuelSlot());
			if (this.isBurning() || !fuelSlot.isEmpty() && this.inputsWithItems()) {
				BaseMachineRecipe irecipe = this.world.getRecipeManager().getRecipe((IRecipeType<BaseMachineRecipe>) this.recipeType, this, this.world).orElse(null);

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
				this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(BaseMachineBlock.ON, this.isBurning()), 3);
			}
		}

		if (flag1) {
			this.markDirty();
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
		return (int) ((this.world.getRecipeManager().getRecipe((IRecipeType<BaseMachineRecipe>) this.recipeType, this, this.world).map(BaseMachineRecipe::getCookTime).orElse(this.defaultCookTime)) * this.tier.getSpeedModifier());
	}

	@Override
	public void clear() {
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
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
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
	public void onCrafting(PlayerEntity player) {
	}

	public void unlockRecipes(PlayerEntity player) {
		List<IRecipe<?>> list = this.grantStoredRecipeExperience(player.world, player.getPositionVec());
		player.unlockRecipes(list);
		this.recipes.clear();
	}

	public List<IRecipe<?>> grantStoredRecipeExperience(World world, Vector3d pos) {
		List<IRecipe<?>> list = Lists.newArrayList();

		for (Entry<ResourceLocation> entry : this.recipes.object2IntEntrySet()) {
			world.getRecipeManager().getRecipe(entry.getKey()).ifPresent((recipe) -> {
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
			int j = ExperienceOrbEntity.getXPSplit(i);
			i -= j;
			world.addEntity(new ExperienceOrbEntity(world, pos.x, pos.y, pos.z, j));
		}

	}

	@Override
	public void fillStackedContents(RecipeItemHelper helper) {
		for (ItemStack itemstack : this.items) {
			helper.accountStack(itemstack);
		}
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(nbt, this.items);
		this.burnTime = nbt.getInt("BurnTime");
		this.cookTime = nbt.getInt("CookTime");
		this.cookTimeTotal = nbt.getInt("CookTimeTotal");
		this.recipesUsed = this.getBurnTime(this.items.get(1));
		CompoundNBT compoundnbt = nbt.getCompound("RecipesUsed");

		for (String s : compoundnbt.keySet()) {
			this.recipes.put(new ResourceLocation(s), compoundnbt.getInt(s));
		}

		if (nbt.contains("CustomName", 8)) {
			this.customName = ITextComponent.Serializer.getComponentFromJson(nbt.getString("CustomName"));
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
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
		return write(new CompoundNBT());
	}

	LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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
	public void remove() {
		super.remove();
		for (int x = 0; x < handlers.length; x++)
			handlers[x].invalidate();
	}

}
