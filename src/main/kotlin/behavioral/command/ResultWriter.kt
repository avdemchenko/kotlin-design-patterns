package behavioral.command

class ResultWriter {

    private val results = mutableListOf<String>()

    fun addResult(result: String) {
        results.add(result)
    }

    fun getResults(): List<String> = results
}
