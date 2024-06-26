package errors

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        println("[ERROR] ${e.message}")
    }
    private val scope = CoroutineScope(
        SupervisorJob() + dispatcher + exceptionHandler
    )
    fun action() = scope.launch {
        throw UnsupportedOperationException("Ouch!")
    }

    fun otherAction() = scope.launch {
        async {
            throw UnsupportedOperationException("Ouch!")
        }
    }

    fun otherOtherAction() = scope.async {
        launch {
            throw UnsupportedOperationException("Ouch!")
        }
    }
}

private val topLevelHandler = CoroutineExceptionHandler {
        _, e ->
    println("[TOP] ${e.message}")
}
private val intermediateHandler = CoroutineExceptionHandler { _, e ->
    println("[INTERMEDIATE] ${e.message}")
}



@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val supervisor = ComponentWithScope()
    supervisor.action()
    delay(1.seconds)

    GlobalScope.launch(topLevelHandler) {
        launch(intermediateHandler) {
            throw UnsupportedOperationException("Ouch!")
        }
    }
    Thread.sleep(1000)

    supervisor.otherAction()
    delay(1.seconds)

    supervisor.otherOtherAction()
    delay(1.seconds)
}