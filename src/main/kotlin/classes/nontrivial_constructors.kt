package classes

import java.net.URI

data class User(
    val nickname: String,
    val isSubscribed: Boolean = true
)

class User1 constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
}

fun main() {
    val alice = User(nickname = "Alice")
    val newName = alice.copy(nickname = "Boo")
    println(alice.isSubscribed)
    println(newName)
    // true
    val bob = User("Bob", false)

    println(bob.isSubscribed)
    // false
    val carol = User("Carol", isSubscribed = false)

    println(carol.isSubscribed)
    // false
    val dave = User(nickname = "Dave", isSubscribed = true
    )
    println(dave.isSubscribed)
    // true

    val downloaderStr = Downloader("http//google.com")
    val downloaderUri = Downloader("foo://example.com:8042/over/there?name=ferret#nose")
}

open class EmptyConstructor

class SubEmptyConstructor: EmptyConstructor()

open class Downloader {
    constructor(url: String?) {
        // some code
    }
    constructor(uri: URI?) {
        // some code
    }
}

class MyDownloader : Downloader {
    constructor(url: String?) : this(url?.let { URI(it) })
    constructor(uri: URI?) : super(uri)
}
