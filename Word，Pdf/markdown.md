### 剑指offer JAVA解
####  公共类
BinaryTreeNode
```
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
```
Node
```
class Node {
    String data;
    Node next;

    public Node(String data) {
        super();
        this.data = data;
    }

    public Node(String data, Node next) {
        super();
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
```

####  题解
> 2.设计一个类，我们只能生成该类的一个实例。
```
// 饿汉式  线程安全
class A {
    private static final A instance = new A();

    private A() {
    }

    public static A getInstance() {
        return instance;
    }
}

// 懒汉式 线程安全写法
class B {
    private static volatile B instance = null;

    private B() {
    }

    public static B getInstance() {
        if (instance == null) {
            synchronized (B.class) {
                if (instance == null)
                    instance = new B();
            }
        }
        return instance;
    }
}

// 静态内部类方式 线程安全
class C {
    private C() {

    }
    public static C getInstance() {
        return CHolder.INSTANCE;
    }

    private static class CHolder {
        private static final C INSTANCE = new C();
    }
}
```

> 3.在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否函数该整数。

```
public class No03 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println(search(arr, 7));
    }

    private static boolean search(int[][] arr, int value) {

        int a = arr[0].length;
        int b = arr.length;
        int i = 0;
        int j = a - 1;

        while (i <= b - 1 && j >= 0) {
            if (arr[i][j] == value) {
                return true;
            }
            if (arr[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
```
> 4.请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入"We are happy"，则输出"We%20are%20happy"
```
public class No04 {

    public static void main(String[] args) {
        String str = "We are happy";
        char[] charArray = str.toCharArray();
        System.out.println(change(charArray));
    }

    private static String change(char[] charArray) {

        int n = charArray.length;
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        char[] temp = new char[n + 2 * count];
        int j = n + 2 * count - 1;
        int i = n - 1;
        while (i >= 0) {
            if (charArray[i] == ' ') {
                temp[j] = '0';
                temp[j - 1] = '2';
                temp[j - 2] = '%';
                j = j - 3;
            } else {
                temp[j] = charArray[i];
                j--;
            }
            i--;
        }
        return new String(temp);
    }
}
```
> 5.输入一个链表的头节点，从尾到头打印每个节点的值
```
public class No05 {

    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        Node newNode = reverse2(node1);
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.getNext();
        }

    }

    private static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node reverseHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reverseHead;
    }

    private static Node reverse2(Node head) {
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }
}
```
> 6.根据前序遍历和中序遍历建立树 
```
public class No06 {
    public static void main(String[] args) {
        String preOrder = "12473568";
        String midOrder = "47215386";
        BiTree tree = new BiTree(preOrder, midOrder, preOrder.length());
        tree.postRootTraverse(tree.root);
    }
}

class BiTree {
    TreeNode root;

    public BiTree(String preOrder, String midOrder, int count) {
        if (count <= 0) {
            return;
        }
        char c = preOrder.charAt(0);
        int i = 0;
        for (; i < count; i++) {
            if (midOrder.charAt(i) == c)
                break;
        }

        root = new TreeNode(c);
        root.setLchild(new BiTree(preOrder.substring(1, i + 1), midOrder.substring(0, i), i).root);
        root.setRchild(new BiTree(preOrder.substring(i + 1), midOrder.substring(i + 1), count - i - 1).root);
    }


    public void postRootTraverse(TreeNode root) {
        if (root != null) {
            postRootTraverse(root.getLchild());
            postRootTraverse(root.getRchild());
            System.out.print(root.getData());
        }
    }
}
```
> 7.两个栈建立队列
```
import java.util.Stack;

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
```
> 8.把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
```

public class No08 {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[right] > arr[left]) {
            try {
                throw new Exception("非旋转数组");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        while (left < right) {
            int mid = (left + right) / 2;
            //对于{1,0,1,1,1}之类的特殊处理
            if (arr[mid] == arr[left] && arr[left] == arr[right]) {
                return seachMin(arr, left, right);
            }
            if (right - left == 1)
                break;
            if (arr[mid] >= arr[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arr[right];
    }

    private static int seachMin(int[] arr, int left, int right) {
        int result = arr[left];
        for (int i = left + 1; i <= right; ++i) {
            if (arr[i] < result)
                result = arr[i];
        }
        return result;
    }
    
}
```
> 9.写一个函数，输入n，求斐波那契数列的第n项 (一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级台阶总共有多少种跳法)
```
public class No09 {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(getMethodNumber(10));
    }

    private static long fibonacci(int n) {
        long[] a = {0, 1};
        if (n < 2)
            return a[n];
        long fib1 = 0;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;

    }


    private static int getMethodNumber(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return getMethodNumber(n - 1) + getMethodNumber(n - 2);
    }
}
```
> 10.请实现一个函数，输入一个整数，输出该二进制表示中1的个数。例如把9表示成二进制是1001，有2位是1。
```
public class No10 {

    public static void main(String[] args) {
        System.out.println(getNum(9));
    }

    public static int getNum(int n) {
        int num = 0;
        while (n != 0) {
            num++;
            n = (n - 1) & n;
        }
        return num;
    }
}
```
> 11.实现函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
```
public class No11 {

    public static void main(String[] args) {
        System.out.println(Power(2.0, 3));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
}
```
> 12 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
```
public class No12 {

    public static void main(String[] args) {
        printNum(3);
    }

    private static void printNum(int n) {
        if (n < 0)
            return;
        int[] array = new int[n];
        printArray(array, 0);
    }

    private static void printArray(int[] array, int n) {

        if (n != array.length) {
            for (int i = 0; i < 10; i++) {
                array[n] = i;
                printArray(array, n + 1);
            }
        } else {
            boolean flag = false;
            for (int j = 0; j < array.length; j++) {
                if (array[j] != 0) {
                    flag = true;
                }
                if (flag) {
                    System.out.print(array[j]);
                }
            }
            // 去掉空白行
            if (flag) {
                System.out.println();
            }
        }
    }
}
``` 
> 13.给定单向链表的头指针和一个结点指针， 定义一个函数在O（1）时间删除该节点
```
public class No13 {

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        delete(a, d);
        Node temp = a;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    private static void delete(Node head, Node c) {
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
```
> 14.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
```
public class No14 {

    public static void main(String[] args) {
        int[] array = {3, 7, 4, 8, 23, 56, 77, 89, 46, 11, 66, 77};
        mysort(array);
        for (int a : array) {
            System.out.println(" " + a);
        }
    }

    private static void mysort(int[] array) {
        if (array == null) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !isEven(array[left])) {
                left++;
            }
            while (left < right && isEven(array[right])) {
                right--;
            }
            if (left < right) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
            if (left >= right) {
                break;
            }
        }
    }

    private static boolean isEven(int i) {
        return (i & 0x1) == 0;
    }

}
```
> 15.输入一个链表，输出该链表中倒数第K个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。这个链表的倒数第3个结点是值为4的结点。（注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
```
public class No15 {

    public static void main(String[] args) {
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        Node d = new Node("4");
        Node e = new Node("5");
        Node f = new Node("6");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);

        System.out.print(FindDataFromTail(a, 5));
    }

    private static String FindDataFromTail(Node a, int k) {

        if (a == null)
            return null;
        if (k == 0) {
            System.out.println("k应该从1开始");
            return null;
        }
        Node node1 = a;
        Node node2 = null;
        for (int i = 0; i < k - 1; i++) {
            if (node1.getNext() == null) {
                System.out.println("k不应该大于链表长度");
                return null;
            }
            node1 = node1.getNext();
        }
        node2 = a;

        while (node1.getNext() != null) {
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
        return node2.getData();

    }
}
```
> 15_2.求链表的中间结点。如果链表中结点总数为奇数，返回中间结点；如果结点总数为偶数，返回中间两个结点的任意一个
```
public class No15_2 {
    public static void main(String[] args) {
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        Node d = new Node("4");
        Node e = new Node("5");
        Node f = new Node("6");
        Node g = new Node("7");

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        Node mid = getMid(a);
        System.out.println(mid.getData());
    }

    private static Node getMid(Node a) {

        if (a == null) {
            return null;
        }
        Node slow = a;
        Node fast = a;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

}
``` 
> 16.同第5题

