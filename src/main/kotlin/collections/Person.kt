package collections

data class Person(
    val name: String,
    val age: Int
)

fun main() {
/*    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age > 30 })
    println(list.map { it * it })
    println(people.map { it.name })
    people.map(Person::name)
    println(people.filter { it.age > 30 }.map(Person::name))
    val maxAge = people.maxByOrNull(Person::age)?.age
    val oldestPerson = people.filter { it.age == maxAge}
    println(oldestPerson)*/

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

    val list = listOf(1, 2, 3, 4)
    val summed = list.reduce { acc, element ->
        acc + element
    }
    println(summed)
    // 10
    val multiplied = list.reduce { acc, element ->
        acc * element
    }
    println(multiplied)

}