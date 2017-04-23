package WGHxPERNAxBEAST.basicallyanything.init;


import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockFeeder;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockModBlocks;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinum;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumNuggetOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockPlatinumOre;
import WGHxPERNAxBEAST.basicallyanything.blocks.BlockSuitCase;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block platinum_ore;
	public static Block platinum_nugget_ore;
	public static Block platinum_block;
	public static Block suit_case;
	public static Block feeder;
	public static Block machine_frame;

	public static void init() {
		platinum_ore = new BlockPlatinumOre("Platinum_Ore", "Platinum_Ore");
		platinum_nugget_ore = new BlockPlatinumNuggetOre("Platinum_Nugget_Ore", "Platinum_Nugget_Ore");
		platinum_block = new BlockPlatinum("Platinum_Block", "Platinum_Block");
		suit_case = new BlockSuitCase("Suit_Case", "Suit Case");
		feeder = new BlockFeeder("block_feeder");
		machine_frame = new BlockModBlocks("machine_frame", "machine_frame", Material.IRON, 3, 12);
	}
	
	public static void register() {
		registerBlock(platinum_ore);
		registerBlock(platinum_nugget_ore);
		registerBlock(platinum_block);
		registerBlock(suit_case);
		registerBlock(feeder);
		registerBlock(machine_frame);
	}
	
	public static void registerRenders() {
		registerRender(platinum_ore);
		registerRender(platinum_nugget_ore);
		registerRender(platinum_block);
		registerRender(suit_case);
		registerRender(feeder);
		registerRender(machine_frame);
	}
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(BasicallyAnything.blocks);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5) );
	}
	public static void registerBlock(Block block, ItemBlock itemBlock) {
		block.setCreativeTab(BasicallyAnything.blocks);
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5) );
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "Inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Block block, int meta, String filename) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), "inventory"));
		Utils.getLogger().info("Register render for" + block.getUnlocalizedName().substring(5));
	}

}
