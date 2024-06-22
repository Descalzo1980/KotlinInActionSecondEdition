package collections_and_arrays

fun <T> copyElements(
    source: Collection<T>,
    target: MutableCollection<T>
) {
    for (item in source) {
        target.add(item)
    }
}

fun main(){
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Any> = arrayListOf("1")
    copyElements(source, target)
    println(target)

    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))
/*    letters[27] = "DDD"*/

    val letters1 = ArrayList<String>()
    for (i in 0..<26) {
        letters1.add(('a' + i).toString())
    }
    println(letters.joinToString(""))

    letters1.add("DDD")
    println(letters1.joinToString(""))

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

    val numbersArray = intArrayOf(1, 2, 3, 4, 5)
    printNumbers(*numbersArray)
}

fun printNumbers(vararg numbers: Int) {
    for (number in numbers) {
        print("$number ")
    }
    println()
}