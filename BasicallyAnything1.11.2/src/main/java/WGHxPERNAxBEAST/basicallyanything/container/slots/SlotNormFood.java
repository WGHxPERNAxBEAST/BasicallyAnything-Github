package WGHxPERNAxBEAST.basicallyanything.container.slots;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotNormFood extends SlotItemHandler {

	public SlotNormFood(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
	/*
	 * please help with getting this slot to accept anything oredictioaried as "normFood"
	 */
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return super.isItemValid(stack) && stack.getItem() == "normFood";
		
	}

}