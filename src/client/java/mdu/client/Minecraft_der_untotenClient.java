package mdu.client;

import mdu.gui.HudRenderingEntryPoint;
import net.fabricmc.api.ClientModInitializer;

public class Minecraft_der_untotenClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudRenderingEntryPoint.init();
	}
}