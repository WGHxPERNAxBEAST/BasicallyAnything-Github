package WGHxPERNAxBEAST.basicallyanything;

import WGHxPERNAxBEAST.basicallyanything.client.gui.GuiHandler;
import WGHxPERNAxBEAST.basicallyanything.config.BatConfig;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATArmor;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATBlocks;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATCombat;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATFood;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATItems;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATMachines;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATTools;
import WGHxPERNAxBEAST.basicallyanything.handlers.AchievementHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.BatSoundHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.FuelHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.OreDictionaryHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.RecipeHandler;
import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCapabilities;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModMachines;
import WGHxPERNAxBEAST.basicallyanything.init.ModTabless;
import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import WGHxPERNAxBEAST.basicallyanything.proxy.CommonProxy;
import WGHxPERNAxBEAST.basicallyanything.worldgen.OreGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class BasicallyAnything {
	
	public static final CreativeTabs machines = new TabBATMachines();
	public static final CreativeTabs blocks = new TabBATBlocks();
	public static final CreativeTabs items = new TabBATItems();
	public static final CreativeTabs tools = new TabBATTools();
	public static final CreativeTabs combat = new TabBATCombat();
	public static final CreativeTabs armor = new TabBATArmor();
	public static final CreativeTabs food = new TabBATFood();
	
	WGHxPERNAxBEAST.basicallyanything.handlers.EventHandler eventHandler = new WGHxPERNAxBEAST.basicallyanything.handlers.EventHandler();
	
	@Mod.Instance(Reference.MODID)
	public static BasicallyAnything instance;
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		//////////////////Initialization//////////////////////////////////////////
		ModMachines.init();
		ModItems.init();
		ModBlocks.init();
		ModTools.init();
		ModArmor.init();
		ModCombat.init();
		ModFood.init();
		ModTabless.init();
		
		//////////////////REGISTER////////////////////////////////////////////////		
		ModMachines.register();
		ModItems.register();
		ModBlocks.register();
		ModTools.register();
		ModArmor.register();
		ModCombat.register();
		ModFood.register();
		ModTabless.register();
		
		BatConfig.preInit();
		proxy.preInit();
		proxy.registerRenders();
		proxy.registerTileEntities();

	
	NetworkRegistry.INSTANCE.registerGuiHandler(BasicallyAnything.instance, new GuiHandler());
	ModCapabilities.registerCapabilities();
	
	AchievementHandler.registerAchievements(); 
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerFuelHandler(new FuelHandler());
		OreDictionaryHandler.registerOreDictionary();
		proxy.registerModelBakeryVarients();
		eventHandler.registerEvents();
		RecipeHandler.registerCraftingRecipes();
		RecipeHandler.registerFurnaceRecipes();
		BatSoundHandler.init();
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}

