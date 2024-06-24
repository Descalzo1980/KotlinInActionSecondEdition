package flow.operators

import coroutines.log
import flow.getTemperatures
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
data class Profile(
    val id: Int
)
fun getAllUserIds(): Flow<Int> {
    return flow {
        repeat(3) {
            delay(200.milliseconds) // Database latency
            log("Emitting!")
            emit(it)
        }
    }
}
suspend fun getProfileFromNetwork(id: Int): String {
    delay(2.seconds) // Network latency
    return "Profile[$id]"
}

fun main() {
    val scope = CoroutineScope(Dispatchers.Default) + SupervisorJob()

/*    val names = flow {
        emit("Jo")
        emit("May")
        emit("Sue")
    }
    val uppercasedNames = names.map {
        it.uppercase()
    }
    val upperAndLowercasedNames = names.transform {
        emit(it.uppercase())
        emit(it.lowercase())
    }
    runBlocking {
        uppercasedNames.collect { print("$it ")}
    }
    runBlocking {
        upperAndLowercasedNames.collect { print("$it ")}
    }*/

    runBlocking {
/*        val temps = getTemperatures()
        temps
            .take(5)
            .onStart {
                println("I am starting")
            }
            .onEach { int ->
                if(int <= 0){
                    println("This is too cold")
                }else{
                    println("This is too hot")
                }
            }
            .onCompletion { cause ->
                if (cause != null) {
                    println("An error occurred! $cause")
                } else {
                    println("Completed!")
                }
            }
            .collect {
                println(it)
            }*/

/*        runBlocking {
            getAllUserIds().collect { id ->
                val profile = getProfileFromNetwork(id)
                println(profile)
            }
        }*/

        val ids = getAllUserIds()
        runBlocking {
            ids
                .buffer(3)
                .map { getProfileFromNetwork(it) }
                .collect { log("Got $it") }
        }
    }
    runBlocking {
        val temps = getTemperatures()
        temps
            .onEach {
                log("Read $it from sensor")
            }
            .conflate()
            .collect {
                log("Collected $it")
                delay(1.seconds)
            }
    }
}