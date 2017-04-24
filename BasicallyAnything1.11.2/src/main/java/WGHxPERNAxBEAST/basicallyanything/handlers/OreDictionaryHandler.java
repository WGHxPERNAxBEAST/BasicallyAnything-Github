package WGHxPERNAxBEAST.basicallyanything.handlers;

import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	public static void registerOreDictionary() {
		
		OreDictionary.registerOre("ingotPlatinum", ModItems.platinumIngot);
		OreDictionary.registerOre("nuggetPlatinum", ModItems.platinumNugget);
		OreDictionary.registerOre("blockPlatinum", ModBlocks.platinum_block);
		OreDictionary.registerOre("orePlatinum", ModBlocks.platinum_ore);

		OreDictionary.registerOre("normFood", Items.APPLE);
		OreDictionary.registerOre("normFood", Items.BAKED_POTATO);
		OreDictionary.registerOre("normFood", Items.BEEF);
		OreDictionary.registerOre("normFood", Items.BEETROOT);
		OreDictionary.registerOre("normFood", Items.BEETROOT_SOUP);
		OreDictionary.registerOre("normFood", Items.BREAD);
		OreDictionary.registerOre("normFood", Items.CARROT);
		OreDictionary.registerOre("normFood", Items.CHICKEN);
		OreDictionary.registerOre("normFood", Items.COOKED_BEEF);
		OreDictionary.registerOre("normFood", Items.COOKED_CHICKEN);
		OreDictionary.registerOre("normFood", Items.COOKED_FISH);
		OreDictionary.registerOre("normFood", Items.COOKED_MUTTON);
		OreDictionary.registerOre("normFood", Items.COOKED_PORKCHOP);
		OreDictionary.registerOre("normFood", Items.COOKED_RABBIT);
		OreDictionary.registerOre("normFood", Items.COOKIE);
		OreDictionary.registerOre("normFood", Items.FISH);
		OreDictionary.registerOre("normFood", Items.MELON);
		OreDictionary.registerOre("normFood", Items.MUSHROOM_STEW);
		OreDictionary.registerOre("normFood", Items.MUTTON);
		OreDictionary.registerOre("normFood", Items.PORKCHOP);
		OreDictionary.registerOre("normFood", Items.POTATO);
		OreDictionary.registerOre("normFood", Items.PUMPKIN_PIE);
		OreDictionary.registerOre("normFood", Items.SPECKLED_MELON);
		OreDictionary.registerOre("normFood", ModFood.niceBiscuit);
		
		OreDictionary.registerOre("chipBasic", new ItemStack(ModItems.chip, 1, 0)); //Basic Chip
		OreDictionary.registerOre("chipAdvanced", new ItemStack(ModItems.chip, 1, 1)); //Advanced Chip

	}

}
