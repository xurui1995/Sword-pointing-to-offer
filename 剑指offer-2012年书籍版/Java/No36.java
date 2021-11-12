/**
 * 在数组中的两个数字如果前面一个数字大于后面的数字， 则这两个数字组成一个逆序对。 输入一个数组，求出这个数组中的逆序对的总数
 */

public class No36 {

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        System.out.println(getInversePairs(arr));

    }

    private static int getInversePairs(int[] arr) {
        if (arr == null)
            return 0;
        int[] clone = arr.clone();
        return mergeSort(arr, clone, 0, arr.length - 1);
    }

    private static int mergeSort(int[] array, int[] result, int start, int end) {
        if (start == end) {
            result[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = mergeSort(result, array, start, start + length);
        int right = mergeSort(result, array, start + length + 1, end);
        int leftIndex = start + length;
        int rightIndex = end;
        int count = 0;
        int point = rightIndex;
        while (leftIndex >= start && rightIndex >= start + length + 1) {
            if (array[leftIndex] > array[rightIndex]) {
                result[point--] = array[leftIndex--];
                count += rightIndex - start - length;

            } else {
                result[point--] = array[rightIndex--];
            }
        }
        for (int i = leftIndex; i >= start; i--)
            result[point--] = array[i];
        for (int j = rightIndex; j >= start + length + 1; j--)
            result[point--] = array[j];
        return left + right + count;

    }

}
