package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemChip;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockFeeder;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockGamemodeDetector;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockMachineFrame;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockTimeWarpClock;
import WGHxPERNAxBEAST.basicallyanything.blocks.item.ItemBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.blocks.item.ItemBlockMeta;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModMachines {
	
	public static Item machine_core;
	public static Item chip;
	public static Block feeder;
	public static Block machine_frame;
	public static Block breaker;
	public static Block gamemodeDetector;
	public static Block TimeWarpClock;
	
	public static void init() {
		chip = new ItemChip("chip");
		machine_core = new ItemChip("machine_core");
		feeder = new BlockFeeder("feeder");
		breaker = new BlockBreaker("block_breaker");
		gamemodeDetector = new BlockGamemodeDetector("gamemode_detector");
		machine_frame = new BlockMachineFrame("machine_frame");
		TimeWarpClock = new BlockTimeWarpClock("time_warp_clock");
	}
	
	public static void register() {
		registerItem(chip);
		registerItem(machine_core);
		registerBlock(feeder);
		registerBlock(breaker, new ItemBlockBreaker(breaker));
		registerBlock(gamemodeDetector);
		registerBlock(machine_frame, new ItemBlockMeta(machine_frame));
		registerBlock(TimeWarpClock, new ItemBlockMeta(TimeWarpClock));
	}
	
	public static void registerRenders() {
		registerRender(feeder);
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(breaker, i, "block_breaker_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(machine_frame, i, "machine_frame_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(machine_core, i, "machine_core_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(chip, i, "chip_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(TimeWarpClock, i, "time_warp_clock_" + EnumHandler.ChipTypes.values()[i].getName());
		}
		registerRender(gamemodeDetector);
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
	}
	
	/**
	 * Registers the block
	 * @param block The block to register
	 */
	public static void registerBlock(Block block) {
		block.setCreativeTab(BasicallyAnything.machines);
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
		block.setCreativeTab(BasicallyAnything.machines);
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

	
	public static void registerItem(Item item) {
		item.setCreativeTab(BasicallyAnything.machines);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Item item, int meta, String filename) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), "inventory"));
		Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
	}

}
