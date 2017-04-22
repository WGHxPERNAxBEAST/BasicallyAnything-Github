package WGHxPERNAxBEAST.basicallyanything.handlers;

import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	public static void registerOreDictionary() {
		
		OreDictionary.registerOre("ingotPlatinum", ModItems.platinumIngot);
		OreDictionary.registerOre("nuggetPlatinum", ModItems.platinumNugget);
		OreDictionary.registerOre("blockPlatinum", ModBlocks.platinum_block);
	}

}
