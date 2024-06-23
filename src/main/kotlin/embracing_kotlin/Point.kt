package embracing_kotlin

data class Point(
    val x: Int,
    val y: Int
) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

class Greeter(val greeting: String) {
    operator fun invoke(target: String) = println("$greeting $target!")
    operator fun invoke(target: String, times: Int) {
        repeat(times) {
            println("$greeting $target!")
        }
    }

    fun hello(target: String) = println("$greeting $target!")
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}


class Person1(
    private val firstName: String, private val lastName: String
) : Comparable<Person1> {
    override fun compareTo(other: Person1): Int {
        return compareValuesBy(
            this, other,
            Person1::lastName, Person1::firstName
        )
    }
}
data class MutablePoint(var x: Int, var y: Int)
operator fun MutablePoint.set(index: Int, value: Int)  {
    when(index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}



fun main() {
    val p22 = MutablePoint(10, 20)
    p22[1] = 42
    println(p22)
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
    val greeting = Greeter("Hello")
    greeting("World")
    greeting("Kotlin", 2)
    greeting.hello("Hello")
    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    val list = mutableListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    val person1 = Person1("Alice", "Smith")
    val person2 = Person1("Bob", "Johnson")
    println(person1 < person2)

    val p = Point(10, 20)
    println(p[1])
}


