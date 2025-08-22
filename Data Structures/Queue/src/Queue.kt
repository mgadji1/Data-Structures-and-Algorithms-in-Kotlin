class Queue<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    private var size = 0

    fun offer(value : T) {
        if (headNullCase(value)) return
        val newNode = Node(value)
        tail?.next = newNode
        tail = newNode
        size++
    }

    fun poll() : T? {
        if (head == null) return null
        val value = oneItemCase()
        if (value != null) return value
        val removedItem = head
        head = head?.next
        removedItem?.next = null
        size--
        return removedItem?.value
    }

    fun peek() : T? = head?.value

    fun isEmpty() : Boolean = size == 0

    fun size() : Int = size

    private fun oneItemCase() : T? {
        if (head == tail) {
            val removedItem = head
            head = null
            tail = null
            size--
            return removedItem?.value
        }
        return null
    }

    private fun headNullCase(value: T) : Boolean {
        if (head == null) {
            head = Node(value)
            tail = head
            size++
            return true
        }
        return false
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("[")
        var item = head
        for (i in 0 until size) {
            if (i == size - 1) {
                stringBuilder.append("${item?.value}")
            }
            else {
                stringBuilder.append("${item?.value}, ")
            }
            item  = item?.next
        }
        stringBuilder.append("]")
        return stringBuilder.toString()
    }
}