package classes

import java.io.File

object Payroll {
    val allEmployees = mutableListOf<PersonPay>()
    fun calculateSalary() {
        for (person in allEmployees) {
            person.salary = 1000
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path,
            ignoreCase = true)
    }
}

fun main(){

    Payroll.allEmployees.add(PersonPay(name = "Boo", salary = 2000))
    Payroll.allEmployees.add(PersonPay(name = "Last"))

    for (person in Payroll.allEmployees) {
        println("Name: ${person.name}, Salary: ${person.salary}")
    }

    println(
        CaseInsensitiveFileComparator.compare(
            File("/User"), File("/user")
        )
    )

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(PersonPay("Bob"), PersonPay("Alice"))
    println(persons.sortedWith(PersonCorp.NameComparator))

    Payroll.calculateSalary()

}

data class PersonPay(
    val name: String,
    var salary: Int = 0
)

data class PersonCorp(val name: String) {
    object NameComparator : Comparator<PersonPay> {
        override fun compare(p1: PersonPay, p2: PersonPay): Int = p1.name.compareTo(p2.name)
    }
}