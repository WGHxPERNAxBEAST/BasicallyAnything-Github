package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlasmaLantern;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinum;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumNuggetOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumOre;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block platinum_ore;
	public static Block platinum_nugget_ore;
	public static Block platinum_block;
	public static Block plasmaLantern;

	public static void init() {
		platinum_ore = new BlockPlatinumOre("platinum_ore", "platinum_ore");
		platinum_nugget_ore = new BlockPlatinumNuggetOre("platinum_nugget_ore", "platinum_nugget_ore");
		platinum_block = new BlockPlatinum("platinum_block", "platinum_block");
		plasmaLantern = new BlockPlasmaLantern("plasma_lantern");
	}
	
	public static void register() {
		registerBlock(platinum_ore);
		registerBlock(platinum_nugget_ore);
		registerBlock(platinum_block);
		registerBlock(plasmaLantern);
	}
	
	public static void registerRenders() {
		registerRender(platinum_ore);
		registerRender(platinum_block);
		registerRender(plasmaLantern);
		
		for(int i = 0; i < EnumHandler.OreType.values().length; i++) {
			registerRender(platinum_nugget_ore, i, "platinum_nugget_ore_" + EnumHandler.OreType.values()[i].getName());
		}
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