package generics

inline fun <reified T>readNumbersOrWords(): List<Any> {
    val input = readln()
    val words: List<String> = input.split(",")
    val numbers: List<Int> = words.mapNotNull { it.toIntOrNull() }
    return numbers.ifEmpty { words }
}
fun printList(l: List<Any>) {
    when(l) {
        is List<*> -> println("Strings: $l")
        is List<*> -> println("Integers: $l")
    }
}

inline fun <reified T> isA(value: Any) = value is T

fun main() {
    val list = readNumbersOrWords<String>()
    printList(list)

    println(isA<String>("abc"))
    // true
    println(isA<String>(123))
    // false

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

}