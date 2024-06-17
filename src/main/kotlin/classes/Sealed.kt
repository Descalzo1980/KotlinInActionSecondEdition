package classes

sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
/*class Mul(val left: Expr, val right: Expr): Expr()*/

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
/*        is Mul -> TODO()*/
    }

sealed interface Toggleable {
    fun toggle()
}

data object LightSwitch : Toggleable {
    override fun toggle() = println("Lights!")
}

data object Camera : Toggleable {
    override fun toggle() = println("Camera!")
}