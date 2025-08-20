fun main() {
    val stack = Stack<String>()

    stack.push("Mark")
    stack.push("Alice")
    stack.push("Bob")

    println(stack)

    println(stack.pop())

    println(stack)

    println(stack.peek())

    println(stack.size())

    println(stack.isEmpty())

    println(stack.pop())
    println(stack.pop())

    println(stack.isEmpty())

    println(stack)
}