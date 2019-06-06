/**
 * 实现函数double Power(double base,int exponent)，
 * 求base的exponent次方。不得使用库函数，
 * 同时不需要考虑大数问题。
 */

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
