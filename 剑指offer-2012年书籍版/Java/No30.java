/**
 * 题目：输入n个整数，输出其中最小的k个。
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 */
package sort;

public class No30 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 7, 8, 9, 10, 14, 16};
        System.out.println(minK(arr, 1));
        System.out.println(minK(arr, 2));
        System.out.println(minK(arr, 3));
        System.out.println(minK(arr, 4));
        System.out.println(minK(arr, 5));
        System.out.println(minK(arr, 6));
    }

    public static int minK(int[] arr, int k) {
        return minK(arr, k, 0, arr.length - 1);
    }

    public static int minK(int[] arr, int k, int start, int end) {
        int mid = partition(arr, start, end);
        if (mid - start == k - 1) {
            return arr[mid];
        } else if (mid - start > k - 1) {
            return minK(arr, k, start, mid - 1);
        } else {
            return minK(arr, k - 1 - (mid - start), mid + 1, end);
        }
    }


    public static int partition(int[] arr, int start, int end) {
        int key = arr[start];
        int keyIndex = start;
        start++;
        for (int i = start; i <= end; i++) {
            if (arr[i] < key) {
                swap(arr, i, start);
                start++;
            }
        }
        swap(arr, keyIndex, start - 1);
        return start - 1;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
