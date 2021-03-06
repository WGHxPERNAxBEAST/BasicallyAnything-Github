package WGHxPERNAxBEAST.basicallyanything.container.slots;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.oredict.OreDictionary;

public class SlotNormFood extends SlotItemHandler {

	public SlotNormFood(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		boolean valid = false;
		for(int id : OreDictionary.getOreIDs(stack))
			if(id == OreDictionary.getOreID("normFood"))
				valid = true;
		return valid && super.isItemValid(stack);
	}

}