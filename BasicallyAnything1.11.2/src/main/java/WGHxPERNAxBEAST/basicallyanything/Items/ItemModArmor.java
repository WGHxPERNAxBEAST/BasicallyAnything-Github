package WGHxPERNAxBEAST.basicallyanything.Items;

import java.util.Iterator;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.handlers.AchievementHandler;
import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModArmor extends ItemArmor{

	public ItemModArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		int PlatinumArmorPeices = 0;
		if(player.getArmorInventoryList() != null) {
			Iterator<ItemStack> iterator = player.getArmorInventoryList().iterator();
			while(iterator.hasNext()) {
				ItemStack stack = iterator.next();
				if(stack != null) {
					if(stack.getItem() instanceof ItemModArmor) {
						ItemModArmor item = (ItemModArmor) stack.getItem();
						if(item.getArmorMaterial() == ModArmor.PlatinumMaterial) {
							PlatinumArmorPeices++;
							continue;
						}
					}
				}
			}
		}
		if(PlatinumArmorPeices == 4) {
			if(!player.hasAchievement(AchievementHandler.achievementPlatinumPlated)) {
				player.addStat(AchievementHandler.achievementPlatinumPlated);
			}
		}
	}

	
	}