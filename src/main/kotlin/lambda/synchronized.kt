package lambda

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.locks.Lock

suspend inline fun <T> synchronized(lock: Mutex, action: () -> T): T {
    return lock.withLock {
        action()
    }
}

suspend fun main()  {
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    val lock = Mutex()
    val sharedList = mutableListOf<Int>()

    val add = scope.async {
        lock.withLock {
            for (i in 1..5) {
                sharedList.add(i)
                println("Added $i to the list")
            }
            println("Finished adding items")
        }
    }

    val read = scope.async {
        add.join()
        lock.withLock {
            for (item in sharedList) {
                println("Read $item from the list")
            }
            println("Finished reading items")
        }
    }

    add.await()
    read.await()
}