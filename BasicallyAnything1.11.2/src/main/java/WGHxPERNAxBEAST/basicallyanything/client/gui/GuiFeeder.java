package WGHxPERNAxBEAST.basicallyanything.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.container.ContainerFeeder;
import WGHxPERNAxBEAST.basicallyanything.tileentity.TileEntityFeeder;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.items.CapabilityItemHandler;

public class GuiFeeder  extends GuiContainer {
	

	/**
	 * The tile entity and player inventory
	 */
	private TileEntityFeeder te;
	private IInventory playerInv;
	private GuiTextField text;
	 
	/**
	 * Typical {@link GuiContainer} constructor
	 * @param playerInv The players inventory
	 * @param te The tile entity
	 */
	public GuiFeeder(IInventory playerInv, TileEntityFeeder te) {
		super(new ContainerFeeder(playerInv, te));
		
		this.xSize = 176; //Texture xSize
		this.ySize = 166; //Texture ySize
		
		this.te = te;
		this.playerInv = playerInv;
	}

	/**
	 * Draws the gui and the grey background behind it
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); //Grey background
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/Feeder.png")); //Binds the texture for rendering
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
	}
	
	/**
	 * Draws the text that is an overlay, i.e where it says Block Breaker in the gui on the top
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("container.Feeder"); //Gets the formatted name for the feeder from the language file
		this.mc.fontRendererObj.drawString(s, this.xSize / 2 - this.mc.fontRendererObj.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
		int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
		int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
	}
	
	public void initGui()
    {
        this.text = new GuiTextField(guiLeft, this.fontRendererObj, this.width / 2 - 68, this.height/2-46, 137, 20);
        text.setMaxStringLength(23);
        text.setText("Player Name Here");
        this.text.setFocused(true);
    }
 
protected void keyTyped(char par1, int par2)
    {
        try {
			super.keyTyped(par1, par2);
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.text.textboxKeyTyped(par1, par2);
    }
 
    public void updateScreen()
    {
        super.updateScreen();
        this.text.updateCursorCounter();
    }
 
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.text.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }
 
    protected void mouseClicked(int x, int y, int btn) {
        try {
			super.mouseClicked(x, y, btn);
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.text.mouseClicked(x, y, btn);
    }


}