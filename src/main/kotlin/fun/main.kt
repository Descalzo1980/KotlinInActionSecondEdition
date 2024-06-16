package `fun`

fun main(){
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fiftyThree")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    println(set.shuffled())
    println(set.last())
    println(set.first())
    println(set.sum())
    println(list.joinToString("; ", "", ";"))

    println(list.joinToString(postfix = ";", prefix = "# "))
}