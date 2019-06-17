/**
 * 根据前序遍历和中序遍历建立树
 */

class No06 {

    fun main() {
        val preOrder = "12473568"
        val midOrder = "47215386"
        BiTree(preOrder, midOrder).also {
            it.print()
        }
    }
}

class BiTree(preOrder: String, midOrder: String) {
    var root: TreeNode? = null

    init {
        if (preOrder.isEmpty() || midOrder.isEmpty()) {
            root = null
        } else {
            if (preOrder.length == 1) {
                root = TreeNode(preOrder[0])
            } else {
                val rootData = preOrder[0]
                val rootIndex = midOrder.indexOf(rootData)
                root = TreeNode(rootData)
                root?.leftChild = BiTree(preOrder.substring(1, rootIndex + 1), midOrder.substring(0, rootIndex)).root
                root?.rightChild = BiTree(preOrder.substring(rootIndex + 1), midOrder.substring(rootIndex + 1)).root
            }
        }
    }

    fun print() {
        println("前序遍历：========= ")
        printPre(root)
        println("\n中序遍历：========= ")
        printMid(root)
        println("\n后序遍历：========= ")
        printPost(root)
    }

    fun printPre(rootNode: TreeNode?) {
        if (rootNode != null) {
            print(rootNode.data)
            printPre(rootNode.leftChild)
            printPre(rootNode.rightChild)
        }
    }

    fun printMid(rootNode: TreeNode?) {
        if (rootNode != null) {
            printMid(rootNode.leftChild)
            print(rootNode.data)
            printMid(rootNode.rightChild)
        }
    }

    fun printPost(rootNode: TreeNode?) {
        if (rootNode != null) {
            printPost(rootNode.leftChild)
            printPost(rootNode.rightChild)
            print(rootNode.data)
        }
    }
}

class TreeNode(var data: Char = ' ') {
    var leftChild: TreeNode? = null
    var rightChild: TreeNode? = null
}