/**
 * 给定单向链表的头指针和一个结点指针， 定义一个函数在O（1）时间删除该节点
 */

public class No13 {

    public static void main(String[] args) {
        MyNode a = new MyNode("A");
        MyNode b = new MyNode("B");
        MyNode c = new MyNode("C");
        MyNode d = new MyNode("D");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        delete(a, d);
        MyNode temp = a;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    private static void delete(MyNode head, MyNode c) {
        // 如果是尾节点,只能遍历删除
        if (c.next == null) {
            while (head.next != c) {
                head = head.next;
            }
            head.next = null;
        } else if (head == c) {
            head = null;
        } else {
            c.setData(c.getNext().getData());
            c.setNext(c.getNext().getNext());
        }

    }


}

class MyNode {
    MyNode next;
    String data;

    public MyNode(String data) {
        super();
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}