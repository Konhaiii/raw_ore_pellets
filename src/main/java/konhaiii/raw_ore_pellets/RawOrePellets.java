package konhaiii.raw_ore_pellets;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RawOrePellets implements ModInitializer {
	public static final String MOD_ID = "raw_ore_pellets";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		LOGGER.info("Raw Ore Pellets: Initialized");
	}
}