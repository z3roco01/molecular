package molecular.api

import molecular.Molecular
import net.minecraft.text.Text

/**
 * describes a specific element, inherits from [Chemical] ( see it for the other parameters )
 * @param symbol the symbol of this element ( ex Ne for neon )
 * @param atomicWeight the standard atomic weight of this element, the same as molar mass so it is used in [molecular.api.Element.getMolarMass]
 * @param atomicNumber the atomic number of this element ( ex 5 for boron )
 * @param tableFamily the family this element occupies in the periodic table, uses [TableFamily] ( ex post transition metals for aluminum )
 */
class Element(transKey: String, phase: Phase, meltingPoint: Float, boilingPoint: Float, val symbol: String, val atomicWeight: Float, val atomicNumber: Int, val tableFamily: TableFamily) :
    Chemical(transKey, phase, meltingPoint, boilingPoint) {

    override fun getFormula() = symbol

    override fun getMolarMass() = this.atomicWeight

    /**
     * an enum for handling the families of the periodic tables
     */
    enum class TableFamily(val transKey: String) {
        ALKALI_METALS("${Molecular.MOD_ID}.periodic_table.family.alkali_metals"),
        ALKALINE_EARTH_METALS("${Molecular.MOD_ID}.periodic_table.family.alkaline_earth_metals"),
        TRANSITION_METALS("${Molecular.MOD_ID}.periodic_table.family.transition_metals"),
        POST_TRANSITION_METALS("${Molecular.MOD_ID}.periodic_table.family.post_transition_metals"),
        METALLOIDS("${Molecular.MOD_ID}.periodic_table.family.metalloids"),
        NONMETALS("${Molecular.MOD_ID}.periodic_table.family.nonmetals"),
        CHALCOGENS("${Molecular.MOD_ID}.periodic_table.family.chalcogens"),
        HALOGENS("${Molecular.MOD_ID}.periodic_table.family.halogens"),
        NOBLE_GASES("${Molecular.MOD_ID}.periodic_table.family.noble_gases"),
        LANTHANIDES("${Molecular.MOD_ID}.periodic_table.family.lanthanides"),
        ACTINIDES("${Molecular.MOD_ID}.periodic_table.family.actinides");

        /**
         * returns a [Text] containing the translated [transKey]
         * @return [Text.translatable] called on [transKey]
         */
        fun translate() = Text.translatable(this.transKey)
    }
}