package molecular.datagen

import molecular.datagen.lang.MolecularEnglishLanguageProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

/**
 * handles all the data generation
 * @since version 0.0.1
 */
object MolecularDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider(::MolecularEnglishLanguageProvider)
	}
}