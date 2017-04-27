package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModArmor;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmor {
	
	public static ArmorMaterial PlatinumMaterial = EnumHelper.addArmorMaterial("Platinum", Reference.MODID + ":Platinum", 50, new int[] {5,12,10,5}, 50, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 20.0F);
	public static ArmorMaterial tinMaterial = EnumHelper.addArmorMaterial("tin", Reference.MODID + ":tin", 15, new int[] {2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);

	
	public static ItemArmor PlatinumHelmet;
	public static ItemArmor PlatinumChestplate;
	public static ItemArmor PlatinumLeggings;
	public static ItemArmor PlatinumBoots;
	public static ItemArmor tinHelmet;
	public static ItemArmor tinChestplate;
	public static ItemArmor tinLeggings;
	public static ItemArmor tinBoots;

	
	public static void init() {
		PlatinumHelmet = new ItemModArmor(PlatinumMaterial, 1, EntityEquipmentSlot.HEAD, "Platinum_Helmet");
		PlatinumChestplate = new ItemModArmor(PlatinumMaterial, 1, EntityEquipmentSlot.CHEST, "Platinum_Chestplate");
		PlatinumLeggings = new ItemModArmor(PlatinumMaterial, 2, EntityEquipmentSlot.LEGS, "Platinum_Leggings");
		PlatinumBoots = new ItemModArmor(PlatinumMaterial, 1, EntityEquipmentSlot.FEET, "Platinum_Boots");
	tinHelmet = new ItemModArmor(tinMaterial, 1, EntityEquipmentSlot.HEAD, "tin_helmet");
		tinChestplate = new ItemModArmor(tinMaterial, 1, EntityEquipmentSlot.CHEST, "tin_chestplate");
		tinLeggings = new ItemModArmor(tinMaterial, 2, EntityEquipmentSlot.LEGS, "tin_leggings");
		tinBoots = new ItemModArmor(tinMaterial, 1, EntityEquipmentSlot.FEET, "tin_boots");

	}
	
	public static void register() {
		registerItem(PlatinumHelmet);
		registerItem(PlatinumChestplate);
		registerItem(PlatinumLeggings);
		registerItem(PlatinumBoots);
		registerItem(tinHelmet);
		registerItem(tinChestplate);
		registerItem(tinLeggings);
		registerItem(tinBoots);
	}
	
	public static void registerRenders() {
		registerRender(PlatinumHelmet);
		registerRender(PlatinumChestplate);
		registerRender(PlatinumLeggings);
		registerRender(PlatinumBoots);
		registerRender(tinHelmet);
		registerRender(tinChestplate);
		registerRender(tinLeggings);
		registerRender(tinBoots);

	}

	public static void registerItem(Item item) {
		item.setCreativeTab(BasicallyAnything.armor);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
	}
	

}
