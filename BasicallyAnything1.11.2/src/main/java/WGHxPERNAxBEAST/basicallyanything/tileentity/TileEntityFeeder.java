package WGHxPERNAxBEAST.basicallyanything.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler.ChipTypes;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityFeeder extends TileEntity implements ITickable, ICapabilityProvider {
/**
 * New 1.9.4 onwards. Using forge capabilities instead of {@link IInventory}
 */
private ItemStackHandler handler;
private int cooldown;
private int cooldownCap = 100;
private Random random;

/**
 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
 */
public TileEntityFeeder() {
	this.cooldown = 0;
	this.handler = new ItemStackHandler(10);
	this.random = new Random();
}
/**
 * Reads data from nbt where data is stored
 */
@Override
public void readFromNBT(NBTTagCompound nbt) {
	this.cooldown = nbt.getInteger("Cooldown");
	this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler")); // Gets the ItemStackHandler from tag within a tag

	super.readFromNBT(nbt);
}
/**
 * Writes data to nbt so it is stored
 */
@Override
public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
	nbt.setInteger("Cooldown", this.cooldown);
	nbt.setTag("ItemStackHandler", this.handler.serializeNBT()); // We write our ItemStackHandler as a tag in a tag

	return super.writeToNBT(nbt);
}

/**
 * The packet which is used to update the tile entity which holds all of the
 * tileentities data
 */
@Override
public SPacketUpdateTileEntity getUpdatePacket() {
	NBTTagCompound nbt = new NBTTagCompound();
	this.writeToNBT(nbt);
	int metadata = getBlockMetadata();
	return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
}

/**
 * Reads the nbt when it receives a packet
 */
@Override
public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
	this.readFromNBT(pkt.getNbtCompound());
}

/**
 * Gets the nbt for a new packet
 */
@Override
public NBTTagCompound getUpdateTag() {
	NBTTagCompound nbt = new NBTTagCompound();
	this.writeToNBT(nbt);
	return nbt;
}

/**
 * Handles when you get an update
 */
@Override
public void handleUpdateTag(NBTTagCompound tag) {
	this.readFromNBT(tag);
}

/**
 * Gets the tile entities nbt with all of the data stored in it
 */
@Override
public NBTTagCompound getTileData() {
	NBTTagCompound nbt = new NBTTagCompound();
	this.writeToNBT(nbt);
	return nbt;
}

/**
 * New 1.9.4 onwards. Capability system
 */
@Override
public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
	if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		return (T) this.handler; // Makes it so that you can get the
									// capability from our tile entity
	return super.getCapability(capability, facing);
}

/**
 * Says what our block is capable of
 */
@Override
public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
	if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		return true;
	return super.hasCapability(capability, facing);
}

/**
 * Says whether the player can interact with the block - used for our
 * {@link GuiBlockBreaker}
 * 
 * @param player
 *            The player to test
 * @return If the player can interact with the block
 */
public boolean isUseableByPlayer(EntityPlayer player) {
	return this.world.getTileEntity(this.getPos()) == this
			&& player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
}
public void setPlayerUUID(UUID id) {
	this.setPlayerUUID(id);
}
@Override
public void update() {
	if (this.world != null) {
		
	}
	
}


}