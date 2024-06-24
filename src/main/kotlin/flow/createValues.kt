package flow

import coroutines.log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

suspend fun createValue(): Flow<Int> {
    return flow {
        emit(1)
        delay(1.seconds)
        emit(2)
        delay(1.seconds)
        emit(2)
        delay(1.seconds)
    }
}

val letters = flow {
    log("Emitting A!")
    emit("A")
    delay(200.milliseconds)
    log("Emitting B!")
    emit("B")
}

suspend fun getRandomNumber(): Int {
    delay(500.milliseconds)
    return Random.nextInt()
}
val randomNumbers = flow {
    repeat(10) {
        emit(getRandomNumber())
    }
}

/*val randomNumbers = flow {
    coroutineScope {
        repeat(10) {
            launch { emit(getRandomNumber()) }
        }
    }
}
Exception in thread "main" java.lang.IllegalStateException:
Flow invariant is violated:
Emission from another coroutine is detected.

*/
val randomNumbers1 = channelFlow {
    repeat(10) {
        launch {
            send(getRandomNumber())
        }
    }
}

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    val job = scope.launch {
        randomNumbers.collect {
            log(it)
        }
    }
    job.join()
    println("All numbers are processed.")
    randomNumbers1.collect {
        log(it)
    }
}