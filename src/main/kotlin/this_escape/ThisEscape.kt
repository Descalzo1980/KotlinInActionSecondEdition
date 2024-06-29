package this_escape

// Интерфейс слушателя событий
interface EventListener {
    fun onEvent(e: Event)
}

// Класс события (может быть любым объектом, представляющим событие)
class Event(val message: String)

// Источник событий, который регистрирует слушателей и генерирует события
class EventSource {
    private val listeners = mutableListOf<EventListener>()

    fun registerListener(listener: EventListener) {
        listeners.add(listener)
    }

    fun generateEvent(message: String) {
        val event = Event(message)
        for (listener in listeners) {
            listener.onEvent(event)
        }
    }
}

// Класс ThisEscape, подверженный проблеме "this escape"
class ThisEscape(source: EventSource) {
    init {
        source.registerListener(object : EventListener {
            override fun onEvent(e: Event) {
                doSomething(e)
            }
        })
    }

    private fun doSomething(e: Event) {
        println("Received event: ${e.message}")
    }
}

// Пример использования
fun main() {
    val source = EventSource()
    val thisEscape = ThisEscape(source)

    // Генерируем событие
    source.generateEvent("Hello, world!")
}