package basic

fun main() {
    println("12.345-6.A".split("\\.|-".toRegex()))
    // [12, 345, 6, A]

    println("12.345-6.A".split(".", "-"))
}