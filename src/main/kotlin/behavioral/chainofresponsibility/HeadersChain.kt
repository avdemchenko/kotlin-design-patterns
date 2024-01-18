package behavioral.chainofresponsibility

interface HeadersChain {

    fun addHeader(inputHeader: String): String
}
