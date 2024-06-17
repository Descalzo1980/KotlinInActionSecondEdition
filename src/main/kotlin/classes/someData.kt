package classes

class Customer(val name: String, val postalCode: Int) {
    override fun toString() = "Customer(name=$name, postalCode=$postalCode)"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Customer)
        return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

data class CustomerData(val name: String, val postalCode: Int)

fun main(){
    val customer = Customer(name = "First", postalCode = 123456)
    val customer1 = Customer(name = "First", postalCode = 123456)
    val processed = hashSetOf(Customer(name = "First", postalCode = 123456))
    println(processed.contains(Customer(name = "First", postalCode = 123456)))
    println(customer)
    println(customer == customer1)
    println(customer === customer1)
    println(customer.hashCode())
    println(customer1.hashCode())
}
