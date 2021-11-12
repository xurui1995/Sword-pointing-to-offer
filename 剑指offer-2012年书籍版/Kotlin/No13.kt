/**
 * 给定单向链表的头指针和一个结点指针， 定义一个函数在O（1）时间删除该节点
 */

class No13 {

    fun main() {
        val node1 = Node("1")
        val node2 = Node("2")
        val node3 = Node("3")
        val node4 = Node("4")
        node1.next = node2
        node2.next = node3
        node3.next = node4

        var head = delete(node1, node3)

        while (head != null) {
            println(head.data)
            head = head.next
        }
    }

    fun delete(head: Node, target: Node): Node? {
        if (target.next == null) {
            // 只能遍历删除
            if (head == target) {
                return null
            } else {
                var temp: Node = head
                while (temp.next != target) {
                    temp = temp.next!!
                }
                temp.next = temp.next?.next
            }
        } else {
            target.data = target.next?.data
            target.next = target.next?.next
        }

        return head
    }
}