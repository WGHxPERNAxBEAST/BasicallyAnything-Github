package WGHxPERNAxBEAST.basicallyanything.handlers;

import java.util.ArrayList;
import java.util.List;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.init.ModArmor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementHandler {
	
	private static List<Achievement> achievements = new ArrayList<Achievement>();
	
	public static Achievement achievementPlatinumPlated = createAchievement("Platinum_Plated", 0, 0, ModArmor.PlatinumChestplate);
	
	public static void registerAchievements() {
		Achievement[] achievementArray = new Achievement[achievements.size()];
		for(Achievement achievement : achievements) {
			achievement.registerStat();
			achievementArray[achievements.indexOf(achievement)] = achievement;
		}
		AchievementPage.registerAchievementPage(new AchievementPage(Reference.NAME, achievementArray));
	}
	
	private static Achievement createAchievement(String name, int column, int row, Item item) {
		Achievement achievement = new Achievement("achievement." + name, name, column, row, item, (Achievement)null);
		achievements.add(achievement);
		return achievement; 
	}
	private static Achievement createAchievement(String name, int column, int row, Block block) {
		Achievement achievement = new Achievement("achievement." + name, name, column, row, block, (Achievement)null);
		achievements.add(achievement);
		return achievement; 
	}
	private static Achievement createAchievement(String name, int column, int row, ItemStack stack) {
		Achievement achievement = new Achievement("achievement." + name, name, column, row, stack, (Achievement)null);
		achievements.add(achievement);
		return achievement; 
	}

}
