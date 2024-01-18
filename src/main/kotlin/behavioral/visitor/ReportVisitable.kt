package behavioral.visitor

interface ReportVisitable {

    fun <R> accept(visitor: ReportVisitor<R>): R
}
