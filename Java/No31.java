/**
 * 输入一个整型数组，数组里有正数，也有负数。
 * 数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n）
 */

public class No31 {

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSub(arr));
    }

    private static int maxSub(int[] arr) {
        int max = 0;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > max)
                max = sum;
            else if (sum < 0)
                sum = 0;
        }
        return max;

    }

}
