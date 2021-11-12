/**
 * 请实现一个函数，输入一个整数，
 * 输出该二进制表示中1的个数。
 * 例如把9表示成二进制是1001， 有2位是1。
 * 因此如果输入9，该函数输出2。
 */

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
