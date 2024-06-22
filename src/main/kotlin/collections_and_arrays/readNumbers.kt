package collections_and_arrays

fun readNumbers(text: String): List<Int?> {
    val result = mutableListOf<Int?>()
    for (line in text.lineSequence()) {
        val numberOrNull = line.toIntOrNull()
        result.add(numberOrNull)
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}


fun main() {
    println(
        readNumbers(
            """"
        |Some text
        |Some text
        |Some text
        |Some text
        |""""".trimMargin()
        )
    )

    println(
        readNumbers(
            """
        |123
        |456
        |789
        |0""".trimMargin()
        )
    )

    val input =
        """
    1
    abc
    42
 """.trimIndent()
    val numbers = readNumbers(input)
    addValidNumbers(numbers)
}