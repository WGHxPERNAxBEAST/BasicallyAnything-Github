package WGHxPERNAxBEAST.basicallyanything.creativetabs;

import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModMachines;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBATMachines extends CreativeTabs {

	public TabBATMachines() {
		super("BAT Machines");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModMachines.machine_frame, 1, 1);
	}

}
