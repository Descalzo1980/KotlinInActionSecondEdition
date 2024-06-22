package nullable

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}
fun main() {
    verifyUserInput(" ")
    // Please fill in the required fields
    verifyUserInput(null)
    // Please fill in the required fields
    verifyUserInput("First")
}
