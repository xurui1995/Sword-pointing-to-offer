/**
 * 输入一个链表，输出该链表中倒数第K个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
 */

public class No15 {

    public static void main(String[] args) {
        Node15 a = new Node15("1");
        Node15 b = new Node15("2");
        Node15 c = new Node15("3");
        Node15 d = new Node15("4");
        Node15 e = new Node15("5");
        Node15 f = new Node15("6");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        System.out.print(FindDataFromTail(a, 5));
    }

    private static String FindDataFromTail(Node15 a, int k) {

        if (a == null)
            return null;
        if (k == 0) {
            System.out.println("k应该从1开始");
            return null;
        }
        Node15 Node1 = a;
        Node15 Node2 = null;
        for (int i = 0; i < k - 1; i++) {
            if (Node1.getNext() == null) {
                System.out.println("k不应该大于链表长度");
                return null;
            }
            Node1 = Node1.getNext();
        }
        Node2 = a;

        while (Node1.getNext() != null) {
            Node1 = Node1.getNext();
            Node2 = Node2.getNext();
        }
        return Node2.getData();

    }
}

class Node15 {
    private String data;
    private Node15 Next;

    public Node15(String data) {
        super();
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node15 getNext() {
        return Next;
    }

    public void setNext(Node15 next) {
        Next = next;
    }

}
