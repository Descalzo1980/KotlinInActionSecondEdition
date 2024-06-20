package collections

fun main() {
    val names = mutableListOf("Martin", "Samuel")
    val secondNames = mutableListOf<String>()
    val thirdNames = mutableListOf("1", "2", "3")
    println(names)
    // [Martin, Samuel]
    names.replaceAll { it.uppercase() }
    println(names)
    // [MARTIN, SAMUEL]
    names.fill("(redacted)")
    println(names)
    // [(redacted), (redacted)]
    checkName(secondNames)
    checkName(thirdNames)
}

fun checkName(name: MutableList<String>) {
    if (name.isEmpty()) {
        name.add("Empty list")
    }else {
        name.add("Non-empty list")
    }
    println(name)
}
