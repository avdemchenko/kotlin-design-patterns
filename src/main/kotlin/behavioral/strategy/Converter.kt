package behavioral.strategy

class Converter(private val stringFormatterStrategy: (String) -> String) {

    fun convert(string: String) = stringFormatterStrategy(string)
}

val lowerCaseFormatter: (String) -> String = { it.toLowerCase() }
val upperCaseFormatter = { it: String -> it.toUpperCase() }
