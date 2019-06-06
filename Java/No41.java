/**
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，输出任意一对即可
 */

public class No41 {

    public static void main(String[] args) {
        int[] data = {1, 2, 4, 7, 11, 15};
        System.out.println(findNumberWithSum(data, 15));
    }

    private static boolean findNumberWithSum(int[] data, int sum) {
        boolean found = false;
        if (data == null)
            return found;
        int num1 = 0;
        int num2 = 0;
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            int curSum = data[start] + data[end];
            if (curSum == sum) {
                num1 = data[start];
                num2 = data[end];
                found = true;
                break;
            } else if (curSum > sum)
                end--;
            else
                start++;
        }
        System.out.println(num1);
        System.out.println(num2);

        return found;
    }

}
