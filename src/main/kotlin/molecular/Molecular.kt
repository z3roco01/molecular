package molecular

import molecular.api.item.ElementItem
import molecular.util.ResourceUtil
import net.fabricmc.api.ModInitializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

/**
 * common init, called on client and server
 * @since version 0.0.1
 */
object Molecular : ModInitializer {
	const val MOD_ID = "molecular"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		var files = ResourceUtil.getFilesInDir("/data/molecular/elements")
		val americium = ResourceUtil.fileToElement(files[0])
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "americium"), ElementItem(americium))

		logger.info("common init done ! :D")
	}
}