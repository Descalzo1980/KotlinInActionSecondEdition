package basic

fun max(a: Int, b: Int): Int = if(a > b) a else b

/*fun max(a: Int, b: Int): Int = if (a > b) a else b*/

fun main(){
    println(max(a = 3,b = 5))

    val result: String = if (canPerformOperation()) {
        "Success"
    } else {
        "Can't perform operation"
    }
    println(result == "Success")

    val language = mutableListOf("Java")
    language.add("Kotlin")

    var answer = 42.customToString()
    println(answer)
    answer = "no answer"
    println(answer)

    val input = readln()
    val name = input.ifBlank { "Kotlin" }
    println("Hello, $name!")
    println("\$x")

}

fun canPerformOperation(): Boolean {
    return true
}

fun Int.customToString(): String{
    return this.toString()
}