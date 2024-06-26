package lambda

data class PersonPerson(
    val name: String,
    val age: Int,
)

val people = listOf(PersonPerson("Alice", 25), PersonPerson("Boo", 44))


fun lookForAlice(people: List<PersonPerson>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lookForAliceLabel(people: List<PersonPerson>) {
    people.forEach label@{
        if (it.name != "Alice") return@label
        print("Found Alice!")
    }
}

fun lookForAliceForEach(people: List<PersonPerson>) {
    people.forEach {
        if (it.name != "Alice") return@forEach
        print("Found Alice!")
    }
}


fun main(){
    println(people.filter { it.age > 33 })

    val result = mutableListOf<PersonPerson>()
    for (person in people) {
        if (person.age < 30) result.add(person)
    }
    println(result)

    println(
        people.filter { it.age > 30 }
            .map(PersonPerson::name)
    )

    lookForAlice(people)
    lookForAliceLabel(people)
    lookForAliceForEach(people)
}
