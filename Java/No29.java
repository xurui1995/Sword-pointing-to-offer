/**
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */

public class No29 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findNum(arr));
    }

    private static Integer findNum(int[] arr) {
        if (arr == null)
            return null;

        int result = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                result = arr[i];
                count = 1;
            } else if (arr[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
