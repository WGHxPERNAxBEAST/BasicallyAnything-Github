package WGHxPERNAxBEAST.basicallyanything.proxy;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.config.BatConfig;
import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModMachines;
import WGHxPERNAxBEAST.basicallyanything.init.ModTabless;
import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy {

/**
	 * Everything that should be ran client side only in the pre initialization phase
	 */
	public void preInit() {
		ModBlocks.createStateMappers();
		ModMachines.createStateMappers();
		BatConfig.clientPreInit();
	}
	
	/**
	 * Everything that should be ran client side only in the initialization phase
	 */
	@Override
	public void init() {
		ModBlocks.registerBlockColours();
		ModItems.registerItemColours();
		ModTools.registerItemColours();
	}

	
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
		ModArmor.registerRenders();
		ModCombat.registerRenders();
		ModMachines.registerRenders();
		ModTabless.registerRenders();
		ModFood.registerRenders();
	}
	
	@Override
	public void registerModelBakeryVarients() {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.platinum_nugget_ore), new ResourceLocation(Reference.MODID, "platinum_nugget_ore_overworld"), new ResourceLocation(Reference.MODID, "platinum_nugget_ore_nether"), new ResourceLocation(Reference.MODID, "platinum_nugget_ore_end"));

		ModelBakery.registerItemVariants(ModMachines.chip, new ResourceLocation(Reference.MODID, "chip_basic"), new ResourceLocation(Reference.MODID, "chip_advanced"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModMachines.breaker), new ResourceLocation(Reference.MODID, "block_breaker_basic"), new ResourceLocation(Reference.MODID, "block_breaker_advanced"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.tinOre), new ResourceLocation(Reference.MODID, "tin_ore_overworld"), new ResourceLocation(Reference.MODID, "tin_ore_nether"), new ResourceLocation(Reference.MODID, "tin_ore_end"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModMachines.machine_frame), new ResourceLocation(Reference.MODID, "machine_frame_basic"), new ResourceLocation(Reference.MODID, "machine_frame_advanced"));
		ModelBakery.registerItemVariants(ModMachines.machine_core, new ResourceLocation(Reference.MODID, "machine_core_basic"), new ResourceLocation(Reference.MODID, "machine_core_advanced"));
	}

}
