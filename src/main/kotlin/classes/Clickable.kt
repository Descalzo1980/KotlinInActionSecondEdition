package classes

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}


open class Button(): Clickable,Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}
class SubButton(): Button(){
    fun onClick() = println("I SubButton")
}


open class RichButton : Clickable {
    fun disable() { println("I RichButton disable") }
    open fun animate() { println("I RichButton animate") }
    override fun click() { println("I RichButton click") }
}

class SubRichButton(private val richButton: RichButton){

    fun sub(){
        richButton.animate()
        richButton.disable()
        richButton.click()
    }
}

fun main(){
    val richButton = RichButton()
    Button().click()
    Button().showOff()
    Button().setFocus(false)
    SubButton().onClick()
    SubButton().click()
    SubRichButton(richButton).sub()
}