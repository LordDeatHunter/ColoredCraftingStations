package wraith.coloredcraftingstations.block;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.screens.CraftingStationScreenHandler;
import wraith.coloredcraftingstations.screens.ImplementedInventory;
import wraith.coloredcraftingstations.registries.BlockEntityRegistry;

public class CraftingStationBlockEntity extends LockableContainerBlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, BlockEntityClientSerializable {

    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public CraftingStationBlockEntity() {
        super(BlockEntityRegistry.CRAFTING_STATION_BLOCK_ENTITY);
    }

    @Override
    public int size() {
        return 9;
    }

    @Override
    public Text getDisplayName() {
        return getContainerName();
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText( "container." + ColoredCraftingStations.MOD_ID + ".crafting_station");
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.inventory = DefaultedList.ofSize(size(), ItemStack.EMPTY);
        Inventories.fromTag(tag, inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new CraftingStationScreenHandler(syncId, inv, ScreenHandlerContext.EMPTY, this);
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return createMenu(syncId, playerInventory, playerInventory.player);
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!(player.currentScreenHandler instanceof CraftingStationScreenHandler)) return;
        for (int i = 1; i < 10; ++i) {
            this.inventory.set(i-1, player.currentScreenHandler.slots.get(i).getStack());
        }
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        if (this.world.getBlockEntity(this.pos) != this) {
            return false;
        } else {
            return player.squaredDistanceTo((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    public void setItems(CraftingInventory input) {
        for (int i = 0 ; i < input.size() && i < size(); ++i) {
            this.inventory.set(i, input.getStack(i));
        }
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        BlockState state = world.getBlockState(pos);
        fromTag(state, tag);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        return toTag(tag);
    }
}
