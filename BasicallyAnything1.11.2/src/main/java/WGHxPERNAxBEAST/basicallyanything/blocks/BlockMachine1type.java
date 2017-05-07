package WGHxPERNAxBEAST.basicallyanything.blocks;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.blocks.item.IMetaBlockName;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler.ChipTypes;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockMachine1type  extends BlockContainer implements IMetaBlockName, ITileEntityProvider {
	
	/**
	 * The type which indicates the tier of block. Basic and advanced versions of each machine
	 */
	public static final PropertyEnum TYPE = PropertyEnum.create("type", ChipTypes.class);
	
	/**
	 * Sets the default state, hardness and resistance for machines
	 * @param unlocalizedName The unlocalized name of the block
	 */
	public BlockMachine1type(String unlocalizedName) {
		super(Material.IRON); //The blocks material
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setDefaultState(this.blockState.getBaseState());
		this.isBlockContainer = true;
	}
	
	/**
	 * Makes sure the block works with meta data
	 */
	@Override
	public String getSpecialName(ItemStack stack) {
		return null;
	}
	/**
	 * Makes sure that when you pick block you get the correct block
	 */
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, (int) (getMetaFromState(world.getBlockState(pos))));
	}
	
	/**
	 * Makes sure the block drops the correct damage. If the block has the {@link PropertyDirection} then this needs to be overridden
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	/**
	 * Returns the state from the meta data. If the block has the {@link PropertyDirection} then this needs to be overridden
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}

	/**
	 * Says that the block should use a model to be rendered
	 */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	/**
	 * Default method to create the tile entity. You probably want to override this
	 */
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return null;
	}
	
	/**
	 * Default method to create the tile entity. You probably want to override this
	 */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}