package basic_types


fun main() {
    showProgress(146)
    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
    println(Person("Sam", 35).isOlderThan(Person("Jane")))


    val x = 1
    println(x.toLong() in listOf(1L, 2L, 3L))

    println("seven".toIntOrNull())

    println("trUE".toBoolean())
    val answer: Any = 42
    val answer1: Any? = null

    println(answer.javaClass)
    println(answer1?.javaClass)

    val no = NoResultProcessor()
    val result = no.process()
    println(result)

/*    fail("Error occurred")*/
    val company = Company1("Ololo", null)
    val address = company.address ?: fail("No address")
    println(address.city)
}

data class Company1(
    val name: String,
    val address: Address1?
)

data class Address1(
    val city: String
)


fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

interface Processor<T> {
    fun process(): T
}
class NoResultProcessor : Processor<Unit> {
    override fun process() {

    }
}

data class Person(
    val name: String,
    val age: Int? = null
) {
    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're $percent % done!")
}