package WGHxPERNAxBEAST.basicallyanything;

import net.minecraftforge.fml.common.Loader;

public class ModChecker {
	
	public static boolean isTinkersConstructLoaded;
	
	public ModChecker() {
		this.isTinkersConstructLoaded = Loader.isModLoaded("tconstruct");
	}

}
