/**
 * 在一个二维数组中，每一行都按照从左到右递增
 * 的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组
 * 和一个整数，判断数组中是否函数该整数。
 */

class No03 {

    fun main() {
        val arr =
            arrayOf(intArrayOf(1, 2, 8, 9),
                    intArrayOf(2, 4, 9, 12),
                    intArrayOf(4, 7, 10, 13),
                    intArrayOf(6, 8, 11, 15))

        println(search(arr, 5))
    }

    fun search(arr: Array<IntArray>, value: Int) : Boolean {
        var i = 0
        var j = arr[0].size - 1
        while (i <= arr[0].size - 1 && j >= 0) {
            when{
                arr[i][j] == value -> return true
                arr[i][j] > value -> j--
                else -> i++
            }
        }
        return false
    }
}