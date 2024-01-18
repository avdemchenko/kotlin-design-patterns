package behavioral.visitor

class FixedPriceContract(val costPerYear: Long) : ReportVisitable {

    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}
