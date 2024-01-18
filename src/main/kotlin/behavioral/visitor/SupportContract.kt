package behavioral.visitor

class SupportContract(val costPerMonth: Long) : ReportVisitable {

    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}
