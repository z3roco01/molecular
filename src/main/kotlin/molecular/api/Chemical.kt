package molecular.api

import molecular.Molecular
import net.minecraft.text.Text

/**
 * generic chemical, stores things shared by all types of chemicals ( elements, compounds ) for any points ( boiling/melting ) that dont exist at 1 atm, put -1 to mark it impossible
 * @param transKey the end of the translation key for this element ( ex ammonium_nitrate for ammonium nitrate )
 * @param phase the chemicals phase at STP ( 273K, 1 atm ) uses the [Phase] enum ( ex gas for oxygen )
 * @param meltingPoint the melting/freezing point of this chemical at 1 atm in kelvin ( ex 1768K for cobalt )
 * @param boilingPoint the boiling/condensation point of this chemical at 1 atm in kelvin ( ex 351.38K for ethanol )
 * @param colour the colour that the chemical will have ( tints the item, etc ) in 0xRRGGBB format
 */
abstract class Chemical(val transKey: String, val phase: Phase, val meltingPoint: Float, val boilingPoint: Float, val colour: Int) {
    /**
     * translates the chemicals [transKey] with 'molecular.chemical' appended before it
     * @return a [Text] containing the translated name
     */
    fun translateName() = Text.translatable("${Molecular.MOD_ID}.chemical.$transKey")

    /**
     * returns the chemical formula for this chemical ( symbol for elements )
     * @return the formula of this chemical
     */
    abstract fun getFormula(): String

    /**
     * returns the molar mass of this chemical ( same as atomic mass for elements )
     * @return the molar mass of this chemical in g/mol
     */
    abstract fun getMolarMass(): Float

    /**
     * enum for using the 3 main phases of matter in code
     */
    enum class Phase(val transKey: String) {
        SOLID("solid"),
        LIQUID("liquid"),
        GAS("gas");

        /**
         * returns a [Text] containing the translated [transKey]
         * @return [Text.translatable] called on [transKey]
         */
        fun translate() = Text.translatable("${Molecular.MOD_ID}.phase.${this.transKey}")

        companion object {
            /** attempts to find the phase that matches the string
             * @param str the string that is attemping to be found
             * @return the [Phase] that matches the string or null
             */
            fun fromString(str: String): Phase? {
                // loop over every phase
                Phase.entries.forEach{p ->
                    // if the phases string matches the passed string
                    if(p.transKey == str)
                        //return it
                        return p
                }

                // if no phase matches, return null
                return null
            }
        }
    }
}