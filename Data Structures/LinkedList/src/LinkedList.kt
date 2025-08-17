class LinkedList<T> {
    private var head : Node<T>? = null
    private var tail : Node<T>? = null
    private var size = 0

    fun pushFront(value : T) {
        if (headNullCase(value)) return
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        size++
    }

    fun pushBack(value : T) {
        if (headNullCase(value)) return
        val newNode = Node(value)
        tail?.next = newNode
        tail = newNode
        size++
    }

    fun popFront() : T? {
        if (head == null) {
            return null
        }
        val value = oneItemCase()
        if (value != null) return value
        val removedItem = head
        head = head?.next
        removedItem?.next = null
        size--
        return removedItem?.value
    }

    fun popBack() : T? {
        if (tail == null) {
            return null
        }
        val value = oneItemCase()
        if (value != null) return value
        val removedItem = tail
        var neighbor = head
        while (neighbor?.next != tail) {
            neighbor = neighbor?.next
        }
        neighbor?.next = null
        tail = neighbor
        size--
        return removedItem?.value
    }

    fun isEmpty() : Boolean = size == 0

    fun size() : Int = size

    fun get(position : Int) : T? {
        checkIndex(position)
        var tempItem = head
        repeat (position) {
            tempItem = tempItem?.next
        }
        return tempItem?.value
    }

    fun contains(value : T) : Boolean {
        var tempItem = head
        while (tempItem != null) {
            if (tempItem.value == value) return true
            tempItem = tempItem.next
        }
        return false
    }

    fun clear() {
        var tempItem = head
        while (tempItem != null) {
            val next = tempItem.next
            tempItem.next = null
            tempItem = next
        }
        head = null
        tail = null
        size = 0
    }

    fun set(position: Int, value: T) : T {
        checkIndex(position)
        var tempItem = head
        repeat(position) {
            tempItem = tempItem?.next
        }
        val oldValue = tempItem!!.value
        tempItem.value = value
        return oldValue
    }

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

    private fun checkIndex(position: Int) {
        if (position < 0 || position >= size) {
            throw IndexOutOfBoundsException("Index is incorrect")
        }
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