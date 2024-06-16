package basic

interface Expr {
    class Num(val value : Int): Expr
    class Sum(val left : Expr,val right : Expr): Expr
}

/*fun eval(e: Expr): Int{
    if(e is Expr.Num){
        val n = e as Expr.Num
        return n.value
    }
    if(e is Expr.Sum){
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}*/

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Expr.Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Expr.Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println(eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), (Expr.Sum(Expr.Num(1), Expr.Num(2))))))

    println(evalWithLogging(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))))
}

/*Определение интерфейса Expr
Интерфейс Expr представляет собой алгебраическое выражение. Внутри него определены два класса:

Num,value типа Int.
Sum, представляющий сумму двух выражений с двумя свойствами left и `rightright, обаExpr.
Функция eval
Функция eval принимает параметр e типа `ExprExpr и возвращает Int.

Логика функции eval:
Если e является экземпляром класса Expr.Num, то:

Приводим e к типу Expr.Num (хотя это приведение избыточно, так как e уже определен как Expr.Num).
Возвращаем значение свойства value.
Если e является экземпляром класса Expr.Sum, то:

Рекурсивно вызываем eval для правого и левого подвыражений.
Складываем результаты и возвращаем сумму.
Если e не является ни Expr.Num, ни Expr.Sum, выбрасывается исключение IllegalArgumentException с сообщением "Unknown expression".

Функция main
Функция main выполняет следующие шаги:

Создает выражение Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)).

Внутреннее выражение Expr.Sum(Expr.Num(1), Expr.Num(2)) представляет собой сумму чисел 1 и 2.
Внешнее выражение представляет собой сумму результата внутреннего выражения и числа 4.
Вызывает функцию eval с этим выражением.

Печатает результат вычисления.

Разбор выражения
Конкретное выражение Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)):

Внутреннее выражение Expr.Sum(Expr.Num(1), Expr.Num(2)):

Expr.Num(1) - это число 1.
Expr.Num(2) - это число 2.
eval вычисляет сумму 1 и 2, получаем 3.
Внешнее выражение Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4)):

Expr.Sum(Expr.Num(1), Expr.Num(2)) уже вычислено и равно 3.
Expr.Num(4) - это число 4.
eval вычисляет сумму 3 и 4, получаем 7.
Таким образом, результат выполнения программы будет 7, и это значение будет выведено на экран.*/
