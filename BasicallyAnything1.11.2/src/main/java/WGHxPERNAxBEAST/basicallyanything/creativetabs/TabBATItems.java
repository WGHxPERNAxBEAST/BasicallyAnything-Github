package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabBATItems extends CreativeTabs{

	public TabBATItems() {
		super("BAT Items");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.platinumIngot);
	}

}
