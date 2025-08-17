fun main() {
    val linkedList = LinkedList<Int>()

    linkedList.pushFront(10)
    linkedList.pushFront(15)

    println(linkedList)

    linkedList.pushBack(20)
    linkedList.pushBack(25)

    println(linkedList)

    linkedList.popBack()

    linkedList.popFront()

    println(linkedList)

    println(linkedList.size())

    println(linkedList.get(0))

    println(linkedList.set(0, 100))

    println(linkedList)

    println(linkedList.contains(100))
    println(linkedList.contains(200))

    println(linkedList.isEmpty())

    linkedList.clear()

    println(linkedList.isEmpty())

    println(linkedList)
}