package flow

import coroutines.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

class ViewCounter {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun increment() {
        _counter.update { it + 1 }
    }
}


enum class Direction { LEFT, RIGHT }

class DirectionSelector {
    private val _direction = MutableStateFlow(Direction.LEFT)
    val direction = _direction.asStateFlow()
    fun turn(d: Direction) {
        _direction.update { d }
    }
}


fun main() = runBlocking{
    val vc = ViewCounter()
    vc.increment()
    println(vc.counter.value)
    // 1


    val switch = DirectionSelector()
    launch {
        switch.direction.collect {
            log("Direction now $it")
        }
    }
    delay(200.milliseconds)
    switch.turn(Direction.RIGHT)
    delay(200.milliseconds)
    switch.turn(Direction.LEFT)
    delay(200.milliseconds)
    switch.turn(Direction.LEFT)
}