package WGHxPERNAxBEAST.basicallyanything.proxy;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.handlers.FuelHandler;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityFeeder;
import WGHxPERNAxBEAST.basicallyanything.worldgen.OreGen;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void init() {

	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityFeeder.class, Reference.MODID + ":feeder");
	}

	public void registerRenders() {
		
	}
	
	public void registerModelBakeryVarients() {
		
	}
	
}
