package lambdas

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}
fun main() {
    createAllDoneRunnable().run()
    // All done!
}
