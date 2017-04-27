package WGHxPERNAxBEAST.basicallyanything.Items;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemModShovel extends ItemSpade {

	public ItemModShovel(ToolMaterial material, String unlocalizedName, ItemStack repair) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.getIsRepairable(new ItemStack(this), repair);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return super.getIsRepairable(toRepair, repair);
	}
	
}
