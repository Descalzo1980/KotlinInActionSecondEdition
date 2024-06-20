package collections

class Book(val title: String, val authors: List<String>)

val library = listOf(
    Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
    Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
    Book("The Three-Body Problem", listOf("Liu"))
)

fun main() {
    val authors = library.map { it.authors }.flatten()
    val title = library.map { it.title }
    val authorsFlat = library.flatMap { it.authors.toSet() }
    println(authors)
    println(title)
    println(authorsFlat)
}