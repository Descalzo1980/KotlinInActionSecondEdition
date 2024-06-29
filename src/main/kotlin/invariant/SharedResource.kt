package invariant

import java.util.concurrent.locks.ReentrantLock

class SharedResource {
    private val lock = ReentrantLock()

    private var x: Int = 0
    private var y: Int = 0

    // Инвариант: x + y должно всегда равняться 100
    fun updateValues(newX: Int, newY: Int) {
        lock.lock()
        try {
            if (newX + newY != 100) {
                throw IllegalArgumentException("Инвариант нарушен: x + y должно быть равно 100")
            }
            x = newX
            y = newY
        } finally {
            lock.unlock()
        }
    }

    fun getValues(): Pair<Int, Int> {
        lock.lock()
        try {
            return Pair(x, y)
        } finally {
            lock.unlock()
        }
    }
}

fun main() {
    val resource = SharedResource()

    // Создаем несколько потоков для обновления значений
    val thread1 = Thread {
        resource.updateValues(40, 60)
        println("Thread 1: ${resource.getValues()}")
    }

    val thread2 = Thread {
        resource.updateValues(70, 30)
        println("Thread 2: ${resource.getValues()}")
    }
    // выкинет ошибку
    val thread3 = Thread {
        resource.updateValues(60, 30)
        println("Thread 2: ${resource.getValues()}")
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}