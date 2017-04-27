package WGHxPERNAxBEAST.basicallyanything.container;

import WGHxPERNAxBEAST.basicallyanything.container.slots.SlotNormFood;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityFeeder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerFeeder extends Container {

	/**
	 * This tile entity and the item handler (inventory)
	 */
	private TileEntityFeeder te;
	private IItemHandler handler;

	/**
	 * Tells the container where the slots are
	 * @param playerInv The player's inventory
	 * @param te The tile entity
	 */
	public ContainerFeeder(IInventory playerInv, TileEntityFeeder te) {
		this.te = te;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null); //Gets the inventory from our tile entity
 
		//Our tile entity slots
		this.addSlotToContainer(new SlotNormFood(handler, 0, 62, 17));
		this.addSlotToContainer(new SlotNormFood(handler, 1, 80, 17));
		this.addSlotToContainer(new SlotNormFood(handler, 2, 98, 17));
		this.addSlotToContainer(new SlotNormFood(handler, 3, 62, 35));
		this.addSlotToContainer(new SlotNormFood(handler, 4, 80, 35));
		this.addSlotToContainer(new SlotNormFood(handler, 5, 98, 35));
		this.addSlotToContainer(new SlotNormFood(handler, 6, 62, 53));
		this.addSlotToContainer(new SlotNormFood(handler, 7, 80, 53));
		this.addSlotToContainer(new SlotNormFood(handler, 8, 98, 53));

		//The player's inventory slots
		int xPos = 8; //The x position of the top left player inventory slot on our texture
		int yPos = 84; //The y position of the top left player inventory slot on our texture

		//Player slots
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
			}
		}

		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
		}
	}

	/**
	 * Checks that the player can put items in and out of the container
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUseableByPlayer(player);
	}

	/**
	 * Called when the player presses shift and takes an item out of the container
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < this.handler.getSlots()) {
	            // From the block breaker inventory to player's inventory
	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
	                return ItemStack.EMPTY;
	        } else {
	            // From the player's inventory to block breaker's inventory
	            if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
	                return ItemStack.EMPTY;
	        }

	        if (current.getCount() == 0) //Use func_190916_E() instead of stackSize 1.11 only 1.11.2 use getCount()
	            slot.putStack(ItemStack.EMPTY); //Use ItemStack.field_190927_a instead of (ItemStack)null for a blank item stack. In 1.11.2 use ItemStack.EMPTY
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}

}