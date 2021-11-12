/**
 * 输入一个链表，输出该链表中倒数第K个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
 */

class No15 {

    fun main() {
        val a = Node("1")
        val b = Node("2")
        val c = Node("3")
        val d = Node("4")
        val e = Node("5")
        val f = Node("6")
        a.next = b
        b.next = c
        c.next = d
        d.next = e
        e.next = f

        println(getNodeFromTail(a, 1))
        println(getNodeFromTail(a, 2))
        println(getNodeFromTail(a, 3))
        println(getNodeFromTail(a, 4))
    }


    fun getNodeFromTail(head: Node, n: Int): Node? {
        var slow: Node? = head
        var fast: Node? = head
        for (i in 0 until n - 1) {
            fast = fast?.next
            if (fast == null) {
                return null
            }
        }

        while (fast?.next != null) {
            fast = fast.next
            slow = slow?.next
        }

        return slow
    }
}