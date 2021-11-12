import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某栈
 * 的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列
 * 但4、3、5、1、2就不可能是该压栈序列的弹出序列
 */

public class No22 {

    public static void main(String[] args) {
        Integer[] pushOrder = {1, 2, 3, 4, 5};
        Integer[] popOrder = {4, 5, 3, 1, 2};
        System.out.println(isRight(pushOrder, popOrder, 5));
    }

    private static boolean isRight(Integer[] pushOrder, Integer[] popOrder, int n) {

        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (int i = 0; i < popOrder.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popOrder[i])
                stack.pop();
            else {
                if (count == pushOrder.length)
                    return false;
                else {
                    do {
                        stack.push(pushOrder[count++]);
                    }
                    while (stack.peek() != popOrder[i] && count != pushOrder.length);
                    if (stack.peek() == popOrder[i])
                        stack.pop();
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
