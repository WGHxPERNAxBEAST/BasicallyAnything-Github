package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabBATFood extends CreativeTabs{

	public TabBATFood() {
		super("BAT Food");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModFood.platinumApple);
	}
	
}
