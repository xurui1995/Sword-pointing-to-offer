/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。输入一个递增排序的数组
 * 的一个旋转，输出旋转数组的最小元素。例如数组
 * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */

public class No08 {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[right] > arr[left]) {
            try {
                throw new Exception("非旋转数组");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        while (left < right) {
            int mid = (left + right) / 2;
            //对于{1,0,1,1,1}之类的特殊处理
            if (arr[mid] == arr[left] && arr[left] == arr[right]) {
                return seachMin(arr, left, right);
            }
            if (right - left == 1)
                break;
            if (arr[mid] >= arr[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return arr[right];
    }

    private static int seachMin(int[] arr, int left, int right) {
        int result = arr[left];
        for (int i = left + 1; i <= right; ++i) {
            if (arr[i] < result)
                result = arr[i];
        }
        return result;
    }


}
