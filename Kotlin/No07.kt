import java.lang.Exception
import java.util.*


/**
 * 两个栈建立队列
 */

class No07 {

    fun main() {
        val queue = MyQueue().apply {
            offer("a")
            offer("b")
            offer("c")
            println(peek())
            poll()
            println(peek())
            offer("d")
            poll()
            println(peek())

        }
    }
}

class MyQueue {

    private val stack1 = Stack<String>()
    private val stack2 = Stack<String>()

    fun offer(str: String) {
        stack1.push(str)
    }

    fun poll() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw Exception("empty queue")
            } else {
                while (stack1.isNotEmpty()) {
                    stack2.push(stack1.pop())
                }

            }
        }
        stack2.pop()
    }

    fun peek(): String {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw Exception("empty queue")
            } else {
                while (stack1.isNotEmpty()) {
                    stack2.push(stack1.pop())
                }

            }
        }
        return stack2.peek()
    }
}