package WGHxPERNAxBEAST.basicallyanything.proxy;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
		ModArmor.registerRenders();
		ModCombat.registerRenders();
	}
	
	@Override
	public void registerModelBakeryVarients() {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.platinum_nugget_ore), new ResourceLocation(Reference.MODID, "platinum_nugget_ore_overworld"), new ResourceLocation(Reference.MODID, "platinum_nugget_ore_nether"), new ResourceLocation(Reference.MODID, "platinum_nugget_ore_end"));
	}

}
