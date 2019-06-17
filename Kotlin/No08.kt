/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组
 * 的一个旋转，输出旋转数组的最小元素。例如数组
 * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */

class No08 {

    fun main() {
        println(finMin(intArrayOf(3, 4, 5, 1, 2)))
        println(finMin(intArrayOf(1, 0, 1, 1, 1)))
    }

    private fun finMin(array: IntArray): Int {
        var leftIndex = 0
        var rightIndex = array.size - 1
        loop@ while (leftIndex < rightIndex) {
            val mid = (leftIndex + rightIndex) / 2
            when {
                array[mid] == array[leftIndex] && array[mid] == array[rightIndex] -> {
                    array.sort(leftIndex, rightIndex + 1)
                    return array[leftIndex]
                }
                (rightIndex - leftIndex) == 1 -> break@loop
                array[mid] >= array[leftIndex] -> leftIndex = mid
                else -> rightIndex = mid
            }
        }
        return array[rightIndex]
    }
}