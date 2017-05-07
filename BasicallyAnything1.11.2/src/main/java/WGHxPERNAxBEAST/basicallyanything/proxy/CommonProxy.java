package WGHxPERNAxBEAST.basicallyanything.proxy;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.network.PacketHandler;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityCanvas;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityFeeder;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit() {
		PacketHandler.registerMessages(Reference.MODID);
	}
	
	public void init() {

	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityFeeder.class, Reference.MODID + ":feeder");

		GameRegistry.registerTileEntity(TileEntityBlockBreaker.class, Reference.MODID + ":block_breaker");
		
		GameRegistry.registerTileEntity(TileEntityCanvas.class, Reference.MODID + ":canvas");

	}

	public void registerRenders() {
		
	}
	
	public void registerModelBakeryVarients() {
		
	}
	
}
