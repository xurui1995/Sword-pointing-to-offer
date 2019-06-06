import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2~10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字
 */

public class No44 {

    public static void main(String[] args) {
        int[] array = {0, 4, 6, 8, 0};
        System.out.println(isContinuous(array));

    }

    private static boolean isContinuous(int[] arr) {

        if (arr == null || arr.length != 5)
            return false;
        Arrays.sort(arr);
        int numberZero = 0;
        int numberGap = 0;
        for (int i = 0; i < arr.length && arr[i] == 0; i++)
            numberZero++;

        int small = numberZero;
        int big = small + 1;
        while (big < arr.length) {
            if (arr[small] == arr[big])
                return false;

            numberGap += arr[big] - arr[small] - 1;
            small = big;
            big++;
        }
        return numberGap <= numberZero;
    }

}
