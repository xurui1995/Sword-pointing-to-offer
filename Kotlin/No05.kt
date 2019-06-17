class No05 {

    fun main() {
        val node1 = Node("A")
        val node2 = Node("B")
        val node3 = Node("C")
        val node4 = Node("D")
        val node5 = Node("E")
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        var newNode: Node? = reverseNode1(node1)
        // var newNode: Node? = reseverNode2(node1)
        while (newNode != null) {
            print(newNode.data)
            newNode = newNode.next
        }
    }

    fun reverseNode1(node: Node): Node {
        if (node.next == null) {
            return node
        }
        val reverseHead = reverseNode1(node.next!!)
        node.next!!.next = node
        node.next = null
        return reverseHead
    }

    fun reseverNode2(node: Node): Node {
        var pre = node
        var cur = pre.next
        pre.next = null
        var temp: Node? = null
        while (cur != null) {
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        }
        return pre
    }
}
