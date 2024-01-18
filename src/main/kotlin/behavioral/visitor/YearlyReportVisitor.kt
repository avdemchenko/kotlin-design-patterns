package behavioral.visitor

class YearlyReportVisitor : ReportVisitor<Long> {

    override fun visit(contract: FixedPriceContract): Long =
        contract.costPerYear

    override fun visit(contract: TimeAndMaterialsContract): Long =
        contract.costPerHour * contract.hours

    override fun visit(contract: SupportContract): Long =
        contract.costPerMonth * 12
}
