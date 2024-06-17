package classes

abstract class Animated {
    abstract val animationSpeed: Double
    val keyframes: Int = 20
    open val frames: Int = 60
    abstract fun animate()
    open fun stopAnimating() { println("Stop") }
    fun animateTwice() { println("Twice") }
}

class SubAnimated(override val animationSpeed: Double): Animated(){

    /*override val animationSpeed: Double = 1.5*/

    override fun animate() {
        println("Let's play")
    }
}

fun main(){
    val animated = SubAnimated(1.5)
    val frame = animated.frames
    val keyFrame = animated.keyframes
    animated.stopAnimating()
    animated.animateTwice()
    animated.animate()
    println("$frame $keyFrame")
}