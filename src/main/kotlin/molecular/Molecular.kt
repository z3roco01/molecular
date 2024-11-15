package molecular

import molecular.util.ResourceUtil
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Molecular : ModInitializer {
	const val MOD_ID = "molecular"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		var files = ResourceUtil.getFilesInDir("/data/molecular/elements")
		logger.info(ResourceUtil.fileToElement(files[0]).toString())

		logger.info("common init done ! :D")
	}
}