package WGHxPERNAxBEAST.basicallyanything.blocks;

import java.util.UUID;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.client.gui.GuiHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler.ChipTypes;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityFeeder;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BlockFeeder extends BlockMachine1type {

	/**
	 * The different properties our block can have.
	 * For {@link PropertyInteger} refer to {@link BlockGamemodeDetector}
	 */
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	public static final PropertyBool ACTIVATED = PropertyBool.create("activated");
	public static EntityLivingBase player;
	
	/**
	 * Default block constructor
	 * @param unlocalizedName The block's unlocalized name
	 */
	public BlockFeeder(String unlocalizedName) {
		super(unlocalizedName);
		//Sets the default version of the block
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVATED, Boolean.valueOf(false)));
	}
	
	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(IBlockState blockState, World world, BlockPos pos) {
		TileEntityFeeder te = (TileEntityFeeder) world.getTileEntity(pos);
		ItemStackHandler handler = (ItemStackHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		return Utils.calculateRedstone(handler);
	}
	
	/**
	 * Adds the properties to our block
	 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING,ACTIVATED});
	}
	
	/**
	 * Says redstone can connect
	 */
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return side != EnumFacing.UP || side != EnumFacing.DOWN; //Says that as long as its not connected on top or bottom it will connect
	}
	
	/**
	 * Replacement of onBlockPlaced in 1.11.2
	 */
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)).withProperty(ACTIVATED, Boolean.valueOf(false));
	}
	
	/**
	 * Returns the correct meta for the block
	 * I recommend also saving the EnumFacing to the meta but I haven't
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		int meta = EnumFacing.values().length + facing.ordinal(); //Stores the type the EnumFacing in the meta
		return meta;
	}
	
	/**
	 * Gets the block state from the meta
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.values()[meta % EnumFacing.values().length]; //Gets the EnumFacing from the meta
		return this.getDefaultState().withProperty(FACING, facing); //Returns the correct state
	}
	
	/**
	 * Makes sure that when you pick block you get the right version of the block
	 */
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, (int) (getMetaFromState(world.getBlockState(pos)) / EnumFacing.values().length));
	}
	
	/**
	 * Makes the block drop the right version of the block from meta data
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return (int) (getMetaFromState(state) / EnumFacing.values().length);
	}

	/**
	 * Returns the tile entity which holds information
	 */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityFeeder();
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityFeeder();
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		player = placer;
	}
	/**
	 * Opens our block's gui when the player right clicks on the block
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
		if(!worldIn.isRemote) {
			playerIn.openGui(BasicallyAnything.instance, GuiHandler.FEEDER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}	
}