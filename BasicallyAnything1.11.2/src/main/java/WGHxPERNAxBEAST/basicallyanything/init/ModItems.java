package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemChip;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemHeart;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModIngot;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModItem;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModNugget;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemPaintBrush;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemPlasmaHandle;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemTinIngot;
import WGHxPERNAxBEAST.basicallyanything.handlers.EnumHandler;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	//State Items
	public static Item platinumIngot;
	public static Item platinumNugget;
	public static Item tinIngot;
	public static Item tinNugget; 
	public static Item tinStick;
	public static Item plasmaIngot;
	public static Item platinumStick;
	public static Item heart;
	public static Item infinityFlame;
	public static Item paintBrush;
	public static Item fabric;
	public static Item plasmaHandle;
	public static Item plasmaCore;
	public static Item plasmaBeamDirector;
	
	//Initialize Items
	public static void init() {
		platinumIngot = new ItemModIngot("Platinum_Ingot", "Platinum_Ingot");
		platinumNugget = new ItemModNugget("Platinum_Nugget", "Platinum_Nugget");
		tinIngot = new ItemTinIngot("tin_ingot", "tin_ingot");
		plasmaIngot = new ItemModIngot("plasma_ingot", "plasma_ingot");
		platinumStick = new Item().setUnlocalizedName("platinum_stick").setRegistryName(new ResourceLocation(Reference.MODID, "platinum_stick"));
		heart = new ItemHeart("heart");
		infinityFlame = new Item().setUnlocalizedName("infinity_flame").setRegistryName(new ResourceLocation(Reference.MODID, "infinity_flame"));
		tinNugget = new Item().setUnlocalizedName("tin_nugget").setRegistryName(new ResourceLocation(Reference.MODID, "tin_nugget"));
		paintBrush = new ItemPaintBrush("paint_brush");
		fabric = new Item().setUnlocalizedName("fabric").setRegistryName(new ResourceLocation(Reference.MODID, "fabric"));
		tinStick = new Item().setUnlocalizedName("tin_stick").setRegistryName(new ResourceLocation(Reference.MODID, "tin_stick"));
		plasmaHandle = new ItemPlasmaHandle("Plasma_Handle", new ItemStack(ModItems.plasmaCore));
		plasmaCore = new Item().setUnlocalizedName("plasma_core").setRegistryName(new ResourceLocation(Reference.MODID, "plasma_core"));
		plasmaBeamDirector = new Item().setUnlocalizedName("plasma_beam_director").setRegistryName(new ResourceLocation(Reference.MODID, "plasma_beam_director"));
	}
	
	//Register Items
		public static void register() {
			registerItem(platinumIngot);
			registerItem(platinumNugget);
			registerItem(plasmaIngot);
			registerItem(platinumStick);
			registerItem(tinIngot);
			registerItem(heart);
			registerItem(infinityFlame);
			registerItem(tinNugget);
			registerItem(paintBrush);
			registerItem(fabric);
			registerItem(tinStick);
			registerItem(plasmaHandle);
			registerItem(plasmaCore);
			registerItem(plasmaBeamDirector);
		}
		
	
	public static void registerRenders() {
		registerRender(platinumIngot);
		registerRender(platinumNugget);
		registerRender(plasmaIngot);
		registerRender(platinumStick);
		registerRender(tinIngot);
		registerRender(heart);
		registerRender(infinityFlame);
		registerRender(tinNugget);
		registerRender(paintBrush);
		registerRender(fabric);
		registerRender(tinStick);
		registerRender(plasmaHandle);
		registerRender(plasmaCore);
		registerRender(plasmaBeamDirector);
	}

/**
	 * Register that the item has a colour and state what the colour is
	 */
	@SideOnly(Side.CLIENT)
	public static void registerItemColours() {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
			
			@Override
			public int getColorFromItemstack(ItemStack stack, int tintIndex) {
				if(stack.hasTagCompound() && tintIndex == 1)
					if(stack.getTagCompound().hasKey("colour"))
						return stack.getTagCompound().getInteger("colour");
				return 0xFFFFFF;
			}
		}, paintBrush);
		Utils.getLogger().info("Registered item colours!");
	
	Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor() {
		
		public int getColorFromItemstack(ItemStack stack, int tintIndex) {
			if(stack.hasTagCompound() && tintIndex == 1)
				if(stack.getTagCompound().hasKey("colour"))
					return stack.getTagCompound().getInteger("colour");
			return 0x0b27cd;
		}
	}, platinumIngot);
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
