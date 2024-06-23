package destructuring

import embracing_kotlin.Point

fun main() {
    val p = Point(10, 20)
    val (x, y) = p
    println(x)
    // 10
    println(y)
    // 20

    val check = Check(1,2,3,4,5,6)
    val (a,b,c,d,e,t) = check
    println(t)

    val (name, ext) = splitFilename("example.kt")
    println(name)
    // example
    println(ext)
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}
fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

data class NameComponents(
    val name: String,
    val extension: String
)

fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

data class Check(
    val a: Int,
    val b: Int,
    val c: Int,
    val d: Int,
    val e: Int,
    val t: Int,
)
