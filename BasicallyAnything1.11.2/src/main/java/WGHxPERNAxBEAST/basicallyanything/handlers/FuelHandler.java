package WGHxPERNAxBEAST.basicallyanything.handlers;

import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == ModItems.infinityFlame) {
			return (int) Math.pow(2, 31); //This is a very big number which will work on both 32 and 64 bit computers
		}
		return 0;
	}

}
