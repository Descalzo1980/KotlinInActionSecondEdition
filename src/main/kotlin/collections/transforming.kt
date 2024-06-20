package collections

fun main() {

    val people = listOf(
        Person("Joe", 22),
        Person("Mary", 31),
        Person("Jamie", 22)
    )
    val nameToAge = people.associate { it.name to it.age }

    println(nameToAge)
    println(nameToAge["Joe"])

    val personToAge = people.associateWith { it.age }
    println(personToAge)

    val ageToPerson = people.associateBy { it.age }
    println(ageToPerson)
}

/*Keep in mind that keys for maps have to be unique, and the ones generated by
 associate , associateBy , and associateWith are no exception. If your
transformation function would result in the same key being added multiple
times, the last result overwrites any previous assignments.
*/