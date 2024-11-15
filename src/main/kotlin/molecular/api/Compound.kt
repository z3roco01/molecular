package molecular.api

/**
 * defines a specific compound ( 2 or more molecules of any element ) inherits from [Chemical] ( see it for other parameters )
 * @param chemicals the list of chemicals in this compound mapped to their subscripts
 */
class Compound(transKey: String, phase: Phase, meltingPoint: Float, boilingPoint: Float, colour: Int,  val chemicals: HashMap<Chemical, Int>):
    Chemical(transKey, phase, meltingPoint, boilingPoint, colour) {

    override fun getFormula(): String {
        // start with empty formula
        var formula = ""

        // loop over each chemical-subscript pair
        for(chemical in chemicals) {
            formula +=
                if(chemical.key is Compound && chemical.value > 1) // if this is a compound and there is more than one then add parenthesis around the formula
                    "(${chemical.key.getFormula()})"
                else // else just add the formula
                    chemical.key.getFormula()

            // if there is more than one of this chemical, then add a subscript
            if(chemical.value > 1)
                formula += chemical.value
        }

        // return the completed formula
        return formula
    }

    override fun getMolarMass(): Float {
        // start with molar mass of 0 g/mol
        var totalMass = 0f

        // loop over every chemical-subscript pair
        for(chemical in chemicals) {
            // add the chemicals molar mass times its subscript to the total mass
            totalMass += chemical.key.getMolarMass() * chemical.value
        }

        return totalMass
    }
}