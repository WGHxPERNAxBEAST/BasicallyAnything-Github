package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabBATCombat extends CreativeTabs{

	public TabBATCombat() {
		super("BAT Combat");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModCombat.platinumSword);
	}

}
