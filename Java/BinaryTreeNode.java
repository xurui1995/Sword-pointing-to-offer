public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode LchildNode;
    private BinaryTreeNode RchildNode;

    public BinaryTreeNode(int data) {
        super();
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLchildNode() {
        return LchildNode;
    }

    public void setLchildNode(BinaryTreeNode lchildNode) {
        LchildNode = lchildNode;
    }

    public BinaryTreeNode getRchildNode() {
        return RchildNode;
    }

    public void setRchildNode(BinaryTreeNode rchildNode) {
        RchildNode = rchildNode;
    }


}
