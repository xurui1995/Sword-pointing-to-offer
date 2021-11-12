/**
 * 写一个函数，求两个整数之和，
 * 要求函数体内部不能使用+、-、*、\四则与水暖符号
 */

public class No47 {

    public static void main(String[] args) {
        System.out.println(add(5, 8));
    }

    private static int add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

}
