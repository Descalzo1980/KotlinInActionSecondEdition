package lambdas

data class Person(
    val name: String,
    val age: Int,
)
fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}
fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob",
        31))
    findTheOldest(people)
    println(people.maxByOrNull { it.age })
    println(people.maxByOrNull(Person::age))

    val sum = {x: Int, y: Int -> x + y}
    println(sum(1,2))
    run { println(42) }

    val myFavoriteNumber = run {
        println("I'm thinking!")
        println("I'm doing some more work...")
        42
    }.also { println("Ololo") }
    println(myFavoriteNumber)

    println(people.maxByOrNull { p: Person -> p.age })

    val names = people.joinToString(
        separator = " ",
        transform = { p: Person -> p.name }
    )
    people.joinToString(" ") { p: Person -> p.name }
    println(names)

    val mapNames = people.map {
        it.name
    }
    println(mapNames)

    val getAge = { p: Person -> p.age }
    people.maxByOrNull(getAge)
}
