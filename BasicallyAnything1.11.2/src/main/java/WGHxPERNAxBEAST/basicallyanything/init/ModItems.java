package WGHxPERNAxBEAST.basicallyanything.init;

import WGHxPERNAxBEAST.basicallyanything.BasicallyAnything;
import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemChip;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemHeart;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModIngot;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModItem;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemModNugget;
import WGHxPERNAxBEAST.basicallyanything.Items.ItemPaintBrush;
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
	public static Item machine_core;
	public static Item tinIngot;
	public static Item heart;
	public static Item chip;
	public static Item infinityFlame;
	public static Item tinNugget;
	public static Item paintBrush;
	public static Item fabric;
	public static Item tinStick;


	
	//Initialize Items
	public static void init() {
		platinumIngot = new ItemModIngot("Platinum_Ingot", "Platinum_Ingot");
		platinumNugget = new ItemModNugget("Platinum_Nugget", "Platinum_Nugget");
		chip = new ItemChip("chip");
		machine_core = new ItemModItem("machine_core");
		tinIngot = new ItemTinIngot("tin_ingot", "tin_ingot");
		heart = new ItemHeart("heart");
		infinityFlame = new Item().setUnlocalizedName("infinity_flame").setRegistryName(new ResourceLocation(Reference.MODID, "infinity_flame"));
		tinNugget = new Item().setUnlocalizedName("tin_nugget").setRegistryName(new ResourceLocation(Reference.MODID, "tin_nugget"));
		paintBrush = new ItemPaintBrush("paint_brush");
		fabric = new Item().setUnlocalizedName("fabric").setRegistryName(new ResourceLocation(Reference.MODID, "fabric"));
		tinStick = new Item().setUnlocalizedName("tin_stick").setRegistryName(new ResourceLocation(Reference.MODID, "tin_stick"));


	}
	
	//Register Items
		public static void register() {
			registerItem(platinumIngot);
			registerItem(platinumNugget);
			registerItem(chip);
			registerItem(machine_core);
			registerItem(tinIngot);
			registerItem(heart);
			registerItem(infinityFlame);
			registerItem(tinNugget);
			registerItem(paintBrush);
			registerItem(fabric);
			registerItem(tinStick);

		}
		
	
	public static void registerRenders() {
		registerRender(platinumIngot);
		registerRender(platinumNugget);
		registerRender(machine_core);
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(chip, i, "chip_" + EnumHandler.ChipTypes.values()[i].getName());
		}
		registerRender(tinIngot);
		registerRender(heart);
		registerRender(infinityFlame);
		registerRender(tinNugget);
		registerRender(paintBrush);
		registerRender(fabric);
		registerRender(tinStick);

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
