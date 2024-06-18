package classes

import kotlin.random.Random

class MyClass {
    companion object {
        fun callMe() {
            println("Companion object called")
        }
    }
}
fun main() {
    MyClass.callMe()

/*    val myObject = MyClass()
    myObject.callMe()*/
    val chance = Random.nextInt(from = 0, until = 100)
    val coin = Random.Default.nextBoolean()
    val subscribingUser = UserCO.newSubscribingUser("bob@gmail.com")
    val socialUser = UserCO.newSocialUser(4)
    println(subscribingUser.nickname)
    println(socialUser.nickname)

    }


class UserCO private constructor(val nickname: String) {

    companion object {

        fun newSubscribingUser(email: String) =
            UserCO(email.substringBefore('@'))
        fun newSocialUser(accountId: Int) =
            UserCO(getNameFromSocialNetwork(accountId))
    }
}