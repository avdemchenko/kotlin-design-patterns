package behavioral.visitor

class TimeAndMaterialsContract(val costPerHour: Long, val hours: Long) : ReportVisitable {

    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}
