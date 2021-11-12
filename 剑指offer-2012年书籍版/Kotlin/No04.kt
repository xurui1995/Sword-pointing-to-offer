/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入"We are happy"，则输出"We%20are%20happy"
 */

class No04 {

    fun main() {
        val str = "We are happy"
        val charArray = str.toCharArray()
        println(change(charArray))
    }

    fun change(charArray: CharArray): String {
        val count = charArray.count { it == ' ' }
        val resultArray = CharArray(charArray.size + count * 2)
        var newIndex = resultArray.size - 1
        var originIndex = charArray.size - 1

        while (newIndex >= 0) {
            if (charArray[originIndex] != ' ') {
                resultArray[newIndex] = charArray[originIndex]
                newIndex--
            } else {
                resultArray[newIndex] = '0'
                resultArray[newIndex - 1] = '2'
                resultArray[newIndex - 2] = '%'
                newIndex -= 3
            }
            originIndex--
        }
        return resultArray.joinToString(separator = "")
    }
}