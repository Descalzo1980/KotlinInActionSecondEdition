package lambdas

fun <T> printMessagesWithPrefix(messages: List<T>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun <T> printProblemCounts(responses: List<T>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if ((it as String).startsWith("4")) {
            clientErrors++
        } else if ((it as String).startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

class Ref<T>(var value: T){
    override fun toString(): String = "value=$value"
}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    val errors1 = listOf(403, 404)
    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printMessagesWithPrefix(errors, "Error:")
    printMessagesWithPrefix(errors1, "Error:")
    printProblemCounts(responses)

    val counter = Ref(0)
    val inc = { counter.value++ }
    inc()
    println(counter)
}