/**
 * 请实现一个函数，输入一个整数，
 * 输出该二进制表示中1的个数。
 * 例如把9表示成二进制是1001， 有2位是1。
 * 因此如果输入9，该函数输出2。
 */
class No10 {
    fun main() {
        println(getNum(9))
    }

    fun getNum(n: Int): Int {
        var temp = n
        var num = 0
        while (temp != 0) {
            num++
            temp = temp and (temp - 1)
        }
        return num
    }
}