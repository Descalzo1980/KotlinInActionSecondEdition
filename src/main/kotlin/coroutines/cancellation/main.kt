package coroutines.cancellation

import coroutines.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main() {
    runBlocking {
        val launchedJob = launch {
            log("I'm launched!")
            delay(1000.milliseconds)
            log("I'm done!")
        }
        val asyncDeferred = async {
            log("I'm async")
            delay(1000.milliseconds)
            log("I'm done!")
        }
        delay(200.milliseconds)
        launchedJob.cancel()
        asyncDeferred.cancel()


        val quickResult = withTimeoutOrNull(500.milliseconds)
        {
            calculateSomething()
        }
        println("quickResult  $quickResult")
        // null
        val slowResult = withTimeoutOrNull(5.seconds) {
            calculateSomething()
        }
        println("slowResult $slowResult")
        // 4


        val job = launch {
            launch {
                launch {
                    launch {
                        log("I'm started")
                        delay(500.milliseconds)
                        log("I'm done!")
                    }
                }
            }
        }
        delay(200.milliseconds)
        job.cancel()

        runBlocking {
            withTimeoutOrNull(2.seconds) {
                while (true) {
                    try {
                        doWork()
                    } catch (e: Exception) {
                        println("Oops: ${e.message}")
                    }
                }
            }
        }
    }
}


suspend fun calculateSomething(): Int {
    delay(3.seconds)
    return 2 + 2
}

suspend fun doWork() {
    delay(500.milliseconds)
    throw UnsupportedOperationException("Didn't work!")
}