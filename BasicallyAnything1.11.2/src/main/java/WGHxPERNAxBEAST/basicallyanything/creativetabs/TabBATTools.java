package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabBATTools extends CreativeTabs{

	public TabBATTools() {
		super("BAT Tools");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModTools.platinumPickaxe);
	}

}
