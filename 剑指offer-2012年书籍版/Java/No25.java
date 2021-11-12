import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

public class No25 {

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(12);
        root.setLchildNode(node1);
        root.setRchildNode(node4);
        node1.setLchildNode(node2);
        node1.setRchildNode(node3);
        findPath(root, 22);
    }

    private static void findPath(BinaryTreeNode root, int i) {
        if (root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root, i, stack, currentSum);
    }

    private static void findPath(BinaryTreeNode root, int i,
                                 Stack<Integer> stack, int currentSum) {
        currentSum += root.getData();
        stack.push(root.getData());
        if (root.getLchildNode() == null && root.getRchildNode() == null) {
            if (currentSum == i) {
                System.out.println("找到路径");
                for (int path : stack) {
                    System.out.println(path + " ");
                }
            }
        }
        if (root.getLchildNode() != null) {
            findPath(root.getLchildNode(), i, stack, currentSum);
        }
        if (root.getRchildNode() != null) {
            findPath(root.getRchildNode(), i, stack, currentSum);
        }

        stack.pop();
    }

}
