/**
 * 求链表的中间结点。如果链表中结点总数为奇数，
 * 返回中间结点；如果结点总数为偶数，返回中间两个结点的任意一个
 */

public class No15_2 {
    public static void main(String[] args) {
        Node15 a = new Node15("1");
        Node15 b = new Node15("2");
        Node15 c = new Node15("3");
        Node15 d = new Node15("4");
        Node15 e = new Node15("5");
        Node15 f = new Node15("6");
        Node15 g = new Node15("7");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        Node15 mid = getMid(a);
        System.out.println(mid.getData());
    }

    private static Node15 getMid(Node15 a) {

        if (a == null) {
            return null;
        }
        Node15 slow = a;
        Node15 fast = a;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

}
