package basic

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}


fun main(){
    println(isLetter('q'))
    println(isLetter('c'))
    println(isNotDigit('с'))
    println(isLetter('с')) // rus c )))) false
    println(recognize('d'))
    println(recognize('1'))
    println(recognize('$'))

    println("Kotlin" in "Java".."Scala")
}