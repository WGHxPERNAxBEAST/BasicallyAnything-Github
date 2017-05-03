package WGHxPERNAxBEAST.basicallyanything.Items;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModShield extends ItemShield {
	
	private PotionEffect[] effects;

	public ItemModShield(String unlocalizedName, ItemStack durability, ItemStack repair, PotionEffect...potionEffects) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.getMaxItemUseDuration(durability);
		this.getIsRepairable(new ItemStack(this), repair);
		this.effects = potionEffects;
	}
	
	@Override
	public Item setCreativeTab(CreativeTabs tab) {
		return super.setCreativeTab(tab);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack durability) {
		return super.getMaxItemUseDuration(durability);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return super.getIsRepairable(toRepair, repair);
	}
	
	protected void onItemUse(ItemStack stack, World worldIn, EntityPlayer player) {
		for(PotionEffect effect : effects) {
			player.addPotionEffect(effect);
		}
	}
	
}