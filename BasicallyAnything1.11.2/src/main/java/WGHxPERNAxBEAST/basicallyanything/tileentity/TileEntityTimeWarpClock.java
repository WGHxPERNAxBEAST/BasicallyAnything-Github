package WGHxPERNAxBEAST.basicallyanything.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.mojang.authlib.GameProfile;

import WGHxPERNAxBEAST.basicallyanything.blocks.BlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTimeWarpClock;
import WGHxPERNAxBEAST.basicallyanything.capabilties.Worker;
import WGHxPERNAxBEAST.basicallyanything.client.gui.GuiBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.config.BatConfig;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler.ChipTypes;
import WGHxPERNAxBEAST.basicallyanything.init.ModCapabilities;
import WGHxPERNAxBEAST.basicallyanything.init.ModMachines;
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

public class TileEntityTimeWarpClock extends TileEntity implements ITickable, ICapabilityProvider {

	/**
	 * New 1.9.4 onwards. Using forge capabilities instead of {@link IInventory}
	 */
	private ItemStackHandler handler;
	private Random random;
	private Worker worker;

	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityTimeWarpClock() {
		this.worker = new Worker(BatConfig.machineCooldownBasic, () -> {
			if (this.world.isBlockPowered(pos)) { // Calls it server side and checks if our block is powered
				IBlockState currentState = this.world.getBlockState(pos); // Gets our block state
				this.world.setBlockState(pos, currentState.withProperty(BlockTimeWarpClock.ACTIVATED, Boolean.valueOf(true))); // Updates it if it is powered
				updateCooldownCap();
			}
		}, () -> {
			IBlockState currentState = this.world.getBlockState(pos); // Updates our current state variable
			EnumFacing facing = (EnumFacing) currentState.getValue(BlockTimeWarpClock.FACING); // Gets which way our block is facing
		});
		this.handler = new ItemStackHandler(10);
		this.random = new Random();
	}

	/**
	 * Reads data from nbt where data is stored
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.worker.deserializeNBT(nbt.getCompoundTag("Worker"));
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler")); // Gets the ItemStackHandler from tag within a tag

		super.readFromNBT(nbt);
	}

	/**
	 * Writes data to nbt so it is stored
	 */
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setTag("Worker", this.worker.serializeNBT());
		nbt.setTag("ItemStackHandler", this.handler.serializeNBT()); // We write our ItemStackHandler as a tag in a tag

		return super.writeToNBT(nbt);
	}

	@Override
	public void update() {
		if (this.world != null && !this.world.isRemote) { // Makes sure we have a world. RENAMED IN
									// 1.11.2 from worldObj to world
			if (!this.world.isBlockPowered(pos)) { // If the block is not powered
				if (!this.world.isAirBlock(pos) && this.world.getBlockState(pos).getBlock() == ModMachines.TimeWarpClock) { // The block is not air and it is a block breaker
					if (this.world.getBlockState(pos).getValue(BlockTimeWarpClock.ACTIVATED)) { // Checks if it is activated
						IBlockState currentState = this.world.getBlockState(pos);
						this.world.setBlockState(pos,
								currentState.withProperty(BlockTimeWarpClock.ACTIVATED, Boolean.valueOf(false))); // Makes it not activated
					}
				}
			}
			if(this.world.isBlockPowered(pos))
			this.world.tickUpdates(true);
		}
	}

	public void updateCooldownCap() {
		int cap = this.worker.getMaxWork();
		if (this.world.getBlockState(pos).getValue(BlockTimeWarpClock.TYPE) == ChipTypes.BASIC)
			cap = BatConfig.machineCooldownBasic;
		else
			cap = BatConfig.machineCooldownAdvanced;
		this.worker.setMaxCooldown(cap);
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
			return (T) this.handler; // Makes it so that you can get the capability from our tile entity
		if(capability == ModCapabilities.CAPABILITY_WORKER)
			return (T) this.worker;
		return super.getCapability(capability, facing);
	}

	/**
	 * Says what our block is capable of
	 */
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || capability == ModCapabilities.CAPABILITY_WORKER)
			return true;
		return super.hasCapability(capability, facing);
	}

	/**
	 * Says that if the block state updates, the tile entity shouldn't get
	 * destroyed but should not refresh
	 */
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}

}