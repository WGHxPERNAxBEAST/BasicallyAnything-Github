package WGHxPERNAxBEAST.basicallyanything.Items;

import java.util.Set;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.handlers.BatSoundHandler;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModTabless;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.If;

public class ItemPlasmaBeam extends ItemTool {
	
	public static BlockPos pos;

	public ItemPlasmaBeam(float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn, Set<Block> effectiveBlocksIn, String unlocalizedName) {
		super(attackDamageIn, attackSpeedIn, materialIn, effectiveBlocksIn);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		new ItemStack(ModItems.plasmaHandle).setTagCompound(new ItemStack(this).getTagCompound());
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		pos = playerIn.getPosition();
		if(playerIn.getHeldItemOffhand() != new ItemStack(Items.SHIELD)){
			playerIn.replaceItemInInventory(EntityEquipmentSlot.MAINHAND.getSlotIndex(), new ItemStack(new ItemStack(ModItems.plasmaHandle).getTagCompound()));
			worldIn.playSound(playerIn, pos, BatSoundHandler.PLASMA_DEACTIVATE, SoundCategory.PLAYERS, 2.0F, 1.0F);
		}
		else {

		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	
	
}
