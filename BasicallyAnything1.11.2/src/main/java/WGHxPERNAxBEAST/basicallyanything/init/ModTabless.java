package WGHxPERNAxBEAST.basicallyanything.init;

import com.google.common.collect.Sets;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModSword;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemPlasmaBeam;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemSoulStealer;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTabless {
	
	public static final ToolMaterial plasmaMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":plasma", 18, 159000, 29.0F, 25.0F, 120);
	
	public static Item PlasmaBeam;
	
	public static void init(){
		PlasmaBeam = new ItemPlasmaBeam(0, 0, plasmaMaterial, Sets.newHashSet(new Block[] {Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, ModBlocks.platinum_block, ModBlocks.canvas, ModBlocks.platinum_nugget_ore, ModBlocks.platinum_ore, ModBlocks.tinBlock, ModBlocks.tinOre, ModMachines.breaker, ModMachines.feeder, ModMachines.machine_frame, ModMachines.gamemodeDetector}), "plasma_beam");
	}
	
	public static void register() {
		registerItem(PlasmaBeam);
	}
	
	public static void registerRenders(){
		registerRender(PlasmaBeam);
	}
	

	public static void registerItem(Item item) {
		item.setCreativeTab(null);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
	}
	


}