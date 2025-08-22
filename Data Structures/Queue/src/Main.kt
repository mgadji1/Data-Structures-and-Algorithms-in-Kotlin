fun main() {
    val queue = Queue<Char>()

    queue.offer('a')
    queue.offer('f')
    queue.offer('k')

    println(queue)

    println(queue.poll())

    println(queue)

    println(queue.peek())

    println(queue.size())

    println(queue.poll())

    println(queue.isEmpty())

    println(queue.poll())

    println(queue.isEmpty())

    println(queue)
}