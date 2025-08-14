class ArrayList<T> {
    private var capacity = 16
    private var items : Array<T?> = arrayOfNulls(capacity)
    private var size = 0

    fun add(item : T) {
        resize()
        items[size] = item
        size++
    }

    fun add(position : Int, item : T) {
        if (position > size || position < 0) {
            throw IndexOutOfBoundsException("Position cannot be greater than size!")
        }
        resize()
        for (i in size - 1 downTo position) {
            items[i + 1] = items[i]
        }
        items[position] = item
        size++
    }

    fun get(position: Int) : T {
        checkIndex(position)
        return items[position]!!
    }

    fun set(position: Int, item: T) : T {
        checkIndex(position)
        val oldItem = items[position]
        items[position] = item
        return oldItem!!
    }

    fun remove(position: Int) : T {
        checkIndex(position)
        val removedItem = items[position]
        for (i in position until size - 1) {
            items[i] = items[i + 1]
        }
        items[size - 1] = null
        size--
        return removedItem!!
    }

    fun clear() {
        for (i in 0 until size) {
            items[i] = null
        }
        size = 0
    }

    fun contains(item : T) : Boolean {
        for (i in 0 until size) {
            if (items[i] == item) {
                return true
            }
        }
        return false
    }

    fun size() : Int = size

    fun isEmpty() : Boolean = size == 0

    private fun resize() {
        if (size == capacity) {
            capacity *= 2
            val newItems : Array<T?> = arrayOfNulls(capacity)
            for (i in 0..size - 1) {
                newItems[i] = items[i]
            }
            items = newItems
        }
    }

    private fun checkIndex(position : Int) {
        if (position >= size || position < 0) {
            throw IndexOutOfBoundsException("Index is incorrect!")
        }
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