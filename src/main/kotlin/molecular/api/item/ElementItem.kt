package molecular.api.item

import molecular.Molecular
import molecular.api.Element
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import net.minecraft.util.Colors

/**
 * handles all items that are one element, not a compound
 */
class ElementItem(val element: Element): Item(Settings()) {
    override fun appendTooltip(stack: ItemStack, context: TooltipContext, tooltip: MutableList<Text>, type: TooltipType) {
        super.appendTooltip(stack, context, tooltip, type)
        tooltip.add(getFamilyTooltip())
        tooltip.add(getMassTooltip())
    }

    /**
     * creates the text for the tooltip that has the table family
     */
    fun getFamilyTooltip() = Text.translatable("item.${Molecular.MOD_ID}.element.tooltip.family")
        .append(": ").append(element.tableFamily.translate()).withColor(Colors.YELLOW)

    /**
     * creates the text for the tooltip that has the atomic mass
     */
    fun getMassTooltip() = Text.translatable("item.${Molecular.MOD_ID}.element.tooltip.mass").append(": ${element.getMolarMass()}")
        .append(Text.translatable("item.${Molecular.MOD_ID}.element.tooltip.mass_unit")).withColor(Colors.RED)
}