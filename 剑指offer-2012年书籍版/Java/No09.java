/**
 * 1,写一个函数，输入n，求斐波那契数列的第n项
 * 2,一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级台阶总共有多少种跳法
 */

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