> 17.输入两个递增排序的链表，合并这两个链表并使新链表中结点仍然是按照递增排序的。例如输入1->3->5->7和2->4->6->8，则合并之后的升序链表应该是1->2->3->4->5->6->7->8 。
```

public class No17 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        Node node5 = new Node(2);
        Node node6 = new Node(4);
        Node node7 = new Node(6);

        node5.setNext(node6);
        node6.setNext(node7);
        Node head = merge(node1, node5);
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }

    }

    private static Node merge(Node a, Node b) {
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node head = a.getData() > b.getData() ? b : a;
        Node index1 = head.getNext();
        Node index2 = head == a ? b : a;

        while (index1 != null && index2 != null) {
            if (index1.getData() < index2.getData()) {
                head.setNext(index1);
                index1 = index1.getNext();
            } else {
                head.setNext(index2);
                index2 = index2.getNext();
            }
            head = head.getNext();
        }

        if (index1 == null) {
            while (index2 != null) {
                head.setNext(index2);
                index2 = index2.getNext();
                head = head.getNext();
            }
        } else {
            while (index1 != null) {
                head.setNext(index1);
                index1 = index1.getNext();
                head = head.getNext();
            }
        }
        return a.getData() > b.getData() ? b : a;
    }
}
```
> 18.输入两颗二叉树A和B，判断B是不是A的子结构
```
public class No18 {

    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node1.setLchildNode(node2);
        node1.setRchildNode(node3);
        node2.setLchildNode(node4);
        node2.setRchildNode(node5);
        node5.setLchildNode(node6);
        node5.setRchildNode(node7);

        BinaryTreeNode a = new BinaryTreeNode(8);
        BinaryTreeNode b = new BinaryTreeNode(9);
        BinaryTreeNode c = new BinaryTreeNode(2);
        a.setLchildNode(b);
        a.setRchildNode(c);
        System.out.println(hasSubTree(node1, a));
    }

    private static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.getData() == root2.getData()) {
                result = doseTree1HaveTree2(root1, root2);
                if (!result) {
                    result = hasSubTree(root1.getLchildNode(), root2);
                }
                if (!result)
                    result = hasSubTree(root1.getRchildNode(), root2);
            }
        }
        return result;

    }

    private static boolean doseTree1HaveTree2(BinaryTreeNode root1,
                                              BinaryTreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.getData() != root2.getData()) {
            return false;
        }

        return doseTree1HaveTree2(root1.getLchildNode(), root2.getLchildNode())
                && doseTree1HaveTree2(root1.getRchildNode(), root2.getRchildNode());
    }

}
```
> 19.请完成一个函数，输入一个二叉树，该函数输出它的镜像
```
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
```
> 20. 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
```
public class No20 {


    public static void main(String[] args) {
        int[][] a = create(5, 5);
        print(a);
        clockWisePrint(a, 0, 4);
    }

    private static void clockWisePrint(int[][] a, int i, int j) {
        if (j < i)
            return;
        if (j == i) {
            System.out.print(a[i][j] + " ");
            return;
        }
        int y = i;
        while (y <= j) {
            System.out.print(a[i][y] + " ");
            y++;
        }
        y = i + 1;
        while (y <= j) {
            System.out.print(a[y][j] + " ");
            y++;
        }
        y = j - 1;
        while (y >= i) {
            System.out.print(a[j][y] + " ");
            y--;
        }

        y = j - 1;
        while (y >= i + 1) {
            System.out.print(a[y][i] + " ");
            y--;
        }


        clockWisePrint(a, i + 1, j - 1);

    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] create(int row, int line) {
        int[][] a = new int[row][line];
        int num = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                a[i][j] = num++;
            }
        }
        return a;
    }

}
```

> 21.定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push以及pop的时间复杂度都是O(1)。
```
import java.util.Stack;

public class No21 {

    public static void main(String[] args) {
        MyStack a = new MyStack();
        System.out.println(a.min());
        a.push(10);
        a.push(11);
        System.out.println(a.min());
    }

}

class MyStack {
    private Stack<Integer> stack1, stackHelp;

    public MyStack() {
        stack1 = new Stack<Integer>();
        stackHelp = new Stack<Integer>();
    }

    public void push(int num) {
        stack1.push(num);
        if (stackHelp.size() == 0 || num < stackHelp.peek()) {
            stackHelp.push(num);
        } else {
            stackHelp.push(stackHelp.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stackHelp.pop();

    }

    public Integer min() {
        if (stackHelp.size() == 0) {
            return null;
        }
        return stackHelp.peek();
    }

}
```



