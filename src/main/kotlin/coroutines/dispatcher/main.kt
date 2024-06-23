package coroutines.dispatcher

import coroutines.log
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.coroutineContext
import kotlin.time.Duration.Companion.seconds

fun main() {
    runBlocking {
        log("Doing some work")
        launch(Dispatchers.Default) {
            log("Doing some background work")
        }
    }

    runBlocking {
        launch(Dispatchers.Default) {
            var x = 0
            repeat(10_000) {
                x++
            }
            println(x)
        }
    }
    val mutex = Mutex()
    runBlocking {
        var x = 0
        repeat(10_000) {
            launch(Dispatchers.Default) {
                mutex.withLock {
                    x++
                }
            }
        }
        delay(1.seconds)
        println(x)
    }

    runBlocking {
        val x = AtomicInteger(0)
        repeat(10_000) {
            launch(Dispatchers.Default) {
                x.incrementAndGet()
            }
        }
        delay(1.seconds)
        println(x)
        introspect()
    }

    runBlocking(Dispatchers.IO + CoroutineName("Coolroutine")) {
        introspect()
    }
}

suspend fun introspect() {
    log(coroutineContext)
}
