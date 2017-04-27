package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockCanvas;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockFeeder;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockGamemodeDetector;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockMachineFrame;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinum;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumNuggetOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockSuitCase;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinBlock;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinButton;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinDoor;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinFence;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinFenceGate;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinPressurePlate;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinSlabDouble;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinSlabHalf;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTinStairs;
import WGHxPERNAxBEAST.basicallyanything.blocks.item.ItemBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.blocks.item.ItemBlockDoor;
import WGHxPERNAxBEAST.basicallyanything.blocks.item.ItemBlockMeta;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityCanvas;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

	public static Block platinum_ore;
	public static Block platinum_nugget_ore;
	public static Block platinum_block;
	public static Block suit_case;
	public static Block feeder;
	public static Block machine_frame;
	public static Block tinOre;
	public static Block tinBlock;
	public static Block breaker;
	public static Block gamemodeDetector;
	public static BlockTinSlabHalf tinSlabHalf;
	public static BlockTinSlabDouble tinSlabDouble;
	public static BlockTinStairs tinStairs;
	public static BlockTinFence tinFence;
	public static BlockTinFenceGate tinFenceGate;
	public static Block tinButton;
	public static Block tinPressurePlate;
	public static BlockTinDoor tinDoor;
	public static Block canvas;
	

	public static void init() {
		platinum_ore = new BlockPlatinumOre("Platinum_Ore", "Platinum_Ore");
		platinum_nugget_ore = new BlockPlatinumNuggetOre("Platinum_Nugget_Ore", "Platinum_Nugget_Ore");
		platinum_block = new BlockPlatinum("Platinum_Block", "Platinum_Block");
		suit_case = new BlockSuitCase("Suit_Case", "Suit Case");
		feeder = new BlockFeeder("block_feeder");
	tinOre = new BlockTinOre("tin_ore", "tin_ore");
		breaker = new BlockBreaker("block_breaker");
		gamemodeDetector = new BlockGamemodeDetector("gamemode_detector");
		machine_frame = new BlockMachineFrame("machine_frame");
		tinBlock = new BlockTinBlock("tin_block");
		tinSlabHalf = new BlockTinSlabHalf("tin_slab_half");
		tinSlabDouble = new BlockTinSlabDouble("tin_slab_double");
		tinStairs = new BlockTinStairs("tin_stairs", tinBlock.getDefaultState());
		tinFence = new BlockTinFence("tin_fence");
		tinFenceGate = new BlockTinFenceGate("tin_fence_gate");
		tinButton = new BlockTinButton("tin_button");
		tinPressurePlate = new BlockTinPressurePlate("tin_pressure_plate");
		tinDoor = new BlockTinDoor("tin_door");
		canvas = new BlockCanvas("canvas");

	}
	
	public static void register() {
		registerBlock(platinum_ore);
		registerBlock(platinum_nugget_ore);
		registerBlock(platinum_block);
		registerBlock(suit_case);
		registerBlock(feeder);
		registerBlock(tinOre, new ItemBlockMeta(tinOre)); //Says that the block uses the ItemBlockMeta as the item block
		registerBlock(breaker, new ItemBlockBreaker(breaker));
		registerBlock(gamemodeDetector);
		registerBlock(machine_frame, new ItemBlockMeta(machine_frame));
		registerBlock(tinBlock);
		registerBlock(tinSlabHalf, new ItemSlab(tinSlabHalf, tinSlabHalf, tinSlabDouble));
		GameRegistry.register(tinSlabDouble); //Doesn't need an item
		registerBlock(tinStairs);
		registerBlock(tinFence);
		registerBlock(tinFenceGate);
		registerBlock(tinButton);
		registerBlock(tinPressurePlate);
		registerBlock(tinDoor, new ItemBlockDoor(tinDoor));
		registerBlock(canvas);

	}
	
	public static void registerRenders() {
		registerRender(platinum_ore);
		for(int i = 0; i < EnumHandler.OreType.values().length; i++) {
			registerRender(platinum_nugget_ore, i, "platinum_nugget_ore_" + EnumHandler.OreType.values()[i].getName());
		}
		registerRender(platinum_block);
		registerRender(suit_case);
		registerRender(feeder);
		for(int i = 0; i < EnumHandler.OreType.values().length; i++) {
			registerRender(tinOre, i, "tin_ore_" + EnumHandler.OreType.values()[i].getName());
		}
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(breaker, i, "block_breaker_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(machine_frame, i, "machine_frame_" + EnumHandler.ChipTypes.values()[i].getName());
		}
		registerRender(gamemodeDetector);
		registerRender(tinBlock);
		registerRender(tinSlabHalf);
		registerRender(tinStairs);
		registerRender(tinFence);
		registerRender(tinFenceGate);
		registerRender(tinButton);
		registerRender(tinPressurePlate);
		registerRender(tinDoor);
		registerRender(canvas);

	}
	
	@SideOnly(Side.CLIENT)
	public static void registerBlockColours() {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {
			
			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) {
				TileEntityCanvas canvas = (TileEntityCanvas) world.getTileEntity(pos);
				if(canvas != null)
					return canvas.getColour();
				return 0xFFFFFF;
			}
		}, canvas);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				if(stack.hasTagCompound())
					if(stack.getTagCompound().hasKey("colour"))
						return stack.getTagCompound().getInteger("colour");
				return 0xFFFFFF;
			}
		}, canvas);
		Utils.getLogger().info("Registered block colours!");
	}
	
	/**
	 * Creates state mappers for ignoring properties etc.
	 */
	@SideOnly(Side.CLIENT)
	public static void createStateMappers() {
		ModelLoader.setCustomStateMapper(gamemodeDetector, new StateMapperBase() { //Ingores all of the block's properties
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(gamemodeDetector.getRegistryName(), "normal");
			}
		});
		ModelLoader.setCustomStateMapper(tinDoor, (new StateMap.Builder().ignore(BlockDoor.POWERED)).build()); //Ignores only the powered property
		ModelLoader.setCustomStateMapper(tinFenceGate, (new StateMap.Builder().ignore(BlockFenceGate.POWERED)).build());
		Utils.getLogger().info("Created the state mappers!");
	}
	
	/**
	 * Registers the block
	 * @param block The block to register
	 */
	public static void registerBlock(Block block) {
		block.setCreativeTab(BasicallyAnything.blocks);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the block with a custom {@link ItemBlock}
	 * @param block The block
	 * @param itemBlock The {@link ItemBlock}
	 */
	public static void registerBlock(Block block, ItemBlock itemBlock) {
		block.setCreativeTab(BasicallyAnything.blocks);
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the blocks renders
	 * @param block The block
	 */
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the blocks renders even if it has meta data
	 * @param block The block
	 * @param meta The blocks meta data
	 * @param fileName The file name
	 */
	public static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
}