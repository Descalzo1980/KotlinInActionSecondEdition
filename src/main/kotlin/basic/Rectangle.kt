package basic

class Rectangle(private val height: Int, private val width: Int ) {
    val isSquare: Boolean
        get() = height == width


    fun createUnitSquare(): Rectangle {
        return Rectangle(1, 1)
    }


}

fun main(){
    val rect1 = Rectangle(3, 4)
    println(rect1.isSquare)
    // false

    val unitSquare = rect1.createUnitSquare()
    println(unitSquare.isSquare)
    // true
}