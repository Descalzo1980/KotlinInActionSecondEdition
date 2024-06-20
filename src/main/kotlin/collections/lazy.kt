package collections

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis


fun generateRandomPerson(): Person {
    val names = listOf("Alice", "Bob", "Charles", "Dan", "Eve", "Frank", "Grace", "Hannah", "Isaac", "Jack")
    val name = names.random()
    val age = Random.nextInt(18, 60)
    return Person(name, age)
}

fun generatePeople(count: Int): List<Person> {
    return List(count) { generateRandomPerson() }
}

suspend fun main() {
    val people = generatePeople(100000000)

    val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    val time1Deferred = scope.async {
        val time1 = measureTimeMillis {
            people
                .asSequence()
                .map(Person::name)
                .filter { it.length < 4 }
                .toList()
        }
        println("Time for first chain: $time1 ms")
    }

    val time2Deferred = scope.async {
        val time2 = measureTimeMillis {
            people
                .asSequence()
                .filter { it.name.length < 4 }
                .map(Person::name)
                .toList()
        }
        println("Time for second chain: $time2 ms")
    }

    time1Deferred.await()
    time2Deferred.await()

    scope.cancel()
}