package molecular.datagen.lang

import molecular.Molecular
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class MolecularEnglishLanguageProvider(dataOutput: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>):
    FabricLanguageProvider(dataOutput, "en_us", registryLookup) {
    override fun generateTranslations(registryLookup: RegistryWrapper.WrapperLookup, translationBuilder: TranslationBuilder) {
        // element tooltip
        translationBuilder.add("item.${Molecular.MOD_ID}.element.tooltip.family",    "Family")
        translationBuilder.add("item.${Molecular.MOD_ID}.element.tooltip.mass",      "Atomic mass")
        translationBuilder.add("item.${Molecular.MOD_ID}.element.tooltip.mass_unit", "Da")

        // periodic table families
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.alkali_metal",          "Alkali metals")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.alkaline_earth_metal",  "Alkaline earth metals")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.transition_metal",      "Transition metals")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.post_transition_metal", "Post-transition metals")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.metalloid",             "Metalloids")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.nonmetal",              "Nonmetals")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.chalcogen",             "Chalcogens")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.halogen",               "Halogens")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.noble_gas",             "Nobel gases")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.lanthanide",            "Lanthanides")
        translationBuilder.add("${Molecular.MOD_ID}.periodic_table.family.actinide",              "Actinides")

        // phases
        translationBuilder.add("${Molecular.MOD_ID}.phase.solid",  "solid")
        translationBuilder.add("${Molecular.MOD_ID}.phase.liquid", "liquid")
        translationBuilder.add("${Molecular.MOD_ID}.phase.gas",    "gas")
    }
}