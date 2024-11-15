package molecular

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Molecular : ModInitializer {
	const val MOD_ID = "molecular"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {


		logger.info("common init done ! :D")
	}
}