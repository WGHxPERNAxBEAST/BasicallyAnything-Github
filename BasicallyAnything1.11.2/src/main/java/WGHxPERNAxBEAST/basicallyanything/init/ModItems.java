package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemChip;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModIngot;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModNugget;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	//State Items
	public static Item platinumIngot;
	public static Item platinumNugget;
	public static Item chip;
	
	//Initialize Items
	public static void init() {
		platinumIngot = new ItemModIngot("Platinum_Ingot", "Platinum_Ingot");
		platinumNugget = new ItemModNugget("Platinum_Nugget", "Platinum_Nugget");
		chip = new ItemChip("chip");
	}
	
	//Register Items
		public static void register() {
			registerItem(platinumIngot);
			registerItem(platinumNugget);
			registerItem(chip);
		}
		
	
	public static void registerRenders() {
		registerRender(platinumIngot);
		registerRender(platinumNugget);
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(chip, i, "chip_" + EnumHandler.ChipTypes.values()[i].getName());
		}
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
