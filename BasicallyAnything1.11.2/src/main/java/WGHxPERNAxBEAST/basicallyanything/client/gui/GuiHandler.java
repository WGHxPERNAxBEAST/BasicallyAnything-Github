package WGHxPERNAxBEAST.basicallyanything.client.gui;

import WGHxPERNAxBEAST.basicallyanything.container.ContainerBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.container.ContainerFeeder;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityBlockBreaker;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityFeeder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	/**
	 * Each gui needs an ID
	 */
	public static final int BLOCK_BREAKER = 0;
	public static final int FEEDER = 1;
	
	/**
	 * Should return the container for that gui. This is called server side because servers handle items in guis
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_BREAKER) {
			return new ContainerBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID == FEEDER) {
			return new ContainerFeeder(player.inventory, (TileEntityFeeder) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
	

	/**
	 * Should return the actual gui. This is called client side as thats where guis are rendered
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_BREAKER) {
			return new GuiBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID == FEEDER) {
			return new GuiFeeder(player.inventory, (TileEntityFeeder) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}