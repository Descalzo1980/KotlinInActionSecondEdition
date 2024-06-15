package taste

data class Person(
    val name: String,
    val age: Int? = null
)

fun main() {
    val persons = listOf(
        Person("Alice", age = 29),
        Person("Alice", age = 29),
        Person("Bob"),
    )
    val person1 = Person("Alice", age = 29)
    val person2 = Person("Alice", age = 29)

    val oldest = persons.maxBy {
        it.age ?: 0
    }
    println("The oldest is: $oldest")

    println(person1 == person2)
    println(person1 === person2)
    val newAlice = person1.copy(name = "Olga")
    println(newAlice)

    var s: String? = null
    var s2: String = ""
    s = "Ololo"
    s2 = "Ololo"
    println(s.length)
    println(s2.length)
}