/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

public class No14 {

    public static void main(String[] args) {
        int[] array = {3, 7, 4, 8, 23, 56, 77, 89, 46, 11, 66, 77};
        mysort(array);
        for (int a : array) {
            System.out.println(" " + a);
        }
    }

    private static void mysort(int[] array) {
        if (array == null) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !isEven(array[left])) {
                left++;
            }
            while (left < right && isEven(array[right])) {
                right--;
            }
            if (left < right) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
            if (left >= right) {
                break;
            }
        }
    }

    private static boolean isEven(int i) {
        return (i & 0x1) == 0;
    }

}
