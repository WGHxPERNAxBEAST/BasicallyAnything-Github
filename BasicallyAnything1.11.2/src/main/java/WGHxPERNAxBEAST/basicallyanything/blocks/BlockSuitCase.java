package WGHxPERNAxBEAST.basicallyanything.blocks;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.blocks.material.ModMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class BlockSuitCase extends Block {

	public BlockSuitCase(String unlocalizedName, String registryName) {
		super(ModMaterial.Platinum);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(2);
		this.setResistance(15);
	}

}
