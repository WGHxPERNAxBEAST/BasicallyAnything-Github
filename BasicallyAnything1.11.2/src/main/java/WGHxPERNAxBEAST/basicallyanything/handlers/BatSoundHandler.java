package WGHxPERNAxBEAST.basicallyanything.handlers;

import WGHxPERNAxBEAST.basicallyanything.Reference;
import WGHxPERNAxBEAST.basicallyanything.util.Utils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class BatSoundHandler {
	
	private static int size = 0;
	
	public static SoundEvent TIN_FENCE_GATE_OPEN;
	public static SoundEvent TIN_FENCE_GATE_CLOSE;
	public static SoundEvent TIN_BUTTON_CLICK_ON;
	public static SoundEvent TIN_BUTTON_CLICK_OFF;
	public static SoundEvent PLASMA_IGNITION;
	public static SoundEvent PLASMA_DEACTIVATE;
	
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();
		
		TIN_FENCE_GATE_OPEN = register("block.tin_fence_gate.open");
		TIN_FENCE_GATE_CLOSE = register("block.tin_fence_gate.close");
		TIN_BUTTON_CLICK_ON = register("block.tin_button.click_on");
		TIN_BUTTON_CLICK_OFF = register("block.tin_button.click_off");
		PLASMA_IGNITION = register("item.plasma_ignition");
		PLASMA_DEACTIVATE = register("item.plasma_deactivate");
	}
	
	public static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		Utils.getLogger().info("Registered sound: " + name);
		return e;
	}

}
