/**
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同
 */

public class No24 {

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9, 11, 10, 8};
        // int[] array={7,4,6,5};

        boolean b = verfiySequenceOfBST(array, 0, 6);
        System.out.println(b);
    }

    private static boolean verfiySequenceOfBST(int[] array, int start, int end) {

        if (array == null || start > end || start < 0 || end < 0)
            return false;

        if (start == end)
            return true;

        int root = array[end];

        int i = start;
        for (; i <= end; i++) {
            if (array[i] > root)
                break;
        }

        int j = i;
        for (; j <= end; j++) {
            if (array[j] < root)
                return false;
        }

        boolean left = true;
        if (i > start) {
            left = verfiySequenceOfBST(array, start, i - 1);
        }

        boolean right = true;
        if (i < end) {

            right = verfiySequenceOfBST(array, i, end - 1);
        }
        return (left && right);
    }

}
