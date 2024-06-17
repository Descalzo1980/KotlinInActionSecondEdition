package basic

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}
fun main() {
    parsePath("file:///C:/Users/79046/Desktop/Aigner%20S.%20Kotlin%20in%20Action%202ed%202024.pdf")
}