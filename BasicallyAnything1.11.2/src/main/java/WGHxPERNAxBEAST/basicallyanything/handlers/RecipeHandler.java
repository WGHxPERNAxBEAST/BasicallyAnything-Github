package WGHxPERNAxBEAST.basicallyanything.handlers;



import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModMachines;
import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import WGHxPERNAxBEAST.basicallyanything.util.RecipeClearColour;
import WGHxPERNAxBEAST.basicallyanything.util.RecipeItemColour;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeHandler {

	public static void registerCraftingRecipes() {

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModFood.platinumApple),
				new Object[] { "PPP", "PGP", "PPP", 'P', "blockPlatinum", 'G', Items.GOLDEN_APPLE}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.platinum_block),
				new Object[] { "PPP", "PPP", "PPP", 'P', ModItems.platinumIngot }));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.platinumIngot, 9),
				new Object[] { ModBlocks.platinum_block });
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumIngot),
				new Object[] { "NNN", "NNN", "NNN", 'N', ModItems.platinumNugget}));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.platinumNugget, 9),
				new Object[] { ModItems.platinumIngot });
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.plasmaIngot), 
				new Object[] {"TP", "PT", 'T', "ingotTin", 'P', "ingotPlatinum"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.feeder),
				new Object[] { "FNF", "NCN", "FNF", 'N', "normFood", 'F',  "machineframeAdvanced", 'C', "machinecoreAdvanced" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.machine_core, 1, 0), 
				new Object[] { "TDT", "RCR", "TDT", 'T', "ingotPlatinum", 'D', "dustRedstone", 'C', Items.COMPARATOR, 'R', Items.REPEATER }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.machine_core, 1, 1), 
				new Object[] { "TDT", "RCR", "TDT", 'T', "ingotPlatinum", 'D', Items.REPEATER, 'C', "machinecoreBasic", 'R', Items.COMPARATOR }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.chip, 1, 0), 
				new Object[] { "TRT", "RGR", "TRT", 'T', "ingotPlatinum", 'R', "machinecoreBasic", 'G', "dyeRed" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.chip, 1, 1), 
				new Object[] { "TRT", "RCR", "TRT", 'T', "ingotPlatinum", 'R', "machinecoreAdvanced", 'C', "chipBasic" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.plasmaHandle),
				new Object[] { "SDS", "SCS", "SIS", 'S', "stickPlatinum", 'D',  ModItems.plasmaBeamDirector, 'C', ModItems.plasmaCore, 'I', "ingotPlatinum" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.plasmaBeamDirector), 
				new Object[] {" G ", "GGG", " G ", 'G', "blockGlass"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.plasmaCore),
				new Object[] { "CCC", "CPC", "CFC", 'C', "blockCoal", 'P', "ingotPlasma", 'F', ModItems.infinityFlame }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.plasmaLantern),
				new Object[] { "NGN", "GCG", "NGN", 'C', ModItems.plasmaCore, 'N', "nuggetPlatinum", 'G', "paneGlass" }));

	
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.machine_frame, 1, 0), 
				new Object[] { "TTT", "TCT", "TTT", 'T', "blockPlatinum", 'C', "chipBasic" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.machine_frame, 1, 1), 
				new Object[] { "TTT", "TCT", "TTT", 'T', "blockPlatinum", 'C', "chipAdvanced" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.platinumStick, 4), 
				new Object[] {"T", "T", 'T', "ingotPlatinum"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.breaker, 1, 0), 
				new Object[] { "MMM", "PCP", "MMM", 'P', ModTools.platinumPickaxe, 'M', "machineframeBasic", 'C', "machinecoreBasic" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModMachines.breaker, 1, 1), 
				new Object[] { "MMM", "BCB", "MMM", 'B', "blockBreakerBasic", 'M', "machineframeAdvanced", 'C', "machinecoreAdvanced" }));
		
		registerToolRecipe("blockPlatinum", ModTools.platinumPickaxe, ModTools.platinumAxe, ModTools.platinumShovel, ModTools.platinumHoe, ModCombat.platinumSword, ModItems.platinumStick);
		registerArmorRecipe("blockPlatinum", ModArmor.PlatinumHelmet, ModArmor.PlatinumChestplate, ModArmor.PlatinumLeggings, ModArmor.PlatinumBoots);

			Utils.getLogger().info("Registered Crafting Recipes!");
	}

	public static void registerFurnaceRecipes() {
		GameRegistry.addSmelting(ModBlocks.platinum_ore, new ItemStack(ModItems.platinumIngot), 3.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.platinum_nugget_ore, 1, 0), new ItemStack(ModItems.platinumNugget), 0.4F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.platinum_nugget_ore, 1, 1), new ItemStack(ModItems.platinumNugget), 0.4F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.platinum_nugget_ore, 1, 2), new ItemStack(ModItems.platinumNugget), 0.4F);
		
			Utils.getLogger().info("Registered Furnace Recipes!");
	}


	/**
	 * Registers a tool using the ingot from the {@link OreDictionary}
	 * @param ingotOD The ingot from the {@link OreDictionary}
	 * @param pickaxe The pickaxe
	 * @param axe The axe
	 * @param shovel The shovel
	 * @param hoe The hoe
	 * @param sword The sword
	 * @param stickOD The stick from the {@link OreDictionary}
	 */
	private static void registerToolRecipe(String ingotOD, Item pickaxe, Item axe, Item shovel, Item hoe, Item sword, Item stickOD) {
		GameRegistry.addRecipe(new ShapedOreRecipe(pickaxe, new Object[] { "III", " S ", " S ", 'I', ingotOD, 'S', stickOD }));
		GameRegistry.addRecipe(new ShapedOreRecipe(axe, new Object[] { "II ", "IS ", " S ", 'I', ingotOD, 'S', stickOD }));
		GameRegistry.addRecipe(new ShapedOreRecipe(axe, new Object[] { " II", " SI", " S ", 'I', ingotOD, 'S', stickOD }));
		GameRegistry.addRecipe(new ShapedOreRecipe(shovel, new Object[] { " I ", " S ", " S ", 'I', ingotOD, 'S', stickOD }));
		GameRegistry.addRecipe(new ShapedOreRecipe(hoe, new Object[] { " II", " S ", " S ", 'I', ingotOD, 'S', stickOD }));
		GameRegistry.addRecipe(new ShapedOreRecipe(hoe, new Object[] { "II ", " S ", " S ", 'I', ingotOD, 'S', stickOD }));
		GameRegistry.addRecipe(new ShapedOreRecipe(sword, new Object[] { " I ", " I ", " S ", 'I', ingotOD, 'S', stickOD }));
	}
	
	/**
	 * Registers Armor using the ingot
	 * @param ingot The ingot
	 * @param helmet The helmet
	 * @param chestplate The chestplate
	 * @param leggings The leggings
	 * @param boots The boots
	 */
	public static void registerArmorRecipe(Item ingot, Item helmet, Item chestplate, Item leggings, Item boots) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',ingot});
	}
	
	/**
	 * Registers Armor using the ingot from the {@link OreDictionary}
	 * @param ingotOD The ingot from the {@link OreDictionary}
	 * @param helmet The helmet
	 * @param chestplate The chestplate
	 * @param leggings The leggings
	 * @param boots The boots
	 */
	public static void registerArmorRecipe(String ingotOD, Item helmet, Item chestplate, Item leggings, Item boots) {
		GameRegistry.addRecipe(new ShapedOreRecipe(helmet, new Object[] { "III","I I","   ",'I',ingotOD}));
		GameRegistry.addRecipe(new ShapedOreRecipe(helmet, new Object[] { "   ","III","I I",'I',ingotOD}));
		GameRegistry.addRecipe(new ShapedOreRecipe(chestplate, new Object[] { "I I","III","III",'I',ingotOD}));
		GameRegistry.addRecipe(new ShapedOreRecipe(leggings, new Object[] { "III","I I","I I",'I',ingotOD}));
		GameRegistry.addRecipe(new ShapedOreRecipe(boots, new Object[] { "I I","I I","   ",'I',ingotOD}));
		GameRegistry.addRecipe(new ShapedOreRecipe(boots, new Object[] { "   ","I I","I I",'I',ingotOD}));
	}
	}

