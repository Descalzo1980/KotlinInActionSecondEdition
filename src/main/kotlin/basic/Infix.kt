package basic

fun main() {
    val map = setOf(
        1,
        7,
        53,
        1,
    )

    val set = setOf(
        1,
        7,
        53,
        1,
    )

    println("Set size: ${set.size}")

    for (number in set) {
        println("$number")
    }

/*    val (number, name) = 1 to "one"
    println(number)
    println(name)*/
}

data class Pair(val first: Int, val second: String)