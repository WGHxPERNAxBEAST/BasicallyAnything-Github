package WGHxPERNAxBEAST.basicallyanything;

import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATArmor;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATBlocks;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATCombat;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATFood;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATItems;
import WGHxPERNAxBEAST.basicallyanything.creativetabs.TabBATTools;
import WGHxPERNAxBEAST.basicallyanything.handlers.AchievementHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.FuelHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.OreDictionaryHandler;
import WGHxPERNAxBEAST.basicallyanything.handlers.RecipeHandler;
import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class BasicallyAnything {
	
	public static final CreativeTabs blocks = new TabBATBlocks();
	public static final CreativeTabs items = new TabBATItems();
	public static final CreativeTabs tools = new TabBATTools();
	public static final CreativeTabs armor = new TabBATArmor();
	public static final CreativeTabs combat = new TabBATCombat();
	public static final CreativeTabs food = new TabBATFood();
	
	WGHxPERNAxBEAST.basicallyanything.handlers.EventHandler eventHandler = new WGHxPERNAxBEAST.basicallyanything.handlers.EventHandler();
	
	@Mod.Instance(Reference.MODID)
	public static BasicallyAnything instance;
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		//////////////////Initialization//////////////////////////////////////////
		ModItems.init();
		ModBlocks.init();
		ModTools.init();
		ModArmor.init();
		ModCombat.init();
		ModFood.init();
		
		//////////////////REGISTER////////////////////////////////////////////////		
		ModItems.register();
		ModBlocks.register();
		ModTools.register();
		ModArmor.register();
		ModCombat.register();
		ModFood.register();
		
	proxy.registerRenders();
	proxy.registerTileEntities();
	
	AchievementHandler.registerAchievements(); 
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerFuelHandler(new FuelHandler());
		OreDictionaryHandler.registerOreDictionary();
		proxy.init();
		proxy.registerModelBakeryVarients();
		eventHandler.registerEvents();
		RecipeHandler.registerCraftingRecipes();
		RecipeHandler.registerSmeltingRecipes();
		
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}

