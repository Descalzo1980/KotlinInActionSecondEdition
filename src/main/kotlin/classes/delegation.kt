package classes

class CountingSet<T>(
    private val innerSet: MutableCollection<T> = hashSetOf<T>()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }
    override fun addAll(elements: Collection<T>): Boolean
    {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }

    override fun remove(element: T): Boolean {
        objectsAdded--
        return innerSet.remove(element)
    }
}
fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("Added ${cset.objectsAdded} objects, ${cset.size} uniques.")
    // Added 3 objects, 2 uniques.
    cset.remove(cset.last())
    println("Remove ${cset.objectsAdded} objects, ${cset.size} uniques.")
}
