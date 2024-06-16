package basic

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val number = 400
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100:$number")

    println(percentage)

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}

fun readNumber(reader: BufferedReader): Int? {
    return try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }
}