/**
 * 1,写一个函数，输入n，求斐波那契数列的第n项
 * 2,一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级台阶总共有多少种跳法
 */

class No09 {

    fun main() {
        for (i in 0..10) {
            print(fibonacci(i).toString() + ",")
        }
    }

    private fun fibonacci(i: Int): Long {
        if (i <= 1) {
            return i.toLong()
        }

        var fib1 = 0L
        var fib2 = 1L
        var fibN = 0L

        for (j in 2..i) {
            fibN = fib1 + fib2
            fib1 = fib2
            fib2 = fibN
        }
        return fibN
    }

    private fun getMethodNumber(n: Int): Int = if (n <= 2) n else getMethodNumber(n - 1) + getMethodNumber(n - 2)
}