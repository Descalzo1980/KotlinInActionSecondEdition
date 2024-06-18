package classes

interface PrettyPrintable {
    fun prettyPrint()
}
@JvmInline
value class UsdCent(private val amount: Int): PrettyPrintable {
    val salesTax get() = amount * 0.06
    override fun prettyPrint() = println("${amount}¢")
}
fun main() {
    val expense = UsdCent(1_99)
    println(expense.salesTax)
    expense.prettyPrint()
}