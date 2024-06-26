package lambda

fun String.filter(predicate: (Char) -> Boolean): String {
    return buildString {
        for (char in this@filter) {
            if (predicate(char)) append(char)
        }
    }
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun List<String>.transform(transformation: (List<String>) -> List<String>): List<String> {
    return transformation(this)
}

fun main() {
    println("ab1c".filter { it in 'a'..'z' })

    val strings = listOf("Hello", "I just need some work").transform {
        it.map { str ->
            str.uppercase()
        }
    }
    val result = strings.joinToString(separator = " * ", prefix = "[", postfix = "]")

    println(result)
}