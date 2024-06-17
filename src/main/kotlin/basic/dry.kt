package basic

class User(val id: Int, val name: String, val address: String)
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address")
    }
    // Save user to the database

/********************************************************************/
    fun validate(user: User,
                 value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

/********************************************************************/
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " + "empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")

}


fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $id: empty $fieldName"
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUserNew(user: User): String {
    user.validateBeforeSave()
    return "User ${user.id} saved successfully"
}
fun main() {
/*    saveUser(User(1, "", ""))*/
    val result = saveUserNew(User(2,"Olol","Boo"))
    println(result)
// java.lang.IllegalArgumentException: Can't save user 1: empty Name
}