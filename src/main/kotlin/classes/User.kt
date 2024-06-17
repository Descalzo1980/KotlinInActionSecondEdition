package classes

interface UserUser {
    val nickname: String
}


interface EmailUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val nickname: String) : UserUser

class SubscribingUser(val email: String) : UserUser {
    override val nickname: String
        get() = email.substringBefore('@')

}

class SocialUser(val accountId: Int) : UserUser {
    override val nickname = getNameFromSocialNetwork(accountId)
}

fun getNameFromSocialNetwork(accountId: Int) = "kodee$accountId"


fun main() {
    println(PrivateUser("kodee").nickname)
    // kodee
    println(SubscribingUser("test@kotlinlang.org").nickname)
    // test
    println(SocialUser(123).nickname)
    // kodee123
}