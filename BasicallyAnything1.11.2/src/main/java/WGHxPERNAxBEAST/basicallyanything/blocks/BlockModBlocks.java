package WGHxPERNAxBEAST.basicallyanything.blocks;

import java.util.Random;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockModBlocks   extends Block {

	public BlockModBlocks(String unlocalizedName, String registryName, Material material, int hardness, int resistance) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
}
