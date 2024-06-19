package lambdas

fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun alphabet1() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

fun alphabet2() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}

val fibonacci = buildList {
    addAll(listOf(1, 1, 2))
    add(3)
    add(index = 0, element = 3)
}
const val shouldAdd = true

val fruits = buildSet {
    add("Apple")
    if (shouldAdd) {
        addAll(listOf("Apple", "Banana", "Cherry"))
    }
}
val medals = buildMap<String, Int> {
    put("Gold", 1)
    putAll(listOf("Silver" to 2, "Bronze" to 3))
}

fun main() {
/*    println(alphabet())
    println(alphabet1())
    println(alphabet2())
    println(fibonacci)
    println(fruits)
    println(medals)*/


    val fruits = listOf("Apple", "Banana", "Cherry")
    val uppercaseFruits = mutableListOf<String>()
    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruits.addAll(it) }
        .filter { it.length > 5 }
        .also { println(it) }
        .reversed()
    println(reversedLongFruits)
    println(uppercaseFruits)
    println(fruits)
}
