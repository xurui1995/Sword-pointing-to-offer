/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数即999
 */

class No12 {

    fun main() {
        printNum(4)
    }

    fun printNum(n: Int) {
        if (n <= 0) {
            return
        }
        printArray(Array<Int>(n) { 0 }, 0)
    }

    fun printArray(array: Array<Int>, index: Int) {
        when (index) {
            array.size -> {
                val numStr = array.joinToString(separator = "") { it.toString() }
                val nonZeroIndex = numStr.indexOfFirst { it != '0' }
                if (nonZeroIndex == -1) {
                    println('0')
                } else {
                    println(numStr.substring(nonZeroIndex))
                }
            }
            else -> {
                for (i in 0..9) {
                    array[index] = i
                    printArray(array, index + 1)
                }
            }
        }
    }
}