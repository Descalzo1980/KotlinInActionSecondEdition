package generics

import basic.Expr


val <T> List<T>.penultimate: T
get() = this[size - 2]

fun <T : Number> List<T>.sum(): T {
    if (this.isEmpty()) throw IllegalArgumentException("List is empty")
    val first = this[0]
    val sum: Double = this.fold(0.0) { acc, num -> acc + num.toDouble() }
    return when (first) {
        is Byte -> sum.toInt().toByte() as T
        is Short -> sum.toInt().toShort() as T
        is Int -> sum.toInt() as T
        is Long -> sum.toLong() as T
        is Float -> sum.toFloat() as T
        is Double -> sum as T
        else -> throw UnsupportedOperationException("Unsupported number type")
    }
}

fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    // [a, b, c]
    println(letters.slice(10..13))
    // [k, l, m, n]

    println(letters.penultimate)

    val listNum = listOf(1,2,3,4,5)
    println(listNum.sum())
}
