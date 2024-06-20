package collections

data class Person(
    val name: String,
    val age: Int
)

val canBeInClub27 = { p: Person -> p.age <= 27 }

fun main() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age > 30 })
    println(list.map { it * it })
    println(people.map { it.name })
    people.map(Person::name)
    println(people.filter { it.age > 30 }.map(Person::name))
    val maxAge = people.maxByOrNull(Person::age)?.age
    val oldestPerson = people.filter { it.age == maxAge}
    println(oldestPerson)

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
    val filtered = numbers.filterIndexed { index, element ->
        index % 2 == 0 && element > 3
    }
    println(filtered)

    val mapped = numbers.mapIndexed { index, element ->
        index + element
    }
    println(mapped)

    val numbers1 = mapOf("One" to "zero", "Two" to "one")
    println(numbers1.mapKeys { it.key.uppercase() })

    val list1 = listOf(1, 2, 3, 4)
    val summed = list1.reduce { acc, element ->
        acc + element
    }
    println(summed)
    // 10
    val multiplied = list1.reduce { acc, element ->
        acc * element
    }
    println(multiplied)
    // 24

    val people1 = listOf(
        Person("Alex", 29),
        Person("Natalia", 28)
    )
    val folded = people1.fold("") { acc, person ->
        acc + person.name
    }
    println(folded)
    val people2 = listOf(Person("Alice", 27), Person("Bob", 31))
    println(people2.all(canBeInClub27))
    println(people2.any(canBeInClub27))
    println(!list.all { it == 3 })
    println(list.any { it != 3 })
    println(emptyList<Int>().none { it > 42 })
}