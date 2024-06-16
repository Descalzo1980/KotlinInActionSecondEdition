package basic

fun main(){
    val binaryReps = mutableMapOf<Char, String>()
    println(binaryReps.keys)
    println(binaryReps.values)
    for (char in 'A'..'F') {
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
/*        binaryReps.put(char,binary)
        public fun put(key: K, value: V): V?*/
    }
    println(binaryReps.keys)
    println(binaryReps.values)

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}