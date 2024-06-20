package collections

val temperatures = listOf(27.7, 29.8, 22.0, 35.5, 19.1)

fun main() {
    println(temperatures.windowed(3))

    println(temperatures.windowed(3) { window ->
        "%.2f".format(window.sum() / window.size )})

    println(temperatures.chunked(temperatures.size))

    println(temperatures.chunked(2) { it.sum() })
}