package collections

fun main(){
    val names = listOf("Joe", "Mary", "Jamie")
    val ages = listOf(22, 31, 31, 44, 0)
    println(names.zip(ages))
    println(names.zip(ages) { name, age -> Person(name, age) })
    println(names zip ages)
    val countries = listOf("DE", "NL", "US")
    println(names zip ages zip countries)
}