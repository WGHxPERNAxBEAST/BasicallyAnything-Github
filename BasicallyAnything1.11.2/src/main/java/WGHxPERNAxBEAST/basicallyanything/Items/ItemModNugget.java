package WGHxPERNAxBEAST.basicallyanything.Items;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemModNugget extends Item {
	
	public ItemModNugget(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}

}
