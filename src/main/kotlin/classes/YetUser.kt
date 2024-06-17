package classes

class UserYet(private val name: String) {
    var address: String = "unspecified"
        set(value) {
            println(
                """
 Address was changed for $name:
 "$field" -> "$value". ❶
 """.trimIndent()
            )
            field = value
        }
}

class Person(var birthYear: Int) {
    var ageIn2050
        get() = 2050 - birthYear
    set(value) {
        birthYear = 2050 - value
    }
}

class LengthCounter {
    var counter: Int = 0
        private set
        fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val user = UserYet("Alice")
    user.address = "Christoph-Rapparini-Bogen 23"
    // Address was changed for Alice:
    // "unspecified" -> "Christoph-Rapparini-Bogen 23".

    val person = Person(1980)
    println(person.ageIn2050)

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("SomeWord")
    println(lengthCounter.counter)
    // lengthCounter.counter = 0
    // Error: Cannot assign to 'counter': the setter is private in
}
