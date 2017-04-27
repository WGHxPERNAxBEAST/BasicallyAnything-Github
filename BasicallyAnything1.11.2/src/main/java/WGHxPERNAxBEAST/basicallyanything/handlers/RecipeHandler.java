package WGHxPERNAxBEAST.basicallyanything.handlers;



import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
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
		GameRegistry.addRecipe(new ItemStack(ModBlocks.platinum_block),
				new Object[] { "PPP", "PPP", "PPP", 'P', "ingotPlatinum" });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.platinumIngot, 9),
				new Object[] { ModBlocks.platinum_block });
		GameRegistry.addRecipe(new ItemStack(ModItems.platinumIngot),
				new Object[] { "NNN", "NNN", "NNN", 'N', "nuggetPlatinum" });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.platinumNugget, 9),
				new Object[] { ModItems.platinumIngot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.machine_frame),
				new Object[] { "PPP", "P P", "PPP", 'P', "ingotPlatinum" });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.feeder),
				new Object[] { "FNF", "NCN", "FNF", 'N', "normFood", 'F',  ModBlocks.machine_frame, 'C', ModItems.machine_core });
		GameRegistry.addRecipe(new ItemStack(ModItems.machine_core),
				new Object[] { "PPP", "RCR", "PPP", 'P', "ingotPlatinum", 'R', Items.REDSTONE, 'C', "chipAdvanced" });
		GameRegistry.addRecipe(new ItemStack(ModItems.chip),
				new Object[] { "PPP", "RRR", "PPP", 'P', "nuggetPlatinum", 'R', Items.REDSTONE });
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.chip, 1, 0), 
				new Object[] { "TRT", "RGR", "TRT", 'T', "ingotPlatinum", 'R', ModItems.machine_core, 'G', "dyeWhite" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.chip, 1, 1), 
				new Object[] { "TRT", "RCR", "TRT", 'T', "ingotPlatinum", 'R', ModItems.machine_core, 'C', "chipBasic" }));

		GameRegistry.addRecipe(new ItemStack(ModCombat.soulStealer), 
				new Object[] { "SAS", "ADA", "SAS", 'S', Items.STICK, 'A', Items.STRING, 'D', Items.DIAMOND });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tinBlock), 
				new Object[] { "TTT", "TTT", "TTT", 'T', ModItems.tinIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tinIngot, 9), 
				new Object[] { ModBlocks.tinBlock });
		GameRegistry.addRecipe(new ItemStack(ModItems.tinIngot), new Object[] { "NNN", "NNN", "NNN", 'N', ModItems.tinNugget });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tinNugget, 9), 
				new Object[] { ModItems.tinIngot });
		GameRegistry.addRecipe(new ShapedOreRecipe(ModFood.tinApple, 
				new Object[] { "III", "IAI", "III", 'I', "blockTin", 'A', Items.APPLE }));
		GameRegistry.addRecipe(new ItemStack(ModItems.infinityFlame), 
				new Object[] { "CCC", "CDC", "CCC", 'C', Blocks.COAL_BLOCK, 'D', Blocks.DIAMOND_BLOCK });
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModFood.niceBiscuit, 4), 
				new Object[] { "cropWheat", "cropWheat" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.machine_frame, 1, 0), 
				new Object[] { "TRT", "TCT", "RIR", 'R', "dustRedstone", 'T', "ingotTin", 'C', "chipBasic", 'I', Blocks.IRON_BLOCK }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.machine_frame, 1, 1), 
				new Object[] { "TRT", "TCT", "RIR", 'R', "dustRedstone", 'T', "ingotTin", 'C', "chipAdvanced", 'I', Blocks.IRON_BLOCK }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.breaker, 1, 0), 
				new Object[] { " P ", "RMR", "TTT", 'P', Items.IRON_PICKAXE, 'R', "dustRedstone", 'M', new ItemStack(ModBlocks.machine_frame, 1, 0), 'T', "ingotTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.breaker, 1, 1), 
				new Object[] { " P ", "RMR", "TTT", 'P', Items.IRON_PICKAXE, 'R', "dustRedstone", 'M', new ItemStack(ModBlocks.machine_frame, 1, 1), 'T', "ingotTin" }));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tinSlabHalf, 2), 
				new Object[] {"TTT", 'T', "ingotTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tinStairs, 4), 
				new Object[] { "T  ", "TT ", "TTT", 'T', "ingotTin" }));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fabric, 2), 
				new Object[] { Items.STRING, Items.STRING });
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paintBrush), 
				new Object[] { "FFF", "SSS", " S ", 'F', "fabric", 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.canvas, 2), 
				new Object[] { "FF", "FF", 'F', "fabric" }));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModBlocks.tinButton, 
				new Object[] { "nuggetTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tinDoor, 3), 
				new Object[] { "TT", "TT", "TT", 'T', "ingotTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.tinStick, 4), 
				new Object[] {"T", "T", 'T', "ingotTin"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tinFence, 3), 
				new Object[] { "TST", "TST", 'S', "stickTin", 'T', "ingotTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.tinFenceGate, 
				new Object[] { "STS", "STS", 'S', "stickTin", 'T', "ingotTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.tinPressurePlate, 
				new Object[] { "TT", 'T', "ingotTin" }));
		
		RecipeSorter.register("itemColour", RecipeItemColour.class, Category.SHAPELESS, "after:minecraft:shapeless"); //Make sure to register the recipe type first!
		GameRegistry.addRecipe(
				new RecipeItemColour(new ItemStack(ModItems.paintBrush)));
		RecipeSorter.register("clearColour", RecipeClearColour.class, Category.SHAPELESS, "after:minecraft:shapeless"); //Make sure to register the recipe type first!
		GameRegistry.addRecipe(new RecipeClearColour(
				new ItemStack(ModBlocks.canvas)));
		Utils.getLogger().info("Registered Crafting Recipes!");

		registerToolRecipe("ingotTin", ModTools.tinPickaxe, ModTools.tinAxe, ModTools.tinShovel, ModTools.tinHoe, ModCombat.tinSword, ModItems.tinStick);
		registerArmorRecipe("ingotTin", ModArmor.tinHelmet, ModArmor.tinChestplate, ModArmor.tinLeggings, ModArmor.tinBoots);
		registerToolRecipe("blockPlatinum", ModTools.platinumPickaxe, ModTools.platinumAxe, ModTools.platinumShovel, ModTools.platinumHoe, ModCombat.platinumSword, Items.STICK);
		registerArmorRecipe("blockPlatinum", ModArmor.PlatinumHelmet, ModArmor.PlatinumChestplate, ModArmor.PlatinumLeggings, ModArmor.PlatinumBoots);

			Utils.getLogger().info("Registered Crafting Recipes!");
	}

	public static void registerFurnaceRecipes() {
		GameRegistry.addSmelting(ModBlocks.platinum_ore, new ItemStack(ModItems.platinumIngot), 3.0F);
		GameRegistry.addSmelting(ModBlocks.platinum_nugget_ore, new ItemStack(ModItems.platinumNugget), 0.4F);
		
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

