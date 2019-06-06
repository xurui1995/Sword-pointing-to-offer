/**
 * 输入一颗二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */

public class No39 {

    public static void main(String[] args) {

    }

    public int treeDepth(BinaryTreeNode root) {

        if (root == null) return 0;

        int left = treeDepth(root.getLchildNode());

        int right = treeDepth(root.getRchildNode());

        return (left > right) ? left + 1 : right + 1;

    }

}
