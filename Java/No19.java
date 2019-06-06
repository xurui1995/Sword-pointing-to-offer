/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */

public class No19 {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);
        node1.setLchildNode(node2);
        node1.setRchildNode(node3);
        node2.setLchildNode(node4);
        node2.setRchildNode(node5);
        node3.setLchildNode(node6);
        node3.setRchildNode(node7);
        mirror(node1);
        print(node1);
    }

    private static void print(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            print(root.getLchildNode());
            print(root.getRchildNode());
        }
    }

    private static void mirror(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLchildNode() == null && root.getRchildNode() == null) {
            return;
        }
        BinaryTreeNode temp = root.getLchildNode();
        root.setLchildNode(root.getRchildNode());
        root.setRchildNode(temp);
        mirror(root.getLchildNode());
        mirror(root.getRchildNode());
    }

}
