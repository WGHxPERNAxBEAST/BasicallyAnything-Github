package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabBATArmor extends CreativeTabs{

	public TabBATArmor() {
		super("BAT Armor");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.IRON_CHESTPLATE);
	}

}
