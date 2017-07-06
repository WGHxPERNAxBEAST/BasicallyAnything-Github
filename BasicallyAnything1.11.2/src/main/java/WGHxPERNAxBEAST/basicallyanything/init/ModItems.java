package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemHeart;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModIngot;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModNugget;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemPlasmaHandle;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	//State Items
	public static Item platinumIngot;
	public static Item platinumNugget;
	public static Item plasmaIngot;
	public static Item platinumStick;
	public static Item heart;
	public static Item infinityFlame;
	public static Item plasmaHandle;
	public static Item plasmaCore;
	public static Item plasmaBeamDirector;
	
	//Initialize Items
	public static void init() {
		platinumIngot = new ItemModIngot("Platinum_Ingot");
		platinumNugget = new ItemModNugget("Platinum_Nugget", "Platinum_Nugget");
		plasmaIngot = new ItemModIngot("plasma_ingot");
		platinumStick = new Item().setUnlocalizedName("platinum_stick").setRegistryName(new ResourceLocation(Reference.MODID, "platinum_stick"));
		heart = new ItemHeart("heart");
		infinityFlame = new Item().setUnlocalizedName("infinity_flame").setRegistryName(new ResourceLocation(Reference.MODID, "infinity_flame"));
		plasmaHandle = new ItemPlasmaHandle("plasma_handle", new ItemStack(ModItems.plasmaCore));
		plasmaCore = new Item().setUnlocalizedName("plasma_core").setRegistryName(new ResourceLocation(Reference.MODID, "plasma_core"));
		plasmaBeamDirector = new Item().setUnlocalizedName("plasma_beam_director").setRegistryName(new ResourceLocation(Reference.MODID, "plasma_beam_director"));
	}
	
	//Register Items
		public static void register() {
			registerItem(platinumIngot);
			registerItem(platinumNugget);
			registerItem(plasmaIngot);
			registerItem(platinumStick);
			registerItem(heart);
			registerItem(infinityFlame);
			registerItem(plasmaHandle);
			registerItem(plasmaCore);
			registerItem(plasmaBeamDirector);
		}
		
	
	public static void registerRenders() {
		registerRender(platinumIngot);
		registerRender(platinumNugget);
		registerRender(plasmaIngot);
		registerRender(platinumStick);
		registerRender(heart);
		registerRender(infinityFlame);
		registerRender(plasmaHandle);
		registerRender(plasmaCore);
		registerRender(plasmaBeamDirector);
	}


	public static void registerItem(Item item) {
		item.setCreativeTab(BasicallyAnything.items);
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
