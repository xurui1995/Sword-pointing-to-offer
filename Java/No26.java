/**
 * 请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，
 * 复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个m_pNext指针指向下一个结点外，
 * 还有一个m_pSibling指向链表中的任意结点或者NULL
 */

public class No26 {

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        ComplexListNode result = clone(node1);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    private static ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        copySibingNodes(head);
        return separateNodes(head);
    }

    private static ComplexListNode separateNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;
        if (node != null) {
            cloneNode = node.next;
            cloneHead = cloneNode;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

    private static void copySibingNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloneNode = node.next;

            if (node.sibling != null) {
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }

    }

    private static void cloneNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloneNode = new ComplexListNode(node.data);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

}

class ComplexListNode {
    int data;
    ComplexListNode next;
    ComplexListNode sibling;

    public ComplexListNode(int data) {
        super();
        this.data = data;
    }
}
