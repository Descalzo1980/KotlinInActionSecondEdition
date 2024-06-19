package lambdas

fun interface IntCondition {
    fun check(i: Int): Boolean
    fun checkString(s: String) = check(s.toInt())
    fun checkChar(c: Char) = check(c.digitToInt())
}


fun interface StringConsumer {
    fun consume(s: String)
}
fun consumeHello(t: StringConsumer) {
    t.consume("Hello")
}
fun consumeHelloFunctional(t: (String) -> Unit) {
    t("Hello")
}

fun main() {
    val isOdd = IntCondition { it % 2 != 0 }
    println(isOdd.check(1))
    // true
    println(isOdd.checkString("2"))
    // false
    println(isOdd.checkChar('3'))
    // true
}