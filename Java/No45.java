/**
 * 0~n-1这n个数字排列成一个圆圈，
 * 从数字0开始每次从这个圆圈中删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字
 */

public class No45 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(6, 3));
    }

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
