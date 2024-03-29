package behavioral.chainofresponsibility

class BodyPayload(val body: String, var next: HeadersChain? = null) : HeadersChain {

    override fun addHeader(inputHeader: String): String =
        inputHeader + body.let { next?.addHeader(it) ?: it }
}