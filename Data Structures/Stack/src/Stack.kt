import java.util.EmptyStackException

class Stack<T> {
    private var capacity = 16
    private var items : Array<T?> = arrayOfNulls(capacity)
    private var size = 0

    fun push(item : T) {
        resize()
        items[size] = item
        size++
    }

    fun peek() : T {
        checkEmptyStack()
        return items[size - 1]!!
    }

    fun pop() : T {
        checkEmptyStack()
        val removedItem = items[size - 1]!!
        items[size - 1] = null
        size--
        return removedItem
    }

    fun size() : Int = size

    fun isEmpty() : Boolean = size == 0

    private fun resize() {
        if (size == capacity) {
            capacity *= 2
            val newItems : Array<T?> = arrayOfNulls(capacity)
            for (i in 0 until size) {
                newItems[i] = items[i]
            }
            items = newItems
        }
    }

    private fun checkEmptyStack() {
        if (size == 0) throw EmptyStackException()
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("[")
        for (i in 0 until size) {
            if (i == size - 1) {
                stringBuilder.append("${items[i]}")
            }
            else {
                stringBuilder.append("${items[i]}, ")
            }
        }
        stringBuilder.append("]")
        return stringBuilder.toString()
    }
}