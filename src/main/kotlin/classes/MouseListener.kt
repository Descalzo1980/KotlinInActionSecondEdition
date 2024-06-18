package classes

interface MouseListener {
    fun onEnter()
    fun onClick()
}

class ButtonCO(private val listener: MouseListener) {
    fun simulateEnter() {
        listener.onEnter()
    }

    fun simulateClick() {
        listener.onClick()
    }
}

fun main() {
    var clickCount = 0
    val button = ButtonCO(object : MouseListener {
        override fun onEnter() {
            println("I enter")
        }
        override fun onClick() {
            println("I click")
            clickCount++
        }
    })
    button.simulateEnter()
    button.simulateClick()
    println(clickCount)
}