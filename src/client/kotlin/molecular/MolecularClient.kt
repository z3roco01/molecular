package molecular

import net.fabricmc.api.ClientModInitializer
import org.slf4j.LoggerFactory

object MolecularClient : ClientModInitializer {
	// client specific logger ( for easier debug )
	val logger = LoggerFactory.getLogger(Molecular.MOD_ID+"_client")

	override fun onInitializeClient() {

		logger.info("client init done ! :p")
	}
}