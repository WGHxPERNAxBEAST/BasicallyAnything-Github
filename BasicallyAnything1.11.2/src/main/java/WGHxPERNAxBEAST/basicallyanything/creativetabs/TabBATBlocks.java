package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabBATBlocks extends CreativeTabs{

	public TabBATBlocks() {
		super("BAT Blocks");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.platinum_block);
	}

}
