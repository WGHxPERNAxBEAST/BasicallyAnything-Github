package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModAxe;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModHoe;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModPickaxe;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModShovel;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTools {
	
	public static final ToolMaterial platinumMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":platinum", 12, 100000, 20.0F, 18.0F, 90);
	
	public static ItemPickaxe platinumPickaxe;
	public static ItemModAxe platinumAxe;
	public static ItemHoe platinumHoe;
	public static ItemSpade platinumShovel;
	
	public static void init(){
		platinumPickaxe = new ItemModPickaxe(platinumMaterial, "Platinum_Pickaxe", new ItemStack(ModItems.platinumIngot));
		platinumAxe = new ItemModAxe(platinumMaterial, "Platinum_Axe", new ItemStack(ModItems.platinumIngot));
		platinumHoe = new ItemModHoe(platinumMaterial, "Platinum_Hoe", new ItemStack(ModItems.platinumIngot));
		platinumShovel = new ItemModShovel(platinumMaterial, "Platinum_Shovel", new ItemStack(ModItems.platinumIngot));
		
	}
	
	public static void register() {
		registerItem(platinumPickaxe);
		registerItem(platinumAxe);
		registerItem(platinumHoe);
		registerItem(platinumShovel);
		
	}
	
	public static void registerRenders(){
		registerRender(platinumPickaxe);
		registerRender(platinumAxe);
		registerRender(platinumHoe);
		registerRender(platinumShovel);
		
	}

	public static void registerItem(Item item) {
		item.setCreativeTab(BasicallyAnything.tools);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
	}
	


}
