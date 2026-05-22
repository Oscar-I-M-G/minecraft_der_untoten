package mdu;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Minecraft_der_untoten implements ModInitializer {
	public static final String MOD_ID = "minecraft_der_untoten";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing mod");
	}
}