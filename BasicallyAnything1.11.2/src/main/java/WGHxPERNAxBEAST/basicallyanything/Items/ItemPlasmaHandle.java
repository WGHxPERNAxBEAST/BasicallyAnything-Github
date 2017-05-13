package WGHxPERNAxBEAST.basicallyanything.Items;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.handlers.BatSoundHandler;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModTabless;
import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;

public class ItemPlasmaHandle extends Item {
	
	public static BlockPos pos;
	
	public ItemPlasmaHandle(String unlocalizedName, ItemStack repair) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.getIsRepairable(new ItemStack(this), repair);
		new ItemStack(ModTabless.PlasmaBeam).setTagCompound(new ItemStack(this).getTagCompound());
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return super.getIsRepairable(toRepair, repair);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		pos = playerIn.getPosition();
		playerIn.replaceItemInInventory(EntityEquipmentSlot.MAINHAND.getSlotIndex(), new ItemStack(ModTabless.PlasmaBeam));
		worldIn.playSound(playerIn, pos, BatSoundHandler.PLASMA_IGNITION, SoundCategory.PLAYERS, 2.0F, 1.0F);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}

