/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

class No14 {
    fun main() {
        val array = intArrayOf(3, 7, 4, 8, 23, 56, 77, 89, 46, 11, 66, 77)
        mySort(array)
        println(array.joinToString { it.toString() })
    }

    private fun mySort(array: IntArray) {
        var left = 0
        var right = array.size - 1
        while (left < right) {
            while (left <= array.size - 1 && array[left] and 0x1 == 1) {
                left++
            }

            while (right >= 0 && array[right] and 0x1 == 0) {
                right--
            }

            if (left < right) {
                var temp = array[left]
                array[left] = array[right]
                array[right] = temp
            }
        }
    }
}