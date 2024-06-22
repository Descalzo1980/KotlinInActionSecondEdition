package nullable

fun strLen(s: String?) = s?.length ?: "Placeholder"

fun strLenSafe(s: String?): Int =
    s?.length ?: 0

fun printAllCaps(str: String?) {
    val allCaps: String? = str?.uppercase()
    println(allCaps)
}

fun ignoreNulls(str: String?) {
    val strNotNull: String = str!!
    println(strNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun main() {
    println(strLenSafe(null))
    println(strLen(null))
    printAllCaps(null)
    printAllCaps("abc")
    val ceo = Employee("Yes Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val person = Person("Dmitry", null)
    val address = Address("Dmitry", 123456,"Ololo","Boo")
    println(person.countryName())
    println(address.street())
/*    ignoreNulls(null)*/

    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}

class Address(
    val streetAddress: String,
    val zipCode: Int,
    val city: String,
    val country: String
)

class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return country ?: "Unknown"
}
fun Address.street(): String {
    return this.streetAddress
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name