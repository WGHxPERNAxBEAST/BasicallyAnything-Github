package WGHxPERNAxBEAST.basicallyanything.Items;

import java.util.List;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

/**
 * The paint brush item class
 * @author CJMinecraft
 *
 */
public class ItemPaintBrush extends Item {
	
	/**
	 * Default item constructor
	 * @param unlocalizedName The name of the item
	 */
	public ItemPaintBrush(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setMaxStackSize(1);
	}
	
	/**
	 * Says the colour of item on the tooltip
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.hasTagCompound())
			if(stack.getTagCompound().hasKey("colour"))
				tooltip.add(TextFormatting.GRAY + I18n.format(getUnlocalizedName() + ".tooltip", String.format("#%06X", (0xFFFFFF & stack.getTagCompound().getInteger("colour")))));
	}

}
