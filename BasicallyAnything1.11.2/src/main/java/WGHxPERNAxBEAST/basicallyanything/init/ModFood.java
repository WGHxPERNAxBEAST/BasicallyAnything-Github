package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModFood;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFood {
	//State Items
	public static Item platinumApple;
	public static Item niceBiscuit;
	public static Item tinApple;
	
	
	//Initialize Items
	public static void init() {
		platinumApple = new ItemModFood("Platinum_Apple", 15, 10, false, new PotionEffect(Potion.getPotionById(1), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(3), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(10), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(11), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(16), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(22), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(24), 6000, 2, false, false), new PotionEffect(Potion.getPotionById(26), 6000, 2, false, false));
		niceBiscuit = new ItemModFood("nice_biscuit", 5, 3, false);
		tinApple = new ItemModFood("tin_apple", 4, 4, false, new PotionEffect(Potion.getPotionById(3), 3600, 2), new PotionEffect(Potion.getPotionById(8), 3600, 256, false, false));

	}
	//Register Items
	public static void register() {
		registerItem(platinumApple);
		registerItem(niceBiscuit);
		registerItem(tinApple);
	}
	
	public static void registerRenders() {
		registerRender(platinumApple);
		registerRender(niceBiscuit);
		registerRender(tinApple);
		}
	
	public static void registerItem(Item item) {
		item.setCreativeTab(BasicallyAnything.food);
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

