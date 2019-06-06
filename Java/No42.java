/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am student."，则输出"student. a am I"
 */

public class No42 {


    public static void main(String[] args) {
        String string = "I am a student.";

        reverseSentence(string);
    }

    private static void reverseSentence(String str) {
        if (str == null)
            return;
        char[] arr = str.toCharArray();

        reverse(arr, 0, arr.length - 1);
        int start = 0;
        int end = 0;
        for (char i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr, start, end);
                end++;
                start = end;
            } else if (i == arr.length) {
                end++;
                reverse(arr, start, end);
            } else {
                end++;
            }
        }

        for (char c : arr) {
            System.out.print(c);
        }
    }

    private static void reverse(char[] arr, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
