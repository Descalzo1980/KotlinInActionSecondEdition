package collections

fun main() {
    val people = listOf(
        Person("Alice", 26),
        Person("Bob", 29),
        Person("Carol", 31),
        Person("Carol", 31),
        Person("Carol", 31),
        Person("Carol", 31),
        Person("Carol", 31),
    )
/*    val comeIn = people.filter(canBeInClub27)
    val stayOut = people.filterNot(canBeInClub27)*/
/*    println(comeIn)
    println(stayOut)*/

    val (comeIn, stayOut) = people.partition(canBeInClub27)
    println(comeIn)
    println(stayOut)

    println(people.groupBy { it.age })

    val list = listOf("apple", "apricot", "banana", "cantaloupe")
    val grouped = list.groupBy { it.filter { char -> char == 'a' } }
    println(grouped)
}
