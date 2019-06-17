import org.junit.Test

/**
 * 实现函数double Power(double base,int exponent)，
 * 求base的exponent次方。不得使用库函数，
 * 同时不需要考虑大数问题。
 */

class No11 {

    fun main() {
        println(Power(3.0, 3))
    }

    fun Power(base: Double, exponent: Int): Double {
        if (exponent < 0) {
            return 0.0
        }
        if (exponent == 0) {
            return if (base == 0.0) {
                0.0
            } else {
                1.0
            }
        }

        if (exponent == 1) {
            return base
        }

        var result = Power(base, exponent shr 1)
        result *= result
        if (exponent and 1 == 1) {
            result *= base
        }

        return result
    }
}