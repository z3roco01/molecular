package molecular.api

import molecular.Molecular
import net.minecraft.text.Text

/**
 * describes a specific element, inherits from [Chemical] ( see it for the other parameters )
 * @param symbol the symbol of this element ( ex Ne for neon )
 * @param atomicMass the standard atomic weight of this element, the same as molar mass so it is used in [molecular.api.Element.getMolarMass]
 * @param atomicNumber the atomic number of this element ( ex 5 for boron )
 * @param tableFamily the family this element occupies in the periodic table, uses [TableFamily] ( ex post transition metals for aluminum )
 */
class Element(transKey: String, phase: Phase, meltingPoint: Float, boilingPoint: Float, colour: Int, val symbol: String, val atomicMass: Float, val atomicNumber: Int, val tableFamily: TableFamily) :
    Chemical(transKey, phase, meltingPoint, boilingPoint, colour) {

    override fun getFormula() = symbol

    override fun getMolarMass() = this.atomicMass

    override fun toString() = "$transKey ( $symbol atomic number ${atomicNumber}, family: ${tableFamily.transKey}), ${phase.transKey} at STP, melts at $meltingPoint, boils at $boilingPoint, has atomic mass $atomicMass, has colour: #${colour.toString(16)}"

    /**
     * an enum for handling the families of the periodic tables
     */
    enum class TableFamily(val transKey: String) {
        ALKALI_METALS("alkali_metal"),
        ALKALINE_EARTH_METALS("alkaline_earth_metal"),
        TRANSITION_METALS("transition_metal"),
        POST_TRANSITION_METALS("post_transition_metal"),
        METALLOIDS("metalloid"),
        NONMETALS("nonmetal"),
        CHALCOGENS("chalcogen"),
        HALOGENS("halogen"),
        NOBLE_GASES("noble_gas"),
        LANTHANIDES("lanthanide"),
        ACTINIDES("actinide");

        /**
         * returns a [Text] containing the translated [transKey]
         * @return [Text.translatable] called on [transKey]
         */
        fun translate() = Text.translatable("${Molecular.MOD_ID}.periodic_table.family.${this.transKey}")

        companion object {
            /** attempts to find the family that matches the string
             * @param str the string that is attempting to be found
             * @return the [molecular.api.Element.TableFamily] that matches the string or null
             */
            fun fromString(str: String): TableFamily? {
                // loop over every phase
                TableFamily.entries.forEach{ f ->
                    // if the familys string matches the passed string
                    if(f.transKey == str)
                    //return it
                        return f
                }

                // if no family matches, return null
                return null
            }
        }
    }
}