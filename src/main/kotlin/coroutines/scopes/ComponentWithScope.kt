package coroutines.scopes

import coroutines.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds


fun main() = runBlocking {
    val scope = CoroutineScope(currentCoroutineContext())
    scope.launch {
        val c = ComponentWithScope()
        c.start()
        delay(2000)
        c.stop()
        launch(Dispatchers.IO) {
            test()
        }
    }.join()
}

class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    private val scope = CoroutineScope(dispatcher + SupervisorJob())
    fun start() {
        log("Starting!")
        scope.launch {
            while (true) {
                delay(500.milliseconds)
                log("Component working!")
            }
        }
        scope.launch {
            log("Doing a one-off task...")
            delay(500.milliseconds)
            log("Task done!")
        }
    }

    fun stop() {
        log("Stopping!")
        scope.cancel()
    }
}

suspend fun test() = coroutineScope {
    launch {
        val a = 5
        val b = 10
        println(a + b)
    }
}