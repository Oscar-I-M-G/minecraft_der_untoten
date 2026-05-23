package mdu.client;

import mdu.gui.HudDebug;
import mdu.gui.HudPoints;
import mdu.gui.HudRenderingEntryPoint;
import net.fabricmc.api.ClientModInitializer;

public class Minecraft_der_untotenClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudRenderingEntryPoint.init();
		HudPoints.init();
		HudDebug.init();
	}
}