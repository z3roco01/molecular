package molecular.api

import molecular.Molecular
import net.minecraft.text.Text

/**
 * generic chemical, stores things shared by all types of chemicals ( elements, compounds ) for any points ( boiling/melting ) that dont exist at 1 atm, put -1 to mark it impossible
 * @param transKey the end of the translation key for this element ( ex ammonium_nitrate for ammonium nitrate )
 * @param phase the chemicals phase at STP ( 273K, 1 atm ) uses the [Phase] enum ( ex gas for oxygen )
 * @param meltingPoint the melting/freezing point of this chemical at 1 atm in kelvin ( ex 1768K for cobalt )
 * @param boilingPoint the boiling/condensation point of this chemical at 1 atm in kelvin ( ex 351.38K for ethanol )
 */
abstract class Chemical(val transKey: String, val phase: Phase, val meltingPoint: Float, val boilingPoint: Float) {
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
        SOLID("${Molecular.MOD_ID}.phase.solid"),
        LIQUID("${Molecular.MOD_ID}.phase.liquid"),
        GAS("${Molecular.MOD_ID}.phase.gas");

        /**
         * returns a [Text] containing the translated [transKey]
         * @return [Text.translatable] called on [transKey]
         */
        fun translate() = Text.translatable(this.transKey)
    }
}