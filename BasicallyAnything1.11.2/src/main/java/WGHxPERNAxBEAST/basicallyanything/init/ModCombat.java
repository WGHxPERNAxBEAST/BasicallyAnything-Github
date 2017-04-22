package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModSword;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCombat {
	
	public static final ToolMaterial platinumMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":platinum", 12, 100000, 20.0F, 18.0F, 90);
	
	public static ItemSword platinumSword;
	
	public static void init(){
		platinumSword = new ItemModSword(platinumMaterial, "Platinum_Sword", new ItemStack(ModItems.platinumIngot));
	}
	
	public static void register() {
		registerItem(platinumSword);
	}
	
	public static void registerRenders(){
		registerRender(platinumSword);
	}
	

	public static void registerItem(Item item) {
		item.setCreativeTab(BasicallyAnything.combat);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
	}
	


}
