package classes

internal open class TalkativeButton {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

private class SubTalkativeButton: TalkativeButton(){

}

/*fun TalkativeButton.giveSpeech() {
    yell()
    whisper()
}*/

fun main(){
    val subTalkativeButton = SubTalkativeButton()
/*    subTalkativeButton.giveSpeech()
    subTalkativeButton.whisper()
    subTalkativeButton.yell()*/
}