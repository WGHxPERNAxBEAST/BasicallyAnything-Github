package WGHxPERNAxBEAST.basicallyanything.Items;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemModIngot extends Item {
	
	public ItemModIngot(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		
	}

}
