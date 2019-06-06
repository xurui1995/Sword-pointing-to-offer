/**
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建人和新的结点，只能调整树中结点指针的指向。
 */

public class No27 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(14);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(8);
        BinaryTreeNode node5 = new BinaryTreeNode(12);
        BinaryTreeNode node6 = new BinaryTreeNode(16);
        root.setLchildNode(node1);
        root.setRchildNode(node2);
        node1.setLchildNode(node3);
        node1.setRchildNode(node4);
        node2.setLchildNode(node5);
        node2.setRchildNode(node6);

        BinaryTreeNode head = covert(root);

        while (head != null) {
            System.out.println(head.getData());
            head = head.getRchildNode();
        }
    }

    private static BinaryTreeNode covert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeList = null;
        lastNodeList = convertNode(root, lastNodeList);
        while (lastNodeList != null && lastNodeList.getLchildNode() != null) {
            lastNodeList = lastNodeList.getLchildNode();
        }
        return lastNodeList;
    }

    private static BinaryTreeNode convertNode(BinaryTreeNode root,
                                              BinaryTreeNode lastNodeList) {
        if (root == null)
            return null;
        BinaryTreeNode current = root;
        if (current.getLchildNode() != null) {
            lastNodeList = convertNode(current.getLchildNode(), lastNodeList);
        }

        current.setLchildNode(lastNodeList);

        if (lastNodeList != null) {
            lastNodeList.setRchildNode(current);
        }
        lastNodeList = current;
        if (current.getRchildNode() != null) {
            lastNodeList = convertNode(current.getRchildNode(), lastNodeList);
        }
        return lastNodeList;
    }

}
