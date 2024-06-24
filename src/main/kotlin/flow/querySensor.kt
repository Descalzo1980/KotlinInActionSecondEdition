package flow

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

fun querySensor(): Int = Random.nextInt(-10..30)
fun getTemperatures(): Flow<Int> {
    return flow {
        while (true) {
            emit(querySensor())
            delay(500.milliseconds)
        }
    }
}

fun celsiusToFahrenheit(celsius: Int) =
    celsius * 9.0 / 5.0 + 32.0

fun main() {
    /*1*/
    val temps = getTemperatures()
    runBlocking {
        launch {
            temps.collect {
                log("$it Celsius")
            }
        }
        launch {
            temps.collect {
                log("${celsiusToFahrenheit(it)} Fahrenheit")
            }
        }

        /*2*/
        val sharedTemps = temps.stateIn(this)
        //val sharedTemps = temps.shareIn(this, SharingStarted.Lazily)
        launch {
            sharedTemps.collect {
                log("$it Celsius")
            }
        }
        launch {
            sharedTemps.collect {
                log(
                    "${celsiusToFahrenheit(it)} Fahrenheit")
            }
        }
    }
}