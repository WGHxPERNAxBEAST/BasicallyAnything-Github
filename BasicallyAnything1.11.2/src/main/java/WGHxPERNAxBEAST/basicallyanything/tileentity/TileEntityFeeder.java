package WGHxPERNAxBEAST.basicallyanything.tileentity;

import java.util.Random;
import java.util.UUID;

import WGHxPERNAxBEAST.basicallyanything.blocks.BlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockFeeder;
import WGHxPERNAxBEAST.basicallyanything.capabilties.Worker;
import WGHxPERNAxBEAST.basicallyanything.client.gui.GuiBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.config.BatConfig;
import WGHxPERNAxBEAST.basicallyanything.container.ContainerFeeder;
import WGHxPERNAxBEAST.basicallyanything.init.ModCapabilities;
import WGHxPERNAxBEAST.basicallyanything.init.ModMachines;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
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
	private Random random;
	private Worker worker;

	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityFeeder() {
		this.worker = new Worker(BatConfig.machineCooldownAdvanced, () -> {
			if (this.world.isBlockPowered(pos)) { // Calls it server side and checks if our block is powered
				IBlockState currentState = this.world.getBlockState(pos); // Gets our block state
				this.world.setBlockState(pos, currentState.withProperty(BlockFeeder.ACTIVATED, Boolean.valueOf(true))); // Updates it if it is powered
				updateCooldownCap();
			}
		}, () -> {
			IBlockState currentState = this.world.getBlockState(pos); // Updates our current state variable
			EnumFacing facing = (EnumFacing) currentState.getValue(BlockFeeder.FACING);
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

	public void updateCooldownCap() {
		int cap = this.worker.getMaxWork();
			cap = BatConfig.machineCooldownAdvanced;
		this.worker.setMaxCooldown(cap);
	}

	/**
	 * Breaks blocks
	 * 
	 * @param facing
	 *            The direction in which the block breaker is facing
	 */
	
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

	/**
	 * Says that if the block state updates, the tile entity shouldn't get
	 * destroyed but should not refresh
	 */
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}
	
	public static EntityPlayer player;
	public static ItemFood FOOD;
	public static ItemStack heal;
	public static ItemStack sat;
	
	@Override
	public void tick() {
		player = (EntityPlayer) BlockFeeder.player;
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(0, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(1, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(2, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(3, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(4, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(5, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(6, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(7, 1, true).getItem();
		FOOD = (ItemFood) this.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).extractItem(8, 1, true).getItem();
		if(player.getFoodStats().needFood()){
			FOOD.getHealAmount(heal);
			FOOD.getSaturationModifier(sat);
			player.getFoodStats().addStats(FOOD, heal);
		}
	}

}