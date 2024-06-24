package coroutines.cancellation

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    runBlocking {
        val job1 = launch {
            repeat(3) {
                doCpuHeavyWork()
            }
        }
        val job2 = launch {
            repeat(3) {
                doCpuHeavyWork()
            }
        }
        job1.join()
        job2.join()
    }
}

suspend fun doCpuHeavyWork(): Int {
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
        yield()
    }
    println("Выполнено CPU-тяжелая работа, счетчик: $counter")
    return counter
}


