package basic

interface Expr {
    class Num(val value : Int): Expr
    class Sum(val left : Expr,val right : Expr): Expr
}

fun eval(e: Expr): Int{
    if(e is Expr.Num){
        val n = e as Expr.Num
        return n.value
    }
    if(e is Expr.Sum){
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun main() {
    println(eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))))
}
