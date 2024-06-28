package generics


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

fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}


fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
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
    val result = oneHalf(listNum
        .map { it.toDouble() }
        .size
    )
    println(result)

    println(max("kotlin", "java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}
