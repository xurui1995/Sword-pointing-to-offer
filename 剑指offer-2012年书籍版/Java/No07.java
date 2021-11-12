import java.util.Stack;

/**
 * 两个栈建立队列
 */

public class No07 {

    private Stack s1 = new Stack();
    private Stack s2 = new Stack();

    public void offer(Object x) {
        s1.push(x);

    }

    public void poll() {
        if (s1.size() == 0 && s2.size() == 0) {
            try {
                throw new Exception("empty queue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (s2.size() != 0) {
                System.out.println(s2.peek().toString());
                s2.pop();
            } else {
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                }
                System.out.println(s2.peek().toString());
                s2.pop();
            }
        }

    }

    public static void main(String[] args) {

        No07 queue = new No07();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
    }

}
