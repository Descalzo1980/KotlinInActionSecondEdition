package basic

fun String.lastChar(): Char = this[this.length - 1]

fun String.firstChar(): Char = this[0]


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

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun main() {
    println("Kotlin".lastChar())
    println("Kotlin".firstChar())

    val list = listOf(1, 2, 3)
    println(
        list.joinToString(
            separator = "; ",
            prefix = "(",
            postfix = ")"
        )
    )
    println(listOf("one", "two", "eight").join(" "))

    val view: View = Button()
    view.click()

    view.showOff()

    val button = Button()
    button.showOff()

    val sb = StringBuilder("Kotlin?")
    println(sb.lastChar)
    sb.lastChar = '!'
    println(sb)

}

var StringBuilder.lastChar: Char
    get() = this[length - 1]
    set(value) {
        this.setCharAt(length - 1, value)
    }

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")