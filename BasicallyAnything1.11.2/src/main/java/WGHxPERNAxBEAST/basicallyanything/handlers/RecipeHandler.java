package WGHxPERNAxBEAST.basicallyanything.handlers;

import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import WGHxPERNAxBEAST.basicallyanything.init.ModBlocks;
import WGHxPERNAxBEAST.basicallyanything.init.ModCombat;
import WGHxPERNAxBEAST.basicallyanything.init.ModFood;
import WGHxPERNAxBEAST.basicallyanything.init.ModItems;
import WGHxPERNAxBEAST.basicallyanything.init.ModTools;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeHandler {

	public static void registerCraftingRecipes() {

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModFood.platinumApple),
				new Object[] { "PPP", "PGP", "PPP", 'P', "blockPlatinum", 'G', Items.GOLDEN_APPLE}));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.platinum_block),
				new Object[] { "PPP", "PPP", "PPP", 'P', ModItems.platinumIngot });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.platinumIngot, 9),
				new Object[] { ModBlocks.platinum_block });
		GameRegistry.addRecipe(new ItemStack(ModItems.platinumIngot),
				new Object[] { "NNN", "NNN", "NNN", 'N', ModItems.platinumNugget });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.platinumNugget, 9),
				new Object[] { ModItems.platinumIngot });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.machine_frame),
				new Object[] { "PPP", "P P", "PPP", 'P', ModItems.platinumIngot });
		/*
		* "normFood" isnt being accepted as part of the recipe for the feeder, when in game, the spaces are blank	
		*/
		GameRegistry.addRecipe(new ItemStack(ModBlocks.feeder),
				new Object[] { "FNF", "NCN", "FNF", 'F',  ModBlocks.machine_frame, 'C', ModItems.machine_core, 'N', "normFood"});
		GameRegistry.addRecipe(new ItemStack(ModItems.machine_core),
				new Object[] { "PPP", "RCR", "PPP", 'P', ModItems.platinumIngot, 'R', Items.REDSTONE, 'C', ModItems.chip });
		GameRegistry.addRecipe(new ItemStack(ModItems.chip),
				new Object[] { "PPP", "RRR", "PPP", 'P', ModItems.platinumNugget, 'R', Items.REDSTONE });
		
		registerToolRecipe("blockPlatinum", ModTools.platinumPickaxe, ModTools.platinumAxe, ModTools.platinumShovel, ModTools.platinumHoe, ModCombat.platinumSword, Items.STICK);
		registerArmorRecipe("blockPlatinum", ModArmor.PlatinumHelmet, ModArmor.PlatinumChestplate, ModArmor.PlatinumLeggings, ModArmor.PlatinumBoots);

			Utils.getLogger().info("Registered Crafting Recipes!");
	}

	public static void registerSmeltingRecipes() {
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

